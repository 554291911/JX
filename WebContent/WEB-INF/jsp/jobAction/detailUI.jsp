<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>查看职位描述</title>
   <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	<link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
 
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 查看职位描述
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>      
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
			<table class="table table-bordered"  >
			
			<thead>
			<tr>
				<td >岗位要求</td>
			</tr>	
			</thead>
				<td >${requirement }</td>
				<thead>
			<tr>
				<td >职位描述</td>
			</tr>	
			</thead>
				<td >${description}</td>
				
			</table>				
	</div>
</div>
 					<!-- 表单操作 -->
        <div id="InputDetailBar">        
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
        </div>
</div>
</body>
</html>
