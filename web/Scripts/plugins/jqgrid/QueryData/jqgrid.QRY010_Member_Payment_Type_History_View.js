/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlMemberPaymentTypeHistoryView = urlListQRY010MemberPaymentTypeHistoryView;
var gridNameMemberPaymentTypeHistoryView = '#gridData_QRY010_Member_Payment_Type_History_View_Grid_List';
var gridPagerMemberPaymentTypeHistoryView = '#gridPager_QRY010_Member_Payment_Type_History_View_jqGrid_List';
var gridSortNameMemberPaymentTypeHistoryView = 'm.created_date';
var gridSortOrderMemberPaymentTypeHistoryView = 'desc';
var gridCaptionMemberPaymentTypeHistoryView = 'ประวัติการเปลี่ยนแระเภทการชำระเงิน';
var gridColNamesMemberPaymentTypeHistoryView = ['ลำดับที่', 'วันที่', 'ประเภทการชำระเงิน', 'สถานะ', 'ประเภทการเปลี่ยน', 'ผู้บันทึก'];
var gridColModelMemberPaymentTypeHistoryView = [
    {name: 'id', index: 'id', sortable: false, hidden: true, align: 'left', width: 100},
    {name: 'createdDate', index: 'm.created_date', align: 'left', sortable: true, width: 200,
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
    {name: 'approved', index: 'm.approved', align: 'left', sortable: false, width: 200},
    {name: 'changeCode', index: 'm.change_code', align: 'left', sortable: true, width: 200},
    {name: 'name', index: 'o.name', align: 'left', sortable: false, width: 200}];
var gridJsonReaderMemberPaymentTypeHistoryView = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "id"           //the unique id of the row
};
var updatePagerIconsMemberPaymentTypeHistoryView = function (table) {
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
var styleCheckboxMemberPaymentTypeHistoryView = function (table) {
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

var enableTooltipsMemberPaymentTypeHistoryView = function (table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function () {
    $(gridNameMemberPaymentTypeHistoryView).jqGrid({
        url: gridUrlMemberPaymentTypeHistoryView,
        datatype: 'json',
        mtype: 'POST',
        //================================ Field Data ========================================
        caption: gridCaptionMemberPaymentTypeHistoryView,
        colNames: gridColNamesMemberPaymentTypeHistoryView,
        colModel: gridColModelMemberPaymentTypeHistoryView,
        jsonReader: gridJsonReaderMemberPaymentTypeHistoryView,
        //================================ End Field Data ====================================
        autowidth: false,
        shrinkToFit: false,
        pager: gridPagerMemberPaymentTypeHistoryView,
        height: 350,
        width: 1120,
        //width: 'auto',
        rowNum: 10,
        sortname: gridSortNameMemberPaymentTypeHistoryView,
        sortorder: gridSortOrderMemberPaymentTypeHistoryView,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridNameMemberPaymentTypeHistoryView).jqGrid("getGridParam", "colModel");
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
            var ids = $(gridNameMemberPaymentTypeHistoryView).jqGrid('getDataIDs');
            var paymentTypeCodeTxt = '';
            var approvedTxt = '';
            var changeCodeTxt = '';

            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                //var buttonView = '<button type="button" type="button" class="btn btn-xs btn-info" alt="View" onclick="onDialogViewMemberBeneficiary(\'' + id + '\');"><i class="ace-icon fa fa-search bigger-120"></i> </button>';           
                //$(gridNameMemberPaymentTypeHistoryView).setRowData(ids[i], {action: buttonView});
                approvedTxt = '';
                changeCodeTxt = '';
                paymentTypeCodeTxt = '';
                
                changeCodeTxt = onChangeCode(parseInt($(gridNameMemberPaymentTypeHistoryView).jqGrid('getCell', ids[i], 'changeCode')));
                approvedTxt = onApproved(parseInt($(gridNameMemberPaymentTypeHistoryView).jqGrid('getCell', ids[i], 'approved')));
                paymentTypeCodeTxt = onPaymentTypeCode(parseInt($(gridNameMemberPaymentTypeHistoryView).jqGrid('getCell', ids[i], 'paymentTypeCode')));
                $(gridNameMemberPaymentTypeHistoryView).setRowData(ids[i], {
                    paymentTypeCode: paymentTypeCodeTxt,
                    approved: approvedTxt,
                    changeCode: changeCodeTxt
                });
            }
            enableTooltipsMemberPaymentTypeHistoryView(this);
            //styleCheckbox(this);
            updatePagerIconsMemberPaymentTypeHistoryView(this);
        }
    });
    $(gridNameMemberPaymentTypeHistoryView).jqGrid('navGrid', gridPagerMemberPaymentTypeHistoryView, {edit: false, add: false, del: false, search: false, refresh: false},
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

