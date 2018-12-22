package com.authorization.privilege.mapper.dsprivilegeread.user;

import com.authorization.privilege.entity.dsprivelege.user.User;

/**
 * @author duxuebo
 * @date 2018/12/4
 * @description 用户读MAPPER接口
 */
public interface UserReadMapper {

    /**
     * 根据主键查询用户
     *
     * @param uid 用户ID
     * @return User对象
     * @throws Exception
     */
    User selectByPrimaryKey(String uid) throws Exception;


}