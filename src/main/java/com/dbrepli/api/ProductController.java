package com.dbrepli.api;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbrepli.api.request.ProductCreateRequest;
import com.dbrepli.api.response.ProductResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductController {

	private final ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<ProductResponse> create(@RequestBody ProductCreateRequest request) {
		ProductResponse response = productService.create(request);
		return ResponseEntity.status(CREATED).body(response);
	}

	@GetMapping("products/{id}")
	public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
		ProductResponse response = productService.find(id);
		return ResponseEntity.status(OK).body(response);
	}


	@GetMapping("/products")
	public ResponseEntity<List<ProductResponse>> findAll() {
		List<ProductResponse> response = productService.findAll();
		return ResponseEntity.status(OK).body(response);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
