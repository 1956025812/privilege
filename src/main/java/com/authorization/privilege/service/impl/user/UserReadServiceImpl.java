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
    public ResultVO<UserVO> denglu(UserVO userVO) throws Exception {

        ResultVO resultVO = null;

        UserVO newUserVO = this.userReadMapper.selectUserVO(userVO);
        if (null != newUserVO) {
            resultVO = ResultVO.getSuccess("查询用户成功", newUserVO);
        } else {
            resultVO = ResultVO.getFailed("账号或密码错误，请重新输入");
        }

        return resultVO;
    }
}
