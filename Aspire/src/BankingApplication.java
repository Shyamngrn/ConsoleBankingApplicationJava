import java.util.HashSet;
import java.util.Scanner;

public class BankingApplication {
	
	static HashSet<UserDetails> hashSet = new HashSet<UserDetails>();
	static Scanner scanner=new Scanner(System.in);
	JDBC jdbc=new JDBC();
	
	 void addUser() 
	{
		UserDetails userDetails = new UserDetails();
		userDetails.setUserDetails();
		hashSet.add(userDetails);
		
	}
	 void viewBalance() throws NonExistingUser
	 {
		 System.out.println("Enter unique ID to view balance");
		 int uniqueID=scanner.nextInt();
		 int count=0;
		 for(UserDetails details:hashSet){
			 
			 if(details.getUniqueNumber()==uniqueID)
			 {
			 details.getUserDetails();
			 break;
			 }
			 else
				 count++;
			 if(count==hashSet.size() || hashSet.size()==0)
			 {
				 throw new NonExistingUser("User not found");
			 }
			
			 }
				 
	 }
	 
	 void withdrawAmount() throws InsufficientFundsException
	 {
		 float amount=0;
		 System.out.println("Enter unique ID to withdraw amount");
		 int uniqueID=scanner.nextInt();
		 for(UserDetails details:hashSet){
			 if(details.getUniqueNumber()==uniqueID)
			 {
				 System.out.println("Enter WithdrawAmount");
				 amount=scanner.nextFloat();
			     details.setAcctBalance(amount);
				 
			 }
		 }
	 }
	 
	 void depositAmount() 
	 {
		 float amount=0;
		 System.out.println("Enter unique ID to deposit amount");
		 int uniqueID=scanner.nextInt();
		 for(UserDetails details:hashSet){
			 if(details.getUniqueNumber()==uniqueID)
			 {
				 System.out.println("Enter depositAmount");
				 amount=scanner.nextFloat();
				 details.setDepositAmount(amount);
			 }
		 }
	 }
	 void transferAmount() throws InsufficientFundsException
	 {
		 float amount=0;
		 System.out.println("Enter unique ID of Sender to debit amount");
		 int uniqueIDSender=scanner.nextInt();
		 System.out.println("Enter unique ID of reciever to credit amount");
		 int uniqueIDReciever=scanner.nextInt();
		 System.out.println("Enter amount to transfer");
		 amount=scanner.nextFloat();
		 for(UserDetails details:hashSet){
			 if(details.getUniqueNumber()==uniqueIDSender)
			 {
				 for(UserDetails details1:hashSet)
				 {
				 if(details1.getUniqueNumber()==uniqueIDReciever)
				 {
				   details.setAcctBalance(amount);
				   details1.setDepositAmount(amount);
				   break;
				 }
				 }
				 
				 
			 }
		 }
	 }

	public static void main(String[] args)  {
		
		int userChoice=0;
		BankingApplication bankingApplication=new BankingApplication();
		while(userChoice!=6)
		{
			System.out.println("\nEnter choice :-\n1.Add User \n2.Withdraw Amount \n3.Deposit Amount \n4.View Balance \n5.Transfer Amount \n6.Exit");
			userChoice=scanner.nextInt();
			switch(userChoice)
			{
			case 1:
				bankingApplication.addUser();
				break;
			case 2:
				try {
					bankingApplication.withdrawAmount();
				} catch (InsufficientFundsException exception1) {
					System.out.println("Exception occured "+exception1);
				}
				break;
			case 3:
				bankingApplication.depositAmount();
				break;
			case 4:
				try {
					bankingApplication.viewBalance();
				} catch (NonExistingUser exception2) {
					System.out.println("Exception occured "+exception2);
				}
				break;
			case 5:
				try {
					bankingApplication.transferAmount();
				} catch (InsufficientFundsException exception) {
					System.out.println("Exception occured "+exception);
				}
				break;
			case 6:break;
			default:
				System.out.println("INVALID CHOICE");
				break;
			
			}
			}
		System.out.println("Thankyou !!");

}
}
