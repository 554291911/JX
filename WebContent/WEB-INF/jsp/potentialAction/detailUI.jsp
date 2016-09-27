<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
<head>
	<title>潜在客户信息</title>
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
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 潜在客户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table  class="table table-bordered" >
                	<tr align="CENTER" valign="MIDDLE">		
						<td>猎头顾问</td>
                        <td>${headHunting }</td>              
                  		<td>发起时间</td>
                        <td>${startTime }</td>
                    </tr>
                    
                <tr align="CENTER" valign="MIDDLE">		
				 <td >潜在客户名称</td>
                        <td colspan="3">${name }</td>
                    </tr>
                     <tr align="CENTER" valign="MIDDLE">		
					 <td>公司简介</td>
                        <td colspan="3">
						${introduction }
						</td>
                    </tr>
                     <tr align="CENTER" valign="MIDDLE">		
					 <td>招聘岗位</td>
                        <td colspan="3">
						${recruitment }
						</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE">		
					<td>初次联系时间</td>
                        <td colspan="3">${firstContactTime }</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE">		<td>联系人</td>
                        <td colspan="3">${contactPerson }</td>
                    </tr>
					<tr align="CENTER" valign="MIDDLE">		<td>联系方式</td>
                        <td colspan="3">${contactInformation }</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE">		<td>初次联系情况</td>
                        <td colspan="3">
						${initialContactInformation }
						</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE">		<td>存在难题</td>
                        <td colspan="3">
						${problem }
						</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE">		<td>再次联系时间</td>
                        <td colspan="3">${againContactTime }</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE">		<td>再次联系情况</td>
                        <td colspan="3">
					${againContactInformation }
						</td>
                    </tr>
                    
                </table>
   </div>
 </div>       
        <!-- 表单操作 -->
         <div id="InputDetailBar">
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
        </div>
</div>

</body>
</html>
