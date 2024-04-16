package com.dev.sprinboot.lesson;

import com.dev.sprinboot.conditional.FirstConditional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;

@Conditional(FirstConditional.class)
@Profile("dev")
@SpringBootApplication
public class SpringBootLessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLessonApplication.class, args);
    }
}
