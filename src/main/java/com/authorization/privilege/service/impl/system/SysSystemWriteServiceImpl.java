package com.authorization.privilege.service.impl.system;

import com.authorization.privilege.constant.system.SysSystemEnum;
import com.authorization.privilege.entity.dsprivelege.system.SysSystem;
import com.authorization.privilege.mapper.dsprivilegeread.system.SysSystemReadMapper;
import com.authorization.privilege.mapper.dsprivilegewrite.system.SysSystemWriteMapper;
import com.authorization.privilege.service.system.SysSystemWriteService;
import com.authorization.privilege.util.CommonUtil;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象写接口实现类
 */
@Service
public class SysSystemWriteServiceImpl implements SysSystemWriteService {

    @Autowired
    private SysSystemWriteMapper sysSystemWriteMapper;

    @Autowired
    private SysSystemReadMapper sysSystemReadMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Void> saveSysSystem(SysSystemVO sysSystemVO) throws Exception {

        SysSystem sysSystem = new SysSystem();
        sysSystem.setSid(CommonUtil.generatorId());
        sysSystem.setSystemName(sysSystemVO.getSystemName());
        sysSystem.setSystemKey(sysSystemVO.getSystemKey());
        sysSystem.setDescription(sysSystemVO.getDescription());
        sysSystem.setCreateUid(sysSystemVO.getLoginUid());
        sysSystem.setCreateTime(LocalDateTime.now());
        sysSystem.setState(SysSystemEnum.STATE_NORMAL.getIntIndex());
        this.sysSystemWriteMapper.insertSelective(sysSystem);

        return ResultVO.getSuccess("新增系统成功");
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Void> updateSysSystem(SysSystemVO sysSystemVO) throws Exception {

        // 根据主键查询系统对象
        SysSystem sysSystem = this.sysSystemReadMapper.selectByPrimaryKey(sysSystemVO.getSid());
        if (null == sysSystem) {
            return ResultVO.getFailed("系统对象不存在，无法修改");
        }

        // 修改系统对象
        sysSystem.setSystemName(sysSystemVO.getSystemName());
        sysSystem.setDescription(sysSystemVO.getDescription());
        sysSystem.setUpdateUid(sysSystemVO.getLoginUid());
        sysSystem.setUpdateTime(LocalDateTime.now());
        this.sysSystemWriteMapper.updateByPrimaryKey(sysSystem);

        return ResultVO.getSuccess("修改系统成功");
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Void> delSysSystem(SysSystemVO sysSystemVO) throws Exception {

        SysSystemVO newSysSystemVO = new SysSystemVO();
        newSysSystemVO.setSid(sysSystemVO.getSid());
        newSysSystemVO.setSids(sysSystemVO.getSids());
        newSysSystemVO.setState(SysSystemEnum.STATE_DEL.getIntIndex());
        newSysSystemVO.setUpdateUid(sysSystemVO.getLoginUid());
        newSysSystemVO.setUpdateTime(LocalDateTime.now());
        this.sysSystemWriteMapper.delSysSystem(newSysSystemVO);

        return ResultVO.getSuccess("删除系统成功");
    }
}
