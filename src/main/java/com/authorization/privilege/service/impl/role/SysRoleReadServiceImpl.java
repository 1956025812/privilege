package com.authorization.privilege.service.impl.role;

import com.authorization.privilege.constant.role.SysRoleEnumsInterface;
import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.authorization.privilege.mapper.dsprivilegeread.role.RoleMenuReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.role.SysRoleReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.system.SysSystemReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.user.UserReadMapper;
import com.authorization.privilege.service.role.SysRoleReadService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import com.authorization.privilege.vo.user.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色读SERVICE接口实现类
 */
@Service
public class SysRoleReadServiceImpl implements SysRoleReadService {

    @Autowired
    private SysRoleReadMapper sysRoleReadMapper;

    @Autowired
    private SysSystemReadMapper sysSystemReadMapper;

    @Autowired
    private UserReadMapper userReadMapper;

    @Autowired
    private RoleMenuReadMapper roleMenuReadMapper;


    @Override
    public ResultVO<PageVO<SysRoleVO>> selectSysRoleVOPage(SysRoleVO sysRoleVO) throws Exception {

        PageHelper.startPage(sysRoleVO.getCurrentPage(), sysRoleVO.getPageSize());
        List<SysRoleVO> sysRoleVOList = this.sysRoleReadMapper.selectSysRoleList(sysRoleVO);

        if (!CollectionUtils.isEmpty(sysRoleVOList)) {

            HashMap<String, SysSystemVO> systemKeyAndSystemVOMap = this.sysSystemReadMapper.selectSystemKeyAndSystemVOMap(new SysSystemVO());
            HashMap<String, UserVO> userIdAndUserVOMap = this.userReadMapper.selectUserIdAndUserVOMap(new UserVO());
            HashMap<String, SysRoleVO> roleIdAndRoleVOMap = this.sysRoleReadMapper.selectRoleIdAndRoleVOMap(new SysRoleVO());

            sysRoleVOList.forEach(eachSysRoleVO -> {

                // 处理所属系统冗余字段
                eachSysRoleVO.setSystemName(CollectionUtils.isEmpty(systemKeyAndSystemVOMap) ? null :
                        (systemKeyAndSystemVOMap.get(eachSysRoleVO.getSystemKey()) == null ? null :
                                systemKeyAndSystemVOMap.get(eachSysRoleVO.getSystemKey()).getSystemName())
                );

                // 处理上级角色冗余字段
                eachSysRoleVO.setParentRoleName(CollectionUtils.isEmpty(roleIdAndRoleVOMap) ? null :
                        (roleIdAndRoleVOMap.get(eachSysRoleVO.getParentRid()) == null ? null :
                                roleIdAndRoleVOMap.get(eachSysRoleVO.getParentRid()).getRoleName()));

                // 处理创建人冗余字段
                eachSysRoleVO.setCreateName(CollectionUtils.isEmpty(userIdAndUserVOMap) ? null :
                        (userIdAndUserVOMap.get(eachSysRoleVO.getCreateUid()) == null ? null :
                                userIdAndUserVOMap.get(eachSysRoleVO.getCreateUid()).getNickname()));

                // 处理状态名称冗余字段
                eachSysRoleVO.setRoleStateName(SysRoleEnumsInterface.State.getName(eachSysRoleVO.getState()));

            });
        }

        PageInfo<SysRoleVO> pageInfo = new PageInfo<>(sysRoleVOList);
        PageVO<SysRoleVO> pageVO = new PageVO<>(
                pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(),
                pageInfo.getPages(), pageInfo.getList()
        );

        return ResultVO.getSuccess("查询角色分页列表成功", pageVO);
    }



    @Override
    public ResultVO<List<SysRoleVO>> selectSysRoleVOList(SysRoleVO sysRoleVO) throws Exception {

        List<SysRoleVO> sysRoleList = this.sysRoleReadMapper.selectSysRoleList(sysRoleVO);
        return ResultVO.getSuccess("查询角色列表成功", sysRoleList);
    }



    @Override
    public ResultVO<SysRoleVO> selectSysRoleVODetail(SysRoleVO sysRoleVO) throws Exception {

        SysRoleVO sysRoleVODetail = this.sysRoleReadMapper.selectSysRoleVO(sysRoleVO);

        if (null != sysRoleVODetail) {

            // 处理系统名称
            SysSystemVO sysSystemVO = new SysSystemVO();
            sysSystemVO.setSystemKey(sysRoleVODetail.getSystemKey());
            SysSystemVO sysSystemVODetail = this.sysSystemReadMapper.selectSysSystemVODetail(sysSystemVO);
            sysRoleVODetail.setSystemName(sysSystemVODetail == null ? null : sysSystemVODetail.getSystemName());

            // 处理上级角色名称
            if (StringUtils.isNotEmpty(sysRoleVODetail.getParentRid())) {
                SysRole parentSysRole = this.sysRoleReadMapper.selectByPrimaryKey(sysRoleVODetail.getParentRid());
                sysRoleVODetail.setParentRoleName(parentSysRole == null ? null : parentSysRole.getRoleName());
            }

            // 处理创建人名称和修改人名称
            HashMap<String, UserVO> userIdAndUserVOMap = this.userReadMapper.selectUserIdAndUserVOMap(new UserVO());
            sysRoleVODetail.setCreateName(CollectionUtils.isEmpty(userIdAndUserVOMap) ? null :
                    (userIdAndUserVOMap.get(sysRoleVODetail.getCreateUid()) == null ? null :
                            userIdAndUserVOMap.get(sysRoleVODetail.getCreateUid()).getNickname())
            );
            sysRoleVODetail.setUpdateName(CollectionUtils.isEmpty(userIdAndUserVOMap) ? null :
                    (userIdAndUserVOMap.get(sysRoleVODetail.getUpdateUid()) == null ? null :
                            userIdAndUserVOMap.get(sysRoleVODetail.getUpdateUid()).getNickname())
            );

            // 处理菜单列表


        }

        return ResultVO.getSuccess("查询角色详情成功", sysRoleVODetail);
    }
}
