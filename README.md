# Basic Banking System

A simple console-based banking application built in Java that allows users to perform basic banking operations with savings account features including interest calculation.

## Features

✨ **Core Features:**
- **Account Management** - Create a savings account with initial balance and interest rate
- **Deposit Money** - Add funds to your account with transaction validation
- **Withdraw Money** - Withdraw funds with sufficient balance checks
- **Check Balance** - View current account balance instantly
- **Apply Interest** - Automatically calculate and apply interest to savings
- **Transaction History** - View complete record of all transactions

## Project Structure

```
Basicbankingsystem.java
├── Account (Parent Class)
│   ├── accountHolder: String
│   ├── balance: double
│   ├── transactionHistory: List<String>
│   ├── deposit()
│   ├── withdraw()
│   └── showHistory()
│
└── SavingsAccount (Child Class)
    ├── interestRate: double
    └── applyInterest()
```

## How to Use

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Terminal/Command Prompt

### Compilation
```bash
javac Basicbankingsystem.java
```

### Running the Application
```bash
java Basicbankingsystem
```

### User Interface

Once the program starts, you'll be prompted to:

1. **Enter Account Holder Name** - Your full name
2. **Enter Initial Balance** - Starting amount (must be positive)
3. **Enter Interest Rate (%)** - Annual interest rate for savings account

Then you'll see a menu with the following options:

```
===== Banking Menu =====
1. Deposit      - Add money to your account
2. Withdraw     - Remove money from your account
3. Check Balance - View current balance
4. Apply Interest - Add interest to your account
5. Show Transaction History - View all transactions
6. Exit         - Close the application
```

## Example Usage

```
Enter account holder name: Abhishek
Enter initial balance: 5000
Enter interest rate (%) for this savings account: 5

===== Banking Menu =====
1. Deposit
2. Withdraw
3. Check Balance
4. Apply Interest
5. Show Transaction History
6. Exit
Choose an option: 1
Enter amount to deposit: 2000
Deposit successful.

Choose an option: 4
Interest applied: 350.0

Choose an option: 5
Transaction History for Abhishek:
- Account opened with balance: 5000.0
- Deposited: 2000.0
- Deposited: 350.0
```

## Input Validation

The system includes robust error handling:

- ✅ **Positive Amount Validation** - Prevents negative or zero deposits/withdrawals
- ✅ **Sufficient Balance Check** - Ensures withdrawal doesn't exceed balance
- ✅ **Number Format Validation** - Handles invalid numeric inputs gracefully
- ✅ **Menu Choice Validation** - Validates menu selections

## Error Handling

| Error | Message |
|-------|---------|
| Negative Deposit | "Deposit amount must be positive." |
| Negative Withdrawal | "Withdrawal amount must be positive." |
| Insufficient Balance | "Insufficient balance." |
| Invalid Number Input | "Invalid number, try again:" |
| Invalid Menu Option | "Invalid option, try again." |

## Class Details

### Account Class
**Purpose:** Base class for all bank accounts

**Methods:**
- `Account(String accountHolder, double initialBalance)` - Constructor
- `getAccountHolder()` - Returns account holder name
- `getBalance()` - Returns current balance
- `deposit(double amount)` - Adds money to account
- `withdraw(double amount)` - Removes money from account
- `showHistory()` - Displays transaction history

### SavingsAccount Class
**Purpose:** Extends Account with interest calculation features

**Methods:**
- `SavingsAccount(String holder, double balance, double rate)` - Constructor
- `applyInterest()` - Calculates and deposits interest based on current balance

## Interest Calculation

Interest is calculated using the formula:
```
Interest = (Current Balance × Interest Rate) / 100
```

Example:
```
Balance: $5000
Interest Rate: 5%
Interest Applied: $250
New Balance: $5250
```

## Key Technologies Used

- **Language:** Java
- **Data Structure:** ArrayList (for transaction history)
- **Input:** Scanner class
- **OOP Concepts:** Inheritance, Encapsulation, Exception Handling

## Future Enhancements

Potential improvements for the banking system:

- 🔐 Account PIN/Password protection
- 💳 Multiple account support
- 📊 Profit/Loss statements
- 🏦 Transfer between accounts
- 📁 File persistence (save/load accounts)
- 🗓️ Date-based transactions
- 💰 Different account types (Checking, Investment, etc.)

## Notes

- All amounts are validated and must be positive numbers
- Transaction history is maintained throughout the session
- Interest calculation uses the current balance at the time of application
- Data is stored in memory and lost when the program exits

## Author

Created by: Abhishek (Saiket System Technologies Task)

## License

This project is open source and available for educational purposes.

---

**Happy Banking! 🏦💰**
