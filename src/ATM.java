import java.util.Scanner;
public class ATM {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        USER_ACCOUNT account =new USER_ACCOUNT("3464577003",3010,3500);
        System.out.println("WELCOME TO MY ATM PROGRAM");
        while (true) {
            System.out.println("Please Enter Your Password : ");
            int input_password= input.nextInt();
            if (account.CheckIfPasswordIsWrong(input_password)) {
                System.out.println("Access granted.");
                break;
            } else {
                System.out.println("Wrong Password Try Again.");
            }
        }
        int choice;
        do {
            System.out.println("__________MENU_________");
            System.out.println(" 1-Show balance ");
            System.out.println(" 2-Deposit");
            System.out.println(" 3-Withdraw");
            System.out.println(" 4-Exist");
            System.out.println("------------------------");
            System.out.println("Enter Your Choice From 1 To 4 : ");
            choice= input.nextInt();
            switch (choice){
                case 1:
                    account.ShowBalance();
                    break;
                case 2:
                    System.out.println("Your LastTransaction is: " + account.getLastTransaction());
                    System.out.println("Enter Your Deposit Amount : ");
                    double Amount_d= input.nextDouble();
                    if(Amount_d<=0.0){
                        System.out.println("Amount Must Be Positive!");
                    }
                    else{
                        account.getDeposit(Amount_d);
                        account.ShowBalance();
                    }
                    break;
                case 3:
                    System.out.println("Your LastTransaction is: " + account.getLastTransaction());
                    System.out.println("Enter Your Withdraw Amount : ");
                    double Amount_w= input.nextDouble();
                    if(Amount_w<=0.0){
                        System.out.println("Amount Must Be Positive!");
                    }
                    else{
                        account.getWithdraw(Amount_w);
                        account.ShowBalance();
                    }
                    break;
                case 4:
                    System.out.println("Thank You For Using The ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }while(choice !=4);

        input.close();
    }


}
class USER_ACCOUNT {
    private String CardNumber;
    private int password;
    private double balance;
    private double deposit;
    private double withdraw;
    private String LastTransaction;
    public USER_ACCOUNT(String CardNumber, int password,double balance){
        this.CardNumber=CardNumber;
        this.password=password;
        this.balance=balance;
        deposit=0.0;
        withdraw=0.0;
        LastTransaction="No Transaction Yet";
    }
    public boolean CheckIfPasswordIsWrong(int input){
        return input==password;
    }
    public void ShowBalance(){
        System.out.println("Your Balance Is : " + balance +"$" );
    }

    public String getLastTransaction() {
        return LastTransaction;
    }
    public void getDeposit(double amount ) {
        balance+= amount;
        LastTransaction= "Deposited " + amount  +"$";
        System.out.println("Deposit Successful");


    }
    public void getWithdraw(double amount) {
        if (amount> balance) {
            System.out.println("Not Enough Balance");
        }
        else{
            balance-=amount;
            LastTransaction= "Withdrawn " + amount +"$";
            System.out.println("withdrawal Successful");
        }

    }
}







