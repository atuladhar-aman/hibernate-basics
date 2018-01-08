# Many to one Association
- A many-to-one entity association maps naturally to a foreign key column: college_id in the user table
- @JoinColumn can be use to rename the join column
- @JoinColumn nullable = false to make the foreign key column NOT NULL when Hibernate generates the SQL schema. 
- A user always has to have a reference to an collegue; it can’t survive on its own