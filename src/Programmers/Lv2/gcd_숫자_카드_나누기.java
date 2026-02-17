package Programmers.Lv2;

class gcd_숫자_카드_나누기 {
    
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = 0;
        int gcdB = 0;
        
        if (arrayA.length < 2) {
            gcdA = arrayA[0];
            gcdB = arrayB[0];
        } else {
            gcdA = gcd(arrayA[0], arrayA[1]);
            gcdB = gcd(arrayB[0], arrayB[1]);
        }
        
        for (int i = 2; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        for (int i = 0; i < arrayA.length; i++) {
          if (gcdA != 0 && arrayB[i] % gcdA == 0) {
            gcdA = 0;
          }
          if (gcdB != 0 && arrayA[i] % gcdB == 0) {
            gcdB = 0;
          }
        }
        
        answer = Math.max(gcdA, gcdB);
        
        return answer;
    }
}