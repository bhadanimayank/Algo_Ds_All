/* Problem - https://leetcode.com/problems/parsing-a-boolean-expression/description/

1106. Parsing A Boolean Expression
Solved
Hard
Topics
Companies
Hint
A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:

't' that evaluates to true.
'f' that evaluates to false.
'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
Given a string expression that represents a boolean expression, return the evaluation of that expression.

It is guaranteed that the given expression is valid and follows the given rules.

 

Example 1:

Input: expression = "&(|(f))"
Output: false
Explanation: 
First, evaluate |(f) --> f. The expression is now "&(f)".
Then, evaluate &(f) --> f. The expression is now "f".
Finally, return false.
Example 2:

Input: expression = "|(f,f,f,t)"
Output: true
Explanation: The evaluation of (false OR false OR false OR true) is true.
Example 3:

Input: expression = "!(&(f,t))"
Output: true
Explanation: 
First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
Then, evaluate !(f) --> NOT false --> true. We return true.
 

Constraints:

1 <= expression.length <= 2 * 104
expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.

*/

class Solution {

    private int start;
    private char[] chars;

    public boolean parseBoolExpr(String expression) {
        this.chars = expression.toCharArray();
        this.start = 0;

        return parseSub();
    }

    public boolean parseSub()
    {
        boolean result;

        if ( chars[start] == 't' )
        {
            result = true;
        }
        else if ( chars[start] == 'f' )
        {
            result = false;
        }
        else if ( chars[start] == '!' )
        {
            start += 2;
            result = !parseSub();
        }
        else if ( chars[start] == '|' )
        {
            start++;
            result = false;

            while( chars[start] != ')' )
            {
                start++;
                boolean temp = parseSub();
                result = result || temp;
            }
        }
        else if ( chars[start] == '&' )
        {
            start++;
            result = true;

            while( chars[start] != ')' )
            {
                start++;
                boolean temp = parseSub();
                result = result && temp;
            }
        }
        else 
        {
            throw new IllegalArgumentException("Unexpected char " + chars[start] + " at " + start);
        }

        start++;
        return result;
    }
}

/* Notes

So for '!', we do start += 2 because we need to jump '!' and '(' then evaluate the internal expression, then we do ++start at last to jump ')' 

Also, for '|', we do start++ because we need to jump '(' then evaluate the internal expression, then we do ++start at last to jump ')' 

For '&' too, we do start++ because we need to jump '(' then evaluate the internal expression, then we do ++start at last to jump ')' 
*/
