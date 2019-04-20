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
			success: function(r){
				alert("购买成功");
			}
		});
	}else{
		alert("亲！您还没有登录哦~");
		return ;
	}
}