package com.itos.util;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.util.jsonObject.MemberPaymentRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bhanumat.w
 */
public class TestJson {

    public static void main(String... args) throws JsonMappingException, IOException {
        List<MemberPaymentHeadDto> dtos = new ArrayList<>();
        MemberPaymentHeadDto dto = new MemberPaymentHeadDto();
        dto.setAmount(new BigDecimal(200));
        dto.setStartSopNo(1);
        dto.setEndSopNo(2);
        dto.setMemberId(5);
        dto.setMonthCode("5570927");
//        dto.setPaymentDate(new Date());
        dto.setPaymentId(2);
        dto.setPaymentTypeCode(20);
        dto.setReceiptNo("xxxxxx");
        dto.setRemark("");
        dtos.add(dto);
        
        dto = new MemberPaymentHeadDto();
        dto.setAmount(new BigDecimal(200));
        dto.setStartSopNo(6);
        dto.setEndSopNo(7);
        dto.setMemberId(5);
        dto.setMonthCode("5570927");
//        dto.setPaymentDate(new Date());
        dto.setPaymentId(3);
        dto.setPaymentTypeCode(20);
        dto.setReceiptNo("xxxxxx");
        dto.setRemark("");
        dtos.add(dto);
        
        MemberPaymentRequest req = new MemberPaymentRequest();
        req.setMemberId(1);
//        req.setMemberPaymentHeadDtos(dtos);
        req.setPaymentDate("27/09/2014");
        req.setPaymentTypeCode(20);
        
        
//        String data2Json = "{}";
//        MemberPaymentDto obj = JsonUtil.parse(dto, MemberPaymentDto.class);
        
        
        System.err.println(JsonUtil.toJsonString(req));
        
    }
}
