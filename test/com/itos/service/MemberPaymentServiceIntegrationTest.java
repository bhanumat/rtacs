package com.itos.service;

/*
 * To change this license header, choose License ers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.itos.model.MemberPayment;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.service.model.IMemberPaymentService;
import com.itos.util.ConstantsMessage;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
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
public class MemberPaymentServiceIntegrationTest {

    @Autowired
    private IMemberPaymentService iMemberPaymentService;

    public MemberPaymentServiceIntegrationTest() {
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
    public void createMemberPayment() {
        try {
            int memberId = 7;
            String monthCode = "55709";
            int paymentTypeCode = 20;
            int referenceId = 1;
            String bankCode = "";
            String bankAccNo = "";
            int bankOperationId = 11;
            float bankPaymentAmount = 200;
            float payAmount = 200;
            float amount = 200;
            float overAmount = 0;
            int cancelFlag = 1;
            String remark = "Test";
            
            MemberPayment payment = buildMemberPayment(memberId, monthCode, paymentTypeCode, referenceId, bankCode,
                    bankAccNo, bankOperationId, bankPaymentAmount, payAmount, amount, overAmount, cancelFlag, remark
            );
            
            MessageResponse response = iMemberPaymentService.createMemberPayment(payment);
            if (response != null) {
                assertEquals(true, response.getCheckSuccess());
                assertEquals(ConstantsMessage.SaveSuccessful, response.getMessage());
                assertNotNull("paymentId", response.getId());
                assertTrue(Integer.valueOf(response.getId()) > 0);
                assertNotNull("obj", response.getObj());
                
                MemberPayment created = (MemberPayment) response.getObj();
                assertNotNull(created.getCreatedBy());
                assertNotNull(created.getCreatedDate());
            } else {
                fail("response is null");
            }
        } catch (Exception ex) {
            Logger.getLogger(MemberPaymentServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private MemberPayment buildMemberPayment(int memberId, String monthCode, int paymentTypeCode, int referenceId, String bankCode,
            String bankAccNo, int bankOperationId, float bankPaymentAmount,
            float payAmount, float amount, float overAmount, int cancelFlag, String remark) {
        MemberPayment payment = new MemberPayment();
        payment.setMemberId(memberId);
        payment.setMonthCode(monthCode);
        payment.setReferenceId(referenceId);
        payment.setBankCode(bankCode);
        payment.setBankAccNo(bankAccNo);
        payment.setBankOperationId(bankOperationId);
        payment.setBankPayAmount(BigDecimal.valueOf(bankPaymentAmount));
        payment.setPayAmount(BigDecimal.valueOf(payAmount));
        payment.setAmount(BigDecimal.valueOf(amount));
        payment.setOverAmount(BigDecimal.valueOf(overAmount));
        payment.setCancelFlag(cancelFlag);
        payment.setRemark(remark);
        payment.setPaymentTypeCode(paymentTypeCode);
        payment.setPaymentDate(new Date());

        payment.setCreatedBy("JUnit Testing");
        payment.setCreatedDate(new Date());
        return payment;
    }

    @Test
    public void updateMemberPayment() {

        try {
            int memberId = 7;
            String monthCode = "55709";
            int paymentTypeCode = 20;
            int referenceId = 1;
            String bankCode = "";
            String bankAccNo = "";
            int bankOperationId = 11;
            float bankPaymentAmount = 200;
            float payAmount = 200;
            float amount = 200;
            float overAmount = 0;
            int cancelFlag = 0;
            String remark = "Test";
            
            MemberPayment payment = buildMemberPayment(memberId, monthCode, paymentTypeCode, referenceId, bankCode,
                    bankAccNo, bankOperationId, bankPaymentAmount, payAmount, amount, overAmount, cancelFlag, remark
            );
            
            MessageResponse createdResponse = iMemberPaymentService.createMemberPayment(payment);
            if (createdResponse != null) {
                payment = (MemberPayment) createdResponse.getObj();
                payment.setMemberId(8);
                payment.setAmount(BigDecimal.valueOf(350));
                payment.setPaymentTypeCode(20);
                payment.setCancelFlag(1); // 1=true, 0=false
                payment.setUpdatedBy("JUnit Testing");
                payment.setUpdatedDate(new Date());
                
                MessageResponse updatedResponse = iMemberPaymentService.updateMemberPayment(payment);
                if (updatedResponse != null) {
                    assertEquals(payment.getPaymentId(), ((MemberPayment) updatedResponse.getObj()).getPaymentId());
                    assertEquals(true, updatedResponse.getCheckSuccess());
                    assertEquals(ConstantsMessage.UpdateSuccessful, updatedResponse.getMessage());
                    
                    MemberPayment afterUpdated = iMemberPaymentService.getMemberPayment(Integer.valueOf(updatedResponse.getId()));
                    assertEquals(payment.getMemberId(), afterUpdated.getMemberId());
                    assertEquals(payment.getAmount(), afterUpdated.getAmount());
                    assertEquals(payment.getPaymentTypeCode(), afterUpdated.getPaymentTypeCode());
                    assertEquals(payment.getCancelFlag(), afterUpdated.getCancelFlag());
                    
                    assertNotNull(afterUpdated.getUpdatedBy());
                    assertNotNull(afterUpdated.getUpdatedDate());
                    
                } else {
                    fail("response is null");
                }
            }
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void removeMemberPayment() {

        try {
            int memberId = 7;
            String monthCode = "55709";
            int paymentTypeCode = 20;
            int referenceId = 1;
            String bankCode = "";
            String bankAccNo = "";
            int bankOperationId = 11;
            float bankPaymentAmount = 200;
            float payAmount = 200;
            float amount = 200;
            float overAmount = 0;
            int cancelFlag = 1;
            String remark = "Test";
            
            MemberPayment payment = buildMemberPayment(memberId, monthCode, paymentTypeCode, referenceId, bankCode,
                    bankAccNo, bankOperationId, bankPaymentAmount, payAmount, amount, overAmount, cancelFlag, remark
            );
            MessageResponse createdResponse1 = iMemberPaymentService.createMemberPayment(payment);
            
            paymentTypeCode = 22;
            referenceId = 2;
            payment = buildMemberPayment(memberId, monthCode, paymentTypeCode, referenceId, bankCode,
                    bankAccNo, bankOperationId, bankPaymentAmount, payAmount, amount, overAmount, cancelFlag, remark
            );
            MessageResponse createdResponse2 = iMemberPaymentService.createMemberPayment(payment);
            
            List<String> ids = new ArrayList();
            ids.add(createdResponse1.getId());
            ids.add(createdResponse2.getId());
            
            MessageRequest req = new MessageRequest();
            req.setItemSelect(ids);
            req.setUserProfileCode("");
            req.setUserProfileId("");
            
            MessageResponse createdResponse = iMemberPaymentService.removeMemberPayment(req);
            if (createdResponse != null) {
                assertEquals(true, createdResponse.getCheckSuccess());
                assertEquals(ConstantsMessage.DeleteSuccessful, createdResponse.getMessage());
            } else {
                fail("response is null");
            }
        } catch (Exception ex) {
            Logger.getLogger(MemberPaymentServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void getMemberPayment() {

        try {
            int memberId = 7;
            String monthCode = "55709";
            int paymentTypeCode = 20;
            int referenceId = 1;
            String bankCode = "";
            String bankAccNo = "";
            int bankOperationId = 11;
            float bankPaymentAmount = 200;
            float payAmount = 200;
            float amount = 200;
            float overAmount = 0;
            int cancelFlag = 1;
            String remark = "Test";
            
            MemberPayment payment = buildMemberPayment(memberId, monthCode, paymentTypeCode, referenceId, bankCode,
                    bankAccNo, bankOperationId, bankPaymentAmount, payAmount, amount, overAmount, cancelFlag, remark
            );
            MessageResponse createdResponse = iMemberPaymentService.createMemberPayment(payment);
            if (createdResponse != null) {
                MemberPayment created = (MemberPayment) createdResponse.getObj();
                MemberPayment loaded = iMemberPaymentService.getMemberPayment(Integer.valueOf(createdResponse.getId()));
                assertNotNull(loaded);
                assertEquals(created.getPaymentId(), loaded.getPaymentId());
                assertEquals(created.getAmount(), loaded.getAmount());
                assertEquals(created.getPaymentTypeCode(), loaded.getPaymentTypeCode());
                assertEquals(created.getCancelFlag(), loaded.getCancelFlag());
                
                assertNotNull(loaded.getCreatedBy());
                assertNotNull(loaded.getCreatedDate());
            } else {
                fail("response is null");
            }
        } catch (Exception ex) {
            Logger.getLogger(MemberPaymentServiceIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void getMemberPaymentByCode() {
        
        JqGridRequest req = new JqGridRequest();
        req.setNd("1411189121948");	
        req.setRows(10);	
        req.setPage(1);	
        req.setSidx("paymentId");	
        req.setSord("asc");	
        req.setSearchField(null);	
        req.setSearchString(null);	
        req.setSearchOper(null);	
        req.setFilters(null);	
        req.setSearch (true);
        StringBuilder sb = new StringBuilder();
        sb.append("{\"conditions\":[");
            sb.append("{\"groupOp\":\"\",\"field\":\"memberId\",\"op\":\"eq\",\"data\":568362,\"dataType\":\"varchar\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"citizenId\",\"op\":\"eq\",\"data\":\"3160100142129\",\"dataType\":\"varchar\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"memberCode\",\"op\":\"eq\",\"data\":\"4001000042\",\"dataType\":\"varchar\"},");
        sb.append("]}");
        req.setSearchCommand(sb.toString());
        JqGridResponse<MemberPaymentHeadDto> memberPaymentHeadDto = iMemberPaymentService.getMemberPaymentByCode(req);
        if (memberPaymentHeadDto != null && memberPaymentHeadDto.getRows() != null) {
            System.out.println("getMemberPaymentByCode result : "+memberPaymentHeadDto.getRows().toString());
        }else {
            fail("response is null");
        }
        
    }
    
    @Test
    public void searchMemberPayment() {
        
        JqGridRequest req = new JqGridRequest();
        req.setNd("1411189121948");	
        req.setRows(10);	
        req.setPage(1);	
        req.setSidx("printedStatus");	
        req.setSord("asc");	
        req.setSearchField(null);	
        req.setSearchString(null);	
        req.setSearchOper(null);	
        req.setFilters(null);	
        req.setSearch (false);
        StringBuilder sb = new StringBuilder();
        sb.append("{\"conditions\":[");
//            sb.append("{\"groupOp\":\"\",\"field\":\"paymentId\",\"op\":\"eq\",\"data\":\"1\",\"dataType\":\"varchar\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"paymentDate\",\"op\":\"bw\",\"data\":\"01/01/2013,31/12/2013\",\"dataType\":\"date\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"citizenId\",\"op\":\"eq\",\"data\":\"3160100142129\",\"dataType\":\"varchar\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"memberCode\",\"op\":\"eq\",\"data\":\"4001000042\",\"dataType\":\"varchar\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"name\",\"op\":\"eq\",\"data\":\"เฉลิม\",\"dataType\":\"varchar\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"surname\",\"op\":\"eq\",\"data\":\"ศรีสว่าง\",\"dataType\":\"varchar\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"memberGroupCode\",\"op\":\"eq\",\"data\":\"10\",\"dataType\":\"varchar\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"memberTypeCode\",\"op\":\"eq\",\"data\":\"20\",\"dataType\":\"varchar\"},");
            sb.append("{\"groupOp\":\"\",\"field\":\"mildeptId\",\"op\":\"eq\",\"data\":\"13307\",\"dataType\":\"integer\"},");
//            sb.append("{\"groupOp\":\"\",\"field\":\"printedStatus\",\"op\":\"eq\",\"data\":\"N\",\"dataType\":\"char\"},");
        sb.append("]}");
        req.setSearchCommand(sb.toString());
        JqGridResponse<MemberPaymentDto> memberPaymentDtos = iMemberPaymentService.searchMemberPayment(req);
        if (memberPaymentDtos != null && memberPaymentDtos.getRows() != null) {
            System.out.println("getMemberPaymentByCode result : "+memberPaymentDtos.getRows().toString());
        }else {
            fail("response is null");
        }
        
    }
}
