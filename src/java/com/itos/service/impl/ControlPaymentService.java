package com.itos.service.impl;

import com.itos.dao.model.IControlPaymentDAO;
import com.itos.model.ControlPayment;
import com.itos.service.model.IControlPaymentService;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bhanumat.w
 */
@Service("iControlPaymentService")
public class ControlPaymentService implements IControlPaymentService {

    protected final Log logger = LogFactory.getLog(getClass());

    public ControlPaymentService() {

    }

    @Autowired
    private IControlPaymentDAO iControlPaymentDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<ControlPayment> getMonthCodes() {
        return iControlPaymentDAO.getMonthCodes();
    }

}
