package org.example.helloworld.service;

import jakarta.inject.Inject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.helloworld.entity.Test_Demo;
import org.example.helloworld.repository.ITest_DemoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.ArrayList;

@ApplicationScoped
public class Test_DemoService implements ITest_DemoService {
    private ITest_DemoRepository test_demoRepository;

    @Inject
    public Test_DemoService(ITest_DemoRepository test_demoRepository) {
        this.test_demoRepository = test_demoRepository;
    }

    public Test_DemoService() {}

    public String getTest_Demo(){
        String rtn = "";

        List<Test_Demo> tdData = new ArrayList<>();
        tdData = test_demoRepository.getTest_Demos();

        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writeValueAsString(tdData);
            rtn = jsonArray;
        }catch (JsonProcessingException e){
            rtn = "DB Error";
        }
        return rtn;
    }

    public String addTest_Demo(int id, String name){
        String rtn = "";
        List<Test_Demo> tdData = new ArrayList<>();
        tdData = test_demoRepository.addNewRecord(id, name);

        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writeValueAsString(tdData);
            rtn = jsonArray;
        }catch(JsonProcessingException e){
            rtn = "DB Error";
        }
        return rtn;
    }

    public String deleteTest_Demo(int id){
        String rtn = "";
        List<Test_Demo> tdData = new ArrayList<>();
        tdData = test_demoRepository.deleteRecord(id);

        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writeValueAsString(tdData);
            rtn = jsonArray;
        }catch(JsonProcessingException e){
            rtn = "DB Error";
        }
        return rtn;
    }

    public String updateTest_Demo(int id, String name){
        String rtn = "";
        List<Test_Demo> tdData = new ArrayList<>();
        tdData = test_demoRepository.updateRecord(id, name);

        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writeValueAsString(tdData);
            rtn = jsonArray;
        }catch(JsonProcessingException e){
            rtn = "DB Error";
        }
        return rtn;
    }
}
