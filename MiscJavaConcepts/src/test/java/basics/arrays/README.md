# Arrays

1. Arrays are contiguous memory allocation where-in we can store homogeneous element(similar
kind of element) which will share the common name.
2. If you want to store the collection of similar data, then we can use arrays. To store the huge collection of similar data, best approach is arrays because memory allocation
will be continuous due to which processing will be faster. 
3. Ex: If you want to store 100 integer data, best approach is arrays. If arrays are not used then we
have to use 100 different variables.

## Limitations of Arrays:
1. Size is fixed i.e., once an array is created with some size it cannot be expanded or compressed i.e., arrays size in not flexible. <br>
2. Some times we may waste the memory or sometimes we may need additional memory. <br>
3. In arrays we can store only homogeneous data or elements. <br>
4. There are very less built-in functionality in array.


## Note: 
Arrays are treated as Objects in Java.
There are 2 types of Arrays:
1. Primitive Array:
The arrays in which we can store simple data like integer, fractional value etc., is called as
Primitive array. 
2. Object Array:
The array in which we can store object reference is called as Derived array or Object Array. <br>

### General Syntax for Declaration and Initialization:

type[] refvar = new type[size];

### General Syntax to store element into Array:
refvar[index] = value;

### Example:
rv = new int [5];


| 0  | 1  | 2  | 3  | 4  |
|----|----|----|----|----|
| 10 | 20 | 30 | 40 | 50 |


### Array vs ArrayList in Java
1. Array is a fixed length data structure whereas ArrayList is a variable length Collection class. 
2. We cannot change length of array once created in Java but ArrayList can be changed.
3. We cannot store primitives in ArrayList, it can only store objects. 
4. But array can contain both primitives and objects in Java. 
5. Since Java 5, primitives are automatically converted in objects which is known as auto-boxing.

