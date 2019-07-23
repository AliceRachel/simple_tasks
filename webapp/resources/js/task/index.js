
$(document).ready(function(){
	var table = $('#commTable').bootstrapTable({
		method:"get",
		cache:false,
		url:getContextPath()+"/tasks/list",
		pagination:true,
		showPaginationSwitch:false,
		pageSize:10,
		pageList:[5,10,15],
		search:false,
		showExport:false,
		sidePagination:"server",
		queryParams:function(params){//多条件查询调用
			params.taskName=$("#taskName").val();
			params.buildDate=$("#buildDate").val();
			return params;
		},
		responseHandler:responseHandler,
		onPostBody:function(){
			$("#commTable").bootstrapTable("resetView");
			//重新生成按钮弹出框
			$('.btn').popover({
				trigger:"hover"
			});
			
		}
	});
	
	$(window).resize(function(){
		$("#commTable").bootstrapTable("resetView");
	});
	
	$("#queryBtn").click(function(){
		$("#commTable").bootstrapTable("selectPage",1);
	})
	
	
	$("#togglePagBtn").click(function(){
		$("#commTable").bootstrapTable("togglePagination");
	});
	
	window.operateEvents={
			'click .update':function(e,value,row,index){
				
			},
			'click .delete':function(e,value,row,index){
				
			}
	}
	
	
	function responseHandler(res){
		if("error"==res.RET_CODE){
			showAlert(res.RET_MSG)
		}
		console.log(res);
		return res;
	}
});

function operateStatusFormatter(value,row,index){
	var status = row.status;
	var content = "";
	if(status==0){
		content="未完成";
	}
	else{
		content="已完成";
	}
	console.log(row);
	return content;
}
function update(obj){
	$c = $(obj).parent().parent().find("td:eq(0)").text()
	$d = $(obj).parent().parent().find("td:eq(1)").text()
	$e = $(obj).parent().parent().find("td:eq(2)").text()
	window.location.href=getContextPath()+"/tasks/update?taskname="+$c+"&status="+$d+"&taskid="+$e;
}
function cli(obj){
    //confirm方法弹出一个对话框,可以选择确定与取消操作
    //同时该方法有返回值,true和false,两个布尔值
	$c = $(obj).parent().parent().find("td:eq(0)").text()
	console.log($c)
	
	$ID = $(obj).parent().parent().find("td:eq(2)").text()
	console.log("DID"+$ID)
    var flag = confirm("确定删除:"+$c+"吗");
    if(flag){
        
        //进行后台处理,路径跳转
//        window.location.href=getContextPath()+"/tasks/deDelete"+"?taskName=+$c";
    	$.ajax({ 

    	     data:"taskId="+$ID, 

    	     type:"POST", 

    	     dataType: 'text', 

    	     url:getContextPath()+"/tasks/doDelete", 

    	     success:function(data){ 

    	        alert("success");
    	        window.location.reload();


    	      },

    	     error:function(data){ 

    	         alert("fail"); 

    	     }

    	}); 
    }else{
        alert("你点击了取消");
    }
}

function operateFormatter(value,row,index){
	var content = '<a '
		+'class=" update btn btn-xs btn-primary"'
		+'rel="popover-hover"'
		+'data-placement="top"'
		+'data-content="更新"'+'onclick="update(this)"'
		+'href="javascript:void(0)">'
		
		+'<span class="fa fa-pencil"></span>'
		+'</a>'
		+'<a '
		+'class="btn delete btn-xs btn-danger"'
		+'rel="popover-hover"'
		+'data-placement="top"'
		+'data-content="删除	"'
		+'onclick="cli(this)"'
		+'href="javascript:void(0)">'
		+'<span class="fa fa-pencil"></span>'
		+'</a>'
		;
	return content;
}