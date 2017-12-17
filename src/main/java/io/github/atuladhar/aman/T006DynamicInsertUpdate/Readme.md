- Given `User` class has multiple columns when we try to **insert** data to database.
- Hibernate will use query that tries to **insert** values to all the columns, eventhough they are not set.
- Hibernate generates the query before hand and uses it to interact with DB.
- This is very good behaviour as generating query at runtime could be expensive.
- But sometime we may not want to use this feature.
- Sometime if our **_columns values are too big like blob_**, this could be performance issues
- If you want to use the query that only **inserts/updates** only those values that you set
- You can use `@DynamicInsert` and `@DynamicUpdate`


> Remove @DynamicInsert / @DynamicUpdate annotation and observe the query to see the change



------

>Run the program and see values in DB + Hibernate will output the query that is executed