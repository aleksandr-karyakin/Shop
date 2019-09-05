package model;

import javax.persistence.*;

@Entity
@Table(name = "prepaymentOrders")
@PrimaryKeyJoinColumn(name="order_id")
public class PrepaymentOrder extends Order {

    @Column(name = "prepayment")
    private Integer prepayment;

    public PrepaymentOrder() {
    }

    public Integer getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(Integer prepayment) {
        this.prepayment = prepayment;
    }
}
