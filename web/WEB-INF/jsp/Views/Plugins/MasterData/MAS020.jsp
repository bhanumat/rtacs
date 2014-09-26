<%-- 
    Document   : MAS020
    Created on : Aug 5, 2014, 03:20:55 AM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/MasterData/getListMAS020.json';
    var urlDelete = rootPath + '/Plugins/MasterData/setDeleteMAS020.json';
    var urlNew = rootPath + '/Plugins/MasterData/setSaveNewMAS020.json';
    var urlEdit = rootPath + '/Plugins/MasterData/setSaveEditMAS020.json';
    var urlLoad = rootPath + '/Plugins/MasterData/getLoadMAS020.json';

    var objectDefault = {};
    var inputToMergeNew = ['#txtTitleDescNew', '#txtTitleNew', 'input[id=chkStatusNew]:checked'];
    var inputToChangeNew = ['titleDesc', 'title', 'status'];

    var inputToMergeEdit = ['#hidTitleIdEdit', '#txtTitleDescEdit', '#txtTitleEdit', 'input[id=chkStatusEdit]:checked'];
    var inputToChangeEdit = ['titleId', 'titleDesc', 'title', 'status'];

    var objIdKeyEdit = 'titleId';

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/MasterData/action.MAS020.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/MasterData/jqgrid.MAS020.js"></script>
<div class="page-header">
    <h1>
        ข้อมูลคำนำหน้า
        <!--<small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ข้อมูลคำนำหน้า
        </small>-->
    
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
                            <label class="col-sm-3 control-label no-padding-right" for="lbTitleDesc"> ชื่อคำนำหน้า : </label>
                            <div class="col-sm-9">
                                <div class="col-sm-4 no-padding-left">
                                    <input type="text" class="form-control" id="txtTitleDesc" name="txtTitleDesc" placeholder="Search">
                                </div>
                                <label class="col-sm-2 control-label no-padding-right" for="lbStatus"> สถานะใช้งาน : </label>
                                <div class="col-sm-2 no-padding-right">
                                    <select name="slStatus" id="slStatus" class="col-xs-10">
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
                <div class="row">
                    <div>
                        <button id="btnAdd" type="button" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;สร้างใหม่</button>
                        <button id="btnReload"  type="button" class="btn btn-sm btn-grey" style="font-size: 14px;"><i class="glyphicon glyphicon-repeat"></i>&nbsp;รีโหลด</button>
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_TitlejqGrid_List"></table>
                        <div id="gridPager_TitlejqGrid_List"></div>
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
                            <label for="lbTitleDescNew" class="col-lg-3 control-label">ชื่อคำนำหน้า *</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtTitleNew" name="txtTitleNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbTitleNew" class="col-lg-3 control-label">คำอธิบาย </label>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control" id="txtTitleDescNew" name="txtTitleDescNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusNew" class="col-lg-3 control-label">สถานะใช้งาน</label>
                            <div class="col-lg-5">
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
                            <label for="lbTitleDescEdit" class="col-lg-3 control-label">ชื่อคำนำหน้า *</label>
                            <div class="col-lg-4">
                                <input type="hidden" id="hidTitleIdEdit" name="hidTitleIdEdit">
                                <input type="text" class="form-control" id="txtTitleEdit" name="txtTitleEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbTitleEdit" class="col-lg-3 control-label">คำอธิบาย </label>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control" id="txtTitleDescEdit" name="txtTitleDescEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusEdit" class="col-lg-3 control-label">สถานะใช้งาน</label>
                            <div class="col-lg-5">
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