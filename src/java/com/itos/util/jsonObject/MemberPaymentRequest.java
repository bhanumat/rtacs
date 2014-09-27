package com.itos.util.jsonObject;

import com.itos.model.ext.MemberPaymentHeadDto;
import java.util.List;

/**
 *
 * @author bhanumat.w
 */
public class MemberPaymentRequest {

    private int paymentId;
    private int memberId;
    private String postNo;
    private int paymentTypeCode;
    private String paymentDate;
    private List<MemberPaymentHeadDto> memberPaymentHeadDtos;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

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

    public List<MemberPaymentHeadDto> getMemberPaymentHeadDtos() {
        return memberPaymentHeadDtos;
    }

    public void setMemberPaymentHeadDtos(List<MemberPaymentHeadDto> memberPaymentHeadDtos) {
        this.memberPaymentHeadDtos = memberPaymentHeadDtos;
    }

    @Override
    public String toString() {
        return "MemberPaymentRequest{" + "paymentId=" + paymentId + ", memberId=" + memberId + ", postNo=" + postNo + ", paymentTypeCode=" + paymentTypeCode + ", paymentDate=" + paymentDate + ", memberPaymentHeadDtos=" + memberPaymentHeadDtos + '}';
    }

}
