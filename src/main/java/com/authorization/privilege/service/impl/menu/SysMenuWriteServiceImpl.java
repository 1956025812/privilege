package com.authorization.privilege.service.impl.menu;

import com.authorization.privilege.constant.menu.SysMenuEnumsInterface;
import com.authorization.privilege.entity.dsprivelege.menu.SysMenu;
import com.authorization.privilege.mapper.dsprivilegeread.menu.SysMenuReadMapper;
import com.authorization.privilege.mapper.dsprivilegewrite.menu.SysMenuWriteMapper;
import com.authorization.privilege.service.menu.SysMenuWriteService;
import com.authorization.privilege.util.CommonUtil;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.menu.SysMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author duxuebo
 * @date 2019/1/26
 * @description 菜单写SERVICE接口实现类
 */
@Service
public class SysMenuWriteServiceImpl implements SysMenuWriteService {

    @Autowired
    private SysMenuWriteMapper sysMenuWriteMapper;

    @Autowired
    private SysMenuReadMapper sysMenuReadMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Void> saveSysMenuVO(SysMenuVO sysMenuVO) throws Exception {

        SysMenu sysMenu = new SysMenu();
        sysMenu.setMid(CommonUtil.generatorId());
        sysMenu.setSystemKey(sysMenuVO.getSystemKey());
        sysMenu.setMenuName(sysMenuVO.getMenuName());
        sysMenu.setType(sysMenuVO.getType());
        sysMenu.setUrl(sysMenuVO.getUrl());
        sysMenu.setLevel(sysMenuVO.getLevel());
        sysMenu.setSort(sysMenuVO.getSort());
        sysMenu.setDescription(sysMenuVO.getDescription());
        sysMenu.setLoginUid(sysMenuVO.getLoginUid());
        sysMenu.setCreateTime(LocalDateTime.now());
        sysMenu.setState(SysMenuEnumsInterface.STATE.STATE_NORMAL.getIntIndex());

        if (sysMenuVO.getLevel() >= SysMenuEnumsInterface.LEVEL.LEVEL_ONE.getIntIndex()) {
            sysMenu.setParentMid(sysMenuVO.getParentMid());
        }

        this.sysMenuWriteMapper.insertSelective(sysMenu);

        return ResultVO.getSuccess("新增菜单成功");
    }



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
        sysMenu.setUpdateTime(LocalDateTime.now());
        this.sysMenuWriteMapper.updateByPrimaryKeySelective(sysMenu);

        return ResultVO.getSuccess("修改菜单成功");
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Void> delSysMenuVO(SysMenuVO sysMenuVO) throws Exception {

        // 如果菜单下面有子菜单则不允许删除
        SysMenuVO newSysMenuVO = new SysMenuVO();
        newSysMenuVO.setParentMid(sysMenuVO.getMid());
        Integer count = this.sysMenuReadMapper.selectCountOfSysMenuList(newSysMenuVO);
        if (count > 0) {
            return ResultVO.getFailed("当前菜单有子菜单，不允许删除");
        }


        SysMenu sysMenu = new SysMenu();
        sysMenu.setMid(sysMenuVO.getMid());
        sysMenu.setState(SysMenuEnumsInterface.STATE.STATE_DEL.getIntIndex());
        sysMenu.setUpdateUid(sysMenuVO.getLoginUid());
        sysMenu.setUpdateTime(LocalDateTime.now());
        this.sysMenuWriteMapper.updateByPrimaryKeySelective(sysMenu);

        return ResultVO.getSuccess("删除菜单成功");
    }
}
