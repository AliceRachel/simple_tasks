package com.neusoft.neumooc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.common.pagination.Paginating;
import com.neusoft.neumooc.vo.Task;
/**
 * 取出task_tasks表数据
 * 分页显示
 * 
 * */
public interface TaskDAO {
	public List<Task> findAll(@Param("t")Task task,@Param("p")Paginating page)throws DAOException;
/**
 * task_tasks
 */
public int getCount(@Param("t")Task task) throws DAOException;
	
	public void addTask(@Param("t")Task task);
	
	public void doDelete(@Param("taskId")String taskId);
	
	public void doUpdate(@Param("t")Task task);
	
	public Task findTaskByName(@Param("t")String taskName);
}
