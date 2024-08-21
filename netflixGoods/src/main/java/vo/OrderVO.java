package vo;

import java.util.Date;

public class OrderVO {
    private int o_idx;
    private int u_idx;
    private int total;
    private String status;
    private Date orderDate;

    // Getter and Setter methods
    public int getO_idx() {
        return o_idx;
    }

    public void setO_idx(int o_idx) {
        this.o_idx = o_idx;
    }

    public int getU_idx() {
        return u_idx;
    }

    public void setU_idx(int u_idx) {
        this.u_idx = u_idx;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
