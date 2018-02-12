var serverUrl = "http://localhost:8080";
var checkSessionTimeOut = (function () {
	try{
		$("body").on("click","*",function() {
        	if(window.parent.window.checkSessionTimeOut){
        		window.parent.window.checkSessionTimeOut();
			}
    	});
	}catch(e){}
})();
$.fn.serializeObject = function() {  
   var o = {};  
   var a = this.serializeArray();  
   $.each(a, function() {  
       if (o[this.name]) {  
           if (!o[this.name].push) {  
               o[this.name] = [o[this.name]];  
           }  
           o[this.name].push(this.value || '');  
       } else {  
           o[this.name] = this.value || '';  
       }  
   });  
   return JSON.stringify(o);  
};
/**
 * 此方法用于user.html、sys.html、role.html、resource.html文件中编辑功能。
 * 适用于Easyui中GET请求.dialog使用情况下。
 * @param getUrl：点击编辑，获取数据的地址
 * @param id：点击时获取的行id
 * @param dialogData：弹出对话框显示的字段名称，eg:dialogData=["loginName","name","email"]
 * @param windowData: 弹出对话框的宽和高，eg：windowData={width:500,height:200}
 * @param postUrl：保存提交时地址
*/
function editRequest(getUrl,id,dialogData,windowData,postUrl){
    $.ajax({
        url:serverUrl + getUrl,
        type:"GET",
        data:{id:id},
        success:function(response){
            if(response){
                console.log(response);
                for(var i=0;i<dialogData.length;i++){
                    var Name=dialogData[i];
                    Name = Name.substring(0,1).toUpperCase() + Name.substring(1);
                    //resource.html editParentBlock editUrlBlock 目录时不显示
                    if(response[dialogData[i]]){
                        $("#edit"+Name).val(response[dialogData[i]]);
                        $("#edit"+Name+"Block").show();
                    }
                    else{
                        $("#edit"+Name+"Block").hide();
                    }
                }
                $('#editForm').form('disableValidation');
                $('#editDialog').dialog({
                    title: '编辑',
                    width: windowData.width,
                    height: windowData.height,
                    closed: false,
                    cache: false,
                    modal: true,
                    buttons: [{
                        text: '保存',
                        handler: function() {
                            var flag = $('#editForm').form('enableValidation').form('validate');
                            if(flag) {
                                var data = $('#editForm').serializeObject();
                                var dataObj=JSON.parse(data);
                                dataObj.id=id;
                                console.log(JSON.stringify(dataObj));
                                $.ajax({
                                    url: serverUrl +postUrl ,
                                    type: 'POST',
                                    data:JSON.stringify(dataObj),
                                    contentType: 'application/json',
                                    complete: function(response) {
                                        if(response.status == 200 || response.status == 201) {
                                            $('#editDialog').dialog('close');
                                            $('#DataGrid').datagrid('reload');
                                        } else {
                                            var result = JSON.parse(response.responseText);
                                            $.messager.alert('错误信息', result.msg, 'error');
                                        }
                                    }
                                });
                            }
                        }
                    }]
                });
            }
        }
    });
};