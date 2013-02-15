import java.util.*;
import java.lang.*;

/**
*This Is Homework 3 problem 1. It converts an english sentence in to a "1337 sp33k" sentence. It replaces
*english characters with their leet speek equivalent
**/

//I completed this assignment by myself using only the resources from the textbook and materials


public class LeetTranslator {
	public static void main (String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String eng = sc.nextLine();
		
		eng=eng.toLowerCase();
		
		eng = eng.replace('a','@');
		eng = eng.replace('e','3');
		eng = eng.replace('i','1');
		eng = eng.replace('s','$');
		eng = eng.replace('o','0');
		
		System.out.print(eng);
		
		}//End main
	}// end class