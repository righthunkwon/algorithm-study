import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        Set<Character> usedKeys = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String option = sc.nextLine();
            String[] words = option.split(" ");
            boolean shortcut = false;
            
            for (int j = 0; j < words.length; j++) {
                char firstChar = Character.toLowerCase(words[j].charAt(0));
                if (!usedKeys.contains(firstChar)) {
                    usedKeys.add(firstChar);
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    shortcut = true;
                    break;
                }
            }

            if (!shortcut) {
                for (int j = 0; j < words.length; j++) {
                    for (int k = 0; k < words[j].length(); k++) {
                        char ch = Character.toLowerCase(words[j].charAt(k));
                        if (!usedKeys.contains(ch)) {
                            usedKeys.add(ch);
                            words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
                            shortcut = true;
                            break;
                        }
                    }
                    if (shortcut) break;
                }
            }
            sb.append(String.join(" ", words)).append("\n");
        }

        System.out.print(sb);
    }
}
