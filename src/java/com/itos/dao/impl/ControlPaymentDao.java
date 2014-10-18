package com.itos.dao.impl;

import com.itos.dao.model.IControlPaymentDAO;
import com.itos.model.ControlPayment;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhanumat.w
 */
@Repository("iControlPaymentDao")
public class ControlPaymentDao implements IControlPaymentDAO {

    protected String objectTable = "ControlPayment";
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ControlPayment> getMonthCodes() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(ControlPayment.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("monthCode"), "monthCode")
                        .add(Projections.property("budgetMonth"), "budgetMonth"))
                .setResultTransformer(Transformers.aliasToBean(ControlPayment.class));
         cr.addOrder(Order.desc("monthCode"));
        return cr.list();
    }

}
