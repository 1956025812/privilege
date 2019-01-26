package com.authorization.privilege.service.impl.menu;

import com.authorization.privilege.service.menu.SysMenuReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duxuebo
 * @date 2019/1/26
 * @description 菜单读SERVICE接口实现类
 */
@Service
public class SysMenuReadServiceImpl implements SysMenuReadService {

    @Autowired
    private SysMenuReadService sysMenuReadService;

}
