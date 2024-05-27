package MyCode;
import ADT.DoubleHashMap;
import MyCode.CP8_Persona;

public class CP8_SistemaRegistro {
	DoubleHashMap<Integer,CP8_Persona> archivo=new DoubleHashMap<>();
	public CP8_SistemaRegistro(){
	}
	public void addPersona(CP8_Persona p) {
		archivo.put(Integer.parseInt(p.getCedula().substring(7)),p);
	}
	public void printCiudadano(String cedula) {
		int key=Integer.parseInt(cedula.substring(7));
		System.out.println("Cédula: "+archivo.get(key).getCedula());
		System.out.println("Nombre completo: "+archivo.get(key).getNombre());
		System.out.println("Género: "+archivo.get(key).getGenero());
		System.out.println("Dirección completa: "+archivo.get(key).getDireccion());
	}
}

//But what should we do if our keys are not integers in the range from 0 to N – 1? 
//Use a hash function to map general keys to corresponding indices in a table. 
//For instance, the last four digits of a Social Security number.

//A hash function h maps keys of a given type to integers in a fixed 
//interval [0, N - 1] 
//• Example: 
//h(x) = x mod N 
//is a hash function for integer keys 
//• The integer h(x) is called the hash value of key x
//• A hash table for a given key type consists of 
//• Hash function h 
//• Array (called table) of size N 
//• When implementing a map with a hash table, the goal is to store item 
//(k, o) at index i = h(k
//		
//		A hash function is usually specified as the composition of two functions: 
//			1.Hash code: 
//			h1: keys → integers (+/-) 
//			2.Compression function: 
//			h2: integers → [0, N - 1]
//			 ■ The hash code is applied first, and 
//			the compression function is applied 
//			next on the result, i.e.,  
//			h(x) = h2(h1(x)) 
//			■ The goal of the hash function is to  
//			“disperse” the keys in an 
//			apparently random way
//			 Memory address: 
//				 We reinterpret the memory address of the key 
//				 object as an integer (default hash code of all Java 
//				 objects) 
//				 Good in general, except for numeric and string 
//				 keys 
//				 Integer cast: 
//				 We reinterpret the bits of the key as an integer 
//				 Suitable for keys of length less than or equal to 
//				 the number of bits of the integer type (e.g., byte, 
//				 short, int in Java)
//				  ■ Component sum: 
//				 ■ We partition the bits of the key 
//				 into components of fixed length 
//				 (e.g., 16 or 32 bits) and we sum 
//				 the components (ignoring 
//				 overflows) 
//				 ■ Suitable for numeric keys of fixed 
//				 length greater than or equal to 
//				 the number of bits of the integer 
//				 type (e.g., long and double in 
//				 Java
//				 
//				 Polynomial accumulation: 
//					 We partition the bits of the key into a 
//					 sequence of components of fixed length 
//					 (e.g., 8, 16 or 32 bits) 
//					 a0 a1 … an-1 
//					 We evaluate the polynomial 
//					 p(z) = a0 + a1 z  + a2 z2 + …  
//					  … + an-1zn-1 
//					 at a fixed value z, ignoring overflows 
//					 Especially suitable for strings (e.g., the 
//					 choice z = 33 gives at most 6 collisions on 
//					 a set of 50,000 English words)
//					  ■ Polynomial p(z) can be 
//					 evaluated in O(n) time using 
//					 Horner’s rule: 
//					 ■ The following polynomials are 
//					 successively computed, each from the 
//					 previous one in O(1) time 
//					 p0(z) = an-1 
//					 pi (z) = an-i-1 + zpi-1(z) 
//					 (i = 1, 2, …, n -1) 
//					 ■ We have p(z) = pn-1(z) 
//
//							 Division: 
//								 h2 (y) = y mod N 
//								 The size N of the hash table is 
//								 usually chosen to be a prime  
//								 The reason has to do with 
//								 number theory and is beyond 
//								 the scope of this course
//								  ■ Multiply, Add and Divide (MAD): 
//								 ■ h2 (y) = (ay + b) mod N 
//								 ■ a and b are nonnegative integers 
//								 such that 
//								 a mod N ≠ 0 
//								 ■ Otherwise, every integer would map 
//								 to the same value b
//
//								 
//								 Collisions occur when different 
//								 elements are mapped to the same 
//								 cell 
//								 (1) Separate Chaining: let each cell 
//								 in the table point to a linked list of 
//								 entries that map there
//								 Separate chaining is simple, but requires 
//								 additional memory outside the table	
//						
//								 (2) Linear Probing
//								 Open addressing: the colliding item is placed in a different cell of the table 
//								Linear probing: handles collisions by placing the colliding item in the next 
//								(circularly) available table cell 
//								Each table cell inspected is referred to as a “probe” 
//								Colliding items lump together, causing future collisions to cause a longer sequence 
//								of probes
//								
//								 Consider a hash table A that uses linear probing 
//								 get(k) 
//								 We start at cell h(k)  
//								 We probe consecutive locations until one of the 
//								 following occurs 
//								 An item with key k is found, or 
//								 An empty cell is found, or 
//								 N cells have been unsuccessfully probed 
//								 • To handle insertions and deletions, we introduce a 
//								 special object, called DEFUNCT, which replaces 
//								 deleted elements 
//								 • remove(k) 
//								 • We search for an entry with key k  
//								 • If such an entry (k, o) is found, we replace it 
//								 with the special item DEFUNCT and we return 
//								 element o 
//								 • Else, we return null
//								  • put(k, o) 
//								 • We throw an exception if the table 
//								 is full 
//								 • We start at cell h(k)  
//								 • We probe consecutive cells until 
//								 one of the following occurs 
//								 • A cell i is found that is either 
//								 empty or stores DEFUNCT, or 
//								 •N cells have been unsuccessfully 
//								 probed 
//								 • We store (k, o) in cell i
//								 
//								 3) Double Hashing
//				 • Double hashing uses a secondary hash function 
//				d(k) and handles collisions by placing an item in 
//				the first available cell of the series 
//				(h(k) + j*d(k)) mod N 
//				for j = 0,  1, … , N - 1 
//				• The secondary hash function d(k) cannot have 
//				zero values 
//				• The table size N must be a prime to allow probing 
//				of all the cells
//				 • Common choice of compression 
//				function for the secondary hash 
//				function:   
//				•d2(k) = q – (k mod q) 
//				•  where 
//				•q < N 
//				•q is a prime 
//				• The possible values for d2(k) are 
//				 1, 2, … , q
//
//				 In the worst case, searches, insertions and 
//				 removals on a hash table take O(n) time 
//				 The worst case occurs when all the keys 
//				 inserted into the map collide 
//				 The load factor α = n/N affects the performance 
//				 of a hash table 
//				 Assuming that the hash values are like random 
//				 numbers, it can be shown that the expected 
//				 number of probes for an insertion with open 
//				 addressing is 
//				 1 / (1 - α) 
//				 ■ The expected running time of all the 
//				 dictionary ADT operations in a hash 
//				 table is O(1)  
//				 ■ In practice, hashing is very fast 
//				 provided the load factor is not close 
//				 to 1 (ideally, α=0.75 for separate 
//				 chaining, α<0.5 for open 
//				 addressing) 
//				 ■ Applications of hash tables: 
//				 ■ small databases 
//				 ■ compilers 
//				 ■ browser caches
//			


//				 
//				 //Grafos
//				 Property 1 
//				 Σv deg(v) = 2m 
//				 Proof: each edge is counted twice 
//				 Property 2 
//				 In an undirected graph with no 
//				 self-loops and no multiple edges 
//				 m ≤ n (n − 1)/2 
//				 Proof: each vertex has degree at 
//				 most (n − 1) 
//				 What is the bound for a directed 
//				 graph?
//				  n*(n-1)
//				  Notation 
//				  n - number of vertices 
//				  m - number of edges 
//				 deg(v) - degree of vertex v
//				  Example 
//				 ■ n = 4 
//				 ■ m = 6 
//				 ■ deg(v) = 3
//A graph is a collection of vertices and edges.  
//We model the abstraction as a combination of three data types: Vertex, 
//Edge, and Graph.  
//A Vertex is a lightweight object that stores an arbitrary element 
//provided by the user (e.g., an airport code) 
//We assume it supports a method, element(), to retrieve the stored 
//element.  
//An Edge stores an associated object (e.g., a flight number, travel 
//distance, cost), retrieved with the element( ) method. 
//
//Representation: Edge List
//Vertex sequence (V) 
//sequence of vertex objects 
//Edge sequence (E) 
//sequence of edge objects 
//Vertex object 
//element 
//reference to position in vertex sequence 
//Edge object 
//element 
//origin vertex object 
//destination vertex object 
//reference to position in edge sequence
//
//Representation: Adjacency List
//Vertex sequence (V) 
//sequence of vertex objects 
//Vertex object 
//element 
//reference to position in vertex sequence 
//sequence of references to edge objects of incident 
//edges 
//Edge objects 
//element 
//maintains references to its endpoint vertices
//
//Representation: Adjacency Matrix
//Edge list structure 
//Augmented vertex objects 
//Integer key (index) associated with vertex 
//2D adjacency array 
//Reference to edge object for adjacent vertices 
//Null for non nonadjacent vertices 
//The “old fashioned” version just has 0 for no 
//edge and 1 for edge

				 
 //A graph G=(V,E) such that 
//Each edge goes in one direction: 
//Edge (a,b) goes from a to b, but not b to a 
//E
// C
// A
// If G is simple, m < n⋅(n - 1) 
//If we keep in-edges and out-edges in separate adjacency lists, we 
//can perform listing of incoming edges and outgoing edges in time 
//proportional to their siz
//
//Assumptions: 
//■
// ■
// ■
// the graph is connected 
//the edges are undirected 
//the edge weights are nonnegative


//DFS y BFS
//A subgraph S of a graph G is a graph such that:  
//The vertices of S are a subset of the vertices of G 
//The edges of S are a subset of the edges of G 
//A spanning subgraph of G is a subgraph that 
//contains all the vertices of G
//
//A graph is connected if there is a path between 
//every pair of vertices 
//A connected component of a graph G is a maximal 
//connected subgraph of G
//
//Trees and Forests
//A tree is an undirected graph T such that: 
//T is connected 
//T has no cycles 
//This definition of tree is different from the one of a 
//rooted tree 
//A forest is an undirected graph without cycles 
//The connected components of a forest are 
//trees
//
//spanning Trees and Forests
//A spanning tree of a connected graph is a spanning 
//subgraph that is a tree 
//A spanning tree is not unique unless the graph is a 
//tree 
//Spanning trees have applications to the design of 
//communication networks 
//A spanning forest of a graph is a spanning subgraph 
//that is a forest
//
//Depth-first search (DFS) is a general 
//technique for traversing a graph 
//A DFS traversal of a graph G  
//Visits all the vertices and edges of G 
//Determines whether G is connected 
//Computes the connected components of G 
//Computes a spanning forest of G
//■ DFS on a graph with n 
//vertices and m edges takes 
//O(n + m ) time 
//■ DFS can be further 
//extended to solve other 
//graph problems 
//■ Find and report a path between 
//two given vertices 
//■ Find a cycle in the graph 
//■ Depth-first search is to 
//graphs what Euler tour is to 
//binary trees
//Properties of DFS
//Property 1 
//DFS(G, v) visits all the vertices and edges 
//in the connected component of v 
//Property 2 
//The discovery edges labeled by DFS(G, v) 
//form a spanning tree of the connected 
//component of v
//
//Analysis of DFS
//Setting/getting a vertex/edge label takes O(1) time 
//Each vertex is labeled twice  
//once as UNEXPLORED 
//once as VISITED 
//Each edge is labeled twice 
//once as UNEXPLORED 
//once as DISCOVERY or BACK 
//Method incidentEdges is called once for each vertex 
//DFS runs in O(n + m) time provided the graph is represented by the 
//adjacency list structure
//Path Finding
//We can specialize the DFS algorithm to find a 
//path between two given vertices u and z using 
//the template method pattern 
//We call DFS(G, u) with u as the start vertex 
//We use a stack S to keep track of the path 
//between the start vertex and the current vertex 
//As soon as destination vertex z is encountered, 
//we return the path as the contents of the stack 
//		Cycle Finding
//		 We can specialize the DFS algorithm to find a 
//		simple cycle using the template method pattern 
//		We use a stack S to keep track of the path 
//		between the start vertex and the current vertex 
//		As soon as a back edge (v, w) is encountered, we 
//		return the cycle as the portion of the stack from 
//		the top to vertex w
//		Breadth-First Search
//		 Breadth-first search (BFS) is a general 
//		technique for traversing a graph 
//		A BFS traversal of a graph G  
//		Visits all the vertices and edges of G 
//		Determines whether G is connected 
//		Computes the connected components of G 
//		Computes a spanning forest of G
//		 ■ BFS on a graph with n vertices and 
//		m edges takes O(n + m ) time 
//		■ BFS can be further extended to 
//		solve other graph problems 
//		■ Find and report a path with the 
//		minimum number of edges between 
//		two given vertices  
//		■ Find a simple cycle, if there is one
//		 Notation 
//		 Gs: connected component of s 
//		 Property 1 
//		 BFS(G, s) visits all the vertices and edges of Gs  
//		 Property 2 
//		 The discovery edges labeled by BFS(G, s) form a 
//		 spanning tree Ts of Gs 
//		 Property 3 
//		 For each vertex v in Li 
//		 The path of  Ts from s to v has i edges  
//		 Every path from s to v in Gs has at least i edges
//		 
//		 Analysis
//		 Setting/getting a vertex/edge label takes O(1) time 
//		Each vertex is labeled twice  
//		once as UNEXPLORED 
//		once as VISITED 
//		Each edge is labeled twice 
//		once as UNEXPLORED 
//		once as DISCOVERY or CROSS 
//		Each vertex is inserted once into a sequence Li  
//		Method incidentEdges is called once for each vertex 
//		BFS runs in O(n + m) time provided the graph is represented by the 
//		adjacency list structure

//directed graphs
//transititve closure
//We can perform DFS 
//starting at each vertex 
//O(n(n+m))
//Alternatively ... Use 
//dynamic programming: 
//The Floyd-Warshall 
//Algorithm
//
//Theorem 
//A digraph admits a topological ordering if and only if it is a 
//DAG
//
//Topological sorting with DFS
//Simulate the algorithm by using depth-first search 
//O(n+m) time.
//
//
//Shortest paths
//weight of the edge 
//Edge weights may represent, distances, costs, etc. 
//Example: 
//2555
// In a  flight route graph, the weight of an edge represents the distance in miles between 
//the endpoint airports
//
//Shortest Path Properties
//Property 1: 
//A subpath of a shortest path is itself a shortest path 
//Property 2: 
//There is a tree of shortest paths from a start vertex to all the other vertices 
//Example: 
//Tree of shortest paths from Providence
//
//Dijkstra’s Algorithm
//The distance of a vertex v from a vertex s 
//is the length of a shortest path between s 
//and v 
//■ Dijkstra’s algorithm computes the 
//distances of all the vertices from a given 
//start vertex s 
//■ Assumptions: 
//■
// ■
// ■
// the graph is connected 
//the edges are undirected 
//the edge weights are nonnegative
// ■ We grow a “cloud” of vertices, 
//beginning with s and eventually 
//covering all the vertices 
//■ We store with each vertex v a 
//label d(v) representing the 
//distance of v from s in the 
//subgraph consisting of the cloud 
//and its adjacent vertices 
//■ At each step 
//■ We add to the cloud the vertex u 
//outside the cloud with the smallest 
//distance label, d(u) 
//■ We update the labels of the 
//vertices adjacent to u
//
//Edge Relaxation
//■ Consider an edge e = (u,z) such that 
//■
//u is the vertex most recently added to the cloud 
//50
//d(u) = 50
//10
//50 25
//■
//z is not in the cloud 
//s u
//d(z) = 75
//e
//z
//■ The relaxation of edge e updates distance d(z) as 
//follows: 
//■ d(z) ← min{d(z),d(u)} + weight(e)
//
//
//Analysis of Dijkstra’s Algorithm
//Graph operations 
//We find all the incident edges once for each vertex 
//Label operations 
//We set/get the distance and locator labels of vertex z O(deg(z)) times 
//Setting/getting a label takes O(1) time 
//Priority queue operations 
//Each vertex is inserted once into and removed once from the priority queue, where each 
//insertion or removal takes O(log n) time 
//The key of a vertex in the priority queue is modified at most deg(w) times, where each key 
//change takes O(log n) time  
//Dijkstra’s algorithm runs in O((n + m) log n) time provided the graph is represented 
//by the adjacency list/map structure 
//Recall that Σv deg(v) = 2m 
//The running time can also be expressed as O(m log n) since the graph is connecte
//
//
//■Dijkstra’s algorithm is based on the greedy method. It adds vertices by 
//increasing distance.
// ■ Suppose it didn’t find all shortest distances. Let 
//F be the first wrong vertex the algorithm 
//processed. 
//■ When the previous node, D, on the true 
//shortest path was considered, its distance was 
//correct 
//
// ■ But the edge (D,F) was relaxed at that time! 
//■ Thus, so long as d(F)>d(D), F’s distance cannot 
//be wrong.  That is, there is no wrong vertex
