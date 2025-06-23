package org.example.helloworld;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import org.example.helloworld.service.ITest_DemoService;

@ApplicationScoped
@Path("/deleterecord/{id}")
public class deleterecord {

    private ITest_DemoService testDemoService;

    @Inject
    public deleterecord(ITest_DemoService _testDemoService) {
        this.testDemoService = _testDemoService;
    }

    public deleterecord() {}

    @GET
    @Produces("text/plain")
    public String deleterecord(@PathParam("id") int id) {
        String rtn = "";

        try{
            rtn = this.testDemoService.deleteTest_Demo(id);
        }catch(Exception e){

        }
        return rtn;
    }
}