/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IControlMemberDAO;
import com.itos.dao.model.IMemberDAO;
import com.itos.dao.model.IMilitaryDepartmentDAO;
import com.itos.dao.model.IOperationMemberDAO;
import com.itos.dao.model.IRankDAO;
import com.itos.dao.model.ITitleDAO;
import com.itos.model.Bank;
import com.itos.model.BankAccountType;
import com.itos.model.BankBranch;
import com.itos.model.ControlMember;
import com.itos.model.Member;
import com.itos.model.MilitaryDepartment;
import com.itos.model.Province;
import com.itos.model.Rank;
import com.itos.model.Title;
import com.itos.model.ext.PaymentDetail;
import com.itos.util.ConstantsMessage;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jqGrid.Paging;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITOS
 */
@Repository("iControlMemberDAO")
public class ControlMemberDAO implements IControlMemberDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private SessionFactory sessionFactory;

    private final String objectTable = "ControlMember";

    @Override
    public BigDecimal getLastApplyFee() {
        logger.info("ControlMemberDAO : getLastApplyFee");
        
        List<ControlMember> list;
        BigDecimal amount = new BigDecimal(BigInteger.ZERO);
        List<WhereField> listWhereField = new ArrayList<>();
        
        Query query;
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);
       
        if (!query.list().isEmpty()) {
            list = query.list();
            amount = list.get(list.size()-1).getApplyFee();
            logger.info("amount : >>" + amount + "<<");
            return amount;
        }
        return null;
    }
}
