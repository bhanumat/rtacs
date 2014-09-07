<%-- 
    Document   : APP041_2
    Created on : Aug 23, 2014, 5:33:40 PM
    Author     : napat_k
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var myStringList ={};
    var listAPP041 = [];
    var urlListAPP041_2_Add = rootPath + '/Plugins/Registration/getListAPP010.json';
    var urlSaveNew = rootPath + '/Plugins/Registration/setSaveNewAPP041.json';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP041_2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP041_2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP041_2_Add.js"></script>
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ขออนุมัติขึ้นทะเบียนสมาชิกใหม่ 
            <i class="ace-icon fa fa-angle-double-right"></i>
            บันทึกขออนุมัติขึ้นทะเบียนสมาชิกใหม่
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <div id="ListView" class="row">
            <div class="col-xs-12">
                <div class="row">
                    <form id="frmCriterionSearch" class="form-horizontal">                          
                        <div class="form-group">
                            <label for="lbDocDate" class="col-lg-4 control-label"> วันที่ขออนุมัติขึ้นทะเบียนสมาชิก<a style="color: red">* </a></label>
                            <div class="col-lg-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtDocDate" name="txtDocDate" class="form-control"/>
                                    <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbDocCode" class="col-lg-4 control-label"> เลขที่อ้างอิงขออนุมัติขึ้นทะเบียนสมาชิก<a style="color: red">* </a>
                            </label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtDocCode" name="txtDocCode" placeholder="Search">
                            </div>
                        </div>
                    </form>
                </div>
                <br/>
                <div class="row">
                    <div>
                        <button type="button" id="btnAdd" name="btnAdd" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;เลือกสมาชิกใหม่</button>
                        <button type="button" id="btnBack" name="btnBack" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-repeat"></i> กลับหน้าเดิม </button>
                        <button type="button" id="btnSave" name="btnSave" class="btn btn-sm btn-info"><i class="ace-icon fa fa-floppy-o bigger-110"></i> บันทึก </button>
                        <button type="button" id="btnCancel" name="btnCancel" class="btn btn-sm"><i class="ace-icon fa fa-undo bigger-110"></i> ยกเลิก </button>
                        <button class="btn btn-sm btn-pink"><i class="ace-icon fa fa-print align-top bigger-125"></i> พิมพ์ใบสมัคร  </button>
                        <button class="btn btn-sm btn-pink"><i class="ace-icon fa fa-print align-top bigger-125"></i> พิมสรุปจำนวนสมาชิก  </button>
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_APP041_2jqGrid_List"></table>
                        <div id="gridPager_APP041_2jqGrid_List"></div>
                    </div>
                </div>                
            </div>
        </div>

        <div id="dialogFormAdd" class="hide">
            <div class="bs-component">
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbMemberRegistrationNew" class="control-label no-padding-right">เลขทะเบียนสมาชิก</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbIdentificationNumberNew" class="control-label no-padding-right">เลขประจำตัวประชาชน</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbNameNew" class="control-label no-padding-right">ชื่อ</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbCurrencyNew" class="control-label no-padding-right">สกุล</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbGovernmentAgencyNew" class="control-label no-padding-right">หน่วยต้นสังกัด</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbStatusNew" class="control-label no-padding-right">สถานะ</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_APP041_2_Add_jqGrid_List"></table>
                        <div id="gridPager_APP041_2_Add_jqGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
