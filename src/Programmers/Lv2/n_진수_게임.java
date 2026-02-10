package Programmers.Lv2;

class n_진수_게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int count = 0;
        
        int idx = 0;
        
        int cur = 0;
        
        while (count != t) {
            String str = Integer.toString(cur, n);
            for (int i = 0; i < str.length(); i++) {
                char c = Character.toUpperCase(str.charAt(i));
                idx++;
                if (idx % m == p - 1) {
                    answer += c;
                    count++;
                  if (count == t) {
                    break;
                  }
                }
            }
            cur++;
        }
        
        return answer;
    }
}