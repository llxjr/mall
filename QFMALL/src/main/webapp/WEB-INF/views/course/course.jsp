<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<html>
<head>
    <title>青蜂商城</title>
<script type="text/javascript">
	console.log("课程");
</script>

</head>
<body>
<!--Index Banner-->



<!--Index Banner End-->
<!--container1 Begin-->
<div class="index_main_container1">
    <div class="page_center_wrapper clearfix">
    </div>
</div>
<!--container1 End-->
<!--container2 Begin-->
<div class="index_main_container2">
    <div class="page_center_wrapper">
    </div>
</div>
<!--container2 End-->
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
                <p><i class="wechat_icon"></i>微信扫一扫，使用小程序</p>
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
        <p class="copyright_bar">山外有山，人外有人，学习有青峰教育@2020-20-20。</p>
    </div>
</div>
<!--Footer End-->
<script src="vendors/jquery/1.42/jquery1.42.min.js"></script>
<script src="vendors/SuperSlide/2.1.2/jquery.SuperSlide.2.1.2.js"></script>
<script>
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
