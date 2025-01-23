// 방법1 => 누적, 데미지를 일종의 리버스 체력으로 보면 선형으로 풀이 가능
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long heroAtk = sc.nextLong();
        int[][] map = new int[n][3];

        for (int i = 0; i < n; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
            map[i][2] = sc.nextInt();
        }

        long cur = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            if (map[i][0] == 1) {
                long monAtk = map[i][1];
                long monHp = map[i][2];
                cur += monAtk * ((monHp / heroAtk) - (monHp % heroAtk == 0 ? 1 : 0));
                max = Math.max(max, cur);
            } else if (map[i][0] == 2) {
                long atk = map[i][1];
                long heal = map[i][2];
                heroAtk += atk;
                cur = Math.max(0, cur - heal);
            }
        }

        System.out.println(max + 1);
    }
}
// 방법2 => 구현+이분탐색
import java.util.*;

public class Main {

    static class Hero {
        long heroHp;
        long heroMaxHp;
        long heroAtk;

        public Hero(long heroMaxHp, long heroAtk) {
            this.heroHp = heroMaxHp;
            this.heroMaxHp = heroMaxHp;
            this.heroAtk = heroAtk;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int heroAtk = sc.nextInt();
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
            map[i][2] = sc.nextInt();
        }

        long left = 1;
        long right = (long) 1e18;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (clearChk(new Hero(mid, heroAtk), map)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean clearChk(Hero hero, int[][] map) {
        for (int[] room : map) {
            if(room[0] == 1){
                hero = monster(hero, room[2], room[1]);
                if (hero.heroHp <= 0) return false;
            }else{
                hero = potion(hero, room[1], room[2]);
            }
        }
        return true;
    }
    public static Hero monster(Hero hero, int monHp, int monAtk) {
        long attackCount = (long) Math.ceil((double) monHp / hero.heroAtk);
        long totalage = (attackCount - 1) * monAtk;

        if (hero.heroHp <= totalage) {
            hero.heroHp = 0;
        } else {
            hero.heroHp -= totalage;
        }
        return hero;
    }

    public static Hero potion(Hero hero, int atkPoint, int recoverHp) {
        hero.heroAtk += atkPoint;
        hero.heroHp = Math.min(hero.heroMaxHp, hero.heroHp + recoverHp);
        return hero;
    }
}

// heroMaxHp => 용사 최대 hp, 최솟값, 입장 이후 변동 X
// heroCurHp => 용사 현재 hp, 입장시 heroMaxHp가 기본 값, MaxHp보다 커질 수 없음
// heroAtk => 용사 데미지
// 일직선 방구조
// [몬스터 방 입장 시 / 1]
// 1 몬스터 데미지a 몬스터 체력h
// 1. 용사 데미지가 몬스터 체력 이상이면 방 통과 => 반복문 종료
// 2. 미만 일 경우 몬스터 체력 차감
// 3. 몬스터 데미지가 용사 체력 이상이면 용사 사망 => 실행 종료
// 4. 미만 일 경우 용사 체력 차감
// [포션 방 입장 시 / 2]
// 2 용사데미지 증가a 용사 체력회복h