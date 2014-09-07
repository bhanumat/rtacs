/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.UrlCaseSensitiveAnnotation;

import java.util.Map;
import org.springframework.util.AntPathMatcher;

/**
 *
 * @author S&B Soft House
 */
public class CaseInsensitivePathMatcher extends AntPathMatcher {

    @Override
    protected boolean doMatch(String pattern, String path, boolean fullMatch, Map<String, String> uriTemplateVariables) {
        return super.doMatch(pattern.toLowerCase(), path.toLowerCase(), fullMatch, uriTemplateVariables);
    }
}
