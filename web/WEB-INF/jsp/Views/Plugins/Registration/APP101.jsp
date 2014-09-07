<%-- 
    Document   : APP101
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/Registration/getListAPP101.json';
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    var responseId = '#main-page-content-loading';

    var listMilitaryDepartment = {};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP101.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP101.js"></script>
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
             รายงานสรุปผู้สมัครสมาชิก
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
                            <label for="lbDocStartDate" class="col-md-2 control-label no-padding-right">วันที่สมัคร ตั้งแต่</label>
                            <!--/div-->  
                            <div class="col-md-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtStartDate" name="txtMemStartDate" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
                            </div>
                            <!--div class="col-md-2"-->
                            <label for="lbDocEndDate" class="col-md-1 control-label no-padding-right"> ถึง </label>
                            <!--/div--> 
                            <div class="col-md-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtEndDate" name="txtMemEndDate" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbNumberMember" class="col-md-2 control-label no-padding-right">เลขทะเบียนสมาชิก</label>
                            <div class="col-md-3">
                                <input id="txtNumberMember" name="txtNumberMember" type="text"  class="form-control">
                            </div>
                            <label for="lbCardID" class="col-md-2 control-label no-padding-right">เลขบัตรประชาชน</label>
                            <div class="col-md-3">
                                <input id="txtCardID" name="txtCardID" type="text"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbFirstName" class="col-md-2 control-label no-padding-right">ชื่อ</label>
                            <div class="col-md-3">
                                <input id="txtFirstName" name="txtFirstName" type="text"  class="form-control">
                            </div>
                            <label for="lbLastName" class="col-md-2 control-label no-padding-right">สกุล</label>
                            <div class="col-md-3">
                                <input id="txtLastName" name="txtLastName" type="text"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbMilitaryIdSearch" class="col-md-2 control-label no-padding-right">หน่วยต้นสังกัด</label>
                            <div class="col-md-3">
                                <select id="slMilitaryIdSearch" name="slMilitaryIdSearch" class="form-control select2">
                                    <option value="%">ทั้งหมด</option>
                                </select>
                            </div>
                            <label for="lbTypeApplySearch" class="col-md-2 control-label no-padding-right">ประเภทการสมัคร</label>
                            <div class="col-md-3">
                                <select id="slTypeApplySearch" name="slTypeApplySearch" class="form-control select2">
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
                <div class="row">
                    <div>
                        <button id="btnPrint" type="button"  class="btn btn-pink "><i class="ace-icon fa fa-print  align-top bigger-125 icon-on-right"></i> พิมพ์รายงาน </button>
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_ExjqGrid_List"></table>
                        <div id="gridPager_ExjqGrid_List"></div>
                    </div>
                </div>     
            </div>
        </div>

        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->