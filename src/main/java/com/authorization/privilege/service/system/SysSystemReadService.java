package com.authorization.privilege.service.system;

import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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


    /**
     * 查询系统对象详情
     *
     * @param sysSystemVO
     * @return SysSystemVO
     * @throws Exception
     */
    ResultVO<SysSystemVO> selectSysSystemVODetail(SysSystemVO sysSystemVO) throws Exception;


    /**
     * 查询系统列表
     *
     * @param sysSystemVO
     * @return SysSystemVO集合
     * @throws Exception
     */
    ResultVO<List<SysSystemVO>> selectSysSystemVOList(SysSystemVO sysSystemVO) throws Exception;


    /**
     * 导出系统列表EXCEL
     *
     * @param sysSystemVO
     * @param response
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> exportSysSystemExcel(SysSystemVO sysSystemVO, HttpServletResponse response) throws Exception;
}
