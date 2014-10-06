
var gridUrl = urlListMemberPayment;
var gridName = '#gridData_MemberPaymentGrid_List';
var gridPager = '#gridPager_MemberPaymentGrid_List';
var gridSortName = 'paymentId';
var gridSortOrder = 'asc';
var gridCaption = 'รายชื่อสมาชิก';
var gridColNames = ['ลำดับที่', 'วันที่ขำระเงิน', 'เลขที่ใบเสร็จ', 'หน่วยต้นสังกัด', 'เลขทะเบียนสมาชิก', 'เลขประจำตัวประชาชน', 'ยศ-คำนำหน้า', 'ชื่อ', 'นามสกุล', 'จำนวนเงิน', 'สถานะ', ''];
var gridColModel = [
    {name: 'paymentId', index: 'paymentId', hidden: true, align: 'left'},
    {name: 'paymentDate', index: 'paymentDate', align: 'center', sortable: true, width: 86,
        formatoptions: {newformat: 'd/m/Y'},
        formatter: function (cellVal, opts, rowObject, action) {
            if (!cellVal) {
                return '';
            } else {
                return $.fn.fmatter.call(
                        this,
                        "date",
                        new Date(cellVal),
                        $.extend({}, $.jgrid.formatter.date, opts),
                        rowObject,
                        action);
            }
        }},
    {name: 'receiptNo', index: 'receiptNo', align: 'center', sortable: true, width: 100},
    {name: 'militaryName', index: 'militaryName', align: 'left', sortable: true, width: 150},
    {name: 'memberCode', index: 'memberCode', align: 'center', sortable: true, width: 116},
    {name: 'citizenId', index: 'citizenId', align: 'center', sortable: true, width: 140},
    {name: 'title', index: 'title', align: 'right', sortable: true, width: 80},
    {name: 'name', index: 'name', align: 'left', sortable: true, width: 150},
    {name: 'surname', index: 'surname', align: 'left', sortable: true, width: 150},
    {name: 'amount', index: 'amount', align: 'right', sortable: true, width: 100,
        formatter: 'currency',
        formatoptions: {prefix: '฿', suffix: '', thousandsSeparator: ','}
    },
    {name: 'paymentStatus', index: 'paymentStatus', align: 'center', sortable: true, width: 145,
        formatter: function (cellVal, opts, rowObject, action) {
            var strToReturn;
            switch (cellVal) {
                case 'Y':
                    strToReturn = '<span class="label label-xlg label-success arrowed arrowed-right">พิมพ์ใบเสร็จแล้ว</span>';
                    break;
                case 'N':
                    strToReturn = '<span class="label label-xlg label-yellow arrowed arrowed-right">ยังไม่พิมพ์ใบเสร็จ</span>';
                    break;
                case 'C':
                    strToReturn = '<span class="label label-xlg label-danger arrowed arrowed-right">ยกเลิกใบเสร็จ</span>';
                default:
                    strToReturn = '';
            }
            return strToReturn;
        }
    },
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

var enableTooltips = function (table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
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
        height: 'auto',
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
                var buttonDelete = '<button type="button" class="btn btn-xs btn-danger" title="Delete" onclick="onDialogDelete(\'' + id + '\');"><i class="ace-icon fa fa-trash-o bigger-120"></i> </button>';
                $(gridName).setRowData(ids[i], {action: buttonDelete});
            }
            enableTooltips(this);
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