<%-- 
    Document   : menu
    Created on : May 29, 2014, 12:03:16 AM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!-- #section:basics/sidebar.horizontal -->
<div id="sidebar" class="sidebar h-sidebar navbar-collapse collapse">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed');
        } catch (e) {
        }
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
        <li id="menuQueryData" class="hover">
            <a href="#" class="dropdown-toggle"> 
                <i class="menu-icon fa fa-users"></i> 
                <span class="menu-text"> ข้อมูลสมาชิก </span> 
                <b class="arrow fa fa-angle-down"></b> 
            </a> 
            <b class="arrow"></b>
            <ul class="submenu" style="width: 250px;">
                <li class="hover"> <a id="menuQRY010" href="#"> <i class="menu-icon fa fa-caret-right"></i> เรียกค้นข้อมูลสมาชิก <b class="arrow"></b> </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuQRY020" href="#"> <i class="menu-icon fa fa-caret-right"></i> เรียกค้นข้อมูลสมาชิกโดยละเอียด </a> <b class="arrow"></b> </li>
            </ul>
        </li>

        <li id="menuRegistration" class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-list"></i> <span class="menu-text"> รับสมัคร </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
            <ul class="submenu" style="width: 250px;">
                <li class="hover"> <a id="menuAPP010" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการผู้สมัครเป็นสมาชิก </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP010_2" href="#" > <i class="menu-icon fa fa-caret-right"></i> บันทึกผู้สมัครเป็นสมาชิก </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP031" href="#" > <i class="menu-icon fa fa-caret-right"></i> ขอความเห็นชอบสมาชิกใหม่ </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP040" href="#" > <i class="menu-icon fa fa-caret-right"></i> กำหนดเลขทะเบียนสมาชิก </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP041" href="#" > <i class="menu-icon fa fa-caret-right"></i> ขออนุมัติขึ้นทะเบียนสมาชิกใหม่ </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP043" href="#" > <i class="menu-icon fa fa-caret-right"></i> ยืนยันอนุมัติขึ้นทะเบียนสมาชิก </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP045" href="#" > <i class="menu-icon fa fa-caret-right"></i> จัดพิมพ์ใบต้อนรับ </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP044" href="#" > <i class="menu-icon fa fa-caret-right"></i> พิมพ์ทะเบียนสมาชิก ก.ฌ. ๔ </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP051" href="#" > <i class="menu-icon fa fa-caret-right"></i> จัดพิมพ์บัตรคุมเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuAPP052" href="#" > <i class="menu-icon fa fa-caret-right"></i> จัดพิมพ์บัตรคุมการโอนย้ายหน่วย </a> <b class="arrow"></b> </li>                      
                <li class="hover"> <a id="menuAPP101" href="#" > <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปผู้สมัครสมาชิก </a> <b class="arrow"></b> </li>
            </ul>
        </li>
        <li id="menuChanges" class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-pencil-square-o"></i> <span class="menu-text"> เปลี่ยนแปลงข้อมูล </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
            <ul class="submenu" style="width: 290px;">
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> เปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 305px;">
                        <li class="hover"> <a id="menuCHT010" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการขอเปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCHT030" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการเปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCHT101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกขอเปลี่ยนแปลงข้อมูล </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> เปลี่ยนแปลงที่อยู่ <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 290px;">
                        <li class="hover"> <a id="menuCHA010" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการขอเปลี่ยนแปลงที่อยู่ </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCHA030" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการเปลี่ยนแปลงที่อยู่ </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCHA101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกขอเปลี่ยนแปลงที่อยู่ </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> เปลี่ยนแปลงผู้รับเงินสงเคราะห์ <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 305px;">
                        <li class="hover"> <a id="menuAPP051" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการขอการเปลี่ยนแปลงผู้รับเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuAPP051" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกเปลี่ยนแปลงผู้รับเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuAPP051" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกขอเปลี่ยนแปลงผู้รับเงินสงเคราะห์ </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> เปลี่ยนแปลงประเภทการชำระเงิน <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 305px;">
                        <li class="hover"> <a id="menuCHP010" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการขอการเปลี่ยนแปลงประเภทการชำระเงิน </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCHP030" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการเปลี่ยนแปลงประเภทการชำระเงิน </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCHP101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกขอเปลี่ยนแปลงการชำระเงิน </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> โอนย้ายหน่วยชำระเงิน <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 290px;">
                        <li class="hover"> <a id="menuCHD010" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการโอนย้ายหน่วยชำระเงิน </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCHD030" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการเปลี่ยนแปลงหน่วยการชำระเงิน </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCHD101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกโอนย้ายหน่วยชำระเงิน </a> <b class="arrow"></b> </li> 
                    </ul>
                </li>
            </ul>
        </li>

        <li id="menuPayment" class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-credit-card"></i> <span class="menu-text"> ชำระเงิน </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
            <ul class="submenu" style="width: 290px;">
                <li class="hover"> <a id="menuPAY020" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการรับชำระเงินค่าสมัครสมาชิก </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuPAY020_1" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกรับชำระเงินค่าสมัครสมาชิก </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuPAY010" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการรับชำระเงินค่าบำรุงศพ </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuPAY010_1" href="#"> <i class="menu-icon fa fa-caret-right"></i>  บันทึกรับชำระเงินค่าบำรุงศพ </a> <b class="arrow"></b> </li>

                <li class="hover"> <a id="menuPAY030" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการหักเงินค่าบำรุงศพผ่านธนาคาร</a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuPAY040" href="#"> <i class="menu-icon fa fa-caret-right"></i>  บันทึกการหักเงินค่าบำรุงศพผ่านธนาคาร </a> <b class="arrow"></b> </li>

                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการชำระเงิน <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 305px;">
                        <li class="hover"> <a id="menuCKP010" href="#"> <i class="menu-icon fa fa-caret-right"></i> ดูตรวจสอบรายชื่อสมาชิกค้างชำระ </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuCKP040" href="#"> <i class="menu-icon fa fa-caret-right"></i> แสดงรายชื่อสมาชิกที่ค้างชำระและได้ดำเนินการทวงถาม </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a id="menuPYC101" href="#"> <i class="menu-icon fa fa-caret-right"></i> แสดงรายการการชำระเงินของหน่วย </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuPYC102" href="#"> <i class="menu-icon fa fa-caret-right"></i> รางานสรุปการชำระเงินผ่านหน่วย </a> <b class="arrow"></b> </li>
            </ul>
        </li>
        <li id="menuWithdraw" class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-exchange"></i> <span class="menu-text"> ถอนสภาพ/คืนสภาพ </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
            <ul class="submenu">
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ถอนสภาพสมาชิกชั่วคราว <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 270px;">
                        <li class="hover"> <a id="menuRMT010" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการถอนสภาพสมาชิกชั่วคราว </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRMT020" href="#"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการถอนสภาพสมาชิกชั่วคราว </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRMT030" href="#"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการถอนสภาพสมาชิกชั่วคราว </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRMT101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกถูกถอนสภาพชั่วคราว </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ถอนสภาพสมาชิกถาวร <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 270px;">
                        <li class="hover"> <a id="menuRMF010" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการถอนสภาพสมาชิกถาวร </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRMF020" href="#"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการถอนสภาพสมาชิกถาวร </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRMF030" href="#"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการถอนสภาพสมาชิกถาวร </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRMF101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกถูกถอนสภาพถาวร </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> คืนสภาพสมาชิก <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 270px;">
                        <li class="hover"> <a id="menuRST010" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการคืนสภาพสมาชิก </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRST020" href="#"> <i class="menu-icon fa fa-caret-right"></i> ดำเนินการคืนสภาพสมาชิก </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRST030" href="#"> <i class="menu-icon fa fa-caret-right"></i> ยืนยันการคืนสภาพสมาชิก </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRST040" href="#"> <i class="menu-icon fa fa-caret-right"></i> ตรวจสอบการถอนสภาพสมาชิกถาวร </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuRST101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกได้รับคืนสภาพ </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li id="menuRequestDeath" class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-bullhorn "></i> <span class="menu-text">แจ้งถึงแก่กรรม</span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
            <ul class="submenu" style="width: 320px;">
                <li class="hover"> <a id="menuFLD010" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการข้อมูลแจ้งถึงแก่กรรมของสมาชิก </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD020" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกข้อมูลถึงแก่กรรมของสมาชิก </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD030" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการจ่ายเงินสงเคราะห์ (ครั้งที่ 1) </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD040" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกรายการจ่ายเงินสงเคราะห์ (ครั้งที่ 1) </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD050" href="#"> <i class="menu-icon fa fa-caret-right"></i>ดำเนินการขออนุมัติจ่ายเงินสงเคราะห์ (ครั้งที่ 1)</a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD070" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกสถานะการยืนยันจ่ายเงินสงเคราะห์ (ครั้งที่ 1) </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD080" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายการจ่ายเงินสงเคราะห์ (ส่วนที่เหลือ)</a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD090" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกรายการจ่ายเงินสงเคราะห์ (ส่วนที่เหลือ) </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD100" href="#"> <i class="menu-icon fa fa-caret-right"></i> ดำเนินการขออนุมัติจ่ายเงินสงเคราะห์ (ส่วนที่เหลือ) </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD102" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกสถานะการยืนยันจ่ายเงินสงเคราะห์ (ส่วนที่เหลือ) </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuFLD103" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปสมาชิกแจ้งถึงแก่กรรม </a> <b class="arrow"></b> </li>
            </ul>
        </li>
        <li id="menuGeneral" class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-globe"></i> <span class="menu-text"> งานทั่วไป </span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
            <ul class="submenu">
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ออกบัตรสมาชิก <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 250px;">
                        <li class="hover"> <a id="menuMCB010" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการออกบัตรสมาชิก </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuMCB101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปการขออกบัตรสมาชิก </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> ขอใบแทนใบตอบรับ <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 250px;">
                        <li class="hover"> <a id="menuMCR010" href="#"> <i class="menu-icon fa fa-caret-right"></i> บันทึกการขอใบแทนใบตอบรับ </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuMCR101" href="#"> <i class="menu-icon fa fa-caret-right"></i> รายงานสรุปการขอใบแทนใบตอบรับ </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
                <li class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-caret-right"></i> บัญชีการคุมการชำระเงิน <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
                    <ul class="submenu" style="width: 250px;">
                        <li class="hover"> <a id="menuAPP053" href="#"> <i class="menu-icon fa fa-caret-right"></i> บัญชีคุมการคุมการชำระผ่านหน่วย </a> <b class="arrow"></b> </li>
                        <li class="hover"> <a id="menuAPP054" href="#"> <i class="menu-icon fa fa-caret-right"></i> บัญชีคุมการคุมการชำระผ่านธนาคาร </a> <b class="arrow"></b> </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li id="menuConfigSystem" class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-cogs"></i> <span class="menu-text">ตั้งค่าหลักระบบ</span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
            <ul class="submenu" style="width: 250px;">
                <li class="hover"> <a id="menuSYS010" href="#"> <i class="menu-icon fa fa-caret-right"></i> กำหนดคุณสมบัติของระบบสมาชิก </a> <b class="arrow"></b> </li>
            </ul>
        </li> 
        <li id="menuMasterData" class="hover">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-cog"></i>
                <span class="menu-text">ข้อมูลพื้นฐาน</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="hover">
                    <a id="menuMAS010" href="#">
                        <i class="menu-icon fa fa-caret-right"></i>
                        ข้อมูลหน่วยต้นสังกัด
                    </a>

                    <b class="arrow"></b>
                </li>

                <li class="hover">
                    <a id="menuMAS020" href="#">
                        <i class="menu-icon fa fa-caret-right"></i>
                        ข้อมูลคำนำหน้า
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="hover">
                    <a id="menuMAS030" href="#">
                        <i class="menu-icon fa fa-caret-right"></i>
                        ข้อมูลยศ
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="hover">
                    <a id="menuMAS040" href="#">
                        <i class="menu-icon fa fa-caret-right"></i>
                        ข้อมูลธนาคาร
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="hover">
                    <a id="menuMAS050" href="#">
                        <i class="menu-icon fa fa-caret-right"></i>
                        ข้อมูลประเภทบัญชีธนาคาร
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="hover">
                    <a id="menuMAS060" href="#">
                        <i class="menu-icon fa fa-caret-right"></i>
                        ข้อมูลสาขาธนาคาร
                    </a>

                    <b class="arrow"></b>
                </li>
                <li class="hover">
                    <a id="menuMAS080" href="#">
                        <i class="menu-icon fa fa-caret-right"></i>
                        ข้อมูลจังหวัด
                    </a>

                    <b class="arrow"></b>
                </li>                 
            </ul>
        </li> 
        <li id="menuAdministrator" class="hover"> <a href="#" class="dropdown-toggle"> <i class="menu-icon fa fa-cogs "></i> <span class="menu-text">ข้อมูลผู้งานระบบ</span> <b class="arrow fa fa-angle-down"></b> </a> <b class="arrow"></b>
            <ul class="submenu" style="width: 250px;">
                <li class="hover"> <a id="menuPER010" href="#"> <i class="menu-icon fa fa-caret-right"></i> จัดการสิทธิ์การใช้งานระบบ </a> <b class="arrow"></b> </li>
                <li class="hover"> <a id="menuPER020" href="#"> <i class="menu-icon fa fa-caret-right"></i> จัดการข้อมูลผู้ใช้งาน </a> <b class="arrow"></b> </li>
            </ul>
        </li>
    </ul><!-- /.nav-list -->

    <!-- #section:basics/sidebar.layout.minimize -->
    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <!-- /section:basics/sidebar.layout.minimize -->
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed');
        } catch (e) {
        }
    </script>
</div>
<!-- /section:basics/sidebar.horizontal -->

