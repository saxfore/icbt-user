package cc.saxfore.icbt.controller;

import cc.saxfore.icbt.common.IConst;
import cc.saxfore.icbt.common.base.ICResponse;
import cc.saxfore.icbt.common.entity.IcUser;
import cc.saxfore.icbt.common.util.ICJsonUtil;
import cc.saxfore.icbt.common.util.ICRespResult;
import cc.saxfore.icbt.component.ICRedisClient;
import cc.saxfore.icbt.service.IcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：AdminController
 * 类 描 述：TODO
 * 创建时间：2019/9/6 1:47 PM
 * 创 建 人：wangjiang
 */
@RestController
@RequestMapping(value = {"/admin", "/api/admin"})
public class AdminController extends BaseController {

    @Autowired
    IcUserService userService;
    @Autowired
    ICRedisClient redisClient;

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public ICResponse find(@PathVariable("id") String id) {
        IcUser icUser = userService.selectByPrimaryKey(id);
        return ICRespResult.success(icUser);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping(value = "/listAll")
    public ICResponse listAll() {
        List<IcUser> userList = userService.listAll();
        return ICRespResult.success(userList);
    }

    /**
     * 添加用户
     *
     * @param icUser
     * @return
     */
    @PostMapping(value = "/add")
    public ICResponse add(@RequestBody IcUser icUser) {
        icUser.setBaseInfo();
        userService.insert(icUser);
        redisClient.set(IConst.REDIS_USER_ADD_KEY + ":" + icUser.getId(), ICJsonUtil.toJsonString(icUser));
        return ICRespResult.success();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/delete/{id}")
    public ICResponse delete(@PathVariable("id") String id) {
        userService.deleteByPrimaryKey(id);
        return ICRespResult.success();
    }

    /**
     * 修改用户
     *
     * @param icUser
     * @return
     */
    @PostMapping(value = "/edit")
    public ICResponse edit(IcUser icUser) {
        userService.updateByPrimaryKey(icUser);
        return ICRespResult.success();
    }


}
