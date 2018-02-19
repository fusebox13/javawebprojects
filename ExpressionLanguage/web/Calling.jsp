<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("name", "fred_pageContext from Calling JSP");
    request.setAttribute("name", "fred_request");
    session.setAttribute("name", "fred_session");
    application.setAttribute("name", "fred_application");
%>
<jsp:forward page="JSP_Test.jsp"/> 