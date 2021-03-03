/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.httpagent.httpclient;

import cn.plusman.httpagent.CONSTANTS;
import javassist.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author plusman
 * @since 2021/3/3 10:54 AM
 */
public class BasicHttpResponseInterceptor implements ClassFileTransformer {
    private static Logger log = LoggerFactory.getLogger(BasicHttpResponseInterceptor.class);
    private final static String CLASS_NAME = "org/apache/http/message/BasicHttpResponse";
    private final static String HACK_METHOD = "getEntity";
    
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.equals(CLASS_NAME)) {
            String finalTargetClassName = CLASS_NAME.replaceAll("\\/", ".");
            log.info("Found {}", className);
            
            try {
                ClassPool cp = ClassPool.getDefault();
                CtClass cc = cp.get(finalTargetClassName);
                CtMethod method = cc.getDeclaredMethod(HACK_METHOD);
                
                
                StringBuilder sb = new StringBuilder();
                sb.append("org.apache.http.entity.BufferedHttpEntity ee = new org.apache.http.entity.BufferedHttpEntity(this.entity);");
                sb.append("org.apache.http.HttpEntity original = this.entity;");
                sb.append("this.entity = ee;");
                sb.append("return original;");
                method.insertBefore(sb.toString());
                
                cc.detach();
                
                return cc.toBytecode();
            } catch (NotFoundException | CannotCompileException | IOException e) {
                log.error("Transform {} fail", CONSTANTS.HACK_CLASS, e);
            }
        }
        
        return null;
    }
}