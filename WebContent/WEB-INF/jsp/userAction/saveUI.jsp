<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
	<title>用户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link   type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link   type="text/css" href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
   <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <script type="text/javascript">
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="user_save.action">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="table table-bordered">
                   <tr><td colspan="2"><font color="red"><s:actionerror/></font></td></tr>
                    <tr><td>登录名</td>
                        <td><s:textfield name="loginName" cssClass="InputStyle"/> *（登录名要唯一）
						</td>
						
                    </tr>
                    <tr><td>姓名</td>
                        <td><s:textfield name="name" cssClass="InputStyle"/> *</td>
                    </tr>
					<tr><td>性别</td>
                        <td><s:radio list="{'男','女'}" name="sex"/>
						</td>
                    </tr>
                    <tr><td>电话号码</td>
                        <td><s:textfield name="phoneNumber" cssClass="InputStyle"/></td>
                    </tr>
                    <tr><td>备注</td>
                        <td><s:textarea name="description" cols="160" rows="5" cssClass="InputStyle"></s:textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
           <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td width="100">岗位</td>
                        <td>
                        	<s:select name="roleIds" cssClass="SelectStyle"
                        		multiple="true" size="10" 
                        		list="#roleList" listKey="id" listValue="name"
                        	/>
							按住Ctrl键多选或取消选择
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

