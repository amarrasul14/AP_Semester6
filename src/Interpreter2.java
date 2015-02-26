import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Interpreter2 {

		String name; String name2; 							// variable
		int value; int value2;								//variable value
		int result; int result2;
		String tempName; 									//for constructor and future usage
		String []sentence;									//for tokenizing the line from file
		ArrayList<String> myList = new ArrayList<String>(); // create a new list of the lines
		
		
public Interpreter2(String variable, int temp){
		tempName = variable;
		value = temp;
}

public void readFile(String filename) throws IOException {
	
	FileReader Fr= new FileReader(filename);
	BufferedReader x = new BufferedReader(Fr);
	String temp;
	//int result;
	
	String sentence1;							//for tokenizing the file
	String sentence2;
	String sentence3;
	
	temp = x.readLine(); // read a line at a time
	//System.out.print();
	
	while(temp != null){ // loop till you have no more lines
	myList.add(temp); // add the line to your list
	temp = x.readLine(); // try to read another line
	}
	
	System.out.println("Contents of file:"+myList);
	
	
	
	sentence1=myList.get(0);
	sentence = sentence1.split(" ");			//tokenizes on basis of space
	
	
	if(sentence[0].equals("Let")){ 				//1st if
	name = sentence[1];							//recognizing a variable
	value=Integer.parseInt(sentence[3]);		//storing the variable's value
	
	System.out.print("Initial value of " + name);
	System.out.println(": " + sentence[3]);
	
	sentence2=myList.get(1);
	sentence = sentence2.split(" ");
	
	
	//System.out.println(sentence2);
	
	if(sentence[0].equals("Let")){
		name2 = sentence[1];					//recognizing a variable
		value2=Integer.parseInt(sentence[3]);	//storing the variable's value
		
		System.out.print("Initial value of " + name2);
		System.out.println(": " + sentence[3]);
	}
	
	/*=====================  Performing the arithmetic functionality  ===============================*/
	
	sentence3=myList.get(2);
	sentence = sentence3.split(" ");
	
	if(sentence[3].equals("+")){							//check for which arithmetic operation is performed
		System.out.println("Addition.");
		
		if(sentence[2].equals("x")){						//checking which variable is being manipulated
		result=value + Integer.parseInt(sentence[4]);
		System.out.print("Value of " + name);
		System.out.println(": " + result);
		}
		else if(sentence[2].equals("y"))
		{
			result=value2 + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
			}
		else{
			result=Integer.parseInt(sentence[2]) + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
		}
	}
	
	if(sentence[3].equals("-")){							//check for which arithmetic operation is performed
		System.out.println("Subtraction.");
		
		if(sentence[2].equals("x")){						//checking which variable is being manipulated
			result=value - Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
			}
		else if(sentence[2].equals("y"))
		{
			result=value2 - Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
			}
		else{
			result=Integer.parseInt(sentence[2]) - Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
		}
		
	}
	
	if(sentence[3].equals("*")){							//check for which arithmetic operation is performed
		System.out.println("Multiplication.");
		if(sentence[2].equals("x")){						//checking which variable is being manipulated
			result=value * Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
			}
		else if(sentence[2].equals("y"))
		{
			result=value2 * Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
			}
		else{
			result=Integer.parseInt(sentence[2]) * Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
		}
		
			
	}
	
	if(sentence[3].equals("/")){							//check for which arithmetic operation is performed
		System.out.println("Division.");
		if(sentence[2].equals("x")){						//checking which variable is being manipulated
			result=value / Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
			}
		else if(sentence[2].equals("y"))
		{
			result=value2 / Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
			}
		else{
			result=Integer.parseInt(sentence[2]) / Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name);
			System.out.println(": " + result);
		}
	}
	
	
	/*=====================  Performing the arithmetic functionality  ===============================*/
	sentence3=myList.get(3);
	sentence = sentence3.split(" ");
	
	if(sentence[3].equals("+")){							//check for which arithmetic operation is performed
		System.out.println("Addition.");
		if(sentence[2].equals("x")){						//checking which variable is being manipulated
			result2=value + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
			}
		else if(sentence[2].equals("y"))
		{
			result2=value2 + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
			}
		else{
			result2=Integer.parseInt(sentence[2]) + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
		}
		
	}
	
	if(sentence[3].equals("-")){							//check for which arithmetic operation is performed
		System.out.println("Subtraction.");
		if(sentence[2].equals("x")){						//checking which variable is being manipulated
			result2=value - Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
			}
		else if(sentence[2].equals("y"))
		{
			result2=value2 + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
			}
		else{
			result2=Integer.parseInt(sentence[2]) + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
		}
		
	}
	
	if(sentence[3].equals("*")){							//check for which arithmetic operation is performed
		System.out.println("Multiplication.");
		if(sentence[2].equals("x")){						//checking which variable is being manipulated
			result2=value * Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
			}
		else if(sentence[2].equals("y"))
		{
			result2=value2 + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
			}
		else{
			result2=Integer.parseInt(sentence[2]) + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
		}
	}
		
	if(sentence[3].equals("/")){							//check for which arithmetic operation is performed
		System.out.println("Division.");
		if(sentence[2].equals("x")){						//checking which variable is being manipulated
			result2=value / Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
			}
		else if(sentence[2].equals("y"))
		{
			result2=value2 + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
			}
		else{
			result2=Integer.parseInt(sentence[2]) + Integer.parseInt(sentence[4]);
			System.out.print("Value of " + name2);
			System.out.println(": " + result2);
		}
	}
	
	sentence1=myList.get(4);
	sentence = sentence1.split(" ");			//tokenizes on basis of space
	
	
	if(sentence[0].equals("print")){
		if(sentence[1].equals("x")){
		System.out.print("Print was called for variable:  " + sentence[1]);
		System.out.println(": " + result);
		}
		else
		{
			System.out.print("Print was called for variable:  " + sentence[1]);
			System.out.println(": " + result2);
		}
	}
	
	
	}//1st if(main)
	
	
	
}//end ReadFILE
	


public static void main(String[] args) throws IOException {

	Interpreter2 a = new Interpreter2("B",1);
	a.readFile("C:/Users/Amar/workspace/Lab2/Amar.txt");
	
}

}
	
