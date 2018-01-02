# TABLE PER HIERARCHY

- Maps an entire class hierarchy to a single table. 
- This table includes columns for all properties of all classes in the hierarchy. 
- The value of an extra type discriminator column or formula identifies the concrete subclass represented by a particular row.

- There is one major problem: data integrity. You must declare columns for properties declared by subclasses to be nullable
- Issue of normalization