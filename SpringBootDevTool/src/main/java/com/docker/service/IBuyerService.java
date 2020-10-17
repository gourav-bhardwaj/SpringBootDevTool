package com.docker.service;

import java.util.List;

import com.docker.bean.Buyer;

public interface IBuyerService {
	Buyer saveBuyer(Buyer buyer);
	boolean updateBuyer(Buyer buyer);
	boolean deleteBuyer(int buyerId);
	Buyer getBuyer(int buyerId);
	List<Buyer> getBuyers();
}
