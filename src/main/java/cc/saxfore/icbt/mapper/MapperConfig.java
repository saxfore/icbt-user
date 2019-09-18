package cc.saxfore.icbt.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;

/**
 * 项目名称：icbt-user
 * 类 名 称：MapperConfig
 * 类 描 述：TODO
 * 创建时间：2019/9/6 1:49 PM
 * 创 建 人：wangjiang
 * 注意：cc.saxfore.icbt.mapper.** 不可识别; 最后一个路径必须明确: cc.saxfore.icbt.**.mapper
 * 说明：@MapperScan(basePackages = {"cc.saxfore.incubation.mapper"})和直接在mapper接口上@Mapper意义相同
 */
@Configuration
@MapperScan(basePackages={"cc.saxfore.icbt.**.mapper"})
public class MapperConfig {

}
