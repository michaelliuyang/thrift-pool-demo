package com.thrift.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class ThriftFactory implements PooledObjectFactory<TTransport> {

    private final String host;
    private final int port;

    public ThriftFactory(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public PooledObject<TTransport> makeObject() throws Exception {
        System.out.println("Create TTransport");
        TTransport tTransport = new TFramedTransport(new TSocket(this.host, this.port));
        tTransport.open();
        return new DefaultPooledObject<TTransport>(tTransport);
    }

    @Override
    public void destroyObject(PooledObject<TTransport> p) throws Exception {
        TTransport tTransport = p.getObject();
        if (tTransport.isOpen()) {
            tTransport.close();
            System.out.println("Destroy TTransport");
        }
    }

    @Override
    public boolean validateObject(PooledObject<TTransport> p) {
        TTransport tTransport = p.getObject();
        boolean flag = tTransport.isOpen();
        System.out.println("Validate TTransport:" + flag);
        return flag;
    }

    @Override
    public void activateObject(PooledObject<TTransport> p) throws Exception {
        System.out.println("Active TTransport");
    }

    @Override
    public void passivateObject(PooledObject<TTransport> p) throws Exception {
        System.out.println("Passivate TTransport");
    }
}
