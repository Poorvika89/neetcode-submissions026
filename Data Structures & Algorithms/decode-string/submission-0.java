class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
                Deque<StringBuilder> stringStack = new ArrayDeque<>();
                        StringBuilder current = new StringBuilder();
                                int count = 0;

                                        for (char c : s.toCharArray()) {
                                                    if (Character.isDigit(c)) {
                                                                    count = count * 10 + (c - '0');
                                                                                } else if (c == '[') {
                                                                                                countStack.push(count);
                                                                                                                stringStack.push(current);
                                                                                                                                current = new StringBuilder();
                                                                                                                                                count = 0;
                                                                                                                                                            } else if (c == ']') {
                                                                                                                                                                            StringBuilder prev = stringStack.pop();
                                                                                                                                                                                            int repeat = countStack.pop();
                                                                                                                                                                                                            for (int i = 0; i < repeat; i++) prev.append(current);
                                                                                                                                                                                                                            current = prev;
                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                        current.append(c);
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                    return current.toString();
    }
}