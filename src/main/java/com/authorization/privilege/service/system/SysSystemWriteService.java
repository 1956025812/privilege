package com.authorization.privilege.service.system;

import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象写接口
 */
public interface SysSystemWriteService {


    /**
     * 新增系统
     *
     * @param sysSystemVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> saveSysSystem(SysSystemVO sysSystemVO) throws Exception;


    /**
     * 修改系统
     *
     * @param sysSystemVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> updateSysSystem(SysSystemVO sysSystemVO) throws Exception;


    /**
     * 删除系统
     *
     * @param sysSystemVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> delSysSystem(SysSystemVO sysSystemVO) throws Exception;
}
