This repo is for all interview prep content based on 'Cracking the Coding Interview' book.

Sections include: Big-O practice, ArrayList & Resizable Arrays


Before Interview:
1) Go over Big-O again (pages 38-59)\
i) Optimize exponential time recursive algorithms with memoization
2) Technical questions\
i) Study funadamental concepts on page 61
ii) Go over approaching a problem tactics

**Chapter 1**\
Hash Tables: 
1) Compute the key's hash code, which will usually be an int or long. Note that two different keys could have the same hash code, as there may be an infinite number of keys and a finite number of ints
2) Then, map the hash codr to an index in the array. This could be done with something like hash(key) % array_length. Two different hash codes could, of course, map to the same index
3) At this index, there is a linked list of keys and values. Store the key and value in this index. We must use a linked list because of collisions: you could have two different keys with the same hash code, or two different hash codes that map to the same index

-> Worst case runtime is O(N) where N is the number of keys. Generally the lookup time is O(1).\
-> Alternatively, we can implement the hash table with a balanced binary search tree which gives us an O(log N) worst case runtime\

ArrayList & Resizable Arrays:\
-> When you need an array-like data structure that offers dynamic resizing, you would usually use an ArrayList.\
-> Each time the array reaches capacity it doubles in size.\
-> Each doubling takes O(N) time, but happens so rarely that its amortized insertion time is O(1).\

StringBuilder:\
-> StringBuilder simply creates a resizable array of all the strings, copying them back to a string only when \

**Chapter 2**\
Linked Lists:

Note: Having a runner that iterates at a different pace can help solve problems \

**Chapter 3**\
Stacks and Queues: (self explanatory)
