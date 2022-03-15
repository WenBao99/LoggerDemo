package com.wenbao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenbao.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wenbao
 * @data 2022/2/21
 * @Tip
 */
@Mapper //代表持久层
public interface UserMapper extends BaseMapper<User>{

}
