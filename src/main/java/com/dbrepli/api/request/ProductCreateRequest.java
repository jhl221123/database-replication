package com.dbrepli.api.request;

import lombok.Builder;

@Builder
public record ProductCreateRequest(String name, Integer price) {
}
