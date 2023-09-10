import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N;
	static ArrayList<Integer> arr; // 처음 숫자 담을 공간

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		arr = new ArrayList<>();
		for(int i =0;i<N;i++) {
			arr.add(sc.nextInt());
		}
   // arr에 입력 완료
		Stack<Integer> st = new Stack<>(); // 여기에 저장해서 나오는 숫자가 다르면 false
		boolean flag = false; // flag가 true면 nice로
		int index = 1; // 비교해야할 수
		while(true) {
			int tmp;
      // arr size가 0이 되면 나머진 
      // st에 저장되어 있는 수를
      // pop하여 선정한다.
			if(arr.size() !=0) {
				tmp = arr.get(0);
				arr.remove(0);
			}
			else {
				tmp = st.pop();
			}
			// tmp 설정 끝

      // index와 tmp가 같으면 index++
			if(index == tmp) {
				index++;
        // index를 1더하여준 후에 
        // 현재 st에 꼭대기에 있는 수가
        // index랑 같은지 비교하여
        // 같지않을 때 까지 진행하여 준다.
				while(true) {					
					if(st.size()!=0 && st.peek() == index) {
						st.pop();
						index++;
					}
					else {
						break;
					}
				}
			}
      // index와 현재수가 다를 때
      // st사이즈가 0이거나 st에 있는수가 현재 수보다 크다면
      // st에 저장
			else if(st.size()==0 || st.peek()>tmp) {
				st.push(tmp);
			}
      // 나머지 경우는 조건을 만족하지 않으므로 break
			else {
				break;
			}		
      // index가 N까지 다 만족하고 index+1을 진행하여 주었기 때문에
      // 조건을 다 만족했으므로 true
			if(index==N+1) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("Nice");
		}
		else {
			System.out.println("Sad");
		}


	}


}
