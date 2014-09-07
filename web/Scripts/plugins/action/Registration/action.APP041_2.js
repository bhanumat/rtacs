/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
    $('#txtDocDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});

    $("#dialogFormAdd").removeClass('hide').dialog({
        width: '800px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> เรียกค้นข้อมูลสมาชิก </h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-check'></i>&nbsp; เลือก",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    onSelectData();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ไม่เลือก",
                "class": "btn btn-xs",
                click: function() {
                    $(this).dialog("close");
                }
            }
        ]
    });

    $("#btnAdd").click(function(e) {
        $("#dialogFormAdd").dialog("open");
    });

    $("#btnCancel").click(function(e) {
        $("#Dialog-Confirm").html("คุณต้องการยกเลิกข้อมูลนี้ใช่หรือไม่?");
        $("#Dialog-Confirm").dialog({
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>&nbsp; ทำการยกเลิก",
                    "class": "btn btn-danger btn-xs",
                    click: function() {
                        onClearGrid();
                        onRefreshGrid();
                        $(this).dialog("close");
                    }
                },
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; หยุดการยกเลิก",
                    "class": "btn btn-xs",
                    click: function() {
                        $(this).dialog("close");
                    }
                }
            ]
        });
        $("#Dialog-Confirm").dialog("open");
    });

    $("#btnBack").click(function(e) {
        onClearGrid();
        //onDialogNew(event);
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP041.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    onRefreshGrid = function() {
        $('#gridData_APP041_2jqGrid_List').setGridParam({
            datatype: 'jsonstring',
            datastr: myStringList
        }).trigger("reloadGrid");
    };

    onClearGrid = function() {
        listAPP041 = [];
        myStringList = {};
    };

    onSelectData = function() {
        var dialogForm = '#dialogFormAdd';
        var myGrid = $('#gridData_APP041_2_Add_jqGrid_List');
        var ids = myGrid.jqGrid('getGridParam', 'selarrrow');
        if (ids.length > 0) {
            for (var i = 0, il = ids.length; i < il; i++) {
                var rowObject = myGrid.getRowData(ids[i]);
                // let's use the prototype for now
                var i = listAPP041.inArray(rowObject.memberId, "memberId");
                if (i === -1) {
                    listAPP041.push(rowObject);
                }
            }
            var jqGridData = {};
            jqGridData.total = 1;
            jqGridData.page = 1;
            jqGridData.records = listAPP041.length;
            jqGridData.rows = listAPP041;
            myStringList = $.toJSON(jqGridData);
            onRefreshGrid();
            $(dialogForm).dialog("close");
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    };

    onActionSaveNew = function(thisDialog, objData) {
        var data = {};
        data.DataSource = $.toJSON(objData);
        console.info(data);
        $.ajax({
            type: 'POST',
            url: urlSaveNew,
            data: data,
            dataType: 'json',
            async: true,
            success: function(msg) {
                $.fn.DialogMessage(msg);
                if (msg.checkSuccess === true) {
                    onActionSearch();
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

        $(thisDialog).dialog("close");
    };

    $("#btnSave").click(function(event) {
        event.preventDefault();
        var ids = [];
        if (listAPP041.length > 0) {
            $("#Dialog-Confirm").html("คุณต้องการบันทึกข้อมูลนี้ใช่หรือไม่?");
            $("#Dialog-Confirm").dialog({
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-floppy-o bigger-110'></i>&nbsp; บันทึก",
                        "class": "btn btn-danger btn-xs",
                        click: function() {
                            for (var item in listAPP041) {
                                var itemData = listAPP041[item];
                                ids.push(itemData.memberId);
                            }

                            var objData = {};
                            objData.ItemSelect = ids.toString();
                            objData.DocDate = $('#txtDocDate').val();
                            objData.DocCode = $('#txtDocCode').val();
                            onActionSaveNew(this, objData);
                        }
                    },
                    {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                        "class": "btn btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    }
                ]
            });
            $("#Dialog-Confirm").dialog("open");
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกสมาชิกใหม่");
            $("#Dialog-Warning").dialog("open");
        }
    });
});
