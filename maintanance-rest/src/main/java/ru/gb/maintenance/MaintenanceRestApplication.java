package ru.gb.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MaintenanceRestApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(MaintenanceRestApplication.class, args);

//		PostRepository postRepository = ctx.getBean(PostRepository.class);
//		postRepository.deleteAll();
//
//		DepartmentRepository departmentRepository = ctx.getBean(DepartmentRepository.class);
//		departmentRepository.deleteAll();
//
//		CompanyRepository companyRepository = ctx.getBean(CompanyRepository.class);
//		companyRepository.deleteAll();
//
//		Post post1 = new Post();
//		post1.setName("Бухгалтерия");
//		postRepository.save(post1);
//
//		Post post2 = new Post();
//		post2.setName("Плановый отдел");
//		postRepository.save(post2);
//
//
//
//		Company company1 = new Company();
//		company1.setName("ООО Артис");
//		companyRepository.save(company1);
//
//		Company company2 = new Company();
//		company2.setName("ОАО Юстас");
//		companyRepository.save(company2);
//
//		Department department1 = new Department();
//		department1.setName("Department#1");
//		department1.setCompany(company1);
//		departmentRepository.save(department1);
//
//		Department department2 = new Department();
//		department2.setName("Department#1");
//		department2.setCompany(company2);
//		departmentRepository.save(department2);

	}

}
