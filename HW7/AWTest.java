import java.util.*;

//I completed this assignment by myself using only the resources from the textbook and materials

/**
* Tests the methods established in the ArrayWrapper class
* @author Adam Yost
* @version 1.0
**/

public class AWTest{

public static void main(String[] args){
		ArrayWrapper aw = new ArrayWrapper(5,4,3,2,1);
		ArrayWrapper bx = new ArrayWrapper(-1,-2,-3,-4,-5);
		System.out.println(aw.toString());
	
		//indexOf
		int a = aw.indexOf(1);
		System.out.println(a);
		//size
		int x = aw.size();
		System.out.println(x);
		//insert
		aw.insert(8,0);
		System.out.println(aw.toString());
		//concatenate
		aw.concatenate(bx);
		System.out.println(aw.toString());
		//addToEnd
		aw.addToEnd(6,7,8,9,10);
		System.out.println(aw.toString());
		//removeIndex
	
		int b =aw.removeIndex(2);
		System.out.println(b);
		System.out.println(aw.toString());
	
		//removeElement
		int c =aw.removeElement(3);
		System.out.println(c);
		System.out.println(aw.toString());
		//clear
		aw.clear();
		System.out.println(aw.toString());
		//restore the array
		aw.addToEnd(10, 10, 10, 70);
		System.out.println(aw.toString());
		//get
		int d = aw.get(2);
		System.out.println(d);
		//mean		
		double u = aw.mean();
		System.out.println(u);
		//getArray
		int [] n = aw.getArray();
	}	
}