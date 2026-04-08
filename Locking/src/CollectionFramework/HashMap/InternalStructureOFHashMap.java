package CollectionFramework.HashMap;
//VVVVVVVVVVVVVV IMP topic for Interviews

//Basic Components of HashMap: Key:Identifier, value:data,
// Bucket:A place where key-value pairs are stored, stores in Arraylist ,
// Hash function: Converts a key into an index(bucket location) for storage

//A hash function is an algorithm that takes an input and return a fixed size string of bytes, typically a numerical value. the output is known as a hash code, hash value. The primary purpose of hash function is to map data of arbitrary size to data of fixed size
//Deterministic: the same input will always produce the same output
//fixed output size: hash code has a consistent size
//Efficient Computation: compute the hash quickly

//How the data gets stores in hashmap
//Step 1: Hashing the key: First the key is passed through a hash function to generate a unique hash code, this hash code helps determine where the key value pair will be stored in array(BucketArray).
//step 2: Calculating the index : The hash code is then used to calculate an index in the array suing int index = hashCode % arraySize;
//       The index decides which bucket will hold this key-value pair
//       For example, if the array size is 16, the key's hash code will be divided by 16, and the remainder will be the index
//Step 3: Storing in the Bucket: the key value pair is stored in the bucket at the calculated index. each bucket can hold multiple key value pairs.

//How hashMap Retrieves Data
//Step 1: Hashing the key: the key is hashed using the same hash function to calculate its hash code
//Step 2: Finding the Index: the hashCode is used to find the index of the bucket where the key value pair is stored
//Step 3: Searching in the Bucket: Once the correct bucket is found it checks for the key in that bucket. if it finds the key it returns the associated value.

//different keys can generate same index
//Handling Collision: same input can have multiple values
//we store multiple key value pairs, arr[8] this store linked list so (k1, v1)->(k2, v2)
// In case of LL we used to perform liner search, which takes O(N) TC, so to solve this issue after java 8 we use Balance Binary search Tree (red black tree)
//we have a threshold value that is 8, when linked list length passes this value we convert to red black tree
// this take TC O(log n), it is a self balancing binary search tree, after deletion or insertion it balances itself

//Hashmap Resizing(Rehashing)
//Hashmap has an internal array size(16), which by default is 16.
//when the number of elements grows and exceeds a certain load factor (default is 0.75) Hashmap automatically resizes the array to hold more data. this process is called rehashing.
//The default size of the array is 16 so when more than 12 elements(16*0.75) are inserted, the hashmap will resize.
//During rehashing
//All existing entries are rehashed and places into the new array, this ensures the hashmap continues to perform efficiently even as more data is added.


//Time complexity
//HashMap provides constant time O(1) performance for basic operation like put and get (assuming no collisions)
//However if there are many collisions, and many entries are stored in the same bucket the performance can degrade to O(n), where n is the number of elements in that bucket.
//But after java 8, if there are too many elements in a bucket, hashmap witches to balanced tree instead of a linked list to ensure better performance O(log n)

//even when we are passing object as key, we generate hashcode,
// that hashcode is generated using memory address

import java.util.HashMap;

public class InternalStructureOFHashMap {

}
