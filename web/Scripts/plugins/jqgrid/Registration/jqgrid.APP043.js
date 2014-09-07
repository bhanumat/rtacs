/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrl = urlList;
var gridName = '#gridData_ExjqGrid_List';
var gridPager = '#gridPager_ExjqGrid_List';
var gridSortName = 'memberCode';
var gridSortOrder = 'asc';
var gridCaption = 'ข้อมูลยืนยันการอนุมัติขึ้นทะเบียนสมาชิกใหม่';
var gridColNames = ['', '', 'เลขทะเบียนสมาชิก', 'หน่วยต้นสังกัด', 'เลขประจำตัวประชาชน', 'ยส - คำนำหน้า', 'ชื่อ', 'สกุล', 'วันที่ขอขึ้นทะเบียน', 'วันที่สมัคร', 'ประเภทการสมัคร', 'เลขที่อ้างอิงอนุมัติ'];
var gridColModel = [
    {name: 'operationId', index: 'operationId', hidden: true, align: 'center'},
    {name: 'memberId', index: 'memberId', hidden: true, align: 'center'},
    {name: 'memberCode', index: 'memberCode', align: 'left', sortable: true, width: 120},
    {name: 'militaryName', index: 'militaryName', align: 'left', sortable: true, width: 110},
    {name: 'citizenId', index: 'citizenId', align: 'center', sortable: false, width: 150},
    {name: 'rankName', index: 'rankName', align: 'center', sortable: false, width: 100},
    {name: 'name', index: 'name', align: 'center', sortable: false, width: 140},
    {name: 'surname', index: 'surname', align: 'center', sortable: false, width: 150},
    {name: 'docDate', index: 'docDate', align: 'center', sortable: false, width: 130},
    {name: 'applyDate', index: 'applyDate', align: 'center', sortable: false, width: 100},
    {name: 'memberTypeCode', index: 'memberTypeCode', align: 'center', sortable: false, width: 140},
    {name: 'docCode', index: 'docCode', align: 'center', sortable: false, width: 120}];
var gridJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "operationMemberId"           //the unique id of the row
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
        url: gridUrl,
        datatype: 'json',
        mtype: 'POST',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaption,
        colNames: gridColNames,
        colModel: gridColModel,
        jsonReader: gridJsonReader,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPager,
        height: 350,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortName,
        sortorder: gridSortOrder,
        viewrecords: true,
        multiselect: true,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridName).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, event) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        loadComplete: function() {
            var ids = $(gridName).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var buttonStatus = '';
                var memberTypeCode = '';
                
                if ('10' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครด้วยตัวเอง';
                } else if ('20' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านหน่วยต้นสังกัด';
                } else if ('30' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านชุดรับสมัคร';
                } else if ('40' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านกรณีพิเศษ';
                } else {
                    memberTypeCode = 'สมัครผ่านกรณีอื่นๆ';
                }
                
                var buttonEdit = '<button type="button" class="btn btn-xs btn-info" alt="Edit" onclick="onDialogEdit(\'' + id + '\');"><i class="ace-icon fa fa-pencil bigger-120"></i> </button>';
                var buttonDelete = '<button type="button" class="btn btn-xs btn-danger" alt="Delete" onclick="onDialogDelete(\'' + id + '\');"><i class="ace-icon fa fa-trash-o bigger-120"></i> </button>';
                if ('E' === $(gridName).jqGrid('getCell', ids[i], 'status')) {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> ใช้งาน </button>';
                } else {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-danger"> <i class="ace-icon fa fa-ban bigger-120"></i> ไม่ใช้งาน </button>';
                }
                $(gridName).setRowData(ids[i], {action: buttonEdit + '&nbsp;' + buttonDelete, status: buttonStatus, memberTypeCode: memberTypeCode});
                //$(gridName).setRowData(ids[i], {action: buttonEdit + '&nbsp;' + buttonDelete, memberStatusCode: buttonStatus, memberGroupCode: memberGroupCode, memberTypeCode: memberTypeCode});
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
    
    //---for Filter Opration Type Code 25---//
    var search = {};
    var requestSearch = new Array();
    var searchFilter = {'groupOp': '', 'field': 'operationTypeCode', 'op': 'eq', 'data': 25, 'dataType': 'integer'};
    requestSearch.push(searchFilter);

    search.conditions = requestSearch;

    $(gridName).jqGrid('setGridParam', {
        search: true,
        postData: {
            /*searchField: "bankName",
             searchOper: "cn",
             searchString: $('#txtBankName').val(),*/

            searchCommand: $.toJSON(search)
        }
    });
    
    $(gridName).trigger("reloadGrid", [{page: 1}]);
    //------//
    
    $("#btnSearch").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });

    $("#btnReload").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });
});

