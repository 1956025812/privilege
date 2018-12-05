package com.authorization.privilege.service.impl.system;

import com.authorization.privilege.constant.system.SysSystemEnum;
import com.authorization.privilege.mapper.dsprivilegeread.system.SysSystemReadMapper;
import com.authorization.privilege.service.system.SysSystemReadService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象读接口实现类
 */
@Service
public class SysSystemReadServiceImpl implements SysSystemReadService {

    @Autowired
    private SysSystemReadMapper sysSystemReadMapper;


    @Override
    public ResultVO<PageVO<SysSystemVO>> selectSysSystemPage(SysSystemVO sysSystemVO) throws Exception {

        PageHelper.startPage(sysSystemVO.getCurrentPage(), sysSystemVO.getPageSize());
        sysSystemVO.setState(SysSystemEnum.STATE_NORMAL.getIntValue());
        List<SysSystemVO> sysSystemVOList = this.sysSystemReadMapper.selectSysSystemPage(sysSystemVO);
        PageInfo<SysSystemVO> pageInfo = new PageInfo<>(sysSystemVOList);

        PageVO<SysSystemVO> pageVO = new PageVO<>(
                pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(),
                pageInfo.getPages(), pageInfo.getList()
        );

        return ResultVO.getSuccess("查询系统分页列表成功", pageVO);
    }
}




