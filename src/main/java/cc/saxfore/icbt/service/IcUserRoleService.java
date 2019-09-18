package cc.saxfore.icbt.service;

import cc.saxfore.icbt.common.entity.userrole.IcUserRole;
import cc.saxfore.icbt.common.entity.userrole.IcUserRoleExample;

import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/16 3:32 PM
 * 创 建 人：wangjiang
 */
public interface IcUserRoleService{


    long countByExample(IcUserRoleExample example);

    int deleteByExample(IcUserRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(IcUserRole record);

    int insertSelective(IcUserRole record);

    List<IcUserRole> selectByExample(IcUserRoleExample example);

    IcUserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(IcUserRole record,IcUserRoleExample example);

    int updateByExample(IcUserRole record,IcUserRoleExample example);

    int updateByPrimaryKeySelective(IcUserRole record);

    int updateByPrimaryKey(IcUserRole record);

    int updateBatch(List<IcUserRole> list);

    int batchInsert(List<IcUserRole> list);


}
