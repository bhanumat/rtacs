
var gridUrl = urlListPay010;
var gridName = '#gridData_MemberPaymentGrid_List';
var gridPager = '#gridPager_PaymentPaymentGrid_List';
var gridSortName = 'paymentId';
var gridSortOrder = 'asc';
var gridCaption = 'รายชื่อสมาชิก';
var gridColNames = ['ลำดับที่', 'วันที่ขำระเงิน', 'เลขที่ใบเสร็จ', 'หน่วยต้นสังกัด', 'เลขทะเบียนสมาชิก', 'เลขประจำตัวประชาชน', 'ยศ-คำนำหน้า', 'ชื่อ', 'นามสกุล', 'จำนวนเงิน', 'สถานะ', ''];
var gridColModel = [
    {name: 'paymentId', index: 'paymentId', hidden: true, align: 'left'},
    {name: 'docDate', index: 'docDate', align: 'center', sortable: true, width: 100,
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
    {name: 'docCode', index: 'docCode', align: 'center', sortable: false, width: 100},
    {name: 'militaryName', index: 'militaryName', align: 'left', sortable: false, width: 150},
    {name: 'memberCode', index: 'memberCode', align: 'center', sortable: false, width: 100},
    {name: 'citizenID', index: 'citizenID', align: 'center', sortable: false, width: 150},
    {name: 'title', index: 'title', align: 'right', sortable: false, width: 100},
    {name: 'name', index: 'name', align: 'left', sortable: false, width: 150},
    {name: 'surname', index: 'surname', align: 'left', sortable: false, width: 150},
    {name: 'amount', index: 'amount', align: 'right', sortable: false, width: 100},
    {name: 'printedStatus', index: 'printedStatus', align: 'left', sortable: false, width: 150},
    {name: 'action', index: 'action', align: 'center', sortable: false, width: 60, search: false}];

var gridJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "paymentId"           //the unique id of the row
};
var updatePagerIcons = function (table) {
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

$(document).ready(function () {
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
        height: 350,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortName,
        sortorder: gridSortOrder,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
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
                var paymentId = $(gridName).jqGrid('getCell', ids[i], 'paymentId');
                var buttonStatus = '';
                var buttonDelete = '<button type="button" class="btn btn-xs btn-danger" alt="Delete" onclick="onDialogDelete(\'' + id + '\');"><i class="ace-icon fa fa-trash-o bigger-120"></i> </button>';
                if ('Y' === $(gridName).jqGrid('getCell', ids[i], 'printedStatus')) {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> พิมพ์ใบเสร็จแล้ว </button>';
                } else if ('N' === $(gridName).jqGrid('getCell', ids[i], 'printedStatus')) {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> ยังไม่พิมพ์ใบเสร็จ </button>';
                } else if ('C' === $(gridName).jqGrid('getCell', ids[i], 'printedStatus')) {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-danger"> <i class="ace-icon fa fa-ban bigger-120"></i> ยกเลิกใบเสร็จ </button>';
                    $(gridName).jqGrid('setCell', ids[i], 'checked', '', '', {style: "visibility: hidden"});

                }
                $(gridName).setRowData(ids[i], {action: buttonDelete, printedStatus: buttonStatus});
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