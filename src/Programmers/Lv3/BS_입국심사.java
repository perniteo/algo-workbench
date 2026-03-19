package Programmers.Lv3;

class BS_입국심사 {

    // 가능한 시간 이분탐색
    
    long binarySearch(int n, int[] times, long maxTime) {
        long left = 0;
        long right = maxTime;
        
        long answer = 0;
        
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            
            long people = 0;
            
            for (int time : times) {
                people += mid / time;
            }
            
            if (people >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
            
        }
        
        return answer;
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;

        long maxTime = 0;
        
        int minTime = Integer.MAX_VALUE;
        
        for (int t : times) {
            minTime = Math.min(minTime, t);
        }
        
        maxTime = (long) n * (long) minTime;
        
        answer = binarySearch(n, times, maxTime);
        
        return answer;
    }
}