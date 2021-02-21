package com.namhd.repository;

import com.namhd.entity.Book;

public interface BookRepositoryCustom {
    public void saveAndLog(Book book);
}
