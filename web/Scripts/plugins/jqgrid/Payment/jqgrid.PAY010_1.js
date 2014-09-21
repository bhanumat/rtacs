var gridUrl = urlListMember;
var gridName = '#gridData_MemberPaymentGrid_List';
var gridPager = '#gridPager_MemberPaymentGrid_List';
var gridSortName = 'memberId';
var gridSortOrder = 'asc';
var gridCaption = 'ข้อมูลสมาชิก';
var gridColNames = ['', 'หน่วยต้นสังกัด', 'เลขทะเบียนสมาชิก', 'เลขประจำตัวประชาชน', 'ยศ - คำนำหน้า', 'ชื่อ', 'สกุล', 'สถานะ'];
var gridColModel = [
    {name: 'memberId', index: 'memberId', align: 'center', sortable: false, width: 40,
        formatter: function (cellVal, opts, rowObject, action) {
            return '<input type="radio" name="selectMember" id="member_' + cellVal + '" value="' + cellVal + '"/>';
        }
    },
    {name: 'militaryName', index: 'militaryName', sortable: false, width: 150},
    {name: 'memberCode', index: 'memberCode', align: 'center', sortable: false, width: 100},
    {name: 'citizenId', index: 'citizenId', align: 'center', sortable: false, width: 150},
    {name: 'rankOrTitleName', index: 'rankOrTitleName', sortable: false, width: 120},
    {name: 'name', index: 'name', sortable: false, width: 100},
    {name: 'surname', index: 'surname', sortable: false, width: 100},
    {name: 'memberStatusCode', index: 'memberStatusCode', sortable: false, width: 145}
];

var gridJsonReader = {
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

var enableTooltips = function(table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
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

$(document).ready(function() {
    $(gridName).jqGrid({
        url: gridUrl,
        datatype: 'json',
        mtype: 'POST',
        caption: gridCaption,
        colNames: gridColNames,
        colModel: gridColModel,
        jsonReader: gridJsonReader,
        autowidth: true,
        shrinkToFit: false,
        pager: gridPager,
        height: 'auto',
        width: 'auto',
        rowNum: 10,
        sortname: gridSortName,
        sortorder: gridSortOrder,
        viewrecords: true,
        multiselect: false,
        rownumbers: false,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridName).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function (id, event) {

        },
        ondblClickRow: function (id, rowid, colid, e) {
        },
        loadComplete: function () {

            var ids = $(gridName).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var buttonStatus = '';
                var buttonDelete = '<button type="button" class="btn btn-xs btn-danger" alt="Delete" onclick="onDialogDelete(\'' + id + '\');"><i class="ace-icon fa fa-trash-o bigger-120"></i> </button>';
                $(gridName).setRowData(id, {action: buttonDelete, printedStatus: buttonStatus});
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
