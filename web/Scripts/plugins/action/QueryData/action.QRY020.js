$(function () {
    var tabMainName = '#tabMainMember';
    $(tabMainName).tabs();
    $('.ui-tabs-panel').removeClass();
    $(tabMainName).tabs("option", "active", 0);

    $("#btnView").click(function (event) {
        event.preventDefault();
        var objDataAction = {};
        objDataAction.memberId = 0;
        if ($("input[name=rdDataTypeSearch]:checked").val() == 'citizenId') {
            objDataAction.citizenId = $('#txtSearch').val();
            objDataAction.memberCode = '';
        } else {
            objDataAction.citizenId = '';
            objDataAction.memberCode = $('#txtSearch').val();
        }
        var req = {};
        req.data2Json = $.toJSON(objDataAction);
        $.ajax({
            type: 'POST',
            url: urlGetLoadQRY020,
            cache: false,
            //timeout: 1000,
            async: false,
            data: req,
            dataType: 'json',
            success: function (json) {
                $.fn.DialogMessageResponse(json);
                if (json.checkSuccess) {
                    onLoadDetail(json.obj);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    });

    onLoadDetail = function (detail) {
        $('#spMemberCode').text(detail.memberCode);
        $('#spApprovedDate').text($.formatDateTime('dd/mm/yy', new Date(detail.approvedDate)));
        $('#spCitizenId').text(detail.citizenId);
        $('#spStartMonthCode').text(detail.startMonthCode);
        $('#spRankOrTitleName').text(detail.rankOrTitleName);
        $('#spGender').text(onGender(detail.gender));
        $('#spName').text(detail.name);
        $('#spSurname').text(detail.surname);

        $('#spBirthDate').text($.formatDateTime('dd/mm/yy', new Date(detail.birthDate)));
        $('#spBirthDateYear').text(onAge(detail.birthDate));
        $('#spMemberGroupCode').text(onMemberGroupCode(detail.memberGroupCode));
        $('#spMemberTypeCode').text(onMemberTypeCode(detail.memberTypeCode));
        $('#spPaymentTypeCode').text(onPaymentTypeCode(detail.paymentTypeCode));
        $('#spMilitaryName').text(detail.militaryName);
        $('#spReferrerRelationshipCode').text(onReferrerRelationshipCode(detail.ReferrerRelationshipCode));
        onReferrerRelationship(detail.referrerId);
        $('#spMarryStatusCode').text(onMarryStatusCode(detail.marryStatusCode));
        $('#spWifehusbandFullname').text(detail.wifehusbandFullname);
        $('#spRemark').text(detail.remark);
        $('#spMemberStatusCode').text(onMemberStatusCode(detail.memberStatusCode));

        $('#spPermanentAddress').text(detail.permanentAddress);
        $('#spPermanentMoo').text(detail.permanentMoo);
        $('#spPermanentRoad').text(detail.permanentRoad);
        $('#spPermanentSoi').text(detail.permanentSoi);
        $('#spPermanentSubdistrict').text(detail.permanentSubdistrict);
        $('#spPermanentDistrict').text(detail.permanentDistrict);
        $('#spPermanentProvinceName').text(detail.permanentProvinceName);
        $('#spPermanentZipcode').text(detail.permanentZipcode);
        $('#spPermanentTel').text(detail.permanentTel);
        $('#spPermanentFax').text(detail.permanentFax);
        $('#spPermanentMobile').text(detail.permanentMobile);

        $('#spAddress').text(detail.address);
        $('#spMoo').text(detail.moo);
        $('#spRoad').text(detail.road);
        $('#spSoi').text(detail.soi);
        $('#spSubdistrict').text(detail.subdistrict);
        $('#spDistrict').text(detail.district);
        $('#spProvinceName').text(detail.provinceName);
        $('#spZipcode').text(detail.zipcode);
        $('#spTel').text(detail.tel);
        $('#spFax').text(detail.fax);
        $('#spMobile').text(detail.mobile);

        onActionLoadMemberBeneficiary(detail.memberId);
        onPaymentView(detail.memberId);
        onMemberStatusView(detail.memberId);
        onMemberDeptHistoryView(detail.memberId);
        onMemberPaymentTypeHistoryView(detail.memberId);
        onMemberTitleNameHistoryView(detail.memberId);
    };

    onReferrerRelationship = function (id) {
        var objDataAction = {};
        objDataAction.memberId = id;
        objDataAction.citizenId = '';
        objDataAction.memberCode = '';
        var req = {};
        req.data2Json = $.toJSON(objDataAction);
        $.ajax({
            type: 'POST',
            url: urlGetLoadQRY020,
            cache: false,
            //timeout: 1000,
            async: false,
            data: req,
            dataType: 'json',
            success: function (json) {
                if (json.checkSuccess) {
                    $('#spReferrerCode').text(json.obj.memberCode);
                    $('#spReferrerNameText').text(json.obj.name + ' ' + json.obj.surname);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionLoadMemberBeneficiary = function (id) {
        var objData = {};
        listMemberBeneficiary = [];
        objData['memberId'] = id;
        var req = {};
        req.data2Json = $.toJSON(objData);
        $.ajax({
            type: 'POST',
            url: urlLoadMemberBeneficiary,
            data: req,
            dataType: 'json',
            async: false,
            success: function (objectResponse) {
                for (var i = 0, item; item = objectResponse[i]; i++) {
                    item['memberRelationship'] = onReferrerRelationshipCode(item['memberRelationshipCode']);
                    listMemberBeneficiary.push(item);
                }

                onRefreshGridMemberBeneficiary();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };

    onRefreshGridMemberBeneficiary = function () {
        var jqGridData = {};
        var listMemberBeneficiaryTempAdd = new Array();
        var icout = 0;
        for (var i = 0, item; item = listMemberBeneficiary[i]; i++) {
            icout++;
            item['id'] = icout;
            listMemberBeneficiaryTempAdd.push(item);
        }
        jqGridData.total = 1;
        jqGridData.page = 1;
        jqGridData.records = listMemberBeneficiaryTempAdd.length;
        jqGridData.rows = listMemberBeneficiaryTempAdd;
        myStringListMemberBeneficiary = $.toJSON(jqGridData);
        $('#gridData_QRY020_View_Grid_List').setGridParam({
            datatype: 'jsonstring',
            datastr: myStringListMemberBeneficiary
        }).trigger("reloadGrid");
    };

    onPaymentView = function (id) {
        $('#gridData_QRY020_Payment_View_Grid_List').jqGrid('setGridParam', {
            search: false,
            url: urlListQRY020PaymentView + id
        });
        $('#gridData_QRY020_Payment_View_Grid_List').trigger("reloadGrid", [{page: 1}]);
    };

    onMemberStatusView = function (id) {
        $('#gridData_QRY020_Member_Status_View_Grid_List').jqGrid('setGridParam', {
            search: false,
            url: urlListQRY020MemberStatusView + id
        });
        $('#gridData_QRY020_Member_Status_View_Grid_List').trigger("reloadGrid", [{page: 1}]);
    };

    onMemberDeptHistoryView = function (id) {
        $('#gridData_QRY020_Member_Dept_History_View_Grid_List').jqGrid('setGridParam', {
            search: false,
            url: urlListQRY020MemberDeptHistoryView + id
        });
        $('#gridData_QRY020_Member_Dept_History_View_Grid_List').trigger("reloadGrid", [{page: 1}]);
    };

    onMemberPaymentTypeHistoryView = function (id) {
        $('#gridData_QRY020_Member_Payment_Type_History_View_Grid_List').jqGrid('setGridParam', {
            search: false,
            url: urlListQRY020MemberPaymentTypeHistoryView + id
        });
        $('#gridData_QRY020_Member_Payment_Type_History_View_Grid_List').trigger("reloadGrid", [{page: 1}]);
    };

    onMemberTitleNameHistoryView = function (id) {
        $('#gridData_QRY020_Member_Title_Name_History_View_Grid_List').jqGrid('setGridParam', {
            search: false,
            url: urlListQRY020MemberTitleNameHistoryView + id
        });
        $('#gridData_QRY020_Member_Title_Name_History_View_Grid_List').trigger("reloadGrid", [{page: 1}]);
    };

    onAge = function (birthDate) {
        var dob = new Date(birthDate);
        var today = new Date();
        var age = Math.floor((today - dob) / (365.25 * 24 * 60 * 60 * 1000));
        return age;
    };

    onReferrerRelationshipCode = function (code) {
        var text = '';
        switch (code) {
            case 10:
            {
                text = 'คู่สมรส';
                break;
            }
            case 20:
            {
                text = 'บุตร/ธิดา';
                break;
            }
            case 30:
            {
                text = 'บิดา';
                break;
            }
            case 31:
            {
                text = 'มารดา';
                break;
            }
            case 40:
            {
                text = 'บิดาคู่สมรส';
                break;
            }
            case 41:
            {
                text = 'มารดาคู่สมรส';
                break;
            }
            case 70:
            {
                text = 'บุตรเขย';
                break;
            }
            case 80:
            {
                text = 'ญาติ';
                break;
            }
            case 90:
            {
                text = 'เพื่อน';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onGender = function (code) {
        var text = '';
        switch (code) {
            case 'M':
            {
                text = 'ชาย';
                break;
            }
            case 'F':
            {
                text = 'หญิง';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onMemberGroupCode = function (code) {
        var text = '';
        switch (code) {
            case 10:
            {
                text = 'ข้าราชการ';
                break;
            }
            case 20:
            {
                text = 'ครอบครัว';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onMemberTypeCode = function (code) {
        var text = '';
        switch (code) {
            case 10:
            {
                text = 'สมัครด้วยตัวเอง';
                break;
            }
            case 20:
            {
                text = 'สมัครผ่านหน่วยต้นสังกัด';
                break;
            }
            case 30:
            {
                text = 'สมัครผ่านชุดรับสมัคร';
                break;
            }
            case 40:
            {
                text = 'สมัครผ่านกรณีพิเศษ';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onPaymentTypeCode = function (code) {
        var text = '';
        switch (code) {
            case 10:
            {
                text = 'ชำระผ่านหน่วย';
                break;
            }
            case 11:
            {
                text = 'ผู้ชำระแทน';
                break;
            }
            case 20:
            {
                text = 'ชำระด้วยตนเอง (เงินสด)';
                break;
            }
            case 21:
            {
                text = 'ชำระผ่านธนาณัติ';
                break;
            }
            case 22:
            {
                text = 'ชำระผ่านธนาคาร';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onMarryStatusCode = function (code) {
        var text = '';
        switch (code) {
            case 10:
            {
                text = 'โสด';
                break;
            }
            case 20:
            {
                text = 'มีสามี';
                break;
            }
            case 30:
            {
                text = 'มีภรรยา';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onMemberStatusCode = function (code) {
        var text = '';
        switch (code) {
            case 10 :
            {
                text = 'ยื่นใบสมัคร';
                break;
            }
            case 11 :
            {
                text = 'ชำระเงินค่าสมัคร';
                break;
            }
            case 12 :
            {
                text = 'บันทึกข้อมูลเพิ่มเติม';
                break;
            }
            case 13 :
            {
                text = 'อนุมัติเห็นชอบ';
                break;
            }
            case 20 :
            {
                text = 'กำหนดเลขทะเบียนสมาชิก';
                break;
            }
            case 25 :
            {
                text = 'ดำเนินการขออนุมัติขึ้นทะเบียน';
                break;
            }
            case 105 :
            {
                text = 'อนุมัติขึ้นทะเบียนเป็นสมาชิก';
                break;
            }
            case 100 :
            {
                text = 'สมาชิกปกติ';
                break;
            }
            case 101 :
            {
                text = 'ค้างชำระ 1 เดือน';
                break;
            }
            case 102 :
            {
                text = 'ค้างชำระ 2 เดือน';
                break;
            }
            case 103 :
            {
                text = 'ค้างชำระ 3 เดือน และได้ดำเนินการทวงถาม';
                break;
            }
            case 109 :
            {
                text = 'ดำเนินการถอนสภาพชั่วคราว';
                break;
            }
            case 110 :
            {
                text = 'ถูกถอนสภาพชั่วคราว';
                break;
            }
            case 115 :
            {
                text = 'บันทึกขอคืนสภาพ';
                break;
            }
            case 116 :
            {
                text = 'ชำระเงินค้างชำระ';
                break;
            }
            case 119 :
            {
                text = 'ดำเนินการคืนสภาพ';
                break;
            }
            case 120 :
            {
                text = 'คืนสภาพเป็นสมาชิกปกติ';
                break;
            }
            case 130 :
            {
                text = 'คืนสภาพเป็นสมาชิกปกติกรณีพิเศษ';
                break;
            }
            case 199 :
            {
                text = 'ดำเนินการถอนสภาพถาวร';
                break;
            }
            case 200 :
            {
                text = 'ถูกถอนสภาพถาวร';
                break;
            }
            case 205 :
            {
                text = 'บันทึกแจ้งถึงแก่กรรม';
                break;
            }
            case 206 :
            {
                text = 'บันทึกการจ่ายค่าจัดการศพ';
                break;
            }
            case 207 :
            {
                text = 'ขออนุมัติจ่ายค่าจัดการศพ';
                break;
            }
            case 210 :
            {
                text = 'ถึงแก่กรรม';
                break;
            }
            case 220 :
            {
                text = 'ลาออก';
                break;
            }
            case 231 :
            {
                text = 'เสียชีวิตก่อนขึ้นทะเบียน';
                break;
            }
            case 232 :
            {
                text = 'ไม่อนุมััติขอความเห็นชอบ';
                break;
            }
            case 233 :
            {
                text = 'ไม่อนุมัติเลขทะเบียน';
                break;
            }
            case 234 :
            {
                text = 'ไม่อนุมัติขึ้นทะเบียน';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onApproved = function (code) {
        var text = '';
        switch (code) {
            case 0:
            {
                text = 'อยู่ระหว่างดำเนินการ';
                break;
            }
            case 1:
            {
                text = 'ได้รับอนุมัติแล้ว';
                break;
            }
            case 2:
            {
                text = 'ไม่ผ่านการอนุมัติ';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onChangeCode = function (code) {
        var text = '';
        switch (code) {
            case 10:
            {
                text = 'แจ้งด้วยตนเอง';
                break;
            }
            case 20:
            {
                text = 'แจ้งผ่านหน่วยต้นสังกัด';
                break;
            }
            default:
            {
                text = '';
                break;
            }
        }
        return text;
    };

    onDialogViewMemberBeneficiary = function (id) {
        onActionLoadMemberBeneficiaryView(id);
        $("#dialogFormMemberBeneficiaryView").removeClass('hide').dialog({
            width: '800px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> ผู้รับเงินสงเคราห์ </h4></div>",
            title_html: true,
            autoOpen: true,
            buttons: [
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

//dialogFormSearch
    $("#dialogFormSearch").removeClass('hide').dialog({
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
                    onActionDialogFormSearch();
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

    $("#btnSearchSelect").click(function (event) {
        $("#dialogFormSearch").dialog("open");
    });

    onActionDialogFormSearch = function () {
        var dialogForm = '#dialogFormSearch';
        var myGrid = $('#gridData_QRY020_For_Search_jqGrid_List');
        var $selRadio = $('input[name=rd_' + myGrid[0].id + ']:radio:checked'), $tr;
        if ($selRadio.length > 0) {
            $tr = $selRadio.closest('tr');
            if ($tr.length > 0) {
                //var selRowId = myGrid.jqGrid('getGridParam', 'selrow');
                var selRowId = $tr.attr('id');
                var citizenId = myGrid.jqGrid('getCell', selRowId, 'citizenId');
                var memberCode = myGrid.jqGrid('getCell', selRowId, 'memberCode');
                if ('' != memberCode) {
                    $('#txtSearch').val(memberCode);
                    $('input:radio[name="rdDataTypeSearch"]').filter('[value="memberCode"]').prop('checked', true);
                } else {
                    $('#txtSearch').val(citizenId);
                    $('input:radio[name="rdDataTypeSearch"]').filter('[value="citizenId"]').prop('checked', true);
                }
                $(dialogForm).dialog("close");
            }
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    };

    onActionFormSearch = function () {
        var search = {};
        var requestSearch = new Array();
        var statussearch = true;
        var condition = 'and';
        if ($('#memberCodeForSearch').val().length !== 0) {
            var search2 = {'groupOp': condition, 'field': 'm.member_code', 'op': 'cn', 'data': $('#memberCodeForSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search2);
        }
        if ($('#citizenIdForSearch').val().length !== 0) {
            var search3 = {'groupOp': condition, 'field': 'm.citizen_id', 'op': 'cn', 'data': $('#citizenIdForSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search3);
        }
        if ($('#memberNameForSearch').val().length !== 0) {
            var search4 = {'groupOp': condition, 'field': 'm.name', 'op': 'cn', 'data': $('#memberNameForSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search4);
        }
        if ($('#memberSurnameForSearch').val().length !== 0) {
            var search5 = {'groupOp': condition, 'field': 'm.surname', 'op': 'cn', 'data': $('#memberSurnameForSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search5);
        }
        if ($('#militaryIdForSearch').val().length !== 0) {
            var search6 = {'groupOp': condition, 'field': 'm.military_id', 'op': 'eq', 'data': $('#militaryIdForSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }

        search.conditions = requestSearch;

        $('#gridData_QRY020_For_Search_jqGrid_List').jqGrid('setGridParam', {
            search: statussearch,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $('#gridData_QRY020_For_Search_jqGrid_List').trigger("reloadGrid", [{page: 1}]);

    };


    $("#btnActionSearch").click(function (e) {
        e.preventDefault();
        onActionFormSearch();
    });

    $("#btnActionSearchReset").click(function (e) {
        e.preventDefault();
        $("#memberCodeForSearch").val("");
        $("#citizenIdForSearch").val("");
        $("#memberNameForSearch").val("");
        $("#memberSurnameForSearch").val("");
        $("#militaryIdSearch").val("");
    });

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

    onActionLoadSearchMilitaryDepartment = function () {
        onActionClearSearchMilitaryDepartment();
        $('#militaryIdForSearch').append('<option value="">ทั้งหมด</option>');
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#militaryIdForSearch').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };
    onActionClearSearchMilitaryDepartment = function () {
        $('#militaryIdForSearch').empty();
    };

    onInit = function () {
        onActionLoadMilitaryDepartment();
        onActionLoadSearchMilitaryDepartment();
    };

    onInit();
});