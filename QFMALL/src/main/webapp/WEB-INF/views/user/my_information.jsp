<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="../common/head.jsp"%>
<script src="js/user/userManage.js"></script>
<html>
 <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    <title>我的资料</title>
</head>
<body>

<!--我的资料-->
<div class="myinfo_container">
    <div class="page_center_wrapper">
        <div class="top_tabs_bar">
            <a id="base" class="tab_cell active" href="javascript:jibenziliao()">基本资料</a>
            <a id="pas" class="tab_cell" href="javascript:editPass()">密码管理</a>
        </div>
   		
        <div class="info_wrapper" id="dlg">
       		 <form id="fm" method="post" enctype="multipart/form-data">
        	<div class="info_item"><label class="item_label">唯一ID:</label><div class="item_value">
        		<input type="text" name='uuid' id='uuid' value="${qfUser.uuid}" readonly="readonly"></div></div>
        	<div class="info_item"><label class="item_label">头像:</label><div class="item_value">
        		<img width="100px" height="100px" src="${qfUser.avatarUrl}" /><input type="file" name='photo' id='avatarUrl'/></div></div>
            <div class="info_item"><label class="item_label">登录名:</label><div class="item_value">
            	<input type="text" name='loginName' id='loginName' value="${qfUser.loginName}"></div></div>
            <div class="info_item"><label class="item_label">邮箱:</label><div class="item_value">
            	<input type="text" name='emailAddress' id='emailAddress' value="${qfUser.emailAddress}"> <span class="errow_warn"><i>*</i>请输入邮箱</span></div></div>
            <div class="info_item"><label class="item_label">昵称:</label><div class="item_value">
            	<input type="text" name='nickName' id='nickName' value="${qfUser.nickName}"></div></div>
            <div class="info_item"><label class="item_label">真实姓名:</label><div class="item_value">
            	<input type="text" name='realName' id='realName' value="${qfUser.realName}"></div></div>
            <div class="info_item"><label class="item_label">手机:</label><div class="item_value">
            	<input type="text" name='phoneNum' id='phoneNum' value="${qfUser.phoneNum}"></div></div>
            <div class="info_item"><label class="item_label">性别:</label><div class="item_value">
            	<input type="text" name='gender' id='gender' value="${qfUser.gender}"></div></div>
            <div class="info_item"><label class="item_label">毕业学校:</label><div class="item_value">
            	<input type="text" name='graduateCollegedd' id='graduateCollegedd' value="${qfUser.graduateCollegedd}"></div></div>
            <div class="info_item"><label class="item_label">主修课程:</label><div class="item_value">
            	<input type="text" name='major' id='major' value="${qfUser.major}"></div></div>
            <div class="info_item"><label class="item_label">省:</label><div class="item_value">
            	<input type="text" name='province' id='province' value="${qfUser.province}"></div></div>
            <div class="info_item"><label class="item_label">市:</label><div class="item_value">
            	<input type="text" name='city' id='city' value="${qfUser.city}"></div></div>
            <div class="info_item"><label class="item_label">区:</label><div class="item_value">
            	<input type="text" name='district' id='district' value="${qfUser.district}"></div></div>
            <div class="item_value"><div class="show_protocol">查看我的购课协议</div></div>
            <div class="item_value"><div class="save_btn"><a href="javascript:edit()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a></div></div>
			</form>
        </div>
       	<div class="info_wrapper" id="pass">
       		<form id="fm" method="post" enctype="multipart/form-data">
       			<div class="info_item"><label class="item_label"></label><div class="item_value">
        		<input type="hidden" name='uuid' id='uuid' value="${qfUser.uuid}" readonly="readonly"></div></div>
       			<div class="info_item">
       				<label class="item_label">修改密码:</label>
       				<div class="item_value">
            			<input type="text" name='password' id='password'>
            		</div>
            	</div>
            	<div class="item_value"><div class="save_btn">
            	<a href="javascript:edit()" class="easyui-linkbutton"
					iconCls="icon-ok">保存</a></div></div>
       		</form>
       	</div>
    </div>
</div>
<!--我的资料End-->
<!--Footer Begin-->
<div class="page_footer_container">
    <div class="page_center_wrapper">
        <div class="clearfix">
            <div class="webmap_wrapper fl">
                <dl class="webmap_col">
                    <dd class="webmap_dd"><a href="${pageContext.request.contextPath}/首页.html">网站首页</a></dd>
                    <dd class="webmap_dd"><a href="#">关于我们</a></dd>
                    <dd class="webmap_dd"><a href="#">联系我们</a></dd>
                    <dd class="webmap_dd"><a href="#">加入我们</a></dd>
                </dl>
                <dl class="webmap_col">
                    <dd class="webmap_dd"><a href="#">选课购课</a></dd>
                    <dd class="webmap_dd"><a href="#">课程学习</a></dd>
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
                <img src="${pageContext.request.contextPath}/images/qrcode.png" alt="">
                <p><i class="wechat_icon"></i>微信扫一扫，使用小程序</p>
            </div>
            <div class="contact_wrapper fr">
                <p class="contact_tel">400-8888-8888</p>
                <p class="contact_work">周一至周日：8：00-20：00</p>
                <div class="contact_list">
                    <a class="contact_list_cell" href="#"><img src="${pageContext.request.contextPath}/images/icon_wechat.png" alt=""></a>
                    <a class="contact_list_cell" href="#"><img src="${pageContext.request.contextPath}/images/icon_sina.png" alt=""></a>
                    <a class="contact_list_cell" href="#"><img src="${pageContext.request.contextPath}/images/icon_qq.png" alt=""></a>
                </div>
            </div>
        </div>
        <p class="copyright_bar">Copyright@2013-2017 www.baidu.com All right res</p>
    </div>
</div>
<!--Footer End-->
</body>

</html>