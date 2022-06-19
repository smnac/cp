/*

1268. Search Suggestions System
You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 

Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.

*/

class Solution {

	class Node {
		Node[] child;
		boolean isEndOfWord;
		Set<String> wordSet;

		public Node() {
			child = new Node[26];
			wordSet = new TreeSet<>();
			isEndOfWord = false;
		}
	}

	Node root = null;

	public void insert(String word) {
		Node cur = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (cur.child[index] == null)
				cur.child[index] = new Node();

			cur = cur.child[index];
			cur.wordSet.add(word);

		}

		cur.isEndOfWord = true;

	}

	public List<List<String>> search(String word) {

		Node cur = root;
		List<List<String>> ansList = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			List<String> curList = new ArrayList<>();
			if (cur.child[index] == null) { 
				for (int j = i; j < word.length(); j++) //no such prefix fill empty list
					ansList.add(new ArrayList<>());

				return ansList;
			}

			cur = cur.child[index];

			for (String item : cur.wordSet) {
				curList.add(item);
				if (curList.size() == 3) //as we need only first 3 in lex order
					break;
			}
			ansList.add(curList);
		}

		return ansList;

	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		root = new Node();

		for (String str : products)
			insert(str);

		return search(searchWord);

	}
}



