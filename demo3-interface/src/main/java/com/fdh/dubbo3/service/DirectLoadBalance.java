package com.fdh.dubbo3.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.LoadBalance;

import java.util.List;

public class DirectLoadBalance implements LoadBalance {


    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {

        System.out.println("invocation:" + invocation.toString());
        Object[] arguments = invocation.getArguments();
        HelloRequest helloRequest = (HelloRequest) arguments[0];

        System.out.println(helloRequest.toString());

        for (Invoker<T> invoker : invokers) {
            System.out.println("invoker:"+invoker);
        }
        return invokers.get(0);
    }

}
