
$(function() {

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
                onActionLoadNewMilitaryDepartment();
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
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

    init = function() {

        $('#paymentDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
        $("#paymentDate").datepicker("setDate", new Date());

        onActionLoadMilitaryDepartment();
    };

    init();
});