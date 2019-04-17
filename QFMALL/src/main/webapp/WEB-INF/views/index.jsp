<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<html>
<head>
    <title>青蜂商城</title>
</head>
<body>
<!--Index Banner-->
<div class="index_banner_container">
    <div class="bd">
        <ul>
            <li>
                <a class="banner_img" href="#" style="background-image: url(images/index_banner.jpg);"></a>
            </li>
            <li>
                <a class="banner_img" href="#" style="background-image: url(images/index_banner.jpg);"></a>
            </li>
            <li>
                <a class="banner_img" href="#" style="background-image: url(images/index_banner.jpg);"></a>
            </li>
        </ul>
    </div>
    <div class="hd">
        <ul>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>

<!--Index Banner End-->
<!--container1 Begin-->
<div class="index_main_container1">
    <div class="page_center_wrapper clearfix">
        <div class="grid_cell">
            <img src="images/icon_kaodian.png" alt="">
            <h2>考点覆盖</h2>
            <p>超大题源量<br>知识点考点全覆盖</p>
        </div>
        <div class="grid_cell">
            <img src="images/icon_ai.png" alt="">
            <h2>智能练习</h2>
            <p>利用人工智能算法<br>实现一对一智能出图</p>
        </div>
        <div class="grid_cell">
            <img src="images/icon_pinggu.png" alt="">
            <h2>智能评估</h2>
            <p>智能评估成绩<br>精确预测考分</p>
        </div>
        <div class="grid_cell">
            <img src="images/icon_shiping.png" alt="">
            <h2>视频课程</h2>
            <p>视频解析声情并茂<br>业内名师讲解</p>
        </div>
    </div>
</div>
<!--container1 End-->
<!--container2 Begin-->
<div class="index_main_container2">
    <div class="page_center_wrapper">
        <h2 class="container_title">青蜂题库 九大板块，九九归一</h2>
        <ul class="grid_wrapper clearfix">
            <li class="grid_cell">
                <img src="images/index_menu_icon_01.png" alt="">
                <h3>金融</h3>
            </li>
            <li class="grid_cell">
                <img src="images/index_menu_icon_02.png" alt="">
                <h3>考研</h3>
            </li>
            <li class="grid_cell">
                <img src="images/index_menu_icon_03.png" alt="">
                <h3>医学</h3>
            </li>
            <li class="grid_cell">
                <img src="images/index_menu_icon_04.png" alt="">
                <h3>会计</h3>
            </li>
            <li class="grid_cell">
                <img src="images/index_menu_icon_05.png" alt="">
                <h3>公考</h3>
            </li>
            <li class="grid_cell">
                <img src="images/index_menu_icon_06.png" alt="">
                <h3>工程</h3>
            </li>
            <li class="grid_cell">
                <img src="images/index_menu_icon_07.png" alt="">
                <h3>资格</h3>
            </li>
            <li class="grid_cell">
                <img src="images/index_menu_icon_08.png" alt="">
                <h3>外语</h3>
            </li>
            <li class="grid_cell">
                <img src="images/index_menu_icon_09.png" alt="">
                <h3>职场</h3>
            </li>
        </ul>
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
