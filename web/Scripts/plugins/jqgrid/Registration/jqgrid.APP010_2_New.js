/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridName = '#gridData_APP010_2_New_Grid_List';
var gridPager = '#gridPager_APP010_2_New_jqGrid_List';
var gridSortName = 'beneficiary_id';
var gridSortOrder = 'asc';
var gridCaption = 'รายการผู้สมัครเป็นสมาชิก';
var gridColNames = ['ลำดับที่', 'เลขประจำตัวประชาชน', 'ยศ', 'คำนำหน้า', 'ชื่อ', 'สกุล', 'ความเกี่ยวพันกับสมาชิก', ''];
var gridColModel = [
    {name: 'id', index: 'id', sortable: false, hidden: true, align: 'left', width: 100},
    {name: 'citizenId', index: 'm.citizen_id', align: 'left', sortable: true, width: 200},
    {name: 'rankName', index: 'r.rank_name', align: 'left', sortable: true, width: 100},
    {name: 'titleName', index: 't.title_name', align: 'left', sortable: true, width: 100},
    {name: 'name', index: 'm.name', align: 'left', sortable: true, width: 200},
    {name: 'surname', index: 'm.surname', align: 'left', sortable: true, width: 200},
    {name: 'memberRelationship', index: 'memberRelationship', align: 'left', sortable: false, width: 200},
    {name: 'action', index: 'action', width: 80, align: 'center', search: false, sortable: false}];
var gridJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "id"           //the unique id of the row
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
    $(gridName).jqGrid({
        datastr: myStringListAPP010,
        datatype: 'jsonstring',
        mtype: 'POST',
        //================================ Field Data ========================================
        caption: gridCaption,
        colNames: gridColNames,
        colModel: gridColModel,
        jsonReader: gridJsonReader,
        //================================ End Field Data ====================================
        autowidth: false,
        shrinkToFit: false,
        pager: gridPager,
        height: 350,
        width: 1120,
        //width: 'auto',
        rowNum: 10,
        sortname: gridSortName,
        sortorder: gridSortOrder,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridName).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, e) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        beforeSelectRow: function(rowid, e) {
            var radio = $(e.target).closest('tr').find('input[type="radio"]');
            radio.attr('checked', 'checked');
            return true; // allow row selection
        },
        loadComplete: function() {
            var ids = $(gridName).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var buttonEdit = '<button type="button" type="button" class="btn btn-xs btn-info" alt="Edit" onclick="onDialogEditMemberBeneficiaryNewForEdit(\'' + id + '\');"><i class="ace-icon fa fa-pencil bigger-120"></i> </button>';
                var buttonDelete = '<button type="button" type="button" class="btn btn-xs btn-danger" alt="Delete" onclick="onDialogDeleteMemberBeneficiaryNew(\'' + id + '\');"><i class="ace-icon fa fa-trash-o bigger-120"></i> </button>';
                $(gridName).setRowData(ids[i], {action: buttonEdit + '&nbsp;' + buttonDelete});
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridName).jqGrid('navGrid', gridPager, {edit: false, add: false, del: false, search: false, refresh: false},
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

