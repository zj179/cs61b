public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> a = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            a.addLast(word.charAt(i));

        }
        return a;

    }
    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        Deque<Character> a = wordToDeque(word);
        while (a.size() > 1) {
            if (a.removeFirst() != a.removeLast()) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> a = wordToDeque(word);
        while(a.size() > 1){
            if(!cc.equalChars(a.removeFirst(), a.removeLast())){
                return false;
            }
        }
        return true;
    }
    /** recursive method*/
//    public boolean isPalindrom2(String word) {
//        Deque<Character> d =wordToDeque(word);
//        return isPalindromRecurisve(d);
//
//    }
//    private boolean isPalindromRecurisve(Deque<Character> d){
//        if(d.size() < 2){
//            return true;
//        }
//        if(d.removeFirst() != d.removeLast()){
//            return false;
//        }
//        return isPalindromRecurisve(d);
//
//
//    }

}
