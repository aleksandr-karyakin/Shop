package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "warehouse")
public class WarehouseItem {

    @Id
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "count", nullable = false)
    private Integer count;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public WarehouseItem() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseItem)) return false;
        WarehouseItem that = (WarehouseItem) o;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "WarehouseItem{" +
                "item=" + item +
                ", count=" + count +
                '}';
    }
}
