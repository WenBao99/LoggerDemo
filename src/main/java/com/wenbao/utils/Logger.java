package com.wenbao.utils;

import java.lang.annotation.*;

/**
 * @author wenbao
 * @data 2022/3/15
 * @Tip
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface Logger {
    String loggerModel() default ""; // 操作模块

    String loggerType() default "";  // 操作类型

    String loggerDesc() default "";  // 操作说明
}
