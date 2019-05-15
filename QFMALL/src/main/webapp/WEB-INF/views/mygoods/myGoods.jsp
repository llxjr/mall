<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="qfUser" value="${sessionScope.qf_user}"></c:set>
<html>
<head>
    <title>青蜂商城</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="styles/css/style.css">
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/jquery-func.js"></script>
	<script type="text/javascript" src="js/course/course.js"></script>
<script type="text/javascript">
	$.ajax({
        url: "mygoods/findAllGoods",
        type: "POST",
        data: {},
        async: false,
        dataType: "json",
        success: function (r) {
           if (r.resultCode == 200) {
           		if(location.href.indexOf("#reloaded")==-1){
		        location.href=location.href+"#reloaded";
		        location.reload();
         	}
           } else {
           		alert(r.message);
           		window.location.href = "/QFMALL/login.html";
           		
             }
            }, error: function (r) {
                alert(r.message);
          }
    });
</script>

</head>
<body>
<!--Index Banner-->

	<!-- Main -->
	<div id="main">
<!-- Content -->
		<div id="content">
			<!-- Box -->
				<div class="box">
					<h2><span>已购买课程</span></h2>
					<a href="#" class="see-all">查看更多</a>
					<div class="cl">&nbsp;</div>
					
					<!-- Posts -->
					<div class="posts">
					<c:if test="${mygooods } == null">
						<h1>空空如也~</h1>
					</c:if>
						<c:forEach var="mygoods" items="${mygoods}">
							<!-- Post -->
						    <div class="post">
						    	<div class="image">
						    		<a href="#"><img src=" /images/${mygoods.goodsImg }" alt="" /></a>
						    	</div>
						    		<div class="data">
						    			<h4><a href="#">${mygoods.goodsName }</a></h4>
						    			<p id="mygoodsId" name="mygoodsId" value="${mygoods.id }">
						    			<a>${mygoods.goodsPrice }￥</a>
						    			<p>${mygoods.description } </p>
						    			<a href="#" onclick="answerQuestion()">章节练习</a>
						    		</div>
						    </div>
						    <!-- /Post -->
						</c:forEach>
					</div>
				</div>
			<!-- /Box -->
			<div class="cl">&nbsp;</div>	
		</div>
		<!-- /Content -->

	</div>
	<!-- /Main -->
	<!-- 
	<div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="add_form" method="post" >
			<table cellspacing="8px">
				<tr>
					<td>课程类目：</td>
					<td>
						<select id="categoryId" name="categoryId">
							<option value="">---请选择课程类目---</option>											
						</select>
				 		&nbsp;<font color="red">*</font>
					</td>
				</tr>
				
				
			</table>
		</form>
	</div>
	 -->
<!--Footer Begin-->
<div class="page_footer_container">
    <div class="page_center_wrapper">
        <div class="clearfix">
            <div class="webmap_wrapper fl">
                <dl class="webmap_col">
                    <dd class="webmap_dd"><a href="首页.html">网站首页</a></dd>
                    <dd class="webmap_dd"><a href="#">关于我们</a></dd>
                    <dd class="webmap_dd"><a href="#">联系我们</a></dd>
                    <dd class="webmap_dd"><a href="#">加入我们</a></dd>
                </dl>
                <dl class="webmap_col">
                    <dd class="webmap_dd"><a href="course/课程.html">选课购课</a></dd>
                    <dd class="webmap_dd"><a href="course/课程.html">课程学习</a></dd>
                    <dd class="webmap_dd"><a href="#">成绩证书</a></dd>
                </dl>
                <dl class="webmap_col">
                    <dd class="webmap_dd"><a href="#">网站条款</a></dd>
                    <dd class="webmap_dd"><a href="#">常见问题</a></dd>
                    <dd class="webmap_dd"><a href="#">意见反馈</a></dd>
                    <dd class="webmap_dd"><a href="#">青蜂网校</a></dd>
                </dl>
            </div>
            <div class="qrcode_wrapper fl">
                <img src="images/weixin.png" alt="">
                <p style="color:#6C6C6C"><i class="wechat_icon" ></i>微信扫一扫，使用小程序</p>
            </div>
            <div class="contact_wrapper fr">
                <p class="contact_tel">400-8888-8888</p>
                <p class="contact_work">周一至周日：8：00-20：00</p>
                <div class="contact_list">
                    <a class="contact_list_cell" href="#"><img src="images/icon_wechat.png" alt=""></a>
                    <a class="contact_list_cell" href="#"><img src="images/icon_sina.png" alt=""></a>
                    <a class="contact_list_cell" href="#"><img src="images/icon_qq.png" alt=""></a>
                </div>
            </div>
        </div>
        <p class="copyright_bar" style="color:#6C6C6C">山外有山，人外有人，学习有青峰教育@2020-20-20。</p>
    </div>
</div>
<!--Footer End-->
<script src="vendors/jquery/1.42/jquery1.42.min.js"></script>
<script src="vendors/SuperSlide/2.1.2/jquery.SuperSlide.2.1.2.js"></script>
<script  type="text/javascript" >
    // 首页轮播 需要引用SuperSlide
    $(".index_banner_container").slide({
        titleCell:".hd ul",
        mainCell: ".bd ul",
        vis: "atuo",
        autoPlay:true
    })
</script>
</body>
</html>
