- We need to store list of String as addresses for User
- If we add `private List<String> address = new ArrayList<>();` line, we will get error.
- We will get `Could not determine type for: java.util.List, at table: user`

### @ElementCollection

- We can use @ElementCollection to use store these kind of values
- If we try to save the values
```java
final User user = new User();
user.setName("USER");
user.setAddress(Arrays.asList("a1", "a2"));
session.save(user);
```
- Hibernate will create two tables.
- One to store User address, and other to store address values

```sql
create table user (
   id bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine=InnoDB
    
create table user_address (
   user_id bigint not null,
    address varchar(255)
) engine=InnoDB
```
- Notice the Address table name. This is the default strategy. We will look at how to change this in next topic.
- Hibernate also adds foreign key constraint on `user_address`
```sql
alter table user_address 
add constraint FKk2ox3w9jm7yd6v1m5f68xibry
foreign key (user_id) 
references user (id)
```
- This is SQL way to saying these two tables are related.
- When we delete user, address related to users are also deleted

------

>Run the program and see values in DB + Hibernate will output the query that is executed