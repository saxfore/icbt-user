package cc.saxfore.icbt.common.entity;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/16 3:28 PM
 * 创 建 人：wangjiang
 */
public class IcRole extends IcBaseEntity {
    private String roleName;

    private String roleDesc;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}