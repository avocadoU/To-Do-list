package ru.gorodnichev_ilya.NauJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import ru.gorodnichev_ilya.NauJava.domain.Task;
import ru.gorodnichev_ilya.NauJava.service.CommandProcessor;

@Configuration
public class Config {

    @Autowired
    private CommandProcessor commandProcessor;

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Task> taskContainer() {
        return new ArrayList<>();
    }

    @Bean
    public CommandLineRunner commandScanner() {
        return args -> {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Введите команду. 'exit' для выхода.");
                while (true) {
                    System.out.print("> ");
                    String input = scanner.nextLine();
                    if ("exit".equalsIgnoreCase(input.trim())) {
                        System.out.println("Выход из программы...");
                        break;
                    }
                    commandProcessor.processCommand(input);
                }
            }
        };
    }
}
