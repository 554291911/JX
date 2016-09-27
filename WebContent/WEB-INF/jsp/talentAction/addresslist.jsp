<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
<html>
<title>通讯录</title>
  <body>
   <s:form action="address_list">
   <div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 通讯录
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
						请输入通讯录名关键字 ：<s:textfield name="addressword"  cssClass="InputStyle2" />
						请输入员工姓名关键字 ：<s:textfield name="nameword"  cssClass="InputStyle2" />
						<input type="IMAGE" src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
					</table>
				</div>
			</div>
<div id="MainArea">

    <table cellspacing="0" cellpadding="0" class="TableStyle">    
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
				<td>通讯录</td>
				<td>上传时间</td>
				<td>员工姓名</td>
                <td>其他操作</td>
            </tr>
			
        </thead>
		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" >
        	<s:iterator value="recordList">
			<tr class="TableDetail1 template" align="CENTER" valign="MIDDLE">
				<td>${addressName }</td>
				<td>${time }</td>
				<td>${name }</td>
				<td><s:a action="address_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除通讯录</s:a>
				<a href="word/${addressName }" onclick="return confirm('确定要下载吗？')">下载通讯录</a>
				</td>
			</tr>
				
			</s:iterator>
        </tbody>
    </table>
  </div> 
    <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
		<table border="0" cellspacing="0" cellpadding="0" height="100%" >
			 <tr  valign="MIDDLE" >
				 <td>
				 <s:a action="address_uploadUI.action">上传通讯录</s:a>
			</td>	
			</tr>
			</table>
        </div>
	</div>
	<%@ include  file="/WEB-INF/jsp/public/pageView.jspf"%>
	
</s:form>
</body>
</html>
