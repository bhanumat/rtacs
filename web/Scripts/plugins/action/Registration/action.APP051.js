$(function() {
//    var tabMainName = '#tabMainMember';
//    $(tabMainName).tabs();
//    $('.ui-tabs-panel').removeClass();
//    $(tabMainName).tabs("option", "active", 0);
//    

    

    $("#btnPrint").click(function(event) {
        var selRowIds = $(gridName).jqGrid('getGridParam', 'selarrrow');
        var objId = {};
        //var myGrid = $('#gridData_ExjqGrid_List');
        //var $selRadio = $('input[name=jqg_gridData_ExjqGrid_List_' + myGrid[0].id + ']:radio:checked'), $tr;
        if (selRowIds.length > 0) {   //alert(selRowIds[0].toString());         
            //onDialogNew(event);   
            $("#Dialog-Warning").html("กำลังดำเนินการ....");
            $("#Dialog-Warning").dialog("open");
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    });

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
        $('#slMilitaryIdSearch').empty();
        $('#slMilitaryIdSearch').append('<option value="%">ทั้งหมด</option>');
    };

    onActionLoadSearchMilitaryDepartment = function() {
        onActionClearNewMilitaryDepartment();
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#slMilitaryIdSearch').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };

    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        var search1 = {'groupOp': '', 'field': 'memberCode', 'op': 'cn', 'data': $('#txtNumberMember').val(), 'dataType': 'varchar'};
        requestSearch.push(search1);
        var search2 = {'groupOp': 'and', 'field': 'citizenId', 'op': 'cn', 'data': $('#txtCardID').val(), 'dataType': 'varchar'};
        requestSearch.push(search2);
        var search3 = {'groupOp': 'and', 'field': 'name', 'op': 'cn', 'data': $('#txtFirstName').val(), 'dataType': 'varchar'};
        requestSearch.push(search3);
        var search4 = {'groupOp': 'and', 'field': 'surname', 'op': 'cn', 'data': $('#txtLastName').val(), 'dataType': 'varchar'};
        requestSearch.push(search4);
        if ('%' !== $('#slMilitaryIdSearch').val()) {
            var search5 = {'groupOp': 'and', 'field': 'militaryId', 'op': 'cn', 'data': $('#slMilitaryIdSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search5);
        }
        if ('%' !== $('#slTypeApplySearch').val()) {
            var search6 = {'groupOp': 'and', 'field': 'paymentTypeCode', 'op': 'cn', 'data': $('#slTypeApplySearch').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }

        var search7 = {'groupOp': 'and', 'field': 'memberStatusCode', 'op': 'eq', 'data': 105, 'dataType': 'integer'};
        requestSearch.push(search7);

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

    $('#txtStartDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#txtEndDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});

    $("#slTypeApplySearch").select2({
        allowClear: true
    });

    $("#slMilitaryIdSearch").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });

    onDialogNew = function(e) {
        e.preventDefault();
        $("#dialogFormNew").dialog("open");
    };

    onInit = function() {
        onActionLoadMilitaryDepartment();

        onActionLoadSearchMilitaryDepartment();
    };

    onInit();
});