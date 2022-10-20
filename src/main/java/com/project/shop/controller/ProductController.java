package com.project.shop.controller;


import com.project.shop.model.Product;
import com.project.shop.service.ProductManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductManagmentService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            productService.addProduct(product);
            return new ResponseEntity<>("Product added", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
//        if(productService.isEmpty()) {
//            return new ResponseEntity<>("DB is empty", HttpStatus.NOT_FOUND);
//        }
//        try{
            productService.getAllProducts();
            System.out.println("QUI");
            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @DeleteMapping (path = "{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
        try{
            if (productService.getProductById(id).isPresent()) {
                productService.deleteProduct(id);
                return new ResponseEntity<>("Product is deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/updatePrice/{id}")
    public ResponseEntity<?> updatePrice(@PathVariable("id") long id, double price) {
        try {
            productService.updatePrice(id, price);
            return new ResponseEntity<>("Product is updated", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping (path = "/getProduct/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        try {
            Optional<Product> p = productService.getProductById(id);
            if (p.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(p.get(), HttpStatus.OK);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getAuthor/{author}")
    public ResponseEntity<?> getProductByAuthor(@RequestParam("author") String author) {
        try {
            List<Product> books =  productService.getProductsByAuthor(author);
            if( books.isEmpty()) {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(books, HttpStatus.OK);
            }
        } catch( Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}


