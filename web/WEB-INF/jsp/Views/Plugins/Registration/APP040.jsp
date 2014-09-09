<%-- 
    Document   : APP040
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlListJsonOperation = rootPath + '/Plugins/Registration/getListAPP040.json';
    var urlActionOpenNew = rootPath + '/Plugins/Registration/APP040_2.htm';
    var urlActionOpenView = rootPath + '/Plugins/Registration/APP040_3.htm';

    var responseId = '#main-page-content-loading';
    var listOperation = {};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP040.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP040.js"></script>
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            กำหนดเลขทะเบียนสมาชิก
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
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> วันที่กำหนดเลขทะเบียน</label>
                            <div class="col-sm-5">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="txtApplyDateFromSearch" class="form-control"/>
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> </div>
                                    </div>
                                    <div class="col-xs-5">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> ถึง&nbsp;&nbsp;</label>
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="txtApplyDateEndSearch" class="form-control" />
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> </div>
                                    </div>
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
                        <button id="btnAdd" type="button" class="btn btn-sm btn-success"><i class="ace-icon fa glyphicon-plus"></i>&nbsp;กำหนดเลขทะเบียนสมาชิก</button>
                    </div>
                </div>
                <div style="padding:1px"></div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_OperationGrid_List"></table>
                        <div id="gridPager_OperationGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->