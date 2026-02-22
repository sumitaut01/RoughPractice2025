package restassured.restassuredwork.pojos;

import lombok.Data;

import java.util.List;

@Data
class Customer {
    private String id;
    private String tier;
    private Preferences preferences;
}

@Data
class Preferences {
    private String currency;
    private List<String> notifications;
}

@Data
class Item {
    private String sku;
    private String type;
    private Object details; // Use Map<String, Object> or specific subclass if keys change
    private Pricing pricing;
}

@Data
class Pricing {
    private double unit_price;
    private int quantity;
    private double discount;
}

@Data
class Financials {
    private double subtotal;
    private List<TaxBreakdown> tax_breakdown;
    private double total_payable;
}

@Data
class TaxBreakdown {
    private String state;
    private double rate;
    private double amount;
}

@Data
class History {
    private String event;
    private String timestamp;
}