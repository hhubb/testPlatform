package com.icode.testplatform.until;

import java.io.Serializable;

public class ResponseUntil implements Serializable {
    /**
     * 成功码
     */
    public static final int SUCCESS=0000;
    /**
     * 参数错误码
     */
    public static final int ARGERROR=0001;
    /**
     * 数据库异常错误码
     */
    public static final int DBEERROR=0010;
    /**
     * 其他业务错误码
     */
    public static final int ORHTHEREERROR=0011;
}
