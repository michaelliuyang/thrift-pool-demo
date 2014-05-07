package com.thrift.test;

import com.thrift.pool.ThriftPool;
import com.thrift.service.AdditionService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TTransport;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class TestClientThread implements Runnable {

    private ThriftPool pool;

    public TestClientThread(ThriftPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        TTransport tTransport = null;
        try {
            tTransport = pool.getResource();
            AdditionService.Client client = new
                    AdditionService.Client(new TCompactProtocol(tTransport));
            System.out.println(client.add(300, 200));
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (tTransport != null)
                pool.returnResource(tTransport);
        }
    }
}
