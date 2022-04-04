package facade;

import component.Bank;
import component.CentralBank;
import component.Credit;
import component.Customer;

import java.math.BigDecimal;

public class Facade {

    private Bank bank;
    private CentralBank centralBank;
    private Credit credit;

    public Facade() {
        bank = new Bank();
        centralBank = new CentralBank();
        credit = new Credit();
    }

    public void useCredit(Customer customer, BigDecimal demandAmount) {
        if (!centralBank.isOnBlackList(customer.getIdentityNo()) && credit.creditCartUsingState(customer)) {
            bank.useCredit(customer,demandAmount);
            System.out.println("credit request result: successful");
        }
    }
}
