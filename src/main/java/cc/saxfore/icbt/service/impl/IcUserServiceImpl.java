package cc.saxfore.icbt.service.impl;

import cc.saxfore.icbt.common.entity.role.IcRoleExample;
import cc.saxfore.icbt.common.entity.user.IcUser;
import cc.saxfore.icbt.common.entity.userrole.IcUserRoleExample;
import cc.saxfore.icbt.common.entity.role.IcRole;
import cc.saxfore.icbt.common.entity.userrole.IcUserRole;
import cc.saxfore.icbt.mapper.IcUserMapper;
import cc.saxfore.icbt.service.IcRoleService;
import cc.saxfore.icbt.service.IcUserRoleService;
import cc.saxfore.icbt.service.IcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/6 2:53 PM
 * 创 建 人：wangjiang
 */
@Service
public class IcUserServiceImpl implements IcUserService {

    @Resource
    private IcUserMapper icUserMapper;
    @Autowired
    private IcUserRoleService icUserRoleService;
    @Autowired
    private IcRoleService icRoleService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return icUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IcUser record) {
        return icUserMapper.insert(record);
    }

    @Override
    public int insertSelective(IcUser record) {
        return icUserMapper.insertSelective(record);
    }

    @Override
    public IcUser selectByPrimaryKey(String id) {
        return icUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(IcUser record) {
        return icUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IcUser record) {
        return icUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public IcUser findUserByUserName(String userName) {
        return icUserMapper.findUserByUserName(userName);
    }

    @Override
    public IcUser findUserByUserNameAndPassword(String username, String password) {
        return icUserMapper.findUserByUserNameAndPassword(username, password);
    }

    @Override
    public List<IcRole> findRoleByUserName(String userName) {
        IcUser icUser = findUserByUserName(userName);

        if (icUser != null) {

            // 用户和角色的映射
            IcUserRoleExample userRoleExample = new IcUserRoleExample();
            IcUserRoleExample.Criteria userRoleCriteria = userRoleExample.createCriteria();
            userRoleCriteria.andUserIdEqualTo(icUser.getId());
            List<IcUserRole> icUserRoles = icUserRoleService.selectByExample(userRoleExample);

            // 查询角色
            if (icUserRoles != null && !icUserRoles.isEmpty()) {
                List<String> roleIdList = icUserRoles.stream().map(p -> p.getRoleId()).collect(Collectors.toList());
                IcRoleExample roleExample = new IcRoleExample();
                IcRoleExample.Criteria roleCriteria = roleExample.createCriteria();
                roleCriteria.andIdIn(roleIdList);
                List<IcRole> icRoleList = icRoleService.selectByExample(roleExample);
                return icRoleList;
            }
        }

        return new ArrayList<>();
    }

    @Override
    public List<IcUser> listAll() {
        return icUserMapper.listAll();
    }


}
