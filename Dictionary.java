import java.util.ArrayList;

public class Dictionary 
{
	private DefinitionNode root; // the root definition in the BST
	 
	/**
	 * Inserts a new word along with its meaning into the dictionary.
	 * @param word The word to be inserted
	 * @param meaning The meaning of the word being inserted
	 * @throws IllegalArgumentException when the word is already in this dictionary
	 */
	public void insert(String word, String meaning) throws IllegalArgumentException 
	{
		if (root == null)
		{
			root = new DefinitionNode(word, meaning);
			return;
		}
		if (!lookup(word).contains("No definition found"))
		{
			throw new IllegalArgumentException();
		}
		else
		{
			String wordL = word.toLowerCase();
			String meaningL = meaning.toLowerCase();
			DefinitionNode a = new DefinitionNode(wordL, meaningL);
			root.insertHelper(a);
		}
		// implement using the DefinitionNode's insertHelper() method
	}
	 
	/**
	 * Searches for the definition of a word, and then return that word's meaning.
	 * @param word The word that is being searched for
	 * @return The meaning of the word, or null if the word cannot be found.
	 */
	public String lookup(String word) {
	    // implement using the DefinitionNode's lookupHelper() method
		if (root == null)
		{
			return "There are no definitions in this empty dictionary.";
		}
		else if(root.lookupHelper(word) == null)
		{
			return "No definition found for the word " + word;
		}
		else 
		{
			return root.lookupHelper(word);
		}
	 }
	 
	/**
	 * Computes the number of words that are currently in this dictionary.
	 * @return That number of words
	 */
	public int getWordCount() {
	    // implement using the DefinitionNode's getWordCountHelper() method
		if (root == null)
		{
			return 0;
		}
		else
		{
			return root.getWordCountHelper();
		}
	}
	 
	/**
	 * Computes a list of all of the words that are currently in this dictionary.
	 * @return That list of all the words
	 */
	public ArrayList<String> getAllWords() {
	    // implement using the DefinitionNode's getAllWordsHelper() method
		if (root == null)
		{
			ArrayList<String> empty = new ArrayList<String>();
			empty.add("Dictionary is empty.");
			return empty;
		}
		else 
		{
			return root.getAllWordsHelper();
		}
	}
}
