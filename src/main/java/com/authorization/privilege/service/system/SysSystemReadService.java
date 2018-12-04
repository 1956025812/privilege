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
     * @return PageVO
     * @throws Exception
     */
    ResultVO<PageVO<SysSystemVO>> selectSysSystemPage(SysSystemVO sysSystemVO) throws Exception;


    /**
     * 查询系统对象详情
     *
     * @param sysSystemVO
     * @return SysSystemVO
     * @throws Exception
     */
    ResultVO<SysSystemVO> selectSysSystemVODetail(SysSystemVO sysSystemVO) throws Exception;
}
