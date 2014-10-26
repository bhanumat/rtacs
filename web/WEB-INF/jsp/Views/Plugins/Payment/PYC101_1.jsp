<%-- 
    Document   : PAY010.jsp รายการรับชำระเงินค่าบำรุงศพ 
    Created on : Sep 7, 2014, 5:22:26 PM
    Author     : bhanumat.w
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript">
    var urlMilitaryPayments = rootPath + '/Plugins/Payment/PYC101.htm';
    var urlListDeptMemberPayment = rootPath + '/Plugins/Payment/getListDeptMemberPayment.json';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Payment/action.PYC101_1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Payment/jqgrid.PYC101_1.js"></script>

<!-- /section:settings.box -->
<div class="page-header">
    <h1>ชำระเงิน
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            แสดงรายการการชำระเงินของหน่วย
            <i class="ace-icon fa fa-angle-double-right"></i>
            รายละเอียด</small>
    </h1>
</div><!-- /.page-header -->
<div class="row">
    <div id="track-changes" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">&nbsp;</h4>
                </div>
                <form>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-6">
                                <h4>
                                    สมัครซ้ำ
                                </h4>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" data-dismiss="modal" class="btn btn-default">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-xs-12">						
        <!-- PAGE CONTENT BEGINS -->						
        <form role="form" class="form-horizontal">
            <input type="hidden" name="deptpaymentId" id="deptpaymentId" value="${deptpaymentId}"/>
            <div class="profile-user-info profile-user-info-striped">
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> หน่วยต้นสังกัด </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${mildeptName}" readonly></span> </div>
                    <div class="profile-info-name" style="width:170px;">วันที่ชำระ </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${paymentDate}" readonly></span> </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> งวดเดือน </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${budgetMonth}" readonly></span> </div>
                    <div class="profile-info-name" style="width:170px;">วันที่บันทึก </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${createdDate}" readonly></span> </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> ยอดชำระ </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${totalAmount}" readonly></span> บาท </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:50px;">จำนวนสมาชิก </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${numMember}" readonly></span> 
                    </div>
                    <div class="profile-info-name" style="width:50px;">เพิ่ม </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${numMemberIn}" readonly></span> </div>
                    <div class="profile-info-name" style="width:50px;">ลด </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${numMemberOut}" readonly></span> </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> หมายเหตุ </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text" value="${remark}" readonly></span>  </div>
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

        <div tabindex="-1" class="modal" id="modal-form" style="display: none;" aria-hidden="true">
            <div style="width: 800px;" class="modal-dialog">
                <div class="modal-content">
                    <div style="padding:5px" class="modal-header">
                        <button data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="blue bigger">บันทึกชำระเงินค่าสมัครสมาชิก</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <form class="form-horizontal" role="form">
                                <!-- #section:elements.form -->
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> ชำระโดย </label>
                                    <div class="col-sm-9">
                                        <label>
                                            <input type="radio" name="form-field-radio" class="ace">
                                            <span class="lbl"> เงินสด</span>
                                        </label>
                                        <span class="middle"></span>
                                        <label>
                                            <input type="radio" name="form-field-radio" class="ace">
                                            <span style="padding-left:10px;" class="lbl"> ธนาณัติ</span>
                                        </label>
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> หมายเลขธนาณัติ </label>
                                    <div class="col-sm-9">
                                        <input type="text">
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> วันที่ชำระ </label>
                                    <div class="col-sm-9">
                                        <fieldset>
                                            <input type="text" id="date_register" />
                                        </fieldset>
                                    </div>
                                </div>	
                                <!-- /section:elements.form -->
                            </form>
                            <div class="col-xs-12">
                                <div style="padding:1px"></div>
                                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th> ลำดับ</th>
                                            <th>เลขทะเบียนสมาชิก </th>
                                            <th>เลขประจำตัวประชาชน </th>
                                            <th> ยศ-คำนำหน้า</th>
                                            <th> ชื่อ </th>
                                            <th> สกุล </th>
                                            <th> ยอดชำระ </th>
                                            <th> สถานะ </th>
                                            <th> รายละเอียด </th>
                                            <th> หน่วยต้นสังกัด </th>
                                            <th> หมายเหตุ</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="center">1</td>
                                            <td>542000872</td>
                                            <td>3-6005-00123-60-7</td>
                                            <td>นาย</td>
                                            <td>กิตติพัฒน์</td>
                                            <td>ศิริชู</td>
                                            <td>210.00</td>
                                            <td>ย้ายออก</td>
                                            <td></td>
                                            <td>รพ.15</td>
                                            <td>ปปป</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-sm"> <i class="ace-icon fa fa-times"></i> ยกเลิก </button>
                        <button data-dismiss="modal"  class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i>บันทึก </button>
                    </div>
                </div>
            </div>
        </div><!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div>

<div class="row">
    <div class="col-xs-12">
        <div style="padding:1px"></div>

        <div id="jqGridContainer" class="col-xs-12">
            <div>
                <table id="gridData_PaymentGrid_List"></table>
                <div id="gridPager_PaymentGrid_List"></div>
            </div>
        </div>

        <div class="clearfix form-actions">
            <div class="col-md-offset-3 col-md-9">
                <a onclick="gotoPrevious()">
                    <button type="button" class="btn">
                        <i class="ace-icon fa fa-undo bigger-110"></i>
                        กลับไปหน้าเดิม
                    </button>
                </a>
            </div>
        </div>
    </div>
</div>