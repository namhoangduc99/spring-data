package com.namhd.springDataJpa;

import com.namhd.entity.Book;
import com.namhd.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories("com.namhd.repository")
@EntityScan("com.namhd.entity")
public class SpringDataJpaApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);
		Book book = new Book();
		book.setTitle("The Manager's Path");
		book.setPageCount(200);
		book.setPrice(new BigDecimal("100.00"));
		book.setPublishDate(new Date());

		repository.save(book);

		System.out.println("=======Book list: " + repository.findAll());
	}

}
