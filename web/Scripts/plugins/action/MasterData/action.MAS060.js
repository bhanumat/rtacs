$(function() {

    $('#frmNew').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            slBankCodeNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    }
                }
            },
            txtBranchCodeNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtBranchNameNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtBranchShortNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtAddressNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtSubdistrictNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtDistrictNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            slProvinceCodeNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    }
                }
            },
            txtZipcodeNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtTelNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtFaxNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            }
        }
    }).on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data
        onActionSaveNew();
    });

    $('#frmEdit').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            slBankCodeEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 99,
                        max: 99,
                        message: 'The title must be less than 5 characters long'
                    }
                }
            },
            txtBranchCodeEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtBranchNameEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtBranchShortEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtAddressEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtSubdistrictEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtDistrictEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            slProvinceCodeEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtZipcodeEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtTelEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            },
            txtFaxEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 3,
                        max: 256,
                        message: 'The title must be less than 256 characters long'
                    }
                }
            }
        }
    }).on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data
        onActionSaveEdit();
    });

    $("#btnAdd").click(function(event) {
        onDialogNew(event);
    });

    $("#dialogFormNew").removeClass('hide').dialog({
        width: '550px',
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
                    $('#frmNew').submit();
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

    $("#dialogFormEdit").removeClass('hide').dialog({
        width: '550px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> แก้ไข</h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; บันทึก",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    $('#frmEdit').submit();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                "class": "btn btn-xs",
                click: function() {
                    var formId = '#frmEdit';
                    var formName = $(formId);
                    $(formName)[0].reset();
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
        onActionLoadEditBank();
        onActionLoad(id);
        $("#dialogFormEdit").dialog("open");
    };

    onDialogDelete = function(id) {
        $("#Dialog-Confirm").html("คุณต้องการลบข้อมูลนี้ใช่หรือไม่?");
        $("#Dialog-Confirm").removeClass('hide').dialog({
            width: '300px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-trash'></i> ลบข้อมูล</h4></div>",
            title_html: true,
            autoOpen: true,
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; ลบข้อมูล",
                    "class": "btn btn-primary btn-xs",
                    click: function() {
                        var objData = {};
                        objData.ItemSelect = id;//JSON.stringify(ids);
                        onActionDelete(this, objData);
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
        var dialogForm = '#dialogFormNew';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate')) {
            $.map(inputToMergeNew, function(inputData) {
                var valueData = $(inputData).val();
                //console.info("selector:" + selector);
                if (inputData.toLowerCase().indexOf(":checked") >= 0) {
                    if (inputData.indexOf("chkStatusNew") >= 0) {
                        if ($('#chkStatusNew').is(':checked')) {
                            valueData = 'E';
                        } else {
                            valueData = 'D';
                        }
                    } else {
                        valueData = 'D';
                    }
                }
                //console.info("value:" + valueData);
                objData[inputToChangeNew[iArray]] = valueData;
                iArray++;
            });

            var req = {};
            req.data2Json = $.toJSON(objData);

            $.ajax({
                type: 'POST',
                url: urlNew,
                data: req,
                dataType: 'json',
                async: false,
                success: function(msg) {
                    $.fn.DialogMessage(msg);
                    if (msg.checkSuccess === true) {
                        $(formName)[0].reset();
                        $(dialogForm).dialog("close");
                        onActionSearch();
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
        }
    };

    onActionSaveEdit = function() {
        var formId = '#frmEdit';
        var dialogForm = '#dialogFormEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate')) {
            $.map(inputToMergeEdit, function(inputData) {
                var valueData = $(inputData).val();
                //console.info("selector:" + selector);
                if (inputData.toLowerCase().indexOf(":checked") >= 0) {
                    if (inputData.indexOf("chkStatusEdit") >= 0) {
                        if ($('#chkStatusEdit').is(':checked')) {
                            valueData = 'E';
                        } else {
                            valueData = 'D';
                        }
                    } else {
                        valueData = 'D';
                    }
                }

                objData[inputToChangeEdit[iArray]] = valueData;
                iArray++;
            });

            var req = {};
            req.data2Json = $.toJSON(objData);

            $.ajax({
                type: 'POST',
                url: urlEdit,
                data: req,
                dataType: 'json',
                async: false,
                success: function(msg) {
                    $.fn.DialogMessage(msg);
                    if (msg.checkSuccess === true) {
                        $(formName)[0].reset();
                        $(dialogForm).dialog("close");
                        onActionSearch();
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
        }
    };

    onActionLoad = function(id) {
        var iArray = 0;
        var objData = {};
        objData[objIdKeyEdit] = id;
        var req = {};
        req.data2Json = $.toJSON(objData);
        $.ajax({
            type: 'POST',
            url: urlLoad,
            data: req,
            dataType: 'json',
            async: false,
            success: function(objectResponse) {
                objectDefault = objectResponse;
                $.map(inputToChangeEdit, function(getData) {
                    //console.info("" + getData + ":" + objectResponse[getData]);
                    if (inputToMergeEdit[iArray].toLowerCase().indexOf(':checked') >= 0) {
                        if (objectResponse[getData] === 'E') {
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
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

    };

    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        var search1 = {'groupOp': '', 'field': 'bankCode', 'op': 'cn', 'data': $('#slBankCodeSearch').val(), 'dataType': 'varchar'};
        requestSearch.push(search1);
        var search2 = {'groupOp': 'and', 'field': 'branchCode', 'op': 'cn', 'data': $('#txtBranchCodeSearch').val(), 'dataType': 'varchar'};
        requestSearch.push(search2);
        var search3 = {'groupOp': 'and', 'field': 'branchName', 'op': 'cn', 'data': $('#txtBranchNameSearch').val(), 'dataType': 'varchar'};
        requestSearch.push(search3);
        var search4 = {'groupOp': 'and', 'field': 'status', 'op': 'cn', 'data': $('#slStatusSearch').val(), 'dataType': 'char'};
        requestSearch.push(search4);
        search.conditions = requestSearch;
        $(gridName).jqGrid('setGridParam', {
            search: true,
            postData: {
                /*searchField: "bankName",
                 searchOper: "cn",
                 searchString: $('#txtBankName').val(),*/

                searchCommand: $.toJSON(search)
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);
    };

    onActionClearNewBank = function() {
        $('#slBankCodeNew').empty();
        $('#slBankCodeNew').append('<option value="">เลือก</option>');
    };

    onActionClearEditBank = function() {
        $('#slBankCodeEdit').empty();
        $('#slBankCodeEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadBank = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonBank,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listBank = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };

    onActionLoadNewBank = function() {
        onActionClearNewBank();
        for (var item in listBank) {
            var itemData = listBank[item];
            $('#slBankCodeNew').append('<option value="' + itemData.bankCode + '">(' + itemData.bankCode + ') ' + $.trim(itemData.bankName) + '</option>');
        }
    };

    onActionLoadEditBank = function() {
        onActionClearEditBank();
        for (var item in listBank) {
            var itemData = listBank[item];
            $('#slBankCodeEdit').append('<option value="' + itemData.bankCode + '">(' + itemData.bankCode + ') ' + $.trim(itemData.bankName) + '</option>');
        }
    };

//////////////////////////////////////////////////////////////
    onActionClearNewProvince = function() {
        $('#slProvinceCodeNew').empty();
        $('#slProvinceCodeNew').append('<option value="">เลือก</option>');
    };

    onActionClearEditProvince = function() {
        $('#slProvinceCodeEdit').empty();
        $('#slProvinceCodeEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadProvince = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonProvince,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listProvince = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };

    onActionLoadNewProvince = function() {
        onActionClearNewProvince();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeNew').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionLoadEditProvince = function() {
        onActionClearEditProvince();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };


////////////////////////////////////////////////////////////

    onActionClearSearchProvince = function() {
        $('#slProvinceCodeSearch').empty();
        $('#slProvinceCodeSearch').append('<option value="%">ทั้งหมด</option>');
    };

    onActionLoadSearchProvince = function() {
        onActionClearSearchProvince();
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonProvince,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                var list = json;
                for (var item in list) {
                    var itemData = list[item];
                    $('#slProvinceCodeNew').append('<option value="' + itemData.provinceCode + '">(' + itemData.provinceName + ')</option>');
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };

    onActionClearSearchBank = function() {
        $('#slBankCodeSearch').empty();
        $('#slBankCodeSearch').append('<option value="%">ทั้งหมด</option>');
    };

    onActionLoadSearchBank = function() {
        onActionClearSearchBank();
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonBank,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                var list = json;
                for (var item in list) {
                    var itemData = list[item];
                    $('#slBankCodeSearch').append('<option value="' + itemData.bankCode + '">(' + itemData.bankCode + ') ' + $.trim(itemData.bankName) + '</option>');
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };

    onActionClearSearchBank = function() {
        $('#slBankCodeSearch').empty();
        $('#slBankCodeSearch').append('<option value="%">ทั้งหมด</option>');
    };

    onActionLoadSearchBank = function() {
        onActionClearSearchBank();
        for (var item in listBank) {
            var itemData = listBank[item];
            $('#slBankCodeSearch').append('<option value="' + itemData.bankCode + '">(' + itemData.bankCode + ') ' + $.trim(itemData.bankName) + '</option>');
        }
    };

    onInit = function() {
        onActionLoadBank();
        onActionLoadProvince();

        onActionLoadNewBank();
        onActionLoadEditBank();
        onActionLoadSearchBank();
        onActionLoadNewProvince();
        onActionLoadEditProvince();
    };

    onInit();
});