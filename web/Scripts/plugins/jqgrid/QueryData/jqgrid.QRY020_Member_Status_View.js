/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlMemberStatusView = urlListQRY020MemberStatusView;
var gridNameMemberStatusView = '#gridData_QRY020_Member_Status_View_Grid_List';
var gridPagerMemberStatusView = '#gridPager_QRY020_Member_Status_View_jqGrid_List';
var gridSortNameMemberStatusView = 'o.create_date';
var gridSortOrderMemberStatusView = 'desc';
var gridCaptionMemberStatusView = 'สถานะภาพสมาชิก';
var gridColNamesMemberStatusView = ['ลำดับที่', 'วันที่บันทึก', 'สถานภาพสมาชิก', 'ผู้บันทึก'];
var gridColModelMemberStatusView = [
    {name: 'id', index: 'id', sortable: false, hidden: true, align: 'left', width: 100},
    {name: 'createDate', index: 'o.create_date', align: 'left', sortable: true, width: 200,
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
    {name: 'operationTypeCode', index: 'o.operation_type_code', align: 'left', sortable: false, width: 200},
    {name: 'name', index: 'u.name', align: 'left', sortable: false, width: 200}];
var gridJsonReaderMemberStatusView = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "id"           //the unique id of the row
};
var updatePagerIconsMemberStatusView = function (table) {
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
var styleCheckboxMemberStatusView = function (table) {
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

var enableTooltipsMemberStatusView = function (table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function () {
    $(gridNameMemberStatusView).jqGrid({
        url: gridUrlMemberStatusView,
        datatype: 'json',
        mtype: 'POST',
        //================================ Field Data ========================================
        caption: gridCaptionMemberStatusView,
        colNames: gridColNamesMemberStatusView,
        colModel: gridColModelMemberStatusView,
        jsonReader: gridJsonReaderMemberStatusView,
        //================================ End Field Data ====================================
        autowidth: false,
        shrinkToFit: false,
        pager: gridPagerMemberStatusView,
        height: 350,
        width: 1120,
        //width: 'auto',
        rowNum: 10,
        sortname: gridSortNameMemberStatusView,
        sortorder: gridSortOrderMemberStatusView,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridNameMemberStatusView).jqGrid("getGridParam", "colModel");
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
            var ids = $(gridNameMemberStatusView).jqGrid('getDataIDs');
            var operationTypeCodeTxt = '';

            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                operationTypeCodeTxt = '';
                operationTypeCodeTxt = onMemberStatusCode(parseInt($(gridNameMemberStatusView).jqGrid('getCell', ids[i], 'operationTypeCode')));
                $(gridNameMemberStatusView).setRowData(ids[i], {
                    operationTypeCode: operationTypeCodeTxt
                });
            }
            enableTooltipsMemberStatusView(this);
            //styleCheckbox(this);
            updatePagerIconsMemberStatusView(this);
        }
    });
    $(gridNameMemberStatusView).jqGrid('navGrid', gridPagerMemberStatusView, {edit: false, add: false, del: false, search: false, refresh: false},
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

