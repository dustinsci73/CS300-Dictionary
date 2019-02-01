import java.util.ArrayList;

public class DefinitionNode 
{
	private final String word;      // the word this definition defines
	private final String meaning;   // the meaning of that word    
	private DefinitionNode leftChild;   // nodes preceding this one alphabetically
	private DefinitionNode rightChild;  // nodes following this one alphabetically
	 
	/**
	 * Constructs a DefinitionNode with the specified word and meaning.
	 * @param word The word associated with this definition
	 * @param meaning The meaning of that word
	 * @throws IllegalArgumentException when the word or meaning are either
	 *         references to an empty string or null references.
	 */
	public DefinitionNode(String word, String meaning) 
	{ 
		if (word == null || word == "" || meaning == null || meaning == "")
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.word =  word;
			this.meaning = meaning;
			leftChild = null;
			rightChild =  null;
		}
	}
	 
	/**
	 * This helper method inserts a new node into the tree or subtree that is 
	 * rooted at this node.  If it cannot directly add the new node as a child 
	 * of this node, then it must recursively call this method on its appropriate
	 * child, to eventually complete this insertion.
	 * @param newNode The new node that is being inserted into the tree
	 * @throws IllegalArgumentException when the word inside newNode is already in
	 *         the tree.  Multiple definitions for the same word are not allowed.
	 */
	public void insertHelper(DefinitionNode newNode) throws IllegalArgumentException 
	{
		if (word == newNode.word)
		{
			throw new IllegalArgumentException();
		}
		else if (word.compareTo(newNode.word) < 0)
		{
			if (rightChild != null)
			{
				rightChild.insertHelper(newNode);
			}
			else
			{
				rightChild = newNode;
			}
		}
		else if (word.compareTo(newNode.word) >= 0)
		{
			if (leftChild != null)
			{
				leftChild.insertHelper(newNode); 
			}
			else
			{
				leftChild = newNode;
			}
		}
	}
	 
	/**
	 * This helper method retrieves the meaning of a particular word from the
	 * tree or subtree rooted at this node.  Like the insertHelper method above, 
	 * this method should also be defined recursively.
	 * @param word The word associated with the meaning being looked up
	 * @return The meaning of that word, or null if the word is not found
	 */
	public String lookupHelper(String word) 
	{ 
		
		if (this.word.equals(word))
		{
			return this.meaning;
		}
		if (this.word.compareTo(word) >= 0 && leftChild != null)
		{
			String temp = leftChild.lookupHelper(word);
			return temp;
		}
		if (this.word.compareTo(word) < 0 && rightChild != null)
		{
			String temp = rightChild.lookupHelper(word);
			return temp;
		}
		return null;
	}
	 
	/**
	 * This recursive helper method retrieves the number of words in the tree
	 * or subtree rooted at this node.
	 * @return The number of definitions in this tree or subtree
	 */
	public int getWordCountHelper() 
	{ 
		int count = 1;

		if (leftChild != null)
		{
			count += leftChild.getWordCountHelper();
		}
		if (rightChild != null)
		{
			count += rightChild.getWordCountHelper();
		}
		return count;
	}
	 
	/**
	 * This recursive helper method retrieves a list containing all of the
	 * words in the tree or subtree rooted at this node.
	 * @return The list of all words in this words tree or subtree
	 */
	public ArrayList<String> getAllWordsHelper() 
	{ 
		ArrayList<String> temp = new ArrayList<String>();
		
		if (leftChild != null)
		{
			temp.addAll(leftChild.getAllWordsHelper());
		}
		temp.add(word);
		if (rightChild != null)
		{
			temp.addAll(rightChild.getAllWordsHelper());
		}
		return temp; 
	}
}
