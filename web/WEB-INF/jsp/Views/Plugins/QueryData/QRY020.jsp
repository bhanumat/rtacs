<%-- 
    Document   : QRY020
    Created on : Sep 17, 2014, 9:24:17 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlGetLoadQRY020 = rootPath + '/Plugins/QueryData/getLoadQRY020.json';
    var urlListQRY020_Search = rootPath + '/Plugins/QueryData/getListQRY020_Search.json';
    var urlLoadMemberBeneficiary = rootPath + '/Plugins/QueryData/getListMemberBeneficiaryQRY020.json';
    var urlListQRY020PaymentView = rootPath + '/Plugins/QueryData/getListPaymentViewQRY020.json?id=';
    var urlListQRY020MemberStatusView = rootPath + '/Plugins/QueryData/getListMemberStatusViewQRY020.json?id=';
    var urlListQRY020MemberDeptHistoryView = rootPath + '/Plugins/QueryData/getListMemberDeptHistoryViewQRY020.json?id=';
    var urlListQRY020MemberPaymentTypeHistoryView = rootPath + '/Plugins/QueryData/getListMemberPaymentTypeHistoryViewQRY020.json?id=';
    var urlListQRY020MemberTitleNameHistoryView = rootPath + '/Plugins/QueryData/getListMemberTitleNameHistoryViewQRY020.json?id=';
    
    
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    var myStringListMemberBeneficiary = '';
    var listMemberBeneficiary = [];
    var listMilitaryDepartment;
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/QueryData/action.QRY020.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/QueryData/jqgrid.QRY020_Search.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/QueryData/jqgrid.QRY020_View.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/QueryData/jqgrid.QRY020_Payment_View.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/QueryData/jqgrid.QRY020_Member_Status_View.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/QueryData/jqgrid.QRY020_Member_Dept_History_View.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/QueryData/jqgrid.QRY020_Member_Payment_Type_History_View.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/QueryData/jqgrid.QRY020_Member_Title_Name_History_View.js"></script>
<div class="page-header">
    <h1>
        ข้อมูลสมาชิก
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            เรียกค้นข้อมูลสมาชิกโดยละเอียด
        </small>
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <div id="ListView" class="row">
            <div class="col-xs-12">
                <div class="row">
                    <div class="widget-box">
                        <div class="widget-header">
                            <h4 class="widget-title">เรียกค้นข้อมูลสมาชิก</h4>
                        </div>
                        <div class="widget-body">
                            <div class="widget-main">
                                <form class="form-search">
                                    <div style="margin-bottom:5px" class="row">
                                        <div align="right" class="col-sm-4">
                                            <div class="input-group">
                                                <input type="radio" checked="checked" name="rdDataTypeSearch" value="citizenId" class="ace">
                                                <span class="lbl"></span> เลขประจำตัวประชาชน 
                                                <input type="radio" name="rdDataTypeSearch" value="memberCode" class="ace">
                                                <span class="lbl"></span> เลขทะเบียนสมาชิก
                                            </div>
                                        </div>
                                        <div class="col-sm-2">
                                            <div class="input-group">
                                                <input id="txtSearch" name="txtSearch" type="text" placeholder="ระบุเลขทะเบียนสมาชิก" class="form-control search-query" kl_virtual_keyboard_secure_input="on">
                                                <span class="input-group-btn"> 
                                                    <a data-toggle="modal" class="blue" role="button" href="#modal-form">
                                                        <button id="btnSearchSelect" name="btnSearchSelect" class="btn btn-purple btn-sm" type="button"> ค้นหา <i class="ace-icon fa fa-search icon-on-right bigger-110"></i> </button>
                                                    </a>
                                                </span> 
                                            </div>
                                        </div>
                                        <div class="col-sm-2">
                                            <button class="btn btn-info btn-sm" type="button" id="btnView" name="btnView"> <i class="ace-icon fa fa-check bigger-110"></i> แสดง </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div id="tabMainMember">
                        <ul>
                            <li class="active"> <a data-toggle="tab" href="#tabMember">ข้อมูลสมาชิก<i class="fa"></i></a> </li>
                            <li> <a data-toggle="tab" href="#tabAddress">ที่อยู่<i class="fa"></i></a> </li>
                            <li> <a data-toggle="tab" href="#tabMemberBeneficiary">ผู้รับเงินสงเคราห์<i class="fa"></i></a> </li>
                            <li> <a data-toggle="tab" href="#tabPayment">การชำระเงิน<i class="fa"></i></a> </li>
                            <li> <a data-toggle="tab" href="#tabMemberStatus">สถานะภาพสมาชิก<i class="fa"></i></a> </li> 
                            <li> <a data-toggle="tab" href="#tabMemberDeptHistory">ประวัติโอนย้าย<i class="fa"></i></a> </li> 
                            <li> <a data-toggle="tab" href="#tabMemberPaymentTypeHistory">ประวัติการเปลี่ยนแระเภทการชำระเงิน<i class="fa"></i></a> </li> 
                            <li> <a data-toggle="tab" href="#tabMemberTitleNameHistory">ประวัติการเปลี่ยน ยศ คำนำหน้า ชื่อสกุล<i class="fa"></i></a> </li> 
                            
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabMember">
                                <div class="row">
                                    <div class="col-xs-10">
                                        <div class="form-horizontal">
                                            <div class="profile-user-info profile-user-info-striped">
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> เลขทะเบียนสมาชิก </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spMemberCode"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> วันที่ขึ้นทะเบียน </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spApprovedDate"></span> </div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> เลขประจำตัวประชาชน </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spCitizenId"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> เริ่มชำระศพที่ </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spStartMonthCode"></span> </div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> ยศ - คำนำหน้า </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spRankOrTitleName"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name">เพศ </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spGender"></span> </div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> ชื่อ </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spName"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> สกุล </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spSurname"></span> </div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> วันเดือนปีเกิด </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spBirthDate"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> อายุ </div>
                                                    <div style="width:200px;" class="profile-info-value"><span class="editable" id="spBirthDateYear"></span><span class="editable"> ปี</span></div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> ประเภทสมาชิก </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spMemberGroupCode"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> ประเภทการสมัคร </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spMemberTypeCode"></span> </div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> ประเภทการชำระเงิน </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPaymentTypeCode"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> หน่วยต้นสังกัด </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spMilitaryName"></span> </div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> รหัสผู้นำเข้า </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spReferrerCode"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> ชื่อผู้นำเข้า </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spReferrerNameText"></span> </div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> ความเกี่ยวพันกับผู้นำเข้า </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spReferrerRelationshipCode"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> </div>
                                                    <div style="width:200px;" class="profile-info-value"></div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> สถานะภาพสมรส </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spMarryStatusCode"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> ชื่อคู่สมรส </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spWifehusbandFullname"></span> </div>
                                                </div>
                                                <div class="profile-info-row">
                                                    <div style="width:170px;" class="profile-info-name"> หมายเตุ </div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spRemark"></span> </div>
                                                    <div style="width:170px;" class="profile-info-name"> <b>สถานะ </b></div>
                                                    <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spMemberStatusCode"><b></b></span> </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <div class="tab-pane" id="tabAddress">
                                <div class="row">
                                    <div class="col-xs-10">
                                        <div class="form-horizontal">
                                            <div class="col-xs-10">
                                                <div class="col-sm-8">
                                                    <h3>ที่อยู่ตามทะเบียนบ้าน</h3>
                                                </div>
                                            </div>
                                            <div class="col-xs-10">
                                                <div class="form-horizontal">
                                                    <!-- #section:elements.form -->
                                                    <div class="profile-user-info profile-user-info-striped">
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> ที่อยู่ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentAddress"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> หมู่ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentMoo"></span> </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> ถนน </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentRoad"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> ซอย </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentSoi"></span> </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> ตำบล/แขวง </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentSubdistrict"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> อำเภอ/เขต </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentDistrict"></span> </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> จังหวัด </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentProvinceName"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> รหัสไปรษณีย์ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentZipcode"></span> </div>
                                                        </div>		
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> โทรศัพท์ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentTel"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> โทรสาร </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentFax"></span> </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> โทรศัพท์เคลื่อนที่ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spPermanentMobile"></span> </div>
                                                        </div>
                                                    </div>
                                                    <!-- /section:elements.form -->
                                                </div>

                                            </div>
                                            <br>
                                            <br>
                                            <div class="col-xs-10">
                                                <div class="col-sm-8">
                                                    <h3>ที่อยู่ที่ติดต่อได้</h3>
                                                </div>
                                            </div>
                                            <div class="col-xs-10">
                                                <div class="form-horizontal">
                                                    <!-- #section:elements.form -->
                                                    <div class="profile-user-info profile-user-info-striped">
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> ที่อยู่ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spAddress"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> หมู่ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spMoo"></span> </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> ถนน </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spRoad"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> ซอย </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spSoi"></span> </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> ตำบล/แขวง </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spSubdistrict"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> อำเภอ/เขต </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spDistrict"></span> </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> จังหวัด </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spProvinceName"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> รหัสไปรษณีย์ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spZipcode"></span> </div>
                                                        </div>		
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> โทรศัพท์ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spTel"></span> </div>
                                                            <div style="width:170px;" class="profile-info-name"> โทรสาร </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spFax"></span> </div>
                                                        </div>
                                                        <div class="profile-info-row">
                                                            <div style="width:170px;" class="profile-info-name"> โทรศัพท์เคลื่อนที่ </div>
                                                            <div style="width:200px;" class="profile-info-value"> <span class="editable" id="spMobile"></span> </div>
                                                        </div>
                                                    </div>
                                                    <!-- /section:elements.form -->
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabMemberBeneficiary">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div id="jqGridContainer1" class="row jqGridContainer">
                                            <div class="col-xs-12">
                                                <table id="gridData_QRY020_View_Grid_List"></table>
                                                <div id="gridPager_QRY020_View_jqGrid_List"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabPayment">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div id="jqGridContainer2" class="row jqGridContainer">
                                            <div class="col-xs-12">
                                                <table id="gridData_QRY020_Payment_View_Grid_List"></table>
                                                <div id="gridPager_QRY020_Payment_View_jqGrid_List"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabMemberStatus">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div id="jqGridContainer3" class="row jqGridContainer">
                                            <div class="col-xs-12">
                                                <table id="gridData_QRY020_Member_Status_View_Grid_List"></table>
                                                <div id="gridPager_QRY020_Member_Status_View_jqGrid_List"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabMemberDeptHistory">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div id="jqGridContainer4" class="row jqGridContainer">
                                            <div class="col-xs-12">
                                                <table id="gridData_QRY020_Member_Dept_History_View_Grid_List"></table>
                                                <div id="gridPager_QRY020_Member_Dept_History_View_jqGrid_List"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabMemberPaymentTypeHistory">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div id="jqGridContainer5" class="row jqGridContainer">
                                            <div class="col-xs-12">
                                                <table id="gridData_QRY020_Member_Payment_Type_History_View_Grid_List"></table>
                                                <div id="gridPager_QRY020_Member_Payment_Type_History_jqGrid_List"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabMemberTitleNameHistory">
                                <div class="row">
                                    <div class="col-xs-12">
                                        <div id="jqGridContainer6" class="row jqGridContainer">
                                            <div class="col-xs-12">
                                                <table id="gridData_QRY020_Member_Title_Name_History_View_Grid_List"></table>
                                                <div id="gridPager_QRY020_Member_Title_Name_History_View_jqGrid_List"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="dialogFormSearch" class="hide">
            <div class="bs-component">
                <div class="row" >
                    <form role="form" class="form-horizontal">
                        <div class="form-group" style="margin-bottom:5px">
                            <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> เลขทะเบียนสมาชิก </label>
                            <div class="col-sm-9">
                                <input type="text" id="memberCodeForSearch" name="memberCodeForSearch" >
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;เลขประจำตัวประชาชน
                                <input type="text" id="citizenIdForSearch" name="citizenIdForSearch" >
                            </div>
                        </div>
                        <div class="form-group" style="margin-bottom:5px">
                            <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> ชื่อ </label>
                            <div class="col-sm-9">
                                <input type="text" id="memberNameForSearch" name="memberNameForSearch" >
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;สกุล
                                <input type="text" id="memberSurnameForSearch" name="memberSurnameForSearch" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> หน่วยต้นสังกัด </label>
                            <div class="col-sm-6">
                                <select id="militaryIdForSearch" name="militaryIdForSearch" class="col-xs-10 col-sm-4" id="form-field-3"></select>
                            </div>
                        </div>
                        <div class="col-md-offset-3 col-md-9">
                            <button type="button" id="btnActionSearch" name="btnActionSearch" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple"><span class="ace-icon fa fa-search"></span>ค้นหา</button>
                            <button type="button" id="btnActionSearchReset" name="btnActionSearchReset"  class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>ล้าง</button>
                        </div>
                    </form>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_QRY020_For_Search_jqGrid_List"></table>
                        <div id="gridPager_QRY020_For_Search_jqGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->
