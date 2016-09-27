<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>经营指标统计</title>

<%@ include file="/WEB-INF/jsp/public/commons.jspf"%>

</head>
<BODY>

	<!-- 标题显示 -->
	<DIV ID="Title_bar">
		<DIV ID="Title_bar_Head">
			<DIV ID="Title_Head"></DIV>
			<DIV ID="Title">
				<!--页面标题-->
				<IMG BORDER="0" WIDTH="13" HEIGHT="13"
					SRC="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				上传经营指标统计
			</DIV>
			<DIV ID="Title_End"></DIV>
		</DIV>
	</DIV>

	<!--显示表单内容-->
	<DIV ID=MainArea>
			<s:form action="indicator_upload" method="post"
									enctype="multipart/form-data">
			<DIV CLASS="ItemBlock_Title1">
				<!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 文件属性</DIV>  -->
			</DIV>

			<!-- 表单内容显示 -->
			<DIV CLASS="ItemBlockBorder">
				<DIV CLASS="ItemBlock">
					<TABLE CELLPADDING="0" CELLSPACING="0" CLASS="mainForm">
						<TR>
							<TD WIDTH="100">上传</TD>
							<TD>
							
									<s:file name="indicator"></s:file>
								
							</TD>
						</TR>
					</TABLE>
				</DIV>
			</DIV>

			<!-- 表单操作 -->
			<DIV ID="InputDetailBar">
				<INPUT TYPE="image"
					SRC="${pageContext.request.contextPath}/style/images/save.png" /> <A
					HREF="javascript:history.go(-1);"><IMG
					SRC="${pageContext.request.contextPath}/style/images/goBack.png" /></A>
			</DIV>
		</s:form>
	</DIV>
</BODY>
</html>
