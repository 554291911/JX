<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>潜在客户信息</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title">
		<!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 潜在客户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td >猎头顾问</td>
				<td >发起时间</td>
				<td>潜在客户名称</td>
				<td>联系人</td>
				<td >联系人电话</td>
				<td>其他操作</td>
			</tr>
		</thead>	
				

        <tbody id="TableData" class="dataContainer" >
        	<s:iterator value="recordList">
			<tr class="TableDetail1 template" align="center">
				<td>${headHunting }</td>
				<td>${startTime }</td>
				<td>${name }</td>
				<td>${contactPerson }</td>
				<td>${contactInformation }</td>
				<td><s:a action="potential_detailUI?id=%{id}">查看详细</s:a>&nbsp;
						<s:a action="potential_editUI?id=%{id}">编辑</s:a>&nbsp;
						<s:a action="potential_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a></td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
      
    
  <!-- 其他功能超链接 -->
    <div id="TableTail">
		 <div id="TableTail_inside">
			<s:a action="potential_saveUI"><img src="${pageContext.request.contextPath}/style/blue/images/button/addNew.PNG" /></s:a>
        </div>
    </div>

	<!-- 分页信息 -->
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="potential_list"></s:form>
</div>
</body>
</html>
