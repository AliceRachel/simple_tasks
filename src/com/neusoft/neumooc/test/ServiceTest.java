package com.neusoft.neumooc.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.neusoft.core.util.IDUtil;
import com.neusoft.neumooc.service.TaskService;
import com.neusoft.neumooc.vo.Task;

public class ServiceTest extends BaseTest{
	@Autowired
	private TaskService taskService;
	
	@Test
	public void testAddTask() {
		Task task = new Task();
		task.setTaskId(IDUtil.getID());
		task.setBuildDate("2009-09-08");
		task.setStatus(0+"");
		task.setTaskName("张三");
		task.setUserId("1");
		taskService.addTask(task);
	}
	
}
