/* Problem - https://leetcode.com/problems/word-ladder/description/

https://takeuforward.org/graph/word-ladder-i-g-29/

127. Word Ladder
Solved
Hard
Topics
Companies
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.

*/

class Solution {

    class Pair{
        String word;
        int step;
        public Pair(String word, int step)
        {
            this.word = word;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<String>(wordList);
        Queue<Pair> queue = new LinkedList<Pair>();

        set.remove(beginWord);
        queue.offer(new Pair(beginWord, 1));

        while(!queue.isEmpty())
        {
            Pair p = queue.poll();

            String word = p.word;
            int step = p.step;

            if(word.equals(endWord))
            {
                return step;
            }

            for(int i = 0 ; i < word.length(); i++)
            {
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    char[] charWord = word.toCharArray();
                    charWord[i] = ch;

                    String str = new String(charWord);

                    if(set.contains(str))
                    {
                        set.remove(str);
                        queue.offer(new Pair(str, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}

/* Notes

Strating with start word, checking every possibility by replacing it's chars one by one with every alphabet. Now checking if the resulting words matches with the word in transformation word list, if yes, move that word to the queue
remove that word from transformation set so it won't be matched again. After polling that word matches if the word matches with the target word, If yes return, If no, then again follow the early mentioned transformation again.


*/