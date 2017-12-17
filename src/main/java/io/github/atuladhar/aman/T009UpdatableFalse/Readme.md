- If you want your data to be inserted and never update you can use `updatable = true` on `@Column` annotation.
- Eg: If entity has `creatingDate` you should never update that field.

------

>Run the program and see values in DB + Hibernate will output the query that is executed