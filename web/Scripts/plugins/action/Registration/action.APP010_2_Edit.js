$(function () {
    var tabMainName = '#tabMainMember';
    $(tabMainName).tabs();
    $('.ui-tabs-panel').removeClass();
    $(tabMainName).tabs("option", "active", 0);
    //$(document).ready(function() {
//        $('#frmEdit')
//
//                .bootstrapValidator({
//                    // Only disabled elements are excluded
//                    // The invisible elements belonging to inactive tabs must be validated
//                    excluded: [':disabled'],
//                    feedbackIcons: {
//                        valid: 'glyphicon glyphicon-ok',
//                        invalid: 'glyphicon glyphicon-remove',
//                        validating: 'glyphicon glyphicon-refresh'
//                    },
//                    fields: {
//                        txtApplyDateEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The title is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 5,
//                                    message: 'The title must be less than 5 characters long'
//                                }
//                            }
//                        },
//                        slMemberTypeCodeEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Member type code is required'
//                                }
//                            }
//                        },
////                        slRankIdEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The Rank is required'
////                                }
////                            }
////                        },
////                        slTitleIdEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The city is required'
////                                }
////                            }
////                        },
//                        txtNameEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The name is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 256,
//                                    message: 'The name must be less than 256 characters long'
//                                }
//                            }
//                        }
//                        ,
//                        txtSurnameEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Surname is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 256,
//                                    message: 'The Surname must be less than 256 characters long'
//                                }
//                            }
//                        },
//                        txtBirthDateEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The BirthDate is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 10,
//                                    message: 'The BirthDate must be less than 10 characters long'
//                                }
//                            }
//                        },
////                        txtAgeEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The age is required'
////                                },
////                                stringLength: {
////                                    min: 1,
////                                    max: 3,
////                                    message: 'The age must be less than 3 characters long'
////                                }
////                            }
////                        },
//                        slGenderEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The gender is required'
//                                }
//                            }
//                        },
////                        slMilitaryIdEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The MilitaryId is required'
////                                }
////                            }
////                        },
//                        slPaymentTypeEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Payment Type is required'
//                                }
//                            }
//                        },
////                        txtReferrerCodeEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The Referrer Code is required'
////                                },
////                                stringLength: {
////                                    min: 1,
////                                    max: 50,
////                                    message: 'The Referrer Code must be less than 50 characters long'
////                                }
////                            }
////                        },
////                        slReferrerRelationshipCodeEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The Referrer Relationship is required'
////                                }
////                            }
////                        },
////                        slMarryStatusCodeEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The Marry Status is required'
////                                }
////                            }
////                        },
////                        txtWifehusbandFullnameEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The Wife husband Fullname is required'
////                                },
////                                stringLength: {
////                                    min: 1,
////                                    max: 256,
////                                    message: 'The Wife husband Fullname must be less than 256 characters long'
////                                }
////                            }
////                        },
////                        txtPermanentAddressEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The Permanent Address is required'
////                                },
////                                stringLength: {
////                                    min: 1,
////                                    max: 100,
////                                    message: 'The Permanent Address must be less than 100 characters long'
////                                }
////                            }
////                        }
////                        ,
////                        txtPermanentMooEdit: {
////                            validators: {
////                                notEmpty: {
////                                    message: 'The Permanent Moo is required'
////                                },
////                                stringLength: {
////                                    min: 1,
////                                    max: 100,
////                                    message: 'The Permanent Moo must be less than 100 characters long'
////                                }
////                            }
////                        },
//                        txtPermanentRoadEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent Road is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Permanent Road must be less than 100 characters long'
//                                }
//                            }
//                        }
//                        ,
//                        txtPermanentSoiEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent Soi is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Permanent Soi must be less than 100 characters long'
//                                }
//                            }
//                        },
//                        txtPermanentSubdistrictEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent Subdistrict is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Permanent Subdistrict must be less than 100 characters long'
//                                }
//                            }
//                        },
//                        txtPermanentDistrictEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent District is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Permanent District must be less than 100 characters long'
//                                }
//                            }
//                        },
//                        slPermanentProvinceCodeEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent Province is required'
//                                }
//                            }
//                        },
//                        txtPermanentZipcodeEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent Zipcode is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 10,
//                                    message: 'The Permanent Zipcode must be less than 10 characters long'
//                                }
//                            }
//                        }
//                        ,
//                        txtPermanentTelEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent Tel is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 50,
//                                    message: 'The Permanent Tel must be less than 50 characters long'
//                                }
//                            }
//                        },
//                        txtPermanentFaxEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent Fax is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 50,
//                                    message: 'The Permanent Fax xmust be less than 50 characters long'
//                                }
//                            }
//                        },
//                        txtPermanentMobileEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Permanent Mobile is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 50,
//                                    message: 'The Permanent Mobile xmust be less than 50 characters long'
//                                }
//                            }
//                        },
//                        txtAddressEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Address is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Address xmust be less than 100 characters long'
//                                }
//                            }
//                        },
//                        txtMooEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Moo is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Moo xmust be less than 100 characters long'
//                                }
//                            }
//                        },
//                        txtRoadEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Road is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Road xmust be less than 100 characters long'
//                                }
//                            }
//                        },
//                        txtSoiEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Soi is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Soi xmust be less than 100 characters long'
//                                }
//                            }
//                        },
//                        txtSubdistrictEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Subdistrict is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The Subdistrict xmust be less than 100 characters long'
//                                }
//                            }
//                        },
//                        txtDistrictEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The District is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 100,
//                                    message: 'The District xmust be less than 100 characters long'
//                                }
//                            }
//                        },
//                        slProvinceCodeEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Province is required'
//                                }
//                            }
//                        },
//                        txtZipcodeEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Zipcode is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 50,
//                                    message: 'The Zipcode xmust be less than 50 characters long'
//                                }
//                            }
//                        },
//                        txtTelEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Tel is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 50,
//                                    message: 'The Tel xmust be less than 50 characters long'
//                                }
//                            }
//                        },
//                        txtFaxEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Fax is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 50,
//                                    message: 'The Tel xmust be less than 50 characters long'
//                                }
//                            }
//                        },
//                        txtMobileEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Mobile is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 50,
//                                    message: 'The Mobile xmust be less than 50 characters long'
//                                }
//                            }
//                        },
//                        slPaymentTypeCodeEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Payment Type is required'
//                                }
//                            }
//                        },
//                        txtBankAccNameEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Bank Account Name is required'
//                                },
//                                stringLength: {
//                                    min: 1,
//                                    max: 256,
//                                    message: 'The Bank Account Name xmust be less than 256 characters long'
//                                }
//                            }
//                        },
//                        slBankCodeEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Bank is required'
//                                }
//                            }
//                        },
//                        slBankBranchIdEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Bank Branch is required'
//                                }
//                            }
//                        },
//                        txtBankAccNoEdit: {
//                            validators: {
//                                notEmpty: {
//                                    message: 'The Bank Account No is required'
//                                }
//                            },
//                            stringLength: {
//                                min: 1,
//                                max: 50,
//                                message: 'The Bank Account No xmust be less than 50 characters long'
//                            }
//                        }
//                    }
//                })
//                // Called when a field is invalid
//
//                .on('error.field.bv', function(e, data) {
//                    // data.element --> The field element
//                    var $tabPane = data.element.parents('.tab-pane'),
//                            tabId = $tabPane.attr('id');
//
//                    $('a[href="#' + tabId + '"][data-toggle="tab"]')
//                            .parent()
//                            .find('i')
//                            .removeClass('fa-check')
//                            .addClass('fa-times');
//                })
//                // Called when a field is valid
//                .on('success.field.bv', function(e, data) {
//                    // data.bv      --> The BootstrapValidator instance
//                    // data.element --> The field element
//                    e.preventDefault();
//
//                    // Get the form instance
//                    var $form = $(e.target);
//
//                    // Get the BootstrapValidator instance
//                    var bv = $form.data('bootstrapValidator');
//
//                    // Use Ajax to submit form data
//                    //onActionSaveNew();
////                    var $tabPane = data.element.parents('.tab-pane'),
////                            tabId = $tabPane.attr('id'),
////                            $icon = $('a[href="#' + tabId + '"][data-toggle="tab"]')
////                            .parent()
////                            .find('i')
////                            .removeClass('fa-check fa-times');
////
////                    // Check if the submit button is clicked
////                    if (data.bv.getSubmitButton()) {
////                        // Check if all fields in tab are valid
////                        var isValidTab = data.bv.isValidContainer($tabPane);
////                        $icon.addClass(isValidTab ? 'fa-check' : 'fa-times');
//                    //}
//                });
    //});

    $("#dialogFormReferrerEdit").removeClass('hide').dialog({
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
                click: function () {
                    onActionSelectReferrerEdit();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ไม่เลือก",
                "class": "btn btn-xs",
                click: function () {
                    $(this).dialog("close");
                }
            }
        ]
    });

    $("#btnReferrerEdit").click(function (event) {
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
                click: function () {
                    onActionSaveMemberBeneficiaryNewForEdit();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                "class": "btn btn-xs",
                click: function () {
                    var formId = '#frmMemberBeneficiaryEdit';
                    var formName = $(formId);
                    $(formName)[0].reset();
                    $(this).dialog("close");
                }
            }
        ]
    });

    $("#btnAddMemberBeneficiaryEdit").click(function (event) {
        $("#dialogFormMemberBeneficiaryEdit").dialog("open");
    });

    onDialogDeleteMemberBeneficiaryEdit = function (id) {
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
                    click: function () {
                        onActionDeleteMemberBeneficiaryEdit(this, id);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                    "class": "btn btn-xs",
                    click: function () {
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };

    onActionSelectReferrerEdit = function () {
        var dialogForm = '#dialogFormReferrerEdit';
        var myGrid = $('#gridData_APP010_2_Edit_Select_jqGrid_List');
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

    onActionSaveMemberBeneficiaryNewForEdit = function () {
        var formId = '#frmMemberBeneficiaryEdit';
        var dialogForm = '#dialogFormMemberBeneficiaryEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeMemberBeneficiaryEdit, function (inputData) {
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

    onActionSaveMemberBeneficiaryEditForEdit = function (id) {
        var formId = '#frmMemberBeneficiaryEditForEdit';
        var dialogForm = '#dialogFormMemberBeneficiaryEditForEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeMemberBeneficiaryEditForEdit, function (inputData) {
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

    onDialogEditMemberBeneficiaryEditForEdit = function (id) {
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
                    click: function () {
                        onActionSaveMemberBeneficiaryEditForEdit(id);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                    "class": "btn btn-xs",
                    click: function () {
                        var formId = '#frmMemberBeneficiaryEditForEdit';
                        var formName = $(formId);
                        $(formName)[0].reset();
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };

    onActionLoadMemberBeneficiaryEditForEdit = function (id) {
        var idCheck = 0;
        var iArray = 0;
        for (var i = 0, item; item = listAPP010[i]; i++) {
            idCheck = i + 1;
            if (idCheck == id) {
                $.map(inputToChangeMemberBeneficiaryEditForEdit, function (getData) {
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

    onActionDeleteMemberBeneficiaryEdit = function (thisDialog, id) {
        var listAPP010EditTempAdd = new Array();
        var idCheck = 0;
        for (var i = 0, item; item = listAPP010[i]; i++) {
            idCheck = i + 1;
            if (idCheck != id) {
                listAPP010EditTempAdd.push(item);
            } else {
                listAPP010Delete.push(item['beneficiaryId']);
            }
        }
        listAPP010 = listAPP010EditTempAdd;
        listAPP010EditTempAdd = null;
        $(thisDialog).dialog("close");
        onRefreshGridMemberBeneficiaryEdit();
    };

    onRefreshGridMemberBeneficiaryEdit = function () {
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

    onActionSaveEdit = function () {
        var formId = '#frmEdit';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeEdit, function (inputData) {
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
                success: function (msg) {
                    $.fn.DialogMessage(msg);
                    if (msg.checkSuccess === true) {
                        //$(formName)[0].reset();
                        onActionLoadMemberBeneficiary($('#hidMemberIdEdit').val());
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
        }
    };

    $("#btnSaveEdit").click(function (event) {
        onActionSaveEdit();
    });

    onActionLoadRank = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonRank,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (json) {
                listRank = json;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionClearEditRank = function () {
        $('#slRankIdEdit').empty();
        //$('#slRankIdEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditRank = function () {
        onActionClearEditRank();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdEdit').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
        }
    };

    onActionLoadTitle = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonTitle,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (json) {
                listTitle = json;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionClearEditTitle = function () {
        $('#slTitleIdEdit').empty();
        //$('#slTitleIdEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditTitle = function () {
        onActionClearEditTitle();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdEdit').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
        }
    };

    onActionLoadMilitaryDepartment = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonMilitaryDepartment,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (json) {
                listMilitaryDepartment = json;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionClearEditMilitaryDepartment = function () {
        $('#slMilitaryIdEdit').empty();
        $('#militaryIdEdit').empty();
        //$('#slMilitaryIdEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditMilitaryDepartment = function () {
        onActionClearEditMilitaryDepartment();
        $('#militaryIdEdit').append('<option value="">ทั้งหมด</option>');
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#slMilitaryIdEdit').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
            $('#militaryIdEdit').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };

    onActionLoadProvince = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonProvince,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (json) {
                listProvince = json;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionClearEditProvince = function () {
        $('#slProvinceCodeEdit').empty();
        //$('#slProvinceCodeEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditProvince = function () {
        onActionClearEditProvince();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearEditPermanentProvince = function () {
        $('#slPermanentProvinceCodeEdit').empty();
        //$('#slPermanentProvinceCodeEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditPermanentProvince = function () {
        onActionClearEditPermanentProvince();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearEditBank = function () {
        $('#slBankCodeEdit').empty();
        $('#slBankCodeEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadBank = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonBank,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (json) {
                listBank = json;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionLoadEditBank = function () {
        onActionClearEditBank();
        for (var item in listBank) {
            var itemData = listBank[item];
            $('#slBankCodeEdit').append('<option value="' + itemData.bankCode + '">(' + itemData.bankCode + ') ' + $.trim(itemData.bankName) + '</option>');
        }
    };
    ////////////////////////////////////////////////////////////////////

    onActionClearEditBankBranch = function () {
        $('#slBankBranchIdEdit').empty();
        //$('#slBankBranchIdEdit').append('<option value="">เลือก</option>');
    };

    onActionClearEditBankAccountType = function () {
        $('#slAccTypeIdEdit').empty();
        $('#slAccTypeIdEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadBankBranch = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonBankBranch,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (json) {
                listBankBranch = json;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionLoadEditBankBranch = function (value) {
        onActionClearEditBankBranch();
        if ('' != value) {
            for (var item in listBankBranch) {
                var itemData = listBankBranch[item];
                if (itemData.bankCode === value) {
                    $('#slBankBranchIdEdit').append('<option value="' + itemData.branchId + '">(' + itemData.branchCode + ') ' + itemData.branchName + '</option>');
                }
            }
        }
    };

    onActionLoadBankAccountType = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonBankAccountType,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (json) {
                listBankAccountType = json;
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionLoadEditBankAccountType = function (value) {
        onActionClearEditBankAccountType();
        if ('' != value) {
            for (var item in listBankAccountType) {
                var itemData = listBankAccountType[item];
                if (itemData.bankCode === value) {
                    $('#slAccTypeIdEdit').append('<option value="' + itemData.accTypeId + '">' + itemData.accTypeName + '</option>');
                }
            }
        }
    };

    onActionLoadReferrer = function (id) {
        var objData = {};
        objData[objIdKeyEdit] = id;
        var req = {};
        req.data2Json = $.toJSON(objData);
        $.ajax({
            type: 'POST',
            url: urlLoadReferrer,
            cache: false,
            //timeout: 1000,
            async: false,
            data: req,
            dataType: 'json',
            success: function (json) {
                //console.info(json);
                $('#txtReferrerFullnameEdit').val(json.name + ' ' + json.surname);
                $('#txtReferrerCodeEdit').val(json.memberCode);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionLoad = function (id) {
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
            success: function (objectResponse) {
                objectDefault = objectResponse;
                $.map(inputToChangeEdit, function (getData) {
                    //console.info("" + getData + ":" + objectResponse[getData]);
                    if (inputToMergeEdit[iArray].toLowerCase().indexOf(':checked') >= 0) {
                        if (objectResponse[getData] === 'E') {
                            $(inputToMergeEdit[iArray].replace(/:checked/g, '')).prop('checked', true);
                        } else {
                            $(inputToMergeEdit[iArray].replace(/:checked/g, '')).prop('checked', false);
                        }
                    } else if (inputToMergeEdit[iArray].toLowerCase().indexOf('date') >= 0) {
                        if (objectResponse[getData] == null || objectResponse[getData] == '') {
                            $(inputToMergeEdit[iArray]).val('');
                        } else {
                            $(inputToMergeEdit[iArray]).val($.formatDateTime('dd/mm/yy', new Date(objectResponse[getData])));//$.fn.fmatter('date', objectResponse[getData], {newformat: 'dd/mm/yyyy'}));
                        }
                    } else if (inputToMergeEdit[iArray].toLowerCase().indexOf('bankcode') >= 0) {
                        $(inputToMergeEdit[iArray]).val(objectResponse[getData]);
                        onActionLoadEditBankBranch(objectResponse[getData]);
                        onActionLoadEditBankAccountType(objectResponse[getData]);
                    } else {
                        $(inputToMergeEdit[iArray]).val(objectResponse[getData]);
                    }
                    iArray++;
                });
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };

    onActionLoadMemberBeneficiary = function (id) {
        var objData = {};
        listAPP010 = [];
        listAPP010Delete = [];
        objData[objIdKeyEdit] = id;
        var req = {};
        req.data2Json = $.toJSON(objData);
        $.ajax({
            type: 'POST',
            url: urlLoadMemberBeneficiary,
            data: req,
            dataType: 'json',
            async: false,
            success: function (objectResponse) {

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
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };

    onCheckMemberRelationshipCode = function (keyValue) {
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

    onActionClearEditRankMemberBeneficiary = function () {
        $('#slRankIdMemberBeneficiaryEdit').empty();
        //$('#slRankIdMemberBeneficiaryEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditRankMemberBeneficiary = function () {
        onActionClearEditRankMemberBeneficiary();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdMemberBeneficiaryEdit').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
        }
    };

    onActionClearEditTitleMemberBeneficiary = function () {
        $('#slTitleIdMemberBeneficiaryEdit').empty();
        //$('#slTitleIdMemberBeneficiaryEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditTitleMemberBeneficiary = function () {
        onActionClearEditTitleMemberBeneficiary();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdMemberBeneficiaryEdit').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
        }
    };

    onActionClearEditPermanentProvinceMemberBeneficiary = function () {
        $('#slPermanentProvinceCodeMemberBeneficiaryEdit').empty();
        //$('#slPermanentProvinceCodeMemberBeneficiaryEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditPermanentProvinceMemberBeneficiary = function () {
        onActionClearEditPermanentProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeMemberBeneficiaryEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearEditProvinceMemberBeneficiary = function () {
        $('#slProvinceCodeMemberBeneficiaryEdit').empty();
        //$('#slProvinceCodeMemberBeneficiaryEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditProvinceMemberBeneficiary = function () {
        onActionClearEditProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeMemberBeneficiaryEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearEditForEditRankMemberBeneficiary = function () {
        $('#slRankIdMemberBeneficiaryEditForEdit').empty();
        //$('#slRankIdMemberBeneficiaryEditForEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditForEditRankMemberBeneficiary = function () {
        onActionClearEditForEditRankMemberBeneficiary();
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#slRankIdMemberBeneficiaryEditForEdit').append('<option value="' + itemData.rankId + '">' + itemData.rankName + ' ' + itemData.rankFullname + '</option>');
        }
    };

    onActionClearEditForEditTitleMemberBeneficiary = function () {
        $('#slTitleIdMemberBeneficiaryEditForEdit').empty();
        //$('#slTitleIdMemberBeneficiaryEditForEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditForEditTitleMemberBeneficiary = function () {
        onActionClearEditForEditTitleMemberBeneficiary();
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#slTitleIdMemberBeneficiaryEditForEdit').append('<option value="' + itemData.titleId + '">' + itemData.title + '</option>');
        }
    };

    onActionClearEditForEditPermanentProvinceMemberBeneficiary = function () {
        $('#slPermanentProvinceCodeMemberBeneficiaryEditForEdit').empty();
        //$('#slPermanentProvinceCodeMemberBeneficiaryEditForEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditForEditPermanentProvinceMemberBeneficiary = function () {
        onActionClearEditForEditPermanentProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slPermanentProvinceCodeMemberBeneficiaryEditForEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };

    onActionClearEditForEditProvinceMemberBeneficiary = function () {
        $('#slProvinceCodeMemberBeneficiaryEditForEdit').empty();
        //$('#slProvinceCodeMemberBeneficiaryEditForEdit').append('<option value="">เลือก</option>');
    };

    onActionLoadEditForEditProvinceMemberBeneficiary = function () {
        onActionClearEditForEditProvinceMemberBeneficiary();
        for (var item in listProvince) {
            var itemData = listProvince[item];
            $('#slProvinceCodeMemberBeneficiaryEditForEdit').append('<option value="' + itemData.provinceCode + '">' + itemData.provinceName + '</option>');
        }
    };
//======================================= End MemberBeneficiary ======================================
    onAddActionSearch = function () {
        //alert("onAddActionSearch");
        var search = {};
        var requestSearch = new Array();
        var statussearch = true;
        var condition = 'and';
        if ($('#memberCodeForEdit').val().length !== 0) {
            var search2 = {'groupOp': condition, 'field': 'm.member_code', 'op': 'eq', 'data': $('#memberCodeForEdit').val(), 'dataType': 'varchar'};
            requestSearch.push(search2);
        }
        if ($('#citizenIdForEdit').val().length !== 0) {
            var search3 = {'groupOp': condition, 'field': 'm.citizen_id', 'op': 'eq', 'data': $('#citizenIdForEdit').val(), 'dataType': 'varchar'};
            requestSearch.push(search3);
        }
        if ($('#memberNameForEdit').val().length !== 0) {
            var search4 = {'groupOp': condition, 'field': 'm.name', 'op': 'eq', 'data': $('#memberNameForEdit').val(), 'dataType': 'varchar'};
            requestSearch.push(search4);
        }
        if ($('#memberSurnameForEdit').val().length !== 0) {
            var search5 = {'groupOp': condition, 'field': 'm.surname', 'op': 'eq', 'data': $('#memberSurnameForEdit').val(), 'dataType': 'varchar'};
            requestSearch.push(search5);
        }
        if ($('#militaryIdEdit').val().length !== 0) {
            var search6 = {'groupOp': condition, 'field': 'm.military_id', 'op': 'eq', 'data': $('#militaryIdEdit').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }

        search.conditions = requestSearch;

        $(gridNameEdit).jqGrid('setGridParam', {
            search: statussearch,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridNameEdit).trigger("reloadGrid", [{page: 1}]);
    };

    $("#btnEditSearch").click(function (e) {
        e.preventDefault();
        onAddActionSearch();
    });

    $("#btnEditReset").click(function (e) {
        e.preventDefault();
        $("#memberCodeForEdit").val("");
        $("#citizenIdForEdit").val("");
        $("#memberNameForEdit").val("");
        $("#memberSurnameForEdit").val("");
        $("#militaryIdEdit").val("");
    });

    onInit = function () {
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
        onActionLoadReferrer($('#hidReferrerIdEdit').val());
    };
    $("#slBankCodeEdit").change(function () {
//console.info($(this).val());
        onActionLoadEditBankBranch($(this).val());
        onActionLoadEditBankAccountType($(this).val());
    });
    onInit();
});