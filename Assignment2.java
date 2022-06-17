/**
 * @Author EmreAydin
 * @Date 2022/06/16
 * EVAM Bootcamp Assignment 2
 */

package assignment_2;

import classes.Bill;
import classes.MemberAccount;
import enums.EnumBillType;
import services.BillService;
import services.MemberAccountService;

import java.time.LocalDateTime;

public class Assignment2 {
    public static void main(String[] args) throws Exception {
        System.out.printf("assignment2");

        MemberAccountService memberAccountService = new MemberAccountService();
        BillService billService = new BillService();

        //Suppose that a DTO has been transfererd from UI to create a memberAccount;
        MemberAccount memberAccount = new MemberAccount();
        memberAccount.setId(1L); //Suppose that id parameter returned form a sequence generator from database
        memberAccount.setName("Emre");
        memberAccount.setSurname("Aydin");
        memberAccount.setBalance(1000.0);
        memberAccount.setPhoneNumber("905547505043");
        memberAccount.setCode(memberAccountService.setMemberCode(memberAccount.getName(),memberAccount.getId()));

        //member has been created with the given informations.
        memberAccountService.create(memberAccount);
        System.out.println("Member Account has been created as given below:");
        System.out.println(memberAccount);

        //Suppose that a DTO has been transfererd from UI to create a bill;
        Bill bill = new Bill();
        bill.setAmount(90.0);
        bill.setBillType(EnumBillType.PHONE_BILL);
        bill.setProcessDate(LocalDateTime.now());
        bill.setId(1L);     //Suppose that id parameter returned form a sequence generator from database
        bill.setMemberAccount(memberAccount);

        billService.createBill(bill);
        System.out.println("Members Bill Has been created as like given below:");
        System.out.println(bill);

        //Finding a bill
        Bill foundedBill = billService.getBillByMemberCodeAndId(memberAccount.getCode(),memberAccount.getId());
        System.out.println("The Bill founded by service is:");
        System.out.println(foundedBill);

        //Found Member
        MemberAccount foundMember = memberAccountService.getMemberAccountByCode(memberAccount.getCode());
        System.out.println("The Member Account founded by service is:");
        System.out.println(foundMember);

        //Paying a bill
        Bill paidBill = billService.payment(memberAccount.getCode(),memberAccount);
        System.out.println("The Bill paid by service is:");
        System.out.println(paidBill);

        //Cancel a paid Bill
        MemberAccount refundMember = billService.refund(memberAccount.getCode(),memberAccount);
        System.out.println("The Bill refund by service is:");
        System.out.println(refundMember);

        //Find a bill and its amount
        Bill foundBill = billService.getBillAndAmount(EnumBillType.PHONE_BILL,memberAccount);
        System.out.println("The Bill found by service is:");
        System.out.println(foundBill);

        //If bill could not found
        System.out.println("If Bill couldnt found then exception is like given below:");
        Bill foundBill2 = billService.getBillAndAmount(EnumBillType.ETHERNET_BILL,memberAccount);
        System.out.println(foundBill2);
    }
}
