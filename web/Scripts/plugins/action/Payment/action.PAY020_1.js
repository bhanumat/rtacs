$(function() {
    $('#docDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#docDate").datepicker("setDate", new Date());
    onActionSearch = function(objData) {
        $.ajax({
            type: 'POST',
            url: urlSearch,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                if (msg.checkSuccess === true && msg.obj != null) {
                    var object = msg.obj;
                    //alert("status : >>" + object.status + "<<");
                    if (object.status === 10 || object.status === 11) {
                        $("#citizenID").text(object.citizenID);
                        $("#username").text(object.name);
                        $("#militaryName").text(object.militaryName);
                        $("#hiddenStatus").text(object.status);
                        $("#memberId").val(object.memberId);
                        $("#amount").val(object.billAmount);
                        $("#docCode").val(object.docCode);
                    } else {
                        $("#citizenFindId").val('');
                        $("#Dialog-Confirm").html("ชำระเบี้ยแล้ว");
                        $("#Dialog-Confirm").removeClass('hide').dialog({
                            width: '300px',
                            resizable: false,
                            modal: true,
                            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-trash'></i> สถานะ</h4></div>",
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
                    listStatus();
                    checkStatus();
                } else {
                    $.fn.DialogMessage(msg);
                }

            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

    };

    onActionSearchAfterSave = function(objData) {
        $.ajax({
            type: 'POST',
            url: urlSearch,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                if (msg.checkSuccess === true && msg.obj != null) {
                    var object = msg.obj;
                    $("#citizenID").text(object.citizenID);
                    $("#username").text(object.name);
                    $("#militaryName").text(object.militaryName);
                    $("#hiddenStatus").text(object.status);
                    $("#memberId").val(object.memberId);
                    $("#amount").val(object.billAmount);
                    $("#docCode").val(object.docCode);
                }
                listStatus();
                checkStatus();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

    };

    onActionSearchOperationMemberId = function(objData) {
        $.ajax({
            type: 'POST',
            url: urlSearchOperationMemberId,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                if (msg.checkSuccess === true && msg.obj != null) {
                    var object = msg.obj;
                    $("#citizenFindId").val(object.citizenID);
                    $("#citizenID").text(object.citizenID);
                    $("#username").text(object.name);
                    $("#militaryName").text(object.militaryName);
                    $("#hiddenStatus").text(object.status);
                    $("#memberId").val(object.memberId);
                    $("#amount").val(object.billAmount);
                    $("#docCode").val(object.docCode);
                    $("#docDate").val(object.dateString);

                    $("#btnSearch").addClass('hide');
                    $("#btnSubmit").addClass('hide');
                    $("#btnCancel").addClass('hide');
                    $("#btnPrint").addClass('hide');
                    $("#btnBillCancel").addClass('hide');

                    document.getElementById("citizenFindId").disabled = true;
                    document.getElementById("docDate").disabled = true;

                    listStatus();
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

    };

    onDialogSave = function() {
        $("#Dialog-Confirm").html("คุณต้องการยืนยันการรับชำระใช่หรือไม่?");
        $("#Dialog-Confirm").removeClass('hide').dialog({
            width: '300px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-save'></i> ยืนยัน</h4></div>",
            title_html: true,
            autoOpen: true,
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; ยืนยัน",
                    "class": "btn btn-primary btn-xs",
                    click: function() {
                        onActionSaveNew(this);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                    "class": "btn btn-xs",
                    click: function() {
                        $(this).dialog("close");
                    }
                }
            ]
        });

    };

    onDialogCancel = function(id) {
        $("#Dialog-Confirm").html("คุณต้องการยกเลิกใบเสร็จนี้ใช่หรือไม่?");
        $("#Dialog-Confirm").removeClass('hide').dialog({
            width: '300px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-trash'></i> ยกเลิกใบเสร็จ</h4></div>",
            title_html: true,
            autoOpen: true,
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; ยกเลิกใบเสร็จ",
                    "class": "btn btn-primary btn-xs",
                    click: function() {
                        var objData = {};
                        objData.ItemSelect = id;//JSON.stringify(ids);
                        onActionCancel(this, objData);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ไม่ยกเลิกใบเสร็จ",
                    "class": "btn btn-xs",
                    click: function() {
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };

    onActionCancel = function(thisDialog, objData) {
        $.ajax({
            type: 'POST',
            url: urlCancel,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                $.fn.DialogMessage(msg);
                if (msg.checkSuccess === true) {
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

        $(thisDialog).dialog("close");
    };

    onActionSaveNew = function(thisDialog) {
        var formId = '#formDetail';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeNew, function(inputData) {
                var valueData = $(inputData).val();
                objData[inputToChangeNew[iArray]] = valueData;
                iArray++;
            });
            var req = {};
            req.operation = jQuery.toJSON(objData);

            $.ajax({
                type: 'POST',
                url: urlNew,
                data: req,
                dataType: 'json',
                async: false,
                success: function(msg) {
                    $.fn.DialogMessage(msg);
                    if (msg.checkSuccess === true) {
                        //$(formName)[0].reset();
                        var objData = {};
                        objData.ItemSelect = $('#citizenFindId').val();
                        onActionSearch(objData);
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
        }
        $(thisDialog).dialog("close");
    };

    onLoad = function(objData) {
        $.ajax({
            type: 'POST',
            url: urlLoad,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                if (msg.checkSuccess === true) {
                    $("#amount").val(msg.message);
                    //$("#docCode").val(msg.id);
                }
                checkStatus();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

    };

    checkStatus = function() {
        if ($("#hiddenStatus").text() === '') {
            $("#btnSubmit").addClass('hide');
            $("#btnCancel").addClass('hide');
            $("#btnPrint").addClass('hide');
            $("#btnBillCancel").addClass('hide');
        } else if ($("#hiddenStatus").text() === '11') {
            $("#btnSubmit").addClass('hide');
            $("#btnCancel").addClass('hide');

//            $("#btnPrint").addClass('hide');
//            $("#btnBillCancel").addClass('hide');

            $("#btnPrint").removeClass('hide');
            $("#btnBillCancel").removeClass('hide');
            $("#btnPrint").addClass('btn btn-success');
            $("#btnBillCancel").addClass('btn btn-danger');
        } else if ($("#hiddenStatus").text() === '10') {
            $("#btnSubmit").removeClass('hide');
            $("#btnCancel").removeClass('hide');
            $("#btnSubmit").addClass('btn btn-info');
            $("#btnCancel").addClass('btn btn-rotate');

            $("#btnPrint").addClass('hide');
            $("#btnBillCancel").addClass('hide');
        } else {
            $("#btnSubmit").addClass('hide');
            $("#btnCancel").addClass('hide');

            $("#btnPrint").addClass('hide');
            $("#btnBillCancel").addClass('hide');
        }
    };

    listStatus = function() {
        if ($("#hiddenStatus").text() === '10') {
            $("#status").text("ยื่นใบสมัคร");
        } else if ($("#hiddenStatus").text() === '11') {
            $("#status").text("ชำระเงินสมัคร");
        } else if ($("#hiddenStatus").text() === '12') {
            $("#status").text("บันทึกข้อมูลเพิ่มเติ่ม");
        } else if ($("#hiddenStatus").text() === '13') {
            $("#status").text("อนุมัติเห็นชอบ");
        } else if ($("#hiddenStatus").text() === '20') {
            $("#status").text("กำหนดเลขทะเบียนสมาชิก");
        } else if ($("#hiddenStatus").text() === '25') {
            $("#status").text("ดำเนินการขออนุมัติขึ้นทะเบียน");
        } else if ($("#hiddenStatus").text() === '105') {
            $("#status").text("อนุมัติขึ้นทะเบียนสมาชิก");
        } else {
            $("#status").text("");
        }
    };

    $("#btnReload").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });

    $("#btnSearch").click(function(event) {
        event.preventDefault();
        $("#citizenID").text('');
        $("#username").text('');
        $("#militaryName").text('');
        $("#hiddenStatus").text('');
        $("#status").text('');
        $("#docCode").val('');
        checkStatus();
        if ($('#citizenFindId').val().length != 0) {
            var objData = {};
            objData.ItemSelect = $('#citizenFindId').val();
            onActionSearch(objData);
        }
    });

    $("#btnSaveNew").click(function(event) {
        onActionSaveNew();
    });

    $("#btnSubmit").click(function(event) {
        event.preventDefault();
        if ($('#citizenFindId').val().length != 0) {
            onDialogSave();
        }
    });

    $("#btnBillCancel").click(function(event) {
        event.preventDefault();
        if ($('#memberId').val().length != 0) {
            var memberId = {};
            memberId = $('#memberId').val();
            //alert(memberId);
            //onDialogCancel(memberId);
        }
    });

    $("#btnCancel").click(function(event) {
        event.preventDefault();
        $("#citizenFindId").val('');
        //$("#docDate").val('');
        $("#docCode").val('');
        $("#citizenID").text('');
        $("#username").text('');
        $("#militaryName").text('');
        $("#hiddenStatus").text('');
        $("#status").text('');
    });

    onInit = function() {
        //alert("first : >>" + $('#operationMemberId').val() + "<<");
        if ($('#operationMemberId').val() === "" || $('#operationMemberId').val() === null) {
            onLoad(1);
        } else {
            var objData = {};
            objData.ItemSelect = $('#operationMemberId').val();
            onActionSearchOperationMemberId(objData);
            //alert("operationMemberId : >>" + $('#operationMemberId').val() + "<<");
        }
    };

    onInit();
});