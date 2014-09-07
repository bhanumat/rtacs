<%-- 
    Document   : MAS050
    Created on : Aug 3, 2014, 10:36:14 AM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/MasterData/getListMAS050.json';
    var urlDelete = rootPath + '/Plugins/MasterData/setDeleteMAS050.json';
    var urlNew = rootPath + '/Plugins/MasterData/setSaveNewMAS050.json';
    var urlEdit = rootPath + '/Plugins/MasterData/setSaveEditMAS050.json';
    var urlLoad = rootPath + '/Plugins/MasterData/getLoadMAS050.json';
    var urlListJsonBank = rootPath + '/Plugins/MasterData/getListInJSONBank.json';

    var objectDefault = {};
    var inputToMergeNew = ['#slBankCodeNew', '#txtAccTypeNameNew', 'input[id=chkStatusNew]:checked'];
    var inputToChangeNew = ['bankCode', 'accTypeName', 'status'];

    var inputToMergeEdit = ['#hidAccTypeIdEdit', '#slBankCodeEdit', '#txtAccTypeNameEdit', 'input[id=chkStatusEdit]:checked'];
    var inputToChangeEdit = ['accTypeId', 'bankCode', 'accTypeName', 'status'];

    var objIdKeyEdit = 'accTypeId';
    
    var listBank = {};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/MasterData/action.MAS050.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/MasterData/jqgrid.MAS050.js"></script>
<div class="page-header">
    <h1>
        ข้อมูลพื้นฐาน
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ข้อมูลประเภทบัญชีธนาคาร
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
                            <label for="lbAccTypeName" class="col-sm-3 control-label no-padding-right"> ชื่อประเภทบัญชีธนาคาร : </label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtAccTypeNameSearch" name="txtAccTypeNameSearch" placeholder="Search">
                            </div>
                            <br />
                            <br />
                            <label class="col-sm-3 control-label no-padding-right" for="lbBankCodeSearch"> ธนาคาร : </label>
                            <div class="col-sm-9">
                                <div class="col-sm-4 no-padding-left">
                                    <select class="form-control select2" id="slBankCodeSearch" name="slBankCodeSearch">
                                    </select>
                                </div>
                                <label class="col-sm-2 control-label no-padding-right" for="lbStatus"> สถานะใช้งาน : </label>
                                <div class="col-sm-2 no-padding-right">
                                    <select name="slStatusSearch" id="slStatusSearch" class="form-control select2">
                                        <option value="%">ทั้งหมด</option>
                                        <option value="E">ใช้งาน</option>
                                        <option value="D">ไม่ใช้งาน</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-3">
                                <button type="button" id="btnSearch" name="btnSearch" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-search"></i>&nbsp;ค้นหา</button>
                                <button type="reset" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-retweet"></i>&nbsp;ล้าง</button>
                            </div>
                        </div>
                    </form>
                </div>
                <br/>
                <div class="row">
                    <div>
                        <button id="btnAdd" type="button" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;สร้างใหม่</button>
                        <button id="btnReload"  type="button" class="btn btn-sm btn-grey" style="font-size: 14px;"><i class="glyphicon glyphicon-repeat"></i>&nbsp;รีโหลด</button>
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_BankAccountTypejqGrid_List"></table>
                        <div id="gridPager_BankAccountTypejqGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>

        <div id="dialogFormNew" class="hide">
            <div class="bs-component">
                <form class="form-horizontal" name="frmNew" id="frmNew">
                    <fieldset>
                        <div class="form-group" style="height: 40px;">
                        </div>
                        <div class="form-group">
                            <label for="lbslBankCodeNew" class="col-sm-4 control-label">รหัสธนาคาร *</label>
                            <div class="col-sm-6">
                                <select class="form-control select2" name="slBankCodeNew" id="slBankCodeNew">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbAccTypeNameNew" class="col-sm-4 control-label">ประเภทบัญชีธนาคาร</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtAccTypeNameNew" name="txtAccTypeNameNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusNew" class="col-sm-4 control-label">สถานะใช้งาน</label>
                            <div class="col-sm-6">
                                <input type="checkbox" id="chkStatusNew" name="chkStatusNew" value="E">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>

        <div id="dialogFormEdit" class="hide">
            <div class="bs-component">
                <form class="form-horizontal" name="frmEdit" id="frmEdit">
                    <fieldset>
                        <div class="form-group" style="height: 40px;">
                        </div>
                        <div class="form-group">
                            <label for="lbslBankCodeEdit" class="col-sm-4 control-label">รหัสธนาคาร *</label>
                            <div class="col-sm-6"><input id="hidAccTypeIdEdit" name="hidAccTypeIdEdit" type="hidden">
                                <select class="form-control select2" name="slBankCodeEdit" id="slBankCodeEdit">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbAccTypeNameEdit" class="col-sm-4 control-label">ประเภทบัญชีธนาคาร</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtAccTypeNameEdit" name="txtBankNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusEdit" class="col-sm-4 control-label">สถานะใช้งาน</label>
                            <div class="col-sm-6">
                                <input type="checkbox" id="chkStatusEdit" name="chkStatusEdit" value="E">
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