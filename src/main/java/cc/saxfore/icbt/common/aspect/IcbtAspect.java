package cc.saxfore.icbt.common.aspect;

import cc.saxfore.icbt.common.util.ICJsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 项目名称：icbt-user
 * 类 名 称：ApiAspect
 * 类 描 述：TODO
 * 创建时间：2019/8/11 6:24 PM
 * 创 建 人：wangjiang
 */
@Aspect
@Component
public class IcbtAspect {
    private static final Logger log = LoggerFactory.getLogger(IcbtAspect.class);

    @Pointcut("execution(* cc.saxfore.icbt.controller..*.*(..))")
    public void icbtMethods() {

    }

    /**
     * 进入方法之前
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("icbtMethods()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        log.info("icbtAspect doBefore ...");

        String clazzName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String reqArgs = Arrays.toString(joinPoint.getArgs());

        log.info("icbtAspect doBefore 调用方法: {}.{}", clazzName, methodName);
        log.info("icbtAspect doBefore 请求参数: {}", reqArgs);
    }

    /**
     * 返回结果之前
     *
     * @param obj
     * @throws Throwable
     */
    @AfterReturning(returning = "obj", pointcut = "icbtMethods()")
    public void doAfterReturning(JoinPoint joinPoint, Object obj) throws Throwable {
        log.info("icbtAspect doAfterReturning ...");

        String clazzName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String reqArgs = Arrays.toString(joinPoint.getArgs());
        String returnResult = ICJsonUtil.toJsonString(obj);

        log.info("icbtAspect doAfterReturning 调用方法: {}.{}", clazzName, methodName);
        log.info("icbtAspect doAfterReturning 返回结果: {}", returnResult);
    }

    /**
     * 调用异常
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "icbtMethods()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.info("icbtAspect doAfterThrowing ...");

        String clazzName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String reqArgs = Arrays.toString(joinPoint.getArgs());

        log.info("icbtAspect doAfterThrowing 调用方法: {}.{} 发生异常...", clazzName, methodName);
    }

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "icbtMethods()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("icbtAspect doAroundAdvice ...");

        String clazzName = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("icbtAspect doAroundAdvice 环绕通知的目标方法: {}.{}", clazzName, methodName);

        try {
            Object obj = proceedingJoinPoint.proceed();
            log.info("icbtAspect doAroundAdvice 环绕通知返回：{}", ICJsonUtil.toJsonString(obj));
            return obj;

        } catch (Throwable throwable) {

            throwable.printStackTrace();
        }

        return null;
    }

}
