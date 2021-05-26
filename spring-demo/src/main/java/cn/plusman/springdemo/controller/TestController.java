/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.springdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author plusman
 * @since 2021/3/2 11:48 PM
 */
@Slf4j
@RestController
public class TestController {
    /**
     *
     * @param time 单位毫秒
     * @return
     */
    @GetMapping("/test/block")
    public String block(
        @RequestParam(required = false) int time
    ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.error("block error", e);
        }
    
        return String.format("blocked %sms", time);
    }
    
}
