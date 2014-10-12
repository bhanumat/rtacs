/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberPaymentDAO;
import com.itos.dao.model.IMemberPaymentHeadDAO;
import com.itos.model.MemberPayment;
import com.itos.model.MemberPaymentHead;
import com.itos.model.ext.DeptMemberPaymentDto;
import com.itos.model.ext.DeptPaymentDto;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.service.model.IMemberPaymentService;
import com.itos.util.DateUtil;
import com.itos.util.StringPool;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MemberPaymentRequest;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bhanumat.w
 */
@Service("iMemberPaymentService")
public class MemberPaymentService implements IMemberPaymentService {
    
    private final Log logger = LogFactory.getLog(getClass());
    private static final String MONTHLY_FEE = "ค่าบำรุงศพประจำเดือน ";
    private static final String START_SOP = "ตั้งแต่ศพที่ ";
    private static final String END_SOP = "ถึงศพที่ ";
    
    @Autowired
    private IMemberPaymentDAO iMemberPaymentDAO;
    
    @Autowired
    private IMemberPaymentHeadDAO iMemberPaymentHeadDAO;
    
    @Value("${application.DateFormat}")
    private String stringDateFormat;
    
    public MemberPaymentService() {
        
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse createMemberPayment(MemberPayment memberPayment) {
        if (memberPayment != null) {
            return iMemberPaymentDAO.add(memberPayment);
        } else {
            logger.error("Passing memberPayment=null");
            throw new NullPointerException("MemberPayment memberPayment is null");
        }
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse updateMemberPayment(MemberPayment memberPayment) {
        if (memberPayment != null) {
            return iMemberPaymentDAO.update(memberPayment);
        } else {
            logger.error("Passing memberPayment=null");
            throw new NullPointerException("MemberPayment memberPayment is null");
        }
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse removeMemberPayment(MessageRequest req) {
        if (req != null) {
            MessageResponse resp = iMemberPaymentDAO.remove(req);
            if (resp.getCheckSuccess()) {
                //Manual remove cascade table related.
                return iMemberPaymentHeadDAO.remove(req);
            } else {
                return resp;
            }
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public MemberPayment getMemberPayment(int paymentId) {
        return iMemberPaymentDAO.getMemberPaymentById(paymentId);
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberPaymentDto> searchMemberPayment(JqGridRequest req) {
        if (req != null) {
            return iMemberPaymentDAO.searchMemberPayment(req);
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberPaymentHeadDto> getMemberPaymentByCode(JqGridRequest req) {
        if (req != null) {
            JqGridResponse<MemberPaymentHeadDto> jqGridResponse = iMemberPaymentDAO.getMemberPaymentByCode(req);
            for (MemberPaymentHeadDto mphDto : jqGridResponse.getRows()){
                mphDto.setPaymentDetail(buildMemberPaymentDetail(mphDto.getMonthCode(), mphDto.getStartSopNo(), mphDto.getEndSopNo()));
            }
            return jqGridResponse;
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse updateMemberPayment(MemberPaymentRequest req) throws Exception {
        if (req != null && req.getMemberPaymentHeadDtos() != null && req.getMemberPaymentHeadDtos().length > 0) {
            Date paymentDate = DateUtil.String2Date(req.getPaymentDate(), stringDateFormat);
            int memberId = req.getMemberId();
            int paymentTypeCode = req.getPaymentTypeCode();
            String performedBy = req.getPerformedBy();
            String postNo = req.getPostNo();
            MemberPayment memberPaymentToUpdate;
            MemberPayment memberPaymentUpdated;
            MemberPaymentHead memberPaymentHeadToAdd;
            MessageResponse resp = null;
            for (MemberPaymentHeadDto dto : req.getMemberPaymentHeadDtos()) {
                memberPaymentToUpdate = new MemberPayment(dto.getPaymentId(), memberId);
                memberPaymentToUpdate.setPaymentDate(paymentDate);
                memberPaymentToUpdate.setPaymentTypeCode(paymentTypeCode);
                memberPaymentToUpdate.setUpdatedBy(performedBy);
                
                resp = iMemberPaymentDAO.update(memberPaymentToUpdate);
                memberPaymentUpdated = (MemberPayment) resp.getObj();
                
                memberPaymentHeadToAdd = new MemberPaymentHead(dto.getPaymentId());
                memberPaymentHeadToAdd.setMemberId(memberId);
                memberPaymentHeadToAdd.setAmount(memberPaymentUpdated.getAmount());
                memberPaymentHeadToAdd.setPaymentDate(paymentDate);
                memberPaymentHeadToAdd.setPaymentTypeCode(paymentTypeCode);
                memberPaymentHeadToAdd.setPaymentPostNo(postNo);
                memberPaymentHeadToAdd.setCreatedBy(performedBy);
                resp = iMemberPaymentHeadDAO.add(memberPaymentHeadToAdd);
            }
            return resp;
        } else {
            logger.error("Passing MemberPaymentRequest req with null");
            throw new NullPointerException("Passing MemberPaymentRequest req with null or  req.getMemberPaymentHeadDtos() is null or empty");
        }
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<DeptPaymentDto> searchDeptPayment(JqGridRequest req) {
        if (req != null) {
            return iMemberPaymentDAO.searchDeptPayment(req);
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<DeptMemberPaymentDto> getListDeptMemberPayment (JqGridRequest req) {
        if (req != null) {
            return iMemberPaymentDAO.getListDeptMemberPayment(req);
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }
    
    private String buildMemberPaymentDetail(String monthCode, Integer start, Integer end) {
        String strMm = StringUtils.substring(monthCode, 3, 5);  //  MM.
        String StrYyy = StringUtils.substring(monthCode, 0, 3); //  yyy.
        String StrYy = StringUtils.substring(monthCode, 1, 3);  //  yy.
        String strBbuddhistYear = StringUtils.rightPad("2", 4, StrYyy); //  '2' + yyy.
        String shortMonth = formatMonth(NumberUtils.toInt(strMm), new Locale("th", "TH"));  //  ม.ค. etc.
        StringBuilder sb = new StringBuilder();
        sb.append(MONTHLY_FEE);
        sb.append(shortMonth);
        sb.append(StringPool.SPACE);
        sb.append(strBbuddhistYear);
        sb.append(StringPool.SPACE);
        sb.append(START_SOP).append(start).append(StringPool.SLASH).append(StrYy);
        sb.append(StringPool.SPACE);
        sb.append(END_SOP).append(end).append(StringPool.SLASH).append(StrYy);
        return sb.toString();
    }

    private String formatMonth(int month, Locale locale) {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] monthNames = symbols.getShortMonths();
        return monthNames[month - 1];
    }
    
}
