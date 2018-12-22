package com.authorization.privilege.service.impl.user;

import com.authorization.privilege.mapper.dsprivilegewrite.user.UserWriteMapper;
import com.authorization.privilege.service.user.UserWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duxuebo
 * @date 2018/12/22
 * @description 用户写SERVICE接口实现类
 */
@Service
public class UserWriteServiceImpl implements UserWriteService {

    @Autowired
    private UserWriteMapper userWriteMapper;

}
