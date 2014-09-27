<%-- 
    Document   : PAY010_1 รับชำระเงินค่าบำรุงศพ 
    Created on : Sep 7, 2014, 6:04:15 PM
    Author     : bhanumat.w
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    var urlListMember = rootPath + '/Plugins/Payment/getMembers.json';
    var urlListMemberPayment = rootPath + '/Plugins/Payment/getListMemberPAY010_1.json';
    var urlMember = rootPath + '/Plugins/Payment/getMemberPAY010_1.json';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Payment/action.PAY010_1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Payment/jqgrid.PAY010_1.js"></script>

<div class="page-header">
    <h1>
        รับชำระเงินค่าบำรุงศพ 
    </h1>
</div><!-- /.page-header -->
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <div class="col-sm-12">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">เรียกค้นข้อมูลสมาชิก</h4>
                    </div>
                    <div class="widget-body">
                        <div class="widget-body">
                            <div class="widget-main">
                                <form class="form-horizontal">
                                    <div class="row" style="margin-bottom:5px">
                                        <div class="col-xs-12 col-sm-3" align="right">
                                            <div class="bigger-110" >
                                                <label class="position-relative">
                                                    <input type="radio" class="ace" name="searchType" id="searchTypeCitizenid" checked="checked">
                                                    <span class="lbl"></span> เลขประจำตัวประชาชน 
                                                </label>
                                                &nbsp;&nbsp;
                                                <label class="position-relative">
                                                    <input type="radio" class="ace" name="searchType" id="searchTypeMemberCode">
                                                    <span class="lbl"></span> เลขทะเบียนสมาชิก
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-2">
                                            <div class="input-group">
                                                <input id="txtSearch" type="text" class="form-control search-query" placeholder="">
                                                <span class="input-group-btn">
                                                    <button id="btnSearch" type="button" class="btn btn-info btn-sm"> แสดง <i class="ace-icon fa fa-check icon-on-right bigger-110"></i> </button>
                                                </span> </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-2">
                                            <a href="#modal-form" role="button" class="blue" data-toggle="modal">
                                                <button type="button" class="btn btn-purple btn-sm"> ค้นหา <i class="ace-icon fa fa-search icon-on-right bigger-110"></i> </button>
                                            </a>
                                        </div>
                                    </div>
                                </form>
                                <form class="form-horizontal" role="form">
                                    <!-- #section:elements.form -->

                                    <!-- /section:elements.form -->
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>						
        <!-- PAGE CONTENT BEGINS -->						

        <form role="form" class="form-horizontal">
            <div class="profile-user-info profile-user-info-striped">
                <input type="hidden" id="memberId"/>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;">เลขทะเบียนสมาชิก</div>
                    <div class="profile-info-value"> <span id="lblMemberCode" class="memberCode"></span> </div>
                    <div class="profile-info-name" style="width:170px;">เลขประจำตัวประชาชน</div>
                    <div class="profile-info-value"> <span id="lblCitizenId" class="citizenId"></span> </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;">ชื่อ-สกุล</div>
                    <div class="profile-info-value"> <span id="lblName" class="editable"></span> </div>
                    <div class="profile-info-name" style="width:170px;">หน่วยต้นสังกัด</div>
                    <div class="profile-info-value"> <span id="lblMilitaryName" class="editable"></span> </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;">ชำระโดย</div>
                    <div class="profile-info-value">
                        <span id="username" class="editable">
                            <label>
                                <input type="radio" name="paymentTypeCode" id="paymentTypeCode20" class="ace" value="20"/>
                                <span class="lbl"> เงินสด</span>
                            </label>
                            <span class="middle"></span>
                            <label>
                                <input type="radio" name="paymentTypeCode" id="paymentTypeCode21" class="ace" value="21"/>
                                <span style="padding-left:10px;" class="lbl"> ธนาณัติ</span>
                            </label>
                        </span> 
                    </div>
                    <div class="profile-info-name" style="width:170px;">หมายเลขธนาณัติ </div>
                    <div class="profile-info-value">
                        <span id="username" class="editable">
                            <input name="paymentTypeCode21No" id="paymentTypeCode21No" type="text"/>
                        </span>
                    </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> วันที่ชำระ</div>
                    <div class="input-group input-group-sm" style="width:170px;">
                        <input type="text" class="form-control" name="paymentDate" id="paymentDate">
                        <span class="input-group-addon"><i class="ace-icon fa fa-calendar"/></span>
                    </div>
                    <div class="profile-info-name" style="width:170px;"> สถานะสมาชิก</div>
                    <div class="profile-info-value">
                        <span id="username" class="editable">
                            <span class="label label-xlg label-yellow arrowed arrowed-right">ค้างชำระ 1 เดือน</span>
                        </span>
                    </div>
                </div>		
            </div>									
        </form>

        <div tabindex="-1" class="modal" id="modal-form-cancel" style="display: none;" aria-hidden="true">
            <div style="width: 800px;" class="modal-dialog">
                <div class="modal-content">
                    <div style="padding:5px" class="modal-header">
                        <button data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="blue bigger">ยกเลิกใบเสร็จ</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <form class="form-horizontal" role="form">
                                <!-- #section:elements.form -->
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> เหตุผลในการยกเลิก </label>
                                    <div class="col-sm-9">
                                        <input type="text" style="width: 400px;">
                                    </div>
                                </div>
                                <!-- /section:elements.form -->
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-sm"> <i class="ace-icon fa fa-times"></i> ยกเลิก </button>
                        <button data-dismiss="modal"  class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i>บันทึก </button>
                    </div>
                </div>
            </div>
        </div><!-- PAGE CONTENT ENDS -->

        <div aria-hidden="true" style="display: none;" id="modal-form" class="modal" tabindex="-1">
            <div class="modal-dialog" style="width: 1000px;">
                <div class="modal-content">
                    <div class="modal-header" style="padding:5px">
                        <button type="button" class="close" data-dismiss="modal">×</button>
                        <h4 class="blue bigger">เรียกค้นข้อมูลสมาชิก </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <form role="form" class="form-horizontal">
                                <!-- #section:elements.form -->
                                <div class="form-group" style="margin-bottom:5px">
                                    <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> เลขทะเบียนสมาชิก </label>
                                    <div class="col-sm-9">
                                        <input type="text" name="memberCode" id="memberCode">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;เลขประจำตัวประชาชน
                                        <input type="text"  name="idCard" id="idCard">
                                    </div>
                                </div>
                                <div class="form-group" style="margin-bottom:5px">
                                    <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> ชื่อ </label>
                                    <div class="col-sm-9">
                                        <input type="text" name="name" id="name">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;สกุล
                                        <input type="text"  name="surname" id="surname">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> หน่วยต้นสังกัด </label>
                                    <div class="col-sm-6">
                                        <select class="col-xs-10 col-sm-4" name="militaryDeptId" id="militaryDeptId">
                                            <option value="">ทั้งหมด</option>
                                        </select>
                                        <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> สถานะ &nbsp;&nbsp;</label>
                                        <select class="col-xs-10 col-sm-4" name="status" id="status">
                                            <option value="">ทั้งหมด</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-offset-3 col-md-9">
                                    <button id="btnSearchAdvance"  type="button" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple">
                                        <span class="ace-icon fa fa-search"></span>ค้นหา
                                    </button>
                                    <button id="btnClearAdvance" type="reset" id="btnResetSearch" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info">
                                        <span class="ace-icon fa fa-retweet"></span>ล้าง
                                    </button>
                                </div>
                                <!-- /section:elements.form -->
                            </form>
                            
                            <div id="jqGridContainer" class="col-xs-12">
                                <div>
                                    <table id="gridData_MemberGrid_List"></table>
                                    <div id="gridPager_MemberGrid_List"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="btnSearchAdvanceSelect" class="btn btn-sm btn-primary" data-dismiss="modal"> <i class="ace-icon fa fa-check"></i> เลือก </button>
                        <button class="btn btn-sm" data-dismiss="modal"> <i class="ace-icon fa fa-times"></i> ไม่เลือก </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->

</div>
<div class="row">
    <div class="col-xs-12">
        <div style="padding:1px"></div>
                            
        <div id="jqGridContainer" class="col-xs-12">
            <div>
                <table id="gridData_MemberPaymentGrid_List"></table>
                <div id="gridPager_MemberPaymentGrid_List"></div>
            </div>
        </div>
        
<!--        <div class="table-header">ข้อมูลสมาชิก</div>
        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th> ลำดับ</th>
                    <th>รายการ </th>
                    <th>จำนวนศพ </th>
                    <th> จำนวนเงิน</th>
                    <th>ชำระ ?</th>
                    <th> หมายเหตุ</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="center">1</td>
                    <td>ค่าบำรุงศพประจำเดือน พ.ค. 2557 ตั้งแต่ศพที่ 1,321/57 ถึงศพที่ 1,720/57 </td>
                    <td>400</td>
                    <td>200.00</td>
                    <td class="center"><input type="checkbox" name="checkbox2" id="checkbox2"></td>
                    <td><input type="text" name="checkbox2" id="checkbox2"></td>
                </tr>
                <tr>
                    <td class="center">2</td>
                    <td>ค่าบำรุงศพประจำเดือน มิ. ย. 2557 ตั้งแต่ศพที่ 1,321/57 ถึงศพที่ 1,720/57 </td>
                    <td>440</td>
                    <td>220.00</td>
                    <td class="center"><input type="checkbox" name="checkbox2" id="checkbox2"></td>
                    <td><input type="text" name="checkbox2" id="checkbox2"></td>
                </tr>
            </tbody>
        </table>-->
    </div>
</div>

<div class="row">
    <div class="col-xs-12">
        <div class="clearfix form-actions">
            <div class="col-md-offset-3 col-md-9">
                <button type="button" id="bootbox-submit" class="btn btn-info">
                    <i class="ace-icon fa fa-floppy-o bigger-110"></i>
                    รับชำระ
                </button>
                &nbsp; &nbsp; &nbsp;
                <button type="reset" class="btn">
                    <i class="ace-icon fa fa-undo bigger-110"></i>
                    ยกเลิก
                </button>
                &nbsp; &nbsp; &nbsp;
                <button type="button" id="bootbox-submit" class="btn btn-success">
                    <i class="ace-icon fa fa-print bigger-110"></i>
                    พิมพ์ใบเสร็จ
                </button>
                &nbsp; &nbsp; &nbsp;
                <a href="#modal-form-cancel" role="button" class="blue" data-toggle="modal">
                    <button type="button" id="bootbox-submit" class="btn btn-danger">
                        <i class="ace-icon fa fa-times bigger-110"></i>
                        ยกเลิกใบเสร็จ
                    </button>
                </a>								
            </div>
        </div>
    </div>
    <!-- /.col -->
</div>