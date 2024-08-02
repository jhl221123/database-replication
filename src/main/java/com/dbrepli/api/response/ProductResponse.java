package com.dbrepli.api.response;

import com.dbrepli.domain.Product;

import lombok.Builder;

@Builder
public record ProductResponse(Long id, String name, Integer price) {

	public static ProductResponse of(Product product) {
		return ProductResponse.builder()
			.id(product.getId())
			.name(product.getName())
			.price(product.getPrice())
			.build();
	}
}
