package com.thrift.service;

import org.apache.thrift.TException;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class AdditionServiceHandler implements AdditionService.Iface {

    @Override
    public int add(int n1, int n2) throws TException {
        return n1 + n2;
    }

}
