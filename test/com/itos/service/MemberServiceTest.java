/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service;

import com.itos.model.ext.MemberData;
import com.itos.service.model.IMemberService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bhanumat.w
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:testApplicationContext.xml",
    "classpath:spring-connection.xml",
    "classpath:spring-datasource.xml",
    "classpath:spring-security.xml"
})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
@Transactional
public class MemberServiceTest {
    
     @Autowired
    private IMemberService iMemberService;

    public MemberServiceTest() {
    }

    @Test
    public void searchMember() {
        JqGridRequest req = new JqGridRequest();
        req.setNd("1411189121948");	
        req.setRows(10);	
        req.setPage(1);	
        req.setSidx(null);	
        req.setSord("asc");	
        req.setSearchField(null);	
        req.setSearchString(null);	
        req.setSearchOper(null);	
        req.setFilters(null);	
        req.setSearch (true);
        req.setSearchCommand("{\"conditions\":[{\"groupOp\":\"\",\"field\":\"memberId\",\"op\":\"eq\",\"data\":8,\"dataType\":\"String\"}]}");
        JqGridResponse<MemberData> response = iMemberService.getListMember(req);
        
        if (response != null) {
            assertNotNull(response.getRows());
            assertTrue(response.getPage()>0);
            assertTrue(response.getRecords()>0);
            assertTrue(response.getTotalPages()>0);
        }else {
            fail("response is null");
        }
    }
}
