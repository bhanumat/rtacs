$(function() {
    
    onClickSearchAdvance = function() {
        var search = {};
        var statusSearch = false; //0 is not in condition, 1 is in condition
        var requestSearch = new Array();
        var condition = '';
        
        var memberCode = $('#memberCode').val();
        if (memberCode) {
            requestSearch.push({'groupOp': condition, 'field': 'memberCode', 'op': 'eq', 'data': memberCode, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }
        
        var idCard = $('#idCard').val();
        if (idCard) {
            requestSearch.push({'groupOp': condition, 'field': 'citizenId', 'op': 'eq', 'data': idCard, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }
        
        var name = $('#name').val();
        if (name) {
            requestSearch.push({'groupOp': condition, 'field': 'name', 'op': 'eq', 'data': name, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }
        
        var surname = $('#surname').val();
        if (surname) {
            requestSearch.push({'groupOp': condition, 'field': 'surname', 'op': 'eq', 'data': surname, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }
        
        var militaryDeptId = $('#militaryDeptId').val();
        if (militaryDeptId) {
            requestSearch.push({'groupOp': condition, 'field': 'militaryId', 'op': 'eq', 'data': militaryDeptId, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }
        
        var status = $('#status').val();
        if (status) {
            requestSearch.push({'groupOp': condition, 'field': 'memberStatusCode', 'op': 'eq', 'data': status, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }

        search.conditions = requestSearch;
        $(gridName).jqGrid('setGridParam', {
            search: statusSearch,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);
    };
    
    onLoadMilitaryDepartment = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonMilitaryDepartment,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (listMilitaryDepartment) {
                $('#militaryDeptId').empty();
                $('#militaryDeptId').append('<option value="">ทั้งหมด</option>');
                for (var item in listMilitaryDepartment) {
                    var itemData = listMilitaryDepartment[item];
                    $('#militaryDeptId').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onClickSearch = function(memberId) {
        if(memberId !== null) {
            // get memberId from search advance
            var objData = {};
            objData["memberId"] = memberId;
            var req = {};
            req.data2Json = $.toJSON(objData);

            searchMember(req);
        } else {
            // click quick search between Citizenid or Membercode
            var txtSearch = $("#txtSearch").val();
            if (txtSearch) {
                var field;
                if ($("#searchTypeCitizenid").prop("checked", true)) {
                    field = "citizenId";
                }
                if ($("#searchTypeMemberCode").prop("checked", true)) {
                    field = "memberCode";
                }

                if (field !== "undefined") {
                    var objData = {};
                    objData[field] = txtSearch;
                    var req = {};
                    req.data2Json = $.toJSON(objData);

                    searchMember(req);
                }
            } else {
                $("#Dialog-Confirm").html("กรุณากรอกข้อมูลการค้นหา");
                $("#Dialog-Confirm").removeClass('hide').dialog({
                    width: '300px',
                    resizable: false,
                    modal: true,
                    title: "<div class='widget-header'><h4 class='smaller'> แจ้งเตือน</h4></div>",
                    title_html: true,
                    autoOpen: true,
                    buttons: [{
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ปิด",
                        "class": "btn btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    }]
                });
            }
        }
    };

    searchMember = function(req) {
        $.ajax({
            type: 'POST',
            url: urlMember,
            data: req,
            dataType: 'json',
            async: false,
            success: function(object) {
                if (object.memberId === 0) {
                    $("#Dialog-Confirm").html("ไม่พบข้อมูล");
                    $("#Dialog-Confirm").removeClass('hide').dialog({
                        width: '300px',
                        resizable: false,
                        modal: true,
                        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-trash'></i> สถานะ</h4></div>",
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
                } else {
                    $("#lblMemberCode").text(object.memberCode);
                    $("#lblCitizenId").text(object.citizenId);
                    $("#lblName").text(object.rankOrTitleName + object.name + "  " + object.surname);
                    $("#lblMilitaryName").text(object.militaryName);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };

    $("#btnSearch").click(function(event) {
        event.preventDefault();
        onClickSearch(null);
    });

    $("#btnSearchAdvance").click(function(event) {
        event.preventDefault();
        onClickSearchAdvance(null);
    });

    $("#btnSearchAdvanceSelect").click(function(event) {
        event.preventDefault();
        onClickSearch($("input:radio[name=selectMember]:checked").val());
    });
  
    $("#btnClearAdvance").click(function(event) {
        event.preventDefault();
        $('#paymentDate').val("");
    });

    init = function() {
        $('#paymentDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
        $("#paymentDate").datepicker("setDate", new Date());
        onLoadMilitaryDepartment();
    };

    init();
});