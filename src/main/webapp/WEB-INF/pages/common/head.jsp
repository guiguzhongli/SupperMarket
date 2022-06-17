<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" />
</head>
<body>
<!--头部-->
<header class="publicHeader" style="position: relative">
    <h1>超市订单管理系统</h1>
    <div style="position: absolute;top: 0;left: 1000px">张志豪 2004050151 软件技术1班</div>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.userCode}</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath }/logout">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="${pageContext.request.contextPath }/bill/billlist">订单管理</a></li>
                <li><a href="${pageContext.request.contextPath }/provider/prolist">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath }/userlist">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath }/pages/pwdmodify.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath }/logout">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
    <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>