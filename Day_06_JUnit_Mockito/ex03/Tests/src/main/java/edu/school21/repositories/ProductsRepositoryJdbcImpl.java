package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {
    private final DataSource dataSource;
    private final String selectQuery = "SELECT * FROM tests.product WHERE id = ?";
    private String insertQuery = "INSERT INTO tests.product (id, name, cost) VALUES ( ?, ?, ?);";
    private String updateQuery = "UPDATE tests.product SET name = ?, cost = ? WHERE id = ?;";
    private final String allQuery = "SELECT * FROM tests.product;";
    private final String deleteQuery = "DELETE FROM tests.product WHERE id = ?";


    public ProductsRepositoryJdbcImpl ( DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll ( ) {
        List<Product> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(allQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while ( resultSet.next() ) {
                Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                result.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Invalid connection");
        }
        return result;
    }

    @Override
    public Optional<Product> findById ( Long id ) {
        Optional<Product> optionalMessage = Optional.empty();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            optionalMessage = Optional.of(new Product(resultSet.getInt(1), resultSet.getString("name"), resultSet.getInt("cost")));
        } catch (SQLException e) {
            e.getMessage();
        }
        return optionalMessage;

    }

    @Override
    public void update ( Product product ) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getCost());
            preparedStatement.setInt(3, product.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Invalid connection");
        }
    }

    @Override
    public void save ( Product product ) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getCost());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Invalid connection");
        }
    }

    @Override
    public void delete ( Long id ) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Invalid connection");
        }
    }
}
