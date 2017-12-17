- What if we have two composition for same `@Embeddable` class

```java
final User user = new User();
user.setName("USER");

Address addr = new Address();
addr.setCity("KTM");
addr.setCountry("NEPAL");

Address addr2 = new Address();
addr.setCity("Pokhara");
addr.setCountry("NPL");

user.setHomeAddress(addr);
user.setWorkAddress(addr2);

session.save(user);
```

- You will get `Repeated column in mapping for entity: io.github.atuladhar.aman.T011EmbeddableTwoComposition.User`

### @AttributeOverride

- You can use `@AttributeOverride` to change the column names of `@Embeddable` class
- If you want to modify two or more attributes you wrap `@AttributeOverride` in `@AttributeOverrides`

```java
@AttributeOverrides({
    @AttributeOverride(name = "city", column = @Column(name = "work_city")),
    @AttributeOverride(name = "country", column = @Column(name = "work_country"))
})
private Address workAddress;
```

- Of course, you can use this for `homeAddress` as well. But I will leave that to you.

### Create Schema hibernate invokes

```sql
create table user (
       id bigint not null auto_increment,
        city varchar(255),
        country varchar(255),
        name varchar(255),
        work_city varchar(255),
        work_country varchar(255),
        primary key (id)
) 
```

------

>Run the program and see values in DB + Hibernate will output the query that is executed