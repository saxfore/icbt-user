package cc.saxfore.icbt.mapper;

import cc.saxfore.icbt.common.entity.user.IcUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/6 2:53 PM
 * 创 建 人：wangjiang
 */
public interface IcUserMapper {

    int deleteByPrimaryKey(String id);

    int insert(IcUser record);

    int insertSelective(IcUser record);

    IcUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IcUser record);

    int updateByPrimaryKey(IcUser record);

    IcUser findUserByUserName(String userName);

    IcUser findUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    List<IcUser> listAll();
}