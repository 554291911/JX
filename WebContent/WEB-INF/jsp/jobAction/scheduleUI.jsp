<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>职位进度</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	<link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
 
</head>

<script>
$(document).ready(function(){
	var $statusSelect = $("#status");
	if( $statusSelect.val() == "关闭" ){
		$("#btn").hide();
		$statusSelect.attr("disabled",true);
	}
});
</script>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 职位进度
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="job_schedule.action">
    	<s:hidden name="id"></s:hidden>       
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
			<table class="table table-bordered"  >
			
				<thead>
				<tr align="CENTER" valign="MIDDLE">
					<td>岗位名称</td>
					<td>客户</td>
					<td>状态</td>
					</tr>
				</thead>
				<tr  align="CENTER" valign="MIDDLE">
					<td>${jobName }</td>
					<td>${companyName }</td>
					<td>
						<s:select headerKey=""  name="status" 
						   list="{'发布', '关闭'}"/>  
					</td>
			</tr>
			<thead>
      <th colspan="3"> 面试情况  <input type="button" value="增加" onClick="addMore()" id="btn"/>
		</th>
        </thead>

			</table>	
			<table class="table table-bordered" id="tab" cellpadding="0" cellspacing="0" >
     
      <tr align="center">
        <td >面试候选人</td>
        <td >面试结果</td>
		<td >面试周期</td>
      </tr>
      <tbody id="more">
	 <s:iterator value="jobProgresses">
	 <tr>
	<td> ${candidate }</td>
	 <td> ${result }</td>
	 <td> ${startTime }&nbsp;&nbsp;到&nbsp;&nbsp;${endTime }</td>
	 </tr>
	 </s:iterator>
      </tbody>
</table>
			
	</div>
</div>
 					<!-- 表单操作 -->
        <div id="InputDetailBar">
            <button type="submit" class="btn btn-default">提交</button>
            <a href="javascript:history.go(-1);"><button type="button" class="btn btn-default" >返回</button></a>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">        
function addMore()
{

	var tbody = document.getElementById("more");
	
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
	td1.innerHTML = "<td ><input type='text'name='candidate' class='InputStyle2'></td>";
	tr.appendChild(td1);
	var td2 = document.createElement("td");
	td2.innerHTML = "<td ><input type='text' name='result' class='InputStyle2'></td>";
	tr.appendChild(td2);
	var td3 = document.createElement("td");
	td3.innerHTML = "<input type='text' name='startTime'>&nbsp;&nbsp;到&nbsp;&nbsp;<input type='text' name='endTime'>&nbsp;";
	var button = document.createElement("input");
	tr.appendChild(td3);
	td3.appendChild(button);
    
	
	
	button.type = "button";
	button.value = "删除";
    button.onclick = function()
    {
        tr.removeChild(td1);
        tr.removeChild(td2);
        tr.removeChild(td3);
        
    }
   tbody.appendChild(tr);
	
}

</script>

</html>
