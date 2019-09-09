package cc.saxfore.icbt.common.exception;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICExceptionEnum
 * 类 描 述：TODO
 * 创建时间：2019/8/11 12:02 PM
 * 创 建 人：wangjiang
 */
public enum ICExceptionEnum {

    UserNotFound(501, "用户不存在"),
    UserIsForzen(502, "该用户已被冻结"),
    UserISRetistered(503, "用户名已被注册");

    private int code;
    private String msg;

    private ICExceptionEnum(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
