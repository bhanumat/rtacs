package com.itos.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itos.model.MemberPaymentHead;
import com.itos.service.model.IMemberPaymentHeadService;
import com.itos.util.ConstantsMessage;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class MemberPaymentHeadServiceIntegrationTest {

    @Autowired
    private IMemberPaymentHeadService iMemberPaymentHeadService;

    public MemberPaymentHeadServiceIntegrationTest() {
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
        MemberPaymentHead payment = buildMemberPaymentHead(7, 200, 20, "xxxxxx");

        MessageResponse response = iMemberPaymentHeadService.createMemberPaymentHead(payment);
        if (response != null) {
            assertEquals(true, response.getCheckSuccess());
            assertEquals(ConstantsMessage.SaveSuccessful, response.getMessage());
            assertNotNull("paymentId", response.getId());
            assertTrue(Integer.valueOf(response.getId()) > 0);
            assertNotNull("obj", response.getObj());

            MemberPaymentHead created = (MemberPaymentHead) response.getObj();
            assertNotNull(created.getCreatedBy());
            assertNotNull(created.getCreatedDate());
        } else {
            fail("response is null");
        }
    }

    private MemberPaymentHead buildMemberPaymentHead(int memberId, int amount, int payTypeCode, String receiptNo) {
        MemberPaymentHead payment = new MemberPaymentHead();
        payment.setMemberId(memberId);
        payment.setAmount(BigDecimal.valueOf(amount));
        payment.setPaymentTypeCode(payTypeCode);
        payment.setPaymentDate(new Date());
        payment.setReceiptNo(receiptNo);
        payment.setCreatedBy("JUnit Testing");
        payment.setCreatedDate(new Date());
        return payment;
    }

    @Test
    public void updateMemberPaymentHead() {

        MemberPaymentHead payment = buildMemberPaymentHead(7, 300, 22, "xxxxxx");
        MessageResponse createdResponse = iMemberPaymentHeadService.createMemberPaymentHead(payment);
        if (createdResponse != null) {
            payment = (MemberPaymentHead) createdResponse.getObj();
            payment.setMemberId(8);
            payment.setAmount(BigDecimal.valueOf(350));
            payment.setPaymentTypeCode(20);
            payment.setReceiptNo("yyyyyy");
            payment.setCancelFlag(1); // 1=true, 0=false
            payment.setUpdatedBy("JUnit Testing");
            payment.setUpdatedDate(new Date());

            MessageResponse updatedResponse = iMemberPaymentHeadService.updateMemberPaymentHead(payment);
            if (updatedResponse != null) {
                assertEquals(payment.getPaymentId(), ((MemberPaymentHead) updatedResponse.getObj()).getPaymentId());
                assertEquals(true, updatedResponse.getCheckSuccess());
                assertEquals(ConstantsMessage.UpdateSuccessful, updatedResponse.getMessage());

                MemberPaymentHead afterUpdated = iMemberPaymentHeadService.getMemberPaymentHead(Integer.valueOf(updatedResponse.getId()));
                assertEquals(payment.getMemberId(), afterUpdated.getMemberId());
                assertEquals(payment.getAmount(), afterUpdated.getAmount());
                assertEquals(payment.getPaymentTypeCode(), afterUpdated.getPaymentTypeCode());
                assertEquals(payment.getReceiptNo(), afterUpdated.getReceiptNo());
                assertEquals(payment.getCancelFlag(), afterUpdated.getCancelFlag());

                assertNotNull(afterUpdated.getUpdatedBy());
                assertNotNull(afterUpdated.getUpdatedDate());

            } else {
                fail("response is null");
            }
        }
    }

    @Test
    public void removeMemberPaymentHead() {

        MemberPaymentHead payment = buildMemberPaymentHead(7, 301, 22, "xxxxxx");
        MessageResponse createdResponse1 = iMemberPaymentHeadService.createMemberPaymentHead(payment);

        payment = buildMemberPaymentHead(7, 302, 22, "xxxxxx2");
        MessageResponse createdResponse2 = iMemberPaymentHeadService.createMemberPaymentHead(payment);

        List<String> ids = new ArrayList();
        ids.add(createdResponse1.getId());
        ids.add(createdResponse2.getId());

        MessageRequest req = new MessageRequest();
        req.setItemSelect(ids);
        req.setUserProfileCode("");
        req.setUserProfileId("");

        MessageResponse createdResponse = iMemberPaymentHeadService.removeMemberPaymentHead(req);
        if (createdResponse != null) {
            assertEquals(true, createdResponse.getCheckSuccess());
            assertEquals(ConstantsMessage.DeleteSuccessful, createdResponse.getMessage());
        } else {
            fail("response is null");
        }
    }

    @Test
    public void getMemberPaymentHead() {

        MemberPaymentHead payment = buildMemberPaymentHead(7, 300, 22, "xxxxxx");
        MessageResponse createdResponse = iMemberPaymentHeadService.createMemberPaymentHead(payment);
        if (createdResponse != null) {
            MemberPaymentHead created = (MemberPaymentHead) createdResponse.getObj();
            MemberPaymentHead loaded = iMemberPaymentHeadService.getMemberPaymentHead(Integer.valueOf(createdResponse.getId()));
            assertNotNull(loaded);
            assertEquals(created.getPaymentId(), loaded.getPaymentId());
            assertEquals(created.getAmount(), loaded.getAmount());
            assertEquals(created.getPaymentTypeCode(), loaded.getPaymentTypeCode());
            assertEquals(created.getReceiptNo(), loaded.getReceiptNo());
            assertEquals(created.getCancelFlag(), loaded.getCancelFlag());

            assertNotNull(loaded.getCreatedBy());
            assertNotNull(loaded.getCreatedDate());
        } else {
            fail("response is null");
        }
    }
}
