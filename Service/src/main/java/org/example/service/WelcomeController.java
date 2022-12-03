package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {
    @RequestMapping("/welcome")
    public String loginMessage(Model model){

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = null;
        try {
            response = Unirest.get("http://localhost:8080/employees")
                    .asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getBody().toString());
       /* String json="[{\"id\":1,\"name\":\"Bilbo Baggins\",\"role\":\"burglar\"},{\"id\":2,\"name\":\"Frodo Baggins\",\"role\":\"thief\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
        Employees employees;
        try {
            employees= objectMapper.readValue(json, Employees.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }*/
        Employee employee1= new Employee(1L,"hello1","dev1");
        Employee employee2= new Employee(2L,"hello2","dev2");
        List<Employee> employeeList= new ArrayList<Employee>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        model.addAttribute("EmployeesList",employeeList);
        return "welcome";
    }
  /*  @GetMapping("/error")
    public String  errMsg(){
        return "<h1>NA</h1>";
    }*/
}