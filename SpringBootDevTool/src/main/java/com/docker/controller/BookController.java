package com.docker.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.bean.Book;
import com.docker.service.IBookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IBookService bookService;

	@PostMapping("/save")
	public ResponseEntity<Map<String, Object>> saveBook(@RequestBody Book book) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", bookService.saveBook(book));
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updateBook(@RequestBody Book book) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", bookService.updateBook(book));
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable("id") int bookId) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", bookService.deleteBook(bookId));
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getBook(@PathVariable("id") int bookId) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", bookService.getBook(bookId));
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> getBooks() {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", bookService.getBooks());
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}
	
}
