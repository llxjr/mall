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
	console.log("test question~~~");

</script>

</head>
<body>
<!--Index Banner-->

	<!-- Main -->
	<div id="main">
	<div id="paper" style="background-color:white; height: 1000px;width: 80%;margin: auto;">
		<div style="font-size:50px;text-align:center;margin-bottom: 30px;">XXX练习</div>
		<div style="height: 100px;width: 100%;font-size:30px;margin-bottom: 30px;">
			<div>1、一位商人花了70元购进一件衣服，加价12元售出。后发现购买者支付的那张100元是假钞，商人想将这100元花出去，可是一不小心又丢掉了。现在请你帮那个倒霉的商人算算，他在这件衣服上共损失了多少钱呢？（）</div>
			<div style="margin-left: 50px;">
				<label><input type="radio" value="" name="qAnswer" /><span></span>A. 80￥</label>
				<label><input type="radio" value="" name="qAnswer" /><span></span>B. 50￥</label>
				<label><input type="radio" value="" name="qAnswer" /><span></span>C. 20￥</label>
				<label><input type="radio" value="" name="qAnswer" /><span></span>D. 0￥</label>
				
			</div>
		</div>
		<div style="height: 100px;width: 100%;font-size:30px;margin-bottom: 30px;">
			<div>2、一位商人花了70元购进一件衣服，加价12元售出。后发现购买者支付的那张100元是假钞，商人想将这100元花出去，可是一不小心又丢掉了。现在请你帮那个倒霉的商人算算，他在这件衣服上共损失了多少钱呢？（）</div>
			<div style="margin-left: 50px;">
				<label><input type="radio" value="" name="qAnswer" /><span></span>A. 80￥</label>
				<label><input type="radio" value="" name="qAnswer" /><span></span>B. 50￥</label>
				<label><input type="radio" value="" name="qAnswer" /><span></span>C. 20￥</label>
				<label><input type="radio" value="" name="qAnswer" /><span></span>D. 0￥</label>
				
			</div>
		</div>
	</div>
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
