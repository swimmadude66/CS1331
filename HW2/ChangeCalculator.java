import java.util.*;
import java.lang.*;
/**
*This is Homework 2 problem 1
*This calculates minimum number of bills/coins needed for a given amount
*I completed this assignment by myself using only the resources from the textbook and materials
**/

public class ChangeCalculator{
	public static void main (String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Amount: $"); //prompt input
		double money = sc.nextDouble(); //retrieve input
		
		//initialize bill/coin counters
		
		int twenties= 0;
		int tens =0;
		int fives=0;
		int ones=0;
		int quarters=0;
		int dimes=0;
		int nickels=0;
		int pennies=0;
		
		double total = money * 100; //Convert money to number of cents
		int change = (int)total % 100; 
		int bills = (int)total - change;
		
		//Count bills
		twenties = bills /2000;
		bills = bills - (twenties * 2000); //update bill total
		tens = bills / 1000;
		bills -= (tens * 1000);
		fives = bills / 500;
		bills -= (fives * 500);
		ones = bills /100;
		bills-= (ones * 100);
		
		//Count change
		quarters = change / 25;
		change-= (quarters*25);
		dimes = change/10;
		change -= dimes*10;
		nickels = change/5;
		change -= (nickels * 5);
		pennies = change;
		
		
		
		System.out.println("Twenties: " + twenties);
		System.out.println("Tens: " + tens);
		System.out.println("Fives: " + fives);
		System.out.println("Ones: " + ones);
		
		System.out.println("Quarters: " + quarters);
		System.out.println("Dimes: " + dimes);
		System.out.println("Nickels: " + nickels);
		System.out.println("Pennies: " + pennies);
		
		
		
		
		}//end main
	}//end class