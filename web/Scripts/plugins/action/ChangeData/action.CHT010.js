$(function() {
    var responseId = '#main-page-content-loading';
    var memberIdList = {};
    var titleameHistoryIdList = {};
    var titleIdList = {};
    var rankIdList = {};
    var nameList = {};
    var surnameList = {};
    var approvedDateList = {};
    var approvedList = {};
    $('#date_begin').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#date_end').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#date_register').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    var controlButton = function(element) {
        $('ul li').each(function(i)
        {
            $(this).removeClass();
            $(this).addClass('hover');
            //$(this).attr('rel'); // This is your rel value
        });
        $('#'+element).addClass('active open');
    };
    
    $("#dialogFormConfirm").removeClass('hide').dialog({
        width: '600px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> ยืนยันการเปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล</h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; ยืนยัน",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    var ids = $(gridName_CHT010).jqGrid('getDataIDs');
                    var index = 0;
                    
                    for (var i = 0; i < ids.length; i++) {
                        var c = $(gridName_CHT010).jqGrid('getCell', ids[i], 'checked');
                        if(c === "True"){
                            memberIdList[index] = $(gridName_CHT010).jqGrid('getCell', ids[i], 'memberId');
                            titleameHistoryIdList[index] = $(gridName_CHT010).jqGrid('getCell', ids[i], 'titleameHistoryId');
                            titleIdList[index] = $(gridName_CHT010).jqGrid('getCell', ids[i], 'titleId');
                            rankIdList[index] = $(gridName_CHT010).jqGrid('getCell', ids[i], 'rankId');
                            nameList[index] = $(gridName_CHT010).jqGrid('getCell', ids[i], 'nameHidden');
                            surnameList[index] = $(gridName_CHT010).jqGrid('getCell', ids[i], 'surnameHidden');
                            approvedDateList[index] = $("#date_register").val();
                            approvedList[index] = $("#confirmType").val();

                            index = index+1;
                        }
                    }
                    $(this).dialog("close");
                    onDialogConfirm();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                "class": "btn btn-xs",
                click: function() {
                    $(this).dialog("close");
                    clearPopupData();
                }
            }
        ]
    });
    
    onDialogConfirm = function() {
        if ($('#date_register').val().length !== 0 && $('#confirmType').val().length !== 0 ) {
            $("#Dialog-Confirm").html("คุณต้องการยืนยันการเปลี่ยนแปลงข้อมูลนี้ใช่หรือไม่?");
            $("#Dialog-Confirm").removeClass('hide').dialog({
                width: '500px',
                resizable: false,
                modal: true,
                title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-trash'></i> ยืนยันการเปลี่ยนแปลงข้อมูล </h4></div>",
                title_html: true,
                autoOpen: true,
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; ยืนยัน",
                        "class": "btn btn-primary btn-xs",
                        click: function() {
                            var objData = {};
                            objData.memberId = memberIdList;
                            objData.titleameHistoryId = titleameHistoryIdList;
                            objData.titleId = titleIdList;
                            objData.rankId = rankIdList;
                            objData.name = nameList;
                            objData.surname = surnameList;
                            objData.approvedDate = approvedDateList;
                            objData.approved = approvedList;
                            
                            onActionConfirm(this, objData);
                            clearPopupData();
                        }
                    }
                    ,
                    {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                        "class": "btn btn-xs",
                        click: function() {
                            $(this).dialog("close");
                            clearPopupData();
                        }
                    }
                ]
            });
        }else{
            $("#Dialog-Confirm").html("กรุณากรอกข้อมูลให้ครบถ้วน");
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
    };
    
    onActionConfirm = function(thisDialog, objData) {
        $.ajax({
            type: 'POST',
            url: urlConfirm_CHT010,
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
        clearPopupData();
    };
    
    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        if ($('#date_begin').val().length !== 0 && $('#date_end').val().length !== 0) {
            var search1 = {'groupOp': 'and', 'field': 'docDate', 'op': 'bw', 'data': $('#date_begin').val() +","+ $('#date_end').val(), 'dataType': 'date' };
            requestSearch.push(search1);
        }else{
            if ($('#date_begin').val().length !== 0) {
                var search1 = {'groupOp': 'and', 'field': 'docDate', 'op': 'bw', 'data': $('#date_begin').val(), 'dataType': 'date' };
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
        
        if ($('#citizenId').val().length !== 0) {
           if($('#citizenId').val().length === 13){
                var search3 = {'groupOp': 'and', 'field': 'citizenId', 'op': 'eq', 'data': $('#citizenId').val(), 'dataType': 'varchar'};
                requestSearch.push(search3);
            }else{
                alert("กรุณากรอกเลขประจำตัวประชาชนให้ครบ 13 หลัก");
            }
        }
        if ($('#memberCode').val().length !== 0) {
            var search4 = {'groupOp': 'and', 'field': 'memberCode', 'op': 'eq', 'data': $('#memberCode').val(), 'dataType': 'varchar'};
            requestSearch.push(search4);
        }
        if ($('#name').val().length !== 0) {
            var search5 = {'groupOp': 'and', 'field': 'name', 'op': 'eq', 'data': $('#name').val(), 'dataType': 'varchar'};
            requestSearch.push(search5);
        }
        if ($('#surname').val().length !== 0) {
            var search6 = {'groupOp': 'and', 'field': 'surname', 'op': 'eq', 'data': $('#surname').val(), 'dataType': 'varchar'};
            requestSearch.push(search6);
        }
        if ($('#military').val().length !== 0) {
            var search7 = {'groupOp': 'and', 'field': 'militaryId', 'op': 'eq', 'data': $('#military').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
        }
        if ($('#memberTypeCode').val().length !== 0) {
            var search8 = {'groupOp': 'and', 'field': 'memberTypeCode', 'op': 'eq', 'data': $('#memberTypeCode').val(), 'dataType': 'integer'};
            requestSearch.push(search8);
        }
        if ($('#fileTypeCode').val().length !== 0) {
            var search9 = {'groupOp': 'and', 'field': 'fileTypeCode', 'op': 'eq', 'data': $('#fileTypeCode').val(), 'dataType': 'integer'};
            requestSearch.push(search9);
        }
        if ($('#approved').val().length !== 0) {
            var search10 = {'groupOp': 'and', 'field': 'approved', 'op': 'eq', 'data': $('#approved').val(), 'dataType': 'integer'};
            requestSearch.push(search10);
        }
        
        search.conditions = requestSearch;
       
        $(gridName_CHT010).jqGrid('setGridParam', {
            search: true,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridName_CHT010).trigger("reloadGrid", [{page: 1}]);
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
    
    onDialogConfirmForm = function(e) {
        e.preventDefault();
        var index = 0;
        var ids = $(gridName_CHT010).jqGrid('getDataIDs');
        for (var i = 0; i < ids.length; i++) {
            var c = $(gridName_CHT010).jqGrid('getCell', ids[i], 'checked');
            if(c === "True"){
                index = index+1;
            }
        }
        if(index>0){
            //requestDataList = requestList;
            $("#dialogFormConfirm").dialog("open");
        }
        else{
            $("#Dialog-Confirm").html("กรุณาเลือกอย่างน้อย 1 รายการ");
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
                            clearPopupData();
                        }
                    }
                ]
            });
        }
    };
    
    clearPopupData = function() {
        $('#confirmType').val('');
        $('#date_register').val('');
    };
    
    $("#btnSearch").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });

    $("#btnConfirm").click(function(event) {
        event.preventDefault();
        onDialogConfirmForm(event);
    });
    
    $("#btnAdd").click(function(e) {
        
        controlButton('menuChangeData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/ChangeData/CHT030.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
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