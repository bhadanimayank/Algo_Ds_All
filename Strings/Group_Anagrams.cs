// https://leetcode.com/problems/group-anagrams/description/

/*

49. Group Anagrams
Solved
Medium
Topics
conpanies icon
Companies
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

*/

/* Solution 1: Using Sorting
Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string which takes O(KlogK) time.
Space Complexity: O(NK), the total information content stored in ans.
*/

public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        
        var map = new Dictionary<string, List<string>>();

        foreach(string word in strs) {

            char[] chars = word.ToCharArray();
            Array.Sort(chars);
            string key = new String(chars);

            if(!map.ContainsKey(key))
                map[key] = new List<string>();

            map[key].Add(word);
        }

        return new List<IList<string>>(map.Values);
    }
}

/* Solution 2: Using Count
Time Complexity: O(NK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we count each character which takes O(K) time.
Space Complexity: O(NK), the total information content stored in ans.
*/

public class Solution
{
    public IList<IList<string>> GroupAnagrams(string[] strs)
    {

        var map = new Dictionary<string, List<string>>();

        foreach (string word in strs)
        {
            int[] count = new int[26];

            foreach (char c in word)
                count[c - 'a']++;

            string key = string.Join('#', count);

            if (!map.ContainsKey(key))
                map[key] = new List<string>();

            map[key].Add(word);
        }

        return new List<IList<string>>(map.Values);
    }
}