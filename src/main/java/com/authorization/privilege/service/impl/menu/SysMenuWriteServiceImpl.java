package com.authorization.privilege.service.impl.menu;

import com.authorization.privilege.entity.dsprivelege.menu.SysMenu;
import com.authorization.privilege.mapper.dsprivilegewrite.menu.SysMenuWriteMapper;
import com.authorization.privilege.service.menu.SysMenuWriteService;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.menu.SysMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author duxuebo
 * @date 2019/1/26
 * @description 菜单写SERVICE接口实现类
 */
@Service
public class SysMenuWriteServiceImpl implements SysMenuWriteService {

    @Autowired
    private SysMenuWriteMapper sysMenuWriteMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Void> updateSysMenuVO(SysMenuVO sysMenuVO) throws Exception {

        SysMenu sysMenu = new SysMenu();
        sysMenu.setMid(sysMenuVO.getMid());
        sysMenu.setMenuName(sysMenuVO.getMenuName());
        sysMenu.setUrl(sysMenuVO.getUrl());
        sysMenu.setSort(sysMenuVO.getSort());
        sysMenu.setDescription(sysMenuVO.getDescription());
        sysMenu.setUpdateUid(sysMenuVO.getLoginUid());
        sysMenu.setUpdateTime(new Date());
        this.sysMenuWriteMapper.updateByPrimaryKeySelective(sysMenu);

        return ResultVO.getSuccess("修改菜单成功");
    }
}
