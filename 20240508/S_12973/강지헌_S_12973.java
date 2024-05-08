import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
	Stack<Character> st = new Stack<Character>();
	for(char c : s.toCharArray()) {
		if(!st.isEmpty() && st.peek()==c) st.pop();
		else st.push(c);
	}
	return st.isEmpty()?1:0;
    }
}
