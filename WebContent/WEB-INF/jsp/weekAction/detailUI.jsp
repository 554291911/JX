<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html xmlns="undefined">
<head>
<title>审批结果</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	<link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
</head>
<body>
<!-- 标题显示 -->
<div id="Title_bar">
  <div id="Title_bar_Head">
    <div id="Title_Head"></div>
    <div id="Title">
      <!--页面标题-->
      <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/>审批结果 </div>
    <div id="Title_End"></div>
  </div> 
</div>
</head>
  <!--显示表单内容-->
 <div id="MainArea">
  <div class="ItemBlockBorder">
            <div class="ItemBlock">
       <table class="table table-bordered" id="tab" cellpadding="0" cellspacing="0" >
		<thead><h3 align="center">${year }年${month }月${week }周工作计划表</h3></thead>
		<tr align="center">
			<td>员工姓名</td><td>${employeeName }</td><td>完成日期</td><td>${endDate }</td>
			
			</tr>
		<tr>
			<td>工作计划</td>
			<td colspan="3">${plan }</td>
		</tr>
		<tr>
			<td>应完成情况描述</td>
			<td colspan="3">${situationDescription }</td>
		</tr>		
		<tr>
			<td>工作输出结果</td>
			<td colspan="3">${output }</td>
		</tr>		
		<tr>
			<td>未完成原因</td>
			<td colspan="3">${reason }</td>
		</tr>		
		<tr>
			<td>审批意见</td>
			<td colspan="3">${remarks }</td>
		</tr>
		<tr>
			<td>审批状态</td>
			<td colspan="3">${status }</td>
		</tr>		
</table>
</div>
</div>
<!-- 其他功能超链接 -->
    <!-- 表单操作 -->
        <div id="InputDetailBar">
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
        </div>
</div>
</body>
</html>
