<%-- 
    Document   : PAY020
    Created on : Aug 2, 2014, 11:27:14 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList     = rootPath + '/Plugins/Payment/getListPAY020.json';
    var urlDelete   = rootPath + '/Plugins/Payment/setDeletePAY020.json';
    var urlCancel   = rootPath + '/Plugins/Payment/cancelPAY020.json';
    
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Payment/action.PAY020.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Payment/jqgrid.PAY020.js"></script>
<div class="page-header">
    <h1>
        รายการรับชำระเงินค่าสมัครสมาชิก
        
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <input type="hidden" name="operationMemberId" id="operationMemberId" />
        <div id="ListView" class="row">
            <div class="col-lg-12">
                <div class="row">
                    <form id="frmCriterionSearch" class="form-horizontal">                          
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> วันที่ชำระเงิน</label>
                            <div class="col-sm-4">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="date_begin" name="date_begin" class="form-control"/>
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> 
                                        </div>
                                    </div>
                                    <div class="col-xs-5" >
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> ถึง&nbsp;&nbsp;</label>
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="date_end" name="date_end" class="form-control" />
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i></span> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> เลขประจำตัวประชาชน </label>
                            <div class="col-sm-6">
                                <input type="text" id="citizenId" class="col-xs-10 col-sm-4"/>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ชื่อ </label>
                            <div class="col-sm-6">
                                <input type="text" id="name" class="col-xs-10 col-sm-4"/>
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> สกุล &nbsp;&nbsp;</label>
                                <input type="text" id="surname" class="col-xs-10 col-sm-4"/>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> หน่วยต้นสังกัด </label>
                            <div class="col-sm-6">
                                <select id="military" name="military" class="select2 col-xs-10 col-sm-4">
                                    <option value="">ทั้งหมด</option>
                                </select>
                             
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> ประเภทการสมัคร &nbsp;&nbsp;</label>
                                <select name="memberTypeCode" id="memberTypeCode" class="select2 col-xs-10 col-sm-4">
                                    <option value="">ทั้งหมด</option>
                                    <option value="10">สมัครด้วยตนเอง</option>
                                    <option value="20">สมัครผ่านหน่วยต้นสังกัด</option>
                                    <option value="30">สมัครผ่านชุดรับสมัคร</option>
                                    <option value="40">สมัครผ่านกรณีพิเศษ</option>
                                </select>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ประเภทสมาชิก</label>
                            <div class="col-sm-6">
                                <select name="memberGroupCode" id="memberGroupCode" class="col-xs-10 col-sm-4">
                                    <option value="">ทั้งหมด</option>
                                    <option value="10">ข้าราชการ</option>
                                    <option value="20">ลูกจ้าง</option>
                                    <option value="30">ครอบครัว</option>
                                    <option value="40">พลทหารกองประจำการ</option>
                                </select>
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> สถานะ &nbsp;&nbsp;</label>
                                <select name="printedStatus" id="printedStatus" class="col-xs-10 col-sm-4">
                                    <option value="">ทั้งหมด</option>
                                    <option value="Y">พิมพ์ใบเสร็จ</option>
                                    <option value="N">ยังไม่พิมพ์ใบเสร็จ</option>
                                    <option value="C">ยกเลิกใบเสร็จ</option>						  
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-6 col-lg-offset-4">
                                <button type="button" id="btnSearch" name="btnSearch" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-search"></i>&nbsp;ค้นหา</button>
                                <button type="reset" id="btnReset" name="btnReset" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-retweet"></i>&nbsp;ล้างข้อมูล</button>
                            </div>
                        </div>
                    </form>
                    <br/>
                    <div class="row">
                        <div>
                            <button id="btnAdd"   type="button" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;ชำระค่าสมัคร</button>
                            <button id="btnCancel"  type="button" class="btn btn-sm btn-danger" style="font-size: 14px;"><i class="glyphicon glyphicon-remove"></i>&nbsp;ยกเลิกใบเสร็จ</button>
                        </div>
                    </div>
                    <div id="jqGridContainer" class="row">
                        <div>
                            <table id="gridData_PaymentMemberGrid_List"></table>
                            <div id="gridPager_PaymentMemberGrid_List"></div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div id="dialogFormReason" class="hide">
            <div class="bs-component">
                <form class="form-horizontal" name="frmReason" id="frmReason">
                    <fieldset>
                        <div class="form-group" style="height: 40px;">
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbMildeptIdNew"> เหตุผลในการยกเลิก </label>
                            <div class="col-sm-9">
                                <input type="text" class="col-xs-10 col-sm-5" id="cancelReason" name="cancelReason">
                            </div>
                        </div>
                        
                    </fieldset>
                </form>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->
</div>