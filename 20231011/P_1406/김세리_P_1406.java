import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        // list에 tocharArray를 이용해서 값을 집어넣는다
        List<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            list.add(c);
        }
        
        /*
         * ListIterator는 Java에서 List 인터페이스를 구현한 컬렉션에서 요소들을 순차적으로 접근하고 조작하기 위한 인터페이스
         * 
         * ListIterator는 Iterator 인터페이스를 확장하면서 추가적인 기능을 제공한다.
         * 
         * ListIterator의 주요 메서드들:
         * 
         * - hasNext(): 다음 요소가 존재하는지 확인하고, 존재한다면 true를 반환한다.
         * - next(): 다음 요소를 반환하고, 커서를 다음 위치로 이동한다.
         * - hasPrevious(): 이전 요소가 존재하는지 확인하고, 존재한다면 true를 반환한다.
         * - previous(): 이전 요소를 반환하고, 커서를 이전 위치로 이동한다.
         * - nextIndex(): 다음 요소의 인덱스를 반환힌다.
         * - previousIndex(): 이전 요소의 인덱스를 반환한다.
         * - add(E e): 현재 위치에 새로운 요소를 추가한다.
         * - remove(): 현재 위치의 요소를 제거한다.
         * - set(E e): 현재 위치의 요소를 새로운 값으로 교체한다.
         * 
         * ListIterator는 단방향 순회뿐만 아니라 양방향 순회도 가능하다. Iterator는 단방향만 가능.
         */

        ListIterator<Character> cursor = list.listIterator(list.size());
        int M = Integer.parseInt(br.readLine());

        // M에서 1씩 감소시키는데 M이 양수일때 까지 while문 반복
        while (M-- > 0) {
            String str = br.readLine();
            char st = str.charAt(0);

            if (st == 'P') {
            	// 현재 위치에 문자 추가
                cursor.add(str.charAt(2));
            } else if (st == 'L' && cursor.hasPrevious()) {
            	// 커서를 앞으로 이동(앞에 값이 있을 때만)
                cursor.previous();
            } else if (st == 'D' && cursor.hasNext()) {
            	// 커서를 다음으로 이동(다음으로 갈 수 있을 때만)
                cursor.next();
            } else if (st == 'B' && cursor.hasPrevious()) {
            	// 커서를 앞으로 이동 하고(이동 할 수 있을 때만), 해당 문자를 삭제
                cursor.previous();
                cursor.remove();
            }
        }

        // list의 값을 result에 저장(for문으로 돌리면 시간초과뜸)
        StringBuilder result = new StringBuilder();
        for (char c : list) {
            result.append(c);
        }

        System.out.println(result);
    }
}
