package cc.saxfore.icbt.mapper;

import cc.saxfore.icbt.common.entity.IcUserRole;

import java.util.List;

import cc.saxfore.icbt.common.entity.example.IcUserRoleExample;
import org.apache.ibatis.annotations.Param;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/16 3:32 PM
 * 创 建 人：wangjiang
 */
public interface IcUserRoleMapper {
    long countByExample(IcUserRoleExample example);

    int deleteByExample(IcUserRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(IcUserRole record);

    int insertSelective(IcUserRole record);

    List<IcUserRole> selectByExample(IcUserRoleExample example);

    IcUserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IcUserRole record, @Param("example") IcUserRoleExample example);

    int updateByExample(@Param("record") IcUserRole record, @Param("example") IcUserRoleExample example);

    int updateByPrimaryKeySelective(IcUserRole record);

    int updateByPrimaryKey(IcUserRole record);

    int updateBatch(List<IcUserRole> list);

    int batchInsert(@Param("list") List<IcUserRole> list);
}