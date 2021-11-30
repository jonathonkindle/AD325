class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 10)
            return res;
        Set<String> one = new HashSet<>(), two = new HashSet<>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!one.add(sub))
                two.add(sub);
        }
        res.addAll(two);
        return res;
    }
}