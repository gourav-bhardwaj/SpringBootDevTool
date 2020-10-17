package com.docker.dao;

import org.springframework.data.repository.CrudRepository;

import com.docker.bean.Buyer;

public interface IBuyerDAO extends CrudRepository<Buyer, Integer> {

}
