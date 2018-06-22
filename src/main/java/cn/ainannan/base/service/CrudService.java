package cn.ainannan.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ainannan.base.bean.BaseBean;
import cn.ainannan.base.dao.CrudDao;

/**
 * Service基类
 */
@Service
public abstract class CrudService<D extends CrudDao<T>, T extends BaseBean<T>> {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	public D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
		if (entity.isNewRecord()){
			entity.preInsert();
			dao.insert(entity);
		}else{
			entity.preUpdate();
			dao.update(entity);
		}
	}
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}

  /**
   * 根据条件删除数据
   * @param params 条件参数
   * @return
   */
  @Transactional(readOnly = false)
  public int deleteByEntity(T entity){
    return dao.deleteByEntity(entity);
  }
}
