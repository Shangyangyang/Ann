package cn.ainannan.commons.mybatisPlus;

import cn.ainannan.sys.utils.StringUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.platform.commons.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class QueryGenerator {

    /**
     * 获取查询条件构造器QueryWrapper实例 通用查询条件已被封装完成
     *
     * @param searchObj    查询实体
     * @param parameterMap request.getParameterMap()
     * @return QueryWrapper实例
     */
    public static <T> QueryWrapper<T> initQueryWrapper(T searchObj, Map<String, String[]> parameterMap) {
        long start = System.currentTimeMillis();
        QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
        installMplus(queryWrapper, searchObj, parameterMap);
        log.debug("---查询条件构造器初始化完成,耗时:" + (System.currentTimeMillis() - start) + "毫秒----");
        return queryWrapper;
    }

    /**
     * 组装Mybatis Plus 查询条件
     * <p>使用此方法 需要有如下几点注意:
     * <br>1.使用QueryWrapper 而非LambdaQueryWrapper;
     * <br>2.实例化QueryWrapper时不可将实体传入参数
     * <br>错误示例:如QueryWrapper<JeecgDemo> queryWrapper = new QueryWrapper<JeecgDemo>(jeecgDemo);
     * <br>正确示例:QueryWrapper<JeecgDemo> queryWrapper = new QueryWrapper<JeecgDemo>();
     * <br>3.也可以不使用这个方法直接调用 {@link #initQueryWrapper}直接获取实例
     */
    public static void installMplus(QueryWrapper<?> queryWrapper, Object searchObj, Map<String, String[]> parameterMap) {
        //区间条件组装 模糊查询 高级查询组装 简单排序 权限查询
        PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(searchObj);
        String name, type, column;
        // update-begin--Author:taoyan  Date:20200923 for：issues/1671 如果字段加注解了@TableField(exist = false),不走DB查询-------
        //定义实体字段和数据库字段名称的映射 高级查询中 只能获取实体字段 如果设置TableField注解 那么查询条件会出问题
        Map<String,String> fieldColumnMap = new HashMap<String,String>();
        for (int i = 0; i < origDescriptors.length; i++) {
            //aliasName = origDescriptors[i].getName();  mybatis  不存在实体属性 不用处理别名的情况
            name = origDescriptors[i].getName();

            type = origDescriptors[i].getPropertyType().toString();
            try {
                if (judgedIsUselessField(name)|| !PropertyUtils.isReadable(searchObj, name)) {
                    continue;
                }


                Object value = PropertyUtils.getSimpleProperty(searchObj, name);


                // 如果值为空，则跳过
                if (value  == null || StringUtils.isBlank(value.toString())) {
                    continue;
                }

                

                column = getTableFieldName(searchObj.getClass(), name);
                if(column==null){
                    //column为null只有一种情况 那就是 添加了注解@TableField(exist = false) 后续都不用处理了
                    continue;
                }
                fieldColumnMap.put(name,column);

                name = StringUtil.humpToLine(name);
                queryWrapper.eq(name, value);

            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

    }

    /**
     * 获取表字段名
     * @param clazz
     * @param name
     * @return
     */
    private static String getTableFieldName(Class<?> clazz, String name) {
        try {
            //如果字段加注解了@TableField(exist = false),不走DB查询
            Field field = null;
            try {
                field = clazz.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                //e.printStackTrace();
            }

            //如果为空，则去父类查找字段
            if (field == null) {
                List<Field> allFields = getClassFields(clazz);
                List<Field> searchFields = allFields.stream().filter(a -> a.getName().equals(name)).collect(Collectors.toList());
                if(searchFields!=null && searchFields.size()>0){
                    field = searchFields.get(0);
                }
            }

            if (field != null) {
                TableField tableField = field.getAnnotation(TableField.class);
                if (tableField != null){
                    if(tableField.exist() == false){
                        //如果设置了TableField false 这个字段不需要处理
                        return null;
                    }else{
                        String column = tableField.value();
                        //如果设置了TableField value 这个字段是实体字段
                        if(!"".equals(column)){
                            return column;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }


    /**
     * 获取class的 包括父类的
     * @param clazz
     * @return
     */
    private static List<Field> getClassFields(Class<?> clazz) {
        List<Field> list = new ArrayList<Field>();
        Field[] fields;
        do{
            fields = clazz.getDeclaredFields();
            for(int i = 0;i<fields.length;i++){
                list.add(fields[i]);
            }
            clazz = clazz.getSuperclass();
        }while(clazz!= Object.class&&clazz!=null);
        return list;
    }


    /**
     *
     * @param name
     * @return
     */
    private static boolean judgedIsUselessField(String name) {
        return "class".equals(name) || "ids".equals(name)
                || "page".equals(name) || "rows".equals(name)
                || "sort".equals(name) || "order".equals(name);
    }
}
