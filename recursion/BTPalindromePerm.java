/*
267. Palindrome Permutation II
Medium

718

85

Add to List

Share
Given a string s, return all the palindromic permutations (without duplicates) of it.

You may return the answer in any order. If s has no palindromic permutation, return an empty list.

 

Example 1:

Input: s = "aabb"
Output: ["abba","baab"]
Example 2:

Input: s = "abc"
Output: []
 

Constraints:

1 <= s.length <= 16
s consists of only lowercase English letters.

*/



class BTPalindromePerm {
	public List<String> generatePalindromes(String s) {

		HashMap<Character, Integer> hm = new HashMap<>();

		for (char c : s.toCharArray())
			hm.put(c, hm.getOrDefault(c, 0) + 1);

		char odd = '@';
		int oc = 0;
		for (Map.Entry<Character, Integer> cm : hm.entrySet()) {
			char key = cm.getKey();
			int freq = cm.getValue();
			if (freq % 2 == 1) {
				oc++;
				odd = key;
			}

			hm.put(key, freq / 2);

		}

		if (oc > 1)
			return new ArrayList<>();

		List<String> res = new ArrayList<>();

		generatePalindromPerm("", odd, s.length() / 2, hm, res);

		return res;

	}

	void generatePalindromPerm(String p, char odd, int len, HashMap<Character, Integer> hm, List<String> ans) {

		if (p.length() == len) {
			StringBuilder sb = new StringBuilder(p);
			sb.reverse();
			if (odd != '@')
				ans.add(p + odd + sb.toString());
			else
				ans.add(p + sb.toString());
			return;
		}

		for (Map.Entry<Character, Integer> cm : hm.entrySet()) {
			char ch = cm.getKey();
			int freq = cm.getValue();

			if (freq > 0) {
				hm.put(ch, freq - 1);
				generatePalindromPerm(p + ch, odd, len, hm, ans);
				hm.put(ch, freq); // backtrack
			}

		}

	}

}
