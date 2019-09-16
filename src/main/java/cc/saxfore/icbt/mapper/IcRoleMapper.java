package cc.saxfore.icbt.mapper;

import cc.saxfore.icbt.common.entity.IcRole;
import cc.saxfore.icbt.common.entity.example.IcRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/16 3:28 PM
 * 创 建 人：wangjiang
 */
public interface IcRoleMapper {
    long countByExample(IcRoleExample example);

    int deleteByExample(IcRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(IcRole record);

    int insertSelective(IcRole record);

    List<IcRole> selectByExample(IcRoleExample example);

    IcRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IcRole record, @Param("example") IcRoleExample example);

    int updateByExample(@Param("record") IcRole record, @Param("example") IcRoleExample example);

    int updateByPrimaryKeySelective(IcRole record);

    int updateByPrimaryKey(IcRole record);

    int updateBatch(List<IcRole> list);

    int batchInsert(@Param("list") List<IcRole> list);
}