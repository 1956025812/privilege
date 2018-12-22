package com.authorization.privilege.mapper.dsprivilegewrite.user;

import com.authorization.privilege.entity.dsprivelege.user.User;

/**
 * @author duxuebo
 * @date 2018/12/4
 * @description 用户写MAPPER接口
 */
public interface UserWriteMapper {


    /**
     * 新增用户
     *
     * @param user
     * @throws Exception
     */
    void insertSelective(User user) throws Exception;


    /**
     * 修改用户
     *
     * @param user
     * @throws Exception
     */
    void updateByPrimaryKeySelective(User user) throws Exception;

}