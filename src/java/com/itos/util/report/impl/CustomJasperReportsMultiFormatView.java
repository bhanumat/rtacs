/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util.report.impl;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

/**
 * This calss override renderReport() method for replace report name .
 */
public class CustomJasperReportsMultiFormatView extends JasperReportsMultiFormatView {

    @Override
    protected void renderReport(JasperPrint populatedReport, Map<String, Object> model, HttpServletResponse response) throws Exception {
        // replace content disposition header filename with the report names.
        Properties contentDispositions = this.getContentDispositionMappings();

        Enumeration enumContDispKeys = contentDispositions.keys();
        // iterate over all disposition mappings and replace the word _rep_name_ with the reportName
        while (enumContDispKeys.hasMoreElements()) {
            Object contDispKey = enumContDispKeys.nextElement();
            // check whether string before cast.
            if (contDispKey instanceof String) {
                // get the disposition string
                String dispositionStr = contentDispositions.getProperty((String) contDispKey);
                // set the new value in the properties
                String fileName = String.valueOf(null == model.get("fileName") ? populatedReport.getName() : model.get("fileName"));
                contentDispositions.setProperty((String) contDispKey, dispositionStr.replace("_rep_name_", fileName));
            }
        }
        super.renderReport(populatedReport, model, response);
    }
}
