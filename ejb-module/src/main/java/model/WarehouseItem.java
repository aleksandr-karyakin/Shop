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

    public WarehouseItem() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
        return Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return "WarehouseItem{" +
                "itemId=" + itemId +
                ", count=" + count +
                '}';
    }
}
