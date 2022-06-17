package services;

import classes.Bill;
import classes.MemberAccount;
import common.BalanceException;
import common.BillException;
import enums.EnumBillType;

import java.util.ArrayList;
import java.util.List;

public class BillService{
    private List<Bill> billList = new ArrayList<Bill>();

    private MemberAccountService memberAccountService = new MemberAccountService();

    public Bill createBill(Bill bill) {
        billList.add(bill);
        return bill;
    }

    public Bill getBillById(Long billId) {
        Bill tempBill = new Bill();
        billList.forEach(item -> {
            if (item.getId().equals(billId)) {
                tempBill.setBillType(item.getBillType());
                tempBill.setId(item.getId());
                tempBill.setAmount(item.getAmount());
                tempBill.setMemberAccount(item.getMemberAccount());
                tempBill.setProcessDate(item.getProcessDate());
            }
        });
        return tempBill;
    }

    public Bill getBillByMemberCodeAndId(String memberCode, Long memberId) {
        Bill tempBill = new Bill();
        billList.forEach(item -> {
            if (item.getMemberAccount().getId().equals(memberId) && item.getMemberAccount().getCode().equals(memberCode)) {
                tempBill.setBillType(item.getBillType());
                tempBill.setId(item.getId());
                tempBill.setAmount(item.getAmount());
                tempBill.setMemberAccount(item.getMemberAccount());
                tempBill.setProcessDate(item.getProcessDate());
            }
        });
        return tempBill;
    }

    public Bill payment(String memberCode, MemberAccount accountToPay) throws BalanceException {
        Bill bill = this.getBillByMemberCodeAndId(memberCode,accountToPay.getId());
        if(accountToPay.getBalance() >= bill.getAmount()){
            accountToPay.setBalance(accountToPay.getBalance()-bill.getAmount());
            return bill;
        }else{
            throw new BalanceException("Amount of balance is not available");
        }
    }

    public Bill getBillAndAmount(EnumBillType billType, MemberAccount memberAccount) throws BillException {
        Bill bill = new Bill();
        billList.forEach(e -> {
            if (e.getBillType() == billType && e.getMemberAccount().equals(memberAccount)) {
                bill.setBillType(billType);
                bill.setId(e.getId());
                bill.setBillType(e.getBillType());
                bill.setAmount(e.getAmount());
                bill.setProcessDate(e.getProcessDate());
            }
        });
        if(bill.getId() != null){
            return bill;
        }else{
            throw new BillException("Bill is not available");
        }
    }

    public MemberAccount refund(String memberCode, MemberAccount refundMember){
        Bill bill = this.getBillByMemberCodeAndId(memberCode, refundMember.getId());
        refundMember.setBalance(refundMember.getBalance() + bill.getAmount());
        return refundMember;
    }
}
