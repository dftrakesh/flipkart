package io.github.dft.flipkart.model.productapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWrapper extends ArrayList<Product> {
    private List<Product> products;
}
