class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
                for (int i = 0; i < order.length(); i++) {
                            orderIndex[order.charAt(i) - 'a'] = i;
                                    }

                                            for (int i = 0; i < words.length - 1; i++) {
                                                        if (!inOrder(words[i], words[i + 1], orderIndex)) {
                                                                        return false;
                                                                                    }
                                                                                            }
                                                                                                    return true;
                                                                                                        }

                                                                                                            private boolean inOrder(String word1, String word2, int[] orderIndex) {
                                                                                                                    int minLength = Math.min(word1.length(), word2.length());
                                                                                                                            for (int i = 0; i < minLength; i++) {
                                                                                                                                        char c1 = word1.charAt(i);
                                                                                                                                                    char c2 = word2.charAt(i);
                                                                                                                                                                if (c1 != c2) {
                                                                                                                                                                                return orderIndex[c1 - 'a'] < orderIndex[c2 - 'a'];
                                                                                                                                                                                            }
                                                                                                                                                                                                    }
                                                                                                                                                                                                            return word1.length() <= word2.length();
    }
}