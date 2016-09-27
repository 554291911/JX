<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
    <title>经营指标统计</title>
   <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 经营指标统计
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td >序号</td>
				<td >经营指标统计表</td>
				<td >其他操作</td>
			</tr>
		</thead>	

		<!--显示数据列表：正在审批或审批完成的表单显示示例-->
        <tbody id="TableData" class="dataContainer" >
			<s:iterator value="recordList">
			
			<tr class="TableDetail1 template" align="center" valign="MIDDLE">
				<td>${id }</td>
				<td>${indicatorName }</td>
				<td><a href="word/${indicatorName }" onclick="return confirm('确定要下载吗？')">下载</a>
				<s:a action="indicator_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
		<table border="0" cellspacing="0" cellpadding="0" height="100%" >
			 <tr  valign="MIDDLE" >
				 <td>
				 <s:a action="indicator_uploadUI.action">上传</s:a>
			</td>	
			</tr>
			</table>
        </div>
	</div>
	<!-- 分页信息 -->
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	<s:form action="talent_list"></s:form>
</body>
</html>

