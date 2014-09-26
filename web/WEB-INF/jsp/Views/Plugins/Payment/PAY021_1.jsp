<%-- 
    Document   : PAY021_1
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlPAY021_1List     = rootPath + '/Plugins/Payment/getPAY021_1List.json';
    var urlSubmitPAY021_1   = rootPath + '/Plugins/Payment/savePAY021_1.json';
    var inputToMergeNew = ['#militaryId', '#registerDate', '#memberIdList', '#militarySumAmount' ];
    var inputToChangeNew = ['militaryId', 'docDate', 'memberIdList', 'sumAmount' ];
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Payment/action.PAY021_1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Payment/jqgrid.PAY021_1.js"></script>
<div class="page-header">
    <h1>ชำระเงิน
        <small>
        <i class="ace-icon fa fa-angle-double-right"></i>
        ชำระเงินค่าสมัครสมาชิก(สมัครผ่านหน่วย) 
        </small>
        <small>
        <i class="ace-icon fa fa-angle-double-right"></i>
        ชำระเงินค่าสมัครสมาชิก 
        </small>
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form role="form" class="form-horizontal" name="formPAY021_1_Detail" id="formPAY021_1_Detail" >
            <input type="hidden" name="militaryId" id="militaryId" value="${militaryId}"/>
            <input type="hidden" name="memberIdList" id="memberIdList"/>
            <div class="profile-user-info profile-user-info-striped">
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> หน่วยต้นสังกัด </div>
                    <div class="profile-info-value"> <span id="militaryNameSp" class="editable"><input type="text" value="${militaryName}" readonly id="militaryName"></span> </div>
                    <div class="profile-info-name" style="width:170px;">วันที่สมัคร </div>
                    <div class="profile-info-value"> <span id="registerDateSp" class="editable"><input type="text" value="${militaryDate}" readonly id="registerDate"></span> </div>
                </div>
            </div>
            <div id="jqGridContainer" class="row">
                <div>
                    <table id="gridData_PAY021_1_Grid_List"></table>
                    <div id="gridPager_PAY021_1_Grid_List"></div>
                </div>
            </div>
            <div class="profile-user-info profile-user-info-striped">
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> จำนวนผู้สมัคร </div>
                    <div class="profile-info-value"> <span id="militaryMemberSp" class="editable"><input type="text" value="${militaryMember}" readonly id="militaryMember"> ราย</span> </div>
                    <div class="profile-info-name" style="width:170px;">รวมยอดชำระ </div>
                    <div class="profile-info-value"> <span id="militarySumAmountSp" class="editable"><input type="text" value="${militarySumAmount}" readonly  id="militarySumAmount"> บาท</span> </div>
                </div>
            </div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button type="button" id="btnSubmit" class="btn btn-info">
                        <i class="ace-icon fa fa-floppy-o bigger-110"></i>
                        รับชำระ
                    </button>
                    &nbsp; &nbsp; &nbsp;
                    <a href="PAY021.html" role="button" class="blue">
                    <button type="reset" class="btn" id="btnCancel">
                        <i class="ace-icon fa fa-undo bigger-110"></i>
                        ยกเลิก
                    </button></a>
                    &nbsp; &nbsp; &nbsp;
                    <button type="button" id="btnBill" class="btn btn-success">
                        <i class="ace-icon fa fa-print bigger-110"></i>
                        ออกใบเสร็จ
                    </button>
                    &nbsp; &nbsp; &nbsp;
                    <a href="#modal-form-cancel" role="button" class="blue" data-toggle="modal">
                        <button type="button" id="btnBillCancel" class="btn btn-danger">
                            <i class="ace-icon fa fa-times bigger-110"></i>
                            ยกเลิกใบเสร็จ
                        </button>
                    </a>
                </div>
            </div>
        </form>
   </div>
</div>