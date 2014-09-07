<%-- 
    Document   : Groups
    Created on : Jun 7, 2014, 7:50:13 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/Security/getListGroups.json';
    var urlDelete = rootPath + '/Plugins/Security/setDeleteGroups.json';
    var urlNew = rootPath + '/Plugins/Security/setSaveNewGroups.json';
    var urlEdit = rootPath + '/Plugins/Security/setSaveEditGroups.json';
    var urlLoad = rootPath + '/Plugins/Security/getLoadGroups.json';

    var objectDefault = {};
    var inputToMergeNew = ['#txtGroupsNameNew', '#txtGroupsDescriptionNew', 'input[id=chkFlagNew]:checked'];
    var inputToChangeNew = ['groupsName', 'groupsDescription', 'flag'];

    var inputToMergeEdit = ['#hidGroupsIdEdit', '#txtGroupsNameEdit', '#txtGroupsDescriptionEdit', 'input[id=chkFlagEdit]:checked'];
    var inputToChangeEdit = ['groupsId', 'groupsName', 'groupsDescription', 'flag'];

    var objIdKeyEdit = 'groupsId';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Security/action.Groups.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Security/jqgrid.Groups.js"></script>
<div class="page-header">
    <h1>
        กลุ่ม
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ข้อมูลกลุ่ม
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
                            <label for="GroupsName" class="col-lg-4 control-label">ชื่อกลุ่มผู้ใช้งาน : </label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtGroupsName" name="txtGroupsName" placeholder="Search">
                            </div>
                        </div>                                      
                        <div class="form-group">
                            <div class="col-lg-12 col-lg-offset-4">
                                <button type="button" id="btnSearch" name="btnSearch" class="btn btn-primary"><i class="glyphicon glyphicon-search"></i>&nbspSearch</button>
                                <button type="reset" class="btn btn-primary"><i class="glyphicon glyphicon-trash"></i>&nbspClear</button>
                            </div>
                        </div>
                    </form>
                </div>
                <br/>
                <div class="row">
                    <div>
                        <button id="btnAdd" type="button" class="btn btn-primary" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;เพิ่มข้อมูลหน่วยต้นสังกัด</button>
                        <button id="btnDelete"  type="button" class="btn btn-primary" style="font-size: 14px;"><i class="glyphicon glyphicon-minus"></i>&nbsp;Delete</button>
                        <button id="btnReload"  type="button" class="btn btn-primary" style="font-size: 14px;"><i class="glyphicon glyphicon-repeat"></i>&nbsp;Reload</button>
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
                            <label for="txtGroupsNameNew" class="col-lg-3 control-label">ชื่อกลุ่ม *</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtGroupsNameNew" name="txtGroupsNameNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtGroupsDescriptionNew" class="col-lg-3 control-label">คำอธิบาย</label>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control" id="txtGroupsDescriptionNew" name="txtGroupsDescriptionNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="chkFlagNew" class="col-lg-3 control-label">สถานะการใช้งาน</label>
                            <div class="col-lg-5">
                                <input type="checkbox" id="chkFlagNew" name="chkFlagNew" value="Y">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>

        <div id="dialogFormEdit" class="hide">
            <div class="well bs-component">
                <form class="form-horizontal" name="frmEdit" id="frmEdit">
                    <fieldset>
                        <div class="form-group">
                            <label for="txtGroupsNameEdit" class="col-lg-3 control-label">ชื่อกลุ่ม *</label>
                            <div class="col-lg-4"><input type="hidden" id="hidGroupsIdEdit" name="hidGroupsIdEdit">
                                <input type="text" class="form-control" id="txtGroupsNameEdit" name="txtGroupsNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtGroupsDescriptionEdit" class="col-lg-3 control-label">คำอธิบาย</label>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control" id="txtGroupsDescriptionEdit" name="txtGroupsDescriptionEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="chkFlagEdit" class="col-lg-3 control-label">สถานะการใช้งาน</label>
                            <div class="col-lg-5">
                                <input type="checkbox" id="chkFlagEdit" name="chkFlagEdit" value="Y">
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