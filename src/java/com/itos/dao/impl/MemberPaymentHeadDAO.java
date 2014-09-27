package com.itos.dao.impl;

import com.itos.dao.model.IMemberPaymentHeadDAO;
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
import java.math.BigDecimal;
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
@Repository("iMemberPaymentHeadDAO")
public class MemberPaymentHeadDAO implements IMemberPaymentHeadDAO {

    static {
        //Ignore null converting 
        ConvertUtils.register(new DateConverter(null), Date.class);
        ConvertUtils.register(new org.apache.commons.beanutils.converters.BigDecimalConverter(null), BigDecimal.class);
    }

    @Autowired
    private SessionFactory sessionFactory;
    private static final String TB_NAME = "MemberPaymentHead";
    private static final String ATT_PAYMENT_ID = "paymentId";

    @Override
    public MessageResponse add(MemberPaymentHead memberPaymentHead) {
        MessageResponse response = new MessageResponse();
        memberPaymentHead.setCreatedDate(new Date());
        boolean success = CommandQuery.Insert(sessionFactory, memberPaymentHead);
        response.setCheckSuccess(success);
        if (success) {
            response.setId(String.valueOf(memberPaymentHead.getPaymentId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
            response.setObj(memberPaymentHead);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public JqGridResponse<MemberPaymentHead> getList(JqGridRequest req) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MemberPaymentHead getMemberPaymentHeadById(int paymentId) {
        MemberPaymentHead memberPaymentHead = null;
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
                memberPaymentHead = (MemberPaymentHead) query.list().get(0);
            } else if (query.list().size() > 1) {
                throw new RuntimeException("Multiple record returned");
            }  //else no data found
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return memberPaymentHead;
    }

    @Override
    public MessageResponse remove(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        MemberPaymentHead memberPaymentHead;
        boolean success;

        for (String id : req.getItemSelect()) {
            memberPaymentHead = (MemberPaymentHead) CommandQuery.LoadDetail(sessionFactory, MemberPaymentHead.class, Integer.valueOf(id));
            if (CommandQuery.Delete(sessionFactory, memberPaymentHead)) {
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
    public MessageResponse update(MemberPaymentHead memberPaymentHead) {
        MessageResponse response = new MessageResponse();
        MemberPaymentHead memberPaymentHeadOrigin = (MemberPaymentHead) CommandQuery.LoadDetail(sessionFactory, MemberPaymentHead.class, memberPaymentHead.getPaymentId());
        try {
            BeanUtils.copyProperties(memberPaymentHeadOrigin, memberPaymentHead);
        } catch (IllegalAccessException | InvocationTargetException e) {
            Logger.getLogger(MemberPaymentHeadDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(ConstantsMessage.UpdateUnsuccessful);
        }

        memberPaymentHeadOrigin.setUpdatedBy(memberPaymentHead.getUpdatedBy());
        memberPaymentHeadOrigin.setUpdatedDate(new Date());

        if (CommandQuery.Update(sessionFactory, memberPaymentHeadOrigin)) {
            response.setCheckSuccess(true);
            response.setId(String.valueOf(memberPaymentHeadOrigin.getPaymentId()));
            response.setObj(memberPaymentHeadOrigin);
            response.setMessage(ConstantsMessage.UpdateSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.UpdateUnsuccessful);
        }
        return response;
    }
}
