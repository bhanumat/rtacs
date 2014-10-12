/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.ControlPayment;
import java.util.List;

/**
 *
 * @author bhanumat.w
 */
public interface IControlPaymentDAO {
    List<ControlPayment> getMonthCodes();
}
