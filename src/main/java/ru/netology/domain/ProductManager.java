package ru.netology.domain;

public class ProductManager {

    ProductRepository repo = new ProductRepository();

    public ProductManager() {
    }

    public void add(Product product) {
        repo.save(product);
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
