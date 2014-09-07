<%-- 
    Document   : footer
    Created on : Mar 1, 2014, 11:42:57 PM
    Author     : ITOS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/content/images/callcenter.png" var="imgCallcenter"/>
<div class="footer-inner">
    <!-- #section:basics/footer -->
    <div class="footer-content">
        <spring:eval expression="@propertyConfigurer.getProperty('application.Footer')" /> <spring:eval expression="@propertyConfigurer.getProperty('application.Version')" />
        
        <%--<br />-->
        <!--<spring:eval expression="@propertyConfigurer.getProperty('application.Recommended')" />--%>
    </div>

    <!-- /section:basics/footer -->
</div>
    
   