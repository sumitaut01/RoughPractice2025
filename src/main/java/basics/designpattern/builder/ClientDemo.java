package basics.designpattern.builder;
public class ClientDemo {
    public static void main(String[] args) {
     Product product=new Product.ProductBuilder()
             .setProdDescription("from model")
             .setProductName("dummy product")
             .setProdDescription("description")
             .Build();
        System.out.println(product.toString());//Product{productName='null', productPrice=0.0, prodDescription='from model'}
    }
}
