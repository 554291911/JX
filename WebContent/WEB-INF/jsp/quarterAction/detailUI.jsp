<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html xmlns="undefined">
<head>
<title>人才信息管理</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
</head>
<body>
<!-- 标题显示 -->
<div id="Title_bar">
  <div id="Title_bar_Head">
    <div id="Title_Head"></div>
    <div id="Title">
      <!--页面标题-->
      <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/>详细内容 </div>
    <div id="Title_End"></div>
  </div> 
</div>
</head>
  <!--显示表单内容-->
 <div id="MainArea">
  <div class="ItemBlockBorder">
            <div class="ItemBlock">
        <table class="table table-bordered" >
		<thead><h3 align="center">${year }年${month }月工作重点表</h3></thead>
		<tr>
			<td>接收人</td>
			<td>${ accepter}</td>
			<td>接收时间</td>
			<td>${acceptDate }</td>
			<td>要求完成时间</td>
			<td>${endDate }</td>
			
		</tr>
		<tr>
			<td>重点工作安排</td>
			<td colspan="5">${keyWork }</td>
		</tr>
	
			<tr>
			<td>目标要求</td>
			<td colspan="5">${target }</td>
			</tr>
			<tr>
			<td>完成结果</td>
			<td colspan="5">${result }</td>
			</tr>
			<tr>
			<td>结果分析</td>
			<td colspan="5">${analysis }</td>
			</tr>
			<tr>
			<td>审批意见</td>
			<td colspan="5">${remarks }</td>
		</tr>	
			<tr>
			<td>审批状态</td>
			<td colspan="5">${status }</td>
		</tr>
</table>
</div>
</div>
<!-- 其他功能超链接 -->
    <div id="InputDetailBar">
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
        </div>
</div>
</body>
</html>
