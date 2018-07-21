public class Solution {
    public int[][] permute(int[] A) {
        HashMap<Integer, Character> intChar = new HashMap<Integer, Character>();
        HashMap<Character, Integer> charInt = new HashMap<Character, Integer>();
        char c = 'A';
        String str = "";
        for (int i = 0; i < A.length; i++) {
            if (!intChar.containsKey(A[i])) {
                intChar.put(A[i], c);
                charInt.put(c, A[i]);
                str += c;
                c++;
            } else {
                str += intChar.get(A[i]);
            }
        }
        HashSet<String> hs = new HashSet<String>();
        hs = permuteString(hs, "", str);
        int[][] ret = new int[hs.size()][A.length];
        int permIndex = 0;
        Iterator<String> iter = hs.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            for (int i = 0; i < s.length(); i++) {
                ret[permIndex][i] = charInt.get(s.charAt(i));
            }
            permIndex++;
        }
        return ret;
    }
    
    public HashSet<String> permuteString(HashSet<String> hs, String prefix, String str) {
        if (str.length() == 0) {
            hs.add(prefix);
        }
        
        for (int i = 0; i < str.length(); i++) {
            permuteString(hs, prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1));
        }
        
        return hs;
    }
}
