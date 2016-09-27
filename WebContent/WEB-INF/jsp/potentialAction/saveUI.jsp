<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
<head>
	<title>新建潜在客户信息</title>
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 新建潜在客户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
	 <s:form action="potential_save.action" >
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table  class="table table-bordered" >
               
              	<h3 align="center">客户信息</h3>
	
                	<tr align="CENTER" valign="MIDDLE">	
						<td >猎头顾问</td>
                        <td><s:textfield name="headHunting" cssClass="InputStyle2"></s:textfield></td>              
                  		<td>发起时间</td>
                        <td><input type="text" name="startTime"/></td>
                    </tr>
                    
                 <tr align="CENTER" valign="MIDDLE"><td >潜在客户名称</td>
                        <td colspan="3"><s:textfield name="name"  cssClass="InputStyle2"></s:textfield></td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE">		
					<td>公司简介</td>
                        <td colspan="3">
						<s:textarea cols="150" rows="5" name="introduction" ></s:textarea>
						</td>
                    </tr align="CENTER" valign="MIDDLE">
                     <tr align="CENTER" valign="MIDDLE">		
					 <td>招聘岗位</td>
                        <td colspan="3">
						<s:textarea cols="150" rows="2" name="recruitment" ></s:textarea>
						</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE"><td>初次联系时间</td>
                        <td colspan="3"><input type="text" name="firstContactTime"  ></td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE"><td>联系人</td>
                        <td colspan="3"><s:textfield name="contactPerson" cssClass="InputStyle2"></s:textfield></td>
                    </tr>
					<tr align="CENTER" valign="MIDDLE"><td>联系方式</td>
                        <td colspan="3"><s:textfield name="contactInformation" cssClass="InputStyle2"></s:textfield></td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE"><td>初次联系情况</td>
                        <td colspan="3">
						<s:textarea cols="150" rows="2" name="initialContactInformation" ></s:textarea>
						</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE"><td>存在难题</td>
                        <td colspan="3">
						<s:textarea cols="150" rows="2" name="problem" ></s:textarea>
						</td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE"><td>再次联系时间</td>
                        <td colspan="3"><input type="text" name="againContactTime" /></td>
                    </tr>
                    <tr align="CENTER" valign="MIDDLE"><td>再次联系情况</td>
                        <td colspan="3">
						<s:textarea cols="150" rows="2" name="againContactInformation" ></s:textarea>
						</td>
                    </tr>
                    
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
