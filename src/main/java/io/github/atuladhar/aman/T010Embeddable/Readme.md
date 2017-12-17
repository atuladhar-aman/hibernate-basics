- In Java, you can have composition relation between two objects.
- i.e
```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Address homeAddress;
}
``` 

If you try to persist this type of relation

```java
final User user = new User();
user.setName("USER");

Address addr = new Address();
addr.setCity("KTM");
addr.setCountry("NEPAL");

user.setHomeAddress(addr);

session.save(user);
```

You will get `Could not determine type for: io.github.atuladhar.aman.T010Embeddable.Address`

In order to remove that error we need to add @Embeddable annotation in `Address`

The basic strategy that hibernate uses for this is to create a column for each item that exist on `Address` class.

```sql
create table user (
       id bigint not null auto_increment,
        city varchar(255),
        country varchar(255),
        name varchar(255),
        primary key (id)
)
```


------

>Run the program and see values in DB + Hibernate will output the query that is executed