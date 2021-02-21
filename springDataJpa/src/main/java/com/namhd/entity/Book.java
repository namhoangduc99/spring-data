package com.namhd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="BOOK")
@NamedQueries({@NamedQuery(name = "Book.queryFour", query = "select b from Book b where b.publishDate > :date"),
        @NamedQuery(name = "Book.queryFive", query = "select b from Book b where b.publishDate between :date1 and :date2"),
        @NamedQuery(name = "Book.querySix", query = "select b from Book b where b.publishDate between :date1 and :date2"),
        @NamedQuery(name = "Book.querySeven", query = "select b from Book b where b.publishDate between :date1 and :date2")})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int pageCount;
    private BigDecimal price;
    private Date publishDate;
}
