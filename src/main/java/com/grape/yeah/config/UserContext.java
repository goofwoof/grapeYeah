package com.grape.yeah.config;

public class UserContext {
    // 构造方法私有化
    private UserContext() {
    }

    private static final ThreadLocal<String> OpenId = new ThreadLocal<>();

    /**
     * 存放用户信息
     *
     * @param openId
     */
    public static void setOpenId(String openId) {
        OpenId.set(openId);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public static String getOpenId() {
        return OpenId.get();
    }
}
