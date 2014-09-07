$(function() {
    var tabMainName = '#tabMainMember';
    $(tabMainName).tabs();
    $('.ui-tabs-panel').removeClass();
    $(tabMainName).tabs("option", "active", 0);
    //$("#txtApplyDate").datepicker();
    //$("#txtApplyDate").datepicker($.datepicker.regional["is"]); // Set ภาษาที่เรานิยามไว้ด้านบน
    //$("#txtApplyDate").datepicker("setDate", new Date()); //Set ค่าวันปัจจุบัน
    $('#txtApplyDateEdit').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#txtBirthDateEdit').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#slMemberGroupCodeEdit").select2({
        allowClear: true
    });
    $("#slMemberTypeCodeEdit").select2({
        allowClear: true
    });
    $("#slRankIdEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slTitleIdEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slGenderEdit").select2({
        allowClear: true
    });
    $("#slMilitaryIdEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slPaymentTypeEdit").select2({
        allowClear: true
    });
    $("#slReferrerRelationshipCodeEdit").select2({
        allowClear: true
    });
    $("#slMarryStatusCodeEdit").select2({
        allowClear: true
    });
    $("#slPermanentProvinceCodeEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slProvinceCodeEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slRankIdEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slPaymentTypeCodeEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true
    });
    $("#slBankCodeEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true
    });
    $("#slBankBranchIdEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slAccTypeIdEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true
    });
    $("#slRankIdMemberBeneficiaryEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slTitleIdMemberBeneficiaryEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slMemberRelationshipCodeMemberBeneficiaryEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true
    });
    $("#slPermanentProvinceCodeMemberBeneficiaryEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slProvinceCodeMemberBeneficiaryEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slRankIdMemberBeneficiaryEditForEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slTitleIdMemberBeneficiaryEditForEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slMemberRelationshipCodeMemberBeneficiaryEditForEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true
    });
    $("#slPermanentProvinceCodeMemberBeneficiaryEditForEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#slProvinceCodeMemberBeneficiaryEditForEdit").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });
    $("#dialogFormReferrerEdit").removeClass('hide').dialog({
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
                    onActionSelectReferrerEdit();
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
    $("#btnReferrerEdit").click(function(event) {
        $("#dialogFormReferrerEdit").dialog("open");
    });
    $("#dialogFormMemberBeneficiaryEdit").removeClass('hide').dialog({
        width: '800px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> ผู้รับเงินสงเคราห์ </h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; บันทึก",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    onActionSaveMemberBeneficiaryNewForEdit();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                "class": "btn btn-xs",
                click: function() {
                    var formId = '#frmMemberBeneficiaryEdit';
                    var formName = $(formId);
                    $(formName)[0].reset();
                    $(this).dialog("close");
                }
            }
        ]
    });
    $("#btnAddMemberBeneficiaryEdit").click(function(event) {
        $("#dialogFormMemberBeneficiaryEdit").dialog("open");
    });
    onDialogDeleteMemberBeneficiaryEdit = function(id) {
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
                        onActionDeleteMemberBeneficiaryEdit(this, id);
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
    onActionSelectReferrerEdit = function() {
        var dialogForm = '#dialogFormReferrerEdit';
        var myGrid = $('#gridData_MAS010_2_Edit_Select_jqGrid_List');
        var $selRadio = $('input[name=rd_' + myGrid[0].id + ']:radio:checked'), $tr;
        if ($selRadio.length > 0) {
            $tr = $selRadio.closest('tr');
            if ($tr.length > 0) {
                //var selRowId = myGrid.jqGrid('getGridParam', 'selrow');
                var selRowId = $tr.attr('id');
                var memberId = myGrid.jqGrid('getCell', selRowId, 'memberId');
                var name = myGrid.jqGrid('getCell', selRowId, 'name');
                var surname = myGrid.jqGrid('getCell', selRowId, 'surname');
                var memberCode = myGrid.jqGrid('getCell', selRowId, 'memberCode');
                $('#hidReferrerIdEdit').val(memberId);
                $('#txtReferrerFullnameEdit').val(name + ' ' + surname);
                $('#txtReferrerCodeEdit').val(memberCode);
                $(dialogForm).dialog("close");
            }
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    };
    onActionSaveMemberBeneficiaryNewForEdit = function() {
        var formId = '#frmMemberBeneficiaryEdit';
        var dialogForm = '#dialogFormMemberBeneficiaryEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeMemberBeneficiaryEdit, function(inputData) {
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
                //console.info("value:" + valueData);
                objData[inputToChangeMemberBeneficiaryEdit[iArray]] = valueData;
                iArray++;
            });
            for (var item in listTitle) {
                var itemData = listTitle[item];
                if (objData['titleId'] == itemData.titleId) {
                    objData['titleName'] = itemData.title;
                }
            }

            for (var item in listRank) {
                var itemData = listRank[item];
                if (objData['rankId'] == itemData.rankId) {
                    objData['rankName'] = itemData.rankName;
                }
            }
            objData['beneficiaryId'] = 0;
            objData['id'] = 0;
            listAPP010.push(objData);
            onRefreshGridMemberBeneficiaryEdit();
            $(formName)[0].reset();
            $(dialogForm).dialog("close");
        }
    };

    onActionSaveMemberBeneficiaryEditForEdit = function(id) {
        var formId = '#frmMemberBeneficiaryEditForEdit';
        var dialogForm = '#dialogFormMemberBeneficiaryEditForEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeMemberBeneficiaryEditForEdit, function(inputData) {
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
                console.info("value:" + valueData);
                objData[inputToChangeMemberBeneficiaryEditForEdit[iArray]] = valueData;
                iArray++;
            });
            for (var item in listTitle) {
                var itemData = listTitle[item];
                if (objData['titleId'] == itemData.titleId) {
                    objData['titleName'] = itemData.title;
                }
            }

            for (var item in listRank) {
                var itemData = listRank[item];
                if (objData['rankId'] == itemData.rankId) {
                    objData['rankName'] = itemData.rankName;
                }
            }
            objData['memberRelationship'] = onCheckMemberRelationshipCode(objData['memberRelationshipCode']);

            var idCheck = 0;
            var iArray = 0;
            for (var i = 0, item; item = listAPP010[i]; i++) {
                idCheck = i + 1;
                if (idCheck == objData['id']) {
                    listAPP010[i] = objData;
                }
            }

            onRefreshGridMemberBeneficiaryEdit();
            $(formName)[0].reset();
            $(dialogForm).dialog("close");
        }
    };

    onDialogEditMemberBeneficiaryEditForEdit = function(id) {
        onActionLoadMemberBeneficiaryEditForEdit(id);
        $("#dialogFormMemberBeneficiaryEditForEdit").removeClass('hide').dialog({
            width: '800px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> ผู้รับเงินสงเคราห์ </h4></div>",
            title_html: true,
            autoOpen: true,
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; บันทึก",
                    "class": "btn btn-primary btn-xs",
                    click: function() {
                        onActionSaveMemberBeneficiaryEditForEdit(id);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                    "class": "btn btn-xs",
                    click: function() {
                        var formId = '#frmMemberBeneficiaryEditForEdit';
                        var formName = $(formId);
                        $(formName)[0].reset();
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };

    onActionLoadMemberBeneficiaryEditForEdit = function(id) {
        var idCheck = 0;
        var iArray = 0;
        for (var i = 0, item; item = listAPP010[i]; i++) {
            idCheck = i + 1;
            if (idCheck == id) {
                $.map(inputToChangeMemberBeneficiaryEditForEdit, function(getData) {
                    //console.info("" + getData + ":" + objectResponse[getData]);
                    if (inputToMergeMemberBeneficiaryEditForEdit[iArray].toLowerCase().indexOf(':checked') >= 0) {
                        if (item[getData] === 'E') {
                            $(inputToMergeMemberBeneficiaryEditForEdit[iArray].replace(/:checked/g, '')).prop('checked', true);
                        } else {
                            $(inputToMergeMemberBeneficiaryEditForEdit[iArray].replace(/:checked/g, '')).prop('checked', false);
                        }
                    } else {
                        $(inputToMergeMemberBeneficiaryEditForEdit[iArray]).val(item[getData]);
                    }
                    iArray++;
                });
            }
        }
    };

    onActionDeleteMemberBeneficiaryEdit = function(thisDialog, id) {
        var listAPP010EditTempAdd = new Array();
        var idCheck = 0;
        for (var i = 0, item; item = listAPP010[i]; i++) {
            idCheck = i + 1;
            if (idCheck != id) {
                listAPP010EditTempAdd.push(item);
                listAPP010Delete.push(id);
            }
        }
        listAPP010 = listAPP010EditTempAdd;
        listAPP010EditTempAdd = null;
        $(thisDialog).dialog("close");
        onRefreshGridMemberBeneficiaryEdit();
    };

    onRefreshGridMemberBeneficiaryEdit = function() {
        var jqGridData = {};
        var listAPP010EditTempAdd = new Array();
        var icout = 0;
        for (var i = 0, item; item = listAPP010[i]; i++) {
            icout++;
            item['id'] = icout;
            listAPP010EditTempAdd.push(item);
        }
        //console.info(listAPP010EditTempAdd);
        jqGridData.total = 1;
        jqGridData.page = 1;
        jqGridData.records = listAPP010EditTempAdd.length;
        jqGridData.rows = listAPP010EditTempAdd;
        myStringListAPP010 = $.toJSON(jqGridData);
        $('#gridData_APP010_2_Edit_Grid_List').setGridParam({
            datatype: 'jsonstring',
            datastr: myStringListAPP010
        }).trigger("reloadGrid");
    };

    onActionSaveEdit = function() {
        var formId = '#frmEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeEdit, function(inputData) {
                var valueData = $(inputData).val();
                //console.info("inputData:" + inputData);
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
                //console.info("value:" + valueData);
                objData[inputToChangeEdit[iArray]] = valueData;
                iArray++;
            });
            objData['listMemberBeneficiary'] = listAPP010;
            objData['deleteBeneficiaryId'] = listAPP010Delete;
            //console.info(objData);
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
                        //$(formName)[0].reset();
                        onActionLoadMemberBeneficiary($('#hidMemberIdEdit').val());
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
        }
    };
    $("#btnSaveEdit").click(function(event) {
        onActionSaveEdit();
    });
    onActionLoadRank = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonRank,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listRank = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };
    onActionClearEditRank = function() {
        $('#slRankIdEdit').empty();
        //$('#slRankIdEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditRank = function() {
        onActionClearEditRank();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdEdit').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
        }
    };
    onActionLoadTitle = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonTitle,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listTitle = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };
    onActionClearEditTitle = function() {
        $('#slTitleIdEdit').empty();
        //$('#slTitleIdEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditTitle = function() {
        onActionClearEditTitle();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdEdit').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
        }
    };
    onActionLoadMilitaryDepartment = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonMilitaryDepartment,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listMilitaryDepartment = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };
    onActionClearEditMilitaryDepartment = function() {
        $('#slMilitaryIdEdit').empty();
        //$('#slMilitaryIdEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditMilitaryDepartment = function() {
        onActionClearEditMilitaryDepartment();
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#slMilitaryIdEdit').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
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
    onActionClearEditProvince = function() {
        $('#slProvinceCodeEdit').empty();
        //$('#slProvinceCodeEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditProvince = function() {
        onActionClearEditProvince();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };
    onActionClearEditPermanentProvince = function() {
        $('#slPermanentProvinceCodeEdit').empty();
        //$('#slPermanentProvinceCodeEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditPermanentProvince = function() {
        onActionClearEditPermanentProvince();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
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
    onActionLoadEditBank = function() {
        onActionClearEditBank();
        for (var item in listBank) {
            var itemData = listBank[item];
            $('#slBankCodeEdit').append('<option value="' + itemData.bankCode + '">(' + itemData.bankCode + ') ' + $.trim(itemData.bankName) + '</option>');
        }
    };
    ////////////////////////////////////////////////////////////////////

    onActionClearEditBankBranch = function() {
        $('#slBankBranchIdEdit').empty();
        //$('#slBankBranchIdEdit').append('<option value="">เลือก</option>');
    };
    onActionClearEditBankAccountType = function() {
        $('#slAccTypeIdEdit').empty();
        $('#slAccTypeIdEdit').append('<option value="">เลือก</option>');
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
    onActionLoadEditBankBranch = function(value) {
        onActionClearEditBankBranch();
        if ('' !== value) {
            for (var item in listBankBranch) {
                var itemData = listBankBranch[item];
                if (itemData.bankCode === value) {
                    $('#slBankBranchIdEdit').append('<option value="' + itemData.branchId + '">(' + itemData.branchCode + ') ' + itemData.branchName + '</option>');
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
    onActionLoadEditBankAccountType = function(value) {
        onActionClearEditBankAccountType();
        if ('' !== value) {
            for (var item in listBankAccountType) {
                var itemData = listBankAccountType[item];
                if (itemData.bankCode === value) {
                    $('#slAccTypeIdEdit').append('<option value="' + itemData.accTypeId + '">' + itemData.accTypeName + '</option>');
                }
            }
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

    onActionLoadMemberBeneficiary = function(id) {
        var objData = {};
        listAPP010 = [];
        objData[objIdKeyEdit] = id;
        var req = {};
        req.data2Json = $.toJSON(objData);
        $.ajax({
            type: 'POST',
            url: urlLoadMemberBeneficiary,
            data: req,
            dataType: 'json',
            async: false,
            success: function(objectResponse) {

//                listAPP010 = new Array();
//                listAPP010 = objectResponse;
//                //var listAPP010Temp = [];
//                //listAPP010Temp = objectResponse;
//                for (var item in objectResponse) {
//                    var itemData = objectResponse[item];
//                    itemData['memberRelationship'] = onCheckMemberRelationshipCode(itemData['memberRelationshipCode']);
//                    //listAPP010.push(itemData);
//                    console.info(itemData);
//                }

                for (var i = 0, item; item = objectResponse[i]; i++) {
                    item['memberRelationship'] = onCheckMemberRelationshipCode(item['memberRelationshipCode']);
                    listAPP010.push(item);
                }

                onRefreshGridMemberBeneficiaryEdit();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };

    onCheckMemberRelationshipCode = function(keyValue) {
        var stringValue = '';
        switch (keyValue) {
            case 0:
                stringValue = 'คู่สมรส';
                break;
            case 1:
                stringValue = 'บุตร / ธิดา';
                break;
            case 2:
                stringValue = 'บิดา';
                break;
            case 3:
                stringValue = 'มารดา';
                break;
            case 4:
                stringValue = 'มารดาคู่สมรส';
                break;
            default:
                stringValue = '';
                break;
        }
        return stringValue;
    };
//================================== Start MemberBeneficiary===========================================

    onActionClearEditRankMemberBeneficiary = function() {
        $('#slRankIdMemberBeneficiaryEdit').empty();
        //$('#slRankIdMemberBeneficiaryEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditRankMemberBeneficiary = function() {
        onActionClearEditRankMemberBeneficiary();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdMemberBeneficiaryEdit').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
        }
    };
    onActionClearEditTitleMemberBeneficiary = function() {
        $('#slTitleIdMemberBeneficiaryEdit').empty();
        //$('#slTitleIdMemberBeneficiaryEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditTitleMemberBeneficiary = function() {
        onActionClearEditTitleMemberBeneficiary();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdMemberBeneficiaryEdit').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
        }
    };
    onActionClearEditPermanentProvinceMemberBeneficiary = function() {
        $('#slPermanentProvinceCodeMemberBeneficiaryEdit').empty();
        //$('#slPermanentProvinceCodeMemberBeneficiaryEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditPermanentProvinceMemberBeneficiary = function() {
        onActionClearEditPermanentProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeMemberBeneficiaryEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };
    onActionClearEditProvinceMemberBeneficiary = function() {
        $('#slProvinceCodeMemberBeneficiaryEdit').empty();
        //$('#slProvinceCodeMemberBeneficiaryEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditProvinceMemberBeneficiary = function() {
        onActionClearEditProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeMemberBeneficiaryEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };
    onActionClearEditForEditRankMemberBeneficiary = function() {
        $('#slRankIdMemberBeneficiaryEditForEdit').empty();
        //$('#slRankIdMemberBeneficiaryEditForEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditForEditRankMemberBeneficiary = function() {
        onActionClearEditForEditRankMemberBeneficiary();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdMemberBeneficiaryEditForEdit').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
        }
    };
    onActionClearEditForEditTitleMemberBeneficiary = function() {
        $('#slTitleIdMemberBeneficiaryEditForEdit').empty();
        //$('#slTitleIdMemberBeneficiaryEditForEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditForEditTitleMemberBeneficiary = function() {
        onActionClearEditForEditTitleMemberBeneficiary();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdMemberBeneficiaryEditForEdit').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
        }
    };
    onActionClearEditForEditPermanentProvinceMemberBeneficiary = function() {
        $('#slPermanentProvinceCodeMemberBeneficiaryEditForEdit').empty();
        //$('#slPermanentProvinceCodeMemberBeneficiaryEditForEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditForEditPermanentProvinceMemberBeneficiary = function() {
        onActionClearEditForEditPermanentProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeMemberBeneficiaryEditForEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };
    onActionClearEditForEditProvinceMemberBeneficiary = function() {
        $('#slProvinceCodeMemberBeneficiaryEditForEdit').empty();
        //$('#slProvinceCodeMemberBeneficiaryEditForEdit').append('<option value="">เลือก</option>');
    };
    onActionLoadEditForEditProvinceMemberBeneficiary = function() {
        onActionClearEditForEditProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeMemberBeneficiaryEditForEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };
//======================================= End MemberBeneficiary ======================================

    onInit = function() {
        onActionLoadRank();
        onActionLoadTitle();
        onActionLoadMilitaryDepartment();
        onActionLoadProvince();
        onActionLoadBank();
        onActionLoadBankBranch();
        onActionLoadBankAccountType();
        onActionLoadEditRank();
        onActionLoadEditTitle();
        onActionLoadEditMilitaryDepartment();
        onActionLoadEditProvince();
        onActionLoadEditPermanentProvince();
        onActionLoadEditBank();
        onActionLoadEditRankMemberBeneficiary();
        onActionLoadEditTitleMemberBeneficiary();
        onActionLoadEditPermanentProvinceMemberBeneficiary();
        onActionLoadEditProvinceMemberBeneficiary();
        onActionLoadEditForEditRankMemberBeneficiary();
        onActionLoadEditForEditTitleMemberBeneficiary();
        onActionLoadEditForEditPermanentProvinceMemberBeneficiary();
        onActionLoadEditForEditProvinceMemberBeneficiary();
        onActionLoad($('#hidMemberIdEdit').val());
        onActionLoadMemberBeneficiary($('#hidMemberIdEdit').val());
    };
    $("#slBankCodeEdit").change(function() {
//console.info($(this).val());
        onActionLoadEditBankBranch($(this).val());
        onActionLoadEditBankAccountType($(this).val());
    });
    onInit();
});