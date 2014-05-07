package com.thrift.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class ThriftPoolConfig extends GenericObjectPoolConfig {

    public ThriftPoolConfig() {
        System.out.println("Create thrift pool config");
        setMaxTotal(20);
        setMaxIdle(5);
        setMaxWaitMillis(1000);
        setMinIdle(3);
        setTestOnBorrow(true);
    }

}
