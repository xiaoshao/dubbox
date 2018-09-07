package com.alibaba.dubbo.demo.hello;

import com.alibaba.dubbo.demo.user.User;

public interface HelloConsumerService {

    User helloConsumer(String name);
}
