class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // 1. 먼저 차량 간 누적 시간 기록
        // 2. 시간에 따른 금액 계산
        
        // 차량 누적시간 계산시 hashmap 사용
        HashMap<String, String> cars = new HashMap<String, String>(); // 1.번호 2.시간
        HashMap<String, Integer> time = new HashMap<String, String>(); // 1.번호 2.누적시간
        for(int i = 0;i<records.length;i++){
            int[] tmp = records[i].split(" ");
            // tmp 배열에 한차의 정보를 저장
            
            if (tmp[2].equals("IN")) {	
                //in이면 배열에 넣고 반대는 꺼내고 시간 저장
				cars.put(temp[1], temp[0]);
			} else {	//OUT인 경우 기존에 들어가 있는 IN 시간을 가져온다.
				String timeIn[] = cars.get(temp[1]).split(":");
				cars.remove(temp[1]);
				String timeOut[] = temp[0].split(":");
				int min = 0;	//분을 계산한다.
				min += (Integer.parseInt(timeOut[0]) - Integer.parseInt(timeIn[0])) * 60;
				min += Integer.parseInt(timeOut[1]) - Integer.parseInt(timeIn[1]);
				if (result.containsKey(temp[1])) {	//계산된 분을 result에 누적으로 담아준다.
					result.replace(temp[1], result.get(temp[1]) + min);
				} else {
					result.put(temp[1], min);
				}
			}
		}
        // 이제 요금 계산하고 
        // 정렬해서 낮은 순서대로 출력하면됨
        }
        
        
        
        
        
        return answer;
    }
}
