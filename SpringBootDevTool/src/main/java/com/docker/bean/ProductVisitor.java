package com.docker.bean;

public class ProductVisitor implements IProductVisitor {

	@Override
	public float visit(Book book) {
		if (book.getDiscount() > 0) {
			float disAmt = ((book.getPrice() * book.getDiscount()) / 100);
			return (book.getPrice() - disAmt);
		}
		return book.getPrice();
	}

}
