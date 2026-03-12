package com.momed.spring7restmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {
    private UUID id;
    private Integer version;
    private String customerName;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
