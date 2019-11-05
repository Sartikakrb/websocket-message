package module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainClass {
    public static void main(String[] args) {
        try {
            SpringApplication.run(MainClass.class, args);
        } catch (Throwable e) {
            System.out.println("FATAL ERROR - Build NOT Successful: terminating Spring application");
            e.printStackTrace();
        }
    }
}
