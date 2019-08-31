package com.caozeal.utopia.server.aop;

import com.caozeal.utopia.server.constants.AuditLogLevelEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *    审计日志注解
 * <p>
 *    其余几个属性是需要记录的用户信息以及实体信息的JSONPath,
 *    按照路径去获取相应的值
 * @author caozhiyong
 * @see AuditLogLevelEnum
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuditLog {

    /**
     * 审计日志记录级别，分为OFF、HIGH、MID、LOW几个安全级别，
     * 与配置的安全级别相比，只记录高于配置级别的日志，
     * 记录级别为OFF则不会记录。
     * @return AuditLogLevelEnum
     */
    AuditLogLevelEnum loglevel() default AuditLogLevelEnum.MID;

    String userIdPath() default "params.userInfo.id";

    String entityIdPath() default "";

    String entityNamePath() default "";

    String entityMorePath() default "";
}
