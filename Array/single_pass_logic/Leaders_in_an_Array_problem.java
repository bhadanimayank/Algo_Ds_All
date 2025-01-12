// https://takeuforward.org/data-structure/leaders-in-an-array/

// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array

/*

Array Leaders
Difficulty: EasyAccuracy: 29.94%Submissions: 791K+Points: 2
You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

Examples:

Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
Input: arr = [10, 4, 2, 4, 1]
Output: [10, 4, 4, 1]
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
Input: arr = [5, 10, 20, 40]
Output: [40]
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
Input: arr = [30, 10, 10, 5]
Output: [30, 10, 10, 5]
Explanation: When an array is sorted in non-increasing order, all elements are leaders.
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 106



*/


// Java

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        
        int n = arr.length - 1;
        int max = arr[n];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = n; i >= 0; --i)
        {
            if(arr[i] >= max)
            {
                max = arr[i];
                list.add(0, arr[i]);
            }
        }
        
        return list;
    }
}

// C#

class Solution {
    public List<int> leaders(int[] arr) {
        // code here
        
        int n = arr.Length - 1;
        int max = arr[n];
        
        List<int> list = new List<int>();
        
        for(int i = n; i >= 0; --i)
        {
            if(arr[i] >= max)
            {
                max = arr[i];
                list.Insert(0, arr[i]);
            }
        }
        
        return list;
    }
}
