package com.wenbao.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author wenbao
 * @data 2022/3/15
 * @Tip aop
 */
@Component
@Aspect //切面
@Slf4j
public class LoggerAspect {

    /**
     * 设置切点
     */
    @Pointcut("@annotation(com.wenbao.utils.Logger)")
    public void LoggerPointCut() {
    }

    /**
     * 设置切面，在方法执行并返回值后执行
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "LoggerPointCut()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        System.err.println(
                joinPoint.getSignature().getName() + "方法的结果是" + result
        );
    }

    /**
     * 设置切面，环绕型
     */
    @Around(value = "LoggerPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取当前时间
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object method = joinPoint.proceed();
        //执行时长
        long endTime = System.currentTimeMillis() - beginTime;
        //保存日志
        saveRecord(joinPoint, endTime);
        return method;
    }

    private void saveRecord(ProceedingJoinPoint joinPoint, long time) {

        //获取signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //通过signature获取方法名
        Method method = signature.getMethod();
        //注入自定义注解
        com.wenbao.utils.Logger logger = method.getAnnotation(com.wenbao.utils.Logger.class);

        //打印日志
        log.info("====================log start!====================");
        log.info("loggerModel{}:"+ logger.loggerModel());
        log.info("loggerType{}:"+ logger.loggerType());
        log.info("loggerDesc{}:"+ logger.loggerDesc());

        //获取请求的接口方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();

        //打印接口信息
        log.info("request method:{}" + className + "." + methodName + "()");

        //获取请求参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        //打印参数信息
        log.info("request params:{}", args);

        //打印执行时间 毫秒级
        log.info("execute time :{} ms", time);
        log.info("====================log end!======================");

    }

}
