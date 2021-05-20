# BCP Spring JDBC Oracle

Template (starter) form spring-jdbc with Oracle DB

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

alter table "CUSTOMER_ADDR_TST" add constraint CUST_FK foreign key("CUSTOMER_ID") references "CUSTOMER_TST"("ID");
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