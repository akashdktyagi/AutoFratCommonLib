# Static
1. We can have Single copy of static members. 
2. If you want to have only one copy of any member e should declare the member with keyword
static. 
3. If the requirements is fixed then we should go for static members. 
4. Ex: addition() logic.

6. Whenever we need to have multiple copy of any member we should go for non-static. 
7. If the requirements is not fixed then we should go for non-static members
8. Ex: salary(), percentage()

### Note-1:
1. Method arguments are also Local Variables. 
2. We can call a method by supplying the value through variables. 
3. Local variables can have same name across different methods. 
4. Local variables are method members and created when method enter into stack and destroyed when method leaves the stack after execution. 

### Note-2:
1. Global variables will reside in the heap memory, it will be there till the end of program. 
2. If its STATIC , will be in static pool(class Variable). 
3. If its NON-STATIC, will be in Object space(Instance Variable).

### Note-3:
1. By default, local variables value is not assigned. Programmer should assign it. 
2. Before using any variables it should have some value. 
3. Global variables will be assigned with default value. 
4. Local variables will not be assigned with default value. 
5. Global variables can b e used without initializing it explicitly. 
6. Local variables should be initialized before usage. 
7. Static means 1 copy, non-static means multiple copy. 
8. Any kind of variables(static.non-static) can be FINAL

### Note-4:
1. By default, local variables value is not assigned. Programmer should assign it. 
2. Before using any variables it should have some value. 
3. Global variables will be assigned with default value. 
4. Local variables will not be assigned with default value.
5. Global variables can b e used without initializing it explicitly. 
6. Local variables should be initialized before usage. 
7. Static means 1 copy, non-static means multiple copy. 
8. Any kind of variables(static.non-static) can be FINAL

# Final

1. Final is a keyword. 
2. If you want to declare constant variable where-in value cannot be changed then those variable
should be declared with the keyword “Final”. 
3. Final variable value cannot be changed or overridden. 
4. Both local and global variable can be Final. 
5. Global Final variables should be initialized at the time of declaration itself. 
6. Local Final variables can be declared once and initialized later. 

### Note:
1. Static members of the same class can be accessed directly. 
2. Local variables will be given preference over Global Variables.

