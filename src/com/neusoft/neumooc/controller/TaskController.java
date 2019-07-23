package com.neusoft.neumooc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.sql.UpdateTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Param;
import com.neusoft.core.common.BaseController;
import com.neusoft.core.common.conf.Params;
import com.neusoft.core.common.pagination.Paginating;
import com.neusoft.core.util.IDUtil;
import com.neusoft.neumooc.service.TaskService;
import com.neusoft.neumooc.vo.Task;
import com.neusoft.neumooc.vo.User;

@Controller
@RequestMapping(value="/tasks")
public class TaskController extends BaseController {
	@Autowired
	private TaskService taskService;
	/**
	 * 访问任务管理页面
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(){
		return "task/index";
	}
	@RequestMapping(value = "/update")
	public String update() {
		return "task/update";
		
	}
	@RequestMapping(value ="/editpage")
	public String editpage() {
		return "task/editpage";
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public Map<String,Object> getTask(Task task,HttpServletRequest request){
		Map<String,Object> retMap = new HashMap<>();
		
		try{
		Paginating page = this.getPaginating(request);
		
		List<Task> list = taskService.getTasks(task, page);
		
		retMap.put("rows", list);
		retMap.put("total", taskService.getCount(task));
		retMap.put(Params.RET_CODE, Params.RET_CODE_SUCCESS);
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("TaskController->getTask错误"+e);
			retMap.put(Params.RET_CODE, Params.RET_CODE_ERROR);
			retMap.put(Params.RET_MSG, Params.OPERATE_ERROR);
		}
		return retMap;
		
	}
	
	@RequestMapping(value="/edit")
	@ResponseBody
	public String getTask(){
		return "task/index";
		
	}
	@RequestMapping(value = "/doAdd")
	@ResponseBody
	public Map<String,Object> addTask(Task task,HttpSession session) {
		Map<String,Object> retMap = new HashMap<>();
		try {
			System.out.println("1");
			task.setTaskId(IDUtil.getID());
			User u = (User) session.getAttribute("user");
			task.setUserId(u.getUserId());
			
		
			taskService.addTask(task);
			
			retMap.put(Params.RET_CODE, Params.RET_CODE_SUCCESS);
		}
		catch (Exception e) {
			log.error("TaskController->getTask错误"+e);
			retMap.put(Params.RET_CODE, Params.RET_CODE_ERROR);
			retMap.put(Params.RET_MSG, Params.OPERATE_ERROR);
		}
		System.out.println(task);
		return retMap;
		
	}
	@RequestMapping(value = "/doDelete")
	@ResponseBody
	public String doDelete(HttpServletRequest     request, @RequestParam String taskId) {
		Map<String,Object> retMap = new HashMap<>();
		try {	
//			Task task = new Task();
			taskService.doDelete(taskId);
			System.out.println(request.getParameter("taskName"));
			retMap.put(Params.RET_CODE, Params.RET_CODE_SUCCESS);

		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("TaskController->doDelete错误"+e);
			retMap.put(Params.RET_CODE, Params.RET_CODE_ERROR);
			retMap.put(Params.RET_MSG, Params.OPERATE_ERROR);
		}
		
		return "task/index";
		
		
	}
	@RequestMapping(value = "/doUpdate")
	@ResponseBody
	public Map<String,Object> doUpdate(HttpServletRequest request, Task task) {
		Map<String,Object> retMap = new HashMap<>();
	try {	
		if(task.getTaskId()!=null) {
			taskService.doUpdate(task);
			retMap.put(Params.RET_CODE, Params.RET_CODE_SUCCESS);
		}
	}
	catch (Exception e) {
		// TODO: handle exception
		log.error("TaskController->getTask错误"+e);
		retMap.put(Params.RET_CODE, Params.RET_CODE_ERROR);
		retMap.put(Params.RET_MSG, Params.OPERATE_ERROR);
	}
		return retMap;
		
	}
	
	
}
