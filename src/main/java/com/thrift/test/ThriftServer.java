package com.thrift.test;

import com.thrift.service.AdditionService;
import com.thrift.service.AdditionServiceHandler;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by michaelliuyang on 14-5-7.
 */
public class ThriftServer {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        try {
            TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(9090);
            TNonblockingServer.Args tArgs = new TNonblockingServer.Args(serverSocket);
            AdditionService.Processor<AdditionServiceHandler> processor =
                    new AdditionService.Processor<AdditionServiceHandler>(new AdditionServiceHandler());
            tArgs.processor(processor);
            tArgs.transportFactory(new TFramedTransport.Factory());
            tArgs.protocolFactory(new TCompactProtocol.Factory());
            TServer server = new TNonblockingServer(tArgs);
            server.serve();
            System.out.println("Starting the non blocking server...");
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

}
