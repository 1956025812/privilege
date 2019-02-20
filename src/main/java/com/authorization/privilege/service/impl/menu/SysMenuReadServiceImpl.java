package com.authorization.privilege.service.impl.menu;

import com.authorization.privilege.mapper.dsprivilegeread.menu.SysMenuReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.system.SysSystemReadMapper;
import com.authorization.privilege.service.menu.SysMenuReadService;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.menu.SysMenuVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

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
    private SysSystemReadMapper sysSystemReadMapper;


    @Override
    public ResultVO<List<SysMenuVO>> selectSysMenuVOList(SysMenuVO sysMenuVO) throws Exception {

        // 查询菜单列表集合
        List<SysMenuVO> sysMenuVOList = this.sysMenuReadMapper.selectSysMenuVOList(sysMenuVO);

        return ResultVO.getSuccess("查询菜单列表成功", sysMenuVOList);
    }
}
