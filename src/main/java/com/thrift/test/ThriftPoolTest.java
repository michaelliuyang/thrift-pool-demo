package com.thrift.test;

import com.thrift.pool.ThriftFactory;
import com.thrift.pool.ThriftPool;
import com.thrift.pool.ThriftPoolConfig;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class ThriftPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ThriftPoolConfig config = new ThriftPoolConfig();
        ThriftFactory factory = new ThriftFactory("localhost", 9090);
        ThriftPool pool = new ThriftPool(config, factory);
        for (int i = 0; i < 1000; i++) {
            TestClientThread runnable = new TestClientThread(pool);
            Thread t = new Thread(runnable);
            t.start();
        }
    }

}
