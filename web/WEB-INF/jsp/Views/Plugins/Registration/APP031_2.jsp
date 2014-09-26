<%-- 
    Document   : APP031_2
    Created on : Aug 23, 2014, 5:33:40 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlLoad = rootPath + '/Plugins/Registration/getListAPP031_2.json';
    var urlSearchOperationId = rootPath + '/Plugins/Registration/APP030_searchByOperationId.json';
    var urlAPP031 = rootPath + '/Plugins/Registration/APP031.htm';
    var myStringList = "";
    var listAPP031 = [];
    var urlListAPP031_2_Add = rootPath + '/Plugins/Registration/getAddListAPP031_2.json';
    var urlSaveNew = rootPath + '/Plugins/Registration/setSaveNewAPP031.json';
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP031_2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP031_2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP031_2_Add.js"></script>

<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ขอความเห็นชอบสมาชิกใหม่  
            <i class="ace-icon fa fa-angle-double-right"></i>
            บันทึกขอความเห็นชอบสมาชิกใหม่
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <input type="hidden" name="memberId" id="memberId" />
        <input type="hidden" name="operationId" id="operationId" value="${operationId}"/>
        <div id="ListView" class="row">
            <div class="col-xs-12">
                <div class="row">
                    <form id="frmCriterionSearch" class="form-horizontal">                          
                        <div class="form-group">
                            <label for="lbDocDate" class="col-lg-4 control-label"> วันที่ขอความเห็นชอบ<a style="color: red">* </a></label>
                            <div class="col-lg-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtDocDate" name="txtDocDate" class="form-control"/>
                                    <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbDocCode" class="col-lg-4 control-label"> เลขที่อ้างอิงขอความเห็นชอบ<a style="color: red">* </a>
                            </label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtDocCode" name="txtDocCode" >
                            </div>
                        </div>
                    </form>
                </div>
                <br/>
                <div class="row">
                    <div>
                        <button type="button" id="btnAdd" name="btnAdd" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;เลือกสมาชิกใหม่</button>
                        
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_APP031_2jqGrid_List"></table>
                        <div id="gridPager_APP031_2jqGrid_List"></div>
                    </div>
                </div>  
                &nbsp;
                
                <div class="col-md-offset-3 col-md-9" >
                    <button type="button" id="btnBack" name="btnBack" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-repeat"></i> กลับหน้าเดิม </button>
                    <button type="button" id="btnSave" name="btnSave" class="btn btn-sm btn-info"><i class="ace-icon fa fa-floppy-o bigger-110"></i> บันทึก </button>
                    <button type="button" id="btnCancel" name="btnCancel" class="btn btn-sm"><i class="ace-icon fa fa-undo bigger-110"></i> ยกเลิก </button>
                    <button type="button" id="btnPrintRegister" name="btnPrintRegister" class="btn btn-sm btn-pink"><i class="ace-icon fa fa-print align-top bigger-125"></i> พิมพ์ใบสมัคร  </button>
                    <button type="button" id="btnPrintSummary" name="btnPrintSummary" class="btn btn-sm btn-pink"><i class="ace-icon fa fa-print align-top bigger-125"></i> พิมสรุปจำนวนสมาชิก  </button>
                </div>
            </div>
        </div>

        <div id="dialogFormAdd" class="hide">
            <div class="bs-component">
                <div class="row" >
                    <form class="form-horizontal">                          
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> วันที่สมัคร</label>
                            <div class="col-sm-6">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="subDateBegin" name="subDateBegin" class="col-xs-10 col-sm-12"/>
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i></span> 
                                        </div>
                                    </div>
                                    <div class="col-xs-6" >
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> ถึง&nbsp;&nbsp;</label>
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="subDateEnd" name="subDateEnd" class="col-xs-12 col-sm-18" />
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i></span> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> เลขทะเบียนสมาชิก </label>
                            <div class="col-sm-9">
                                <input type="text" id="subMemberCode" name="subMemberCode" class="col-xs-10 col-sm-4"/>
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> เลขประจำตัวประชาชน &nbsp;&nbsp;</label>
                                <input type="text" id="subCitizenId" name="subCitizenId" class="col-xs-10 col-sm-4"/>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ชื่อ </label>
                            <div class="col-sm-9">
                              <input type="text" id="subName" name="subName" class="col-xs-10 col-sm-4"/>
                              <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> สกุล &nbsp;&nbsp;</label>
                              <input type="text" id="subSurname" name="subSurname" class="col-xs-10 col-sm-4"/>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> หน่วยต้นสังกัด </label>
                            <div class="col-sm-9">
                                <select id="subMilitary" name="subMilitary" class="select2 col-xs-10 col-sm-4">
                                    <option value="">ทั้งหมด</option>
                                </select>
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> ประเภทการสมัคร &nbsp;&nbsp;</label>
                                <select name="subMemberTypeCode" id="subMemberTypeCode" class="select2 col-xs-10 col-sm-4">
                                    <option value="">ทั้งหมด</option>
                                    <option value="10">สมัครด้วยตนเอง</option>
                                    <option value="20">สมัครผ่านหน่วยต้นสังกัด</option>
                                    <option value="30">สมัครผ่านชุดรับสมัคร</option>
                                    <option value="40">สมัครผ่านกรณีพิเศษ</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-6 col-lg-offset-4">
                                <button type="button" id="btnSubSearch" name="btnSubSearch" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-search"></i>&nbsp;ค้นหา</button>
                                <button type="button" id="btnSubReset" name="btnSubReset" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-retweet"></i>&nbsp;ล้างข้อมูล</button>
                            </div>
                        </div>
                    </form>
                </div>    
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_APP031_2_Add_jqGrid_List"></table>
                        <div id="gridPager_APP031_2_Add_jqGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
