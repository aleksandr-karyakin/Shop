package model;

import javax.persistence.*;

@Entity
@Table(name = "deliveryOrders")
@PrimaryKeyJoinColumn(name="order_id")
public class DeliveryOrder extends Order {

    @Column(name = "address")
    private String address;

    public DeliveryOrder() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
