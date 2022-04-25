package oleksandrpopovych89.logic.essence;

public class Equipment {
    private Integer eqId;
    private String name;
    private String shortName;
    private String vendorName;
    private String vendorCode;
    private String units;
    private Integer quantity;

    public Equipment(Integer eqId, String name, String shortName, String vendorName, String vendorCode, String units, Integer quantity) {
        this.eqId = eqId;
        this.name = name;
        this.shortName = shortName;
        this.vendorName = vendorName;
        this.vendorCode = vendorCode;
        this.units = units;
        this.quantity = quantity;
    }

    public Equipment() {
    }

    public Integer getEqId() {
        return eqId;
    }

    public void setEqId(Integer eqId) {
        this.eqId = eqId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "eqId=" + eqId +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", vendorCode='" + vendorCode + '\'' +
                ", units='" + units + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
