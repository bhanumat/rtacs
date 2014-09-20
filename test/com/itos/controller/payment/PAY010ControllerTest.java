/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.controller.payment;

import com.itos.model.MemberPayment;
import com.itos.service.model.IMemberPaymentService;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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
public class PAY010ControllerTest {

    @Mock
    private IMemberPaymentService iMemberPaymentService;

    @InjectMocks
    private PAY010Controller pay010Controller;

    private MockMvc mockMvc;

    public PAY010ControllerTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pay010Controller).build();

    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetMemberPayment() {
        when(iMemberPaymentService.getMemberPayment(2)).thenReturn(new MemberPayment(2, 10));
    }

}
