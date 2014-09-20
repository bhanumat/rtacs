
$(function () {
    
    onActionSearch = function() {
        var search = {};
        var statusSearch = false; //0 is not in condition, 1 is in condition
        var requestSearch = new Array();
        var condition = '';
        var citizenId = $('#citizenId').val();
        if(citizenId.length !== 0){
            if(citizenId.length===13){
                var search1 = {'groupOp': condition, 'field': 'citizenId', 'op': 'eq', 'data': citizenId, 'dataType': 'varchar'};
                requestSearch.push(search1);
                condition = 'and';
                statusSearch = true;
            }else{
                $("#Dialog-Confirm").html("กรุณากรอกรหัสประชาชนเป็น 13 หลักเท่านั้น");
                $("#Dialog-Confirm").removeClass('hide').dialog({
                    width: '300px',
                    resizable: false,
                    modal: true,
                    title: "<div class='widget-header'><h4 class='smaller'> แจ้งเตือน</h4></div>",
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
                return;
            }
        }
//        if($('#txtNameSearch').val().length!==0){
//            var search2 = {'groupOp': condition, 'field': 'name', 'op': 'cn', 'data': $('#txtNameSearch').val(), 'dataType': 'varchar'};
//            requestSearch.push(search2);
//            condition = 'and';
//            statusSearch = true;
//        }
//        if($('#txtSurnameSearch').val().length!==0){
//            var search3 = {'groupOp': condition, 'field': 'surname', 'op': 'cn', 'data': $('#txtSurnameSearch').val(), 'dataType': 'varchar'};
//            requestSearch.push(search3);
//            condition = 'and';
//            statusSearch = true;
//        }
//
//        if ($('#txtApplyDateFromSearch').val().length !== 0 && $('#txtApplyDateEndSearch').val().length !== 0) {
//            var search4 = {'groupOp': condition, 'field': 'applyDate', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val() + "," + $('#txtApplyDateEndSearch').val(), 'dataType': 'date'};
//            requestSearch.push(search4);
//            statusSearch = true;
//            condition = 'and';
//        } else {
//            if ($('#txtApplyDateFromSearch').val().length !== 0) {
//                var search5 = {'groupOp': condition, 'field': 'applyDate', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val(), 'dataType': 'date'};
//                requestSearch.push(search5);
//                statusSearch = true;
//                 condition = 'and';
//            } else {
//                if ($('#txtApplyDateEndSearch').val().length !== 0) {
//                    $("#Dialog-Confirm").html("กรุณากรอกข้อมูลค้นหาวันที่สมัคร");
//                    $("#Dialog-Confirm").removeClass('hide').dialog({
//                        width: '300px',
//                        resizable: false,
//                        modal: true,
//                        title: "<div class='widget-header'><h4 class='smaller'> แจ้งเตือน</h4></div>",
//                        title_html: true,
//                        autoOpen: true,
//                        buttons: [
//                            {
//                                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ปิด",
//                                "class": "btn btn-xs",
//                                click: function() {
//                                    $(this).dialog("close");
//                                }
//                            }
//                        ]
//                    });
//                }
//            }
//        }
//
//        if ('%' !== $('#slMilitaryDepartmentSearch').val()) {
//            var search6 = {'groupOp': condition, 'field': 'militaryId', 'op': 'eq', 'data': $('#slMilitaryDepartmentSearch').val(), 'dataType': 'integer'};
//            requestSearch.push(search6);
//            condition = 'and';
//            statusSearch = true;
//        }
//
//        if ('%' !== $('#slApplyTypeSearch').val()) {
//            var search7 = {'groupOp': condition, 'field': 'memberTypeCode', 'op': 'eq', 'data': $('#slApplyTypeSearch').val(), 'dataType': 'integer'};
//            requestSearch.push(search7);
//            condition = 'and';
//            statusSearch = true;
//        }
//
//        if ('%' !== $('#slMemberTypeCodeSearch').val()) {
//            var search8 = {'groupOp': condition, 'field': 'memberGroupCode', 'op': 'eq', 'data': $('#slMemberTypeCodeSearch').val(), 'dataType': 'integer'};
//            requestSearch.push(search8);
//            condition = 'and';
//            statusSearch = true;
//        }
//
//        if ('%' !== $('#slMemberStatusCodeSearch').val()) {
//            var search9 = {'groupOp': condition, 'field': 'memberStatusCode', 'op': 'eq', 'data': $('#slMemberStatusCodeSearch').val(), 'dataType': 'integer'};
//             requestSearch.push(search9);
//             condition = 'and';
//             statusSearch = true;
//        }
        search.conditions = requestSearch;
        $(gridName).jqGrid('setGridParam', {
            search: statusSearch,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);
        
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
                onActionLoadNewMilitaryDepartment();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionClearNewMilitaryDepartment = function () {
        $('#militaryDeptId').empty();
    };

    onActionLoadNewMilitaryDepartment = function () {
        onActionClearNewMilitaryDepartment();
        $('#militaryDeptId').append('<option value="">ทั้งหมด</option>');
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#militaryDeptId').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };
    

    init = function () {
        console.log("initialize action.PAY010.js ...");
        $('#paymentDateStart').datepicker({language: 'th', format: 'dd/mm/yyyy'});

        $('#paymentDateEnd').datepicker({language: 'th', format: 'dd/mm/yyyy'});
        
        $('#frmCriterionSearch').submit(function(event) {
            event.preventDefault();
            onActionSearch();
        });

        onActionLoadMilitaryDepartment();
    };

    init();
    
    
    
});