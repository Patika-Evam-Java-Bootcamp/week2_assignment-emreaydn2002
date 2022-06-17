package enums;

public enum EnumBillType {
    PHONE_BILL(0, "PHONE_BILL"),
    ETHERNET_BILL(1, "ETHERNET_BILL"),
    WATER_BILL(2, "WATER_BILL");

    private Integer valueOf;
    private String name;

    EnumBillType(Integer valueOf, String name) {
        this.valueOf = valueOf;
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
