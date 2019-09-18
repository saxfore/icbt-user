package cc.saxfore.icbt.service.impl;

import cc.saxfore.icbt.common.entity.userrole.IcUserRoleExample;
import cc.saxfore.icbt.mapper.IcUserRoleMapper;
import cc.saxfore.icbt.service.IcUserRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cc.saxfore.icbt.common.entity.userrole.IcUserRole;
import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/16 3:32 PM
 * 创 建 人：wangjiang
 */
@Service
public class IcUserRoleServiceImpl implements IcUserRoleService {

    @Resource
    private IcUserRoleMapper icUserRoleMapper;

    @Override
    public long countByExample(IcUserRoleExample example) {
        return icUserRoleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(IcUserRoleExample example) {
        return icUserRoleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return icUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IcUserRole record) {
        return icUserRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(IcUserRole record) {
        return icUserRoleMapper.insertSelective(record);
    }

    @Override
    public List<IcUserRole> selectByExample(IcUserRoleExample example) {
        return icUserRoleMapper.selectByExample(example);
    }

    @Override
    public IcUserRole selectByPrimaryKey(String id) {
        return icUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(IcUserRole record,IcUserRoleExample example) {
        return icUserRoleMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(IcUserRole record,IcUserRoleExample example) {
        return icUserRoleMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(IcUserRole record) {
        return icUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IcUserRole record) {
        return icUserRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<IcUserRole> list) {
        return icUserRoleMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<IcUserRole> list) {
        return icUserRoleMapper.batchInsert(list);
    }

}
