- We use `@ColumnTransformer` to transfrom data when reading / writing to DB.
- `AttributeConverter` does the same but, `AttributeConverter` has many flexibility.
- Basically, `AttributeConverter` is used to convert from X to Y where X and Y can be same type.

### Steps

- Create a class that `implements AttributeConverter<X, Y>`
- Annotate class with `@Converter(autoApply = true)`. `autoApply` represends if this converter should be applied automatically. This is additional settings
- (Method 1) Use `@Convert` annotation to explicitly say this needs to be converted
```java
@Convert(converter = AddressConverter.class)
private Address homeAddress;
```

- (Method 2) Apply `AttributeConverter` when building metadata

```java
final Metadata metadata = sources.getMetadataBuilder()
        .applyAttributeConverter(AddressConverter.class)
        .build();
``` 

`applyAttributeConverter` can take one more argument `autoApply`. If we use above method to add `AttributeConverter`, `autoApply` value is set to whatever we set when we created `Converter`.

------

>Run the program and see values in DB + Hibernate will output the query that is executed