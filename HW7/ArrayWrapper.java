import java.util.*;
/**
* This class wraps an array and builds functions that can be executed on the array. This class takes in a
* variable number of integers and creates an array which can be operated upon in order to create a new array,
* in effect allowing arrays to be altered
* @author Adam Yost
* @version 1.0
**/

//I completed this assignment by myself using only the resources from the textbook and materials


public class ArrayWrapper {

/**
* backing array to be created from the arguments and operated upon by the methods in this class
**/
	private int[] back;

/**
* constructor for the ArrayWrapper object
* @param nums  a variable number of integers to be made in to an array
**/

	public ArrayWrapper(int ... nums){
		back = new int[nums.length];
		for (int x=0; x<nums.length; x++){
			back[x]= nums[x];
		}
	}
	
/**
* Formats the backing array in a form similar to a mathemaical array allowing it to be read more easily
* @return done - a String representation of the backing array
**/
	
	public String toString(){
		String done = "[";
		for(int i=0; i<back.length; i++){
			if (i!= (back.length-1)){
				done += (back[i] +", ");
				}
			else{
				done += (back[i]);
				}
			}
		done += "]";	
		return done;
		}

/**
* Returns the index of the first instance of the integer supplied
* @param i  an integer object to search for throughout the array
* @return x - an integer object representing the first index matching the input
**/
public int indexOf(int i){
	int index = 0;
	int x = -1;
	while (index<back.length){
		if(back[index] == i){
			x = index;
			break;
		}
		else{
			index++;
			}	
	}
return x;
}

/**
* returns the size of the backing array of the given ArrayWrapper object
**/
public int size(){
	return back.length;
	}
	
/**
* Adds the given integer at the given index and shifts the remaining indices accordingly
* @param index  integer object representing the index at which the input will be added
* @param number  integer object which will be inserted at the given index
**/
public void insert(int index, int number){
	int[] temp = new int[back.length +1];
	if (index >= back.length){
		copy(back, temp);
		temp[back.length] = number;
		}
	else if (index <= 0){
		for (int x = 1; x<temp.length; x++){
			temp[x] = back[x-1];
			}
		temp[0] = number;
		}
	else{
		for (int x=0; x<index; x++){
			temp[x] = back[x];
			}
		temp[index] = number;
		for (int x=index+1; x<temp.length; x++){
			temp[x] = back[x-1];
			}
		}
	back = new int[temp.length];
	copy(temp, back);
}
	
/**
* Copies an array into another array object of the same size or greater
* @param input  array object to be copied in to the new array
* @param output  array object to hold the old array
**/ 
public void copy(int[] input, int[] output){
	for(int x=0; x<input.length; x++){
		output[x] = input[x];
		}
	}

/**
* tacks the backing array of one ArrayWrapper object to the end of another ArrayWrapper's backign array
* @param aw  ArrayWrapper object whose array will be added to the primary object
**/

public void concatenate(ArrayWrapper aw){
	int s = aw.size();
	int[] temp = new int[back.length + s];
	copy(back, temp);
	for (int x = back.length; x<temp.length; x++){
		temp[x] = aw.get(x- back.length);
		}
	back = new int[temp.length];
	copy(temp, back);
	}

/**
* Adds a new array consisting of the backing array plus the integers entered in the order entered
* @param n  a variable number of integers to be added to the end of the array
**/ 
public void addToEnd(int ... n){
	int s = n.length;
	int[] temp = new int[back.length +s];
	copy(back, temp);
	for (int x = back.length; x<temp.length; x++){
		temp[x] = n[x- back.length];
		}
	back = new int[temp.length];
	copy(temp, back);
	}

/**
* removes the integer at the specified index and returns the integer that was removed
* @param i  integer object representing the index which should be removed
* @return a - integer object representing the integer which was removed
**/
public int removeIndex(int i){
	int[] temp = new int[back.length -1];
	if (i <0){
		i = 0;
		}
	else if(i>= back.length){
		i = back.length -1;
		}
	else{
		i = i;
	}
	int a = back[i];
	for (int x = 0; x<i; x++){
		temp[x] = back[x];
		}
	for (int x=i; x<temp.length; x++){
		temp[x] = back[x+1];
		}
	back = new int[temp.length];
	copy(temp, back);
	return a;
}

/**
* Removes the first instance of the integer in the array and returns the index of the removed element
* @param a an integer object representing the element to be found and removed
* @return b - an integer object representing the index of the removed element
**/
public int removeElement(int a){
	int b = indexOf(a);
	removeIndex(indexOf(a));
	return(b);
	}
	
/**
* clears the backing array to a zero element array
**/

public void clear(){
	back = new int[0];
	}

/**
* Gets the integer at the index supplied
* @param i  integer object of the index to retreive
* @return integer object of the element at the given index
**/
public int get(int i){
	return back[i];
	}

/**
* averages the elements in the array and returns the arithmatic mean
* @return avg - double object representing the average of the elements in the array
**/
public double mean(){
	double avg = 0;
	double total = 0;
	for (int x =0; x<back.length; x++){
		total += back[x];
		avg = total/(back.length);
	}
	return(avg);
}

/**
* returns the backing array of the ArrayWrapper object in int[] format
* @return back - int[] object containing the backing array
**/

public int[] getArray(){
	return back;
}

public static void main(String[] args){
	}
}