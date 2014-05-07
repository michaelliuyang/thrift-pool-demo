package com.thrift.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class ThriftPoolConfig extends GenericObjectPoolConfig {

    private int maxTotal = 30;
    private int maxIdle = 10;
    private int minIdle = 5;
    private int maxWait = 1000;
    private boolean testOnBorrow = true;
    private boolean testOnReturn = true;

    public ThriftPoolConfig() {
        System.out.println("Create thrift pool config");
        setMaxTotal(maxTotal);
        setMaxIdle(maxIdle);
        setMinIdle(minIdle);
        setMaxWaitMillis(maxWait);
        setTestOnBorrow(testOnBorrow);
        setTestOnReturn(testOnReturn);
    }

    public ThriftPoolConfig(int maxTotal, int maxIdle, int minIdle, int maxWait) {
        System.out.println("Create thrift pool config");
        setMaxTotal(maxTotal);
        setMaxIdle(maxIdle);
        setMinIdle(minIdle);
        setMaxWaitMillis(maxWait);
    }

    public ThriftPoolConfig(int maxTotal, int maxIdle, int minIdle, int maxWait,
                            boolean testOnBorrow, boolean testOnReturn) {
        System.out.println("Create thrift pool config");
        setMaxTotal(maxTotal);
        setMaxIdle(maxIdle);
        setMinIdle(minIdle);
        setMaxWaitMillis(maxWait);
        setTestOnBorrow(testOnBorrow);
        setTestOnReturn(testOnReturn);
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }
}
