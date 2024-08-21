package vo;

import java.util.Date;

public class ProductsVO {
    private int p_idx;
    private String name;
    private String description;
    private int price;
    private int stock;
    private String category;
    private int isSellable;
    private Date registeredAt;
    private int userIdx;

    // Getter and Setter methods
    public int getP_idx() {
        return p_idx;
    }

    public void setP_idx(int p_idx) {
        this.p_idx = p_idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIsSellable() {
        return isSellable;
    }

    public void setIsSellable(int isSellable) {
        this.isSellable = isSellable;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }
}
