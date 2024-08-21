package vo;

import java.util.Date;

public class PaymentVO {
    private int id;
    private int o_idx;
    private String paymentMethod;
    private double amount;
    private Date paymentDate;

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getO_idx() {
        return o_idx;
    }

    public void setO_idx(int o_idx) {
        this.o_idx = o_idx;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
