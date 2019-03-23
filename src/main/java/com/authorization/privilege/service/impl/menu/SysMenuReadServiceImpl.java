package com.authorization.privilege.service.impl.menu;

import com.authorization.privilege.constant.menu.SysMenuEnum;
import com.authorization.privilege.entity.dsprivelege.menu.SysMenu;
import com.authorization.privilege.entity.dsprivelege.system.SysSystem;
import com.authorization.privilege.mapper.dsprivilegeread.menu.SysMenuReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.system.SysSystemReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.user.UserReadMapper;
import com.authorization.privilege.service.menu.SysMenuReadService;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.menu.SysMenuVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import com.authorization.privilege.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duxuebo
 * @date 2019/1/26
 * @description 菜单读SERVICE接口实现类
 */
@Service
public class SysMenuReadServiceImpl implements SysMenuReadService {

    @Autowired
    private SysMenuReadMapper sysMenuReadMapper;

    @Autowired
    private UserReadMapper userReadMapper;

    @Autowired
    private SysSystemReadMapper sysSystemReadMapper;

    @Override
    public ResultVO<List<SysMenuVO>> selectSysMenuVOList(SysMenuVO sysMenuVO) throws Exception {

        // 查询菜单列表集合
        List<SysMenuVO> sysMenuVOList = this.sysMenuReadMapper.selectSysMenuVOList(sysMenuVO);

        if (!CollectionUtils.isEmpty(sysMenuVOList)) {

            // 查询所有的系统key和对应的系统VO对象MAP
            HashMap<String, SysSystemVO> systemKeyAndSystemVOMap = this.sysSystemReadMapper.selectSystemKeyAndSystemVOMap(new SysSystemVO());

            sysMenuVOList.forEach(eachSysMenuVO -> {

                // 处理菜单类型冗余字段
                eachSysMenuVO.setMenuTypeName(SysMenuEnum.getName(eachSysMenuVO.getType()));

                // 处理系统名称冗余字段
                eachSysMenuVO.setSystemName(CollectionUtils.isEmpty(systemKeyAndSystemVOMap) ? null :
                        (systemKeyAndSystemVOMap.get(eachSysMenuVO.getSystemKey()) == null ? null :
                                systemKeyAndSystemVOMap.get(eachSysMenuVO.getSystemKey()).getSystemName())
                );
            });
        }

        return ResultVO.getSuccess("查询菜单列表成功", sysMenuVOList);
    }


    @Override
    public ResultVO<SysMenuVO> selectSysMenuVODetail(SysMenuVO sysMenuVO) throws Exception {

        SysMenuVO detailSysMenuVO = this.sysMenuReadMapper.selectSysMenuVODetail(sysMenuVO);

        if (null != detailSysMenuVO) {

            // 处理菜单类型名称
            detailSysMenuVO.setMenuTypeName(SysMenuEnum.getName(detailSysMenuVO.getType()));

            // 处理创建人昵称和修改人昵称字段
            UserVO userVO = new UserVO();
            Map<String, UserVO> userIdAndUserVOMap = this.userReadMapper.selectUserIdAndUserVOMap(userVO);
            if (!CollectionUtils.isEmpty(userIdAndUserVOMap)) {
                UserVO createUserVO = userIdAndUserVOMap.get(detailSysMenuVO.getCreateUid());
                UserVO updateUserVO = userIdAndUserVOMap.get(detailSysMenuVO.getUpdateUid());
                detailSysMenuVO.setCreateName(createUserVO == null ? null : createUserVO.getNickname());
                detailSysMenuVO.setUpdateName(updateUserVO == null ? null : updateUserVO.getNickname());
            }

            // 处理系统名称字段
            SysSystem sysSystem = this.sysSystemReadMapper.selectByPrimaryKey(detailSysMenuVO.getSystemId());
            detailSysMenuVO.setSystemName(sysSystem == null ? null : sysSystem.getSystemName());

            // 如果是二级以下菜单，则处理上级菜单名称
            if (!SysMenuEnum.MENU_LEVEL_ONE.getIntIndex().equals(detailSysMenuVO.getLevel())) {
                SysMenu parentSysMenu = this.sysMenuReadMapper.selectByPrimaryKey(detailSysMenuVO.getParentMid());
                detailSysMenuVO.setParentMenuName(parentSysMenu == null ? null : parentSysMenu.getMenuName());
            }
        }

        return ResultVO.getSuccess("查询菜单详情成功", detailSysMenuVO);
    }
}
