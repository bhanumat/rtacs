$(function() {

    $("#btnAdd").click(function(event) {
        onDialogNew(event);
    });

    $("#dialogFormNew").removeClass('hide').dialog({
        width: '500px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i>สร้างกลุ่มผู้ใช้งาน</h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; Save",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    onActionSaveNew();
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

    $("#dialogFormEdit").removeClass('hide').dialog({
        width: '500px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i>แก้ไขกลุ่มผู้ใช้งาน</h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; Save",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    onActionSaveEdit();
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

    $('#btnDelete').click(function(event) {
        event.preventDefault();
        var ids = $(gridName).jqGrid('getGridParam', 'selarrrow');
        if (ids.length > 0) {
            $("#Dialog-Confirm").html("คุณต้องการลบข้อมูลนี้ใช่หรือไม่?");
            $("#Dialog-Confirm").dialog({
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>&nbsp; Delete all items",
                        "class": "btn btn-danger btn-xs",
                        click: function() {
                            var objData = {};
                            objData.ItemSelect = ids.toString();//JSON.stringify(ids);
                            onActionDelete(this, objData);
                        }
                    },
                    {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; Cancel",
                        "class": "btn btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    }
                ]
            });
            $("#Dialog-Confirm").dialog("open");
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกเพื่อทำการลบข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    });

    onDialogNew = function(e) {
        e.preventDefault();
        $("#dialogFormNew").dialog("open");
    };

    onDialogEdit = function(id) {
        onActionLoad(id);
        $("#dialogFormEdit").dialog("open");
    };

    onActionDelete = function(thisDialog, objData) {
        $.ajax({
            type: 'POST',
            url: urlDelete,
            data: objData,
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

    onActionSaveNew = function() {
        var formId = '#frmNew';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        $.map(inputToMergeNew, function(inputData) {
            var valueData = $(inputData).val();
            //console.info("selector:" + selector);
            if (inputData.toLowerCase().indexOf(":checked") >= 0) {
                if (inputData.toLowerCase().indexOf("chkFlagNew") >= 0) {
                    if ($('#chkFlagNew').is(':checked')) {
                        valueData = 'Y';
                    } else {
                        valueData = 'N';
                    }
                }
                if (typeof valueData === 'undefined') {
                    // your code here.
                    valueData = 'N';
                } else {
                    valueData = 'Y';
                }
            }
            //console.info("value:" + valueData);
            objData[inputToChangeNew[iArray]] = valueData;
            iArray++;
        });
        $.ajax({
            type: 'POST',
            url: urlNew,
            data: objData,
            dataType: 'json',
            async: false,
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
    };

    onActionSaveEdit = function() {
        var formId = '#frmEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        $.map(inputToMergeEdit, function(inputData) {
            var valueData = $(inputData).val();
            //console.info("selector:" + selector);
            if (inputData.toLowerCase().indexOf(":checked") >= 0) {
                if (inputData.toLowerCase().indexOf("chkFlagEdit") >= 0) {
                    if ($('#chkFlagEdit').is(':checked')) {
                        valueData = 'Y';
                    } else {
                        valueData = 'N';
                    }
                }
                if (typeof valueData === 'undefined') {
                    // your code here.
                    valueData = 'N';
                } else {
                    valueData = 'Y';
                }
            }

            objData[inputToChangeEdit[iArray]] = valueData;
            iArray++;
        });
        $.ajax({
            type: 'POST',
            url: urlEdit,
            data: objData,
            dataType: 'json',
            async: false,
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
    };

    onActionLoad = function(id) {
        var iArray = 0;
        var objData = {};
        objData[objIdKeyEdit] = id;
        $.ajax({
            type: 'POST',
            url: urlLoad,
            data: objData,
            dataType: 'json',
            async: false,
            success: function(objectResponse) {
                objectDefault = objectResponse;
                $.map(inputToChangeEdit, function(getData) {
                    //console.info("" + getData + ":" + objectResponse[getData]);
                    if (inputToMergeEdit[iArray].toLowerCase().indexOf(':checked') >= 0) {
                        if (objectResponse[getData] === 'Y') {
                            $(inputToMergeEdit[iArray].replace(/:checked/g, '')).prop('checked', true);
                        } else {
                            $(inputToMergeEdit[iArray].replace(/:checked/g, '')).prop('checked', false);
                        }
                    } else {
                        $(inputToMergeEdit[iArray]).val(objectResponse[getData]);
                    }
                    iArray++;
                });
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                console.info("XMLHttpRequest");
                console.info(XMLHttpRequest);
                console.info("textStatus");
                console.info(textStatus);
                console.info("errorThrown");
                console.info(errorThrown);
                var msg = JSON.parse(errorThrown);
                //jAlert('error', msg.Message, 'ข้อผิดพลาด');
            }
        });

    };

    onActionSearch = function() {
        $(gridName).jqGrid('setGridParam', {
            search: true,
            postData: {
                searchField: "groupsName",
                searchOper: "cn",
                searchString: $('#txtGroupsName').val()
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);
    };
});