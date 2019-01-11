package com.authorization.privilege.mapper.dsprivilegeread.user;

import com.authorization.privilege.entity.dsprivelege.user.User;
import com.authorization.privilege.vo.user.UserVO;

import java.util.Map;

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


    /**
     * 查询用户VO对象
     *
     * @param userVO
     * @return UserVO
     * @throws Exception
     */
    UserVO selectUserVO(UserVO userVO) throws Exception;


    /**
     * 查询用户ID和名称MAP
     *
     * @param userVO
     * @return 用户ID和名称MAP
     * @throws Exception
     */
    Map<String, String> selectUserIdAndNameMap(UserVO userVO) throws Exception;
}