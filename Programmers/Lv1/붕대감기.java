import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> attackInfo = new HashMap<>();
    int endTime = 0;
    int curHealth = 0;
    int successiveTime = 0;

    public int solution(int[] bandage, int health, int[][] attacks) {
        curHealth = health;
        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
            endTime = attack[0];
        }

        for (int i = 1; i <= endTime; i++) {
            if (attackInfo.containsKey(i)) {
                curHealth -= attackInfo.get(i);
                successiveTime = 0;
            } else { // 공격이 없다면
                curHealth += bandage[1];
                successiveTime++;

                if (successiveTime == bandage[0]) {
                    curHealth += bandage[2];
                    successiveTime = 0;
                }
                if (curHealth > health) {
                    curHealth = health;
                }
            }

            if (curHealth <= 0) {
                return -1;
            }
        }

        return curHealth;
    }

}