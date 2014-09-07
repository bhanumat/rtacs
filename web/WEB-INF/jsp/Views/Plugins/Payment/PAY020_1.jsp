<%-- 
    Document   : PAY020_1
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlSearch = rootPath + '/Plugins/Payment/getSearchPAY020_1.json';
    var urlLoad = rootPath + '/Plugins/Payment/onLoadPAY020_1.json';
    var urlNew = rootPath + '/Plugins/Payment/addNewPAY020_1.json';
    var urlCancel = rootPath + '/Plugins/Payment/cancelPAY020.json';
    var urlSearchOperationMemberId = rootPath + '/Plugins/Payment/searchByOperationMemberId.json';
    var inputToMergeNew = ['#citizenFindId', '#docDate', '#docCode', '#amount' ];
    var inputToChangeNew = ['citizenId', 'docDate', 'docCode', 'amount' ];

    var objIdKeyEdit = 'operationId';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Payment/action.PAY020_1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Payment/jqgrid.PAY020_1.js"></script>
<div class="page-header">
    <h1>
        ชำระเงิน
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            บันทึกรับชำระเงินค่าสมัครสมาชิก
        </small>
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <input type="hidden" name="memberId" id="memberId" />
        <input type="hidden" name="hiddenStatus" id="hiddenStatus" />
        <input type="hidden" name="operationMemberId" id="operationMemberId" value="${operationMemberId}"/>
        <!-- PAGE CONTENT BEGINS -->
        <form class="form-horizontal" name="formDetail" id="formDetail">
        <div id="ListView" class="row">
            <div class="col-lg-12">
                <div class="row">
                    <form id="frmCriterionSearch" class="form-horizontal">                          
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> เลขประจำตัวประชาชน* </label>
                            <div class="col-xs-12 col-sm-3">
                                <div class="input-group">
                                    <input id="citizenFindId" type="text" class="form-control search-query" placeholder="ระบุเลขประจำตัวประชาชน">
                                    <span class="input-group-btn"> <a href="#" role="button" class="blue" data-toggle="modal">
                                            <button type="button" id="btnSearch" class="btn btn-purple btn-sm"> แสดง <i class="ace-icon fa fa-search icon-on-right bigger-110"></i> </button>
                                        </a> </span> </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form role="form" class="form-horizontal">
                                <div class="profile-user-info profile-user-info-striped">

                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> เลขประจำตัวประชาชน </div>
                                        <div class="profile-info-value"> <span id="citizenID" class="editable"></span> </div>
                                        <div class="profile-info-name" style="width:170px;"> สถานะ </div>
                                        <div class="profile-info-value"> <span id="status" class="editable"></span> </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ชื่อ-สกุล</div>
                                        <div class="profile-info-value" style="width:300px;"> <span id="username" ></span> </div>
                                        <div class="profile-info-name" style="width:170px;">หน่วยต้นสังกัด </div>
                                        <div class="profile-info-value" style="width:300px;"><span id="militaryName" class="editable"></span></div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> วันที่ชำระ</div>
                                        <div class="input-group input-group-sm"  style="width:170px;" >
                                            <input type="text" id="docDate" name="docDate" class="form-control" />
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i></span> 
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> เลขที่ใบเสร็จ</div>
                                        <div class="profile-info-value" style="width:300px;"><input id="docCode" class="editable" disabled="true"/></div>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </form>
                </div>
                <!-- #section:elements.tab.option -->
                <div class="row">
                    <div class="table-header">รายการชำระเงิน</div>
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th> ลำดับ</th>
                                <th>รายการ </th>

                                <th> จำนวนเงิน</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="center">1</td>
                                <td>ค่าสมัครสมาชิก</td>

                                <td><input id="amount" disabled="true"></span></td>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-offset-3 col-md-9">
                <button type="button" id="btnSubmit" class="btn btn-info">
                    <i class="ace-icon fa fa-floppy-o bigger-110"></i>รับชำระ
                </button>
                &nbsp; &nbsp; &nbsp;
                <button type="button" class="btn" id="btnCancel" class="btn btn-rotate">
                    <i class="ace-icon fa fa-undo bigger-110"></i>ยกเลิก
                </button>
                &nbsp; &nbsp; &nbsp;
                <button type="button" class="hide" id="btnPrint" class="btn btn-success">
                    <i class="ace-icon fa fa-print bigger-110"></i>พิมพ์ใบเสร็จ
                </button>
                &nbsp; &nbsp; &nbsp;
                <a href="#modal-form-cancel" role="button" class="blue" data-toggle="modal">
                    <button type="button" class="hide" id="btnBillCancel" class="btn btn-danger">
                        <i class="ace-icon fa fa-times bigger-110"></i>ยกเลิกใบเสร็จ
                    </button>
                </a>
            </div>
            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
        </form>
    </div><!-- /.row -->

    <!-- basic scripts -->

    <!-- inline scripts related to this page -->