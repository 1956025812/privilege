package com.authorization.privilege.constant.system;

/**
 * @author duxuebo
 * @date 2019/3/25
 * @description 系统枚举集合接口
 */
public interface SysSystemEnumInterface {

    /**
     * 系统状态枚举集合
     */
    enum STATE implements SysSystemEnumInterface {

        STATE_DEL("删除", 0), STATE_NORMAL("正常", 1);

        private String name;
        private Integer intIndex;

        private STATE(String name, Integer intIndex) {
            this.name = name;
            this.intIndex = intIndex;
        }

        /**
         * 根据整型索引得到对应的名称
         *
         * @param intIndex
         * @return 名称
         */
        public static String getName(Integer intIndex) {
            for (STATE e : STATE.values()) {
                if (e.getIntIndex().equals(intIndex)) {
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
    }



}
