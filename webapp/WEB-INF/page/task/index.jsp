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

				<li><a href="#" style="color: black;">任务管理</a></li>
				<li class="active">任务列表</li>

				<li style="float: right"><a href="#" class="active text-right"
					style="color: black;">退出&nbsp;&nbsp;</a></li>


			</ol>
		</div>
		<!--查询-->
		<div class="panel panel-primary">
			<div class="panel-heading ">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-zoom-in"></span>&nbsp;查询
				</h3>
			</div>

			<div class="panel-body">
				<div class="col-md-6">
					<div class="form-group">
						<div class="col-md-2 col-md-offset-1">

							<label class="control-label" for="proname">任务名称</label>
						</div>
						<div class="col-md-7">
							<input class="form-control " id="taskName" placeholder="任务名称"
								type="text">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="col-md-2 col-md-offset-1">

							<label class="control-label" for="protime">任务创建时间</label>
						</div>
						<div class="col-md-6">
							<input class="form-control " id="buildDate" placeholder="time"
								id="protime" type="date">
						</div>
					</div>
				</div>
				<div class="col-md-6"></div>
			</div>
			<div class="panel-footer text-right">
				<button type="reset" class="btn"
					style="background-color: #c79121; color: white">重置</button>
				<button type="reset" class="btn btn-warning" id="queryBtn">查询</button>
				<button class="btn btn-primary " id="addBtn"
					onclick="location.href='${base}/tasks/editpage'">添加任务</button>
			</div>

		</div>
		<!--任务列表-->
		<div class="panel panel-primary">
			<div class="panel-heading ">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-th-list"></span>&nbsp;任务列表
				</h3>
			</div>
			<form action="" role="form" class="form-inline">
				<div class="panel-body">
					<table class="table table-bordered text-center" id="commTable"
						data-sort-name="builddate" data-sort--order="desc">
						<thead>
							<tr>
								<th class="text-center" data-field="taskName">任务名称</th>

								<th class="text-center" data-field="status"
									data-formatter="operateStatusFormatter">任务状态</th>
								<th class="text-center" data-field="taskId"
									style="display: none" id="taskid">任务ID</th>
								<th class="text-center" data-field="buildDate">任务创建时间</th>
								<th class="text-center" data-width="20%"
									data-formatter="operateFormatter" data-events="operateEvents">操作</th>
							</tr>
						</thead>
						<tbody>

						</tbody>

					</table>




				</div>

			</form>
		</div>
	</div>
	<%@ include file="/WEB-INF/page/common/footer.jsp"%>
	<!-- 引入bootstrap datatable脚本 -->
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
	<script src="${resourcesUrl}/js/task/index.js"></script>

</body>
</html>