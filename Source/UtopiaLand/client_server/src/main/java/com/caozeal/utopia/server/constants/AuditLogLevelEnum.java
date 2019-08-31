package com.caozeal.utopia.server.constants;

/**
 * 审计日志记录安全级别
 * @author caozhiyong
 */
public enum AuditLogLevelEnum {

    /**
     * 安全级别：关闭、高、中、低
     */
    OFF,
    HIGH,
    MID,
    LOW;

    AuditLogLevelEnum() {
    }

    /**
     * 是否需要记录审计日志
     * @param configLevel 配置的纪录级别
     * @return boolean
     */
    public boolean needNotLog(AuditLogLevelEnum configLevel) {
        return AuditLogLevelEnum.OFF.equals(this) ||
                ( configLevel != null &&
                        this.ordinal() > configLevel.ordinal());
    }
}
