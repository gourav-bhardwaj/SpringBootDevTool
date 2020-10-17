package com.docker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.bean.Book;
import com.docker.dao.IBookDAO;

@Service
public class BookService implements IBookService {

	@Autowired
	private IBookDAO bookDao;
	
	
	@Override
	public Book saveBook(Book book) {
		try {
			if (Objects.nonNull(book)) {
				return bookDao.save(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateBook(Book book) {
		try {
			if (Objects.nonNull(book) && book.getBookId() > 0) {
				bookDao.save(book);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBook(int bookId) {
		Optional<Book> book = bookDao.findById(bookId);
		if (book.isPresent()) {
			bookDao.delete(book.get());
			return true;
		}
		return false;
	}

	@Override
	public Book getBook(int bookId) {
		return bookDao.findById(bookId).get();
	}

	@Override
	public List<Book> getBooks() {
		List<Book> bookList = new ArrayList<Book>();
		bookDao.findAll().forEach(bookList::add);
		return bookList;
	}

}
