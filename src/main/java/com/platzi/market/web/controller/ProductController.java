package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> listProduct = productService.getAll();
        return listProduct.size()>0
                ? new ResponseEntity<>(listProduct, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int idProduct) {
        return productService.getProducto(idProduct)
                .map(product -> new ResponseEntity<>(product, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{idCatg}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("idCatg") int idCategoria) {
       return productService.getByCategoria(idCategoria)
               .map(listProducts -> new ResponseEntity<>(listProducts, HttpStatus.FOUND))
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int idProduct) {
        return productService.delete(idProduct)
                ? new ResponseEntity<>(true,HttpStatus.OK)
                : new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
