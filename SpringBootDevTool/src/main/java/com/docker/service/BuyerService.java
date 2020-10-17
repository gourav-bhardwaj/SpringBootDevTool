package com.docker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docker.bean.Buyer;
import com.docker.dao.IBuyerDAO;

@Service
public class BuyerService implements IBuyerService {

	@Autowired
	private IBuyerDAO buyerDao;
	
	@Override
	public Buyer saveBuyer(Buyer buyer) {
		try {
			if (buyer != null) {
				return buyerDao.save(buyer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateBuyer(Buyer buyer) {
		try {
			if (buyer != null && buyer.getBuyerId() > 0) {
				buyerDao.save(buyer);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBuyer(int buyerId) {
		Optional<Buyer> buyerObj = buyerDao.findById(buyerId);
		if (buyerObj.isPresent()) {
			buyerDao.delete(buyerObj.get());
			return true;
		}
		return false;
	}

	@Override
	public Buyer getBuyer(int buyerId) {
		return buyerDao.findById(buyerId).get();
	}

	@Override
	public List<Buyer> getBuyers() {
		List<Buyer> list = new ArrayList<Buyer>();
		buyerDao.findAll().forEach(list::add);
		return list;
	}

}
