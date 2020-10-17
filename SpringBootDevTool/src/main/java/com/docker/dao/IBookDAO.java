package com.docker.dao;

import org.springframework.data.repository.CrudRepository;

import com.docker.bean.Book;

public interface IBookDAO extends CrudRepository<Book, Integer> {

}
