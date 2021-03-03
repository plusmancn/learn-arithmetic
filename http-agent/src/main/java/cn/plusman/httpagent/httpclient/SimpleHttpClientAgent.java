/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.httpagent.httpclient;

import cn.plusman.httpagent.HttpTransformer;
import cn.plusman.httpagent.SimpleHttpAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.Instrumentation;

/**
 * @author plusman
 * @since 2021/3/3 10:56 AM
 */
public class SimpleHttpClientAgent {
    private static Logger log = LoggerFactory.getLogger(SimpleHttpClientAgent.class);
    
    public static void premain(String agentArgs, Instrumentation ins) {
        log.info("In premain method");
        ins.addTransformer(new BasicHttpResponseInterceptor(), true);
    }
    
    public static void agentmain(String agentArgs, Instrumentation inst) {
        log.info("In agentmain method");
    }
}
