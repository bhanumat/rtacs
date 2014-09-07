$(function() {

    $("#btnRegisterNo").click(function(event) {
        var arrInput = document.getElementsByTagName("input");
        var RegisterNo = document.getElementById("txtRegisterMemberCode").value;
        for (var i = 0; i < arrInput.length; i++) {
            if (arrInput[i].type === "text") {
                if (arrInput[i].id.indexOf("txtMemberCode_") !== -1) {
                    arrInput[i].value = RegisterNo;
                    RegisterNo = parseInt(RegisterNo) + 1;
                }
            }
        }
    });

    onActionSaveNew = function(thisDialog, objData) {
        var data = {};
        data.DataSource = $.toJSON(objData);
        console.info(data);
        $.ajax({
            type: 'POST',
            url: urlSaveNew,
            data: data,
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
    };

    $("#btnSave").click(function(event) {
        event.preventDefault();
        var ids = [];
        var arrInput = document.getElementsByTagName("input");
        var numOfTextbox = 0;
        var numOfTextboxwithValue = 0;
        for (var i = 0; i < arrInput.length; i++) {
            if (arrInput[i].id.indexOf("txtMemberCode_") !== -1) {
                if (arrInput[i].type === "text") {
                    numOfTextbox++
                }
                if (arrInput[i].value.length > 0) {
                    numOfTextboxwithValue++;
                }
            }
        }

        if (numOfTextbox === numOfTextboxwithValue) {
            $("#Dialog-Confirm").html("คุณต้องการบันทึกข้อมูลนี้ใช่หรือไม่?");
            $("#Dialog-Confirm").dialog({
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-floppy-o bigger-110'></i>&nbsp; บันทึก",
                        "class": "btn btn-danger btn-xs",
                        click: function() {
                            for (var item in listAPP040) {
                                var itemData = listAPP040[item];
                                ids.push(itemData.memberId);
                            }

                            var objData = {};
                            objData.ItemSelect = ids.toString();

                            //objData.DocDate = $('#txtDocDate').val();
                            //objData.DocCode = $('#txtDocCode').val();
                            objData.memberCode = $('#txtMemberCode_' + ids.toString()).val();
                            onActionSaveNew(this, objData);
                        }
                    },
                    {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                        "class": "btn btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    }
                ]
            });
            $("#Dialog-Confirm").dialog("open");
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกสมาชิกใหม่");
            $("#Dialog-Warning").dialog("open");
        }
    });


    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        if ($('#txtMildeptId').val().length !== 0) {
            var search1 = {'groupOp': '', 'field': 'mildeptId', 'op': 'cn', 'data': $('#txtMildeptId').val(), 'dataType': 'integer'};
            requestSearch.push(search1);
            var search2 = {'groupOp': 'and', 'field': 'name', 'op': 'cn', 'data': $('#txtName').val(), 'dataType': 'varchar'};
            requestSearch.push(search2);
        } else {
            var search1 = {'groupOp': '', 'field': 'name', 'op': 'cn', 'data': $('#txtName').val(), 'dataType': 'varchar'};
            requestSearch.push(search1);
        }
        var search3 = {'groupOp': 'and', 'field': 'status', 'op': 'cn', 'data': $('#slStatus').val(), 'dataType': 'char'};
        requestSearch.push(search3);
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

    onActionLoadMemberOperation = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlList,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listAPP040 = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };


////////////////////////////////////////////////////////////

    onInit = function() {
        onActionLoadMemberOperation();

    };


    onInit();
});