package com.authorization.privilege.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qjwyss
 * @date 2019/5/31
 * @description
 */
public class ExcelReadTest {

    private Logger logger = LoggerFactory.getLogger(ExcelReadTest.class);


    @Test
    public void readExcelTest() throws Exception {

       /* InputStream inputStream = new FileInputStream(new File("E:\\temp\\7.xlsx"));

        System.out.println("开始读取");

        List<User> dataList = new ArrayList<User>();

        EasyExcelFactory.readBySax(inputStream, new Sheet(1,1), new AnalysisEventListener() {

            @Override
            public void invoke(Object object, AnalysisContext analysisContext) {

                logger.info("当前行：{} 对应的对象信息为：{}", analysisContext.getCurrentRowNum(), object);

                ArrayList userObj = (ArrayList) object;
                User user = new User();
                user.setUid(userObj.get(0) == null ? null : userObj.get(0).toString());
                user.setName(userObj.get(1) == null ? null : userObj.get(1).toString());
                user.setAge(userObj.get(2) == null ? null : Integer.valueOf(userObj.get(2).toString()));
                dataList.add(user);

                // 每批插入的数量
                int perReadCount = 5;
                Integer currentRowNum = analysisContext.getCurrentRowNum();
                if (currentRowNum % perReadCount == 0) {
                    logger.info("存储dataList的大小为：{}",dataList.size());
                    dataList.clear();
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                logger.info("最后一批存储dataList的大小为：{}",dataList.size());
                dataList.clear();//解析结束销毁不用的资源
            }
        });

        System.out.println("读取完毕");*/
    }

}
