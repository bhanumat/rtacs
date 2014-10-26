var gridPaymentUrl = urlListDeptMemberPayment;
var gridPaymentName = '#gridData_PaymentGrid_List';
var gridPaymentPagerName = '#gridPager_PaymentGrid_List';
var gridPaymentSortName = 'memberCode';
var gridPaymentSortOrder = 'asc';
var gridPaymentCaption = 'ข้อมูลสมาชิก';
var gridPaymentColNames = ['เลขทะเบียนสมาชิก', 'เลขประจำตัวประชาชน', 'ยศ-คำนำหน้า', 'ชื่อ', 'สกุล', 'ยอดชำระ', 'สถานะ', 'รายละเอียด', 'หน่วยต้นสังกัด', 'หมายเหตุ'];
var gridPaymentColModel = [
    {name: 'memberCode', index: 'memberCode', sortable: true, width: 120},
    {name: 'citizenId', index: 'citizenId', sortable: true, width: 150},
    {name: 'title', index: 'title', sortable: true, width: 90},
    {name: 'name', index: 'name', sortable: true, width: 100},
    {name: 'surname', index: 'surname', sortable: true, width: 100},
    {name: 'paymentAmount', index: 'paymentAmount', align: 'right', sortable: true, width: 90, 
        formatter: 'currency', 
        formatoptions: {prefix: '฿', suffix: '', thousandsSeparator: ','}
    },
    {name: 'typeCode', index: 'typeCode', sortable: true, width: 100, 
        formatter: function (cellVal, opts, rowObject, action) {
            if (10 === cellVal) {
                return 'ย้ายเข้า';
            } else if (20 === cellVal) {
                return 'ย้ายออก';
            } else {
                return '';
            }
        }
    },
    {name: 'description', index: 'description', sortable: true, width: 100},
    {name: 'typeCode', index: 'typeCode', sortable: true, width: 100, 
        formatter: function (cellVal, opts, rowObject, action) {
            if (10 === cellVal) {
                return rowObject.mildeptNameIn === null ? '' : rowObject.mildeptNameIn;
            } else if (20 === cellVal) {
                return rowObject.mildeptNameOut === null ? '' : rowObject.mildeptNameOut;
            } else {
                return '';
            }
        }
    },
    {name: 'remark', index: 'remark', sortable: true, width: 200}
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

$(document).ready(function() {
    console.log('Initialize PYC101_1 Grid ..');
    var search = {};
    var requestSearch = new Array();
    requestSearch.push({'groupOp': '', 'field': 'deptpaymentId', 'op': 'eq', 'data': $('#deptpaymentId').val(), 'dataType': 'integer'});
    search.conditions = requestSearch;
            
    $(gridPaymentName).jqGrid({
        url: gridPaymentUrl,
        postData : {
            searchCommand: $.toJSON(search)
        },
        search: true,
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
        loadComplete: function () {
            enableTooltips(this);
            updatePagerIcons(this);
        }
    });
    $(gridPaymentName).jqGrid('navGrid', gridPaymentPagerName, {edit: false, add: false, del: false, search: false, refresh: false});
});