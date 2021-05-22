# BCP Spring JDBC Oracle

Template (starter) form spring-jpa with Oracle DB.  
Controller receives Customer (with Addrs) and save all (parent and child entities).

## Test

Get a customer:
```console
curl --location --request GET 'http://localhost:8080/customer/131'
```
Save a customer:
```console
curl --location --request POST 'http://localhost:8080/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Bruno",
    "lastName": "Proenca",
    "addrs": [
        {
            "country": "US",
            "city": "BBBB"
        },
        {
            "country": "BR",
            "city": "AAAA"
        }
    ]
}'
```

### Config Env:

Run `create-table.sql` script:

```sql
CREATE TABLE CUSTOMER_TST 
(
  ID NUMBER NOT NULL 
, FIRST_NAME VARCHAR2(50) 
, LAST_NAME VARCHAR2(50) 
, CONSTRAINT CUSTOMER_TST_PK PRIMARY KEY 
  (ID) ENABLE 
);

CREATE SEQUENCE CUSTOMER_SEQ_TST
  MINVALUE 10
  MAXVALUE 9999999999
  START WITH 10
  INCREMENT BY 3;

CREATE TABLE CUSTOMER_ADDR_TST 
(
  ID NUMBER NOT NULL 
, CUSTOMER_ID NUMBER NOT NULL 
, COUNTRY VARCHAR2(20) NOT NULL 
, CITY VARCHAR2(20) 
, CONSTRAINT CUSTOMER_ADDR_TST_PK PRIMARY KEY 
  (ID) ENABLE 
);

ALTER TABLE CUSTOMER_ADDR_TST
ADD CONSTRAINT CUST_FK FOREIGN KEY (CUSTOMER_ID)
REFERENCES CUSTOMER_TST (ID)
ON DELETE CASCADE ENABLE;

CREATE VIEW VIEW_CUSTOMER_TST AS SELECT * FROM CUSTOMER_TST;
```

Configure database properties in `application.properties` file.

### Run Project

```console
mvn spring-boot:run
```
(or) passing parameters:
```console
mvn spring-boot:run \
 -Dspring-boot.run.arguments=" \
 --SPRING_DATASOURCE_USERNAME=BCP \
 --SPRING_DATASOURCE_PASSWORD=BCP \
 --SPRING_DATASOURCE_URL=jdbc:oracle:thin:@localhost:1522:xe \
 --server.port=8080"
 ```