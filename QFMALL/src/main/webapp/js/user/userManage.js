function edit() {
	var formData = new FormData(document.getElementById("fm")); 
	$.ajax({
		url : 'user/update',
		type : 'POST',
		data : formData, 
		dataType : "json",//预期服务器返回的数据类型
        contentType: false,  
        processData: false,
		success : function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "编辑成功!");
			} else {
				$.messager.alert("系统提示", res.message);
			}
		},
		error : function() {
			 window.location.reload();
		}

	})
}

$(function(){
	$("#dlg").show();
	$("#pass").hide();
	
})

function jibenziliao(){
	$("#dlg").show();
	$("#pass").hide();
	$("#base").addClass("active");
	$("#pas").removeClass("active");
	
}
function editPass(){
	$("#dlg").hide();
	$("#pass").show();
	$("#pas").addClass("active");
	$("#base").removeClass("active");
	
}