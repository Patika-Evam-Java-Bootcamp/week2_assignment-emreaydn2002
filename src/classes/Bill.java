package classes;

import enums.EnumBillType;

import java.time.LocalDateTime;
import java.util.Objects;

public class Bill {
    private Long id;
    private Double amount;
    private EnumBillType billType;
    private LocalDateTime processDate;
    private MemberAccount memberAccount;

    public Bill() {
    }

    public Bill(Long id, Double amount, EnumBillType billType, LocalDateTime processDate, MemberAccount memberAccount) {
        this.id = id;
        this.amount = amount;
        this.billType = billType;
        this.processDate = processDate;
        this.memberAccount = memberAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public EnumBillType getBillType() {
        return billType;
    }

    public void setBillType(EnumBillType billType) {
        this.billType = billType;
    }

    public LocalDateTime getProcessDate() {
        return processDate;
    }

    public void setProcessDate(LocalDateTime processDate) {
        this.processDate = processDate;
    }

    public MemberAccount getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(MemberAccount memberAccount) {
        this.memberAccount = memberAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id.equals(bill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", billType=" + billType +
                ", processDate=" + processDate +
                ", memberAccount=" + memberAccount +
                '}';
    }
}
