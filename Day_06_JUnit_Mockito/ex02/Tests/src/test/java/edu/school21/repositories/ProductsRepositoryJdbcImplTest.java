package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImplTest {
    ProductsRepository productsRepository;
    EmbeddedDatabase database;
    private final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1, "Product A", 10),
            new Product(2, "Gadget B", 15),
            new Product(3, "Component C", 25),
            new Product(4, "Component X", 8),
            new Product(5, "Device Y", 12),
            new Product(6, "Product Z", 9),
            new Product(7, "Accessory Q", 30),
            new Product(8, "Mechanism M", 22),
            new Product(9, "Part P", 14),
            new Product(10, "Module", 20)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(4, "Component X", 8);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(9, "MicroShem", 59);
    final Product EXPECTED_SAVE_PRODUCT = new Product(11, "AbraCadabra", 11);

    @BeforeEach
    void init ( ) {
        database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(database);
    }
    @Test
    void testFindALL ( ) throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void testFindById ( ) throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, productsRepository.findById(4L).get());
    }

    @Test
    void testUpdate ( ) throws SQLException {
        productsRepository.update(new Product(9, "MicroShem", 59));
        Assertions.assertEquals(productsRepository.findById(9L).get(), EXPECTED_UPDATED_PRODUCT);
    }

    @Test
    void testSave ( ) throws SQLException {
        productsRepository.save(new Product(11, "AbraCadabra", 11));
        Assertions.assertEquals(productsRepository.findById(11L).get(), EXPECTED_SAVE_PRODUCT);
    }

    @Test
    void testDelete ( ) throws SQLException {
        productsRepository.delete(1L);
        Optional<Product> res = productsRepository.findById(1L);
        Assertions.assertFalse(res.isPresent());
    }
    @Test
    void invalidIdToFinById () throws SQLException {
        Optional<Product> optionalProduct =  productsRepository.findById(12512L);
        Assertions.assertEquals(optionalProduct, Optional.empty());
    }

    @AfterEach
    void close ( ) {
        database.shutdown();
    }

}
