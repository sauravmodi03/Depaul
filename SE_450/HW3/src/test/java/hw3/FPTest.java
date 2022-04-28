package hw3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class FPTest {

	@Test
	public void testMap() {

		LinkedList<Integer> l = new LinkedList<>();
		List<String> listString = Arrays.asList("Mary", "Isla", "Sam");
		List<Integer> listInteger = new ArrayList<>();
		for (String x : listString) {
			listInteger.add(x.hashCode());
		}
		assertArrayEquals(listInteger.toArray(), FP.map(listString, (String str) -> { return str.hashCode();}).toArray());

		for (int i=0; i < 5; i++) l.add(i+1); // [5,4,3,2,1] list(INTEGER)
		
	     // Integer ==> Boolean
		 // static <U,V> List<V> map(Iterable<U> l, Function<U,V> f) 
		 // List(Boolean)
		
		List<Boolean> b = FP.map(l,
				(Integer x) -> { return x%2 ==0;});
		Boolean[] s = {false,true,false,true,false};
		assertArrayEquals(b.toArray(),s);
		
		List<Integer> u = FP.map(l, (Integer x) -> {return x+1;});
		Integer[] r = {2,3,4,5,6};
		assertArrayEquals(u.toArray(),r);
	}


	@Test
	public void testFoldLeft() {
		
		LinkedList<Integer> l = new LinkedList<>();
		assertTrue(0 == FP.foldLeft(0, l, (Integer x, Integer y) -> {return x+y;}));
		for (int i=0; i < 10; i++) l.addLast(i+1); // [1,2,3,4,5,6,7,8,9,10]
		assertTrue(55 == FP.foldLeft(0, l, (Integer x, Integer y) -> {return x+y;}));
		// add the numbers of the list
//	          0 + 1
//				1 + 2
//				   3 + 3
//				      6 + 4 .... 55
		  
		LinkedList<String> str = new LinkedList<>();
		String res = "";
		for (int i=1; i <= 5; i++) { //Adding numbers to list
			str.addLast(String.valueOf(i));
			res = res.concat(String.valueOf(i));
		}
		assertTrue(res.equals(FP.foldLeft("", str, (String str1, String str2) -> {return str1.concat(str2);})));
		// concatenate the strings
	}


	@Test
	public void testFoldRight() {
		LinkedList<String> s = new LinkedList<>();
		String r = "";
		for (int i=4; i > 0; i--) {
			s.addLast(String.valueOf(i));
			r = String.valueOf(i).concat(r);
		}
		assertTrue(r.equals(FP.foldRight("", s, (String x, String y) -> {return y.concat(x);})));
		
		LinkedList<Integer> l1 = new LinkedList<>();
		for (int j=0; j < 3; j++) 
			l1.addLast(j+1);
		// [1,2,3]
		assertTrue(2 == FP.foldRight(0, l1, (Integer x, Integer y) -> {return x-y;}));
		// 3 -0 =3. 2-3 =-1.  1-(-1) = 2

		LinkedList<Integer> l = new LinkedList<>();
		assertTrue(0 == FP.foldRight(0, l, (Integer x, Integer y) -> {return x+y;}));
		for (int i=0; i < 10; i++) l.addLast(i+1); // [1,2,3,4,5,6,7,8,9,10]
		assertTrue(55 == FP.foldRight(0, l, (Integer x, Integer y) -> {return x+y;}));
	}

	@Test
	public void testFilter() {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i=0; i < 5; i++) l.addFirst(i+1); //[1,2,3,4,5]
		Iterable<Integer> i = FP.filter(l, (Integer x ) -> {return x%2 != 0;});
		  // [1,3,5]
		int u = 0;
		for (Integer a: i) u++;
		assertTrue(u==3);
		
		Iterable<Integer> j = FP.filter(l, (Integer x ) -> {return x%2 == 0;});
		  // [2,4]
		int u1 = 0;
		for (Integer a : j) { u1++; }
		assertTrue(u1==2);

		List<Person> p = new ArrayList<>();

		p.add( new Person(130000, "Name1"));
		p.add( new Person(20000, "Name2"));
		p.add( new Person(150000, "Name3"));
		p.add( new Person(140000, "Name4"));
		p.add( new Person(30000, "Name5"));
		p.add( new Person(200000, "Name6"));

		p.stream().filter(x-> x.getSalary() >= 100000).toList();

		Iterable<Person> persons = FP.filter(p, (Person person) -> {return  person.getSalary() >= 100000;});
		List<Person> result = new ArrayList<>();
		for (Person person : persons) {
			result.add(person);
		}
		assertArrayEquals(p.stream().filter(x-> x.getSalary() >= 100000).toArray() , result.toArray());
	}

	@Test
	public  void testMinVal() {
		List<Integer> list = Arrays.asList(10,45,23,78,5,67,30,7);
		assertTrue( 5 == FP.minVal(list, Integer::compare));
	}

	@Test
	public void testMinPos() {
		List<Integer> listIntegers = Arrays.asList(10,45,23,78,5,67,30,7);
		assertTrue( 4 == FP.minPos(listIntegers));
	}

}
