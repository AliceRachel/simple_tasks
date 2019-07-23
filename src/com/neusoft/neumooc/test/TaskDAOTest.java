package com.neusoft.neumooc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.neusoft.core.common.pagination.Paginating;
import com.neusoft.neumooc.dao.TaskDAO;
import com.neusoft.neumooc.vo.Task;

public class TaskDAOTest extends BaseTest {
		@Autowired
		private TaskDAO taskDAO;
		
		@Test
		public void testFindAll(){
			Task task =new Task();
			task.setTaskName("放");
			Paginating page= new Paginating();
			page.setPageIndex(1);
			page.setPageSize(4);
			page.setOrder("desc");
			page.setSort("taskname");
			List<Task> list =taskDAO.findAll(task, page);
			System.out.println(list.size());
			for(Task t:list){
				System.out.println(t);
			}
		}
		@Test
		public void testGetCount(){
			Task task =new Task();
			//task.setTaskName("放");
			task.setBuildDate("2007-03-06");
			int count=taskDAO.getCount(task);
			System.out.println("返回数据总数为："+count);
			
		}
		@Test 
		public void testAddTask() {
			Task task =new Task();
			//insert into task_tasks(taskid,taskname,status,userid,builddate)
			task.setTaskId("13");
			task.setTaskName("国庆节");
			task.setStatus("1");
			task.setUserId("5");
			task.setBuildDate("2019-06-24");
		}
		
		@Test
		public void testDoUpdate() {
			Task task =new Task();
			
		}
}
