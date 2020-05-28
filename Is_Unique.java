/*
 * 1.1: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
*/

// Solution 1
boolean isUniqueChars(String str) {
    if (str.length() > 128) return false;

    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i);
        if (char_set[val]) {    // Already found this char in string
            return false;
        }
        char_set[val] = true;
    }
    return true;
}

/*
 * Summary
 * Time complexity is O(n) where n is the length of the string.
 * Space complexity is O(1).
 * If you didn't want to assume the character set is fixed, you could express the complexity as O(c) space
 * and O(min(c, n)) or O(c) time, where c is the size of the character set.
*/