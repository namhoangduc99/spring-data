package com.namhd.repository;

import com.namhd.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
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

    //additional query techniques
    //@Query
    @Query("select b from Book b")
    public List<Book> queryOne();

    @Query("select b from Book b where b.pageCount > ?1")
    public List<Book> queryTwo(int pageCount);

    @Query("select b from Book b where b.title = :title")
    public List<Book> queryThree(@Param("title") String title, Sort sort);

    public List<Book> queryFour(@Param("date") Date publishDate, Pageable page);

    public List<Book> queryFive(@Param("date1") Date date1, @Param("date2") Date date2, Pageable page);

    public Page<Book> querySix(@Param("date") Date publishDate, Pageable page);

    public Iterable<Book> querySeven(@Param("date") Date publishDate);
}
