package pojo;

import java.util.List;


public class PriceRequest {
    private String countryCode;
    private String companyCode;
    private String customerBranch;
    private String customerNumber;
    private boolean isOrder;
    private String clientSystem;
    private List<PriceRequestLine> priceRequestLines;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "PriceRequest{" +
                "countryCode='" + countryCode + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", customerBranch='" + customerBranch + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", isOrder=" + isOrder +
                ", clientSystem='" + clientSystem + '\'' +
                ", priceRequestLines=" + priceRequestLines +
                '}';
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCustomerBranch() {
        return customerBranch;
    }

    public void setCustomerBranch(String customerBranch) {
        this.customerBranch = customerBranch;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isOrder() {
        return isOrder;
    }

    public void setOrder(boolean order) {
        isOrder = order;
    }

    public String getClientSystem() {
        return clientSystem;
    }

    public void setClientSystem(String clientSystem) {
        this.clientSystem = clientSystem;
    }

    public List<PriceRequestLine> getPriceRequestLines() {
        return priceRequestLines;
    }

    public void setPriceRequestLines(List<PriceRequestLine> priceRequestLines) {
        this.priceRequestLines = priceRequestLines;
    }

    // Getters and Setters for all fields...
}