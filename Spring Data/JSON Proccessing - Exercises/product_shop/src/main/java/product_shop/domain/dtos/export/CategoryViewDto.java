package product_shop.domain.dtos.export;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CategoryViewDto {
    @Expose
    private String category;

    @Expose
    private Integer productCount;

    @Expose
    private BigDecimal averagePrice;

    //total price sum of all products
    @Expose
    private BigDecimal totalRevenue;

    public CategoryViewDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
