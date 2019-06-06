package com.authorization.privilege.excel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author qjwyss
 * @date 2019/3/15
 * @description
 */
public class ExcelWriteTest {


    /**
     * 针对较少的记录数(20W以内大概)可以调用该方法一次性查出然后写入到EXCEL的一个SHEET中
     * 注意： 一次性查询出来的记录数量不宜过大，不会内存溢出即可。
     *
     * @throws IOException
     */
    @Test
    public void writeExcelOneSheetOnceWrite() throws IOException {

        // 生成EXCEL并指定输出路径
        OutputStream out = new FileOutputStream("E:\\temp\\withoutHead1.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

        // 设置SHEET
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("sheet1");

        // 设置标题
        Table table = new Table(1);
        List<List<String>> titles = new ArrayList<List<String>>();
        titles.add(Arrays.asList("用户ID"));
        titles.add(Arrays.asList("名称"));
        titles.add(Arrays.asList("年龄"));
        titles.add(Arrays.asList("生日"));
        table.setHead(titles);

        // 查询数据导出即可 比如说一次性总共查询出100条数据
        List<List<String>> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            userList.add(Arrays.asList("ID_" + i, "小明" + i, String.valueOf(i), new Date().toString()));
        }

        writer.write0(userList, sheet, table);
        writer.finish();
    }



    /**
     * 针对105W以内的记录数可以调用该方法分多批次查出然后写入到EXCEL的一个SHEET中
     * 注意：
     * 每次查询出来的记录数量不宜过大，根据内存大小设置合理的每次查询记录数，不会内存溢出即可。
     * 数据量不能超过一个SHEET存储的最大数据量105W
     *
     * @throws IOException
     */
    @Test
    public void writeExcelOneSheetMoreWrite() throws IOException {

        // 生成EXCEL并指定输出路径
        OutputStream out = new FileOutputStream("E:\\temp\\100W.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

        // 设置SHEET
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("sheet1");

        // 设置标题
        Table table = new Table(1);
        List<List<String>> titles = new ArrayList<List<String>>();
        titles.add(Arrays.asList("用户ID"));
        titles.add(Arrays.asList("名称"));
        titles.add(Arrays.asList("年龄"));
        titles.add(Arrays.asList("生日"));
        table.setHead(titles);

        // 模拟分批查询：总记录数50条，每次查询20条，  分三次查询 最后一次查询记录数是10
        Integer totalRowCount = 1000000;
        Integer pageSize = 200000;
        Integer writeCount = totalRowCount % pageSize == 0 ? (totalRowCount / pageSize) : (totalRowCount / pageSize + 1);

        // 注： 此处仅仅为了模拟数据，实用环境不需要将最后一次分开，合成一个即可， 参数为： currentPage = i+1;  pageSize = pageSize
        for (int i = 0; i < writeCount; i++) {

            // 前两次查询 每次查20条数据
            if (i < writeCount - 1) {

                List<List<String>> userList = new ArrayList<>();
                for (int j = 0; j < pageSize; j++) {
                    userList.add(Arrays.asList("ID_" + (int)(1+Math.random()*(1000-1+1)), "小明", String.valueOf((int)(1+Math.random()*(1000-1+1))), new Date().toString()));
                }
                writer.write0(userList, sheet, table);

            } else if (i == writeCount - 1) {

                // 最后一次查询 查多余的10条记录
                List<List<String>> userList = new ArrayList<>();
                Integer lastWriteRowCount = totalRowCount - (writeCount - 1) * pageSize;
                for (int j = 0; j < lastWriteRowCount; j++) {
                    userList.add(Arrays.asList("ID_" + (int)(1+Math.random()*(1000-1+1)), "小明", String.valueOf((int)(1+Math.random()*(1000-1+1))), new Date().toString()));
                }
                writer.write0(userList, sheet, table);
            }
        }

        writer.finish();
    }



    /**
     * 针对几百万的记录数可以调用该方法分多批次查出然后写入到EXCEL的多个SHEET中
     * 注意：
     * perSheetRowCount % pageSize要能整除  为了简洁，非整除这块不做处理
     * 每次查询出来的记录数量不宜过大，根据内存大小设置合理的每次查询记录数，不会内存溢出即可。
     *
     * @throws IOException
     */
    @Test
    public void writeExcelMoreSheetMoreWrite() throws IOException {

        // 生成EXCEL并指定输出路径
        OutputStream out = new FileOutputStream("E:\\temp\\50W.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

        // 设置SHEET名称
        String sheetName = "测试SHEET";

        // 设置标题
        Table table = new Table(1);
        List<List<String>> titles = new ArrayList<List<String>>();
        titles.add(Arrays.asList("用户ID"));
        titles.add(Arrays.asList("名称"));
        titles.add(Arrays.asList("年龄"));
        titles.add(Arrays.asList("生日"));
        table.setHead(titles);

        // 模拟分批查询：总记录数250条，每个SHEET存100条，每次查询20条  则生成3个SHEET，前俩个SHEET查询次数为5， 最后一个SHEET查询次数为3 最后一次写的记录数是10
        // 注：该版本为了较少数据判断的复杂度，暂时perSheetRowCount要能够整除pageSize， 不去做过多处理  合理分配查询数据量大小不会内存溢出即可。
        Integer totalRowCount = 500000;
        Integer perSheetRowCount = 1000000;
        Integer pageSize = 20;
        Integer sheetCount = totalRowCount % perSheetRowCount == 0 ? (totalRowCount / perSheetRowCount) : (totalRowCount / perSheetRowCount + 1);
        Integer previousSheetWriteCount = perSheetRowCount / pageSize;
        Integer lastSheetWriteCount = totalRowCount % perSheetRowCount == 0 ?
                previousSheetWriteCount :
                (totalRowCount % perSheetRowCount % pageSize == 0 ? totalRowCount % perSheetRowCount / pageSize : (totalRowCount % perSheetRowCount / pageSize + 1));

        for (int i = 0; i < sheetCount; i++) {

            // 创建SHEET
            Sheet sheet = new Sheet(i, 0);
            sheet.setSheetName(sheetName + i);

            if (i < sheetCount - 1) {

                // 前2个SHEET, 每个SHEET查5次 每次查20条 每个SHEET写满100行  2个SHEET合计200行  实用环境：参数： currentPage: j+1 + previousSheetWriteCount*i, pageSize: pageSize
                for (int j = 0; j < previousSheetWriteCount; j++) {
                    List<List<String>> userList = new ArrayList<>();
                    for (int k = 0; k < 20; k++) {
                        userList.add(Arrays.asList("ID_" + Math.random(), "小明", String.valueOf(Math.random()), new Date().toString()));
                    }
                    writer.write0(userList, sheet, table);
                }

            } else if (i == sheetCount - 1) {

                // 最后一个SHEET 实用环境不需要将最后一次分开，合成一个即可， 参数为： currentPage = i+1;  pageSize = pageSize
                for (int j = 0; j < lastSheetWriteCount; j++) {

                    // 前俩次查询 每次查询20条
                    if (j < lastSheetWriteCount - 1) {

                        List<List<String>> userList = new ArrayList<>();
                        for (int k = 0; k < 20; k++) {
                            userList.add(Arrays.asList("ID_" + Math.random(), "小明", String.valueOf(Math.random()), new Date().toString()));
                        }
                        writer.write0(userList, sheet, table);

                    } else if (j == lastSheetWriteCount - 1) {

                        // 最后一次查询 将剩余的10条查询出来
                        List<List<String>> userList = new ArrayList<>();
                        Integer lastWriteRowCount = totalRowCount - (sheetCount - 1) * perSheetRowCount - (lastSheetWriteCount - 1) * pageSize;
                        for (int k = 0; k < lastWriteRowCount; k++) {
                            userList.add(Arrays.asList("ID_" + Math.random(), "小明1", String.valueOf(Math.random()), new Date().toString()));
                        }
                        writer.write0(userList, sheet, table);

                    }
                }
            }
        }

        writer.finish();
    }



}
