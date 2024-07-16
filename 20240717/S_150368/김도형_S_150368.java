class Solution {
    
    //1.중복순열을 통해 각 이모티콘의 할인율의 모든 경우의 수를 계산
    //2.경우의 수 중에서 이모티콘 플러스 가입자 수가 최대가 되는 경우 갱신(가입자수,판매액 모두)
    //3.이모티콘 플러스 가입자 수가 현재 최대 가입자 수와 동일할 경우 전체 판매액 비교 후 갱신
    
    private static int[]discount = {10,20,30,40}; //할인율
    private static int emoticonPlus = 0; //이모티콘 플러스 서비스 가입자 수
    private static int totalSale = 0; //전체 판매액
    private static int[] sale; // 이모티콘 할인율을 저장할 배열
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        sale = new int[emoticons.length]; //각 이모티콘의 할인율 배열 
        
        perm(0,users,emoticons);
        
        int[] answer = {emoticonPlus,totalSale};
        return answer;
    }
    
    //모든 경우의 수 계산하는 중복순열
    public void perm(int depth,int[][] users,int[]emoticons){
        
        if(depth == emoticons.length){
           cal(sale,users,emoticons);
           return;
        }
        
        for(int i=0;i<4;i++){
            sale[depth]=discount[i]; //현재 depth의 이모티콘 할인율 할당
            perm(depth+1,users,emoticons);
        }
        
    }
    
    //해당 경우의 수의 이모티콘 플러스 가입자 수와 이모티콘 판매액 계산하는 메서드
    public void cal(int[]sale, int[][]users, int[]emoticons){
        
        int tmpEmoticonPlus=0;
        int tmpTotalSale=0;
        
        for(int[]user:users){
            int userTotal = 0; //해당 유저의 이모티콘 구매금액(user[1]보다 커지면 플러스 가입)
            
            for(int i=0;i<emoticons.length;i++){
                //해당 유저의 기준에 부합하는 이모티콘 구매
                if (sale[i] >= user[0]) {
                    userTotal += emoticons[i] * (100 - sale[i]) / 100;
                }
            }
            
            //플러스 가입하거나 각각 구입하거나
            if(userTotal>=user[1]){
                tmpEmoticonPlus++;
            }else{
                tmpTotalSale+=userTotal;
            }
        }
        
        //갱신
        if(tmpEmoticonPlus>emoticonPlus){ 
            emoticonPlus = tmpEmoticonPlus;
            totalSale = tmpTotalSale;
        }else if(tmpEmoticonPlus==emoticonPlus && tmpTotalSale>totalSale){
            totalSale = tmpTotalSale;
        }
   
    }
    
    
    
}
