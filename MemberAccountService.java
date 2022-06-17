package services;

import classes.MemberAccount;

import java.util.ArrayList;
import java.util.List;

public class MemberAccountService {
    private List<MemberAccount> memberAccountList = new ArrayList<MemberAccount>();

    public MemberAccount create(MemberAccount memberAccount) {
        memberAccountList.add(memberAccount);
        return memberAccount;
    }

    public List<MemberAccount> getMemberAccounts() {
        return memberAccountList;
    }

    public MemberAccount getOneById(Long memberId) {
        MemberAccount tempMemberAccount = new MemberAccount();
        memberAccountList.forEach(memberAccount -> {
            if (memberAccount.getId().equals(memberId)) {
                tempMemberAccount.setId(memberAccount.getId());
                tempMemberAccount.setBalance(memberAccount.getBalance());
                tempMemberAccount.setCode(memberAccount.getCode());
                tempMemberAccount.setSurname(memberAccount.getSurname());
                tempMemberAccount.setPhoneNumber(memberAccount.getPhoneNumber());
            }
        });
        return tempMemberAccount;
    }

    public MemberAccount updateAccount(MemberAccount memberToUpdate) {
        memberAccountList.forEach(memberAccount -> {
            if (memberAccount.getId().equals(memberToUpdate.getId())) {
                memberAccount.setId(memberToUpdate.getId());
                memberAccount.setBalance(memberToUpdate.getBalance());
                memberAccount.setCode(memberToUpdate.getCode());
                memberAccount.setSurname(memberToUpdate.getSurname());
                memberAccount.setPhoneNumber(memberToUpdate.getPhoneNumber());
            }
        });
        return memberToUpdate;
    }

    public boolean deleteAccount(Long memberId) {
        return memberAccountList.removeIf(memberAccount -> memberAccount.getId().equals(memberId));
    }

    public MemberAccount getMemberAccountByCode(String memberCode) {
        MemberAccount tempMemberAccount = new MemberAccount();
        memberAccountList.forEach(memberAccount -> {
            if (memberAccount.getCode().equals(memberCode)) {
                tempMemberAccount.setId(memberAccount.getId());
                tempMemberAccount.setBalance(memberAccount.getBalance());
                tempMemberAccount.setCode(memberAccount.getCode());
                tempMemberAccount.setSurname(memberAccount.getSurname());
                tempMemberAccount.setName(memberAccount.getName());
                tempMemberAccount.setPhoneNumber(memberAccount.getPhoneNumber());
            }
        });
        return tempMemberAccount;
    }

    public String setMemberCode(String customerName, Long id) {
        return customerName.substring(0, 2) + id.toString();
    }

}
