$(function() {
    var tabMainName = '#tabMainMember';
    $(tabMainName).tabs();
    $('.ui-tabs-panel').removeClass();
    $(tabMainName).tabs("option", "active", 0);
    //$("#txtApplyDate").datepicker();
    //$("#txtApplyDate").datepicker($.datepicker.regional["is"]); // Set ภาษาที่เรานิยามไว้ด้านบน
    //$("#txtApplyDate").datepicker("setDate", new Date()); //Set ค่าวันปัจจุบัน
    $('#txtApplyDateNew').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#txtApplyDateNew").datepicker("setDate", new Date());
    $('#txtBirthDateNew').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#txtBirthDateNew").datepicker("setDate", new Date());

//    $("#slMemberGroupCodeNew").select2({
//        allowClear: true
//    });
//
//    $("#slMemberTypeCodeNew").select2({
//        allowClear: true
//    });
//
//    $("#slRankIdNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slTitleIdNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slGenderNew").select2({
//        allowClear: true
//    });
//
//    $("#slMilitaryIdNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slPaymentTypeNew").select2({
//        allowClear: true
//    });
//
//    $("#slReferrerRelationshipCodeNew").select2({
//        allowClear: true
//    });
//
//    $("#slMarryStatusCodeNew").select2({
//        allowClear: true
//    });
//
//    $("#slPermanentProvinceCodeNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slProvinceCodeNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slRankIdNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slPaymentTypeCodeNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true
//    });
//
//    $("#slBankCodeNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true
//    });
//
//    $("#slBankBranchIdNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slAccTypeIdNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true
//    });
//
//    $("#slRankIdMemberBeneficiaryNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slTitleIdMemberBeneficiaryNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slMemberRelationshipCodeMemberBeneficiaryNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true
//    });
//
//    $("#slPermanentProvinceCodeMemberBeneficiaryNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slProvinceCodeMemberBeneficiaryNew").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slRankIdMemberBeneficiaryNewForEdit").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slTitleIdMemberBeneficiaryNewForEdit").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slMemberRelationshipCodeMemberBeneficiaryNewForEdit").select2({
//        placeholder: '-เลือก-',
//        allowClear: true
//    });
//
//    $("#slPermanentProvinceCodeMemberBeneficiaryNewForEdit").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });
//
//    $("#slProvinceCodeMemberBeneficiaryNewForEdit").select2({
//        placeholder: '-เลือก-',
//        allowClear: true,
//        minimumInputLength: 1
//    });

    $("#dialogFormReferrerNew").removeClass('hide').dialog({
        width: '970px',
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
                    onActionSelectReferrerNew();
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

    $("#btnReferrerNew").click(function(event) {
        $("#dialogFormReferrerNew").dialog("open");
    });

    $("#dialogFormMemberBeneficiaryNew").removeClass('hide').dialog({
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
                    onActionSaveMemberBeneficiaryEditForNew();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                "class": "btn btn-xs",
                click: function() {
                    var formId = '#frmMemberBeneficiaryNew';
                    var formName = $(formId);
                    $(formName)[0].reset();
                    $(this).dialog("close");
                }
            }
        ]
    });

    $("#btnAddMemberBeneficiaryNew").click(function(event) {
        $("#dialogFormMemberBeneficiaryNew").dialog("open");
    });

    onDialogDeleteMemberBeneficiaryNew = function(id) {
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
                        onActionDeleteMemberBeneficiaryNew(this, id);
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

    onActionSelectReferrerNew = function() {
        var dialogForm = '#dialogFormReferrerNew';
        var myGrid = $('#gridData_APP010_2_New_Select_jqGrid_List');
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
                $('#hidReferrerIdNew').val(memberId);
                $('#txtReferrerFullnameNew').val(name + ' ' + surname);
                $('#txtReferrerCodeNew').val(memberCode);
                $(dialogForm).dialog("close");
            }
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    };

    onActionSaveMemberBeneficiaryEditForNew = function() {
        var formId = '#frmMemberBeneficiaryNew';
        var dialogForm = '#dialogFormMemberBeneficiaryNew';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeMemberBeneficiaryNew, function(inputData) {
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
                objData[inputToChangeMemberBeneficiaryNew[iArray]] = valueData;
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
            objData['beneficiaryId'] = listAPP010.length + 1;
            objData['id'] = listAPP010.length + 1;
            listAPP010.push(objData);

            onRefreshGridMemberBeneficiaryNew();
            $(formName)[0].reset();
            $(dialogForm).dialog("close");
        }
    };

    onActionSaveMemberBeneficiaryNewForEdit = function(id) {
        var formId = '#frmMemberBeneficiaryNewForEdit';
        var dialogForm = '#dialogFormMemberBeneficiaryNewForEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeMemberBeneficiaryNewForEdit, function(inputData) {
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
                objData[inputToChangeMemberBeneficiaryNewForEdit[iArray]] = valueData;
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
            objData['id'] = id;
            //listAPP010.push(objData);

            var idCheck = 0;
            var iArray = 0;
            for (var i = 0, item; item = listAPP010[i]; i++) {
                idCheck = i + 1;
                if (idCheck == id) {
                    listAPP010[i] = objData;
                }
            }

            onRefreshGridMemberBeneficiaryNew();
            $(formName)[0].reset();
            $(dialogForm).dialog("close");
        }
    };

    onDialogEditMemberBeneficiaryNewForEdit = function(id) {
        onActionLoadMemberBeneficiaryNewForEdit(id);
        $("#dialogFormMemberBeneficiaryNewForEdit").removeClass('hide').dialog({
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
                        onActionSaveMemberBeneficiaryNewForEdit(id);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                    "class": "btn btn-xs",
                    click: function() {
                        var formId = '#frmMemberBeneficiaryNewForEdit';
                        var formName = $(formId);
                        $(formName)[0].reset();
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };

    onActionLoadMemberBeneficiaryNewForEdit = function(id) {
        var idCheck = 0;
        var iArray = 0;
        for (var i = 0, item; item = listAPP010[i]; i++) {
            idCheck = i + 1;
            if (idCheck == id) {
                $.map(inputToChangeMemberBeneficiaryNewForEdit, function(getData) {
                    //console.info("" + getData + ":" + objectResponse[getData]);
                    if (inputToMergeMemberBeneficiaryNewForEdit[iArray].toLowerCase().indexOf(':checked') >= 0) {
                        if (item[getData] === 'E') {
                            $(inputToMergeMemberBeneficiaryNewForEdit[iArray].replace(/:checked/g, '')).prop('checked', true);
                        } else {
                            $(inputToMergeMemberBeneficiaryNewForEdit[iArray].replace(/:checked/g, '')).prop('checked', false);
                        }
                    } else {
                        $(inputToMergeMemberBeneficiaryNewForEdit[iArray]).val(item[getData]);
                    }
                    iArray++;
                });
            }
        }
    };

    onActionDeleteMemberBeneficiaryNew = function(thisDialog, id) {
        var listAPP010NewTempAdd = new Array();
        var idCheck = 0;
        for (var i = 0, item; item = listAPP010[i]; i++) {
            idCheck = i + 1;
            if (idCheck != id) {
                listAPP010NewTempAdd.push(item);
            }
        }
        listAPP010 = listAPP010NewTempAdd;
        listAPP010NewTempAdd = null;
        $(thisDialog).dialog("close");
        onRefreshGridMemberBeneficiaryNew();
    };

    onRefreshGridMemberBeneficiaryNew = function() {
        var jqGridData = {};
        var listAPP010NewTempAdd = new Array();
        for (var i = 0, item; item = listAPP010[i]; i++) {
            item['id'] = i + 1;
            listAPP010NewTempAdd.push(item);
        }
        jqGridData.total = 1;
        jqGridData.page = 1;
        jqGridData.records = listAPP010NewTempAdd.length;
        jqGridData.rows = listAPP010NewTempAdd;
        myStringListAPP010 = $.toJSON(jqGridData);

        $('#gridData_APP010_2_New_Grid_List').setGridParam({
            datatype: 'jsonstring',
            datastr: myStringListAPP010
        }).trigger("reloadGrid");
    };

    onActionSaveNew = function() {
        var formId = '#frmNew';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeNew, function(inputData) {
                var valueData = $(inputData).val();
                //console.info("inputData:" + inputData);
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

            objData['listMemberBeneficiary'] = listAPP010;

            //console.info(objData);
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
                        listAPP010 = [];
                        onRefreshGridMemberBeneficiaryNew();
                        $(formName)[0].reset();
                        var typeAction = 'GET';
                        var urlAction = urlActionListAPP010;
                        var objDataAction = {};
                        var dataTypeAction = 'html';
                        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
        }
    };

    $("#btnSaveNew").click(function(event) {
        event.preventDefault();
        onActionSaveNew();
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

    onActionClearNewRank = function() {
        $('#slRankIdNew').empty();
        //$('#slRankIdNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewRank = function() {
        onActionClearNewRank();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdNew').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
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

    onActionClearNewTitle = function() {
        $('#slTitleIdNew').empty();
        //$('#slTitleIdNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewTitle = function() {
        onActionClearNewTitle();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdNew').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
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

    onActionClearNewMilitaryDepartment = function() {
        $('#slMilitaryIdNew').empty();
        $('#militaryIdNew').empty();
        //$('#slMilitaryIdNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewMilitaryDepartment = function() {
        onActionClearNewMilitaryDepartment();
        $('#militaryIdNew').append('<option value="">ทั้งหมด</option>');
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#slMilitaryIdNew').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
            $('#militaryIdNew').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
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

    onActionClearNewProvince = function() {
        $('#slProvinceCodeNew').empty();
        //$('#slProvinceCodeNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewProvince = function() {
        onActionClearNewProvince();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeNew').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearNewPermanentProvince = function() {
        $('#slPermanentProvinceCodeNew').empty();
        //$('#slPermanentProvinceCodeNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewPermanentProvince = function() {
        onActionClearNewPermanentProvince();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeNew').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearNewBank = function() {
        $('#slBankCodeNew').empty();
        $('#slBankCodeNew').append('<option value="">เลือก</option>');
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

    ////////////////////////////////////////////////////////////////////

    onActionClearNewBankBranch = function() {
        $('#slBankBranchIdNew').empty();
        //$('#slBankBranchIdNew').append('<option value="">เลือก</option>');
    };

    onActionClearNewBankAccountType = function() {
        $('#slAccTypeIdNew').empty();
        $('#slAccTypeIdNew').append('<option value="">เลือก</option>');
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
                    $('#slBankBranchIdNew').append('<option value="' + itemData.branchId + '">(' + itemData.branchCode + ') ' + itemData.branchName + '</option>');
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
                    $('#slAccTypeIdNew').append('<option value="' + itemData.accTypeId + '">' + itemData.accTypeName + '</option>');
                }
            }
        }
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

    onActionClearNewRankMemberBeneficiary = function() {
        $('#slRankIdMemberBeneficiaryNew').empty();
        //$('#slRankIdMemberBeneficiaryNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewRankMemberBeneficiary = function() {
        onActionClearNewRankMemberBeneficiary();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdMemberBeneficiaryNew').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
        }
    };

    onActionClearNewTitleMemberBeneficiary = function() {
        $('#slTitleIdMemberBeneficiaryNew').empty();
        //$('#slTitleIdMemberBeneficiaryNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewTitleMemberBeneficiary = function() {
        onActionClearNewTitleMemberBeneficiary();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdMemberBeneficiaryNew').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
        }
    };

    onActionClearNewPermanentProvinceMemberBeneficiary = function() {
        $('#slPermanentProvinceCodeMemberBeneficiaryNew').empty();
        //$('#slPermanentProvinceCodeMemberBeneficiaryNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewPermanentProvinceMemberBeneficiary = function() {
        onActionClearNewPermanentProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeMemberBeneficiaryNew').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearNewProvinceMemberBeneficiary = function() {
        $('#slProvinceCodeMemberBeneficiaryNew').empty();
        //$('#slProvinceCodeMemberBeneficiaryNew').append('<option value="">เลือก</option>');
    };

    onActionLoadNewProvinceMemberBeneficiary = function() {
        onActionClearNewProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeMemberBeneficiaryNew').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearNewForEditRankMemberBeneficiary = function() {
        $('#slRankIdMemberBeneficiaryNewForEdit').empty();
        //$('#slRankIdMemberBeneficiaryNewForEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadNewForEditRankMemberBeneficiary = function() {
        onActionClearNewForEditRankMemberBeneficiary();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdMemberBeneficiaryNewForEdit').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
        }
    };

    onActionClearNewForEditTitleMemberBeneficiary = function() {
        $('#slTitleIdMemberBeneficiaryNewForEdit').empty();
        //$('#slTitleIdMemberBeneficiaryNewForEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadNewForEditTitleMemberBeneficiary = function() {
        onActionClearNewForEditTitleMemberBeneficiary();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdMemberBeneficiaryNewForEdit').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
        }
    };

    onActionClearNewForEditPermanentProvinceMemberBeneficiary = function() {
        $('#slPermanentProvinceCodeMemberBeneficiaryNewForEdit').empty();
        //$('#slPermanentProvinceCodeMemberBeneficiaryNewForEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadNewForEditPermanentProvinceMemberBeneficiary = function() {
        onActionClearNewForEditPermanentProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeMemberBeneficiaryNewForEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearNewForEditProvinceMemberBeneficiary = function() {
        $('#slProvinceCodeMemberBeneficiaryNewForEdit').empty();
        //$('#slProvinceCodeMemberBeneficiaryNewForEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadNewForEditProvinceMemberBeneficiary = function() {
        onActionClearNewForEditProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeMemberBeneficiaryNewForEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

//======================================= End MemberBeneficiary ======================================

    onAddActionSearch = function(){
       //alert("onAddActionSearch");
        var search = {};
        var requestSearch = new Array();
        var statussearch = true;
        var condition = 'and';
        if ($('#memberCodeForNew').val().length !== 0) {
            var search2 = {'groupOp': condition, 'field': 'm.member_code', 'op': 'cn', 'data': $('#memberCodeForNew').val(), 'dataType': 'varchar'};
            requestSearch.push(search2);
        }
        if ($('#citizenIdForNew').val().length !== 0) {
            var search3 = {'groupOp': condition, 'field': 'm.citizen_id', 'op': 'cn', 'data': $('#citizenIdForNew').val(), 'dataType': 'varchar'};
            requestSearch.push(search3);
        }
        if ($('#memberNameForNew').val().length !== 0) {
            var search4 = {'groupOp': condition, 'field': 'm.name', 'op': 'cn', 'data': $('#memberNameForNew').val(), 'dataType': 'varchar'};
            requestSearch.push(search4);
        }
        if ($('#memberSurnameForNew').val().length !== 0) {
            var search5 = {'groupOp': condition, 'field': 'm.surname', 'op': 'cn', 'data': $('#memberSurnameForNew').val(), 'dataType': 'varchar'};
            requestSearch.push(search5);
        }
        if ($('#militaryIdNew').val().length !== 0) {
            var search6 = {'groupOp': condition, 'field': 'm.military_id', 'op': 'eq', 'data': $('#militaryIdNew').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }
        
        search.conditions = requestSearch;
       
        $(gridNameNew).jqGrid('setGridParam', {
            search: statussearch,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridNameNew).trigger("reloadGrid", [{page: 1}]);
    };
    
    $("#btnNewSearch").click(function(e) {
        e.preventDefault();
        onAddActionSearch();
    });
    
    $("#btnNewReset").click(function(e) {
        e.preventDefault();
        $("#memberCodeForNew").val("");
        $("#citizenIdForNew").val("");
        $("#memberNameForNew").val("");
        $("#memberSurnameForNew").val("");
        $("#militaryIdNew").val("");
    });
    
    onInit = function() {
        onActionLoadRank();
        onActionLoadTitle();
        onActionLoadMilitaryDepartment();
        onActionLoadProvince();
        onActionLoadBank();
        onActionLoadBankBranch();
        onActionLoadBankAccountType();

        onActionLoadNewRank();
        onActionLoadNewTitle();
        onActionLoadNewMilitaryDepartment();
        onActionLoadNewProvince();
        onActionLoadNewPermanentProvince();
        onActionLoadNewBank();
        onActionLoadNewRankMemberBeneficiary();
        onActionLoadNewTitleMemberBeneficiary();
        onActionLoadNewPermanentProvinceMemberBeneficiary();
        onActionLoadNewProvinceMemberBeneficiary();
        onActionLoadNewForEditRankMemberBeneficiary();
        onActionLoadNewForEditTitleMemberBeneficiary();
        onActionLoadNewForEditPermanentProvinceMemberBeneficiary();
        onActionLoadNewForEditProvinceMemberBeneficiary();
    };

    $("#slBankCodeNew").change(function() {
        //console.info($(this).val());
        onActionLoadNewBankBranch($(this).val());
        onActionLoadNewBankAccountType($(this).val());
    });

    onInit();
});