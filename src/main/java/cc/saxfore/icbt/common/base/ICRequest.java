package cc.saxfore.icbt.common.base;

import java.io.Serializable;

/**
 * 项目名称：icbt-user
 * 类 名 称：ICResponse
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:21 PM
 * 创 建 人：wangjiang
 */
public class ICRequest<T> implements Serializable {

    protected ICReqHeader header;
    protected T body;

    public ICReqHeader getHeader() {
        return header;
    }

    public void setHeader(ICReqHeader header) {
        this.header = header;
    }



    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
