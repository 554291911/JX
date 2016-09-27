<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>查看职位</title>
<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>
</head>
<s:form action="job_list.action">
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				查看职位
			</div>
			<div id="Title_End"></div>
		</div>
	</div>
<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
		<s:select  name="statusType" headerKey="" headerValue="请选择状态" 
		 list="{'全部','发布', '关闭'}"/>  
		<s:select  name="degreeType" headerKey="" headerValue="请选择紧急程度" 
		 list="{'★', '★★', '★★★', '★★★★', '★★★★★'}"/>  
		 请输入客户关键字 ： <s:textfield name="companyType"></s:textfield>
		<input type="IMAGE" src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
					</table>
				</div>
			</div>
	<div id="MainArea">

		<table cellspacing="0" cellpadding="0" class="TableStyle">
			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td>岗位名称</td>
					<td>客户</td>
					<td>紧急程度</td>
					<td>工作地点</td>
					<td>待遇状况</td>
					<td>状态</td>
					<td>发布日期</td>
					<td>其他操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer">
			<s:iterator value="recordList">
				<tr class="TableDetail1 template" align="CENTER" valign="MIDDLE">
					<td>${jobName }</td>
					<td>${companyName }</td>
					<td>${emergencyDegree }</td>
					<td>${workingPlace }</td>
					<td>${treatment }</td>
					<td>${status }</td>
					<td >${releaseDate }</td>
					<td>
						<div class="listyle">
							<s:a action="job_scheduleUI?id=%{id}">查看职位进度</s:a>&nbsp;
							<s:a action="job_detailUI?id=%{id}">查看职位描述</s:a>&nbsp;
							<s:a action="job_editUI?id=%{id}">编辑职位信息</s:a>&nbsp;
							<s:a action="job_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
						</div>
					</td>
				</tr>
				</s:iterator>
			</tbody>
		</table>

    <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
		<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left" class="TableStyle">
			 <tr valign="MIDDLE" >
				 <td>
           <s:a action="job_saveUI"><img src="${pageContext.request.contextPath}/style/blue/images/button/addNew.PNG" /></s:a>
			</td>
			<td>
			
		<%-- 	
			<s:form name="">
			<s:select headerKey="" headerValue="请选择查询内容" name="companyname" 
         list=""/>  
							<s:select headerKey="" headerValue="请选择查询内容" name="status" 
         list=""/>  
						<input name="Submit" type="submit" value="查询">
			</s:form> 
			--%>
				 </td>
			
			</tr>
			</table>
        </div>
	</div>
	</div>
	<!-- 分页信息 -->
	<%@ include file="/WEB-INF/jsp/public/pageView.jspf"%>
</s:form>
</body>
</html>

