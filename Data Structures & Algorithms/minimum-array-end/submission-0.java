class Solution {
    public long minEnd(int n, int x) {
          long result = x;
                  n--;
                          int bitPos = 0;
                                  while (n > 0) {
                                              if ((result & (1L << bitPos)) == 0) {
                                                              if ((n & 1) == 1) {
                                                                                  result |= (1L << bitPos);
                                                                                                  }
                                                                                                                  n >>= 1;
                                                                                                                              }
                                                                                                                                          bitPos++;
                                                                                                                                                  }
                                                                                                                                                          return result;
    }
}