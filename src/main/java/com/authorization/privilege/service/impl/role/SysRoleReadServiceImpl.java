package com.authorization.privilege.service.impl.role;

import com.authorization.privilege.mapper.dsprivilegeread.role.SysRoleReadMapper;
import com.authorization.privilege.service.role.SysRoleReadService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public ResultVO<PageVO<SysRoleVO>> selectSysRoleVOPage(SysRoleVO sysRoleVO) throws Exception {

        PageHelper.startPage(sysRoleVO.getCurrentPage(), sysRoleVO.getPageSize());
        List<SysRoleVO> sysRoleVOList = this.sysRoleReadMapper.selectSysRoleList(sysRoleVO);

        PageInfo<SysRoleVO> pageInfo = new PageInfo<>(sysRoleVOList);
        PageVO<SysRoleVO> pageVO = new PageVO<>(
                pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(),
                pageInfo.getPages(), pageInfo.getList()
        );

        return ResultVO.getSuccess("查询角色分页列表成功", pageVO);
    }
}
