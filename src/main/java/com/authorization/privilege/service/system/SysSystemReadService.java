package com.authorization.privilege.service.system;

import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象读接口
 */
public interface SysSystemReadService {

    /**
     * 查询系统分页列表
     *
     * @param sysSystemVO
     * @return ResultVO
     * @throws Exception
     */
    ResultVO<PageVO<SysSystemVO>> selectSysSystemPage(SysSystemVO sysSystemVO) throws Exception;
}
