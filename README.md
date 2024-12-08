* Obtain a token:

```curl --location 'http://localhost:8080/authenticate' \
--header 'Content-Type: application/json' \
--data '{
    "username": "admin",
    "password": "admin"
}'
```
* Use the token in subsequent requests as a _**Bearer**_ token:

```
curl --location 'http://localhost:8080/customers' \
--header 'Authorization: Bearer <TOKEN>  ' \
```


* Create loan using `/loan` endpoint like following:

```
curl --location 'http://localhost:8080/loan' \
--header 'Authorization: Bearer <TOKEN>' \
--header 'Content-Type: application/json' \
--data '{
    "customerId": 1,
    "loanAmount": 120.89,
    "interestRate": 0.1,
    "numberOfInstallment": "SIX"
}'
```

* Pay a loan using `/payment` endpoint like following:

```
curl --location 'http://localhost:8080/payment' \
--header 'Authorization: Bearer <TOKEN>' \
--header 'Content-Type: application/json' \
--data '{
    "loanId": 1,
    "amount": 50
}'
```
