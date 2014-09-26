/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlPAY021 = urlPAY021List;
var gridNamePAY021 = '#gridData_PAY021_Grid_List';
var gridPagerPAY021 = '#gridPager_PAY021_Grid_List';
var gridSortNamePAY021 = 'militaryName';
var gridSortOrderPAY021 = 'asc';
var gridCaptionPAY021 = 'รายชื่อสมาชิก';
var gridColNamesPAY021 = ['ลำดับ', 'วันที่รับสมัคร', 'รหัสหน่วย', 'หน่วยต้นสังกัด','จำนวนผู้สมัคร','ค่าสมัครสมาชิกรวม', ''];
var gridColModelPAY021 = [
    {name: 'militaryId', index: 'militaryId', hidden: true, align: 'left'},
    {name: 'docDate',   index: 'docDate',  align: 'center', sortable: false, width: 100,
        formatoptions: {newformat: 'd/m/Y'},
        formatter: function(cellval, opts, rowObject, action) {
            return $.fn.fmatter.call(
                    this,
                    "date",
                    new Date(cellval),
                    $.extend({}, $.jgrid.formatter.date, opts),
                    rowObject,
                    action);
        }},
    {name: 'militaryCode',  index: 'militaryCode',  align: 'center', sortable: false, width: 100},
    {name: 'militaryName',  index: 'militaryName',  align: 'left', sortable: false, width: 150},
    {name: 'sumMember',     index: 'sumMember',     align: 'right',  sortable: false, width: 100},
    {name: 'sumAmount',     index: 'sumAmount',     align: 'right',  sortable: false, width: 150},
    {name: 'action',        index: 'action',        align: 'center', sortable: false,width: 100,  search: false}];
var gridJsonReaderPAY021 = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "militaryId"           //the unique id of the row
};
var updatePagerIcons = function(table) {
    var replacement =
            {
                'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
                'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
                'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
                'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
            };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function() {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if ($class in replacement)
            icon.attr('class', 'ui-icon ' + replacement[$class]);
    });
};

//it causes some flicker when reloading or navigating grid
//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
//or go back to default browser checkbox styles for the grid
var styleCheckbox = function(table) {
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


var enableTooltips = function(table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function() {
    $(gridNamePAY021).jqGrid({
        url: gridUrlPAY021,
        datatype: 'json',
        mtype: 'POST',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaptionPAY021,
        colNames: gridColNamesPAY021,
        colModel: gridColModelPAY021,
        jsonReader: gridJsonReaderPAY021,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPagerPAY021,
        height: 350,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortNamePAY021,
        sortorder: gridSortOrderPAY021,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridNamePAY021).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, event) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        loadComplete: function() {
            
            var ids = $(gridNamePAY021).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var militaryId = $(gridNamePAY021).jqGrid('getCell', ids[i], 'militaryId');
                var militaryName = $(gridNamePAY021).jqGrid('getCell', ids[i], 'militaryName');
                var docDate = $(gridNamePAY021).jqGrid('getCell', ids[i], 'docDate');
                var sumMember = $(gridNamePAY021).jqGrid('getCell', ids[i], 'sumMember');
                var sumAmount = $(gridNamePAY021).jqGrid('getCell', ids[i], 'sumAmount');
                var buttonView = '<button type="button" class="btn btn-xs btn-search" alt=View" onclick="onDialogView(\'' + militaryId + '\',\'' + militaryName + '\',\'' + docDate + '\',\'' + sumMember + '\',\'' + sumAmount + '\');"><i class="ace-icon fa fa-search bigger-120"></i> </button>';
                $(gridNamePAY021).setRowData(ids[i], {action: buttonView});
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridNamePAY021).jqGrid('navGrid', gridPagerPAY021, {edit: false, add: false, del: false, search: false, refresh: false},
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

