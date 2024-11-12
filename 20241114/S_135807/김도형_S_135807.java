//최대공약수 구하는 방법 까먹어서 찾아봄..

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0]; //A배열의 최대공약수
        int gcdB = arrayB[0]; //B배열의 최대공약수
        for(int i=1;i<arrayA.length;i++){
            gcdA = gcd(arrayA[i],gcdA);
        }
        for(int i=1;i<arrayB.length;i++){
            gcdB = gcd(arrayB[i],gcdB);
        }
        
        //gcdA로 B배열 중 나눠떨어지는게 있는지 확인  
        for(int i=0;i<arrayB.length;i++){
            if(arrayB[i]%gcdA==0)break;
            if(i==arrayB.length-1)answer = gcdA;
        }
        
        //gcdB로 A배열 중 나눠떨어지는게 있는지 확인
        for(int i=0;i<arrayA.length;i++){
            if(arrayA[i]%gcdB==0)break;
            if(i==arrayA.length-1)answer = Math.max(gcdB,answer);
        }

        return answer;
    }

    //유클리드 호제법을 통해 최대공약수 구하기
    public static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }

    /*
    // 반복문 방식
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    */
  
}
