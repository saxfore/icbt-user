package cc.saxfore.icbt.service.impl;

import cc.saxfore.icbt.mapper.IcRoleMapper;
import cc.saxfore.icbt.service.IcRoleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import cc.saxfore.icbt.common.entity.role.IcRole;
import cc.saxfore.icbt.common.entity.role.IcRoleExample;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/16 3:28 PM
 * 创 建 人：wangjiang
 */
@Service
public class IcRoleServiceImpl implements IcRoleService {

    @Resource
    private IcRoleMapper icRoleMapper;

    @Override
    public long countByExample(IcRoleExample example) {
        return icRoleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(IcRoleExample example) {
        return icRoleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return icRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(IcRole record) {
        return icRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(IcRole record) {
        return icRoleMapper.insertSelective(record);
    }

    @Override
    public List<IcRole> selectByExample(IcRoleExample example) {
        return icRoleMapper.selectByExample(example);
    }

    @Override
    public IcRole selectByPrimaryKey(String id) {
        return icRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(IcRole record,IcRoleExample example) {
        return icRoleMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(IcRole record,IcRoleExample example) {
        return icRoleMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(IcRole record) {
        return icRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(IcRole record) {
        return icRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<IcRole> list) {
        return icRoleMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<IcRole> list) {
        return icRoleMapper.batchInsert(list);
    }

}
