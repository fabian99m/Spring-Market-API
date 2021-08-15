package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("Get all supermarket products.")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> listProduct = productService.getAll();
        return listProduct.size() > 0
                ? new ResponseEntity<>(listProduct, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find a product with an id.")
    @ApiResponses({
            @ApiResponse(code = 302, message = "Found"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<Product> getProduct(@PathVariable("id") int idProduct) {
        return productService.getProducto(idProduct)
                .map(product -> new ResponseEntity<>(product, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @ApiOperation("Find a product with a category id.")
    @ApiResponses({
            @ApiResponse(code = 302, message = "Found"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @GetMapping("/category/{idCatg}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("idCatg") int idCategoria) {
        return productService.getByCategoria(idCategoria)
                .map(listProducts -> new ResponseEntity<>(listProducts, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @ApiOperation("Save a product.")
    @ApiResponse(code = 201, message = "Created")
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }


    @ApiOperation("Delete a product with a given id.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int idProduct) {
        return productService.delete(idProduct)
                ? new ResponseEntity<>(true, HttpStatus.OK)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
