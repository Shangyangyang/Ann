package com.newheyd.base.bean;

public enum ResultCode {

    QR_CANCEL(93),
    QR_CONFIRM(94),
    QR_SCAN(95),
    QR_NOT_SCAN(96),
    QR_TIMEOUT(97),
    QR_OBJ_NULL(98),
    QR_KEY_NULL(99),

    NOT_LOGIN(100),

    SUCCESS(200), // 成功

    FAIL(400), // 失败

    UNAUTHORIZED(401), // 未认证（签名错误）
    NOT_FOUND(404), // 接口不存在

    INTERNAL_SERVER_ERROR(500);// 服务器内部错误

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
