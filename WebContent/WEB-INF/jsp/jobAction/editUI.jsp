<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	
<html>
<head>
	<title>添加职位信息</title>
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 添加职位信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
      <s:form action="job_edit.action">    
      <s:hidden name="id"></s:hidden>
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
			<table class="table table-bordered"  >
				<thead>
				<tr align="CENTER" valign="MIDDLE">
					<td>岗位名称</td>
					<td>客户</td>
					<td>紧急程度</td>
					<td>工作地点</td>
					<td>待遇状况</td>
					<td>发布日期</td>
					<td>状态</td>
					</tr>
				</thead>
				<tr  align="CENTER" valign="MIDDLE">
					<td><s:textfield name="jobName" />
						  </td>
					
					<td> <s:textfield name="companyName" />
						  </td>
						  <td>
						  <s:select headerKey="" headerValue="请选择紧急程度" name="emergencyDegree" 
						  list="{'★', '★★', '★★★', '★★★★', '★★★★★'}"/>  
         </td>
					<td><s:textfield name="workingPlace" cssClass="InputStyle2"/></td>
					<td><s:textfield name="treatment" cssClass="InputStyle2"/></td>
					<td><input type="text" name="releaseDate" value="${ releaseDate}"></td>
					<td> 
					<s:select  name="status" 
						   list="{'发布', '关闭'}" />  
						  </td>
			</tr>
			<thead>
			<tr>
				<td colspan="7">岗位要求</td>
			</tr>	
			</thead>
			<tr>
				<td colspan="7"><s:textarea name="requirement" cols="150" rows="5"></s:textarea></td>
			</tr>
			<thead>
			<tr>
				<td colspan="7">职位描述</td>
			</tr>	
			</thead>
				<td colspan="7"><s:textarea name="description" cols="150" rows="5"></s:textarea></td>
			</table>				
	</div>
</div>
 					<!-- 表单操作 -->
        <div id="InputDetailBar">
            <button type="submit" class="btn btn-default">保存</button>
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
        </div>
   </s:form>
</div>
</body>
</html>
