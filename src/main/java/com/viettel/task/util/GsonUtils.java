package com.viettel.task.util;

/**
 * Copyright 2014 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * GsonUtils
 *
 * @author TrungNTH
 * @version 1.0
 * @since 23-12-2014
 */
public final class GsonUtils {

    private static final GsonUtils INSTANCE = new GsonUtils();

    private Gson gson;

    private GsonUtils() {
        gson = new GsonBuilder().create();
    }

    public static Gson getGson() {
        return INSTANCE.gson;
    }
}
