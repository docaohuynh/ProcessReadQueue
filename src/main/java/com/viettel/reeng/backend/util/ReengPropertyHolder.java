
/*
 * Copyright (C) 2012 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.viettel.reeng.backend.util;

//import com.viettel.security.PassTranformer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 *
 * @author vas_phunp
 */
public class ReengPropertyHolder extends PropertyPlaceholderConfigurer {

    private String encryptFlag = ".enc";

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        return convertPropertyValue(propertyValue);
    }

    public void setEncryptFlag(String encryptFlag) {
        this.encryptFlag = encryptFlag;
    }
}
