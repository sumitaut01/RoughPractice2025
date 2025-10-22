package oopsbank;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        SavingsAccount savingsAccount1=new SavingsAccount(1234,500, 500);
        savingsAccount1.depositMoney(500);

        System.out.println(savingsAccount1.getBalance());//1500

        Account account2=new SavingsAccount(1, 100, 500);
        account2.depositMoney(700);
        System.out.println(account2.getBalance());//800




        SavingsAccount savingsAccount3=new SavingsAccount(12344,500, 500);
        System.out.println(savingsAccount3.getBalance());//500


        List<Account> lstAct=new ArrayList<>();

        lstAct.add(savingsAccount1);
        lstAct.add(account2);
        lstAct.add(savingsAccount3);

        System.out.println("----Separator--");
       lstAct.forEach(acct-> System.out.println(acct.getAccountNumber()));
       //12340
        //1
        //123440




        Comparator<Account> accComp= Comparator.comparingInt(Account::getAccountNumber);
        lstAct.sort(accComp);
        lstAct.forEach(acct-> System.out.println(acct.getAccountNumber()));
        //1
        //1234
        //12344

        //this also works
        Comparator<Account> accComp3= (a,b)->-Integer.compare(a.getAccountNumber(),b.getAccountNumber());
        lstAct.sort(accComp3);
        lstAct.forEach(acct-> System.out.println(acct.getAccountNumber()));
        //12344
        //1234
        //1

        System.out.println("--------------------Filtering with Streams------");
        SavingsAccount savingsAccount11=new SavingsAccount(12,500, 500);
        SavingsAccount savingsAccount22=new SavingsAccount(200,500, 500);
        SavingsAccount savingsAccount33=new SavingsAccount(300,500, 500);

        List<Account> filtered=lstAct.stream().filter(i->i.getAccountNumber()>100).collect(Collectors.toList());

        filtered.forEach(f-> System.out.println(f.getAccountNumber()));
        //--------------------Filtering with Streams------
        //12344
        //1234



        //trying to store object state via serialization
        System.out.println("Serialization");
        SavingsAccount s1=new SavingsAccount(1234, 200, 300);
        SavingsAccount s2=new SavingsAccount(12340, 2000, 3000);

        List<SavingsAccount> lSavings=new ArrayList<>();
        lSavings.add(s1);
        lSavings.add(s2);


        ObjectOutputStream ois=new ObjectOutputStream(new FileOutputStream("Savings.ser"));
        ois.writeObject(s1);


        //Deseriali
        ObjectInputStream oiss=new ObjectInputStream(new FileInputStream("Savings.ser"));
        SavingsAccount x1= (SavingsAccount) oiss.readObject();
        System.out.println(s1.getAccountNumber());//1234



        //below code erroring out.. see later
//        System.out.println("Deseriali");
//        List<SavingsAccount> lSavingsx=new ArrayList<>();
//        lSavingsx.add(new SavingsAccount(1, 1, 1));
//        lSavingsx.add(new SavingsAccount(11, 11, 11));
//        ObjectOutputStream oistx=new ObjectOutputStream(new FileOutputStream("SavingsList1.ser"));
//
//        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("SavingsList1.ser"));
//        List<SavingsAccount> lSavingsobjx= (List<SavingsAccount>) inputStream.readObject();
//        lSavingsobjx.forEach(l-> System.out.println(l.getAccountNumber() +" "+l.getBalance()));


    }
}
