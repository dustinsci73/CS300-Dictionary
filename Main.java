import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		Scanner scnr = new Scanner(System.in);
		String userResponse = "";
		do {
			System.out.println("==================Dictionary =================");
			System.out.println("Enter 'I' to Insert a definition in the dictionary");
			System.out.println("Enter 'L' to Lookup a definition in the dictionary");
			System.out.println("Enter 'A' to print All the words in the dictionary");
			System.out.println("Enter ‘C’ to print the Count of all words in the dictionary");
			System.out.println("Enter 'Q' to quit the program");
			System.out.println("==========================================");
			System.out.println("Please enter your command: ");
			
			String input = scnr.nextLine();
			String[] inputs = input.split(" ");
			userResponse = inputs[0].toUpperCase();
			switch (userResponse) {
				case "I" : String meaning = inputs[1] + " - ";
						   for (int j = 2; j < inputs.length; j++)
						   {
							   meaning += inputs[j];
							   meaning += " ";
						   }
						   try 
						   {
							   dictionary.insert(inputs[1], meaning);
						   }
						   catch (IllegalArgumentException e)
						   {
							   System.out.println("WARNING: failed to insert duplicate word: " + inputs[1] 
									   + ".");
						   }
				    		   //String word = scnr.nextLine().trim();
						   break;
				case "L" : System.out.println(dictionary.lookup(inputs[1]));
					break;
				case "A" : for (int i = 0; i < dictionary.getAllWords().size(); i++)
							{
								System.out.print(dictionary.getAllWords().get(i));
								if (i < dictionary.getAllWords().size() - 1) 
								{
									System.out.print(", ");
								}
							}
							System.out.println();
					break;
				case "C" : System.out.println(dictionary.getWordCount());
					break;
				case "Q" : return;
				default :
					System.out.println("WARNING: Unrecognized command.");
				}
				System.out.println();
		} while (true);

	}

}

