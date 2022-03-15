package com.wenbao.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author wenbao
 * @data 2022/2/22
 * @Tip 自动填充处理
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        //打印报告
        log.info("start insert fill...");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this
                .setFieldValByName("createTime", LocalDate.now(), metaObject)
                .setFieldValByName("modifiedTime", LocalDate.now(), metaObject);
    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        //打印报告
        log.info("start update fill...");
        this.setFieldValByName("modifiedTime", LocalDate.now(), metaObject);

    }


}
