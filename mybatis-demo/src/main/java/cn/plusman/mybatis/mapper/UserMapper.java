/*
 * Copyright (c) 2021. <plusmancn@gmail.com> All Rights Reversed.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cn.plusman.mybatis.mapper;

import cn.plusman.mybatis.entity.User;

/**
 * @author plusman
 * @since 2021/3/13 3:05 PM
 */
public interface UserMapper {
    User selectByid3(Integer id);
}
