package cc.saxfore.icbt.common.schedule;

import cc.saxfore.icbt.common.entity.user.IcUser;
import cc.saxfore.icbt.service.IcUserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 项目名称：icbt-user
 * 类 名 称：ScheduleTask
 * 类 描 述：TODO
 * 创建时间：2019/8/11 8:05 PM
 * 创 建 人：wangjiang
 */
@Component
public class ScheduleTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);

    @Autowired
    IcUserService userService;

    /**
     * 每分钟执行一次
     */
    // @Scheduled(cron = "0 */1 * * * ?")
    public void listAllUsers() {
        log.info("ScheduleTask listAllUsers ...");
        long beginTime = new Date().getTime();

        List<IcUser> userList = userService.listAll();
        log.info("ScheduleTask listAllUsers 查询结果：{}", new Gson().toJson(userList));

        long endTime = new Date().getTime();
        log.info("ScheduleTask listAllUsers 执行时间：{}ms", (endTime - beginTime));
    }


}
