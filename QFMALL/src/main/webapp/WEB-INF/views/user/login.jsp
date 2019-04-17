<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file="../common/head.jsp" %> --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="qfUser" value="${sessionScope.qf_user}"></c:set>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/style.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript">
        function doLogin() {
            var pReg = /1[3578]\d{9}/;//需要改变
            var loginName = $("#phoneNum").val();
            var password = $("#password").val();
            if (loginName == null || loginName == "") {
                alertWarnMsg("手机号不能为空！")
                return;
            }
            if (!(pReg.test(loginName))) {
                alertWarnMsg("请输入正确的手机号！")
                return;
            }
            if (password == null || password == "") {
                alertWarnMsg("请输入密码！");
                return;
            }
            if (password.length < 6) {
                alertWarnMsg("请输入正确长度密码！");
                return;
            }
            $.ajax({
                url: "${ctx}/doLogin.do",
                type: "POST",
                data: {
                    "loginName": loginName,
                    "password": password
                },
                async: false,
                dataType: "json",
                success: function (r) {
                	console.log(r.resultCode);
                    if (r.resultCode == 200) {
                        alertWarnMsg("登录成功！");
                        setTimeout(function () {

                        window.location.href = "index";

                        }, 400)
                    } else {
                        alertWarnMsg(r.message);
                    }
                }, error: function () {
                    alert("登录失败，网络异常");
                }, complete: function () {
                    $("#loginName").val("");
                    $("#password").val("");
                }
            });
        }

        function alertWarnMsg(msg) {
            $("#warnMsg").html(msg);
            $("#notice").css("display", "block");
        }

        $(function () {
            $('body').keydown(function (event) {
                if (event.which == 13) {
                    doLogin();
                }
            })
        })
    </script>
</head>
<body style="background-color: #f9f9f9;">
<div class="page_login_container">
    <div id="notice" class="account_error_warn" style="display: none;">
        <i></i><span id="warnMsg"></span>
    </div>
    <div class="login_main_wrapper">
        <a href="index.html" class="logo_img"><img src="images/login/logo.png" alt=""></a>
        <form action="" id="baseLoginForm">
            <div class="form_wrapper">
                <div class="form_item">
                    <p class="item_title">手机号</p>
                    <div class="item_value">
                        <input id="phoneNum" type="text" placeholder="请输入手机号">
                    </div>
                </div>
                <div class="form_item has_warn">
                    <p class="item_title">密码</p>
                    <div class="item_value">
                        <input id="password" type="password" placeholder="请输入密码">
                    </div>
                </div>
                <button onclick="javascript:doLogin()" type="button" class="submit_btn">登录</button>
                <div class="login_help"><a href="register.html">立即注册</a> <a class="fr" href="#">忘记密码</a></div>
                <div class="fast_login">
                    <a href="#"><img src="images/login/login_wechat.png" alt=""><span>使用微信登录</span></a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
