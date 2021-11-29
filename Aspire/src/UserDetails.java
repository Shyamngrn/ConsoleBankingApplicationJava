import java.util.Scanner;

class UserDetails {
	
	private String firstName;
	private String lastName;
	private int uniqueNumber;
	private int userAge;
	private float acctBalance;
	UserDetails()
	{
		acctBalance=0;
	}
	public float getAcctBalance()
	{
		return acctBalance;
	}
	public void setAcctBalance(float withdrawAmount) throws InsufficientFundsException 
	{
		if(acctBalance<withdrawAmount)
		{
			throw new InsufficientFundsException("Insufficient Funds");
		}
		else
		{
		acctBalance-=withdrawAmount;
		JDBC jdbc=new JDBC();
		jdbc.setAcctBalance(uniqueNumber,acctBalance);
		System.out.println("Amount Withdrawn for UniqueID "+this.uniqueNumber+" = "+withdrawAmount+"\n New balance = "+acctBalance);
		}
	}
	public int getUniqueNumber()
	{
		return uniqueNumber;
	}
	public void setDepositAmount(float depositAmount)
	{
		acctBalance+=depositAmount;
		System.out.println("Amount Deposited for uniqueID "+this.uniqueNumber+" = "+depositAmount+"\n New balance="+acctBalance);

		
	}
	public void setUserDetails()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter FirstName , LastName , UniqueNumber , UserAge ");
		this.firstName=scanner.next();;
		this.lastName=scanner.next();
		this.uniqueNumber=scanner.nextInt();
		this.userAge=scanner.nextInt();
		JDBC jdbc =new JDBC();
		jdbc.addUserDetails(firstName, lastName, uniqueNumber, userAge, 0);
		System.out.println("User Added Successfully");
		
	}
	
	public void getUserDetails() {
		
		System.out.println("First Name : "+this.firstName+"\nLast Name : "+this.lastName+"\nUnique Number : "+this.uniqueNumber+"\nUser Age : "+this.userAge+"\nAcct Balance : "+this.acctBalance);
	}

}
