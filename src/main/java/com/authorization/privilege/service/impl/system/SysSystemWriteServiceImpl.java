package com.authorization.privilege.service.impl.system;

import com.authorization.privilege.constant.system.SysSystemEnum;
import com.authorization.privilege.entity.dsprivelege.system.SysSystem;
import com.authorization.privilege.mapper.dsprivilegewrite.system.SysSystemWriteMapper;
import com.authorization.privilege.service.system.SysSystemWriteService;
import com.authorization.privilege.util.CommonUtil;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象写接口实现类
 */
@Service
public class SysSystemWriteServiceImpl implements SysSystemWriteService {

    @Autowired
    private SysSystemWriteMapper sysSystemWriteMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Void> saveSysSystem(SysSystemVO sysSystemVO) throws Exception {

        SysSystem sysSystem = new SysSystem();
        sysSystem.setSid(CommonUtil.generatorId());
        sysSystem.setSystemName(sysSystemVO.getSystemName());
        sysSystem.setSystemKey(sysSystemVO.getSystemKey());
        sysSystem.setDescription(sysSystemVO.getDescription());
        sysSystem.setCreateUid("0");
        sysSystem.setCreateTime(new Date());
        sysSystem.setState(SysSystemEnum.STATE_NORMAL.getIntValue());
        this.sysSystemWriteMapper.insertSelective(sysSystem);

        return ResultVO.getSuccess("新增系统成功");
    }
}
