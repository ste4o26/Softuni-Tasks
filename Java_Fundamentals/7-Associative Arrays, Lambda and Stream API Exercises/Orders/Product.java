package Orders;

public class Product {
        private String name;
        private double price;
        private int quantity;
        private double totalPrice;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return this.name;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return this.price;
        }

        public int getQuantity() {
            return this.quantity;
        }

        public double getTotalPrice() {
            return this.totalPrice;
        }
    }

