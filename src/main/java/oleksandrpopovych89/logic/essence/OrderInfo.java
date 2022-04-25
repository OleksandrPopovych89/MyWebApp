package oleksandrpopovych89.logic.essence;

import java.sql.Date;

public class OrderInfo {
    private Integer orderId;
    private Date dateOfCreate;
    private Date dateOfLastSave;

    public OrderInfo(Integer orderNumber, Date dateOfCreate, Date dateOfLastSave) {
        this.orderId = orderNumber;
        this.dateOfCreate = dateOfCreate;
        this.dateOfLastSave = dateOfLastSave;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderId = orderNumber;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Date getDateOfLastSave() {
        return dateOfLastSave;
    }

    public void setDateOfLastSave(Date dateOfLastSave) {
        this.dateOfLastSave = dateOfLastSave;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderNumber=" + orderId +
                ", dateOfCreate=" + dateOfCreate +
                ", dateOfLastSave=" + dateOfLastSave +
                '}';
    }
}
