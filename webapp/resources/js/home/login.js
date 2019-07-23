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
	$('#loginBtn').click(function() {
		$("#tipInfo").html("");
		$("#loginForm").submit();
	});
}

// 设置form
function setFrom() {
	// 提示信息
	var emsg = "<i class='fa fa-exclamation-triangle'></i> ";

	// 校验form
	var vform = $("#loginForm").validate({
		rules : {
			userName : {
				required : true
			},
			passWord : {
				required : true
			}
		},
		messages : {
			userName : {
				required : '请输入用户名!'
			},
			passWord : {
				required : '请输入密码!'
			}
		},
		submitHandler : function(form) {
			$(form).ajaxSubmit({
				success : function(data) {
					if ("success" == data.RET_CODE) {
							var vurl="/home/index";
							location.replace(getContextPath() + vurl);
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
