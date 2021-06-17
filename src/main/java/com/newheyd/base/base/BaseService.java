package com.newheyd.base.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseService<D extends BaseDao<T>, T extends BaseBean> {
	
	//日志对象
	protected Logger logger = LoggerFactory.getLogger(getClass());	

	//持久层对象
	@Autowired
	protected D dao;	
	
	/**
	 * 查询数据列表
	 * @param entity
	 * @return
	 */
	public List<T> list(T entity){
		return dao.list(entity);
	}

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id){
		return dao.get(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity){
		return dao.get(entity);
	}
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly = false)
	public int insert(T entity) {
		entity.preInsert();
		return dao.insert(entity);		
	}
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly = false)
	public int update(T entity){
		entity.preUpdate();
		return dao.update(entity);			
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public int save(T entity) {
		if (entity.getIsNewRecord()){
			entity.preInsert();
			return dao.insert(entity);
		}else{
			entity.preUpdate();
			return dao.update(entity);
		}
	}
	
	/**
	 * 删除数据（逻辑删除，更新del_flag字段为1）
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly = false)
	public int delete(T entity){
		return dao.delete(entity);		
	}
}
