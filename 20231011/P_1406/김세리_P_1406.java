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
        List<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            list.add(c);
        }

        ListIterator<Character> cursor = list.listIterator(list.size());
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            String str = br.readLine();
            char st = str.charAt(0);

            if (st == 'P') {
                cursor.add(str.charAt(2));
            } else if (st == 'L' && cursor.hasPrevious()) {
                cursor.previous();
            } else if (st == 'D' && cursor.hasNext()) {
                cursor.next();
            } else if (st == 'B' && cursor.hasPrevious()) {
                cursor.previous();
                cursor.remove();
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : list) {
            result.append(c);
        }

        System.out.println(result);
    }
}
