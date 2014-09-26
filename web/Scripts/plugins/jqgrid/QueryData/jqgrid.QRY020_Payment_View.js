/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlPaymentView = urlListQRY020PaymentView;
var gridNamePaymentView = '#gridData_QRY020_Payment_View_Grid_List';
var gridPagerPaymentView = '#gridPager_QRY020_Payment_View_jqGrid_List';
var gridSortNamePaymentView = 'm.month_code';
var gridSortOrderPaymentView = 'desc';
var gridCaptionPaymentView = 'การชำระเงิน';
var gridColNamesPaymentView = ['ลำดับที่', 'งวดเดือน', 'startSopNo', 'startSopNo', 'ศพที่', 'จำนวนเงิน', 'วันที่ชำระ', 'วิธีการชำระ', 'ชำระแล้ว', 'ชำระเกิน', 'ชำระที่หน่วย', 'เลขที่อ้างอิง', 'ผู้บันทึก', 'หมายเหตุ'];
var gridColModelPaymentView = [
    {name: 'id', index: 'id', sortable: false, hidden: true, align: 'left', width: 100},
    {name: 'budgetMonth', index: 'c.budget_month', align: 'left', sortable: true, width: 200,
        formatoptions: {newformat: 'm/Y'},
        formatter: function (cellval, opts, rowObject, action) {
            return $.fn.fmatter.call(
                    this,
                    "date",
                    new Date(cellval),
                    $.extend({}, $.jgrid.formatter.date, opts),
                    rowObject,
                    action);
        }},
    {name: 'startSopNo', index: 'c.start_sop_no', hidden: true, align: 'left', sortable: false, width: 200},
    {name: 'endSopNo', index: 'c.end_sop_no', hidden: true, align: 'left', sortable: false, width: 200},
    {name: 'startSopNo_EndSopNo', index: '', align: 'left', sortable: false, width: 200},
    {name: 'amount', index: 'm.amount', align: 'right', formatter: 'number', formatoptions: {decimalPlaces: 2}, sortable: true, width: 200},
    {name: 'paymentDate', index: 'm.payment_date', align: 'left', sortable: true, width: 200,
        formatoptions: {newformat: 'd/m/Y'},
        formatter: function (cellval, opts, rowObject, action) {
            return $.fn.fmatter.call(
                    this,
                    "date",
                    new Date(cellval),
                    $.extend({}, $.jgrid.formatter.date, opts),
                    rowObject,
                    action);
        }},
    {name: 'paymentTypeCode', index: 'm.payment_type_code', align: 'left', sortable: true, width: 200},
    {name: 'payAmount', index: 'm.pay_amount', align: 'right', formatter: 'number', formatoptions: {decimalPlaces: 2}, sortable: true, width: 200},
    {name: 'overAmount', index: 'm.over_amount', align: 'right', formatter: 'number', formatoptions: {decimalPlaces: 2}, sortable: true, width: 200},
    {name: 'mildeptName', index: 'mildept_name', align: 'left', sortable: false, width: 200},
    {name: 'receiptNo', index: 'r.receipt_no', align: 'left', sortable: true, width: 200},
    {name: 'username', index: 'username', align: 'left', sortable: false, width: 200},
    {name: 'remark', index: 'm.remark', align: 'left', sortable: false, width: 200}];
var gridJsonReaderPaymentView = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "id"           //the unique id of the row
};
var updatePagerIconsPaymentView = function (table) {
    var replacement =
            {
                'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
                'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
                'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
                'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
            };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if ($class in replacement)
            icon.attr('class', 'ui-icon ' + replacement[$class]);
    });
};

//it causes some flicker when reloading or navigating grid
//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
//or go back to default browser checkbox styles for the grid
var styleCheckboxPaymentView = function (table) {
    $(table).find('input:checkbox').addClass('ace')
            .wrap('<label />')
            .after('<span class="lbl align-top" />');

    $("input[id^='cb_']").addClass('ace')
            .wrap('<label />')
            .after('<span class="lbl align-top" />');
    /*
     $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
     .find('input.cbox[type=checkbox]').addClass('ace')
     .wrap('<label />').after('<span class="lbl align-top" />');
     */

};

var enableTooltipsPaymentView = function (table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function () {
    $(gridNamePaymentView).jqGrid({
        url: gridUrlPaymentView,
        datatype: 'json',
        mtype: 'POST',
        //================================ Field Data ========================================
        caption: gridCaptionPaymentView,
        colNames: gridColNamesPaymentView,
        colModel: gridColModelPaymentView,
        jsonReader: gridJsonReaderPaymentView,
        //================================ End Field Data ====================================
        autowidth: false,
        shrinkToFit: false,
        pager: gridPagerPaymentView,
        height: 350,
        width: 1120,
        //width: 'auto',
        rowNum: 10,
        sortname: gridSortNamePaymentView,
        sortorder: gridSortOrderPaymentView,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridNamePaymentView).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function (id, e) {

        },
        ondblClickRow: function (id, rowid, colid, e) {
        },
        beforeSelectRow: function (rowid, e) {
            var radio = $(e.target).closest('tr').find('input[type="radio"]');
            radio.attr('checked', 'checked');
            return true; // allow row selection
        },
        loadComplete: function () {
            var ids = $(gridNamePaymentView).jqGrid('getDataIDs');
            var paymentTypeCodeTxt = '';
            var startSopNoCal = '';
            var endSopNoCal = '';

            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                //var buttonView = '<button type="button" type="button" class="btn btn-xs btn-info" alt="View" onclick="onDialogViewMemberBeneficiary(\'' + id + '\');"><i class="ace-icon fa fa-search bigger-120"></i> </button>';           
                //$(gridNamePaymentView).setRowData(ids[i], {action: buttonView});
                paymentTypeCodeTxt = '';
                startSopNoCal = '';
                endSopNoCal = '';
                startSopNoCal = $(gridNamePaymentView).jqGrid('getCell', ids[i], 'startSopNo');
                endSopNoCal = $(gridNamePaymentView).jqGrid('getCell', ids[i], 'endSopNo');
                paymentTypeCodeTxt = onPaymentTypeCode(parseInt($(gridNamePaymentView).jqGrid('getCell', ids[i], 'paymentTypeCode')));
                $(gridNamePaymentView).setRowData(ids[i], {
                    paymentTypeCode: paymentTypeCodeTxt,
                    startSopNo_EndSopNo: startSopNoCal + '-' + endSopNoCal
                });
            }
            enableTooltipsPaymentView(this);
            //styleCheckbox(this);
            updatePagerIconsPaymentView(this);
        }
    });
    $(gridNamePaymentView).jqGrid('navGrid', gridPagerPaymentView, {edit: false, add: false, del: false, search: false, refresh: false},
    {}, // edit options  
            {}, // add options  
            {}, //del options  
            {
                closeOnEscape: true,
                multipleSearch: true,
                closeAfterSearch: true
            }
    );
});

