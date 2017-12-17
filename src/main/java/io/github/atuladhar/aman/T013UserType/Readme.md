- In hibernate we can create our own type: `UserType`
- We need to create a class that implements `UserType`: Look at `AddressUserType`
- We need to define the types. Usually, we declare type on `package-info.java` but I am currently not able to implement solution that uses `package-info.java`.
- We define type on  `User` class using `@TypeDef` because we are going to use the type there
- We can wrap multiple `@TypeDef` on `@TypeDefs`

```java
@TypeDefs({
    @TypeDef(name = "address_type", typeClass = AddressUserType.class)
})
```

- To use it we need to use `@Type` annotation with name of type
```java
@Type(type = "address_type")
private Address homeAddress;
```

# TODO: when using hibernate only, how to define Types with help of package-info.java


------

>Run the program and see values in DB + Hibernate will output the query that is executed