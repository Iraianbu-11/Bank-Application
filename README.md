# Banking Application
# Task 1

The initial customers details for our banking system will be in a file bank_db.txt

The file contains multiple lines and every line will be of the form



| CusId | Account | Name | Balance | Password |
|-------|---------|------|---------|----------|
| 1     | 11001   | Raja | 10000   | ABswer12 |


# Task 2

1. Add New Customer
2. Customer ID and Account Should be Unique
3. Assume Default balance of 10000
4. Persist the Customer Details in file
5. For Password ask customer to reenter the password to ensure its proper

# Task 3

Encrypt Password

The encryption rule is very simple add +1 to original char to encrypt it 'a will be encrypted as 'b'


m as n, z as a (wrap around)
\
1 as 2 , 9 as 0 , 0 as 1
\
A as B , C as D , Z as A

# Task 4

Authenticate User with Customer ID and Password

# Task 5

Support basic ATM Operation on successful authentication

1. Cash Deposit
2. Withdrawal (Minimum Balance is 1000)
3. Money Transfer

# Task 6

1. Persist Transaction History for each bank operation if file.
2. Customer can view the transaction information

| T-ID | Type    | Amount | Balance |
|------|---------|--------|---------|
| 1    | Opening | 10000  | 10000   |
| 2    | Deposit | 10000  | 20000   |


Transaction ID is auto incremented value starting from 1