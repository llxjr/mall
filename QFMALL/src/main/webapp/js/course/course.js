function buy(courseId,uuid){
	var id = courseId;
	console.log("user");
	if(uuid != null && uuid != ""){
		console.log(courseId);
		$.ajax({
			url: "mygoods/addGoods/" + id,
			type: "POST",
			data: {},
			dataType: "json",
			success: function(res){
				if (res.resultCode == 200) {
					alert("系统提示，购买课程成功!");
				} else {
					alert("系统提示，" + res.message);
				}
			}
		});
	}else{
		alert("亲！您还没有登录哦~");
   		window.location.href = "/QFMALL/login.html";
	}
}

function answerQuestion() {
	console.log("test!!!");
	window.location.href = "/QFMALL/question";
//	$('#dlg').dialog({
//		title : '添加课程',
//		closed : false,
//		cache: false,
//	    width: 600,             
//	    height: 300,     
//		buttons : [ {
//			text : '保存',
//			iconCls : 'icon-add',
//			handler : function() {
//				add();
//			}
//		}, {
//			text : '取消',
//			iconCls : 'icon-cancel',
//			handler : function() {
//				$('#dlg').dialog("close");
//				reset();
//			}
//		} ]
//	})

}