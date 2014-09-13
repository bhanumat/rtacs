<%-- 
    Document   : PAY010.jsp รายการรับชำระเงินค่าบำรุงศพ 
    Created on : Sep 7, 2014, 5:22:26 PM
    Author     : bhanumat.w
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript">
    console.log(rootPath);
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';

</script>
<div class="page-header">
    <h1>
        รายการรับชำระเงินค่าบำรุงศพ
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
            <div class="form-group">
                <div class="col-md-2">
                    <div class="col-lg-12">
                        <div class="col-md-6">
                            <input name="txtAgeNew" class="form-control" id="txtAgeNew" type="text">
                        </div>
                        <div class="col-md-3">
                            <label class="control-label no-padding-right" for="lbAgeYearNew">ปี</label>
                        </div>
                        <div class="col-md-3">
                            <label class="control-label no-padding-right">เพศ<span style="color: red;">*</span></label>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <select name="slGenderNew" class="form-control select2" id="slGenderNew">
                        <option value="">-เลือก-</option>
                        <option value="M">ชาย</option>
                        <option value="F">หญิง</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> วันที่ชำระเงิน </label>
                <div class="col-xs-4">
                    <div class="input-group input-group-sm"></div>
                    <input type="text" id="dateBegin" name="dateBegin" class="form-control"/>
                    <span class="middle" style="padding-left:65px;">ถึง</span>
                    <input type="text" id="dateEnd" name="dateEnd"/>
                </div>
            </div>	
            <div class="form-group">
                <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> เลขทะเบียนสมาชิก</label>
                <div class="col-sm-9">
                    <input type="text" style="width:200px;" >
                    <span class="middle" style="padding-left:15px;">เลขประจำตัวประชาชน</span>
                    <input type="text" style="width:200px;" >
                </div>
            </div>	
            <div class="form-group">
                <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> ชื่อ </label>
                <div class="col-sm-9">
                    <input type="text" style="width:200px;" >
                    <span class="middle" style="padding-left:25px;">ชื่อสกุล</span>
                    <input type="text" style="width:200px;" >
                </div>
            </div>	
            <div class="form-group">
                <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> หน่วยต้นสังกัด </label>
                <div class="col-sm-9">
                    <select  name="select-org"  style="width: 150px">
                        <option value="" selected="selected">&nbsp;</option>
                        <option value="1">กกส.กห.</option>
                        <option value="2">กคช.กช</option>
                        <option value="3">กง.กห.</option>
                        <option value="4">กง.ทหาร</option>
                    </select>
                    <span class="middle" style="padding-left:25px;">ประเภทการสมัคร</span>
                    <select name="select3"  style="width: 150px">
                        <option value="" selected="selected">&nbsp;</option>
                        <option value="1">สมัครด้วยตนเอง</option>
                        <option value="2">สมัครผ่านหน่วยต้นสังกัด</option>
                        <option value="3">สมัครผ่านชุดรับสมัคร</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> ประเภทสมาชิก</label>
                <div class="col-sm-9">
                    <select class="col-xs-10 col-sm-4" id="form-field-4" name="xx3">
                        <option>ทั้งหมด</option>
                        <option value="1">ข้าราชการ</option>
                        <option value="2">ลูกจ้าง</option>
                        <option value="3">ครอบครัว</option>
                        <option value="4">พลทหารกองประจำการ</option>
                    </select>
                    <span class="middle" style="padding-left:80px;">สถานะ</span>
                    <select name="select3"  style="width: 150px">
                        <option value="" selected="selected">&nbsp;</option>
                        <option value="1">พิมพ์ใบเสร็จ</option>
                        <option value="2">ยกเลิกใบเสร็จ</option>
                    </select>
                </div>
            </div>								

            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple"><span class="ace-icon fa fa-search"></span>ค้นหา</button>
                    <button class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>ยกเลิก</button>
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
                        <h4 class="blue bigger">บันทึกชำระเงินค่าบำรุงศพ</h4>
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
                                <div class="table-header">ข้อมูลสมาชิก</div>
                                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th> ลำดับ</th>
                                            <th>รายการ </th>
                                            <th>จำนวนศพ </th>
                                            <th> จำนวนเงิน</th>
                                            <th>ชำระ ?</th>
                                            <th> จำนวนเงินชำระ </th>
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
                                            <td>200.00</td>
                                            <td><input type="text" name="checkbox2" id="checkbox2"></td>

                                        </tr>
                                        <tr>
                                            <td class="center">1</td>
                                            <td>ค่าบำรุงศพประจำเดือน มิ. ย. 2557 ตั้งแต่ศพที่ 1,321/57 ถึงศพที่ 1,720/57 </td>
                                            <td>440</td>
                                            <td>220.00</td>
                                            <td class="center"><input type="checkbox" name="checkbox2" id="checkbox2"></td>
                                            <td>220.00</td>
                                            <td><input type="text" name="checkbox2" id="checkbox2"></td>

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
        </div>
        <!-- PAGE CONTENT ENDS JACK-->
    </div><!-- /.col -->

</div>
<div class="row">
    <div class="col-xs-12">
        <a href="PAY010-1.html" role="button" class="blue">
            <button class="btn btn-sm btn-primary" type="button" id="btnDialog5"> <i class="ace-icon fa glyphicon-plus bigger-110"></i> ชำระเงิน</button></a>
        <a href="#modal-form-cancel" role="button" class="blue" data-toggle="modal">
            <button type="button" class="btn btn-sm btn-danger">
                <i class="ace-icon fa fa-times bigger-110"></i>
                ยกเลิกใบเสร็จ
            </button>
        </a> 
        <div style="padding:1px"></div>
        <div class="table-header">รายชื่อสมาชิก</div>
        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th class="center">ลำดับที่</th>
                    <th> วันที่ชำระเงิน</th>
                    <th>เลขที่ใบเสร็จ</th>
                    <th class="center">เลขทะเบียนสมาชิก</th>
                    <th>หน่วยต้นสังกัด</th>
                    <th>เลขประจำตัวประชาชน</th>
                    <th>ยส - คำนำหน้า</th>
                    <th>ชื่อ</th>
                    <th>สกุล</th>

                    <th>จำนวนเงิน</th>
                    <th> สถานะ</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="center">1</td>
                    <td>8 มิ.ย. 57</td>
                    <td>ฬ0011375</td>
                    <td>5450012551</td>
                    <td>มทบ. 15</td>
                    <td>1234567890123</td>
                    <td>ส.ต.</td>
                    <td>รำไพแข</td>
                    <td>ส่งศร</td>

                    <td>420.00</td>
                    <td><span class="label label-xlg label-success arrowed arrowed-right">พิมพ์ใบเสร็จ</span></td>

                    <td><div class="hidden-sm hidden-xs btn-group"> <a href="#" role="button" class="blue" data-toggle="modal">
                                <button class="btn btn-xs btn-info" id="btnDialog"><i class="ace-icon fa fa-pencil bigger-120"></i></button>
                            </a> <a href="" role="button" class="blue" data-toggle="modal">
                                <button class="btn btn-xs btn-danger" id="btnDialog"><i class="ace-icon fa fa-trash-o bigger-120"></i></button>
                            </a></div>
                        <div class="hidden-md hidden-lg">
                            <div class="inline position-relative">
                                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto"> <i class="ace-icon fa fa-cog icon-only bigger-110"></i></button>
                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li> <a href="#" class="tooltip-info" data-rel="tooltip" title="View"> <span class="blue"> <i class="ace-icon fa fa-search-plus bigger-120"></i></span></a></li>
                                    <li> <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit"> <span class="green"> <i class="ace-icon fa fa-pencil-square-o bigger-120"></i></span></a></li>
                                    <li> <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete"> <span class="red"> <i class="ace-icon fa fa-trash-o bigger-120"></i></span></a></li>
                                </ul>
                            </div>
                        </div></td>
                </tr>
                <tr>
                    <td class="center">1</td>
                    <td>8 มิ.ย. 57</td>
                    <td>ฬ0011374</td>
                    <td>5450012551</td>
                    <td>มทบ. 15</td>
                    <td>1234567890123</td>
                    <td>ส.ต.</td>
                    <td>รำไพแข</td>
                    <td>ส่งศร</td>
                    <td>400.00</td>
                    <td><span class="label label-xlg label-success arrowed arrowed-right">พิมพ์ใบเสร็จ</span></td>
                    <td><div class="hidden-sm hidden-xs btn-group"> <a href="#" role="button" class="blue" data-toggle="modal">
                                <button class="btn btn-xs btn-info" id="btnDialog"><i class="ace-icon fa fa-pencil bigger-120"></i></button>
                            </a> <a href="" role="button" class="blue" data-toggle="modal">
                                <button class="btn btn-xs btn-danger" id="btnDialog"><i class="ace-icon fa fa-trash-o bigger-120"></i></button>
                            </a></div>
                        <div class="hidden-md hidden-lg">
                            <div class="inline position-relative">
                                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto"> <i class="ace-icon fa fa-cog icon-only bigger-110"></i></button>
                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li> <a href="#" class="tooltip-info" data-rel="tooltip" title="View"> <span class="blue"> <i class="ace-icon fa fa-search-plus bigger-120"></i></span></a></li>
                                    <li> <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit"> <span class="green"> <i class="ace-icon fa fa-pencil-square-o bigger-120"></i></span></a></li>
                                    <li> <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete"> <span class="red"> <i class="ace-icon fa fa-trash-o bigger-120"></i></span></a></li>
                                </ul>
                            </div>
                        </div></td>
                </tr>
                <tr>
                    <td class="center">1</td>
                    <td>8 มิ.ย. 57</td>
                    <td>ฬ0011373</td>
                    <td>5450012551</td>
                    <td>มทบ. 15</td>
                    <td>1234567890123</td>
                    <td>ส.ต.</td>
                    <td>รำไพแข</td>
                    <td>ส่งศร</td>

                    <td>400.00</td>
                    <td><span class="label label-xlg label-success arrowed arrowed-right">พิมพ์ใบเสร็จ</span></td>

                    <td><div class="hidden-sm hidden-xs btn-group"> <a href="#" role="button" class="blue" data-toggle="modal">
                                <button class="btn btn-xs btn-info" id="btnDialog"><i class="ace-icon fa fa-pencil bigger-120"></i></button>
                            </a> <a href="" role="button" class="blue" data-toggle="modal">
                                <button class="btn btn-xs btn-danger" id="btnDialog"><i class="ace-icon fa fa-trash-o bigger-120"></i></button>
                            </a></div>
                        <div class="hidden-md hidden-lg">
                            <div class="inline position-relative">
                                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto"> <i class="ace-icon fa fa-cog icon-only bigger-110"></i></button>
                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li> <a href="#" class="tooltip-info" data-rel="tooltip" title="View"> <span class="blue"> <i class="ace-icon fa fa-search-plus bigger-120"></i></span></a></li>
                                    <li> <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit"> <span class="green"> <i class="ace-icon fa fa-pencil-square-o bigger-120"></i></span></a></li>
                                    <li> <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete"> <span class="red"> <i class="ace-icon fa fa-trash-o bigger-120"></i></span></a></li>
                                </ul>
                            </div>
                        </div></td>
                </tr>
                <tr>
                    <td class="center">1</td>
                    <td>8 มิ.ย. 57</td>
                    <td>ฬ0011372</td>
                    <td>5450012551</td>
                    <td>มทบ. 15</td>
                    <td>1234567890123</td>
                    <td>ส.ต.</td>
                    <td>รำไพแข</td>
                    <td>ส่งศร</td>

                    <td>410.00</td>
                    <td><span class="label label-xlg label-yellow arrowed arrowed-right">ยกเลิกใบเสร็จ</span></td>

                    <td><div class="hidden-sm hidden-xs btn-group"> <a href="#" role="button" class="blue" data-toggle="modal">
                                <button class="btn btn-xs btn-info" id="btnDialog"><i class="ace-icon fa fa-pencil bigger-120"></i></button>
                            </a> <a href="#" role="button" class="blue" data-toggle="modal">
                                <button class="btn btn-xs btn-danger" id="btnDialog"><i class="ace-icon fa fa-trash-o bigger-120"></i></button>
                            </a></div>
                        <div class="hidden-md hidden-lg">
                            <div class="inline position-relative">
                                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto"> <i class="ace-icon fa fa-cog icon-only bigger-110"></i></button>
                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                    <li> <a href="#" class="tooltip-info" data-rel="tooltip" title="View"> <span class="blue"> <i class="ace-icon fa fa-search-plus bigger-120"></i></span></a></li>
                                    <li> <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit"> <span class="green"> <i class="ace-icon fa fa-pencil-square-o bigger-120"></i></span></a></li>
                                    <li> <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete"> <span class="red"> <i class="ace-icon fa fa-trash-o bigger-120"></i></span></a></li>
                                </ul>
                            </div>
                        </div></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- /.col -->
</div>