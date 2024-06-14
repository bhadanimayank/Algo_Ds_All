/* Problem - https://leetcode.com/problems/word-ladder-ii/description/

https://takeuforward.org/graph/g-30-word-ladder-ii/

126. Word Ladder II
Hard
Topics
Companies
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
The sum of all shortest transformation sequences does not exceed 105.

*/

class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> st = new HashSet<String>(wordList);
        Queue<ArrayList<String>> queue = new LinkedList<>();

        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        queue.offer(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;

        List<List<String>> ans = new ArrayList<>();

        while(!queue.isEmpty())
        {
            ArrayList<String> lst = queue.poll();

            if(lst.size() > level)
            {
                level++;

                for(String it: usedOnLevel)
                {
                    st.remove(it);
                }
            }

            String word = lst.get(lst.size() - 1);

            if(word.equals(endWord))
            {
                if(ans.size() == 0)
                {
                    ans.add(lst);
                }
                else if(ans.get(0).size() == lst.size())
                {
                    ans.add(lst);
                }
            }

            for (int i = 0; i < word.length(); i++)
            {
                for (char c = 'a'; c <= 'z'; c++)
                {
                    char[] wordCharArray = word.toCharArray();
                    wordCharArray[i] = c;
                    String transformedWord = new String(wordCharArray);

                    if(st.contains(transformedWord))
                    {
                        lst.add(transformedWord);
                        
                        ArrayList<String> temp = new ArrayList<String>(lst);
                        queue.add(temp);

                        usedOnLevel.add(transformedWord);
                        lst.remove(lst.size() - 1);
                    }
                }
            }

        }

        return ans;
    }
}