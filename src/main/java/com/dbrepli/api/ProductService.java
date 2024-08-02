package com.dbrepli.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dbrepli.api.request.ProductCreateRequest;
import com.dbrepli.api.response.ProductResponse;
import com.dbrepli.domain.Product;
import com.dbrepli.domain.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductResponse create(ProductCreateRequest request) {
		Product product = Product.builder()
			.name(request.name())
			.price(request.price())
			.build();
		Product savedProduct = productRepository.save(product);
		return ProductResponse.of(savedProduct);
	}

	public ProductResponse find(Long id) {
		return ProductResponse.of(
			productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"))
		);
	}

	public List<ProductResponse> findAll() {
		return productRepository.findAll().stream()
			.map(ProductResponse::of)
			.toList();
	}

	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
