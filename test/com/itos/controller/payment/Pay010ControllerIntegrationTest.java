package com.itos.controller.payment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itos.model.MemberPaymentHead;
import com.itos.service.model.IMemberPaymentService;
import com.itos.util.jsonObject.MessageResponse;
import java.math.BigDecimal;
import java.util.Date;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author bhanumat.w
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    /**
     * Commented out because of I cannot solve a problem related to bean id=tilesConfigurer And we no need to have it.
     * We point to integrate test on *Controller, view no more needed.
     */
    //    "file:web/WEB-INF/tiles.xml",
    //    "file:web/WEB-INF/applicationContext.xml",
    //    "file:web//WEB-INF/dispatcher-servlet.xml",
    //    "file:web//WEB-INF/spring-connection.xml",
    //    "file:web/WEB-INF/spring-datasource.xml",
    //    "file:web/WEB-INF/spring-security.xml"
    "classpath:testApplicationContext.xml",
    //        "classpath:dispatcher-servlet.xml", //Don't have XmlViewResolver yet.
    "classpath:spring-connection.xml",
    "classpath:spring-datasource.xml",
    "classpath:spring-security.xml"
})
@TransactionConfiguration(transactionManager = "hibernateTransactionManager", defaultRollback = true)
@Transactional
public class Pay010ControllerIntegrationTest {

    @Autowired
    private IMemberPaymentService iMemberPaymentService;

    public Pay010ControllerIntegrationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createMemberPaymentHead() {
        MemberPaymentHead payment = new MemberPaymentHead();
        payment.setMemberId(7);
        payment.setAmount(new BigDecimal(200));
        payment.setPaymentId(1);
        payment.setPaymentTypeCode(20);
        payment.setPaymentDate(new Date());
        payment.setReceiptNo("xxxxxxx");
        payment.setCreatedBy("admin");
        payment.setCreatedDate(new Date());

        MessageResponse response = iMemberPaymentService.createMemberPaymentHead(payment);
        if (response != null) {
            assertEquals(true, response.getCheckSuccess());
            org.junit.Assert.assertNotNull("paymentId", response.getId());
            org.junit.Assert.assertNotNull("object", response.getObj());
        } else {
            fail("response is null");
        }
    }
}
