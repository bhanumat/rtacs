<%-- 
    Document   : PAY010.jsp รายการรับชำระเงินค่าบำรุงศพ 
    Created on : Sep 7, 2014, 5:22:26 PM
    Author     : bhanumat.w
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>กองการฌาปนกิจ สก.ทบ.</title>

		<meta name="description" content="top menu &amp; navigation" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="../assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="../assets/css/jquery-ui.min.css" />
		<link rel="stylesheet" href="../assets/css/chosen.css" />
		<link rel="stylesheet" href="../assets/css/datepicker.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-timepicker.css" />
		<link rel="stylesheet" href="../assets/css/daterangepicker.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-datetimepicker.css" />
		<link rel="stylesheet" href="../assets/css/colorpicker.css" />
        <link rel="stylesheet" href="../assets/css/flora.calendars.picker.css" />
        <link rel="stylesheet" href="../assets/css/jquery-ui-1.10.3.custom.css" />
 	    <link rel="stylesheet" href="../assets/css/SpecialDateSheet.css" />


		<!-- text fonts -->
		<link rel="stylesheet" href="../assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="../assets/css/ace.min.css" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="../assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="../assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="../assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="../assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="../assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="../assets/js/html5shiv.js"></script>
		<script src="../assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		<div id="navbar" class="navbar navbar-default    navbar-collapse       h-navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="#" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							กองการฌาปนกิจ สก.ทบ.
						</small>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->
					<button class="pull-right navbar-toggle navbar-toggle-img collapsed" type="button" data-toggle="collapse" data-target=".navbar-buttons,.navbar-menu">
						<span class="sr-only">Toggle user menu</span>

						<img src="../assets/avatars/user.jpg" alt="Jason's Photo" />
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
						<li class="light-blue user-min">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									Jason
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
									<a href="#">
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
								Overview
	  		&nbsp;
								<i class="ace-icon fa fa-angle-down bigger-110"></i>
							</a>

							<ul class="dropdown-menu dropdown-light-blue dropdown-caret">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-eye bigger-110 blue"></i>
										Monthly Visitors
									</a>
								</li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-user bigger-110 blue"></i>
										Active Users
									</a>
								</li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog bigger-110 blue"></i>
										Settings
									</a>
								</li>
							</ul>
						</li>
					</ul>

					<!-- /section:basics/navbar.nav -->

					<!-- #section:basics/navbar.form -->

					<!-- /section:basics/navbar.form -->
				</nav>
			</div><!-- /.navbar-container -->
		</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar.horizontal -->
			<div id="sidebar" class="sidebar      h-sidebar                navbar-collapse collapse">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>

						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

                <ul class="nav nav-list">
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-users"></i> <span class="menu-text"> ข้อมูลสมาชิก </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 250px;">
                      <li class="hover"> <a href="QRY010.html"> <i class="menu-icon fa fa-caret-right"></i> เรียกค้นข้อมูลสมาชิก <b class="arrow"></b> </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="QRY020.html"> <i class="menu-icon fa fa-caret-right"></i> เรียกค้นข้อมูลสมาชิกโดยละเอียด </a> <b class="arrow"></b> </li>
                    </ul>
                  </li>
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-list"></i> <span class="menu-text"> รับสมัคร </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 250px;">
                     <li class="hover"> <a href="APP010.html"> <i class="menu-icon fa fa-caret-right"></i> รายการผู้สมัครเป็นสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="APP010-2.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกผู้สมัครเป็นสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="APP031.html"> <i class="menu-icon fa fa-caret-right"></i> ขอความเห็นชอบสมาชิกใหม่ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="APP040.html"> <i class="menu-icon fa fa-caret-right"></i> กำหนดเลขทะเบียนสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="APP041.html"> <i class="menu-icon fa fa-caret-right"></i> ขออนุมัติขึ้นทะเบียนสมาชิกใหม่ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="APP043.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันอนุมัติขึ้นทะเบียนสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="APP044.html"> <i class="menu-icon fa fa-caret-right"></i> พิมพ์ทะเบียนสมาชิก ก.ฌ. ๔ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="APP051.html"> <i class="menu-icon fa fa-caret-right"></i> จัดพิมพ์บัตรคุมเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="APP052.html"> <i class="menu-icon fa fa-caret-right"></i> จัดพิมพ์บัตรคุมการโอนย้ายหน่วย </a> <b class="arrow"></b> </li>                      
                      <li class="hover"> <a href="APP101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปผู้สมัครสมาชิก </a> <b class="arrow"></b> </li>
                    </ul>
                  </li>
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-pencil-square-o"></i> <span class="menu-text"> เปลี่ยนแปลงข้อมูล </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 290px;">
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> เปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 305px;">
                          <li class="hover"> <a href="CHT010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการเปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHT030.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการเปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHT101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกขอเปลี่ยนแปลงข้อมูล </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> เปลี่ยนแปลงที่อยู่ <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 290px;">
                          <li class="hover"> <a href="CHA010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการเปลี่ยนแปลงที่อยู่ </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHA030.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการเปลี่ยนแปลงที่อยู่ </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHA101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกขอเปลี่ยนแปลงที่อยู่ </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> เปลี่ยนแปลงผู้รับเงินสงเคราะห์ <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 305px;">
                          <li class="hover"> <a href="CHH010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกเปลี่ยนแปลงผู้รับเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHH030.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการเปลี่ยนแปลงผู้รับเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHH101.html"> <i class="menu-icon fa fa-caret-right"></i> รายการสรุปสมาชิกขอเปลี่ยนแปลงผู้รับเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> เปลี่ยนแปลงประเภทการชำระเงิน <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 305px;">
                          <li class="hover"> <a href="CHP010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการเปลี่ยนแปลงประเภทการชำระเงิน </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHP030.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกสาย ๖ ชำระเงินประเภทต่างๆ </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHP101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกขอเปลี่ยนแปลง </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> โอนย้ายหน่วยชำระเงิน <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 290px;">
                          <li class="hover"> <a href="CHD050.html"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการโอนย้ายหน่วยชำระเงิน </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHD060.html"> <i class="menu-icon fa fa-caret-right"></i> รายการโอนย้ายหน่วยของสมาชิกที่มีปัญหา </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHD040.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการเปลี่ยนแปลงหน่วยการชำระเงิน </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHD030.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการโอนหน่วยชำระเงิน </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CHD101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกโอนย้ายหน่วยชำระเงิน </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li class="active open hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-credit-card"></i> <span class="menu-text"> ชำระเงิน </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 290px;">
                      <li class="hover"> <a href="PAY021.html"> <i class="menu-icon fa fa-caret-right"></i> ชำระเงินค่าสมัครสมาชิก(สมัครผ่านหน่วย) </a> <b class="arrow"></b> </li> 
 <li class="hover"> <a href="PAY020.html"> <i class="menu-icon fa fa-caret-right"></i> รายการรับชำระเงินค่าสมัครสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="PAY020-1.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกรับชำระเงินค่าสมัครสมาชิก </a> <b class="arrow"></b> </li>
					  <li class="hover"> <a href="PAY010.html"> <i class="menu-icon fa fa-caret-right"></i> รายการรับชำระเงินค่าบำรุงศพ </a> <b class="arrow"></b> </li>
					  <li class="hover"> <a href="PAY010-1.html"> <i class="menu-icon fa fa-caret-right"></i>  บันทึกรับชำระเงินค่าบำรุงศพ </a> <b class="arrow"></b> </li>

					  <li class="hover"> <a href="PAY030.html"> <i class="menu-icon fa fa-caret-right"></i> รายการหักเงินค่าบำรุงศพผ่านธนาคาร</a> <b class="arrow"></b> </li>
					  <li class="hover"> <a href="PAY040.html"> <i class="menu-icon fa fa-caret-right"></i>  บันทึกการหักเงินค่าบำรุงศพผ่านธนาคาร </a> <b class="arrow"></b> </li>
					 
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการชำระเงิน <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 305px;">
                          <li class="hover"> <a href="CKP010.html"> <i class="menu-icon fa fa-caret-right"></i> ดูตรวจสอบรายชื่อสมาชิกค้างชำระ </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="CKP040.html"> <i class="menu-icon fa fa-caret-right"></i> แสดงรายชื่อสมาชิกที่ค้างชำระและได้ดำเนินการทวงถาม </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
					                            <li class="hover"> <a href="PYC101.html"> <i class="menu-icon fa fa-caret-right"></i> แสดงรายการการชำระเงินของหน่วย </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="PYC102.html"> <i class="menu-icon fa fa-caret-right"></i> รางานสรุปการชำระเงินผ่านหน่วย </a> <b class="arrow"></b> </li>
                    </ul>
                  </li>
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-exchange"></i> <span class="menu-text"> ถอนสภาพ/คืนสภาพ </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu">
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ถอนสภาพสมาชิกชั่วคราว <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 270px;">
                          <li class="hover"> <a href="RMT010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการถอนสภาพสมาชิกชั่วคราว </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RMT020.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการถอนสภาพสมาชิกชั่วคราว </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RMT030.html"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการถอนสภาพสมาชิกชั่วคราว </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RMT101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกถูกถอนสภาพชั่วคราว </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ถอนสภาพสมาชิกถาวร <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 270px;">
                          <li class="hover"> <a href="RMF010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการถอนสภาพสมาชิกถาวร </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RMF020.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการถอนสภาพสมาชิกถาวร </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RMF030.html"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการถอนสภาพสมาชิกถาวร </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RMF101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกถูกถอนสภาพถาวร </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> คืนสภาพสมาชิก <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 270px;">
                          <li class="hover"> <a href="RST010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการคืนสภาพสมาชิก </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RST020.html"> <i class="menu-icon fa fa-caret-right"></i> ดำเนินการคืนสภาพสมาชิก </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RST030.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการคืนสภาพสมาชิก </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RST040.html"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการถอนสภาพสมาชิกถาวร </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="RST101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกได้รับคืนสภาพ </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-bullhorn "></i> <span class="menu-text">แจ้งถึงแก่กรรม</span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 270px;">
                      <li class="hover"> <a href="FLD010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกข้อมูลถึงแก่กรรมของสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="FLD011.html"> <i class="menu-icon fa fa-caret-right"></i> ปรับปรุงการยกยอดศพ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="FLD020.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกข้อมูลยอดจ่ายเงินค่าจัดการศพ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="FLD030.html"> <i class="menu-icon fa fa-caret-right"></i> ดำเนินการขออนุมัติจ่ายเงินค่าจัดการศพ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="FLD040.html"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการอนุมัติจ่ายเงินค่าจัดการศพ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="FLD050.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกสถานะการยืนยันการจ่ายเงิน </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="FLD060.html"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบรายชื่อสมาชิกที่แจ้งถึงแก่กรรม </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="FLD101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกแจ้งถึงแก่กรรม </a> <b class="arrow"></b> </li>
                    </ul>
                  </li>
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-globe"></i> <span class="menu-text"> งานทั่วไป </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu">
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ออกบัตรสมาชิก <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 250px;">
                          <li class="hover"> <a href="MCB010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการออกบัตรสมาชิก </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="MCB101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปการขออกบัตรสมาชิก </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ขอใบแทนใบตอบรับ <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 250px;">
                          <li class="hover"> <a href="MCR010.html"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการขอใบแทนใบตอบรับ </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="MCR101.html"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปการขอใบแทนใบตอบรับ </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                      <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> บัญชีการคุมการชำระเงิน <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                        <ul class="submenu" style="width: 250px;">
                          <li class="hover"> <a href="APP053.html"> <i class="menu-icon fa fa-caret-right"></i> บัญชีคุมการคุมการชำระผ่านหน่วย </a> <b class="arrow"></b> </li>
                          <li class="hover"> <a href="APP054.html"> <i class="menu-icon fa fa-caret-right"></i> บัญชีคุมการคุมการชำระผ่านธนาคาร </a> <b class="arrow"></b> </li>
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-cogs"></i> <span class="menu-text">ระบบสมาชิก</span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 250px;">
                      <li class="hover"> <a href="SYS010.html"> <i class="menu-icon fa fa-caret-right"></i> กำหนดคุณสมบัติของระบบสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="SYS020.html"> <i class="menu-icon fa fa-caret-right"></i> ตัดยอดสมาชิก / กำหนดค่าบำรุงศพ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="SYS030.html"> <i class="menu-icon fa fa-caret-right"></i> ตั้งค่าหมวด / เลขที่ใบเสร็จ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="SYS040.html"> <i class="menu-icon fa fa-caret-right"></i> ปิดรายการตั้งหัก / สร้างรายการตั้งหักใหม่ </a> <b class="arrow"></b> </li>
                    </ul>
                  </li>
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-cog"></i> <span class="menu-text">ฐานข้อมูล</span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 250px;">
                      <li class="hover"> <a href="DBM001.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลส่วนตัวผู้ใช้ระบบ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM101.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลหน่วยต้นสังกัด </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM102.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลจังหวัด </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM103.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลคำนำหน้า </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM104.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลยศ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM110.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลธนาคาร </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM111.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลประเภทบัญชีธนาคาร </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM112.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลสาขาธนาคาร </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM301.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลเจ้าหน้าที่ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM401.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลแบบการรักษาความปลอดภัย </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM302.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลหน่วยงานในกองการฌาปนกิจฯ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM303.html"> <i class="menu-icon fa fa-caret-right"></i> ข้อมูลเครื่องคอมพิวเตอร์ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM500.html"> <i class="menu-icon fa fa-caret-right"></i> แก้ไข้ข้อมูลสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="DBM501.html"> <i class="menu-icon fa fa-caret-right"></i> แก้ไข้เลขบัตรประจำตัวประชาชน </a> <b class="arrow"></b> </li>
                    </ul>
                  </li>
                  <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-file-o"></i> <span class="menu-text">โปรแกรมใหม่</span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 305px;">
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปยอดสมาชิกที่ค้างชำระ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงาน กฌ.5 </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> ยกเลิกใบเสร็จ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปยอดสมาชิกที่ค้างชำระ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> ปรับสถานภาพสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> สร้างไฟล์ข้อมูลการหักบัญชีย้อนหลังส่งให้ธนาคาร </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานการหักเงินย้อนหลัง </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> หักธนาคารย้อนหลัง </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานการเข้าห้องเซร์ฟเวอร์ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> ปรับปรุงข้อมูลการเสียชีวิต </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> บัญชีรายชื่อผู้ขออนุมิขึ้นทะเบียนสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> บันชีรายชื่อหน่วยต้นสังกัดและจำนวนสมาชิกที่ขออนุมัติขึ้นทะเบียน </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> ย้ายหน่วยต้นสังกัดสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> สถานภาพสมาชิก </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> ปรับเลขที่ศพ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานการชำระเงินค่าบำรุงศพ ณ กฌป.สก.ทบ. </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานการทดรองจ่าย </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานการชำระเงินค่าบำรุงศพ ณ กฌป.สก.ทบ.  (ตามเวลา) </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบอายุผู้สมัคร </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> พิมพ์บัตรคุมเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> สรุปการชำระเงินในแต่ละงวดเดือน </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> เอกสารการจ่ายเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> สรุปรายละเอียดการชำระเงินสายควบคุมที่ ๑-๕ </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> เติมเงินค้างชำระคนถึงแก่กรรม </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> รายชื่อบัญชีจากไฟล์ส่งธนาคาร </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> ลบรายการชำระเงิน </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> ปรับเลขที่ศพสมาชิกถึงแก่กรรม </a> <b class="arrow"></b> </li>
                      <li class="hover"> <a href="#"> <i class="menu-icon fa fa-caret-right"></i> บัญชีตรวจสถานภาพสมาชิกประจำปี </a> <b class="arrow"></b> </li>
                    </ul>
                  </li>
                </ul>
                <!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>

			<!-- /section:basics/sidebar.horizontal -->
			<div class="main-content">
				<div class="page-content">
					<!-- #section:settings.box -->
					<div class="ace-settings-container" id="ace-settings-container">
						<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
							<i class="ace-icon fa fa-cog bigger-150"></i>
						</div>

						<div class="ace-settings-box clearfix" id="ace-settings-box">
							<div class="pull-left width-50">
								<!-- #section:settings.skins -->
								<div class="ace-settings-item">
									<div class="pull-left">
										<select id="skin-colorpicker" class="hide">
											<option data-skin="no-skin" value="#438EB9">#438EB9</option>
											<option data-skin="skin-1" value="#222A2D">#222A2D</option>
											<option data-skin="skin-2" value="#C6487E">#C6487E</option>
											<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
										</select>
									</div>
									<span>&nbsp; Choose Skin</span>
								</div>

								<!-- /section:settings.skins -->

								<!-- #section:settings.navbar -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
									<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
								</div>

								<!-- /section:settings.navbar -->

								<!-- #section:settings.sidebar -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
									<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
								</div>

								<!-- /section:settings.sidebar -->

								<!-- #section:settings.breadcrumbs -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
									<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
								</div>

								<!-- /section:settings.breadcrumbs -->

								<!-- #section:settings.rtl -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
									<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
								</div>

								<!-- /section:settings.rtl -->

								<!-- #section:settings.container -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
									<label class="lbl" for="ace-settings-add-container">
										Inside
										<b>.container</b>
									</label>
								</div>

								<!-- /section:settings.container -->
							</div><!-- /.pull-left -->

							<div class="pull-left width-50">
								<!-- #section:basics/sidebar.options -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
									<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
									<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
									<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
								</div>

								<!-- /section:basics/sidebar.options -->
							</div><!-- /.pull-left -->
						</div><!-- /.ace-settings-box -->
					</div><!-- /.ace-settings-container -->

					<!-- /section:settings.box -->
					<div class="page-header">

						
											<h1>ชำระเงิน
											<small>
							<i class="ace-icon fa fa-angle-double-right"></i>
							แสดงรายการการชำระเงินของหน่วย
							
							<i class="ace-icon fa fa-angle-double-right"></i>
							รายละเอียด</small>
						
						</h1>
			    </div><!-- /.page-header -->
					<div class="row">
                        <div id="track-changes" class="modal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">&nbsp;</h4>
                                    </div>
                                    <form>
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-md-6">
                                                   
                                                    <h4>
                                                        สมัครซ้ำ
                                                    </h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" data-dismiss="modal" class="btn btn-default">Close</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>                    
						<div class="col-xs-12">						
							<!-- PAGE CONTENT BEGINS -->						
						
							<form role="form" class="form-horizontal">
							  <div class="profile-user-info profile-user-info-striped">

								<div class="profile-info-row">
								  <div class="profile-info-name" style="width:170px;"> หน่วยต้นสังกัด </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="มทบ. 15" readonly id="form-field-2"></span> </div>
								  <div class="profile-info-name" style="width:170px;">วันที่ชำระ </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="21 มิ.ย 2557" readonly id="form-field-2"></span> </div>
								
								</div>
								<div class="profile-info-row">
								  <div class="profile-info-name" style="width:170px;"> งวดเดือน </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="มิ.ย 2557" readonly id="form-field-2"></span> </div>
								  <div class="profile-info-name" style="width:170px;">วันที่บันทึก </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="15 ก.ย. 57" readonly id="form-field-2"></span> </div>
								
								</div>
								<div class="profile-info-row">
								  <div class="profile-info-name" style="width:170px;"> ยอดชำระ </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="30,030.00" readonly id="form-field-2"></span> บาท </div>
			
								
								</div>
								<div class="profile-info-row">

								  
								  <div class="profile-info-name" style="width:50px;">จำนวนสมาชิก </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="143" readonly id="form-field-2"></span> 
								  
								  </div>
								  <div class="profile-info-name" style="width:50px;">เพิ่ม </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="0" readonly id="form-field-2"></span> </div>
								   <div class="profile-info-name" style="width:50px;">ลด </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="2" readonly id="form-field-2"></span> </div>
								
								</div>
																<div class="profile-info-row">
								  <div class="profile-info-name" style="width:170px;"> หมายเหตุ </div>
								  <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="" readonly id="form-field-2"></span>  </div>
			
								
								</div>
							  </div>									
					
							</form>

							<div tabindex="-1" class="modal" id="modal-form-cancel" style="display: none;" aria-hidden="true">
											<div style="width: 800px;" class="modal-dialog">
											  <div class="modal-content">
												<div style="padding:5px" class="modal-header">
												  <button data-dismiss="modal" class="close" type="button">×</button>
												  <h4 class="blue bigger">ยกเลิกใบเสร็จ</h4>
												</div>
												<div class="modal-body">
												  <div class="row">
													<form class="form-horizontal" role="form">
													  <!-- #section:elements.form -->
	
													  <div style="margin-bottom:5px" class="form-group">
														<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> เหตุผลในการยกเลิก </label>
														<div class="col-sm-9">
														  <input type="text" style="width: 400px;">
														</div>
													  </div>

													  <!-- /section:elements.form -->
													</form>

												  </div>
												</div>
												<div class="modal-footer">
												  <button data-dismiss="modal" class="btn btn-sm"> <i class="ace-icon fa fa-times"></i> ยกเลิก </button>
												  <button data-dismiss="modal"  class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i>บันทึก </button>
												</div>
											  </div>
											</div>
										  </div><!-- PAGE CONTENT ENDS -->
							

										  <div tabindex="-1" class="modal" id="modal-form" style="display: none;" aria-hidden="true">
											<div style="width: 800px;" class="modal-dialog">
											  <div class="modal-content">
												<div style="padding:5px" class="modal-header">
												  <button data-dismiss="modal" class="close" type="button">×</button>
												  <h4 class="blue bigger">บันทึกชำระเงินค่าสมัครสมาชิก</h4>
												</div>
												<div class="modal-body">
												  <div class="row">
													<form class="form-horizontal" role="form">
													  <!-- #section:elements.form -->
														 <div style="margin-bottom:5px" class="form-group">
															<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> ชำระโดย </label>
															<div class="col-sm-9">
																		<label>
																			<input type="radio" name="form-field-radio" class="ace">
																			<span class="lbl"> เงินสด</span>
																		</label>
																	<span class="middle"></span>
																		<label>
																			<input type="radio" name="form-field-radio" class="ace">
																			<span style="padding-left:10px;" class="lbl"> ธนาณัติ</span>
																		</label>
															</div>
														</div>
													  <div style="margin-bottom:5px" class="form-group">
														<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> หมายเลขธนาณัติ </label>
														<div class="col-sm-9">
														  <input type="text">
														</div>
													  </div>
													<div style="margin-bottom:5px" class="form-group">
														<label class="col-sm-2 control-label no-padding-right" for="form-field-1"> วันที่ชำระ </label>
														<div class="col-sm-9">
														  <fieldset>
															<input type="text" id="date_register" />
														  </fieldset>
														</div>
													</div>	
													  <!-- /section:elements.form -->
													</form>
													<div class="col-xs-12">
													  <div style="padding:1px"></div>
													
													  <table id="sample-table-1" class="table table-striped table-bordered table-hover">
														<thead>
														  <tr>
															<th> ลำดับ</th>
															<th>เลขทะเบียนสมาชิก </th>
															<th>เลขประจำตัวประชาชน </th>
															
															<th> ยศ-คำนำหน้า</th>
															
															<th> ชื่อ </th>
															<th> สกุล </th>
															<th> ยอดชำระ </th>
															<th> สถานะ </th>
															<th> รายละเอียด </th>
															<th> หน่วยต้นสังกัด </th>
															<th> หมายเหตุ</th>
														  </tr>
														</thead>
														<tbody>
														  <tr>
															<td class="center">1</td>
								  <td>542000872</td>
								  <td>3-6005-00123-60-7</td>
							  <td>นาย</td>
							  <td>กิตติพัฒน์</td>
							  <td>ศิริชู</td>
							  <td>210.00</td>
							  <td>ย้ายออก</td>
							  <td></td>
							  <td>รพ.15</td>
															<td>ปปป</td>
															
														  </tr>



														</tbody>
													  </table>
													</div>
												  </div>
												</div>
												
												<div class="modal-footer">
												  <button data-dismiss="modal" class="btn btn-sm"> <i class="ace-icon fa fa-times"></i> ยกเลิก </button>
												  <button data-dismiss="modal"  class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i>บันทึก </button>
												</div>
											  </div>
											</div>
										  </div><!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->

					</div>
					<div class="row">
					<div class="col-xs-12">
					

													  <div style="padding:1px"></div>
													  <div class="table-header">ข้อมูลสมาชิก</div>
													  <table id="sample-table-1" class="table table-striped table-bordered table-hover">
														<thead>
														  <tr>
																			<th> ลำดับ</th>
															<th>เลขทะเบียนสมาชิก </th>
															<th>เลขประจำตัวประชาชน </th>
															
															<th> ยศ-คำนำหน้า</th>
															
															<th> ชื่อ </th>
															<th> สกุล </th>
															<th> ยอดชำระ </th>
															<th> สถานะ </th>
															<th> รายละเอียด </th>
															<th> หน่วยต้นสังกัด </th>
															<th> หมายเหตุ</th>
														  </tr>
														</thead>
														<tbody>
													  <tr>
															<td class="center">1</td>
																
								  <td>542000872</td>
								  <td>3-6005-00123-60-7</td>
							  <td>นาย</td>
							  <td>กิตติพัฒน์</td>
							  <td>ศิริชู</td>
							  <td>0.00</td>
							  <td>ย้ายออก</td>
							  <td></td>
							  <td>รพ.15</td>
															<td>ปปป</td>
															
															
														  </tr>

													  <tr>
															<td class="center">2</td>
																	
								  <td>542000872</td>
								  <td>3-6005-00123-60-7</td>
							  <td>นาย</td>
							  <td>กิตติพัฒน์</td>
							  <td>ศิริชู</td>
							  <td>0.00</td>
							  <td>ย้ายออก</td>
							  <td></td>
							  <td>รพ.15</td>
															<td>ปปป</td>
															
														  </tr>
														  													  <tr>
															<td class="center">3</td>
																			
								  <td>542000872</td>
								  <td>3-6005-00123-60-7</td>
							  <td>นาย</td>
							  <td>กิตติพัฒน์</td>
							  <td>ศิริชู</td>
							  <td>210.00</td>
							  <td>ย้ายออก</td>
							  <td></td>
							  <td>รพ.15</td>
															<td>ปปป</td>
															
														  </tr>

														</tbody>
													  </table>
													  
		
					  	<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
		
								<a href="PYC101.html">
									<button type="button" class="btn">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										กลับไปหน้าเดิม
									</button>
								</a>								
		
								
							</div>
						</div>
					</div>
									<!-- /.col -->
					</div>

                </div><!-- /.page-content -->
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						<span class="bigger-120">
							<!-- <span class="blue bolder">Ace</span> -->
							<!-- Application &copy; 2013-2014 -->
                            สงวนลิขสิทธิ์ &copy; 2014 กองการฌาปนกิจ กรมสวัสดิการทหารบก
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>

					<!-- /section:basics/footer -->
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='../assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='../assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="../assets/js/bootstrap.min.js"></script>
        

		<!-- page specific plugin scripts -->
		<script src="../assets/js/jquery.dataTables.min.js"></script>
		<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>
		<script src="../assets/js/jquery-ui.min.js"></script>
		<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>    
        <script src="../assets/js/bootbox.min.js"></script>    
		<!-- ace scripts -->
		<script src="../assets/js/ace-elements.min.js"></script>
		<script src="../assets/js/ace.min.js"></script>
 
		<!--[if lte IE 8]>
		  <script src="../assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="../assets/js/jquery-ui.custom.min.js"></script>
		<script src="../assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="../assets/js/chosen.jquery.min.js"></script>
		<script src="../assets/js/fuelux/fuelux.spinner.min.js"></script>
		<script src="../assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="../assets/js/date-time/bootstrap-timepicker.min.js"></script>
		<script src="../assets/js/date-time/moment.min.js"></script>
		<script src="../assets/js/date-time/daterangepicker.min.js"></script>
		<script src="../assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
		<script src="../assets/js/bootstrap-colorpicker.min.js"></script>
		<script src="../assets/js/jquery.knob.min.js"></script>
		<script src="../assets/js/jquery.autosize.min.js"></script>
		<script src="../assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
		<script src="../assets/js/jquery.maskedinput.min.js"></script>
		<script src="../assets/js/bootstrap-tag.min.js"></script>     
        
		
		<script src="../assets/js/jquery.plugin.js"></script>
        <!--<script src="jquery.calendars.all.js"></script><!-- Use instead of calendars, plus, and picker below -->
        <script src="../assets/js/jquery.calendars.js"></script>
        <script src="../assets/js/jquery.calendars.plus.js"></script>
        <script src="../assets/js/jquery.calendars.picker.js"></script>
        <!--<script src="jquery.calendars.picker.ext.js"></script><!-- Include for ThemeRoller styling -->
        <script src="../assets/js/jquery.calendars.persian.js"></script>
        <script type="text/javascript" src="../assets/js/jquery.calendars.thai.min.js"></script>
        <script type="text/javascript" src="../assets/js/jquery.calendars.thai-th.js"></script>
        <script type="text/javascript" src="../assets/js/jquery.calendars.picker-th.js"></script>   
               
        <script type="text/javascript" src="../assets/js/jquery-ui-1.10.3.custom.js"></script>         

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			 var $sidebar = $('.sidebar').eq(0);
			 if( !$sidebar.hasClass('h-sidebar') ) return;
			
			 $(document).on('settings.ace.top_menu' , function(ev, event_name, fixed) {
				if( event_name !== 'sidebar_fixed' ) return;
			
				var sidebar = $sidebar.get(0);
				var $window = $(window);
			
				//return if sidebar is not fixed or in mobile view mode
				if( !fixed || ( ace.helper.mobile_view() || ace.helper.collapsible() ) ) {
					$sidebar.removeClass('hide-before');
					//restore original, default marginTop
					ace.helper.removeStyle(sidebar , 'margin-top')
			
					$window.off('scroll.ace.top_menu')
					return;
				}
			
			
				 var done = false;
				 $window.on('scroll.ace.top_menu', function(e) {
			
					var scroll = $window.scrollTop();
					scroll = parseInt(scroll / 4);//move the menu up 1px for every 4px of document scrolling
					if (scroll > 17) scroll = 17;
			
			
					if (scroll > 16) {			
						if(!done) {
							$sidebar.addClass('hide-before');
							done = true;
						}
					}
					else {
						if(done) {
							$sidebar.removeClass('hide-before');
							done = false;
						}
					}
			
					sidebar.style['marginTop'] = (17-scroll)+'px';
				 }).triggerHandler('scroll.ace.top_menu');
			
			 }).triggerHandler('settings.ace.top_menu', ['sidebar_fixed' , $sidebar.hasClass('sidebar-fixed')]);
			
			 $(window).on('resize.ace.top_menu', function() {
				$(document).triggerHandler('settings.ace.top_menu', ['sidebar_fixed' , $sidebar.hasClass('sidebar-fixed')]);
			 });
			
			
			});
		</script>
        <!-- for jQuery Table -->
        <script type="text/javascript">
			jQuery(function($) {
				var oTable1 = 
				$('#sample-table-2')
				//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
				.dataTable( {
					bAutoWidth: false,
					"aoColumns": [
					  { "bSortable": false },
					  null, null,null, null, null,
					  { "bSortable": false }
					]
			
					
					//,
					//"sScrollY": "200px",
					//"bPaginate": false,
			
					//"sScrollX": "100%",
					//"sScrollXInner": "120%",
					//"bScrollCollapse": true,
					//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
					//you may want to wrap the table inside a "div.dataTables_borderWrap" element
			
					//"iDisplayLength": 50
			    } );
				
			
			
				$(document).on('click', 'th input:checkbox' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
				});
			
			
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					//var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
				
			
			})
		</script>
		<script type="text/javascript">
                    jQuery(function($) {
                        $('#id-disable-check').on('click', function() {
                            var inp = $('#form-input-readonly').get(0);
                            if(inp.hasAttribute('disabled')) {
                                inp.setAttribute('readonly' , 'true');
                                inp.removeAttribute('disabled');
                                inp.value="This text field is readonly!";
                            }
                            else {
                                inp.setAttribute('disabled' , 'disabled');
                                inp.removeAttribute('readonly');
                                inp.value="This text field is disabled!";
                            }
                        });
                    
                    
                        $('.chosen-select').chosen({allow_single_deselect:true}); 
                        //resize the chosen on window resize
                        $(window).on('resize.chosen', function() {
                            var w = $('.chosen-select').parent().width();
                            $('.chosen-select').next().css({'width':w});
                        }).trigger('resize.chosen');
                    
                        $('#chosen-multiple-style').on('click', function(e){
                            var target = $(e.target).find('input[type=radio]');
                            var which = parseInt(target.val());
                            if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
                             else $('#form-field-select-4').removeClass('tag-input-style');
                        });
                    
                    
                        $('[data-rel=tooltip]').tooltip({container:'body'});
                        $('[data-rel=popover]').popover({container:'body'});
                        
                        $('textarea[class*=autosize]').autosize({append: "\n"});
                        $('textarea.limited').inputlimiter({
                            remText: '%n character%s remaining...',
                            limitText: 'max allowed : %n.'
                        });
                    
                        $.mask.definitions['~']='[+-]';
                        $('.input-mask-date').mask('99/99/9999');
                        $('.input-mask-phone').mask('(999) 999-9999');
                        $('.input-mask-eyescript').mask('~9.99 ~9.99 999');
                        $(".input-mask-product").mask("a*-999-a999",{placeholder:" ",completed:function(){alert("You typed the following: "+this.val());}});
                    
                    
                    
                        $( "#input-size-slider" ).css('width','200px').slider({
                            value:1,
                            range: "min",
                            min: 1,
                            max: 8,
                            step: 1,
                            slide: function( event, ui ) {
                                var sizing = ['', 'input-sm', 'input-lg', 'input-mini', 'input-small', 'input-medium', 'input-large', 'input-xlarge', 'input-xxlarge'];
                                var val = parseInt(ui.value);
                                $('#form-field-4').attr('class', sizing[val]).val('.'+sizing[val]);
                            }
                        });
                    
                        $( "#input-span-slider" ).slider({
                            value:1,
                            range: "min",
                            min: 1,
                            max: 12,
                            step: 1,
                            slide: function( event, ui ) {
                                var val = parseInt(ui.value);
                                $('#form-field-5').attr('class', 'col-xs-'+val).val('.col-xs-'+val);
                            }
                        });
                    
                    
                        
                        //"jQuery UI Slider"
                        //range slider tooltip example
                        $( "#slider-range" ).css('height','200px').slider({
                            orientation: "vertical",
                            range: true,
                            min: 0,
                            max: 100,
                            values: [ 17, 67 ],
                            slide: function( event, ui ) {
                                var val = ui.values[$(ui.handle).index()-1] + "";
                    
                                if( !ui.handle.firstChild ) {
                                    $("<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
                                    .prependTo(ui.handle);
                                }
                                $(ui.handle.firstChild).show().children().eq(1).text(val);
                            }
                        }).find('a').on('blur', function(){
                            $(this.firstChild).hide();
                        });
                        
                        
                        $( "#slider-range-max" ).slider({
                            range: "max",
                            min: 1,
                            max: 10,
                            value: 2
                        });
                        
                        $( "#slider-eq > span" ).css({width:'90%', 'float':'left', margin:'15px'}).each(function() {
                            // read initial values from markup and remove that
                            var value = parseInt( $( this ).text(), 10 );
                            $( this ).empty().slider({
                                value: value,
                                range: "min",
                                animate: true
                                
                            });
                        });
                        
                        $("#slider-eq > span.ui-slider-purple").slider('disable');//disable third item
                    
                        
                        $('#id-input-file-1 , #id-input-file-2').ace_file_input({
                            no_file:'No File ...',
                            btn_choose:'Choose',
                            btn_change:'Change',
                            droppable:false,
                            onchange:null,
                            thumbnail:false //| true | large
                            //whitelist:'gif|png|jpg|jpeg'
                            //blacklist:'exe|php'
                            //onchange:''
                            //
                        });
                        //pre-show a file name, for example a previously selected file
                        //$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])
                    
                    
                        $('#id-input-file-3').ace_file_input({
                            style:'well',
                            btn_choose:'Drop files here or click to choose',
                            btn_change:null,
                            no_icon:'ace-icon fa fa-cloud-upload',
                            droppable:true,
                            thumbnail:'small'//large | fit
                            //,icon_remove:null//set null, to hide remove/reset button
                            /**,before_change:function(files, dropped) {
                                //Check an example below
                                //or examples/file-upload.html
                                return true;
                            }*/
                            /**,before_remove : function() {
                                return true;
                            }*/
                            ,
                            preview_error : function(filename, error_code) {
                                //name of the file that failed
                                //error_code values
                                //1 = 'FILE_LOAD_FAILED',
                                //2 = 'IMAGE_LOAD_FAILED',
                                //3 = 'THUMBNAIL_FAILED'
                                //alert(error_code);
                            }
                    
                        }).on('change', function(){
                            //console.log($(this).data('ace_input_files'));
                            //console.log($(this).data('ace_input_method'));
                        });
                        
                    
                        //dynamically change allowed formats by changing allowExt && allowMime function
                        $('#id-file-format').removeAttr('checked').on('change', function() {
                            var whitelist_ext, whitelist_mime;
                            var btn_choose
                            var no_icon
                            if(this.checked) {
                                btn_choose = "Drop images here or click to choose";
                                no_icon = "ace-icon fa fa-picture-o";
                    
                                whitelist_ext = ["jpeg", "jpg", "png", "gif" , "bmp"];
                                whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"];
                            }
                            else {
                                btn_choose = "Drop files here or click to choose";
                                no_icon = "ace-icon fa fa-cloud-upload";
                                
                                whitelist_ext = null;//all extensions are acceptable
                                whitelist_mime = null;//all mimes are acceptable
                            }
                            var file_input = $('#id-input-file-3');
                            file_input
                            .ace_file_input('update_settings',
                            {
                                'btn_choose': btn_choose,
                                'no_icon': no_icon,
                                'allowExt': whitelist_ext,
                                'allowMime': whitelist_mime
                            })
                            file_input.ace_file_input('reset_input');
                            
                            file_input
                            .off('file.error.ace')
                            .on('file.error.ace', function(e, info) {
                                //console.log(info.file_count);//number of selected files
                                //console.log(info.invalid_count);//number of invalid files
                                //console.log(info.error_list);//a list of errors in the following format
                                
                                //info.error_count['ext']
                                //info.error_count['mime']
                                //info.error_count['size']
                                
                                //info.error_list['ext']  = [list of file names with invalid extension]
                                //info.error_list['mime'] = [list of file names with invalid mimetype]
                                //info.error_list['size'] = [list of file names with invalid size]
                                
                                
                                /**
                                if( !info.dropped ) {
                                    //perhapse reset file field if files have been selected, and there are invalid files among them
                                    //when files are dropped, only valid files will be added to our file array
                                    e.preventDefault();//it will rest input
                                }
                                */
                                
                                
                                //if files have been selected (not dropped), you can choose to reset input
                                //because browser keeps all selected files anyway and this cannot be changed
                                //we can only reset file field to become empty again
                                //on any case you still should check files with your server side script
                                //because any arbitrary file can be uploaded by user and it's not safe to rely on browser-side measures
                            });
                        
                        });
                    
                        $('#spinner1').ace_spinner({value:0,min:0,max:200,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
                        .on('change', function(){
                            //alert(this.value)
                        });
                        $('#spinner2').ace_spinner({value:0,min:0,max:10000,step:100, touch_spinner: true, icon_up:'ace-icon fa fa-caret-up', icon_down:'ace-icon fa fa-caret-down'});
                        $('#spinner3').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'ace-icon fa fa-plus smaller-75', icon_down:'ace-icon fa fa-minus smaller-75', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
                        //$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
                        //or
                        //$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
                        //$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0
                    
                    
                        //datepicker plugin
                        //link
                        $('.date-picker').datepicker({
                            autoclose: true,
                            todayHighlight: true
                        })
                        //show datepicker when clicking on the icon
                        .next().on(ace.click_event, function(){
                            $(this).prev().focus();
                        });
                    
                        //or change it into a date range picker
                        $('.input-daterange').datepicker({autoclose:true});
                    
                    
                        //to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
                        $('input[name=date-range-picker]').daterangepicker({
                            'applyClass' : 'btn-sm btn-success',
                            'cancelClass' : 'btn-sm btn-default',
                            locale: {
                                applyLabel: 'Apply',
                                cancelLabel: 'Cancel',
                            }
                        })
                        .prev().on(ace.click_event, function(){
                            $(this).next().focus();
                        });
                    
                    
                        $('#timepicker1').timepicker({
                            minuteStep: 1,
                            showSeconds: true,
                            showMeridian: false
                        }).next().on(ace.click_event, function(){
                            $(this).prev().focus();
                        });
                        
                        $('#date-timepicker1').datetimepicker().next().on(ace.click_event, function(){
                            $(this).prev().focus();
                        });
                        
                    
                        $('#colorpicker1').colorpicker();
                    
                        $('#simple-colorpicker-1').ace_colorpicker();
                        //$('#simple-colorpicker-1').ace_colorpicker('pick', 2);//select 2nd color
                        //$('#simple-colorpicker-1').ace_colorpicker('pick', '#fbe983');//select #fbe983 color
                        //var picker = $('#simple-colorpicker-1').data('ace_colorpicker')
                        //picker.pick('red', true);//insert the color if it doesn't exist
                    
                    
                        $(".knob").knob();
                        
                        
                        var tag_input = $('#form-field-tags');
                        try{
                            tag_input.tag(
                              {
                                placeholder:tag_input.attr('placeholder'),
                                //enable typeahead by specifying the source array
                                source: ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
                                /**
                                //or fetch data from database, fetch those that match "query"
                                source: function(query, process) {
                                  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
                                  .done(function(result_items){
                                    process(result_items);
                                  });
                                }
                                */
                              }
                            );
                    
                            //programmatically add a new
                            var $tag_obj = $('#form-field-tags').data('tag');
                            $tag_obj.add('Programmatically Added');
                        }
                        catch(e) {
                            //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
                            tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
                            //$('#form-field-tags').autosize({append: "\n"});
                        }
                        
                        
                        
                    
                        /////////
                        $('#modal-form input[type=file]').ace_file_input({
                            style:'well',
                            btn_choose:'Drop files here or click to choose',
                            btn_change:null,
                            no_icon:'ace-icon fa fa-cloud-upload',
                            droppable:true,
                            thumbnail:'large'
                        })
                        
                        //chosen plugin inside a modal will have a zero width because the select element is originally hidden
                        //and its width cannot be determined.
                        //so we set the width after modal is show
                        $('#modal-form').on('shown.bs.modal', function () {
                            $(this).find('.chosen-container').each(function(){
                                $(this).find('a:first-child').css('width' , '210px');
                                $(this).find('.chosen-drop').css('width' , '210px');
                                $(this).find('.chosen-search input').css('width' , '200px');
                            });
                        })
						
	
						$("#bootbox-warning").on(ace.click_event, function() {
							bootbox.dialog({
								message: "<span class='bigger-110'>สมัครซ้ำ</span>",
								buttons: 			
								{
									
									"danger" :
									{
										"label" : "Danger!",
										"className" : "btn-sm btn-danger",
										"callback": function() {
											//Example.show("uh oh, look out!");
										}
									}, 

								}
							});
						});		
						$("#bootbox-options").on(ace.click_event, function() {
							bootbox.dialog({
								message: "<span class='bigger-110'>ไม่สามารถสมัคร สมาชิกได้ !!!  <br> สถานะภาพสมาชิก : รอขึ้นทะเบียนสมาชิก</span>",
								buttons: 			
								{
									/*"success" :
									 {
										"label" : "<i class='ace-icon fa fa-check'></i> ปิด",
										"className" : "btn-sm btn-success",
										"callback": function() {
											//Example.show("great success");
										}
									},*/
									"danger" :
									{
										"label" : "<i class='ace-icon fa fa-check'></i> ปิด",
										"className" : "btn-sm btn-danger",
										"callback": function() {
											//Example.show("uh oh, look out!");
										}
									}, 
									/*
									"click" :
									{
										"label" : "Click ME!",
										"className" : "btn-sm btn-primary",
										"callback": function() {
											//Example.show("Primary button");
										}
									}, 
									"button" :
									{
										"label" : "Just a button...",
										"className" : "btn-sm"
									}*/
								}
							});
						});	
						$("#bootbox-submit").on(ace.click_event, function() {
							bootbox.dialog({
								message: "<span class='bigger-110'>บันทึกข้อมูลเรียบร้อย</span>",
								buttons: 			
								{
									"success" :
									 {
										"label" : "<i class='ace-icon fa fa-check'></i> ปิด",
										"className" : "btn-sm btn-success",
										"callback": function() {
											//Example.show("great success");
										}
									}
									

								}
							});
						});							
                        /**
                        //or you can activate the chosen plugin after modal is shown
                        //this way select element becomes visible with dimensions and chosen works as expected
                        $('#modal-form').on('shown', function () {
                            $(this).find('.modal-chosen').chosen();
                        })
                        */

	

                    
                    });
                </script>	
                 <script type="text/javascript"> 
                
					$(function() {
							$('.modal').on('shown.bs.modal, loaded.bs.modal', function(e) {
								// set form state
								$(this).data('form-data', $(this).find('form').serialize());
							});
		
					});
  				 </script>	
				 <script type="text/javascript">
                            jQuery(function($) {
                            
                                $( "#date_begin1" ).datepicker({
                                    showOtherMonths: true,
                                    selectOtherMonths: false,
                                    //isRTL:true,
                            
                                    
                                    /*
                                    changeMonth: true,
                                    changeYear: true,
                                    
                                    showButtonPanel: true,
                                    beforeShow: function() {
                                        //change button colors
                                        var datepicker = $(this).datepicker( "widget" );
                                        setTimeout(function(){
                                            var buttons = datepicker.find('.ui-datepicker-buttonpane')
                                            .find('button');
                                            buttons.eq(0).addClass('btn btn-xs');
                                            buttons.eq(1).addClass('btn btn-xs btn-success');
                                            buttons.wrapInner('<span class="bigger-110" />');
                                        }, 0);
                                    }
                            */
                                });
								
								
								
								


                            
                            
                                //override dialog's title function to allow for HTML titles
                                $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
                                    _title: function(title) {
                                        var $title = this.options.title || '&nbsp;'
                                        if( ("title_html" in this.options) && this.options.title_html == true )
                                            title.html($title);
                                        else title.text($title);
                                    }
                                }));
                            
                                $( "#id-btn-dialog1" ).on('click', function(e) {
                                    e.preventDefault();
                            
                                    var dialog = $( "#dialog-message" ).removeClass('hide').dialog({
                                        modal: true,
                                        title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='ace-icon fa fa-check'></i> jQuery UI Dialog</h4></div>",
                                        title_html: true,
                                        buttons: [ 
                                            {
                                                text: "Cancel",
                                                "class" : "btn btn-xs",
                                                click: function() {
                                                    $( this ).dialog( "close" ); 
                                                } 
                                            },
                                            {
                                                text: "OK",
                                                "class" : "btn btn-primary btn-xs",
                                                click: function() {
                                                    $( this ).dialog( "close" ); 
                                                } 
                                            }
                                        ]
                                    });
                            
                                    /**
                                    dialog.data( "uiDialog" )._title = function(title) {
                                        title.html( this.options.title );
                                    };
                                    **/
                                });
                            
                            
                                $( "#dialog-delete" ).on('click', function(e) {
                                    e.preventDefault();
                                
                                    $( "#dialog-confirm" ).removeClass('hide').dialog({
                                        resizable: false,
                                        modal: true,
                                        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon fa fa-exclamation-triangle red'></i> Empty the recycle bin?</h4></div>",
                                        title_html: true,
                                        buttons: [
                                            {
                                                html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>&nbsp; Delete all items",
                                                "class" : "btn btn-danger btn-xs",
                                                click: function() {
                                                    $( this ).dialog( "close" );
                                                }
                                            }
                                            ,
                                            {
                                                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; Cancel",
                                                "class" : "btn btn-xs",
                                                click: function() {
                                                    $( this ).dialog( "close" );
                                                }
                                            }
                                        ]
                                    });
                                });
                            
                            
                                
                                //autocomplete
                                 var availableTags = [
                                    "ActionScript",
                                    "AppleScript",
                                    "Asp",
                                    "BASIC",
                                    "C",
                                    "C++",
                                    "Clojure",
                                    "COBOL",
                                    "ColdFusion",
                                    "Erlang",
                                    "Fortran",
                                    "Groovy",
                                    "Haskell",
                                    "Java",
                                    "JavaScript",
                                    "Lisp",
                                    "Perl",
                                    "PHP",
                                    "Python",
                                    "Ruby",
                                    "Scala",
                                    "Scheme"
                                ];
                                $( "#tags" ).autocomplete({
                                    source: availableTags
                                });
                            
                                //custom autocomplete (category selection)
                                $.widget( "custom.catcomplete", $.ui.autocomplete, {
                                    _renderMenu: function( ul, items ) {
                                        var that = this,
                                        currentCategory = "";
                                        $.each( items, function( index, item ) {
                                            if ( item.category != currentCategory ) {
                                                ul.append( "<li class='ui-autocomplete-category'>" + item.category + "</li>" );
                                                currentCategory = item.category;
                                            }
                                            that._renderItemData( ul, item );
                                        });
                                    }
                                });
                                
                                 var data = [
                                    { label: "anders", category: "" },
                                    { label: "andreas", category: "" },
                                    { label: "antal", category: "" },
                                    { label: "annhhx10", category: "Products" },
                                    { label: "annk K12", category: "Products" },
                                    { label: "annttop C13", category: "Products" },
                                    { label: "anders andersson", category: "People" },
                                    { label: "andreas andersson", category: "People" },
                                    { label: "andreas johnson", category: "People" }
                                ];
                                $( "#search" ).catcomplete({
                                    delay: 0,
                                    source: data
                                });
                                
                                
                                //tooltips
                                $( "#show-option" ).tooltip({
                                    show: {
                                        effect: "slideDown",
                                        delay: 250
                                    }
                                });
                            
                                $( "#hide-option" ).tooltip({
                                    hide: {
                                        effect: "explode",
                                        delay: 250
                                    }
                                });
                            
                                $( "#open-event" ).tooltip({
                                    show: null,
                                    position: {
                                        my: "left top",
                                        at: "left bottom"
                                    },
                                    open: function( event, ui ) {
                                        ui.tooltip.animate({ top: ui.tooltip.position().top + 10 }, "fast" );
                                    }
                                });
                            
                            
                                //Menu
                                $( "#menu" ).menu();
                            
                            
                                //spinner
                                var spinner = $( "#spinner" ).spinner({
                                    create: function( event, ui ) {
                                        //add custom classes and icons
                                        $(this)
                                        .next().addClass('btn btn-success').html('<i class="ace-icon fa fa-plus"></i>')
                                        .next().addClass('btn btn-danger').html('<i class="ace-icon fa fa-minus"></i>')
                                        
                                        //larger buttons on touch devices
                                        if('touchstart' in document.documentElement) 
                                            $(this).closest('.ui-spinner').addClass('ui-spinner-touch');
                                    }
                                });
                            
                                //slider example
                                $( "#slider" ).slider({
                                    range: true,
                                    min: 0,
                                    max: 500,
                                    values: [ 75, 300 ]
                                });
                            
                            
                            
                                //jquery accordion
                                $( "#accordion" ).accordion({
                                    collapsible: true ,
                                    heightStyle: "content",
                                    animate: 250,
                                    header: ".accordion-header"
                                }).sortable({
                                    axis: "y",
                                    handle: ".accordion-header",
                                    stop: function( event, ui ) {
                                        // IE doesn't register the blur when sorting
                                        // so trigger focusout handlers to remove .ui-state-focus
                                        ui.item.children( ".accordion-header" ).triggerHandler( "focusout" );
                                    }
                                });
                                //jquery tabs
                                $( "#tabs" ).tabs();
                                
                                
                                //progressbar
                                $( "#progressbar" ).progressbar({
                                    value: 37,
                                    create: function( event, ui ) {
                                        $(this).addClass('progress progress-striped active')
                                               .children(0).addClass('progress-bar progress-bar-success');
                                    }
                                });
                                    
                            });
                        </script>                      
						 
                         <script type="text/javascript">
							$(function() {
   
    							//$('#date_begin').calendarsPicker({calendar: $.calendars.instance('thai','th')});
								//$('#date_end').calendarsPicker({calendar: $.calendars.instance('thai','th')});
							});
						</script>
						<script>
                         $.datepicker.regional['th'] ={
                                changeMonth: true,
                                changeYear: true,
                                //defaultDate: GetFxupdateDate(FxRateDateAndUpdate.d[0].Day),
                                yearOffSet: 543,
                                
                                dateFormat: 'dd M yy',
                                dayNames: ['อาทิตย์', 'จันทร์', 'อังคาร', 'พุธ', 'พฤหัสบดี', 'ศุกร์', 'เสาร์'],
                                dayNamesMin: ['อา', 'จ', 'อ', 'พ', 'พฤ', 'ศ', 'ส'],
                                monthNames: ['มกราคม', 'กุมภาพันธ์', 'มีนาคม', 'เมษายน', 'พฤษภาคม', 'มิถุนายน', 'กรกฎาคม', 'สิงหาคม', 'กันยายน', 'ตุลาคม', 'พฤศจิกายน', 'ธันวาคม'],
                                monthNamesShort: ['ม.ค.', 'ก.พ.', 'มี.ค.', 'เม.ย.', 'พ.ค.', 'มิ.ย.', 'ก.ค.', 'ส.ค.', 'ก.ย.', 'ต.ค.', 'พ.ย.', 'ธ.ค.'],
                                constrainInput: true,
                            };
                        $.datepicker.setDefaults($.datepicker.regional['th']);
                        
                          $(function() {
                            $( "#date_begin" ).datepicker( $.datepicker.regional["th"] ); // Set ภาษาที่เรานิยามไว้ด้านบน
                            $( "#date_begin" ).datepicker("setDate", new Date()); //Set ค่าวันปัจจุบัน
							$( "#date_end" ).datepicker( $.datepicker.regional["th"] ); // Set ภาษาที่เรานิยามไว้ด้านบน
                            $( "#date_end" ).datepicker("setDate", new Date()); //Set ค่าวันปัจจุบัน
                            $( "#date_register" ).datepicker( $.datepicker.regional["th"] ); // Set ภาษาที่เรานิยามไว้ด้านบน
                            $( "#date_register" ).datepicker("setDate", new Date()); //Set ค่าวันปัจจุบัน			
							$( "#date_pop1" ).datepicker( $.datepicker.regional["th"] ); // Set ภาษาที่เรานิยามไว้ด้านบน
                            $( "#date_pop1" ).datepicker("setDate", new Date()); //Set ค่าวันปัจจุบัน
							$( "#date_pop2" ).datepicker( $.datepicker.regional["th"] ); // Set ภาษาที่เรานิยามไว้ด้านบน
                            $( "#date_pop2" ).datepicker("setDate", new Date()); //Set ค่าวันปัจจุบัน				
                          });
                        
                        
                            var Holidays;
                         
                            //On Selected Date
                            //Have Check Date
                            function CheckDate(date) {
                                var day = date.getDate();
                                var selectable = true;//ระบุว่าสามารถเลือกวันที่ได้หรือไม่ True = ได้ False = ไม่ได้
                                var CssClass = '';
                                
                                if (Holidays != null) {
                        
                                    for (var i = 0; i < Holidays.length; i++) {
                                        var value = Holidays[i];
                                        if (value == day) {
                        
                                            selectable = false;
                                            CssClass = 'specialDate';
                                            break;
                                        }
                                    }
                                }
                                return [selectable, CssClass, ''];
                            }
                        
                        
                            //=====================================================================================================
                            //On Selected Date
                            function SelectedDate(dateText, inst) {
                                //inst.selectedMonth = Index of mounth
                                //(inst.selectedMonth+1)  = Current Mounth
                            	var DateText = inst.selectedDay + '/' + (inst.selectedMonth + 1) + '/' + inst.selectedYear;
                                //CallGetUpdateInMonth(ReFxupdateDate(dateText));
                                //CallGetUpdateInMonth(DateText);
                                return [dateText, inst]
                            }
                            //=====================================================================================================
                            //Call Date in month on click image
                            function OnBeforShow(input, inst) {
                                var month = inst.currentMonth + 1;
                                var year = inst.currentYear;
                                //currentDay: 10
                                //currentMonth: 6
                                //currentYear: 2012
                                GetDaysShows(month, year); 
                               
                            }
                            //=====================================================================================================
                            //On Selected Date
                            //On Change Drop Down
                            function ChangMonthAndYear(year, month, inst) {
                        
                                GetDaysShows(month, year);
                            }
                        
                            //=====================================
                            function GetDaysShows(month, year) {
                                //CallGetDayInMonth(month, year); <<เป็น Function ที่ผมใช้เรียก ajax เพื่อหาวันใน DataBase  แต่นี้เป็นเพียงตัวอย่างจึงใช้ Array ด้านล่างแทนการ Return Json
                                //อาจใช้ Ajax Call Data โดยเลือกจากเดือนและปี แล้วจะได้วันที่ต้องการ Set ค่าวันไว้คล้ายด้านล่าง
                                Holidays = [1,4,6,11]; // Sample Data
                            }
                            //=====================================
                         
                          </script>

						  <script language="javascript"> 
						    $(document).ready(function(){ 
						      $("#check-idcard-pass").click(function(){       
						        $("#form-register").show();
						        $('#select-name').removeAttr('disabled');
						        //$('#id).attr('disabled', 'disabled');
						      });
							  
							  $("#check-ref").click(function(){       
						        $("#inpurt-ref").show();
						        $('#select-ref').removeAttr('disabled');
						        //$('#id).attr('disabled', 'disabled');
						      });


						      
						      $(".disable").click(function(){       
						        $(".hello").hide();
						      });           
						      $(".hide_fast").click(function(){       
						        $(".hello").hide("fast");
						      });
						      $(".hide_slow").click(function(){       
						        $(".hello").hide("slow");
						      });
						      $(".hide_2000").click(function(){       
						        $(".hello").hide(2000);
						      });
						    });     
						  </script>
						<script type="text/javascript">
							    $(document).ready(function(){
							        $("#select-paymenttype").change(function(){
							            $( "select option:selected").each(function(){
							                if($(this).attr("value")=="1"){
							                    //$(".box").hide();
												//alert("9999");
							                    $("#input-marital-status").hide();
							                }
											if($(this).attr("value")=="2"){
							                    //$(".box").hide();
							                    $("#input-marital-status").show();
							                }
											if($(this).attr("value")=="3"){
							                    //$(".box").hide();
							                    $("#input-marital-status").show();
							                }
											if($(this).attr("value")=="0"){
							                    //$(".box").hide();
							                    $("#input-marital-status").hide();
							                }											
							                /*if($(this).attr("value")=="green"){
							                    $(".box").hide();
							                    $(".green").show();
							                }
							                if($(this).attr("value")=="blue"){
							                    $(".box").hide();
							                    $(".blue").show();
							                }*/
							            });
							        }).change();
							    });
						</script>
		<link rel="stylesheet" href="../assets/css/ace.onpage-help.css" />
		<link rel="stylesheet" href="../docs/assets/js/themes/sunburst.css" />

		<script type="text/javascript"> ace.vars['base'] = '..'; </script>
		<script src="../assets/js/ace/ace.onpage-help.js"></script>
		<script src="../docs/assets/js/rainbow.js"></script>
		<script src="../docs/assets/js/language/generic.js"></script>
		<script src="../docs/assets/js/language/html.js"></script>
		<script src="../docs/assets/js/language/css.js"></script>
		<script src="../docs/assets/js/language/javascript.js"></script>
	</body>
</html>
