package repository;

import domain.product;

public class productRepository {
    private static product[] items = new product[0];

    public static void save(product item) {
        int length = items.length + 1;
        product[] tmp = new product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        product[] tmp = new product[length];
        int index = 0;
        for (product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
    public static product[] findAll() {
        return items;
    }
}