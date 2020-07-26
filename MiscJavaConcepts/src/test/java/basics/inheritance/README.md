# INHERITANCE
### Definition:
Getting the features or properties of one class from another class is called as Inheritance. 
1. The class from which other class acquires the features is called as Super class or Parent class or
Base class.
2. The class which acquires the features or properties is called as Sub class or Child class or Derived
Class. 
3. Through Inheritance we can achieve:
1. Extensibility. 
2. Code Optimization. 
3. Code Re-usability. 
4. Code Maintainability. 

To Achieve inheritance between classes, we should use Extends keyword. 
There are 4 types of Inheritance:

1. Single Level inheritance. 
2. Multilevel inheritance. 
3. Hybrid Inheritance. 
4. Multiple inheritance. 

1. Single Level inheritance: One class inheriting from only one Super class. 
2. Multilevel inheritance: One class inheriting from another Sub class. 
3. Hybrid Inheritance: Two or more class inheriting from common Super class. 
4. Multiple inheritance: One class inheriting from multiple immediate Super class. Note: Multiple inheritance is not possible is java through Classes instead happens through Interfaces

### Note: 
Only non-static members of a class will be involved in Inheritance.


# Super:

### Definition:
super keyword is used to access super class non-static members in case of inheritance between
classes. 
1. Has Effective use in method overriding than inheritance. 
2. Due to method overriding super class implementation will be masked in the sub class. 
3. To get the original/masked implementation in sub class we can use super keyword. 
4. To avoid overrriding use Final keyword. 
5. Declare class as Final then no method can be overridden. 

Super Calling Statement:
1. Super Calling Statement is used to call Super Class Constructor in case of inheritance between
Classes. 
2. Super Calling Statement will call immediate Super constructor in case of inheritance.
3. Through Super Calling Statement we can achieve Constructor Chaining. 
4. Constructor Chaining means Sub class Constructor calling its immediate Super class
Constructor. 

Rule: If there is inheritance between classes then Constructor chaining is mandatory(Rule of Java)

###Note: 
If there is inheritance between classes and if the Programmer has not developed super classing
statement inside the constructor then there will be a default Super calling constructor statement
developed by the Compiler
i.e.,Super();Default Super calling statement will always be without “Arguments”

### Rules for Super class:
1. Super Calling Statement should always be the first statement inside the class. 
2. We can develop maximum one super calling statement inside the constructor. 
3. Super Calling Statement can be used to call only constructor. 
4. If the Programmer has not developed either this() or super(), then compiler will develop the
default Super Calling Statement. 
5. If the Programmer writes this calling Statement then 

### Similarity between this and Super calling statement. 
1. Both are used to call Constructor. 
2. Both should be first statement inside the constructor. 
3. Both can be developed only inside constructor. 
4. Both this and super Calling Statement cannot be developed inside a constructor simultaneously at
a time. 
5. Both this and Super Calling Statement cannot be developed 


