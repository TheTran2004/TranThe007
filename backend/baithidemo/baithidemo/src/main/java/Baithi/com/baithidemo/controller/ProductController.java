package Baithi.com.baithidemo.controller;

import Baithi.com.baithidemo.product.Product;
import Baithi.com.baithidemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                productService.findAll());
    }
    @GetMapping("/findAllProductActive")
    public ResponseEntity<?> findAllProductActive()
    {
        return ResponseEntity.ok(productService.findAllProductActive());
    }
    @GetMapping("/findAllProductCancel")
    public ResponseEntity<?> findAllProductCancel()
    {
        return ResponseEntity.ok(productService.findAllProductCancel());
    }
    @GetMapping("/findAllProductFinish")
    public ResponseEntity<?> findAllBookingFinish()
    {
        return ResponseEntity.ok(productService.findAllProductFinish());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product){
        return ResponseEntity.ok(productService.update(product));

    }
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Product product){
        return ResponseEntity.ok(productService.insert(product));

    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
