$(function() {
    $('#paymentDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#paymentDate").datepicker("setDate", new Date());
});