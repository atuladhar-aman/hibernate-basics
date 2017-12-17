- You may sometimes, need to represent one data in two form
- For example: height of user can be save on inches and centimeter
- It is not good practice to store same value twice
- We can use `@Formula` to achive this issue
- Any fields that are annotated with `@Formula`, hibernate doesn't create column for those in DB
- When we try to get those entities from DB, hibernate fetch the values by using formula provided

### How to use
```java
private Long heightInInches;

@Formula("height_in_inches * 2") // random conversion
@Setter(AccessLevel.PRIVATE) // user cannot set height on centimeter
private Long heightInCentimeter;
```

- You can see `heightInCentimeter` has `@Formula` annotation.
- We provide the formula that needs to be applied
- Notice the column name used, we need to use database column name not entities property names.
- I added private setter because we don't need setter here. (This is optional)
- When we query entity it will fire following query.

```sql
select
        user0_.id as id1_0_0_,
        user0_.height_in_inches as height_i2_0_0_,
        user0_.height_in_inches * 2 as formula0_0_ # <----- Look at this line here
    from
        user user0_ 
    where
        user0_.id=?
``` 

------

>Run the program and see values in DB + Hibernate will output the query that is executed