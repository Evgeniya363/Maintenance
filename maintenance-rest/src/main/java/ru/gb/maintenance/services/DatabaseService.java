package ru.gb.maintenance.services;

import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.maintenance.model.*;
import ru.gb.maintenance.repositories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DatabaseService {
    public static void InitDb(ConfigurableApplicationContext ctx) {
        // Не перемещать, порядок важен!
        MaintenanceRepository maintenanceRepository = ctx.getBean(MaintenanceRepository.class);
        maintenanceRepository.deleteAll();

        EquipmentRepository equipmentRepository = ctx.getBean(EquipmentRepository.class);
        equipmentRepository.deleteAll();

        ContractorRepository contractorRepository = ctx.getBean(ContractorRepository.class);
        contractorRepository.deleteAll();

        EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
        employeeRepository.deleteAll();

        DepartmentRepository departmentRepository = ctx.getBean(DepartmentRepository.class);
        departmentRepository.deleteAll();

        PostRepository postRepository = ctx.getBean(PostRepository.class);
        postRepository.deleteAll();

        CategoryRepository categoryRepository = ctx.getBean(CategoryRepository.class);
        categoryRepository.deleteAll();

        CompanyRepository companyRepository = ctx.getBean(CompanyRepository.class);
        companyRepository.deleteAll();

        ModelRepository modelRepository = ctx.getBean(ModelRepository.class);
        modelRepository.deleteAll();

        ManufacturerRepository manufacturerRepository = ctx.getBean(ManufacturerRepository.class);
        manufacturerRepository.deleteAll();


        Post post1 = new Post();
        post1.setName("Бухгалтер");
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setName("Инженер");
        postRepository.save(post2);

        Post post3 = new Post();
        post3.setName("Техник");
        postRepository.save(post3);


        Company company1 = new Company();
        company1.setName("ООО ИТ-сервис");
        companyRepository.save(company1);

        Company company2 = new Company();
        company2.setName("ОАО Протон-М");
        companyRepository.save(company2);

        Company company3 = new Company();
        company3.setName("ОАО Гермес");
        companyRepository.save(company3);


        Department department1 = new Department();
        department1.setName("Техотдел");
        department1.setCompany(company1);
        departmentRepository.save(department1);

        Department department2 = new Department();
        department2.setName("Бухгалтерия");
        department2.setCompany(company2);
        departmentRepository.save(department2);

        Department department3 = new Department();
        department3.setName("Плановый отдел");
        department3.setCompany(company2);
        departmentRepository.save(department3);


        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName("ASUS");
        manufacturerRepository.save(manufacturer1);

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setName("HP");
        manufacturerRepository.save(manufacturer2);

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setName("None");
        manufacturerRepository.save(manufacturer3);

        Manufacturer manufacturer4 = new Manufacturer();
        manufacturer4.setName("Samsung");
        manufacturerRepository.save(manufacturer4);


        Model model1 = new Model();
        model1.setName("S1024U");
        model1.setManufacturer(manufacturer1);
        modelRepository.save(model1);

        Model model2 = new Model();
        model2.setName("A124U");
        model2.setManufacturer(manufacturer1);
        modelRepository.save(model2);

        Model model3 = new Model();
        model3.setName("AI-15");
        model3.setManufacturer(manufacturer2);
        modelRepository.save(model3);

        Model model4 = new Model();
        model4.setName("FF140");
        model4.setManufacturer(manufacturer2);
        modelRepository.save(model4);

        Model model5 = new Model();
        model5.setName("Star 5");
        model5.setManufacturer(manufacturer3);
        modelRepository.save(model5);


        Category category1 = new Category();
        category1.setName("Сервер/системный блок");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setName("Принтер/МФУ");
        categoryRepository.save(category2);

        Category category3 = new Category();
        category3.setName("Монитор");
        categoryRepository.save(category3);


        Employee employee1 = new Employee();
        employee1.setFirstName("Иван");
        employee1.setPatronymic("Иванович");
        employee1.setSecondName("Иванов");
        employee1.setPost(post2);
        employee1.setDepartment(department1);
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Петр");
        employee2.setPatronymic("Петрович");
        employee2.setSecondName("Петров");
        employee2.setPost(post3);
        employee2.setDepartment(department1);
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Алла");
        employee3.setPatronymic("Дмитриевна");
        employee3.setSecondName("Коваль");
        employee3.setPost(post1);
        employee3.setDepartment(department2);
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Инна");
        employee4.setPatronymic("Ивановна");
        employee4.setSecondName("Головина");
        employee4.setPost(post2);
        employee4.setDepartment(department3);
        employeeRepository.save(employee4);

        Employee employee5 = new Employee();
        employee5.setFirstName("Зоя");
        employee5.setPatronymic("Павловна");
        employee5.setSecondName("Костенко");
        employee5.setPost(post3);
        employee5.setDepartment(department3);
        employeeRepository.save(employee5);

//        List<Contractor> contractors = new ArrayList<>();
        Contractor contractor1 = new Contractor();
        contractor1.setEmployee(employee1);
//        contractors.add(contractor1);
        contractorRepository.save(contractor1);

        Contractor contractor2 = new Contractor();
        contractor2.setEmployee(employee2);
//        contractors.add(contractor2);
        contractorRepository.save(contractor2);

        List<Equipment> equipments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Equipment equipment1 = new Equipment();
            equipment1.setCategory(categoryRepository.findById(category1.getId() + ThreadLocalRandom.current().nextLong(0, categoryRepository.count())).orElse(category1));
            equipment1.setModel(modelRepository.findById(model1.getId() + ThreadLocalRandom.current().nextLong(0, categoryRepository.count())).orElse(model1));
            equipment1.setDepartment(departmentRepository.findById(department1.getId() + ThreadLocalRandom.current().nextLong(0, departmentRepository.count())).orElse(department1));
            equipment1.setEmployee(employeeRepository.findById(employee1.getId() + ThreadLocalRandom.current().nextLong(0, employeeRepository.count())).orElse(employee1));
            equipment1.setSerialNumber("123-34521-123hj-123-00");
            equipment1.setInventoryNumber("2200001");
            equipment1.setServiceNumber("300-001");
            equipment1.setStartUsageDate(LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(1, 3650)));
            equipment1.setMaintenanceDate(LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(1, 365)));
            equipments.add(equipment1);
            equipmentRepository.save(equipment1);
        }

        List<Equipment> equipmentList = equipmentRepository.findAll();

        for (Equipment e : equipmentList) {
            Maintenance maintenance = new Maintenance();
            LocalDate date1 = LocalDate.now().minusDays(ThreadLocalRandom.current().nextInt(365, 365 * 2));
            maintenance.setDate(date1);
            maintenance.setEquipment(e);
            maintenance.setContractor(contractorRepository.getById(contractor1.getId() + ThreadLocalRandom.current().nextLong(0, contractorRepository.count() )));
            maintenance.setType(
                    ThreadLocalRandom.current().nextInt(0, 2) == 0 ?
                            Type.PLANNED :
                            Type.UNSCHEDULED
            );
            maintenance.setStatus(Status.COMPLETED); //
            maintenance.setReason("Комментарий # " + ThreadLocalRandom.current().nextInt(1, 100));
            maintenanceRepository.save(maintenance);

            maintenance = new Maintenance();
            maintenance.setDate(date1.minusDays(-365));
            maintenance.setEquipment(e);
            maintenance.setContractor(contractorRepository.getById(contractor1.getId() + ThreadLocalRandom.current().nextLong(0, contractorRepository.count())));
            maintenance.setType(
                    ThreadLocalRandom.current().nextInt(0, 2) == 0 ?
                            Type.PLANNED :
                            Type.UNSCHEDULED
            );
            int rnd = ThreadLocalRandom.current().nextInt(0, 4);
            maintenance.setStatus(
                    rnd == 0 ? Status.SCHEDULED : (
                            rnd == 1 ? Status.INWORKS : (
                                    rnd == 2 ? Status.COMPLETED : (
                                            rnd == 3 ? Status.REJECTED : Status.POSTPONED)))
            );
            maintenance.setReason("Комментарий # " + ThreadLocalRandom.current().nextInt(1, 100));
            maintenanceRepository.save(maintenance);

        }

    }

}
