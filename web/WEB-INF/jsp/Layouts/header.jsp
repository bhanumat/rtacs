<%-- 
    Document   : header
    Created on : Mar 1, 2014, 11:42:17 PM
    Author     : ITOS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="rtaIcon" value="/Content/Images/rta_icon.png"/>
<c:url value="/j_spring_security_logout" var="urlLogout"/>

<!-- #section:basics/navbar.layout -->
<div id="navbar" class="navbar navbar-default navbar-collapse h-navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed');
        } catch (e) {
        }
    </script>


    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <!-- #section:basics/navbar.layout.brand -->
            <a href="#" class="navbar-brand">
                <img src="${rtaIcon}">
                <small>
                    <spring:eval expression="@propertyConfigurer.getProperty('application.Banner')" />
                </small>
            </a>

            <!-- /section:basics/navbar.layout.brand -->

            <!-- #section:basics/navbar.toggle -->
            <button class="pull-right navbar-toggle navbar-toggle-img collapsed" type="button" data-toggle="collapse" data-target=".navbar-buttons,.navbar-menu">
                <span class="sr-only">Toggle user menu</span>
                <img src="${pageContext.request.contextPath}/Content/assets/avatars/user.jpg" alt="Jason's Photo" />
            </button>

            <button class="pull-right navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".sidebar">
                <span class="sr-only">Toggle sidebar</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>
            </button>

            <!-- /section:basics/navbar.toggle -->
        </div>

        <!-- #section:basics/navbar.dropdown -->
        <div class="navbar-buttons navbar-header pull-right  collapse navbar-collapse" role="navigation">
            <ul class="nav ace-nav">
                <!-- #section:basics/navbar.user_menu -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="${pageContext.request.contextPath}/Content/assets/avatars/avatar2.png" alt="${userName}" />
                        <span class="user-info">
                            <small>Welcome,</small>
                            ${userName}
                        </span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-cog"></i>
                                Settings
                            </a>
                        </li>

                        <li>
                            <a href="profile.html">
                                <i class="ace-icon fa fa-user"></i>
                                Profile
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="${urlLogout}">
                                <i class="ace-icon fa fa-power-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- /section:basics/navbar.user_menu -->
            </ul>
        </div>

        <!-- /section:basics/navbar.dropdown -->
        <nav role="navigation" class="navbar-menu pull-left collapse navbar-collapse">
            <!-- #section:basics/navbar.nav -->
            <ul class="nav navbar-nav">
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        System Management
                        &nbsp;
                        <i class="ace-icon fa fa-angle-down bigger-110"></i>
                    </a>

                    <ul class="dropdown-menu dropdown-light-blue dropdown-caret">
                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-user bigger-110 blue"></i>
                                Users
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-cog bigger-110 blue"></i>
                                Roles &amp; Permission
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- /section:basics/navbar.nav -->
        </nav>
    </div><!-- /.navbar-container -->

</div>

<!-- /section:basics/navbar.layout -->