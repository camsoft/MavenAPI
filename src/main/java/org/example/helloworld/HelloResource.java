package org.example.helloworld;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import org.example.helloworld.service.ITest_DemoService;

@ApplicationScoped
@Path("/hello-world")
public class HelloResource {

    private ITest_DemoService testDemoService;

    @Inject
    public HelloResource(ITest_DemoService _testDemoService) {
        this.testDemoService = _testDemoService;
    }

    public HelloResource() {}

    @GET
    @Produces("text/plain")
    public String hello() {
        String rtn = "";

        try{
            rtn = this.testDemoService.getTest_Demo();
        }catch(Exception e){
            int test = 1;
        }
        return rtn;
    }
}