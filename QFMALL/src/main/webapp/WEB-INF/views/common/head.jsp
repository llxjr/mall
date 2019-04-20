<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="qfUser" value="${sessionScope.qf_user}"></c:set>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/style.css">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<script type="text/javascript">
	
	$.ajax({
        url: "${ctx}/category/head",
        type: "POST",
        data: {
        },
        async: false,
        dataType: "json",
        success: function (r) {
			 window.location.reload();
        }
    });
    function logout(){
	$.ajax({
		url : 'doLogout.do',
		type : 'POST',
		data : {}, 
		dataType : "json",//预期服务器返回的数据类型
        contentType: false,  
        processData: false,
		success : function(res) {
			if (res.resultCode == 200) {
				//$.messager.alert("系统提示，退出成功!");
			 window.location.reload();
			} else {
				$.messager.alert("系统提示，error");
			}
		},
		error : function() {
			 window.location.reload();
		}

	})
    }
	
</script>
<body>
	
<!--Header Begin-->
<div class="page_header_container">
    <div class="page_center_wrapper clearfix">
        <a class="logo_wrapper fl" href="首页.html"><img src="images/page_logo.png"></a>
        <div class="course_wrapper fl">
            <h2 class="course_title">选课中心<i class="drop_icon"></i></h2>
            <div class="course_content">
                <dl class="course_list">
                	<c:forEach var="parent" items="${categoryList}">
                		<dt class="course_list_title">${parent.categoryName}</dt>
                		<dd class="course_list_dd">
	               			<c:if test="${parent.level eq 1}">
	               				<c:forEach var="child" items="${parent.child}">
	               					<a class="course_list_cell" 
	               						href="${ctx}/course/findByCategoryId(${child.id})">
	               						${child.categoryName}
	               					</a>
	               				</c:forEach>
	               			</c:if>
                		</dd>
                	</c:forEach>
                </dl>
                
            </div>
        </div>
        <ul class="nav_wrapper fl">
            <li class="nav_li"><a class="nav_cell" href="index">首页</a></li>
            <li class="nav_li"><a  href="course.do">课程</a></li>
            <li class="nav_li"><a  href="index">题库</a></li>
            <li class="nav_li"><a class="nav_cell" href="index">考试练习</a></li>
            <li class="nav_li"><a class="nav_cell" href="#">资讯公告</a></li>
        </ul>
        <div class="fr">
            <div class="user_wrapper clearfix">
                <a class="user_item" href="index">购物车(0)</a>
                <a class="user_item" href="index">我的订单</a>
                <a class="user_item last_user_item" href="myGoods.do">我的课程</a>
               	<a class="user_avatar" href="mypage"><img src="${qfUser.avatarUrl}" alt=""></a>
                <c:if test="${qfUser == null }">
                    <a class="login_item" href="login.html">登录</a>
                    <a class="login_item" href="register.html">注册</a>
                </c:if>
                <c:if test="${qfUser != null }">
                    <span class="login_item">${qfUser.nickName}</span>
                    <a href="#" onclick="logout()">退出</a>
                </c:if>
            </div>
            <div class="search_wrapper">
                <input type="text" placeholder="搜索感兴趣的课程">
                <div class="search_btn"><i></i></div>
            </div>
        </div>
    </div>
</div>
<!--Header End-->
	
</body>

</html>
