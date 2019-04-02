package com.authorization.privilege.constant.role;

/**
 * @author duxuebo
 * @date 2019/4/2
 * @description 角色枚举常量接口集合
 */
public interface SysRoleEnumsInterface {

    enum State implements SysRoleEnumsInterface {

        DEL("删除", 0), START("启用", 1), STOP("禁用", 2);

        private String name;
        private Integer intIndex;

        State(String name, Integer intIndex) {
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
            for (State e : State.values()) {
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
