package com;

import com.alibaba.dubbo.demo.hello.HelloConsumerService;
import com.alibaba.dubbo.demo.user.User;
import com.alibaba.dubbo.demo.user.facade.AnotherUserRestService;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class HelloConsumerServiceImpl implements HelloConsumerService {

    private AnotherUserRestService anotherUserRestService;

    public void setAnotherUserRestService(AnotherUserRestService service){
        this.anotherUserRestService = service;
    }


    @Override
    @Path("/{name}")
    @GET
    public User helloConsumer(@PathParam("name") String name) {
        User user = anotherUserRestService.getUser(1L);
        user.setName(name);

        return user;
    }
}
