package com.ciazhar.springwebfluxcommandpattern.model.mongo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ciazhar on 11/5/17.
 * <p>
 * [ Documentation Here ]
 */

@Data
@Builder
@Document
public class Product {
    @Id
    private String id;
    private String name;
    private Long price;
    private Integer stock;
}
