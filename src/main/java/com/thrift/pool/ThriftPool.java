package com.thrift.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.thrift.transport.TTransport;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class ThriftPool {

    private GenericObjectPool<TTransport> pool;

    public ThriftPool(String host, int port, int timeout, ThriftPoolConfig config) {
        ThriftFactory factory = new ThriftFactory(host, port, timeout);
        this.pool = new GenericObjectPool<TTransport>(factory, config);
    }

    public TTransport getResource() {
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            throw new RuntimeException("Get thrift resource error", e);
        }
    }

    public void returnResource(TTransport tTransport) {
        try {
            pool.returnObject(tTransport);
        } catch (Exception e) {
            throw new RuntimeException("return thrift resource error", e);
        }
    }

    public void close() {
        try {
            pool.close();
        } catch (Exception e) {
            throw new RuntimeException("Close thrift pool error", e);
        }
    }

}
