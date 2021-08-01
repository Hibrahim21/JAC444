public class Stack{
    
	private char element[];
    
	// Default no-arg constructor
    public Stack (){
    	element = new char[0];
    }
    
    // Push stack function
	public void push(char input){
            char[] temp = new char[element.length + 1];
            for (int i = 0; i < element.length ;i++){
                temp[i] = element[i];
            }
            temp[element.length] = input;
            element = temp;
    }
	
	// Pop stack function
    public char pop(){
        char out = '\u0000';
        if(element.length != 0) {
            char[] temp = new char[element.length - 1];
            out = element[element.length - 1];
            for (int i = 0; i < element.length - 1; i++) {
                temp[i] = element[i];
            }
            element = temp;
        }
        return out;
    }

}

