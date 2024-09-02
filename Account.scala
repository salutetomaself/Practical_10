class Account(var balance: Double) {

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
    println(s"Deposited $amount. New balance: $balance")
  }

  
  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    if (amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println(s"Insufficient funds. Current balance: $balance")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $amount to another account.")
    } else {
      println(s"Insufficient funds for transfer. Current balance: $balance")
    }
  }

  def checkBalance: Double = balance
}

object AccountTest extends App {
  val account1 = new Account(1000)
  val account2 = new Account(500)

  account1.deposit(200) 

  account1.withdraw(300) 

  account1.transfer(400, account2) 

  println(s"Final balance of Account 1: ${account1.checkBalance}")
  println(s"Final balance of Account 2: ${account2.checkBalance}")
}
