<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/chosen.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/datepicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/bootstrap-timepicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/daterangepicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/bootstrap-datetimepicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/colorpicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/Themes/jquery.validationEngine/validationEngine.jquery.css" />


<!-- text fonts -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace.min.css" />

<!--[if lte IE 9]>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-part2.min.css" />
<![endif]-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/ace-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/Themes/theme.internal.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/Themes/select2/select2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/Themes/select2/select2-bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Content/assets/css/bootstrapValidator.min.css" />

<!-- ace settings handler -->
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lte IE 8]>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/html5shiv.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/respond.min.js"></script>
<![endif]-->


<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script type='text/javascript' src='${pageContext.request.contextPath}/Content/assets/js/jquery.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
window.jQuery || document.write("<script type='text/javascript' src='${pageContext.request.contextPath}/Content/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    var rootPath = '${pageContext.request.contextPath}';
    if ('ontouchstart' in document.documentElement) {
        document.write("<script type='text/javascript' src='${pageContext.request.contextPath}/Content/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
    }
</script>
<!-- page specific plugin scripts -->
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/bootstrap.external/bootbox.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jquery-ui.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jquery.ui.touch-punch.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/fuelux/fuelux.spinner.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/date-time/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/date-time/bootstrap-timepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/date-time/daterangepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/date-time/locales/bootstrap-datepicker.th.js"></script>
<!--
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/bootstrap.external/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/bootstrap.external/bootstrap-datepicker-thai.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/bootstrap.external/bootstrap-datepicker.th.js"></script>
-->
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/bootstrap-colorpicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jquery.knob.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jquery.autosize.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jquery.maskedinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/bootstrap-tag.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/jqGrid/i18n/grid.locale-en.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/jquery.external/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/jquery.external/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/jquery.external/i18n/jquery.validationEngine-en.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/base/jquery.setting.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/base/jquery.jqGrid.setting.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/base/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/action.MainPage.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/jquery.external/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/jquery.external/i18n/select2_locale_th.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/jquery.external/jquery.fmatter.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Content/assets/js/bootstrapValidator.min.js"></script>
