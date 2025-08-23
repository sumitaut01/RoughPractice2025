package basics.designpattern.builder;

public class Product {

    String productName;
    double productPrice;
    String prodDescription;

    //Private Constructor
    public Product(ProductBuilder productBuilder){
        this.prodDescription=productBuilder.prodDescription;
    };

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", prodDescription='" + prodDescription + '\'' +
                '}';
    }


    static class ProductBuilder{
        String productName;
        double productPrice;
        String prodDescription;
        public ProductBuilder(String prodDescription) {
            this.prodDescription = prodDescription;
        }

        public ProductBuilder() {}

        public ProductBuilder setProdDescription(String prodDescription) {
            this.prodDescription= prodDescription;
            return this;
        }

        public Product Build(){
            return new Product(this);
        }

        public ProductBuilder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;
        }
    }


}
