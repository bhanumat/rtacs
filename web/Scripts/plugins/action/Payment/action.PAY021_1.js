$(function() {
    onActionSaveNew = function(thisDialog) {
        //alert("memberIdList : >>"+$("#memberIdList").val() + "<<");
        var formId = '#formPAY021_1_Detail';
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
            req.paymentMilitary = jQuery.toJSON(objData);
            $.ajax({
                type: 'POST',
                url: urlSubmitPAY021_1,
                data: req,
                dataType: 'json',
                async: true,
                success: function(msg) {
                    $.fn.DialogMessage(msg);
                    if (msg.checkSuccess === true) {
                       $("#btnSubmit").addClass('hide');
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
        }
        $(thisDialog).dialog("close");
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
    
    $("#btnSubmit").click(function(event) {
        event.preventDefault();
        onDialogSave();
    });

    $("#btnReset").click(function(e) {
        //window.location.reload();
    });
    
    onInit = function() {
        
    };

    onInit();
});