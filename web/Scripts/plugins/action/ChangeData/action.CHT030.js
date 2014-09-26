$(function() {
    $('#tab6_changeDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    //--------------------------------load dropdown list
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
        $('#tab6_titleId').empty();
    };
    
    onActionLoadNewTitle = function() {
        onActionClearNewTitle();
        $('#tab6_titleId').append('<option value="">--เลือก--</option>');
        for (var item in listTitle) {
            var itemData = listTitle[item];
            $('#tab6_titleId').append('<option value="' + itemData.titleId + '">' + itemData.titleDesc + '</option>');
        }
    };
    
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
        $('#tab6_rankId').empty();
    };
    
    onActionLoadNewRank = function() {
        onActionClearNewRank();
        $('#tab6_rankId').append('<option value="">--เลือก--</option>');
        for (var item in listRank) {
            var itemData = listRank[item];
            $('#tab6_rankId').append('<option value="' + itemData.rankId + '">' + itemData.rankName + '</option>');
        }
    };
    //--------------------------------
    onActionSearch = function(objData) {
        $.ajax({
            type: 'POST',
            url: urlCHT030Search,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                if (msg.checkSuccess === true && msg.obj != null) {
                    var object = msg.obj;
                    //tab1
                    $("#tab1_memberCode").text(object.memberCode); 
                    $("#tab1_registerDate").text(object.approvedDate); 
                    $("#tab1_citizenId").text(object.citizenId); 
                    $("#tab1_beginSop").text(object.beginSop);
                    $("#tab1_preName").text(object.titleRank);
                    $("#tab1_sex").text(object.gender);
                    $("#tab1_name").text(object.name); 
                    $("#tab1_surname").text(object.surname);
                    $("#tab1_birthDate").text(object.birthDate);
                    $("#tab1_age").text(object.age);
                    //$("#tab1_age").text(object.officerTypeCode);
                    $("#tab1_memberType").text(object.memberTypeCode);
                    $("#tab1_paymentType").text(object.paymentTypeCode);
                    //$("#tab1_military").text(object.mildeptId); 
                    $("#tab1_military").text(object.mildeptName);
                    $("#tab1_referenceCode").text(object.referenceCode); 
                    $("#tab1_referenceName").text(object.referenceName);
                    $("#tab1_wifehusband").text(object.referenceRelationshipCode);
                    $("#tab1_marryName").text(object.wifehusbandFullname);
                    $("#tab1_remark").text(object.remark);
                    $("#tab1_memberStatus").text(object.memberStatusCode);
                    //tab2
                    $("#tab2_permanentAddress").text(object.permanentAddress); 
                    $("#tab2_permanentMoo").text(object.permanentMoo);
                    $("#tab2_permanentRoad").text(object.permanentRoad);
                    $("#tab2_permanentSoi").text(object.permanentSoi);
                    $("#tab2_permanentSubdistrict").text(object.permanentSubDistrict);
                    $("#tab2_permanentDistrict").text(object.permanentDistrict);
                    $("#tab2_permanentProvince").text(object.permanentProvinceName);
                    $("#tab2_permanentZipCode").text(object.permanentZipcode);
                    $("#tab2_permanentTel").text(object.permanentTel);
                    $("#tab2_permanentMobile").text(object.permanentMobile);
                    $("#tab2_permanentFax").text(object.permanentFax);
                    $("#tab2_address").text(object.address);
                    $("#tab2_moo").text(object.moo);
                    $("#tab2_road").text(object.road);
                    $("#tab2_soi").text(object.soi);
                    $("#tab2_subdistrict").text(object.subdistrict);
                    $("#tab2_district").text(object.district);
                    $("#tab2_province").text(object.provinceName);
                    $("#tab2_zipCode").text(object.zipcode);
                    $("#tab2_tel").text(object.mobile);
                    $("#tab2_mobile").text(object.tel);
                    $("#tab2_fax").text(object.fax);
                    
                } else {
                    $.fn.DialogMessage(msg);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };
    
    $("#btnShow").click(function(event) {
        event.preventDefault();
        var searchCode = {};
        var dataSource = $('#idRadio').val();
        alert("dataSource : " + dataSource);
        /**/
        if (dataSource === '1') {
            if($('#searchId').val().length === 13){
                searchCode[0] = $('#searchId').val();
            }else{
                alert("กรุณากรอกเลขประจำตัวประชาชนให้ครบ 13 หลัก");
                return;
            }
        }else{
            searchCode[0] = $('#searchId').val();
        }
        var objData = {};
        objData.itemSelect = searchCode;
        objData.dataSource = dataSource;
        onActionSearch(objData);
        /**/
    });
    
    radioAction = function(value){
        $('#idRadio').val(value);
        //alert("value : " + value);
    };
    
    rankChecked = function(){
        if(document.getElementById("tab6_rank_checkbox").checked){
            document.getElementById("tab6_rankId").disabled = false;
        }else{
            document.getElementById("tab6_rankId").disabled = true;
            $('#tab6_rankId').val("");
        }
    };
    
    titleChecked = function(){
        if(document.getElementById("tab6_title_checkbox").checked){
            document.getElementById("tab6_titleId").disabled = false;
        }else{
            document.getElementById("tab6_titleId").disabled = true;
            $('#tab6_titleId').val("");
        }
    };
    
    nameChecked = function(){
        if(document.getElementById("tab6_name_checkbox").checked){
            document.getElementById("tab6_name").disabled = false;
        }else{
            document.getElementById("tab6_name").disabled = true;
            $('#tab6_name').val("");
        }
    };
    
    surnameChecked = function(){
        if(document.getElementById("tab6_surname_checkbox").checked){
            document.getElementById("tab6_surname").disabled = false;
        }else{
            document.getElementById("tab6_surname").disabled = true;
            $('#tab6_surname').val("");
        }
    };
    
    onInit = function() {
        onActionLoadTitle();
        onActionLoadNewTitle();
        onActionLoadRank();
        onActionLoadNewRank();
    };

    onInit();
});