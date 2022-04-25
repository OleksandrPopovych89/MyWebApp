package oleksandrpopovych89.logic.essence;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Integer orderId;
    List<Equipment> equipmentList = new ArrayList<>();

    public Order(Integer orderName, List<Equipment> equipmentList) {
        this.orderId = orderName;
        this.equipmentList = equipmentList;
    }

    public Order(Equipment equipment) {
    }

    public Order() {

    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderNumber) {
        this.orderId = orderNumber;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public void remove(int index) {
        equipmentList.remove(index);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", equipmentList=" + equipmentList +
                '}';
    }
}
