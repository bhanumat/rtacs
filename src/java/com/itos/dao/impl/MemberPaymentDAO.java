package com.itos.dao.impl;

import com.itos.dao.model.IMemberPaymentDAO;
import com.itos.model.MemberPayment;
import com.itos.model.MemberPaymentHead;
import com.itos.util.ConstantsMessage;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import com.itos.util.StringPool;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bhanumat.w
 */
@Repository("iMemberPaymentDAO")
public class MemberPaymentDAO implements IMemberPaymentDAO {

    static {
        //Ignore null converting 
        ConvertUtils.register(new DateConverter(null), Date.class);
    }

    @Autowired
    private SessionFactory sessionFactory;
    private static final String TB_NAME = "MemberPayment";
    private static final String ATT_PAYMENT_ID = "paymentId";

    @Override
    public MessageResponse add(MemberPayment memberPayment) {
        MessageResponse response = new MessageResponse();
        boolean success = CommandQuery.Insert(sessionFactory, memberPayment);
        response.setCheckSuccess(success);
        if (success) {
            response.setId(String.valueOf(memberPayment.getPaymentId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
            response.setObj(memberPayment);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public JqGridResponse<MemberPayment> getList(JqGridRequest req) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MemberPayment getMemberPaymentById(int paymentId) {
        MemberPayment memberPayment = null;
        List<WhereField> listWhereField = new ArrayList<>();

        try {
            /*
             * Command HQL query Data.
             */
            WhereField whereField = new WhereField();
            whereField.setSearchField(ATT_PAYMENT_ID);
            whereField.setSearchLogic(StringPool.BLANK);
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(paymentId);
            listWhereField.add(whereField);

            Query query = CommandQuery.CreateQuery(sessionFactory, TB_NAME, listWhereField, 0, 1);

            if (!query.list().isEmpty() && query.list().size() == 1) {
                memberPayment = (MemberPayment) query.list().get(0);
            } else if (query.list().size() > 1) {
                throw new RuntimeException("Multiple record returned");
            } //else no data found
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return memberPayment;
    }

    @Override
    public MessageResponse remove(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        MemberPayment memberPayment;
        boolean success;

        for (String id : req.getItemSelect()) {
            memberPayment = (MemberPayment) CommandQuery.LoadDetail(sessionFactory, MemberPayment.class, Integer.valueOf(id));
            if (CommandQuery.Delete(sessionFactory, memberPayment)) {
                iCountSuccessful++;
            }
        }

        response.setCheckSuccess(iCountSuccessful == req.getItemSelect().size());
        success = response.getCheckSuccess();
        if (success) {
            response.setId(StringPool.BLANK);
            response.setMessage(ConstantsMessage.DeleteSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.DeleteUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse update(MemberPayment memberPayment) {
        MessageResponse response = new MessageResponse();
        MemberPayment memberPaymentOrigin = (MemberPayment) CommandQuery.LoadDetail(sessionFactory, MemberPayment.class, memberPayment.getPaymentId());
        try {
            BeanUtils.copyProperties(memberPaymentOrigin, memberPayment);
        } catch (IllegalAccessException | InvocationTargetException e) {
            Logger.getLogger(MemberPaymentHeadDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(ConstantsMessage.UpdateUnsuccessful);
        }

        memberPaymentOrigin.setUpdatedBy(memberPayment.getUpdatedBy());
        memberPaymentOrigin.setUpdatedDate(memberPayment.getUpdatedDate());

        if (CommandQuery.Update(sessionFactory, memberPaymentOrigin)) {
            response.setCheckSuccess(true);
            response.setId(String.valueOf(memberPaymentOrigin.getPaymentId()));
            response.setObj(memberPaymentOrigin);
            response.setMessage(ConstantsMessage.UpdateSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.UpdateUnsuccessful);
        }
        return response;
    }

}
