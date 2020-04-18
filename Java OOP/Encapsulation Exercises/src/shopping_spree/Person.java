package shopping_spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        Validator.validateNotEmptyName(name);
        this.name = name;
    }

    private double getMoney() {
        return this.money;
    }

    private void setMoney(double money) {
        Validator.validateNotNegativeMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (canPersonAffordTheProduct(product)) {
            double money = getMoney();
            money -= product.getCost();
            setMoney(money);

            addProduct(product);

            System.out.println(MessageCreator.boughtProductMessage(this, product));
        } else {
            MessageCreator.cantAffordProductMessage(this, product);
        }
    }

    private boolean canPersonAffordTheProduct(Product product) {
        return this.getMoney() >= product.getCost();
    }

    private void addProduct(Product product) {
        this.products.add(product);
    }

    public int getProductsCount() {
        return this.products.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName() + " - ");

        if (this.getProductsCount() == 0) {
            sb.append("Nothing bought");
            return sb.toString();
        } else {
            products.forEach(product -> sb.append(product.getName() + ", "));
            return sb.toString().substring(0, sb.length() - 2);
        }
    }
}
