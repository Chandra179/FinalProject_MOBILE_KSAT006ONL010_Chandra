# Bank application

## Create a profile
Input : `firstname, lastname, country, username, password, confirm password`

## Login
1. User with empty account <br>
`username` : sum2 <br>
`password` : sum2 <br>

2. User with account <br>
`username` : sum4 <br>
`password` : sum4 <br>

## Accounts
1. List of accounts <br>
  1.1 List of account <br>
  1.1.1 List of transactions <br>
2. Add accounts <br>
  2.1 Add an account <br>
  
## Deposit
1. Make a deposit : Deposit money to specific account

## Transfer
1. Sending account <br>
  1.1 Transfer money to receiver account <br>
2. Receiving account <br>
  2.1 Receive money from sender account <br>
  
## Payment
1. Payer <br>
  1.1 pay money to `payee` <br>
2. Payee <br>
  2.1 payee receive money from `payer`
  
## Test Case
1. Add new Accounts <br>
add new accounts `account name, balance` <br>
2. Create a profile <br>
  2.1 Create account with valid input should success <br>
  2.2 Create account using registed username should failed <br>
  2.3 Create account with invalid confirm password should failed <br>
3. Login <br>
  3.1 Login using registered user should success <br>
  3.2 Login using unregistered user should failed <br>
4. Make a deposit <br>
Make a deposit to specific account <br>
5. Payment <br>
  5.1 Add new payee <br>
  5.2 Make payment `transfer money to payee` <br>
6. Test menu with empty accounts <br>
  6.1 Deposit menu : `show Deposit error`
  6.2 Account menu : `show Add an account with button below`
  6.3 Dashboard menu : `show button ADD ACCOUNT`
  6.4 Transfer menu : `show transfer error`
  6.5 Payment menu : `show payment error`
