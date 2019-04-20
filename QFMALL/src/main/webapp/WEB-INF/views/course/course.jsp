<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        url: "${ctx}/course/courselist",
        type: "POST",
        data: {
        },
        async: false,
        dataType: "json",
        success: function (r) {
			 window.location.reload();
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
				<h2><span>CATEGORY ONE</span></h2>
				
				<a href="#" class="see-all">See all articles in this category</a>
				
				<div class="cl">&nbsp;</div>
				
				<div class="posts">
					<!-- Post -->
				    <div class="post">
				    	<div class="image">
				    		<a href="#"><img src="/images/english1.jpg" alt="" /></a>
				    	</div>
				    	<div class="data">
				    		<h4><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></h4>
				    		<p>Maecenas sodales auctor urna cursus facilisis. Cras rutrum justo id mi bibendum luctus. </p>
				    	</div>
				    </div>
				    <!-- /Post -->
					<!-- Post -->
				   <div class="post last">
				    	<div class="image">
				    		<a href="#"><img src="styles/css/images/post-2.jpg" alt="" /></a>
				    	</div>
				    	<div class="data">
				    		<h4><a href="#">Maecenas scelerisque sapien </a></h4>
				    		<p>Maecenas sodales auctor urna cursus facilisis. Cras rutrum justo id mi bibendum luctus. </p>
				    	</div>
				    </div>
				    <!-- /Post -->
				    <div class="cl">&nbsp;</div>
					<!-- Post -->
				    <div class="post">
				    	<div class="image">
				    		<a href="#"><img src="styles/css/images/post-3.jpg" alt="" /></a>
				    	</div>
				    	<div class="data">
				    		<h4><a href="#">Cras ac ultrices ipsum. </a></h4>
				    		<p>Vivamus adipiscing dui at turpis imperdiet congue. Fusce posuere augue et odio bibendum non dictum nisi posuere. </p>
				    	</div>
				    </div>
				    <!-- /Post -->
					<!-- Post -->
				    <div class="post last">
				    	<div class="image">
				    		<a href="#"><img src="/images/math1.jpg" alt="" /></a>
				    	</div>
				    	<div class="data">
				    		<h4><a href="#">Nunc ac lorem id ipsum.</a></h4>
				    		<p>Maecenas sodales auctor urna cursus facilisis. Cras rutrum justo id mi bibendum luctus. </p>
				    	</div>
				    </div>
				    <!-- /Post -->
					<div class="cl">&nbsp;</div>
				</div>
			</div>
			<!-- /Box -->
			
			<c:forEach var="category" items="${categoryDTOs}">
				<!-- Box -->
				<div class="box">
					<h2><span>${category.categoryName}</span></h2>
					<a href="#" class="see-all">查看更多</a>
					<div class="cl">&nbsp;</div>
					
					<!-- Posts -->
					<div class="posts">
						<c:forEach var="course" items="${category.courseDTOs}">
							<!-- Post -->
						    <div class="post">
						    	<div class="image">
						    		<a href="#"><img src=" /images/${course.courseImg }" alt="" /></a>
						    	</div>
						    		<div class="data">
						    			<h4><a href="#">${course.courseName }</a></h4>
						    			<p id="courseId" name="courseId" value="${course.id }">
						    			<a>${course.price }￥</a><a href="#" class="button blue small" onclick="buy(${course.id},'${sessionScope.qf_user.uuid}')">购买</a>
						    			<c:forEach  var="chapter" items="${course.chapters}">
						    				<p>${chapter.chapterName } </p>
						    			</c:forEach>
						    		</div>
						    </div>
						    <!-- /Post -->
						</c:forEach>
					</div>
				</div>
			</c:forEach>
			
			<!-- Box -->
			<div class="box">
				<h2><span>CATEGORY TWO</span></h2>
				
				<a href="#" class="see-all">See all articles in this category</a>
				
				<div class="cl">&nbsp;</div>
				
				<div class="posts">
					<!-- Post -->
				    <div class="post">
				    	<div class="image">
				    		<a href="#"><img src="styles/css/images/post-5.jpg" alt="" /></a>
				    	</div>
				    	<div class="data">
				    		<h4><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></h4>
				    		<p>Maecenas sodales auctor urna cursus facilisis. Cras rutrum justo id mi bibendum luctus. </p>
				    	</div>
				    </div>
				    <!-- /Post -->
					<!-- Post -->
				    <div class="post last">
				    	<div class="image">
				    		<a href="#"><img src="styles/css/images/post-6.jpg" alt="" /></a>
				    	</div>
				    	<div class="data">
				    		<h4><a href="#">Maecenas scelerisque sapien </a></h4>
				    		<p>Maecenas sodales auctor urna cursus facilisis. Cras rutrum justo id mi bibendum luctus. </p>
				    	</div>
				    </div>
				    <!-- /Post -->
				    <div class="cl">&nbsp;</div>
					<!-- Post -->
				    <div class="post">
				    	<div class="image">
				    		<a href="#"><img src="styles/css/images/post-1.jpg" alt="" /></a>
				    	</div>
				    	<div class="data">
				    		<h4><a href="#">Cras ac ultrices ipsum. </a></h4>
				    		<p>Vivamus adipiscing dui at turpis imperdiet congue. Fusce posuere augue et odio bibendum non dictum nisi posuere. </p>
				    	</div>
				    </div>
				    <!-- /Post -->
					<!-- Post -->
				    <div class="post last">
				    	<div class="image">
				    		<a href="#"><img src="styles/css/images/post-1.jpg" alt="" /></a>
				    	</div>
				    	<div class="data">
				    		<h4><a href="#">Nunc ac lorem id ipsum.</a></h4>
				    		<p>Maecenas sodales auctor urna cursus facilisis. Cras rutrum justo id mi bibendum luctus. </p>
				    	</div>
				    </div>
				    <!-- /Post -->
					<div class="cl">&nbsp;</div>
				</div>
			</div>
			<!-- /Box -->
						
			
			<div class="cl">&nbsp;</div>	
		</div>
		<!-- /Content -->

	</div>
	<!-- /Main -->
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
