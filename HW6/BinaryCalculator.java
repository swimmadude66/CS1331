//I completed this assignment by myself using only the resources from the textbook and materials
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
* This class handles the arithmetic operations to be run on the input binary strings. It does this
* by interpreting the binary string in to an integer, then conducting mathmatical operations, and returning
* a binary string corresponding to the result of the operation
* @author Adam Yost
* @version 1.0
**/


public class BinaryCalculator{
	
/**
* Takes in a binary string and using a while loop checks each bit for its value, then adds the value to a
* running decimal total, allowing conversion from binary to int
* @param String bin - a binary string containing only 1s or 0s
* @return Integer tot - an Integer object representing the value of the binary string
**/
public static int binToInt(String bin){
		int len = bin.length()-1;
		double power = 0;
		int tot = 0;
		double part;
			while (len >=0){
				int end =len +1;
				String bit = bin.substring(len,end);
				int a = new Integer(bit);
				if (a == 1){
					part = Math.pow(2.0,power);
				}
				else{
					part = 0;
					}
				len --;
				power ++;
				tot += part;
			}
		return(tot);
		}


/**
* takes two binary strings and adds them by first converting them to int objects and adding those values,
* then returning the result as the binary string of the sum
* @param String a - The first binary string to be added
* @param String b - the second binary string to be added
* @return String c - the sum of the two numbers, represented in binary
**/
public static String add(String a, String b){
	int numa = binToInt(a);
	int numb = binToInt(b);
	int numc = numa + numb;
	String c = Integer.toBinaryString(numc);
	return (c);
	}

/**
* Takes in two binary strings to be subtracted and returns a binary string representing the total
* @param String a - First number to be subtracted in binary format
* @param String b - Second number to subtract in binary format
* @return String c - result of subtraction represented in binary format
**/

public static String subtract(String a, String b){
	int numa = binToInt(a);
	int numb = binToInt(b);
	int numc = numa - numb;
	String c = Integer.toBinaryString(numc);
	return (c);
	}	
	
/**
* Takes in two binary strings to be multiplied and returns a binary string representing the product
* @param String a - First number to be multiplied in binary format
* @param String b - Second number to multiply in binary format
* @return String c - product represented in binary format
**/ 
	
public static String multiply(String a, String b){
	int numa = binToInt(a);
	int numb = binToInt(b);
	int numc = numa * numb;
	String c = Integer.toBinaryString(numc);
	return (c);
	}	

/**
* Takes in two binary strings to be divided and returns a binary string representing the total
* @param String a - First number to be divided in binary format
* @param String b - Second number to divide in binary format
* @return String c - result of division represented in binary format
**/	
	
public static String divide(String a, String b){
	int numa = binToInt(a);
	int numb = binToInt(b);
	int numc = numa / numb;
	String c = Integer.toBinaryString(numc);
	return (c);
	}	
	
	public static void main (String[] args){
		
		}
}
				