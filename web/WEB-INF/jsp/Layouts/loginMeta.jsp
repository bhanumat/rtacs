<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url var="favicon" value="/Content/Images/favicon.ico"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><spring:eval expression="@propertyConfigurer.getProperty('application.Title')" /></title>
<link rel="shortcut icon" href="${favicon}" />

<meta name="description" content="User login page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/font-awesome.min.css" />

<!-- text fonts -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace.min.css" />

<!--[if lte IE 9]>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-part2.min.css" />
<![endif]-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="${pageContext.request.contextPath}/Content/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lte IE 8]>
<script src="${pageContext.request.contextPath}/Content/assets/js/html5shiv.js"></script>
<script src="${pageContext.request.contextPath}/Content/assets/js/respond.min.js"></script>
<![endif]-->


<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/Content/assets/js/jquery.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script src='${pageContext.request.contextPath}/Content/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement)
        document.write("<script src='${pageContext.request.contextPath}/Content/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="${pageContext.request.contextPath}/Content/assets/js/bootstrap.min.js"></script>