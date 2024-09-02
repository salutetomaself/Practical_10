class Account(var balance: Double) {
 
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    if (amount <= balance) {
      balance -= amount
    } else {
      println(s"Insufficient funds. Current balance: $balance")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    } else {
      println(s"Insufficient funds for transfer. Current balance: $balance")
    }
  }

  def checkBalance: Double = balance

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else if (balance < 0) {
      balance += balance * 0.1
    }
  }

  override def toString: String = s"Account(balance = $balance)"
}

class Bank(val accounts: List[Account]) {
  
  def accountsWithNegativeBalances: List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def totalBalance: Double = {
    accounts.map(_.balance).sum
  }

  def applyInterestToAllAccounts(): Unit = {
    accounts.foreach(_.applyInterest())
  }

  def printAllAccounts(): Unit = {
    accounts.foreach(account => println(account))
  }
}

object BankTest extends App {
 
  val acc1 = new Account(1000);
  val acc2 = new Account(-500);
  val acc3 = new Account(200)
  val acc4 = new Account(-300)

  val bank = new Bank(List(acc1, acc2, acc3, acc4))

  val negativeAccounts = bank.accountsWithNegativeBalances
  println("Accounts with negative balances:")
  negativeAccounts.foreach(println)

  val total = bank.totalBalance
  println(s"Total balance of all accounts: $total")

  bank.applyInterestToAllAccounts()
  println("Final balances after applying interest:")
  bank.printAllAccounts()
}
