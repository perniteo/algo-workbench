package Programmers.코드챌린지_2025;

class 서버_증설_횟수_refactoring {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] expire = new int[24];
        
        int server = 0;
        
        for (int i = 0; i < 24; i++) {
            if (expire[i] > 0) {
                server -= expire[i];
            }
            int player = players[i];
            int requiredServer = player / m;
            if (requiredServer > server) {
                int addServer = requiredServer - server;
                server += addServer;
                answer += addServer;
                if (i + k < 24) {
                    expire[i+k] += addServer;
                }
            }
        }
        return answer;
    }
}