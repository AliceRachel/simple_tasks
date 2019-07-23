<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/commonPage.jsp"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- Head -->
<head>
<meta charset="utf-8" />
<title></title>
<%@ include file="/WEB-INF/page/common/header.jsp"%>
<!--Page Related styles-->
</head>
<!-- /Head -->
<!-- Body -->
<body>
	<!--路径导航-->
	<div class="container-fluid">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href='${base}/home/index' style="color: black;">任务管理</a></li>
				<li class="active">编辑任务</li>

			</ol>
		</div>

		<!--任务列表-->
		<div class="panel panel-primary">
			<div class="panel-heading ">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;编辑
				</h3>
			</div>
			<form action="${base}/tasks/doAdd" role="form"
				class="form-horizontal" id="addForm">
				<div class="panel-body">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="col-md-2">

								<label class="control-label" for="proname">任务名称</label>
							</div>
							<div class="col-md-8">
							
								<input class="form-control " placeholder="任务名称" id="proname"
									name="taskName" id="taskName" type="text" value="${t.taskName}">
								
							</div>
						</div>


						<div class="form-group" class="radio">

							<div class="col-md-5 col-md-offset-2">
							
								<label class="radio-inline"> <input type="radio"
									name="status" checked value="1">
									<c:if test="$(t.status=='1')">checked</c:if>
									完成
								</label> <label class="radio-inline"> <input type="radio"
									name="status" value="0">
									<c:if test="$(t.status=='0')">checked</c:if>
									未完成
								</label>
							</div>
						</div>
						<!-- 隐藏域 -->
						<input type="hidden" id="taskId" name="taskId" value="${t.taskId }">
					</div>
					
				</div>
				<div id="tipInfo"></div>
				<div class="panel-footer text-right">
					<a class="btn btn-default " href='${base}/home/index'>返回</a>
					<button type="reset" class="btn"
						style="background-color: #c79121; color: white">重置</button>
					<button type="submit" class="btn btn-warning " id="sumbitAdd">提交</button>
				</div>
				<div class="col-md-3"></div>
			</form>
		</div>
	</div>
	<%@ include file="/WEB-INF/page/common/footer.jsp"%>
	<script type="text/javascript"
		src="${resourcesUrl}/common/components/bootstrapTable/tableExport.js"></script>
	<script type="text/javascript"
		src="${resourcesUrl}/common/components/bootstrapTable/jquery.base64.js"></script>
	<script
		src="${resourcesUrl}/common/components/bootstrapTable/bootstrap-table-all.min.js"></script>
	<script type="text/javascript"
		src="${resourcesUrl}/common/components/bootstrapTable/colResizable-1.5.min.js"></script>
	<script
		src="${resourcesUrl}/common/components/bootstrapTable/bootstrap-table-zh-CN.min.js"></script>
	<script
		src="${resourcesUrl}/common/components/bootstrapTable/lodash.min.js"></script>
	<!-- 用户自定义js -->
	<script src="${resourcesUrl}/js/task/taskEdit.js"></script>
</body>
</html>