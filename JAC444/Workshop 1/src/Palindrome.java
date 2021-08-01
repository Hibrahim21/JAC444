public class Palindrome {
	
    private char[] arg;
    
    private Stack personalStack = new Stack();
    
    // 1-arg constructor 
    Palindrome(String input){
        this.arg = input.toCharArray(); //Convert the String to a charArray
        
        for(int i = 0 ; i < arg.length ; i++){
        	personalStack.push(arg[i]);
        }
    }
    
    public boolean isPali(){
        boolean check = true;
        for(int i = 0 ; i < arg.length ; i++){
            if(arg[i] == personalStack.pop()){ // If the arg variable we pushed matches 
            	check = true;
            }else {
            	check = false;
            }
        }
        return check;
    }
    
    // isEmpty function checks if no arguments have been passed or not to proceed 
    public boolean isEmpty() {
    	boolean flag = true;
    		if(arg[0] == 0) {
    			flag = true;
    		} 
    		else {
    			flag = false;
    		}
    		return flag;
    	}

    public static void main(String[] args) {

      Palindrome pali = new Palindrome(args[0]); //Creating a Palindrome Obj
      
      if(pali.isEmpty() == false) { // Call isEmpty function to check if no args have been passed
    	  if (pali.isPali()){ // Call boolean function isPali() and print out the results
              System.out.println("The word " + args[0] + " is palindrome.");
          }else {
              System.out.println("The word " + args[0] + " is not palindrome.");
          }
      }
      else {
    	  System.out.println("***No arguments have been passed***");
      }
      
    }
}





























//import java.util.*;
//import java.lang.*;

//public class Palindrome {
//	
//    public static void main(String[] args) {
//      
//    	String rev = "";
//    	
//    	for(int cnt = args[0].length() - 1; cnt >= 0; cnt--) {
//    		rev = rev + args[0].charAt(cnt);
//    	}
//    	if(args[0].equals(rev)) {
//            System.out.println("The string " + args[0] + " is a palindrome.");
//    	}
//    	else {
//            System.out.println("The string " + args[0] + " is not a palindrome.");
//    	}
//    }
//
//}
