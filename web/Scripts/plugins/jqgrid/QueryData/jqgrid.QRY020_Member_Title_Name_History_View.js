/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlMemberTitleNameHistoryView = urlListQRY020MemberTitleNameHistoryView;
var gridNameMemberTitleNameHistoryView = '#gridData_QRY020_Member_Title_Name_History_View_Grid_List';
var gridPagerMemberTitleNameHistoryView = '#gridPager_QRY020_Member_Title_Name_History_View_jqGrid_List';
var gridSortNameMemberTitleNameHistoryView = 'm.created_date';
var gridSortOrderMemberTitleNameHistoryView = 'desc';
var gridCaptionMemberTitleNameHistoryView = 'สถานะภาพสมาชิก';
var gridColNamesMemberTitleNameHistoryView = ['ลำดับที่', 'วันที่', 'ยศ - คำนำหน้า', 'ชื่อ', 'สกุล', 'ยศ - คำนำหน้า - ชื่อ -สกุลที่เปลี่ยนแปลง', 'สถานะ', 'ประเภทการเปลี่ยน', 'ผู้บันทึก'];
var gridColModelMemberTitleNameHistoryView = [
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
    {name: 'titleRank', index: 'title_rank', hidden: true, align: 'left', sortable: true, width: 300},
    {name: 'name', index: 'm.name', hidden: true, align: 'left', sortable: true, width: 200},
    {name: 'surname', index: 'm.surname', hidden: true, align: 'left', sortable: true, width: 200},
    {name: 'textName', index: '', align: 'left', sortable: false, width: 200},
    {name: 'approved', index: 'm.approved', align: 'left', sortable: false, width: 200},
    {name: 'fileTypeCode', index: 'm.file_type_code', align: 'left', sortable: false, width: 200},
    {name: 'username', index: 'username', align: 'left', sortable: false, width: 200}];
var gridJsonReaderMemberTitleNameHistoryView = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "id"           //the unique id of the row
};
var updatePagerIconsMemberTitleNameHistoryView = function (table) {
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
var styleCheckboxMemberTitleNameHistoryView = function (table) {
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

var enableTooltipsMemberTitleNameHistoryView = function (table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function () {
    $(gridNameMemberTitleNameHistoryView).jqGrid({
        url: gridUrlMemberTitleNameHistoryView,
        datatype: 'json',
        mtype: 'POST',
        //================================ Field Data ========================================
        caption: gridCaptionMemberTitleNameHistoryView,
        colNames: gridColNamesMemberTitleNameHistoryView,
        colModel: gridColModelMemberTitleNameHistoryView,
        jsonReader: gridJsonReaderMemberTitleNameHistoryView,
        //================================ End Field Data ====================================
        autowidth: false,
        shrinkToFit: false,
        pager: gridPagerMemberTitleNameHistoryView,
        height: 350,
        width: 1120,
        //width: 'auto',
        rowNum: 10,
        sortname: gridSortNameMemberTitleNameHistoryView,
        sortorder: gridSortOrderMemberTitleNameHistoryView,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridNameMemberTitleNameHistoryView).jqGrid("getGridParam", "colModel");
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
            var ids = $(gridNameMemberTitleNameHistoryView).jqGrid('getDataIDs');
            var operationTypeCodeTxt = '';
            var textName = '';
            var textApproved = '';
            var textFileTypeCode = '';

            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                textName = '';
                textApproved = '';
                textFileTypeCode = '';
                textName = $(gridNameMemberTitleNameHistoryView).jqGrid('getCell', ids[i], 'titleRank');
                textName += ' ' + $(gridNameMemberTitleNameHistoryView).jqGrid('getCell', ids[i], 'name');
                textName += ' ' + $(gridNameMemberTitleNameHistoryView).jqGrid('getCell', ids[i], 'surname');
                textApproved = onApproved(parseInt($(gridNameMemberTitleNameHistoryView).jqGrid('getCell', ids[i], 'approved')));
                textFileTypeCode = onChangeCode(parseInt($(gridNameMemberTitleNameHistoryView).jqGrid('getCell', ids[i], 'fileTypeCode')));
                $(gridNameMemberTitleNameHistoryView).setRowData(ids[i], {
                    textName: textName,
                    approved: textApproved,
                    fileTypeCode: textFileTypeCode
                });
            }
            enableTooltipsMemberTitleNameHistoryView(this);
            //styleCheckbox(this);
            updatePagerIconsMemberTitleNameHistoryView(this);
        }
    });
    $(gridNameMemberTitleNameHistoryView).jqGrid('navGrid', gridPagerMemberTitleNameHistoryView, {edit: false, add: false, del: false, search: false, refresh: false},
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

