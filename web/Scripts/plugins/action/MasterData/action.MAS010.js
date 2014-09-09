$(function() {

    $('#frmNew').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            txtMildeptIdNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 1,
                        max: 5,
                        message: 'The title must be less than 5 characters long'
                    }
                }
            },
            txtNameNew: {
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
            txtFullnameNew: {
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
            txtAddress1New: {
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
            txtAddress2New: {
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
            txtZipCodeNew: {
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
            txtTelephoneNew: {
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
            },
            slBankCodeNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    }
                }
            },
            txtBankAccountNameNew: {
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
            txtBankAccountNoNew: {
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
            slBankBranchNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    }
                }
            }, slBankAccountTypeNew: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
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
            txtMildeptIdEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    },
                    stringLength: {
                        min: 1,
                        max: 5,
                        message: 'The title must be less than 5 characters long'
                    }
                }
            },
            txtNameEdit: {
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
            txtFullnameEdit: {
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
            txtAddress1Edit: {
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
            txtAddress2Edit: {
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
                    }
                }
            },
            txtZipCodeEdit: {
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
            txtTelephoneEdit: {
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
            },
            slBankCodeEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    }
                }
            },
            txtBankAccountNameEdit: {
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
            txtBankAccountNoEdit: {
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
            slBankBranchEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
                    }
                }
            },
            slBankAccountTypeEdit: {
                validators: {
                    notEmpty: {
                        message: 'The title is required'
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
        width: '600px',
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
        if ($(formId).validationEngine('validate'))
        {
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
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeEdit, function(inputData) {
                var valueData = $(inputData).val();
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
        if ($('#txtMildeptId').val().length != 0) {
            var search1 = {'groupOp': '', 'field': 'mildeptId', 'op': 'cn', 'data': $('#txtMildeptId').val(), 'dataType': 'integer'};
            requestSearch.push(search1);
            var search2 = {'groupOp': 'and', 'field': 'name', 'op': 'cn', 'data': $('#txtName').val(), 'dataType': 'varchar'};
            requestSearch.push(search2);
        } else {
            var search1 = {'groupOp': '', 'field': 'name', 'op': 'cn', 'data': $('#txtName').val(), 'dataType': 'varchar'};
            requestSearch.push(search1);
        }
        var search3 = {'groupOp': 'and', 'field': 'status', 'op': 'cn', 'data': $('#slStatus').val(), 'dataType': 'char'};
        requestSearch.push(search3);
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

    ////////////////////////////////////////////////////////////////////

    onActionClearNewBankBranch = function() {
        $('#slBankBranchNew').empty();
        $('#slBankBranchNew').append('<option value="">เลือก</option>');
    };

    onActionClearEditBankBranch = function() {
        $('#slBankBranchEdit').empty();
        $('#slBankBranchEdit').append('<option value="">เลือก</option>');
    };

    onActionClearNewBankAccountType = function() {
        $('#slBankAccountTypeNew').empty();
        $('#slBankAccountTypeNew').append('<option value="">เลือก</option>');
    };

    onActionClearEditBankAccountType = function() {
        $('#slBankAccountTypeEdit').empty();
        $('#slBankAccountTypeEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadBankBranch = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonBankBranch,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listBankBranch = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };

    onActionLoadNewBankBranch = function(value) {
        onActionClearNewBankBranch();
        if ('' != value) {
            for (var item in listBankBranch) {
                var itemData = listBankBranch[item];
                if (itemData.bankCode === value) {
                    $('#slBankBranchNew').append('<option value="' + itemData.branchId + '">(' + itemData.branchCode + ') ' + itemData.branchName + '</option>');
                }
            }
        }
    };

    onActionLoadEditBankBranch = function(value) {
        onActionClearEditBankBranch();
        if ('' != value) {
            for (var item in listBankBranch) {
                var itemData = listBankBranch[item];
                if (itemData.bankCode === value) {
                    $('#slBankBranchEdit').append('<option value="' + itemData.branchId + '">(' + itemData.branchCode + ') ' + itemData.branchName + '</option>');
                }
            }
        }

    };

    onActionLoadBankAccountType = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonBankAccountType,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listBankAccountType = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };

    onActionLoadNewBankAccountType = function(value) {
        onActionClearNewBankAccountType();
        if ('' != value) {
            for (var item in listBankAccountType) {
                var itemData = listBankAccountType[item];
                if (itemData.bankCode === value) {
                    $('#slBankAccountTypeNew').append('<option value="' + itemData.accTypeId + '">' + itemData.accTypeName + '</option>');
                }
            }
        }
    };

    onActionLoadEditBankAccountType = function(value) {
        onActionClearEditBankAccountType();
        if ('' != value) {
            for (var item in listBankAccountType) {
                var itemData = listBankAccountType[item];
                if (itemData.bankCode === value) {
                    $('#slBankAccountTypeEdit').append('<option value="' + itemData.accTypeId + '">' + itemData.accTypeName + '</option>');
                }
            }
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

    onInit = function() {
        onActionLoadBank();
        onActionLoadBankBranch();
        onActionLoadBankAccountType();
        onActionLoadProvince();

        onActionLoadNewBank();
        onActionLoadEditBank();

        onActionLoadNewProvince();
        onActionLoadEditProvince();

    };

    $("#slBankCodeNew").change(function() {
        onActionLoadNewBankBranch($(this).val());
        onActionLoadNewBankAccountType($(this).val());
    });

    $("#slBankCodeEdit").change(function() {
        onActionLoadEditBankBranch($(this).val());
        onActionLoadEditBankAccountType($(this).val());
    });

    onInit();
});