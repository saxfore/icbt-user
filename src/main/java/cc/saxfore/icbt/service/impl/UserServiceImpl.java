package cc.saxfore.icbt.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cc.saxfore.icbt.common.entity.IcUser;
import cc.saxfore.icbt.mapper.IcUserMapper;
import cc.saxfore.icbt.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：${NAME}
 * 类 描 述：TODO
 * 创建时间：2019/9/6 2:53 PM
 * 创 建 人：wangjiang
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IcUserMapper icUserMapper;

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
    public List<IcUser> listAll() {
        return icUserMapper.listAll();
    }


}
