package cn.ainannan.base.service;

import cn.ainannan.base.bean.BaseBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


public class MyBaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    @Autowired
    protected M baseMapper;

    @Override
    public M getBaseMapper() {
        return baseMapper;
    }

    @Override
    public boolean save(T entity) {
        BaseBean bean = (BaseBean)entity;

        if(bean.ifNewRecord()){
            bean.preInsert();
            return super.save(entity);
        } else {
            bean.preUpdate();
            return super.updateById(entity);
        }
    }
}
