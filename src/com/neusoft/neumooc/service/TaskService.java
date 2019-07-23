package com.neusoft.neumooc.service;

import java.util.List;

import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.core.common.pagination.Paginating;
import com.neusoft.neumooc.vo.Task;
//import com.sun.xml.internal.org.jvnet.fastinfoset.VocabularyApplicationData;

public interface TaskService {
	/**
	 * 获得分页数据
	 * @param task查询条件
	 * @param page分页条件
	 * @return
	 * @throws ServiceException
	 */
	public List<Task> getTasks(Task task,Paginating page) throws ServiceException;
	
	/**
	 * 获得分页总的数量
	 * @param task查询条件
	 * @return
	 * @throws ServiceException
	 */
	public int getCount(Task task) throws ServiceException;
	
	public void addTask(Task task) throws ServiceException;
	
	public void doDelete(String taskId) throws ServiceException;
	
	public Task findTaskByName(String taskName) throws ServiceException;
	
	public void doUpdate(Task task) throws ServiceException;
}
