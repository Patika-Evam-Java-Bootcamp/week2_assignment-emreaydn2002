package classes;

public class MemberAccount{
    private Long id;
    private String name;
    private String surname;
    private String code;
    private Double balance;
    private String phoneNumber;

    public MemberAccount() {
    }

    public MemberAccount(Long id, String name, String surname, String code, Double balance, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.code = code;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "MemberAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", code='" + code + '\'' +
                ", balance='" + balance + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
