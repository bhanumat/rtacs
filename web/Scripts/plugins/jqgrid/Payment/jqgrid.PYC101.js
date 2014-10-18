var pyc101GridUrl = urlListDeptMemberPayment;
var pyc101GridName = '#gridData_PYC101';
var pyc101GridPagerName = '#gridPager_PYC101';
var pyc101GridSortName = 'paymentDate';
var pyc101GridSortOrder = 'asc';
var pyc101GridCaption = 'รายการการชำระเงินของหน่วย';
var pyc101GridColNames = ['ลำดับที่', 'วันที่ชำระ', 'งวดเดือน', 'หน่วยต้นสังกัด', 'จำนวนสมาชิก', 'จำนวนเงิน', 'เพิ่ม', 'ลด', 'วันที่บันทึก', 'ผู้บันทึก', ''];
var pyc101GridColModel = [
    {name: 'deptpaymentId', index: 'deptpaymentId', hidden: true, sortable: true, width: 120},
    {name: 'paymentDate', index: 'paymentDate', align: 'center', sortable: true, width: 120,
        formatoptions: {newformat: 'd M Y'},
        formatter: function (cellVal, opts, rowObject, action) {
            if (!cellVal) {
                return '';
            } else {
                return $.fn.fmatter.call(
                        this,
                        "date",
                        moment(new Date(cellVal)).add(543, 'years').toDate(),
                        $.extend({}, $.jgrid.formatter.date, opts),
                        rowObject,
                        action);
            }
        }},
    {name: 'budgetMonth', index: 'budgetMonth', align: 'center', sortable: true, width: 120,
        formatoptions: {newformat: 'M Y'},
        formatter: function (cellVal, opts, rowObject, action) {
            if (!cellVal) {
                return '';
            } else {
                return $.fn.fmatter.call(
                        this,
                        "date",
                        moment(new Date(cellVal)).add(543, 'years').toDate(),
                        $.extend({}, $.jgrid.formatter.date, opts),
                        rowObject,
                        action);
            }
        }},
    {name: 'mildeptName', index: 'mildeptName', sortable: true, width: 200},
    {name: 'numMember', index: 'numMember', align: 'right', sortable: true, width: 100,
        formatter: 'number',
        formatoptions: {thousandsSeparator: ',', decimalPlaces: 0}},
    {name: 'totalAmount', index: 'totalAmount', align: 'right', sortable: true, width: 150,
        formatter: 'currency',
        formatoptions: {prefix: '฿', suffix: '', thousandsSeparator: ','}},
    {name: 'numMemberIn', index: 'numMemberIn', align: 'right', sortable: true, width: 100,
        formatter: 'number',
        formatoptions: {thousandsSeparator: ',', decimalPlaces: 0}},
    {name: 'numMemberOut', index: 'numMemberOut', align: 'right', sortable: true, width: 100,
        formatter: 'number',
        formatoptions: {thousandsSeparator: ',', decimalPlaces: 0}},
    {name: 'createdDate', index: 'createdDate', align: 'center', sortable: true, width: 100,
        formatoptions: {newformat: 'd M Y'},
        formatter: function (cellVal, opts, rowObject, action) {
            if (!cellVal) {
                return '';
            } else {
                return $.fn.fmatter.call(
                        this,
                        "date",
                        moment(new Date(cellVal)).add(543, 'years').toDate(),
                        $.extend({}, $.jgrid.formatter.date, opts),
                        rowObject,
                        action);
            }
        }},
    {name: 'username', index: 'username', sortable: true, width: 100},
    {name: '', index: '', sortable: true, width: 100}
];
var pyc101GridJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "deptpaymentId" //the unique id of the row
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
    console.log('Initialize PYC101 Grid ..');
    $(pyc101GridName).jqGrid({
        url: pyc101GridUrl,
        datatype: 'json',
        mtype: 'POST',
        caption: pyc101GridCaption,
        colNames: pyc101GridColNames,
        colModel: pyc101GridColModel,
        jsonReader: pyc101GridJsonReader,
        autowidth: true,
        shrinkToFit: false,
        pager: pyc101GridPagerName,
        height: 'auto',
        width: 'auto',
        rowNum: 10,
        sortname: pyc101GridSortName,
        sortorder: pyc101GridSortOrder,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
        },
        onSelectRow: function (id, event) {
        },
        loadComplete: function () {
            enableTooltips(this);
            updatePagerIcons(this);
        }
    });
    $(pyc101GridName).jqGrid('navGrid', pyc101GridPagerName, {edit: false, add: false, del: false, search: false, refresh: false});
});
