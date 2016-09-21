package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Service Implementation for managing Product.
 */
@Service
public class ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductService.class);
    
    @Inject
    private ProductRepository productRepository;

    /**
     * Save a product.
     *
     * @param product the entity to save
     * @return the persisted entity
     */
    public Product save(Product product) {
        log.debug("Request to save Product : {}", product);
        Product result = productRepository.save(product);
        return result;
    }

    /**
     *  Get all the products.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public Page<Product> findAll(Pageable pageable) {
        log.debug("Request to get all Products");
        Page<Product> result = productRepository.findAll(pageable);
        return result;
    }

    /**
     *  Get one product by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public Product findOne(String id) {
        log.debug("Request to get Product : {}", id);
        Product product = productRepository.findOne(id);
        return product;
    }

    /**
     *  Delete the  product by id.
     *
     *  @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.delete(id);
    }
}
