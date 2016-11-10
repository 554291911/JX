<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>人才信息管理</title>
     <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
  </head>
 <body>
 <s:form action="talent_list">
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 人才信息管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
		<s:select  name="sexType" headerKey="" headerValue="请选择性别"
         list="{ '男', '女'}"/>  
		<s:select  name="levelType" headerKey="" headerValue="请选择岗位级别"
         list="{'A+', 'A', 'A-', 'B+', 'B', 'B-', 'C', 'D'}"/> 
          <s:select  name="firstDegreeType" headerKey="" headerValue="请选择第一学历"
         list="{'小学', '初中', '高中', '专科', '本科', '硕士研究生', '博士研究生', '博士后'}"/>  
						请输入现任职位关键字 ：<s:textfield name="jobCondition" cssClass="InputStyle2" /> 
						<%-- 请输入过往公司关键字 ：<s:textfield name="companyCondition"  cssClass="InputStyle2" /> --%>
						请输入目前公司关键字 ：<s:textfield name="ncompany"  cssClass="InputStyle2"/>
					</table>
				</div>
</div>
<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
						更新时间: <input type="date"  name="startTime" value="${ startTime}"/>
							    <input type="date"  name="endTime"  value="${endTime }"/>
						请输入个人特点关键字 ：<s:textfield name="character"  cssClass="InputStyle2" />
						请输入推荐职位关键字 ：<s:textfield name="nrecommend"  cssClass="InputStyle2" />
					</table>
				</div>
</div>
<div id="TableTail">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
						请输入操作人关键字 ：<s:textfield name="operator"  cssClass="InputStyle2" />
						<input type="IMAGE" src="${pageContext.request.contextPath}/style/blue/images/button/submit.PNG" align="ABSMIDDLE"/>
					</table>
				</div>
</div>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td >姓名</td>
				<td >性别</td>
                <td  >岗位级别</td>
                <td >出生日期</td>
				<td >第一学历</td>
				<!-- <td>过往公司</td> -->
				<td>目前公司</td>
				<td >现任职位</td>
				<td>推荐职位</td>
				<td>沟通完结情况</td>
				<td >个人特点</td>
				<td >操作人</td>
				<td>最后更新时间</td>
				<td >其他操作</td>
            </tr>
			
        </thead>

		<!--显示数据列表-->
		
        <tbody id="TableData" class="dataContainer">
        	<s:iterator value="recordList">
			<tr class="TableDetail1 template" align="CENTER" valign="MIDDLE">
				<td>${name }</td>
				<td>${sex }</td>
				<td>${postLevel }</td>
				<td>${birthday }</td>
				<td>${firstDegree }</td>
				<td>
				${company }
				</td>
				<%-- <s:iterator value="jobExperiences">
					${company }
					<br />
				</s:iterator> --%>
				<td>${position }</td>
				<td>${recommend }</td>
				<td>${isCommunicate }</td>
				<td>${disposition }</td>
				<td>${creator }</td>
				<td>${modified }</td>
				<td><s:a action="talent_detailUI?id=%{id}">查看详细</s:a>&nbsp;
					<s:a action="talent_editUI?id=%{id}">编辑</s:a>&nbsp;
					<%-- <s:a action="talent_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a> --%>
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
           <s:a action="talent_saveUI"><img src="${pageContext.request.contextPath}/style/blue/images/button/addNew.PNG" /></s:a>
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
