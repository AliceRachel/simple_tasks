package com.neusoft.neumooc.vo;

import java.util.Date;

import com.neusoft.core.common.BaseVO;
/**
 * task_task
 * 
 */
public class Task extends BaseVO {
	
	private String taskId;
	private String taskName;
	private String status;
	private String userId;
	private String buildDate;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", status=" + status + ", userId=" + userId
				+ ", builddate=" + buildDate + "]";
	}

	
}
