/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlPAY021_1 = urlPAY021_1List;
var gridNamePAY021_1 = '#gridData_PAY021_1_Grid_List';
var gridPagerPAY021_1 = '#gridPager_PAY021_1_Grid_List';
var gridSortNamePAY021_1 = 'm.name, m.surname';
var gridSortOrderPAY021_1 = 'asc';
var gridCaptionPAY021_1 = 'ข้อมูลสมาชิก';
var gridColNamesPAY021_1 = ['ลำดับ', 'เลขประจำตัวประชาชน', 'ยศ-คำนำหน้า', 'ชื่อ','สกุล','หมายเหตุ'];
var gridColModelPAY021_1 = [
    {name: 'memberId',      index: 'memberId', hidden: true, align: 'left'},
    {name: 'citizenId',     index: 'citizenId',         align: 'left', sortable: false, width: 200},
    {name: 'rankAndTitleName',index: 'rankAndTitleName',  align: 'left', sortable: false, width: 200},
    {name: 'name',          index: 'name',              align: 'left', sortable: false, width: 200},
    {name: 'surname',       index: 'surname',           align: 'left', sortable: false, width: 200},
    {name: 'remark',        index: 'remark',            align: 'left', sortable: false, width: 300,  search: false}];
var gridJsonReaderPAY021_1 = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "memberId"           //the unique id of the row
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
    var search = {};
    var requestSearch = new Array();
    var search1 = {'groupOp': '', 'field': 'm.apply_date', 'op': 'bw', 'data': $('#registerDate').val() +","+ $('#registerDate').val(), 'dataType': 'date' };
    requestSearch.push(search1);
    var search2 = {'groupOp': 'and', 'field': 'm.military_id', 'op': 'eq', 'data': $('#militaryId').val(), 'dataType': 'integer'};
    requestSearch.push(search2);
    search.conditions = requestSearch;
//    $(gridNamePAY021_1).jqGrid('setGridParam', {
//        search: true,
//        postData: {
//            searchCommand: $.toJSON(search)
//        }
//    });
        
    $(gridNamePAY021_1).jqGrid({
        url: gridUrlPAY021_1,
        datatype: 'json',
        mtype: 'POST',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaptionPAY021_1,
        colNames: gridColNamesPAY021_1,
        colModel: gridColModelPAY021_1,
        jsonReader: gridJsonReaderPAY021_1,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPagerPAY021_1,
        height: 350,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortNamePAY021_1,
        sortorder: gridSortOrderPAY021_1,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        search: true,
        postData: {
            searchCommand: $.toJSON(search)
        },
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridNamePAY021_1).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, event) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        loadComplete: function() {
            
            var ids = $(gridNamePAY021_1).jqGrid('getDataIDs');
            $("#memberIdList").val("");
            for (var i = 0; i < ids.length; i++) {
                var memberId = $(gridNamePAY021_1).jqGrid('getCell', ids[i], 'memberId');
                $("#memberIdList").val($("#memberIdList").val() + memberId + ",");
            }
            
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridNamePAY021_1).jqGrid('navGrid', gridPagerPAY021_1, {edit: false, add: false, del: false, search: false, refresh: false},
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

