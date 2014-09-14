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
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private SessionFactory sessionFactory;
    private static final String TB_NAME = "MemberPaymentHead";
    private static final String ATT_PAYMENT_ID = "paymentId";

    @Override
    public MessageResponse add(MemberPaymentHead memberPaymentHead) {
        MessageResponse response = new MessageResponse();
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
    public MessageResponse remove(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        MemberPaymentHead memberPaymentHead;
        boolean success;

        for (String id : req.getItemSelect()) {
            memberPaymentHead = (MemberPaymentHead) CommandQuery.LoadDetail(sessionFactory, MemberPaymentHead.class, id);
            if (CommandQuery.Delete(sessionFactory, memberPaymentHead)) {
                iCountSuccessful++;
            }
        }
        if (iCountSuccessful == req.getItemSelect().size()) {
            response.setCheckSuccess(true);
        } else {
            response.setCheckSuccess(false);
        }
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
        memberPaymentHeadOrigin.setCancelFlag(memberPaymentHead.getCancelFlag());
        memberPaymentHeadOrigin.setPaymentDate(memberPaymentHead.getPaymentDate());
        memberPaymentHeadOrigin.setUpdatedBy(memberPaymentHead.getUpdatedBy());
        memberPaymentHeadOrigin.setUpdatedDate(memberPaymentHead.getUpdatedDate());

        if (CommandQuery.Update(sessionFactory, memberPaymentHeadOrigin)) {
            response.setCheckSuccess(true);
            response.setId(String.valueOf(memberPaymentHeadOrigin.getPaymentId()));
            response.setMessage(ConstantsMessage.UpdateSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.UpdateUnsuccessful);
        }
        return response;
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

            if (!query.list().isEmpty()) {
                memberPaymentHead = (MemberPaymentHead) query.list().get(0);
            }
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return memberPaymentHead;
    }

}
