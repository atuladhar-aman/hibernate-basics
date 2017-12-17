- If you want to change the table name it is as simple as using `@Column` annotation.
- `@Column` annotation has attribute `name` where, you can pass your custom column name.
- Notice, we were not using `@Column` annotation before, but still hibernate was creating columns for them in DB.

------

>Run the program and see values in DB + Hibernate will output the query that is executed