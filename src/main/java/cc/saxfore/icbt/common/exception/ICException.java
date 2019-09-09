package cc.saxfore.icbt.common.exception;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICException
 * 类 描 述：TODO
 * 创建时间：2019/8/11 11:54 AM
 * 创 建 人：wangjiang
 */
public class ICException extends RuntimeException {

    private int code;
    private String msg;

    public ICException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ICException(Throwable cause, int code, String msg) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public ICException(Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String msg) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.msg = msg;
    }

    public ICException(ICExceptionEnum exp) {
        super(exp.getMsg());
        this.code = exp.getCode();
        this.msg = exp.getMsg();
    }

}
