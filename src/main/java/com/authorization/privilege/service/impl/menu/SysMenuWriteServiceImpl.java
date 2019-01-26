package com.authorization.privilege.service.impl.menu;

import com.authorization.privilege.mapper.dsprivilegewrite.menu.SysMenuWriteMapper;
import com.authorization.privilege.service.menu.SysMenuWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duxuebo
 * @date 2019/1/26
 * @description 菜单写SERVICE接口实现类
 */
@Service
public class SysMenuWriteServiceImpl implements SysMenuWriteService {

    @Autowired
    private SysMenuWriteMapper sysMenuWriteMapper;


}
