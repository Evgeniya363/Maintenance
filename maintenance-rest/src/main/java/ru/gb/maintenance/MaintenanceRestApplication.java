package ru.gb.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.gb.maintenance.model.*;
import ru.gb.maintenance.repositories.*;
import ru.gb.maintenance.services.DatabaseService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableTransactionManagement
public class MaintenanceRestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MaintenanceRestApplication.class, args);
        DatabaseService.InitDb(ctx);
    }

}
