package com.itos.util.jsonObject;

import com.itos.model.ext.MemberPaymentHeadDto;
import java.util.Arrays;

/**
 *
 * @author bhanumat.w
 */
public class MemberPaymentRequest {

    private int memberId;
    private String postNo;
    private int paymentTypeCode;
    private String paymentDate;
    private MemberPaymentHeadDto[] memberPaymentHeadDtos;
    private String performedBy;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    public int getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(int paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public MemberPaymentHeadDto[] getMemberPaymentHeadDtos() {
        return memberPaymentHeadDtos;
    }

    public void setMemberPaymentHeadDtos(MemberPaymentHeadDto[] memberPaymentHeadDtos) {
        this.memberPaymentHeadDtos = memberPaymentHeadDtos;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    @Override
    public String toString() {
        return "MemberPaymentRequest{" + "memberId=" + memberId + ", postNo=" + postNo + ", paymentTypeCode=" + paymentTypeCode + ", paymentDate=" + paymentDate + ", memberPaymentHeadDtos=" + Arrays.toString(memberPaymentHeadDtos) + ", updateBy=" + performedBy + '}';
    }

}
