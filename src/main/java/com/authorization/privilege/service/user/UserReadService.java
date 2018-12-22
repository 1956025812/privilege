package com.authorization.privilege.service.user;

import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.user.UserVO;

/**
 * @author duxuebo
 * @date 2018/12/22
 * @description 用户读SERVICE接口
 */
public interface UserReadService {


    /**
     * 查询用户VO对象
     *
     * @param userVO
     * @return UserVO
     * @throws Exception
     */
    ResultVO<UserVO> selectUserVO(UserVO userVO) throws Exception;
}
