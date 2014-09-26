<%-- 
    Document   : APP040_2
    Created on : Aug 2, 2014, 11:27:14 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/Registration/getListAPP010_FOR_APP040_2.json';
    var urlSaveNew = rootPath + '/Plugins/Registration/setSaveNewAPP040_2.json';
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    var urlActionListAPP040 = rootPath + '/Plugins/Registration/APP040.htm';
    var responseId = '#main-page-content-loading';
    var listAPP040_2 = {};
    var listMilitaryDepartment = {};
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP040_2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP040_2.js"></script>
<div class="page-header">
    <h1>
        กำหนดเลขทะเบียนสมาชิก  
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            บันทึกกำหนดเลขทะเบียนสมาชิก
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
                            <div class="col-md-1"></div>
                            <!--div class="col-md-2"-->
                            <label for="lbApplyDateFromSearch" class="col-md-2 control-label no-padding-right">วันที่ขอความเห็นชอบ ตั้งแต่
                            </label>
                            <div class="col-md-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtApplyDateFromSearch" name="txtApplyDateFromSearch" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
                            </div>
                            <div class="col-md-2">
                            </div> 
                            <label for="lbApplyDateEndSearch" class="col-md-1 control-label no-padding-right"> ถึง </label>

                            <div class="col-md-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtApplyDateEndSearch" name="txtApplyDateEndSearch" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbCitizenIdSearch" class="col-md-2 control-label no-padding-right">เลขประจำตัวประชาชน</label>
                            <div class="col-md-3">
                                <input id="txtCitizenIdSearch" name="txtCitizenIdSearch" type="text"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbNameSearch" class="col-md-2 control-label no-padding-right">ชื่อ</label>
                            <div class="col-md-3">
                                <input id="txtNameSearch" name="txtNameSearch" type="text"  class="form-control">
                            </div>
                            <label for="lbSurnameSearch" class="col-md-2 control-label no-padding-right">สกุล</label>
                            <div class="col-md-3">
                                <input id="txtSurnameSearch" name="txtSurnameSearch" type="text"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbMilitaryDepartmentSearch" class="col-md-2 control-label no-padding-right">หน่วยต้นสังกัด</label>
                            <div class="col-md-3">
                                <select id="slMilitaryDepartmentSearch" name="slMilitaryDepartmentSearch" class="form-control select2">
                                    <option value="%">ทั้งหมด</option>
                                </select>
                            </div>
                            <label for="lbApplyTypeSearch" class="col-md-2 control-label no-padding-right">ประเภทการสมัคร</label>
                            <div class="col-md-3">
                                <select id="slApplyTypeSearch" name="slApplyTypeSearch" class="form-control select2">
                                    <option value="%">ทั้งหมด</option>
                                    <option value="10">สมัครด้วยตนเอง</option>
                                    <option value="20">สมัครผ่านหน่วยต้นสังกัด</option>
                                    <option value="30">สมัครผ่านชุดรับสมัคร</option>
                                    <option value="40">สมัครผ่านกรณีพิเศษ</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-2"></div>
                            <div class="col-md-3">
                                <button type="button" id="btnSearch" name="btnSearch" class="btn btn-search"><i class="ace-icon fa fa-check-square-o bigger-110"></i>ค้นหา</button>
                                <button type="reset" class="btn btn-primary"><i class="ace-icon fa fa-retweet"></i>&nbsp;ล้าง</button>
                            </div>
                        </div>
                    </form>
                </div>
                <br/>
                <div class="row">
                    <label for="lbMildeptId" align="right">เลขทะเบียนเริ่มต้น&nbsp;&nbsp;</label>
                    <input type="text" id="txtRegisterMemberCode" name="txtRegisterMemberCode">
                    <button type="button" id="btnRegisterNo" name="btnSearch" class="btn btn-sm btn-success"><i class="ace-icon fa glyphicon-plus"></i>กำหนดเลขทะเบียน</button>
                    <button type="button" id="btnBack" name="btnBack" class="btn btn-sm"><i class="ace-icon fa fa-undo"></i>ยกเลิก</button>
                    <button type="button" id="btnRegisterSave" name="btnRegisterSave" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-floppy-o"></i>บันทึก</button>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_APP040_2_Grid_List"></table>
                        <div id="gridPager_APP040_2_Grid_List"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->