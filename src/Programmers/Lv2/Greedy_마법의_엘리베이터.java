package Programmers.Lv2;

class Greedy_마법의_엘리베이터 {

    // 5일 경우 앞자리 확인 후 올림 or 내림 처리

    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int n = storey % 10;
            if (n > 5 || (n == 5 && (storey / 10) % 10 >= 5)) {
                answer += 10 - n;
                storey += 10 - n;
            } else {
                answer += n;
                storey -= n;
            }
            storey /= 10;
        }
        
        return answer;
    }
}