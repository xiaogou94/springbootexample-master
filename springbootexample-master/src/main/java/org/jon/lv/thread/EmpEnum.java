package org.jon.lv.thread;

import lombok.Getter;

public enum EmpEnum {
    ONE(1, "刘一"),
    TWO(2, "陈二"),
    THREE(3, "张三"),
    FOUR(4, "李四"),
    FIVE(5, "王五"),
    SIX(6, "赵六"),
    SEVEN(7, "孙七"),
    EIGHT(8, "周八"),
    NINE(9, "吴九"),
    TEN(10, "郑十");

    @Getter
    private int code;//员工编号
    @Getter
    private String name;//员工名称

    EmpEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static EmpEnum forEach(int index) {
        EmpEnum[] EmpEnums = EmpEnum.values();
        for (EmpEnum epmEnum : EmpEnums) {
            if (index == epmEnum.getCode()) {
                return epmEnum;
            }
        }
        return null;
    }

}
