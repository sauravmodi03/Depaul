package hw3;

import java.util.*;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class FP {
	
// f takes U to V.. ie. f.apply(U): V

	/**
	 * Function to demonstrate Function<U, V> interface
	 * @param l List of objects
	 * @param f Function interface object
	 * @param <U> Type of input object
	 * @param <V> Return type of object
	 * @return
	 */
	static <U,V> List<V> map(Iterable<U> l, Function<U,V> f) {
		assert (l != null);
		List<V> list = new ArrayList<>();
		// walk through the U's
		// use f at every stage f.apply
		// construct list of V's
		l.forEach(x -> list.add(f.apply(x))); //Iterating over provided list
		return list;
	}

	/**
	 * Function to demonstrate foldLeft approach
	 * @param e First element of the list
	 * @param l List of objects
	 * @param f BiFunction object
	 * @param <U> Type of object
	 * @param <V> Type of result object
	 * @return
	 */
	static <U,V> V foldLeft(V e, Iterable<U> l, BiFunction<V,U,V> f) {
		assert (l != null);
		// walk through the U's [u1,u2, ..,un]
		//                       e
		// use f at every stage v1= f.apply(e,u1)
		//                         v2= f.apply(v1,u2)
		//						    v3= f.apply(v2,u3)..
		// return the last v
		for(U i:l){
			e = f.apply(e,i);
		}
		return e;
	}

	// similar to above
	// but from the right
	//     vn=  f(un,e)
	//          vn-1 = f(un-1,vn)
	// ..
	// return the first v

	/**
	 * Function to demonstrate foldRigt approach
	 * @param e First element of the list
	 * @param l List of objects
	 * @param f BiFunction object
	 * @param <U> Type of object
	 * @param <V> Type of result object
	 * @return
	 */
	static <U,V> V foldRight(V e, List<U> l, BiFunction<U,V,V> f) {
		assert ( l != null);
		for (int i = l.size() - 1 ; i >= 0 ; i--) {
			e = f.apply(l.get(i), e);
		}
	return e;
}


	/**
	 * Function to find persons for a specific condition
	 * @param l List of objects
	 * @param p Predicate object
	 * @param <U> Type of objects
	 * @return
	 */
	static <U> Iterable<U> filter(Iterable<U> l, Predicate<U> p) {
		assert (l != null);
		List<U> result = new ArrayList<>();
		l.forEach(x-> { if (p.test(x)) result.add(x);});
		return result;
	}

	/**
	 * Function to find minimum from given elements
	 * @param l List of objects
	 * @param c Comparator object
	 * @param <U> Type of objects
	 * @return
	 */
	static <U> U minVal(Iterable<U> l, Comparator<U> c){
	// write using fold.  No other loops or recursion permitted
		return foldLeft(l.iterator().next(), l, (U u1, U u2)  -> c.compare(u1, u2) < 0 ? u1 : u2);
	}

	/**
	 *  Function to find positions of min element
	 * @param l List of objects
	 * @param <U> Type of objects
	 * @return
	 */
	static <U extends Comparable<U>> int minPos(Iterable<U> l){
		// write using fold.  No other loops or recursion permitted.
		List<U> newList = new ArrayList<>();
		l.forEach(x-> { newList.add(x); });
		return newList.indexOf(foldLeft(l.iterator().next(), l, (U u1, U u2) -> u1.compareTo(u2) < 0 ? u1 : u2));
	}

	/**
	 * Main class
	 * @param args
	 */
	public static void main(String[] args) {
		// (1) Use map to implement the following behavior (described in Python).  i.e given a List<T> create a List<Integer> of the hashes of the objects.
		// names = ['Mary', 'Isla', 'Sam']
		// for i in range(len(names)):
		       // names[i] = hash(names[i]
		
		// (2) Use foldleft to calculate the sum of a list of integers.
		// i.e write a method: int sum(List<Integer> l)
		
		// (3) Use foldRight to concatenate a list of strings i.e write a method
		// String s (List<String> l)
		
		// (4) consider an array of Persons. Use filter to 
		// print the names of the Persons whose salary is
		// greater than 100000
		
		// (5) Use minVal to calculate the minimum of a List of 
		//       Integers
		
        // (6) Use minVal to calculate the maximum of a List of 
		//       Integers
		
		// (7)  Use minPos to calculate the position of the
		// minimum in  a List of  Integers

		// (8)  Use minPos to calculate the position of the
		// minimum in  a List of  String
		}
	}

	class Person {
		final int salary;
		final String name;

		Person(int salary, String name){
			this.salary = salary;
			this.name = name;
		}

		int getSalary() { return salary; }
		String name() { return name;}

	}