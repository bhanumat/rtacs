<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:url value="/j_spring_security_check" var="urlSecurity"/>
<c:url var="rtaIcon" value="/Content/Images/rta_icon.png"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <tiles:insertAttribute name="meta"/>
    </head>
    <body class="login-layout light-login">
        <div class="main-container">
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

                    </div>

                </div><!-- /.navbar-container -->

            </div>

            <!-- /section:basics/navbar.layout -->

            <!-- #.main-content -->
            <div class="main-content">

                <!-- #.row -->
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="login-container">
                            <div class="center">
                                <div style="height: 80px;"></div>
                            </div>

                            <div class="space-6"></div>

                            <div class="position-relative">
                                <div id="login-box" class="login-box visible widget-box no-border">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <h4 class="header blue lighter bigger">
                                                <i class="ace-icon fa fa-coffee green"></i>
                                                Please Enter Your Information
                                            </h4>
                                            <span class="red">${error}</span>                                            
                                            <div class="space-6"></div>

                                            <form id="formReport" name="formReport" action="${urlSecurity}" method="post">
                                                <fieldset>
                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input id="j_username" name="j_username" type="text" tabindex="1" required class="form-control" placeholder="Username" />
                                                            <i class="ace-icon fa fa-user"></i>
                                                        </span>
                                                    </label>

                                                    <label class="block clearfix">
                                                        <span class="block input-icon input-icon-right">
                                                            <input id="j_password" name="j_password" type="password" tabindex="2" required class="form-control" placeholder="Password" />
                                                            <i class="ace-icon fa fa-lock"></i>
                                                        </span>
                                                    </label>

                                                    <div class="space"></div>

                                                    <div class="clearfix">
                                                        <label class="inline">
                                                            <input tabindex="3" type="checkbox" class="ace" />
                                                            <span class="lbl"> Remember Me</span>
                                                        </label>

                                                        <button id="btnSignIn" type="submit" tabindex="4" class="width-35 pull-right btn btn-sm btn-primary">
                                                            <i class="ace-icon fa fa-key"></i>
                                                            <span class="bigger-110">Login</span>
                                                        </button>
                                                    </div>

                                                    <div class="space-4"></div>
                                                </fieldset>
                                            </form>
                                        </div><!-- /.widget-main -->
                                    </div><!-- /.widget-body -->
                                </div><!-- /.login-box -->

                            </div><!-- /.position-relative -->
                        </div>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.main-content -->

            <!-- #.footer -->

            <div class="center">
                <div style="height: 80px;"></div>
                <tiles:insertAttribute name="footer"/>     
            </div>
            <!-- /.footer -->
        </div><!-- /.main-container -->    
        <script type="text/javascript">
            jQuery(function($) {
                //$('body').attr('class', 'login-layout');
                $('body').css({'background-color': '#ffffff'});
                $('body').css('background-image', 'none');
            });
        </script>
    </body>
</html>
