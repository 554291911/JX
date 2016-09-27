<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head> 
	<title>编辑人才信息</title>
	<%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
	<link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
	 
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 编辑人才信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="talent_edit.action" method="post"  enctype="multipart/form-data" > 
    <s:hidden name="id"></s:hidden> 
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
          <table class="table table-bordered" >
   <thead align="left">
  <th colspan="3">
  个人资料
  </th>     
	</thead>
      <tr>
         <td  colspan="2">姓名:<s:textfield name="name"/></td>
		 <td rowspan="7"><label class="control-label">${ photoUrl}</label><s:file name="photo"></s:file></td>
      </tr>
      <tr><td>婚姻状况:
         <s:radio list="{'已婚','未婚','离异', '其他'}" name="isMarried"/>
		 </td>
		 <td>有无子女 ：
		 <s:radio list="{'有子女','无子女'}" name="hasChildren"/></td>
		 </tr>
      <tr>
         <td>出生年月:
         <s:textfield name="birthday"/>
         <td>岗位级别:
         <s:select headerKey="" headerValue="请选择" name="postLevel" 
         list="{'A+', 'A', 'A-', 'B+', 'B', 'B-', 'C', 'D'}"/>  
		 </td>
	
      </tr>
	  <tr>
         <td>性别:
          <s:radio list="{'男','女'}" name="sex"/>
         <td>联系电话:
         <s:textfield name="phoneNumber" />
      </tr>
      <tr>
         <td>第一学历:
          <s:select headerKey="" headerValue="请选择" name="firstDegree" 
         list="{'小学', '初中', '高中', '专科', '本科', '硕士研究生', '博士研究生', '博士后'}"/>  
         </td>
         <td>最高学历:
          <s:select headerKey="" headerValue="请选择" name="highestDegree" 
         list="{'小学', '初中', '高中', '专科', '本科', '硕士研究生', '博士研究生', '博士后'}"/>  
		</td>
      </tr>
	   <tr>
        <td>现任职位:<s:textfield name="position"/></td>
         <td >邮&nbsp;&nbsp;箱:
         <s:textfield name="email" cssClass="InputStyle"/>
         </td>
      </tr>
	  <tr>
         <td colspan="2">现所在地: <s:textarea name="address" cols="80" rows="1"></s:textarea>
      </tr>
	   <thead>
  <th  colspan="3">
  教育经历
  </th>     
	</thead>
	<tr>
	<td colspan="3">
	<s:textarea name="eduExperience" cols="160" rows="5"></s:textarea>
	</td>
	</tr>
	  <thead>
  <th  colspan="3">
  工作经历 <input type="button" value="增加" onClick="addMore()"/>
  </th>     
	</thead>
   	<tr>
    <td>工作时间</td>
	<td>所在公司</td>
	<td>所在职位</td>
		</tr>
   
   <tbody id="more">
  		<s:iterator value="jobExperiences">
							<tr id="${id }">
								<td><input  type='text' name='startDate' value="${startDate }" />至
									<input type='text' name='endDate' value="${ endDate}" /></td>
								<td><input type='text' name='company' class='InputStyle' value="${company }"/></td>
								<td><input type='text' name='job' class='InputStyle delete'  value="${job }"/>&nbsp<input type="button" value="删除"
									onclick="del_tr(${id});" /></td>
							</tr>
						</s:iterator>
  </tbody>
	<thead>
  <th colspan="3">
  期望职位
  </th>     
	</thead>
	<tr>
	<td colspan="3">
	<s:textarea name="hopeJob" cols="160" rows="5"></s:textarea>
	</td>
	</tr>
	<thead>
  <th colspan="3">
  待遇水平
  </th>     
	</thead>
	<tr>
	<td colspan="3">
	<s:textarea name="treatmentLevel" cols="160" rows="5"></s:textarea>
	</td>
	</tr>
	<thead>
  <th colspan="3">
  期望待遇
  </th>     
	</thead>
	<tr>
	<td colspan="3">
	<s:textarea name="hopeTreatment" cols="160" rows="5"></s:textarea>
	</td>
	</tr>
	<thead>
  <th colspan="3">
  整体评价
  </th>     
	</thead>
	<tr>
	<td colspan="3">
	<s:textarea name="description" cols="160" rows="5"></s:textarea>
	</td>
	</tr>
		<thead>
  <th colspan="3">
  简历
  </th>
  </thead>
       <tr>
	   <td colspan="1"><label class="control-label">${oldResumeName }</label><s:file name="oldResume"></s:file></td>
	   <td colspan="2"><s:file name="standardResume"><label class="control-label">${standardResumeName }</label></s:file></td>
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
<script type="text/javascript">  
function del_tr(id){
	var tr = document.getElementById(id);
    tr.parentNode.removeChild(tr);
}
function addMore()
{

	var tbody = document.getElementById("more");
	
    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
	td1.innerHTML = "<input type='text' name='startDate'/> 至 <input type='text' name='endDate'/>";
	tr.appendChild(td1);
	var td2 = document.createElement("td");
	td2.innerHTML = "<input type='text' name='company' class='InputStyle'/>";
	tr.appendChild(td2);
	var td3 = document.createElement("td");
	td3.innerHTML = "<input type='text' name='job' class='InputStyle'/>&nbsp;";
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
