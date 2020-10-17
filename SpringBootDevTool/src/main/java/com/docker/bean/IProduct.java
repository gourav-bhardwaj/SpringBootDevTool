package com.docker.bean;

public interface IProduct {
	float actualAmount(IProductVisitor visitor);
}
