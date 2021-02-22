package com.namhd.springDataJpa;

import com.namhd.entity.*;
import com.namhd.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
@EnableJpaRepositories("com.namhd.repository")
@EntityScan("com.namhd.entity")
public class SpringDataJpaApplication {
	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
		OrderRepository orderRepository = context.getBean(OrderRepository.class);
		CourseRepository courseRepository = context.getBean(CourseRepository.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);

		//CRUD operators
//		Book book = new Book();
//		book.setTitle("The Manager's Path");
//		book.setPageCount(200);
//		book.setPrice(new BigDecimal("100.00"));
//		book.setPublishDate(new Date());
//		book.setId(4);
//		repository.save(book); //update query because book id 4 already exists.
//
//		Book book1 = new Book();
//		book1.setTitle("The Manager's Path");
//		book1.setPageCount(300);
//		book1.setPrice(new BigDecimal("200.00"));
//		book1.setPublishDate(new Date());
//		repository.save(book1); //insert query because book id is not set or not found.
//
//		ArrayList<Long> ids = new ArrayList<>();
//		ids.add(1L);
//		ids.add(2L);
//		repository.deleteInBatch(repository.findAllById(ids));
//
//		//String Operators
//		List<Book> result;
//		result = repository.findByTitle("The Manager's Path");
//		System.out.println("======FindByTitle result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		result = repository.findByTitleLike("%a%");
//		System.out.println("======FindByTitleLike result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		result = repository.findByTitleContaining("Manager");
//		System.out.println("======FindByTitleContaining result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		result = repository.findByTitleStartingWith("Factfullness");
//		System.out.println("======FindByTitleStartingWith result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		result = repository.findByTitleIgnoreCase("The manager's path");
//		System.out.println("======FindByTitleIgnoreCase result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		//Relational Operators
//		result = repository.findByPageCountBetween(100, 200);
//		System.out.println("======FindByPageCountBetween result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		result = repository.findByPageCountGreaterThan(200);
//		System.out.println("======FindByPageCountGreaterThan result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		result = repository.findByPageCountGreaterThanEqual(200);
//		System.out.println("======findByPageCountGreaterThanEqual result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		//Logical Operators
//		result = repository.findByTitleContainingAndPageCountGreaterThan("Path", 200);
//		System.out.println("======findByTitleContainingAndPageCountGreaterThan result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		result = repository.findByTitleNot("ABC");
//		System.out.println("======findByTitleNot result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		//Date comparisons
//		Date date = new SimpleDateFormat("yyyy-mm-dd").parse("2001-01-01");
//		result = repository.findByPublishDateAfter(date);
//		System.out.println("======findByPublishDateAfter result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		//Ordering results
//		result = repository.findByTitleContainingOrderByPageCountAsc("Path");
//		System.out.println("======findByTitleContainingOrderByPageCountAsc result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//
//		//Limiting Query results
//		result = repository.findTopByTitleContainingOrderByPriceAsc("t");
//		System.out.println("======findTopByTitleContainingOrderByPriceAsc result:");
//		for(Book b : result) {
//			System.out.println(b);
//		}
//		//Traversing nested properties
//
//		//Additional query techniques
//		result = repository.queryTwo(200);
//		System.out.println("======queryOne result=======");
//		System.out.println(result);
//
//		Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse("1970-01-01");
//		Date date2 = new SimpleDateFormat("yyyy-mm-dd").parse("2022-01-01");
//		result = repository.queryFive(date1, date2, PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "price")));
//		System.out.println("========queryFive result========");
//		System.out.println(result);
//
//		Page<Book> all = repository.findAll(PageRequest.of(0,1));
//		System.out.println("=========Pageable query result========");
//		System.out.println(all.get().toArray()[0]);
//
//		result = repository.queryFour(date1, PageRequest.of(1,1));
//		System.out.println("=========Pageable query with @Query method=========");
//		System.out.println(result);
//
//		List<Book> all1 = repository.findAll(Sort.by("pageCount", "price"));
//		System.out.println("==========Sorting query result=========");
//		System.out.println(all1);
//
//		List<Book> all2 = repository.findAll(Sort.by(Sort.Direction.ASC, "pageCount").and(Sort.by(Sort.Direction.DESC, "price")));
//		System.out.println("==========Sorting query result 2=========");
//		System.out.println(all2);

		// create a user instance
		User user = new User("John Doe", "john.doe@example.com", "1234abcd");

		// create an address instance
		Address address = new Address("Lake View 321", "Berlin", "Berlin",
				"95781", "DE");

		user.setAddress(address);
		address.setUser(user);

		userRepository.save(user);

		userRepository.findById(1L);
//		System.out.println(userRepository.findById(1L).get());

		Customer customer = new Customer();
		customer.setCustCode("A11011");
		customer.setDispatchAddress("D11011");
		System.out.println("Before save - customer id = " + customer.getId());
		customerRepository.save(customer);
		System.out.println("After save - customer id = " + customer.getId());
		Order order1 = new Order();
		order1.setCustomer(customer);
		order1.setProductCode("DELL001");
		order1.setQuantity(1);
		order1.setPrice(20.0);
		orderRepository.save(order1);

		Order order2 = new Order();
		order2.setCustomer(customer);
		order2.setProductCode("DELL001");
		order2.setQuantity(1);
		order2.setPrice(20.0);
		orderRepository.save(order2);

		Order order3 = new Order();
		order3.setCustomer(customer);
		order3.setProductCode("DELL001");
		order3.setQuantity(1);
		order3.setPrice(20.0);
		orderRepository.save(order3);

		// create a student
		Student student = new Student("John Doe", 15, "8th");

		// save the student
		studentRepository.save(student);

		// create three courses
		Course course1 = new Course("Machine Learning", "ML", 12, 1500);
		Course course2 = new Course("Database Systems", "DS", 8, 800);
		Course course3 = new Course("Web Basics", "WB", 10, 0);

		// save courses
		courseRepository.saveAll(Arrays.asList(course1, course2, course3));

		// add courses to the student
		student.getCourses().addAll(Arrays.asList(course1, course2, course3));

		// update the student
		studentRepository.save(student);

	}

}
