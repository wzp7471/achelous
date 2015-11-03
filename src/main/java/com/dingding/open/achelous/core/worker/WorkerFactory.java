package com.dingding.open.achelous.core.worker;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WorkerFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public enum Type {
        SPRING, NON_SPRING
    };

    public static MessageWorker getWorker(String name) {
        if (name.contains(".")) {
            return getWorker(Type.NON_SPRING, name);
        } else {
            return getWorker(Type.SPRING, name);
        }
    }

    public static MessageWorker getWorker(Type type, String name) {
        switch (type) {
            case NON_SPRING:
                try {
                    return (MessageWorker) Class.forName(name).newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case SPRING:
                return (MessageWorker) applicationContext.getBean(name);
            default:
                break;
        }
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }
}
