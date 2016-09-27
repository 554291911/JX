<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html xmlns="undefined">
<head>
<title>编辑重点工作</title>
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
      <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/>编辑重点工作 </div>
    <div id="Title_End"></div>
  </div> 
</div>
</head>
  <!--显示表单内容-->
 <div id="MainArea">
 <s:form action="quarter_edit.action" >
 	<s:hidden name="id"></s:hidden>
  <div class="ItemBlockBorder">
            <div class="ItemBlock">
 <table class="table table-bordered" >
		<thead><h3 align="center">${year }年${month }月重点工作</h3></thead>
		<tr>
			<td>接收人</td>
			<td><s:textfield name="accepter"></s:textfield></td>
			<td>接收时间</td>
			<td><input type="text" name="acceptDate" value="${acceptDate }"/></td>
			<td>要求完成时间</td>
			<td><input type="text" name="endDate" value="${endDate }"/></td>
			
		</tr>
		<tr>
			<td>重点工作安排</td>
			<td colspan="5"><s:textarea cols="150" rows="5" name="keyWork" ></s:textarea></td>
		</tr>
	
			<tr>
			<td>目标要求</td>
			<td colspan="5"><s:textarea cols="150" rows="5" name="target" ></s:textarea></td>
			</tr>
			<tr>
			<td>完成结果</td>
			<td colspan="5"><s:textarea cols="150" rows="5" name="result" ></s:textarea></td>
			</tr>
			<tr>
			<td>结果分析</td>
			<td colspan="5"><s:textarea cols="150" rows="5" name="analysis" ></s:textarea></td>
			</tr>
</table>
	</div>

<!-- 其他功能超链接 -->
    <div id="InputDetailBar">
			<button type="submit" class="btn btn-default">提交</button>
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
        </div>
</div>
</s:form>
</div>	
</body>
</html>
