package com.neusoft.neumooc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.core.common.BaseService;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.common.exception.ServiceException;
import com.neusoft.core.common.pagination.Paginating;
import com.neusoft.neumooc.dao.TaskDAO;
import com.neusoft.neumooc.vo.Task;

//实例化
@Service
@Transactional
public class TaskServiceImpl extends BaseService implements TaskService{

	@Autowired
	private TaskDAO taskDAO;
	@Override
	public List<Task> getTasks(Task task, Paginating page) throws ServiceException {
		try {
			return taskDAO.findAll(task, page);
		}catch(Exception e) {
			throw new ServiceException("TaskServiceImpl的方法getTasks错误",e);
		}
		
	}

	@Override
	public int getCount(Task task) throws ServiceException {
		try {
			return taskDAO.getCount(task);
		}catch(Exception e) {
			throw new ServiceException("TaskServiceImpl的方法getCounts错误",e);
		}
		
	}

	@Override
	public void addTask(Task task) throws ServiceException {
		
		try {
			taskDAO.addTask(task);
		} catch (Exception e) {
			throw new ServiceException("TaskServiceImpl的方法addTask错误",e);
		}
		
	}

	@Override
	public void doDelete(String taskId) throws ServiceException {
		taskDAO.doDelete(taskId);
	}

	@Override
	public Task findTaskByName(String taskName) throws ServiceException {
		return taskDAO.findTaskByName(taskName);
	}

	@Override
	public void doUpdate(Task task) throws ServiceException {
		try {
			taskDAO.doUpdate(task);
		} catch (Exception e) {
			throw new ServiceException("TaskServiceImpl的方法doUpdate错误",e);
		}
	}

}
