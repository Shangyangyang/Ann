package com.newheyd.base.base;

import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * 查询数据列表
	 * @param entity
	 * @return
	 */
	public List<T> list(T entity);

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id);

	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity);	
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除数据（逻辑删除，更新del_flag字段为1）
	 * @param entity
	 * @return
	 */
	public int delete(T entity);
	
}