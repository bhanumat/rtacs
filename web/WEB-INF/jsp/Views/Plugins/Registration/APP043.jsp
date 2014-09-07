<%-- 
    Document   : APP010_2
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/Registration/getListAPP043.json';
    var urlNew = rootPath + '/Plugins/Registration/setSaveApproveAPP043.json';
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    var responseId = '#main-page-content-loading';
    
    var objectDefault = {};
    var inputToMergeEdit = ['#txtApplyStatus', '#txDocDate'];
    var inputToChangeEdit = ['operationTypeCode', 'docDate'];

    var listMilitaryDepartment = {};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP043.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP043.js"></script>
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ยืนยันการอนุมัติขึ้นทะเบียนสมาชิกใหม่
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
                            <label for="lbDocStartDate" class="col-md-2 control-label no-padding-right">วันที่ขออนุมัติขึ้นทะเบียน ตั้งแต่</label>
                            <!--/div-->  
                            <div class="col-md-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtStartDate" name="txtDocStartDate" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
                            </div>
                            <!--div class="col-md-2"-->
                            <label for="lbDocEndDate" class="col-md-1 control-label no-padding-right"> ถึง </label>
                            <!--/div--> 
                            <div class="col-md-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtEndDate" name="txtDocEndDate" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbReferNumber" class="col-md-2 control-label no-padding-right">เลขที่อ้างอิงขออนุมัติขึ้นทะเบียน</label>
                            <div class="col-md-3">
                                <input id="txtReferNumber" name="txtReferNumber" type="text"  class="form-control">
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
                        <button id="btnCummit" type="button" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;ยืนยันอนุมัติขึ้นทะเบียนสมาชิก</button>
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

        <div id="dialogFormNew" class="hide">
            <div class="bs-component">
                <form class="form-horizontal" name="frmNew" id="frmNew">
                    <fieldset>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-3">
                                <label for="lbApplyStatus" class="control-label no-padding-right">ผลอนุมัติ</label>
                            </div>  
                            <div class="col-md-5">
                                <select id="txtApplyStatus" name="txtApplyStatus" class="form-control select2">
                                    <option value="105">อนุมัติขึ้นทะเบียนเป็นสมาชิก</option>
                                    <option value="234">ไม่อนุมัติขึ้นทะเบียน</option>
                                </select>
                                <!--input id="txtApplyStatus" name="txtApplyStatus" type="text"  class="form-control"-->
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-3">
                                <label for="lbDocDate" class="control-label no-padding-right"> วันที่ขึ้นทะเบียน </label>
                            </div> 
                            <div class="col-md-5">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txDocDate" name="txDocDate" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
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