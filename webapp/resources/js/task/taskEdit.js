/**
 * 登录JS
 */

/*
 * ========================= Query初始化 =========================
 */
$(document).ready(function() {
	initForm();
});

/**
 * 初始化form
 */
function initForm() {
	// 设置from
	setFrom();
	// 登录
	$('#sumbitAdd').click(function() {
		$("#tipInfo").html("");
		
	});
}

// 设置form
function setFrom() {
	// 提示信息
	var emsg = "<i class='fa fa-exclamation-triangle'></i> ";

	// 校验form
	var vform = $("#addForm").validate({
		rules : {
			taskName : {
				required : true
			}
		},
		messages : {
			taskName : {
				required : '请输入任务名!'
			}
			
		},
		submitHandler : function(form) {
			$(form).ajaxSubmit({
				success : function(data) {
					if ("success" == data.RET_CODE) {
						showAlert("成功");
						
					} 
					else {
						$("#tipInfo").addClass("invalid");
						$("#tipInfo").html(emsg+data.RET_MSG);
					}
				}
			});
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
			element[0].focus();
			return false;
		}
	});
}
