function login(){
		var data = {};
		data.loginName = $("#loginName").val();
		data.password = $("#password").val();
		$.ajax({
			url: serverUrl+ '/user/login',
			type: 'POST',
			data: JSON.stringify(data),
			contentType: 'application/json',
			complete: function(response) {
				if(response.status == 200 || response.status == 201) {
					var result = JSON.parse(response.responseText);
					if(result.data.flag){
						window.location.href="mainPage.html";
					} else {
						alert("用户名或密码错误");
						console.log(result);
					}
				} else {
					if(response.responseText) {
						var result = JSON.parse(response.responseText);
					    alert('网络异常');
					} else {
						alert("网络异常");
					}
				}
			}
		});
	
}
