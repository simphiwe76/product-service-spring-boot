package com.hopewell.productservice.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record Manufacture (
        String country,
        String address
) {}
