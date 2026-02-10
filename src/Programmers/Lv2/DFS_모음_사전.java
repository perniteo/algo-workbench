package Programmers.Lv2;

class DFS_모음_사전 {

  // String + dfs
    
    int answer = 0;
    
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    
    String word;
    
    boolean dfs(String cur) {
      if (cur.equals(word)) {
        return true;
      }
      if (cur.length() == 5) {
        return false;
      }
        
        for (int i = 0; i < 5; i++) {
            answer++;
          if (dfs(cur + words[i])) {
            return true;
          }
        }
        return false;
    }
    
    public int solution(String word) {
        this.word = word;
        dfs(new String());
        return answer;
    }
}