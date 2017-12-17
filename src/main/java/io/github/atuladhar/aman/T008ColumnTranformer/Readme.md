- You may sometimes, need to store value on db as one type, and in object represent that data as different type
- For example: on DB height is saved as centimeter, and in object height is represented as inches
- We can use `@ColumnTransformer` to achive this issue
- When we try to get those entities from DB, hibernate fetch the values by using formula provided

### How to use
```java
@ColumnTransformer(
    read = "height_in_inches / 2", // convert db values to object value (read)
    write = "? * 2" // convert object value to db value (insert / update)
)
private Long heightInInches;
```
### SQL fired
```sql
# WRITE
    insert 
    into
        user
        (height_in_inches) 
    values
        (? * 2)

# READ
    select
        user0_.id as id1_0_0_,
        user0_.height_in_inches / 2 as height_i2_0_0_ 
    from
        user user0_ 
    where
        user0_.id=?
``` 

------

>Run the program and see values in DB + Hibernate will output the query that is executed