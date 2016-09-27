<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html xmlns="undefined">
<head>
<title>添加周工作计划</title>
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
      <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/>添加周工作计划 </div>
    <div id="Title_End"></div>
  </div> 
</div>
</head>
  <!--显示表单内容-->
 <div id="MainArea">
 <s:form action="week_save.action" >
  <div class="ItemBlockBorder">
            <div class="ItemBlock">
       <table class="table table-bordered" id="tab" cellpadding="0" cellspacing="0" >
		<thead><h3 align="center"><s:textfield name="year"/>年<s:textfield name="month" />月<s:textfield name="week" />周工作计划表</h3></thead>
		<tr align="center">
			<td>员工姓名</td><td><s:textfield name="employeeName"></s:textfield></td><td>完成日期</td><td><input type="text" name="endDate" /></td>
			
			</tr>
		<tr>
			<td>工作计划</td>
			<td colspan="3"><s:textarea name="plan" cols="150" rows="4"></s:textarea></td>
		</tr>
		<tr>
			<td>应完成情况描述</td>
			<td colspan="3"><s:textarea name="situationDescription" cols="150" rows="7"></s:textarea></td>
		</tr>		
		<tr>
			<td>工作输出结果</td>
			<td colspan="3"><s:textarea name="output" cols="150" rows="6"></s:textarea></td>
		</tr>		
		<tr>
			<td>未完成原因</td>
			<td colspan="3"><s:textarea name="reason" cols="150" rows="5"></s:textarea></td>
		</tr>		
</table>
</div>
</div>
<!-- 其他功能超链接 -->
    <!-- 表单操作 -->
        <div id="InputDetailBar">
            <button type="submit" class="btn btn-default">保存</button>
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
			
        </div>
    </s:form>
</div>
</body>
</html>
