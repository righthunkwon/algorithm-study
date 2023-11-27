package baek;

import java.io.*;

public class Pro_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String math = br.readLine();
		//마이너스로 다 쪼개서 다 괄호쳐주면  제일 최소 아님?? 아닌가? 
    //10-(50+20)-(10)-(10+10) 마이너스로 다쪼개고 사이는 한번에 더해서 빼자 
    
		String[] arr = math.split("-");
		int min = 0;
    
		for (int i = 0; i < arr.length; i++) {
		  	String[] arr2 = arr[i].split("\\+"); //사이에 덧셈이 있다면 값 더해 , split("+")이렇게 하려면 split("\\+")이렇게 해야가능
			  int sum = 0;
			  for (int j = 0; j < arr2.length; j++) {
				      sum += Integer.parseInt(arr2[j]);
			  }
			  if(i==0)min+=sum;           //가장 앞 수는 더하기
			  else min-=sum;              //나머지는 빼기가 앞에 붙어있는거니까
		}
		System.out.println(min);
	}
}
