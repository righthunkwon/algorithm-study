class Solution {
    public int solution(int[] arrayA,int[] arrayB) {
        int answer=0,a=arrayA[0],b=arrayB[0];
        for(int i=1;i<arrayA.length;i++){
            a=gcd(a,arrayA[i]);
            b=gcd(b,arrayB[i]);
        }
        if(chk(arrayB,a)) answer=Math.max(a,answer);
        if(chk(arrayA,b)) answer=Math.max(b,answer);
        return answer;
    }
    
    public static int gcd(int a,int b){
        return a%b==0?b:gcd(b,a%b);
    }
    
    public static boolean chk(int[] arr,int num){
        for(int n:arr) if(n%num==0) return false;
        return true;
    }
}
