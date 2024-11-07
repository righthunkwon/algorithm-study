class Solution {
    public int solution(String[][] book_time) {
    	int answer=0,x=0;
    	int[] nt=new int[14410];
    	int[][] t=new int[book_time.length][2];
        for(String[] book : book_time) {
        	t[x][0]=Integer.parseInt(book[0].split(":")[0])*60+Integer.parseInt(book[0].split(":")[1]);
        	t[x++][1]=Integer.parseInt(book[1].split(":")[0])*60+Integer.parseInt(book[1].split(":")[1])+10;
        }
        for(int[] i : t) {
        	nt[i[0]]++;
        	nt[i[1]]--;
        }
        for(int i=1;i<nt.length;i++) {
        	nt[i]+=nt[i-1];
        	answer=Math.max(answer, nt[i]);
        }
        return answer;
    }
}
