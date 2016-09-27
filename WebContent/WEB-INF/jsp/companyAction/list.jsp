<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>客户公司资料</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <script type="text/javascript">
    </script>
</head>
<body>
  <s:form action="company_list">
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 客户公司资料
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
						请输入公司名关键字 ：<s:textfield name="comName" cssClass="InputStyle2" /> 
						<input type="IMAGE" src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
					</table>
				</div>
			</div>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	
                <td  width="10%">客户公司名称</td>
                <td width="15%">其他操作</td>			
            </tr>
			
        </thead>

		<!--显示数据列表-->
        <tbody   id="TableData" class="dataContainer" >
           <s:iterator value="recordList">
			<tr class="TableDetail1 template" align="CENTER" valign="MIDDLE">
				
				<td>${companyName }</td>		
				<td>
				<s:a action="company_detailUI?id=%{id}">查看详细</s:a>&nbsp;
					<s:a action="company_editUI?id=%{id}">编辑</s:a>&nbsp;
					<s:a action="company_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
				</td>
			</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
		<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left" class="TableStyle">
			 <tr  valign="MIDDLE" >
				 <td>
           	<s:a action="company_saveUI"><img src="${pageContext.request.contextPath}/style/blue/images/button/addNew.PNG" /></s:a>
			</td>
			<td>
				 </td>
			</tr>
			</table>
        </div>
	</div>
	</div>
	
	<!-- 分页信息 -->
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	
</s:form>
</body>
</html>
