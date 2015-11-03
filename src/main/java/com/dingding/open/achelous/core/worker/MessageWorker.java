/**
 * DingDing.com Inc.
 * Copyright (c) 2000-2016 All Rights Reserved.
 */
package com.dingding.open.achelous.core.worker;


/**
 * 消息处理者
 * 
 * @author surlymo
 * @date Nov 3, 2015
 */
public interface MessageWorker<T> {
    void proc(T message);
}