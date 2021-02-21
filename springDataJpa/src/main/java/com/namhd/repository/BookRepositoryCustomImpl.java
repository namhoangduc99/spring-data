package com.namhd.repository;

import com.namhd.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom{
    private static Logger logger = LoggerFactory.getLogger(BookRepositoryCustomImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveAndLog(Book book) {
        logger.info("Saving the book entity " + book.toString());
        entityManager.persist(book);
    }
}
