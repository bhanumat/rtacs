$(function() {
    
    onClickSearchAdvance = function() {
        var search = {};
        var statusSearch = false; //0 is not in condition, 1 is in condition
        var requestSearch = new Array();
        var condition = '';
        
        var memberCode = $('#memberCode').val();
        if (memberCode) {
            requestSearch.push({'groupOp': condition, 'field': 'm.member_code', 'op': 'eq', 'data': memberCode, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }
        
        var idCard = $('#idCard').val();
        if (idCard) {
            if (idCard.length === 13) {
                requestSearch.push({'groupOp': condition, 'field': 'm.citizen_id', 'op': 'eq', 'data': idCard, 'dataType': 'varchar'});
                condition = 'and';
                statusSearch = true;
            } else {
                $.fn.DialogWarning('กรุณากรอกรหัสประชาชนเป็น 13 หลักเท่านั้น');
                return;
            }
        }
        
        var name = $('#name').val();
        if (name) {
            requestSearch.push({'groupOp': condition, 'field': 'm.name', 'op': 'eq', 'data': name, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }
        
        var surname = $('#surname').val();
        if (surname) {
            requestSearch.push({'groupOp': condition, 'field': 'm.surname', 'op': 'eq', 'data': surname, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }
        
        var militaryDeptId = $('#militaryDeptId').val();
        if (militaryDeptId) {
            requestSearch.push({'groupOp': condition, 'field': 'm.military_id', 'op': 'eq', 'data': militaryDeptId, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }
        
        var status = $('#status').val();
        if (status) {
            requestSearch.push({'groupOp': condition, 'field': 'm.member_status_code', 'op': 'eq', 'data': status, 'dataType': 'integer'});
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
                if ($("#searchTypeCitizenid").is(":checked")) {
                    field = "citizenId";
                }
                if ($("#searchTypeMemberCode").is(":checked")) {
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
                        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-search'></i> สถานะ</h4></div>",
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
                    $("#hdnMemberId").val(object.memberId);
                    $("#lblMemberCode").text(object.memberCode);
                    $("#lblCitizenId").text(object.citizenId);
                    $("#lblName").text(object.rankOrTitleName + object.name + "  " + object.surname);
                    $("#lblMilitaryName").text(object.militaryName);
                    $("#lblMilitaryName").text(object.militaryName);
                    $("#paymentTypeCode20").attr("checked", "checked");
                    changePaymentTypeCode(20);
                    loadMemberPaymentGridByMemberId(object.memberId);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };
    
    loadMemberPaymentGridByMemberId = function(memberId) {
        if (memberId) {
            var requestSearch = new Array();
            requestSearch.push({'groupOp': '', 'field': 'memberId', 'op': 'eq', 'data': memberId, 'dataType': 'varchar'});
            var search = {};
            search.conditions = requestSearch;
            
            $(gridPaymentName).jqGrid('setGridParam', {
                search: true,
                postData: {
                    searchCommand: $.toJSON(search)
                },
                url: gridPaymentUrl,
                page:1
            }).trigger("reloadGrid");
        }
    };
    
    changePaymentTypeCode = function(code) {
        if(code === "21") {
            $("#postNo").removeAttr("disabled");
            $("#postNo").focus();
        } else {
            $("#postNo").val("");
            $("#postNo").attr("disabled", "disabled");
        }
    };

    openConfirmDialogUpdate = function () {
        $("#Dialog-Confirm").html("คุณต้องการบันทึกข้อมูลนี้ใช่หรือไม่?");
        $("#Dialog-Confirm").removeClass('hide').dialog({
            width: '300px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> บันทึกข้อมูล</h4></div>",
            title_html: true,
            autoOpen: true,
            buttons: [{
                    html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; บันทึกข้อมูล",
                    "class": "btn btn-primary btn-xs",
                    click: function () {
                        updatePayment();
                    }
                }, {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                    "class": "btn btn-xs",
                    click: function () {
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };
    
    updatePayment = function() {
        var memberId = $("#hdnMemberId").val();
        if(memberId){
            var req = {};
            req.memberId = memberId;
            req.paymentDate = $('#paymentDate').val();//'09/27/2014';
            req.paymentTypeCode = $("input:radio[name=paymentTypeCode]").val();
            req.postNo = $('#postNo').val();
            var payment = new Array();
            $("input:checkbox[name='isPay[]']").each( function () {
                if($(this).is(":checked")) {
                    var paymentId = $(this).val();
                    var remark = $("#remark_" + paymentId).val();
                    payment.push({'paymentId': paymentId, 'remark': remark});
                }
            });
            req.memberPaymentHeadDtos = payment;//[{paymentId:2, remark:'ทดสอบ1'}, {paymentId:3, remark:'ทดสอบ1'}];

            $.ajax({
                type: 'POST',
                url: urlUpdateMemberPayment,
                cache: false,
                //timeout: 1000,
                async: false,
                data: $.toJSON(req),
                dataType: 'json',
                success: function () {
                    $("#Dialog-Confirm").html("บันทึกข้อมูลเรียบร้อยแล้ว");
                    $("#Dialog-Confirm").removeClass('hide').dialog({
                        width: '300px',
                        resizable: false,
                        modal: true,
                        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-ok'></i> สถานะ</h4></div>",
                        title_html: true,
                        autoOpen: true,
                        buttons: [
                            {
                                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ปิด",
                                "class": "btn btn-xs",
                                click: function() {
                                    loadMemberPaymentGridByMemberId(memberId);
                                    $(this).dialog("close");
                                }
                            }
                        ]
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                },
                beforeSend: function (jqXHR) {
                }
            });
        }
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
        onClickSearch($("input:radio[name=selectMember]").val());
    });
  
    $("#btnClearAdvance").click(function(event) {
        event.preventDefault();
        //$('#paymentDate').val("");
    });
  
    $("input:radio[name=paymentTypeCode]").change(function(event) {
        changePaymentTypeCode($(this).val());
    });
    
    $("#btnSubmit").click(function(event) {
        event.preventDefault();
        openConfirmDialogUpdate();
    });

    init = function() {
        $('#paymentDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
        $("#paymentDate").datepicker("setDate", new Date());
        onLoadMilitaryDepartment();
    };

    init();
});