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

import com.docker.bean.Buyer;
import com.docker.service.IBuyerService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
	
	@Autowired
	private IBuyerService buyerService;
	
	@PostMapping("/save")
	public ResponseEntity<Map<String, Object>> saveBuyer(@RequestBody Buyer buyer) {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", buyerService.saveBuyer(buyer));
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updateBuyer(@RequestBody Buyer buyer) {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", buyerService.updateBuyer(buyer));
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteBuyer(@PathVariable("id") int buyerId) {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", buyerService.deleteBuyer(buyerId));
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getBuyer(@PathVariable("id") int buyerId) {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", buyerService.getBuyer(buyerId));
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> getBuyers() {
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("data", buyerService.getBuyers());
		return new ResponseEntity<Map<String,Object>>(body, HttpStatus.OK);
	}

}
