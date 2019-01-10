package com.authorization.privilege.service.impl.system;

import com.authorization.privilege.constant.system.SysSystemEnum;
import com.authorization.privilege.mapper.dsprivilegeread.system.SysSystemReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.user.UserReadMapper;
import com.authorization.privilege.service.system.SysSystemReadService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import com.authorization.privilege.vo.user.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    private UserReadMapper userReadMapper;


    @Override
    public ResultVO<PageVO<SysSystemVO>> selectSysSystemPage(SysSystemVO sysSystemVO) throws Exception {

        // 查询用户ID和名称列表
        UserVO userVO = new UserVO();
        List<UserVO> userIdAndNameList = this.userReadMapper.selectUserIdAndNameList(userVO);

        // 查询系统分页列表
        PageHelper.startPage(sysSystemVO.getCurrentPage(), sysSystemVO.getPageSize());
        List<SysSystemVO> sysSystemVOList = this.sysSystemReadMapper.selectSysSystemPage(sysSystemVO);


        // 处理列表冗余字段
        if (!CollectionUtils.isEmpty(sysSystemVOList)) {
            for (SysSystemVO eachSysSystemVO : sysSystemVOList) {

                // 处理创建人名称
                String createUid = eachSysSystemVO.getCreateUid();
                if (!CollectionUtils.isEmpty(userIdAndNameList)) {
                    for (UserVO eachUserVO : userIdAndNameList) {
                        if (createUid.equals(eachUserVO.getUid())) {
                            eachSysSystemVO.setCreateName(eachUserVO.getNickname());
                            break;
                        }
                    }
                }
            }
        }


        // 封装返回分页对象
        PageInfo<SysSystemVO> pageInfo = new PageInfo<>(sysSystemVOList);
        PageVO<SysSystemVO> pageVO = new PageVO<>(
                pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(),
                pageInfo.getPages(), pageInfo.getList()
        );

        return ResultVO.getSuccess("查询系统分页列表成功", pageVO);
    }


    @Override
    public ResultVO<SysSystemVO> selectSysSystemVODetail(SysSystemVO sysSystemVO) throws Exception {

        SysSystemVO newSysSystemVO = this.sysSystemReadMapper.selectSysSystemVODetail(sysSystemVO);
        return ResultVO.getSuccess("查询系统对象详情成功", newSysSystemVO);
    }
}




