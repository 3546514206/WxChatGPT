package edu.zjnu.weChat.utils.enums.parameters;

/**
 * UUID
 * <p>
 */
public enum UUIDParaEnum {

    APP_ID("appid", "wx782c26e4c19acffb"),
    FUN("fun", "new"),
    LANG("lang", "zh_CN"),
    _("_", "时间戳");

    private String para;
    private String value;

    UUIDParaEnum(String para, String value) {
        this.para = para;
        this.value = value;
    }

    public String para() {
        return para;
    }

    public String value() {
        return value;
    }
}
