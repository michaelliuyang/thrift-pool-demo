package com.thrift.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.thrift.transport.TTransport;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class ThriftPool {

    private GenericObjectPool<TTransport> pool;

    public ThriftPool(GenericObjectPoolConfig config, ThriftFactory factory) {
        this.pool = new GenericObjectPool<TTransport>(factory, config);
    }

    public TTransport getResource() {
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void returnResource(TTransport tTransport) {
        pool.returnObject(tTransport);
    }

}
