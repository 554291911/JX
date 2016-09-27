<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
	<title>修改密码</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link   type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link   type="text/css" href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
   <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <script type="text/javascript">
    function validatePWD(){
    	var txtPwd = $("#txtPwd");
    	var txtPwd2 = $("#txtPwd2");
    	if(txtPwd.val() != txtPwd2.val()){
    		alert("两次密码输入不一致请重新输入");
    	}
    	else{
    		$("div3").text("");
    	}
    }
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 编辑用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="user_editpassword.action">
    <s:hidden name="id"></s:hidden>
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="table table-bordered">
                    <tr>
                    <td colspan="2"><font color="red"><s:actionerror/></font></td>
                    </tr>
                    <tr><td>旧密码</td>
                        <td><input type="password" name="password" class="InputStyle"/> 
						</td>
						
                    </tr>
                    <tr><td>新密码</td>
                        <td><input type="password" name="newpassword" class="InputStyle" id="txtPwd"/></td>
                    </tr>
					<tr><td>确认新密码</td>
                        <td><input type="password" name="confirmpassword" class="InputStyle" id="txtPwd2" onblur="validatePWD()"/></td>
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

