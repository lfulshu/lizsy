package com.yx.common;

/**
 * @author liizzz
 * @start 2019-09-26 9:15
 * <p>
 * 枚举类
 * enum定义的类默认继承java.lang.Enum类，而不是Object类
 * 同时枚举类不能派生子类（类的默认修饰符为private）
 * <p>
 * 所谓枚举类就是有包含有固定数量实例（并且实例的值也固定）的特殊类，如果其含有public构造器，
 * 那么在类的外部就可以通过这个构造器来新建实例，显然这时实例的数量和值就不固定了，这与定义枚举类的初衷相矛盾，
 * 为了避免这种形象，就对枚举类的构造器默认使用private修饰。如果为枚举类的构造器显式指定其它访问控制符，则会编译出错。
 * <p>
 * 注意枚举类的所有实例必须在其首行显式列出，否则它不能产生实例
 */
public enum ResponseCode {

    SUCCESS(1, "success"),
    ERROR(-1, "error"),
    NEED_LOGIN(10, "need_login"),
    ILLEAGAL_ARGUMENT(100, "illegal_argument");

    private int code;
    private String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
