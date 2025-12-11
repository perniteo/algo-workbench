package Programmers.PCCP;

public class 붕대감기_1번 {
  // 재밌었음 '모의 턴제 전투' 구현하는 느낌
  // 확장성 고려해서 attacked 를 넣었음

    public int solution(int[] bandage, int health, int[][] attacks) {
      int maxHealth = health;

      int phase = 0;

      int turn = 1;

      int bandageCharge = 0;
      boolean attacked;

      while (phase != attacks.length) {
        attacked = false;
        if (attacks[phase][0] == turn) {
          health -= attacks[phase][1];
          attacked = true;
          bandageCharge = 0;
          phase++;
          if (health <= 0) {
            return -1;
          }
        }

        if (!attacked) {
          bandageCharge++;
          health += bandage[1];

          if (bandageCharge == bandage[0]) {
            health += bandage[2];
            bandageCharge = 0;
          }
          if (health > maxHealth) {
            health = maxHealth;
          }
        }

        turn++;
      }


      return health;
    }
  }

