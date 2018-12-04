package com.authorization.privilege.constant.system;

/**
 * @author duxuebo
 * @date 2018/12/4
 * @description 系统对象枚举类
 */
public enum SysSystemEnum {

    STATE_DEL("删除", 0), STATE_NORMAL("正常", 1);

    private String name;
    private Integer intValue;
    private String stringValue;

    private SysSystemEnum(String name, Integer intValue) {
        this.name = name;
        this.intValue = intValue;
    }

    private SysSystemEnum(String name, String stringValue) {
        this.name = name;
        this.stringValue = stringValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
