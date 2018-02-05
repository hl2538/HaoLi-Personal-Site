function login(){
		var data = {};
		data.accountName = $("#accountName").val();
		data.password = $("#password").val();
		$.ajax({
			url:serverUrl+'user/login',
			type: 'POST',
			data: JSON.stringify(data),
			contentType: 'application/json',
			complete: function(response) {
				console.log(response);
				if(response.status == 200 || response.status == 201) {
					var result = JSON.parse(response.responseText);
					if(result.flag){
						window.location.href="mainPage.html";
					} else {
						$.messager.alert('错误信息', "用户名或密码错误", 'error');
					}
				} else {
					if(response.responseText) {
						var result = JSON.parse(response.responseText);
					    $.messager.alert('错误信息', result.msg, 'error');
					} else {
						$.messager.alert('错误信息', "网络异常", 'error');
					}
				}
			}
		});
	
}
