package com.neusoft.neumooc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.neusoft.core.common.BaseDAO;
import com.neusoft.core.common.exception.DAOException;
import com.neusoft.core.common.pagination.Paginating;
import com.neusoft.neumooc.vo.Task;
import com.neusoft.neumooc.vo.User;
/**
 * 接口实现
 * @author wangs
 *
 */
//@Repository
public class TaskDAOImpl extends BaseDAO implements TaskDAO{
	private static final String sql_task=
			"select taskid taskId,taskname taskName,status,"
					+"userid userId,builddate buildDate from"
					+ " task_tasks where 1=1 ";
	@Override
	public List<Task> findAll(Task task, Paginating page) throws DAOException {
		// TODO Auto-generated method stub
		//所有数据
		List<Task> list =null;
		
		try {
			//条件语句
			StringBuilder wSql = new StringBuilder();
			String sql_task_findAll;
			
			//参数传递
			Map<String,String> param = new HashMap<>();
			if (task.getTaskName()!=null&&!"".equals(task.getTaskName())) {
				param.put("taskName", task.getTaskName());
				wSql.append( " and taskname=:taskName");
				//				wSql += " and taskname=:taskName";
			}
			if (task.getBuildDate()!=null&&!"".equals(task.getBuildDate())) {
				param.put("buildDate", task.getBuildDate());
				wSql.append(" and builddate=:buildDate");
	//				wSql += " and taskname=:buidDate";
			}
//			分页+排序
			sql_task_findAll=sql_task+wSql.toString()+" order by "+page.getSort()+" "+page.getOrder();
			list =this.getPageData(sql_task_findAll, Task.class, page.getPageIndex(), page.getPageSize(), param);
		
		
		}catch(Exception e) {
			log.error("TaskDAOImpl的方法findAll错误:"+e.getMessage());
			throw new DAOException("TaskDAOImpl的方法findAll错误",e);
		}
		
		return list;
	}

	@Override
	public int getCount(Task task) throws DAOException {
		// TODO Auto-generated method stub
		int count =0;
		try {
			//条件语句
			StringBuilder wSql = new StringBuilder();
		String sql_task_findAll = null;
			//参数传递
			Map<String,String> param = new HashMap<>();
			if(task.getTaskName()!=null && !"".equals(task.getTaskName())) {
				wSql.append(" and taskname like :taskName");
				param.put("taskName","%"+ task.getTaskName()+"%");
			}
			if(task.getBuildDate()!=null && !"".equals(task.getBuildDate())) {
				wSql.append(" and builddate like :buildDate");
				param.put("buildDate","%"+ task.getBuildDate()+"%");
			}
			
			sql_task_findAll +=wSql.toString();
			log.debug("sql-task->"+sql_task);
			count=this.getCount(sql_task,param);
		}catch(Exception e) {
			log.error("TaskDAOImpl的方法findAll错误:"+e.getMessage());
			throw new DAOException("TaskDAOImpl的方法getCount错误",e);
		}
			
		
		return count;
	}
	
	@Override
	public void addTask(Task task) {
		// TODO 自动生成的方法存根
		String add_sql="insert into task_tasks(taskid,taskname,status,userid,builddate) values('45','"+task.getTaskName()+"','"+task.getStatus()+"','1',date_format(now(),'%Y-%m-%d'))";
		update(add_sql);
	}

	@Override
	public void doDelete(String taskName) {
		// TODO 自动生成的方法存根
		String delete_sql="delete from task_tasks where taskname='"+taskName+"'";
		update(delete_sql);
	}

	@Override
	public void doUpdate(Task task) {
		// TODO 自动生成的方法存根
//		String update_sql="update task_tasks  set taskname='"+taskName+"',status='"+status+"' where taskid='"+taskid+"'" ;
//		update(update_sql);		
	}

	@Override
	public Task findTaskByName(String taskName) {
		// TODO 自动生成的方法存根
		String findtask_sql="select * from task_tasks where taskid='"+taskName+"'";
		Object[] params=new Object[]{taskName};
		Task task=this.queryForBean(findtask_sql, Task.class);
		return task;
	}

	

}
