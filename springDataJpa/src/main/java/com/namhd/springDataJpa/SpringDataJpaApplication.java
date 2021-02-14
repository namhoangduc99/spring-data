package com.namhd.springDataJpa;

import com.namhd.entity.Book;
import com.namhd.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("com.namhd.repository")
@EntityScan("com.namhd.entity")
public class SpringDataJpaApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		//CRUD operators
		Book book = new Book();
		book.setTitle("The Manager's Path");
		book.setPageCount(200);
		book.setPrice(new BigDecimal("100.00"));
		book.setPublishDate(new Date());
		book.setId(4);
		repository.save(book); //update query because book id 4 already exists.

		Book book1 = new Book();
		book1.setTitle("The Manager's Path");
		book1.setPageCount(300);
		book1.setPrice(new BigDecimal("200.00"));
		book1.setPublishDate(new Date());
		repository.save(book1); //insert query because book id is not set or not found.

		ArrayList<Long> ids = new ArrayList<>();
		ids.add(1L);
		ids.add(2L);
		repository.deleteInBatch(repository.findAllById(ids));

		//String Operators
		List<Book> result;
		result = repository.findByTitle("The Manager's Path");
		System.out.println("======FindByTitle result:");
		for(Book b : result) {
			System.out.println(b);
		}

		result = repository.findByTitleLike("%a%");
		System.out.println("======FindByTitleLike result:");
		for(Book b : result) {
			System.out.println(b);
		}

		result = repository.findByTitleContaining("Manager");
		System.out.println("======FindByTitleContaining result:");
		for(Book b : result) {
			System.out.println(b);
		}

		result = repository.findByTitleStartingWith("Factfullness");
		System.out.println("======FindByTitleStartingWith result:");
		for(Book b : result) {
			System.out.println(b);
		}

		result = repository.findByTitleIgnoreCase("The manager's path");
		System.out.println("======FindByTitleIgnoreCase result:");
		for(Book b : result) {
			System.out.println(b);
		}

		//Relational Operators

		//Logical Operators

		//Date comparisons

		//Ordering results

		//Limiting Query results

		//Traversing nested properties

	}

}
