<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>突发事件流转</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
</head>
<s:form action="transfer_list">
<body>
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 突发事件流转
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
			
		请输入科目名称关键字 ：<s:textfield name="subjectType"  cssClass="InputStyle2" />
						<input type="IMAGE" src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
					</table>
				</div>
			</div>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td >时间</td>
				<td >发起人</td>
				<td >接收人</td>
				<td >科目</td>
				<td>状态</td>
				<td >相关操作</td>
			</tr>
		</thead>	

        <tbody id="TableData" class="dataContainer" >
			 <s:iterator value="recordList">
			<tr class="TableDetail1 template" align="center">	
				<td>${nowTime }</td>
				<td>${nowPromoter }</td>
				<td>${nowRecipient }</td>
				<td>${subject }</td>
				<td>${status }</td>
				<td><s:a action="transfer_detailUI?id=%{id}">查看详细</s:a>&nbsp;
						<s:a action="transfer_editUI?id=%{id}">发起流转</s:a>&nbsp;
						<s:a action="transfer_succeed?id=%{id}" onclick="return confirm('确定完成流转？')">完成</s:a>&nbsp;
			</tr>
			</s:iterator>
        </tbody>
    </table>
   
   <!-- 其他功能超链接 -->
    <div id="TableTail">
		 <div id="TableTail_inside">
			<s:a action="transfer_saveUI"><img src="${pageContext.request.contextPath}/style/blue/images/button/addNew.PNG" /></s:a>
        </div>
    </div>
</div>
<!-- 分页信息 -->
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
</body>
</s:form>
</html>
