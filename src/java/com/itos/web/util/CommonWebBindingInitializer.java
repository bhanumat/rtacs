/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author ITOS
 */
public class CommonWebBindingInitializer implements WebBindingInitializer {

    @Autowired
    private Validator validator;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.setValidator(validator);
        binder.setConversionService(conversionService);
    }

}
