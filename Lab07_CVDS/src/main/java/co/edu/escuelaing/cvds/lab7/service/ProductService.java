package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Product;
import co.edu.escuelaing.cvds.lab7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;
import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public Product partialUpdateProduct(int id, Product partialProduct) {
        Optional<Product> existingProduct = productRepository.getProductById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
                updatedProduct.setName(partialProduct.getName());
                updatedProduct.setDescription(partialProduct.getDescription());
                updatedProduct.setCategory(partialProduct.getCategory());
                updatedProduct.setRating(partialProduct.getRating());
                updatedProduct.setPrice(partialProduct.getPrice());
                updatedProduct.setQuantity(partialProduct.getQuantity());

            return productRepository.updateProduct(updatedProduct);
        } else {
            return null;
        }



}
