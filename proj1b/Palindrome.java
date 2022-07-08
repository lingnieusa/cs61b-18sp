public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> res = wordToDeque(word);
        while(res.size()>1) {
            if(res.removeFirst()!=res.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> res = wordToDeque(word);
        while(res.size()>1) {
            if(!cc.equalChars(res.removeFirst(),res.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
