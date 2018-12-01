package com.authorization.privilege.util;

import java.util.UUID;

/**
 * 通用工具类
 */
public class CommonUtil {

    /**
     *  生成主键
     * @return 主键
     */
    public static String generatorId() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }


    public static void main(String[] args) {
        System.out.println(generatorId());
    }
}