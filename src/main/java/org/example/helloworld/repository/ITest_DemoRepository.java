package org.example.helloworld.repository;

import org.example.helloworld.entity.Test_Demo;
import java.util.List;

public interface ITest_DemoRepository {
    List<Test_Demo> getTest_Demos();
    List<Test_Demo> addNewRecord(int id, String name);
    List<Test_Demo> updateRecord(int id, String name);
    List<Test_Demo> deleteRecord(int id);
}
