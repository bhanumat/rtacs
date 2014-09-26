$(function() {
    var responseId = '#main-page-content-loading';
    $('#date_begin').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#date_begin").datepicker("setDate", new Date());
    $('#date_end').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#date_end").datepicker("setDate", new Date());

    $("#btnAdd").click(function(event) {
        //onDialogNew(event);
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP031_2.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    });

    $("#dialogFormNew").removeClass('hide').dialog({
        width: '600px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> สร้างใหม่</h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; บันทึก",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    onActionSaveNew();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                "class": "btn btn-xs",
                click: function() {
                    var formId = '#frmNew';
                    var formName = $(formId);
                    $(formName)[0].reset();
                    $(this).dialog("close");
                }
            }
        ]
    });

    onDialogNew = function(e) {
        e.preventDefault();
        $("#dialogFormNew").dialog("open");
    };

    onDialogView = function(id) {
        $('#operationId').val(id);
        var typeAction = 'GET';
        var urlAction = urlActionView;
        var objDataAction = {operationId: $('#operationId').val()};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    };

    onActionSearch = function() {
        //alert("military >>" + $('#military').val() + "<<");
        //alert("memberTypeCode >>" + $('#memberTypeCode').val() + "<<");
        var search = {};
        var requestSearch = new Array();
        if ($('#date_begin').val().length != 0 && $('#date_end').val().length != 0) {
            var search1 = {'groupOp': 'and', 'field': 'doc_date', 'op': 'bw', 'data': $('#date_begin').val() + "," + $('#date_end').val(), 'dataType': 'date'};
            requestSearch.push(search1);
        } else {
            if ($('#date_begin').val().length != 0) {
                var search1 = {'groupOp': 'and', 'field': 'doc_date', 'op': 'bw', 'data': $('#date_begin').val(), 'dataType': 'date'};
                requestSearch.push(search1);
            } else {
                if ($('#date_end').val().length != 0) {
                    $("#Dialog-Confirm").html("กรุณากรอกข้อมูลค้นหาวันที่ขออนุมัติ");
                    $("#Dialog-Confirm").removeClass('hide').dialog({
                        width: '300px',
                        resizable: false,
                        modal: true,
                        title: "<div class='widget-header'><h4 class='smaller'> แจ้งเตือน</h4></div>",
                        title_html: true,
                        autoOpen: true,
                        buttons: [
                            {
                                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ปิด",
                                "class": "btn btn-xs",
                                click: function() {
                                    $(this).dialog("close");
                                }
                            }
                        ]
                    });
                }
            }
        }

        if ($('#docCode').val().length != 0) {
            var search3 = {'groupOp': '', 'field': 'docCode', 'op': 'eq', 'data': $('#docCode').val(), 'dataType': 'varchar'};
            requestSearch.push(search3);
        }

        search.conditions = requestSearch;

        $(gridName).jqGrid('setGridParam', {
            search: true,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);
    };

    $("#btnSearch").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });

});