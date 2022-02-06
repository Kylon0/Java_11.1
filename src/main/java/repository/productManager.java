package repository;

import domain.book;
import domain.product;
import domain.smartphone;

public class productManager {
    private productRepository repository;
    product[] products = new product[0];

    public productManager(productRepository repository) {
        this.repository = repository;
    }

    public void add(product product) {
        productRepository.save(product);
    }

    public product[] searchBy(String text) {
        product[] result = new product[0];
        for (product product : productRepository.findAll()) {
            if (matches(product, text)) {
                product[] tmp = new product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(product product, String search) {
        if (product instanceof book) {
            book book = (book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getTitle().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof smartphone) {
            smartphone smartphone = (smartphone) product;
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
