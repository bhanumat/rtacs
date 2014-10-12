var gridPaymentUrl = urlPayments;
var gridPaymentName = '#gridData_PaymentGrid_List';
var gridPaymentPagerName = '#gridPager_PaymentGrid_List';
var gridPaymentSortName = '';
var gridPaymentSortOrder = 'asc';
var gridPaymentCaption = 'ข้อมูลสมาชิก';
var gridPaymentColNames = ['เลขทะเบียนสมาชิก', 'เลขประจำตัวประชาชน', 'ยศ-คำนำหน้า', 'ชื่อ', 'สกุล', 'ยอดชำระ', 'สถานะ', 'รายละเอียด', 'หน่วยต้นสังกัด', 'หมายเหตุ'];
var gridPaymentColModel = [
    {name: '', index: '', sortable: true, width: 100},
    {name: '', index: '', sortable: true, width: 100},
    {name: '', index: '', sortable: true, width: 100},
    {name: '', index: '', sortable: true, width: 100},
    {name: '', index: '', sortable: true, width: 100},
    {name: '', index: '', align: 'right', sortable: true, width: 90, 
        formatter: 'currency', 
        formatoptions: {prefix: '฿', suffix: '', thousandsSeparator: ','}
    },
    {name: '', index: '', sortable: true, width: 100},
    {name: '', index: '', sortable: true, width: 100},
    {name: '', index: '', sortable: true, width: 100},
    {name: '', index: '', sortable: true, width: 100}
];
var gridPaymentJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "paymentId"           //the unique id of the row
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

$(document).ready(function() {alert("aaa");
    $(gridPaymentName).jqGrid({
        url: '',
        datatype: 'json',
        mtype: 'POST',
        caption: gridPaymentCaption,
        colNames: gridPaymentColNames,
        colModel: gridPaymentColModel,
        jsonReader: gridPaymentJsonReader,
        autowidth: true,
        shrinkToFit: false,
        pager: gridPaymentPagerName,
        height: 'auto',
        width: 'auto',
        rowNum: 10,
        sortname: gridPaymentSortName,
        sortorder: gridPaymentSortOrder,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {},
        onSelectRow: function (id, event) {},
        loadComplete: function () {alert("bbb");
            enableTooltips(this);
            updatePagerIcons(this);
        }
    });
    $(gridPaymentName).jqGrid('navGrid', gridPaymentPagerName, {edit: false, add: false, del: false, search: false, refresh: false});
});
