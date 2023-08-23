package edu.school21.models;

import java.util.Objects;

public class Product {
    private Integer id;
    private String name;
    private Integer cost;

    public Product ( Integer id, String name, Integer cost ) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Integer getCost ( ) {
        return cost;
    }

    public void setCost ( Integer cost ) {
        this.cost = cost;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(cost, product.cost);
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash(id, name, cost);
    }

    @Override
    public String toString ( ) {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
