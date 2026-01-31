package Programmers.코드챌린지_2025;

class 서버_증설_횟수_2차예선 {

    // 불필요한 상태(expire[24]) -> 제거 가능
    // 불필요한 계산(addServer) -> (requiredServer, currentServer 만 계산하면 됨)

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] expire = new int[25];
        
        int server = 0;
        
        for (int i = 0; i < 24; i++) {
            if (expire[i] > 0) {
                server -= expire[i];
            }
            int player = players[i];
            if (player / m > server) {
                int addServer = (player - server * m) / m;
                server += addServer;
                answer += addServer;
                if (i + k > 24) { //
                    expire[24] += addServer;
                } else {
                    expire[i+k] += addServer;
                }
            }
        }
        return answer;
    }
}