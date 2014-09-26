<%-- 
    Document   : CHT010
    Created on : Sep 21, 2014, 5:20:18 PM
    Author     : TeTe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList_CHT010 = rootPath + '/Plugins/ChangeData/loadCHT010.json';
    var urlConfirm_CHT010 = rootPath + '/Plugins/ChangeData/confirmCHT010.json';
    
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/ChangeData/action.CHT010.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/ChangeData/jqgrid.CHT010.js"></script>
<div class="page-header">
    <h1>เปลี่ยนแปลงข้อมูล
        <small> 
            <i class="ace-icon fa fa-angle-double-right"></i>
                เปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล
            <i class="ace-icon fa fa-angle-double-right"></i>
            รายการขอการเปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล
        </small>
    </h1>
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <div id="ListView" class="row">
            <div class="col-lg-12">
                <div class="row">
                    <form id="frmCriterionSearch" class="form-horizontal">    
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> วันที่ขอเปลี่ยน</label>
                            <div class="col-sm-5">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="date_begin" class="form-control"/>
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> 
                                        </div>
                                    </div>
                                    <div class="col-xs-6">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ถึง&nbsp;&nbsp;</label>
                                        <div class="input-group input-group-sm">
                                        <input type="text" id="date_end" class="form-control" />
                                        <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> เลขประจำตัวประชาชน </label>
                            <div class="col-sm-6">
                                <input type="text" id="citizenId" maxlength="13" class="col-xs-10 col-sm-4"/>
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> เลขทะเบียนสมาชิก &nbsp;&nbsp;</label>
                                <input type="text" id="memberCode" class="col-xs-10 col-sm-4"/>
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
                                <select name="memberTypeCode" id="memberTypeCode" class="col-xs-10 col-sm-4">
                                     <option value="">ทั้งหมด</option>
                                    <option value="10">สมัครด้วยตนเอง</option>
                                    <option value="20">สมัครผ่านหน่วยต้นสังกัด</option>
                                    <option value="30">สมัครผ่านชุดรับสมัคร</option>
                                    <option value="40">สมัครผ่านกรณีพิเศษ</option>
                                </select>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ประเภทการเปลี่ยนแปลง</label>
                            <div class="col-sm-6">
                                <select name="fileTypeCode" id="fileTypeCode" class="col-xs-10 col-sm-4">
                                    <option value="">ทั้งหมด</option>
                                    <option value="10">แจ้งด้วยตนเอง</option>
                                    <option value="20">แจ้งผ่านหน่วยต้นสังกัด</option>
                                    <option value="30">แจ้งกรณีพิเศษ</option>
                                </select>
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> สถานะ &nbsp;&nbsp;</label>
                                <select name="approved" id="approved" class="col-xs-10 col-sm-4">
                                    <option value="">ทั้งหมด</option>
                                    <option value="0">อยู่ระหว่างดำเนินการ</option>
                                    <option value="1">ได้รับอนุมัติแล้ว</option>
                                    <option value="2">ไม่ผ่านการอนุมัติ</option>					
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
                            <button class="btn btn-sm btn-primary" type="button" id="btnAdd"> <i class="ace-icon fa glyphicon-plus bigger-110"></i> เพิ่มรายการใหม่ </button>
                            <button class="btn btn-white btn-info btn-bold" type="button" id="btnConfirm"> <i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> ยืนยันการเปลี่ยนแปลง </button>
                        </div>
                    </div>
                    <div id="jqGridContainer" class="row">
                        <div>
                            <table id="gridData_CHT010Grid_List"></table>
                            <div id="gridPager_CHT010Grid_List"></div>
                        </div>
                    </div>
		
                    <div id="dialogFormConfirm" class="hide">
                        <div class="bs-component">
                            <form class="form-horizontal" name="frmConfirm" id="frmConfirm">
                                <fieldset>
                                    <div class="form-group" style="height: 40px;">
                                    </div>
                                    <div style="margin-bottom:5px" class="form-group">
                                        <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> สถานะ </label>
                                        <div class="col-sm-9">
                                            <select name="confirmType" id="confirmType" style="width: 150px">
                                                <option value="" selected="selected">-เลือก-&nbsp;</option>
                                                <option value="1">ได้รับอนุมัติแล้ว</option>
                                                <option value="2">ไม่ผ่านการอนุมัติ</option>
                                            </select>
                                        </div>
                                        <br>
                                        <br>
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> วันที่ </label>
                                        <div class="col-sm-9">
                                            <div class="row">
                                                <div class="col-xs-5">
                                                    <div class="input-group input-group-sm">
                                                        <input type="text" id="date_register" class="col-xs-13 col-sm-18"/>
                                                        <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>
