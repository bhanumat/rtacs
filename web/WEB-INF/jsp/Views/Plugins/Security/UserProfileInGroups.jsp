<%-- 
    Document   : UserProfileInGroups
    Created on : Jun 29, 2014, 1:05:05 AM
    Author     : ITOS
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/Security/getListUserProfileInGroups.json';    
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Security/action.Groups.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Security/jqgrid.Groups.js"></script>
<div class="page-header">
    <h1>
        ผู้ใช้งาน
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ข้อมูลผู้ใช้งาน
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
                            <label for="GroupsName" class="col-lg-4 control-label">ชื่อกลุ่ม : </label>
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
            <div class="well bs-component">
                <form class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">รหัสหน่วยงานต้นสังกัด *</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="inputEmail" placeholder="รหัสหน่วยงานต้นสังกัด">
                            </div>
                            <div class="col-lg-3">
                                <label>
                                    <input type="checkbox">
                                    ไม่ได้ใช้ส่วนนี้แล้ว
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">หน่วยงานต้นสังกัด *</label>
                            <div class="col-lg-5">
                                <input type="text" class="form-control" id="inputEmail" placeholder="หน่วยงานต้นสังกัด">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ชื่อเต็มหน้วยต้นสังกัด</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" id="inputEmail" placeholder="ชื่อเต็มหน้วยต้นสังกัด">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ขึ้นกับหน่วยส่งเงิน</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="select">
                                    <option>xxxx1</option>
                                    <option>xxxx2</option>
                                    <option>xxxx3</option>
                                </select>
                            </div>
                        </div>
                        <hr style="border-color:#666">
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">สายควบคุมที่ *</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="select">
                                    <option>xxxx1</option>
                                    <option>xxxx2</option>
                                    <option>xxxx3</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ที่อยู่</label>
                            <div class="col-lg-8">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">จังหวัด</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="จังหวัด">
                            </div>
                            <label for="inputEmail" class="col-lg-2 control-label">อำเภอ</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="อำเภอ">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ตำบล</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="ตำบล">
                            </div>
                            <label for="inputEmail" class="col-lg-2 control-label">รหัสไปรษณีย์</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="รหัสไปรษณีย์">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">โทรศัพท์</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="โทรศัพท์">
                            </div>
                            <label for="inputEmail" class="col-lg-2 control-label">โทรสาร</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="โทรสาร">
                            </div>
                        </div>
                        <hr style="border-color:#666">
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">บัญชีเงินฝากธนาคาร</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="inputEmail" placeholder="บัญชีเงินฝากธนาคาร">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ชื่อบัญชี</label>
                            <div class="col-lg-6">
                                <input type="text" class="form-control" id="inputEmail" placeholder="ชื่อบัญชี">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">เลขที่บัญชี</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="inputEmail" placeholder="เลขที่บัญชี">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">สาขาธนาคาร</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="select">
                                    <option>xxxx1</option>
                                    <option>xxxx2</option>
                                    <option>xxxx3</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ประเถทบัญชี</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="select">
                                    <option>xxxx1</option>
                                    <option>xxxx2</option>
                                    <option>xxxx3</option>
                                </select>
                            </div>
                        </div>                                                                 
                    </fieldset>
                </form>
            </div>
        </div>
        <div id="dialogFormEdit" class="hide">
            <div class="well bs-component">
                <form class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">รหัสหน่วยงานต้นสังกัด*</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="inputEmail" placeholder="รหัสหน่วยงานต้นสังกัด">
                            </div>
                            <div class="col-lg-3">
                                <label>
                                    <input type="checkbox">
                                    ไม่ได้ใช้ส่วนนี้แล้ว
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">หน่วยงานต้นสังกัด*</label>
                            <div class="col-lg-5">
                                <input type="text" class="form-control" id="inputEmail" placeholder="หน่วยงานต้นสังกัด">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ชื่อเต็มหน้วยต้นสังกัด</label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" id="inputEmail" placeholder="ชื่อเต็มหน้วยต้นสังกัด">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ขึ้นกับหน่วยส่งเงิน</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="select">
                                    <option>xxxx1</option>
                                    <option>xxxx2</option>
                                    <option>xxxx3</option>
                                </select>
                            </div>
                        </div>
                        <hr style="border-color:#666">
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">สายควบคุมที่*</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="select">
                                    <option>xxxx1</option>
                                    <option>xxxx2</option>
                                    <option>xxxx3</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ที่อยู่</label>
                            <div class="col-lg-8">
                                <textarea class="form-control" rows="3" id="textArea"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">จังหวัด</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="จังหวัด">
                            </div>
                            <label for="inputEmail" class="col-lg-2 control-label">อำเภอ</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="อำเภอ">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ตำบล</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="ตำบล">
                            </div>
                            <label for="inputEmail" class="col-lg-2 control-label">รหัสไปรษณีย์</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="รหัสไปรษณีย์">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">โทรศัพท์</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="โทรศัพท์">
                            </div>
                            <label for="inputEmail" class="col-lg-2 control-label">โทรสาร</label>
                            <div class="col-lg-3">
                                <input type="text" class="form-control" id="inputEmail" placeholder="โทรสาร">
                            </div>
                        </div>
                        <hr style="border-color:#666">
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">บัญชีเงินฝากธนาคาร</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="inputEmail" placeholder="บัญชีเงินฝากธนาคาร">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ชื่อบัญชี</label>
                            <div class="col-lg-6">
                                <input type="text" class="form-control" id="inputEmail" placeholder="ชื่อบัญชี">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">เลขที่บัญชี</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="inputEmail" placeholder="เลขที่บัญชี">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">สาขาธนาคาร</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="select">
                                    <option>xxxx1</option>
                                    <option>xxxx2</option>
                                    <option>xxxx3</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-3 control-label">ประเถทบัญชี</label>
                            <div class="col-lg-4">
                                <select class="form-control" id="select">
                                    <option>xxxx1</option>
                                    <option>xxxx2</option>
                                    <option>xxxx3</option>
                                </select>
                            </div>
                        </div>                                                                 
                    </fieldset>
                </form>
            </div>
        </div>
        <a href="#" id="id-btn-dialog2" class="btn btn-info btn-sm">Confirm Dialog</a>
        <a href="#" id="id-btn-dialog1" class="btn btn-purple btn-sm">Modal Dialog</a>
        <div id="dialog-message" class="hide">
            <p>
                This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.
            </p>

            <div class="hr hr-12 hr-double"></div>

            <p>
                Currently using
                <b>36% of your storage space</b>.
            </p>
        </div><!-- #dialog-message -->

        <div id="dialog-confirm" class="hide">
            <div class="alert alert-info bigger-110">
                These items will be permanently deleted and cannot be recovered.
            </div>

            <div class="space-6"></div>

            <p class="bigger-110 bolder center grey">
                <i class="ace-icon fa fa-hand-o-right blue bigger-120"></i>
                Are you sure?
            </p>
        </div><!-- #dialog-confirm -->

        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->
<script type="text/javascript">
    /*
    $(function($) {
        //override dialog's title function to allow for HTML titles
        $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
            _title: function(title) {
                var $title = this.options.title || '&nbsp;';
                if (("title_html" in this.options) && this.options.title_html === true)
                    title.html($title);
                else
                    title.text($title);
            }
        }));

        $("#id-btn-dialog1").on('click', function(e) {
            e.preventDefault();

            var dialog = $("#dialog-message").removeClass('hide').dialog({
                modal: true,
                title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='ace-icon fa fa-check'></i> jQuery UI Dialog</h4></div>",
                title_html: true,
                buttons: [
                    {
                        text: "Cancel",
                        "class": "btn btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    },
                    {
                        text: "OK",
                        "class": "btn btn-primary btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    }
                ]
            });

            /**
             dialog.data( "uiDialog" )._title = function(title) {
             title.html( this.options.title );
             };
             **/
            /*
        });

        $("#id-btn-dialog2").on('click', function(e) {
            e.preventDefault();

            $("#dialog-confirm").removeClass('hide').dialog({
                resizable: false,
                modal: true,
                title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon fa fa-exclamation-triangle red'></i> Empty the recycle bin?</h4></div>",
                title_html: true,
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>&nbsp; Delete all items",
                        "class": "btn btn-danger btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    }
                    ,
                    {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; Cancel",
                        "class": "btn btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    }
                ]
            });
        });

    });*/
</script>