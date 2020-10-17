package com.docker.service;

import java.util.List;
import com.docker.bean.Book;

public interface IBookService {
	Book saveBook(Book book);
	boolean updateBook(Book book);
	boolean deleteBook(int bookId);
	Book getBook(int bookId);
	List<Book> getBooks();
}
