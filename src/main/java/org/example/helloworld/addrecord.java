package org.example.helloworld;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import org.example.helloworld.service.ITest_DemoService;

@ApplicationScoped
@Path("/addrecord/{id}/{name}")
public class addrecord {

    private ITest_DemoService testDemoService;

    @Inject
    public addrecord(ITest_DemoService _testDemoService) {
        this.testDemoService = _testDemoService;
    }

    public addrecord() {}

    @GET
    @Produces("text/plain")
    public String addrecord(@PathParam("id") int id, @PathParam("name") String name) {
        String rtn = "";

        try{
            rtn = this.testDemoService.addTest_Demo(id, name);
        }catch(Exception e){

        }
        return rtn;
    }
}