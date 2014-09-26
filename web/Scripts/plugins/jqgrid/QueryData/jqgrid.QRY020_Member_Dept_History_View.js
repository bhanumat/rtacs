/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlMemberDeptHistoryView = urlListQRY020MemberDeptHistoryView;
var gridNameMemberDeptHistoryView = '#gridData_QRY020_Member_Dept_History_View_Grid_List';
var gridPagerMemberDeptHistoryView = '#gridPager_QRY020_Member_Dept_History_View_jqGrid_List';
var gridSortNameMemberDeptHistoryView = 'd.created_date';
var gridSortOrderMemberDeptHistoryView = 'desc';
var gridCaptionMemberDeptHistoryView = 'ประวัติโอนย้าย';
var gridColNamesMemberDeptHistoryView = ['ลำดับที่', 'วันที่', 'ย้ายจาก', 'หน่วย', 'ไปที่', 'หน่วย', 'สถานะ', 'ผู้บันทึก', 'ยกเลิก'];
var gridColModelMemberDeptHistoryView = [
    {name: 'id', index: 'id', sortable: false, hidden: true, align: 'left', width: 100},
    {name: 'createdDate', index: 'd.created_date', align: 'left', sortable: true, width: 200,
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
    {name: 'frMildeptId', index: 'fr_mildept_id', align: 'left', sortable: false, width: 200},
    {name: 'frMildeptName', index: 'fr_mildept_name', align: 'left', sortable: false, width: 200},
    {name: 'mildeptId', index: 'mildept_id', align: 'left', sortable: false, width: 200},
    {name: 'mildeptName', index: 'mildept_name', align: 'left', sortable: false, width: 200},
    {name: 'approved', index: 'a.approved', align: 'left', sortable: false, width: 200},
    {name: 'username', index: 'username', align: 'left', sortable: true, width: 200},
    {name: 'cancel', index: 'd.cancel', align: 'left', sortable: true, width: 200}];
var gridJsonReaderMemberDeptHistoryView = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "id"           //the unique id of the row
};
var updatePagerIconsMemberDeptHistoryView = function (table) {
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
var styleCheckboxMemberDeptHistoryView = function (table) {
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

var enableTooltipsMemberDeptHistoryView = function (table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function () {
    $(gridNameMemberDeptHistoryView).jqGrid({
        url: gridUrlMemberDeptHistoryView,
        datatype: 'json',
        mtype: 'POST',
        //================================ Field Data ========================================
        caption: gridCaptionMemberDeptHistoryView,
        colNames: gridColNamesMemberDeptHistoryView,
        colModel: gridColModelMemberDeptHistoryView,
        jsonReader: gridJsonReaderMemberDeptHistoryView,
        //================================ End Field Data ====================================
        autowidth: false,
        shrinkToFit: false,
        pager: gridPagerMemberDeptHistoryView,
        height: 350,
        width: 1120,
        //width: 'auto',
        rowNum: 10,
        sortname: gridSortNameMemberDeptHistoryView,
        sortorder: gridSortOrderMemberDeptHistoryView,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridNameMemberDeptHistoryView).jqGrid("getGridParam", "colModel");
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
            var ids = $(gridNameMemberDeptHistoryView).jqGrid('getDataIDs');
            var approvedTxt = '';

            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                approvedTxt = '';
                approvedTxt = onApproved(parseInt($(gridNameMemberDeptHistoryView).jqGrid('getCell', ids[i], 'approved')));
                $(gridNameMemberDeptHistoryView).setRowData(ids[i], {
                    approved: approvedTxt
                });
            }
            enableTooltipsMemberDeptHistoryView(this);
            //styleCheckbox(this);
            updatePagerIconsMemberDeptHistoryView(this);
        }
    });
    $(gridNameMemberDeptHistoryView).jqGrid('navGrid', gridPagerMemberDeptHistoryView, {edit: false, add: false, del: false, search: false, refresh: false},
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

