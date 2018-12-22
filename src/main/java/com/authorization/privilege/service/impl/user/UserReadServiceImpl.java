package com.authorization.privilege.service.impl.user;

import com.authorization.privilege.mapper.dsprivilegeread.user.UserReadMapper;
import com.authorization.privilege.service.user.UserReadService;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duxuebo
 * @date 2018/12/22
 * @description 用户读SERVICE接口实现类
 */
@Service
public class UserReadServiceImpl implements UserReadService {

    @Autowired
    private UserReadMapper userReadMapper;


    @Override
    public ResultVO<UserVO> selectUserVO(UserVO userVO) throws Exception {

        UserVO newUserVO = this.userReadMapper.selectUserVO(userVO);
        return ResultVO.getSuccess("查询用户成功", newUserVO);
    }
}
