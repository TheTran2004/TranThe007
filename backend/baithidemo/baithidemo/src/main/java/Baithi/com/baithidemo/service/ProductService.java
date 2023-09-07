package Baithi.com.baithidemo.service;

import Baithi.com.baithidemo.modes.ProductStatus;
import Baithi.com.baithidemo.product.Product;
import Baithi.com.baithidemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Configurable
public class ProductService {
    final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Product insert(Product product){
        product.setCreatedDate(LocalDateTime.now());
        return productRepository.save(product);
    }
    public Product update(Product product){
        Optional<Product> optionalProduct = productRepository
                .findById(product.getId());
        if(optionalProduct.isPresent()){
            // Tim trong Table Booking xem co Booking nao co ID = ID truyen vao ko???
            return productRepository.save(product);
        }
        return null;
    }

    public Product deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository
                .findById(id);
        if(optionalProduct.isPresent()){
            // Tim trong Table product xem co product nao co ID = ID truyen vao ko???
            Product foundProduct = optionalProduct.get();
            if(foundProduct.getStatus() == ProductStatus.PRODUCT_PENDING){
                foundProduct.setStatus(ProductStatus.PRODUCT_CANCEL);
            }
            return  productRepository.save(foundProduct);
        }
        return null;
    }

    public List<Product> findAll()
    {
        return productRepository.findAll();
    }
    public List<Product> findAllProductActive()
    {
        return  productRepository.findAll().stream()
                .filter(product -> product.isActive()==true)
                .collect(Collectors.toList());
    }

    public List<Product> findAllProductFinish()
    {
        return  productRepository.findAll().stream()
                .filter(product -> product.isFinish()==true)
                .collect(Collectors.toList());
    }

    public List<Product> findAllProductCancel()
    {
        return  productRepository.findAll().stream()
                .filter(product -> product.isCancel()==true)
                .collect(Collectors.toList());
    }
}