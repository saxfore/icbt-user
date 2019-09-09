package cc.saxfore.icbt.common.entity;

import cc.saxfore.icbt.common.IConst;
import cc.saxfore.icbt.common.util.ICStringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目名称：icbt-user
 * 类 名 称：IcBaseEntity
 * 类 描 述：TODO
 * 创建时间：2019/9/6 5:23 PM
 * 创 建 人：wangjiang
 */
public class IcBaseEntity implements Serializable {

    protected String id;
    protected String delFlag;
    protected String createUser;
    protected Date createTime;
    protected String updateUser;
    protected Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setBaseInfo() {
        if (ICStringUtil.isBlank(this.id)) {
            this.id = ICStringUtil.generalID();
        }
        if (ICStringUtil.isBlank(this.createUser)) {
            this.createUser = IConst.ENTITY_DEFAULT_OPERATOR;
        }
        if (ICStringUtil.isBlank(this.updateUser)) {
            this.updateUser = IConst.ENTITY_DEFAULT_OPERATOR;
        }
        if (this.createTime == null) {
            this.createTime = new Date();
        }
        if (this.updateTime == null) {
            this.updateTime = new Date();
        }
    }

}
