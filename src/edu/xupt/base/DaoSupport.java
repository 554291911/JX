package edu.xupt.base;

import java.util.List;

import edu.xupt.entites.PageBean;
import edu.xupt.util.QueryHelper;

public interface DaoSupport<T> {


	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */
	T getById(int id);
	

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();
	

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return
	 */
	List<T> getByIds(int[] ids);
	
	/**
	 * 公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 *            HQL语句与参数列表
	 * @return
	 */
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);

}
