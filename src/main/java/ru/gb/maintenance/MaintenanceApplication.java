package ru.gb.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.model.Post;
import ru.gb.maintenance.repositories.CompanyRepository;
import ru.gb.maintenance.repositories.PostRepository;

@SpringBootApplication
public class MaintenanceApplication {

	public static void main(String[] args) {

//		ConfigurableApplicationContext ctx = SpringApplication.run(MaintenanceApplication.class, args);
//		PostRepository postRepository = ctx.getBean(PostRepository.class);
//		Post post1 = new Post();
//		post1.setName("Бухгалтерия");
//		postRepository.save(post1);
//
//		Post post2 = new Post();
//		post2.setName("Плановый отдел");
//		postRepository.save(post2);
//
//		CompanyRepository companyRepository = ctx.getBean(CompanyRepository.class);
//		Company company1 = new Company();
//		company1.setName("ООО Артис");
//		companyRepository.save(company1);
//
//		Company company2 = new Company();
//		company2.setName("ОАО Юстас");
//		companyRepository.save(company2);
//

	}

}
