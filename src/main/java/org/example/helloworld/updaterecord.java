package org.example.helloworld;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import org.example.helloworld.service.ITest_DemoService;

@ApplicationScoped
@Path("/updaterecord/{id}/{name}")
public class updaterecord {

    private ITest_DemoService testDemoService;

    @Inject
    public updaterecord(ITest_DemoService _testDemoService) {
        this.testDemoService = _testDemoService;
    }

    public updaterecord() {}

    @GET
    @Produces("text/plain")
    public String updaterecord(@PathParam("id") int id, @PathParam("name") String name) {
        String rtn = "";

        try{
            rtn = this.testDemoService.updateTest_Demo(id, name);
        }catch(Exception e){

        }
        return rtn;
    }
}