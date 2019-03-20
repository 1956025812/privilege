package com.authorization.privilege.constant.system;

/**
 * @author duxuebo
 * @date 2018/12/4
 * @description 系统对象枚举类
 */
public enum SysSystemEnum {

    STATE_DEL("删除", 0), STATE_NORMAL("正常", 1);

    private String name;
    private Integer intIndex;
    private String stringIndex;

    private SysSystemEnum(String name, Integer intIndex) {
        this.name = name;
        this.intIndex = intIndex;
    }

    private SysSystemEnum(String name, String stringIndex) {
        this.name = name;
        this.stringIndex = stringIndex;
    }


    /**
     * 根据整型索引得到对应的名称
     *
     * @param intIndex
     * @return 名称
     */
    public static String getName(Integer intIndex) {
        for (SysSystemEnum e : SysSystemEnum.values()) {
            if (e.getIntIndex().equals(intIndex)) {
                return e.name;
            }
        }
        return null;
    }


    /**
     * 根据字符串型索引得到对应的名称
     *
     * @param stringIndex
     * @return 名称
     */
    public static String getName(String stringIndex) {
        for (SysSystemEnum e : SysSystemEnum.values()) {
            if (e.getStringIndex().equals(stringIndex)) {
                return e.name;
            }
        }
        return null;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIntIndex() {
        return intIndex;
    }

    public void setIntIndex(Integer intIndex) {
        this.intIndex = intIndex;
    }

    public String getStringIndex() {
        return stringIndex;
    }

    public void setStringIndex(String stringIndex) {
        this.stringIndex = stringIndex;
    }
}
