<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<html>
<head>
	<title>突发事件流转</title>
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 突发事件流转
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table  class="table table-bordered" >
				<thead><h3 align="center">突发事件流转表</h3></thead>.
                	<tr align="CENTER" valign="MIDDLE">		
						<td >时间</td>              
                  		<td>发起人</td>    
						<td>接收人</td>  
                    </tr>
                    <s:iterator value="userForTransfers">
                   <tr align="CENTER" valign="MIDDLE">	
					<td>${time }</td> 
					 <td>${Promoter }</td>
					 <td>${recipient }</td>
					</tr>
					</s:iterator>
                 <tr align="CENTER" valign="MIDDLE">	
				 <td >科目</td>
                        <td colspan="2">${subject }</td>
                    </tr>
                     <tr align="CENTER" valign="MIDDLE">	
					 <td>事件及情况描述</td>
                        <td colspan="2">${description }</td>
                    </tr>
                     <tr align="CENTER" valign="MIDDLE">	
					 <td>解决方案及执行人</td>
                        <td colspan="2">
					${solutionAndImpl }
						</td>
                    </tr>
                 <tr align="CENTER" valign="MIDDLE">	
					<td>事件处理结果反馈</td>
                        <td colspan="2">${feedback }</td>
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

