
# Using Maven or Gradle project.
 ```bash
 gradle init --type java-application
 ```

 # Add `hibernate-entitymanager` as your project dependency
 ```bash
 # as of writing 5.2.12.Final is latest
 compile group: 'org.hibernate', name: 'hibernate-entitymanager', version: '5.2.12.Final'
 compile group: 'mysql', name: 'mysql-connector-java', version: '6.0.6'

```

`hibernate-entitymanager` includes all the dependencies that you need like `hibernate-core`.

We will be using Java based configuration to setup our hibernate project.

Configuration are managed at: `HibernateUtil.java`. 

In order to interact with DB we need a hold of `Session`.
To get the `Session` we need `SessionFactory`.

SessionFactory needs different information in order to create a session. Some of them are
- DB_URL
- DB_PASSWORD
- DB_PASSWORD
- DIALECT

In order to set this values in Hibernate we can use `StandartServiceRegistryBuilder`.
The role of the ServiceRegistry is to provide a flexible way of bootstrapping Hibernate services.

-----

For generating getter and setters I am using lombok
To auto scan the packages with entity class I am using fluent-hibernate API.


------

> Run the program and see values in DB + Hibernate will output the query that is executed

