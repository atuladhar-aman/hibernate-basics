# TABLE PER CONCRETE CLASS WITH IMPLICIT POLYMORPHISM

- You can override the column name of super class by using `@AttributeOverride`

# Pros
- separate SQL query for each concrete subclass.

# Cons
- Different tables, share exactly the same database semantics. 
- Schema evolution can be complex. 
- It also makes it much more difficult to implement database integrity constraints that apply to all subclasses.