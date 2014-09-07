<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="favicon" value="/Content/Images/favicon.ico"/>
<c:url value="/Pages/Home.htm" var="urlHome"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title><spring:eval expression="@propertyConfigurer.getProperty('application.Title')" /></title>
<link rel="shortcut icon" href="${favicon}" />

<meta name="description" content="<spring:eval expression="@propertyConfigurer.getProperty('application.Title')" />" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
