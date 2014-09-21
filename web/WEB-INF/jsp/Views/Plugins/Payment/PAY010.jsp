<%-- 
    Document   : PAY010.jsp รายการรับชำระเงินค่าบำรุงศพ 
    Created on : Sep 7, 2014, 5:22:26 PM
    Author     : bhanumat.w
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <script type="text/javascript">
            var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
            var urlListMemberPayment = rootPath + '/Plugins/Payment/getListMemberPayment.json';
            var urlDeleteMemberPayment = rootPath + '/Plugins/Payment/deleteMemberPayment.json';
            var urlAddMemberPayment = rootPath + '/Plugins/Payment/PAY010_1.htm';
        </script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Payment/action.PAY010.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Payment/jqgrid.PAY010.js"></script>

    </head>
    <body>
        <div class="page-header">
            <h1>
                รายการรับชำระเงินค่าบำรุงศพ
            </h1>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <form class="form-horizontal" id="frmCriterionSearch">                          
                    <div class="form-group">
                        <div class="col-md-1"></div>
                        <label class="col-md-2 control-label no-padding-right" for="paymentDateStart"> วันที่ชำระเงิน</label>
                        <div class="col-md-2">
                            <div class="input-group input-group-sm">
                                <input type="text" class="form-control" name="paymentDateStart" id="paymentDateStart">
                                <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                            </div>
                        </div>
                        <div class="col-md-2"></div> 
                        <label class="col-md-1 control-label no-padding-right" for="paymentDateEnd"> ถึง </label>
                        <div class="col-md-2">
                            <div class="input-group input-group-sm">
                                <input type="text" class="form-control" name="paymentDateEnd" id="paymentDateEnd">
                                <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-1"></div>
                        <label class="col-md-2 control-label no-padding-right" for="memberCode">เลขทะเบียนสมาชิก</label>
                        <div class="col-md-2">
                            <input type="text" class="form-control" name="memberCode" id="memberCode">
                        </div>
                        <div class="col-md-1"></div>
                        <label class="col-md-2 control-label no-padding-right" for="citizenId">เลขประจำตัวประชาชน</label>
                        <div class="col-md-2">
                            <input type="text" class="form-control" name="citizenId" id="citizenId">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-1"></div>
                        <label class="col-md-2 control-label no-padding-right" for="name">ชื่อ</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" name="name" id="name">
                        </div>
                        <label class="col-md-2 control-label no-padding-right" for="surname">สกุล</label>
                        <div class="col-md-3">
                            <input type="text" class="form-control" name="surname" id="surname">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-1"></div>
                        <label class="col-md-2 control-label no-padding-right" for="militaryId">หน่วยต้นสังกัด</label>
                        <div class="col-md-3">
                            <select class="form-control select2" name="militaryId" id="militaryId">
                                <option value="">ทั้งหมด</option>
                            </select>
                        </div>
                        <label class="col-md-2 control-label no-padding-right" for="memberTypeCode">ประเภทการสมัคร</label>
                        <div class="col-md-3">
                            <select class="form-control select2" name="memberTypeCode" id="memberTypeCode">
                                <option value="">ทั้งหมด</option>
                                <option value="10">สมัครด้วยตนเอง</option>
                                <option value="20">สมัครผ่านหน่วยต้นสังกัด</option>
                                <option value="30">สมัครผ่านชุดรับสมัคร</option>
                                <option value="40">สมัครผ่านกรณีพิเศษ</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-1"></div>
                        <label class="col-md-2 control-label no-padding-right" for="memberGroupCode">ประเภทสมาชิก</label>
                        <div class="col-md-3">
                            <select class="form-control select2" name="memberGroupCode" id="memberGroupCode">
                                <option value="">ทั้งหมด</option>
                                <option value="10">ข้าราชการ</option>
                                <option value="20">ลูกจ้าง</option>
                                <option value="30">ครอบครัว</option>
                                <option value="40">พลทหารกองประจำการ</option>
                            </select>
                        </div>
                        <label class="col-md-2 control-label no-padding-right" for="memberStatusCode">สถานะ</label>
                        <div class="col-md-3">
                            <select class="form-control select2" name="memberStatusCode" id="memberStatusCode">
                                <option value="">ทั้งหมด</option>
                                <option value="Y">พิมพ์ใบเสร็จแล้ว</option>
                                <option value="N">ยังไม่พิมพ์ใบเสร็จ</option>
                                <option value="C">ยกเลิกใบเสร็จ</option>
                            </select>
                        </div>                                
                    </div>  
                    <div class="form-group">
                        <div class="col-md-1"></div>
                        <div class="col-md-2"></div>
                        <div class="col-md-3">
                            <button class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple" name="btnSearch" id="btnSearch" type="submit">
                                <i class="ace-icon fa fa-search"></i>ค้นหา
                            </button>
                            <button class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info" type="reset">
                                <i class="ace-icon fa fa-retweet"></i>ล้าง
                            </button>
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
                                        <div style="margin-bottom:5px" class="form-group">
                                            <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> เหตุผลในการยกเลิก </label>
                                            <div class="col-sm-9">
                                                <input type="text" style="width: 400px;">
                                            </div>
                                        </div>
                                    </form>

                                </div>
                            </div>
                            <div class="modal-footer">
                                <button data-dismiss="modal" class="btn btn-sm"> <i class="ace-icon fa fa-times"></i> ยกเลิก </button>
                                <button data-dismiss="modal"  class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i>บันทึก </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div>
                        <button id="btnAdd"   type="button" class="btn btn-sm btn-success" style="font-size: 14px;">
                            <i class="glyphicon glyphicon-plus"></i>&nbsp;ชำระค่าสมัคร
                        </button>
<!--                        <button id="btnCancel"  type="button" class="btn btn-sm btn-danger" style="font-size: 14px;">
                            <i class="glyphicon glyphicon-remove"></i>&nbsp;ยกเลิกใบเสร็จ
                        </button>-->
                    </div>
                </div>
                <!-- Grid View -->
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_MemberPaymentGrid_List"></table>
                        <div id="gridPager_MemberPaymentGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>
    </body></html>