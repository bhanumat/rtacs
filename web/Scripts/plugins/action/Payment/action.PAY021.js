$(function() {
    var responseId = '#main-page-content-loading';
    
    $('#date_begin').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#date_end').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    var controlButton = function(element) {
        $('ul li').each(function(i)
        {
            $(this).removeClass();
            $(this).addClass('hover');
            //$(this).attr('rel'); // This is your rel value
        });
        $('#'+element).addClass('active open');
    };
    
    onDialogView = function(militaryId,militaryName,militaryDate,militaryMember,militarySumAmount) {
        //alert("id : >>" + id + "<<");
        $('#militaryId').val(militaryId);
        $('#militaryName').val(militaryName);
        $('#militaryDate').val(militaryDate);
        $('#militaryMember').val(militaryMember);
        $('#militarySumAmount').val(militarySumAmount);
        var typeAction = 'POST';
        var urlAction = rootPath + '/Plugins/Payment/TOPAY021_1.htm';
        var objDataAction = {militaryId:$('#militaryId').val(),militaryName:$('#militaryName').val(),militaryDate:$('#militaryDate').val(),militaryMember:$('#militaryMember').val(),militarySumAmount:$('#militarySumAmount').val()};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        //e.preventDefault();
    };
    
    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        if ($('#date_begin').val().length !== 0 && $('#date_end').val().length !== 0) {
            var search1 = {'groupOp': '', 'field': 'docDate', 'op': 'bw', 'data': $('#date_begin').val() +","+ $('#date_end').val(), 'dataType': 'date' };
            requestSearch.push(search1);
        }else{
            if ($('#date_begin').val().length !== 0) {
                var search1 = {'groupOp': '', 'field': 'docDate', 'op': 'bw', 'data': $('#date_begin').val(), 'dataType': 'date' };
                requestSearch.push(search1);
            }else{
                if ($('#date_end').val().length !== 0) {
                        $("#Dialog-Confirm").html("กรุณากรอกข้อมูลค้นหาวันที่ชำระเงิน");
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
                }
            }
        }
        
        if ($('#military').val().length !== 0) {
            var search2 = {'groupOp': '', 'field': 'militaryId', 'op': 'eq', 'data': $('#military').val(), 'dataType': 'integer'};
            requestSearch.push(search2);
        }
        
        search.conditions = requestSearch;
       
        $(gridNamePAY021).jqGrid('setGridParam', {
            search: true,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridNamePAY021).trigger("reloadGrid", [{page: 1}]);
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
        $('#military').empty();
    };
    
    onActionLoadNewMilitaryDepartment = function() {
        onActionClearNewMilitaryDepartment();
        $('#military').append('<option value="">ทั้งหมด</option>');
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#military').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };
    
    $("#btnSearch").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });

    
    
    $("#btnReset").click(function(e) {
        //window.location.reload();
    });
    
    onInit = function() {
        onActionLoadMilitaryDepartment();
        onActionLoadNewMilitaryDepartment();

    };

    onInit();
});