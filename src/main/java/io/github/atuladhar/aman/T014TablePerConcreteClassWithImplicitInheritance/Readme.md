# Strategies or mapping Inheritance on Hibernate
1. `TABLE PER CONCRETE CLASS WITH IMPLICIT POLYMORPHISM`
2. `TABLE PER CONCRETE CLASS WITH UNIONS`
3. `TABLE PER HIERARCHY`
4. `TABLE PER SUBCLASS WITH JOINS`

# TABLE PER CONCRETE CLASS WITH IMPLICIT POLYMORPHISM

- If you use implicit polymorphism, you map concrete classes with @Entity, as usual. 
- By default, properties of the superclass are ignored and not persistent
- You have to annotate the superclass with `@MappedSuperclass` to enable embedding of its properties in the concrete subclass tables
