package com.authorization.privilege.constant.menu;

/**
 * @author duxuebo
 * @date 2019/3/25
 * @description 菜单枚举集合接口
 */
public interface SysMenuEnumsInterface {

    /**
     * 菜单状态枚举集合
     */
    enum STATE implements SysMenuEnumsInterface {

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
                    return e.getName();
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


    /**
     * 菜单类型枚举集合
     */
    enum TYPE implements SysMenuEnumsInterface {

        TYPE_MENU("菜单", 1), TYPE_BUTTON("按钮", 2);

        private String name;
        private Integer intIndex;

        private TYPE(String name, Integer intIndex) {
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
            for (TYPE e : TYPE.values()) {
                if (e.getIntIndex().equals(intIndex)) {
                    return e.getName();
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


    /**
     * 菜单级别枚举集合
     */
    enum LEVEL implements SysMenuEnumsInterface {

        LEVEL_ONE("一级", 1);

        private String name;
        private Integer intIndex;

        private LEVEL(String name, Integer intIndex) {
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
            for (LEVEL e : LEVEL.values()) {
                if (e.getIntIndex().equals(intIndex)) {
                    return e.getName();
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
