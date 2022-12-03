package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class Main  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }
    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }

}
/*interface Function<T,U>{
     T apply(T t,U c);
}

public class Main {
    public static void main(String[] args) throws UnirestException {
        System.out.println("Hello world!");
        Function<Integer,Integer> function = (t,c)-> t + c;
        System.out.println(function.apply(3,4));
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("http://localhost:8080/employees")
                .asString();
        System.out.println(response.getBody().toString());
    }}*/
