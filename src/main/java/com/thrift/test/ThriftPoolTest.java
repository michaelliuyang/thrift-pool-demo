package com.thrift.test;

import com.thrift.pool.ThriftPool;
import com.thrift.pool.ThriftPoolConfig;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class ThriftPoolTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        ThriftPoolConfig config = new ThriftPoolConfig();
        ThriftPool pool = new ThriftPool("localhost", 9090, 1000, config);
        for (int i = 0; i < 10000; i++) {
            TestClientThread runnable = new TestClientThread(pool);
            Thread t = new Thread(runnable);
            t.start();
        }
    }

}
