package com.namhd.repository;

import com.namhd.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByTitle(String title);

    //derived query - string operator
    public List<Book> findByTitleLike(String title);
    public List<Book> findByTitleContaining(String title);
    public List<Book> findByTitleStartingWith(String title);
    public List<Book> findByTitleEndingWith(String title);
    public List<Book> findByTitleIgnoreCase(String title);

    //derived query - relational operator
    //relatinal operators only apply when we finding by a field that implements Comparable interface
    // PageCount field in this example is of type int, it is autobox to Integer type and it implements Comparable.
    public List<Book> findByPageCountEquals(int pageCount);
    public List<Book> findByPageCountGreaterThan(int pageCount);
    public List<Book> findByPageCountGreaterThanEqual(int pageCount);
    public List<Book> findByPageCountBetween(int min, int max);

    //logical operator
    public List<Book> findByTitleContainingOrTitleContaining(String title, String title2);
    public List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
    public List<Book> findByTitleNot(String title);

    //date comparisons
    public List<Book> findByPublishDateAfter(Date date);
    public List<Book> findByPublishDateBefore(Date date);
    public List<Book> findByPublishDateBetween(Date date, Date date2);

    //ordering result
    public List<Book> findByTitleContainingOrderByPageCountAsc(String title);

    //limiting result
    public List<Book> findTopByOrderByPageCountDesc();
    public List<Book> findFirstByOrderByPageCountAsc();
    public List<Book> findTop5ByTitleContainingOrderByPriceAsc(String title);
    public List<Book> findTopByTitleContainingOrderByPriceAsc(String title);

    //transversing nested properties
    //when book and author has a many to one relationship. Book entity has 1 property named Author. Author has 1 property named firstName
    //we want to find all the book that its author firstName is "Alex"
    //public List<Book> findByAuthorFirstName(String firstName);
    //public List<Book> findByAuthor_Country(String country); --> make it clear for Spring JPA to build the query
}
