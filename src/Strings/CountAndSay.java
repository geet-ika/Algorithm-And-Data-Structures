
class CountAndSay {

    public String countAndSay(int n) {
        return countAndSay((long) n);
    }

    private String countAndSay(long n) {
        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);
        int len = str.length(), count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            count = 1;
            while (i < len - 1 && str.charAt(i + 1) == c) {
                count++;
                i++;
            }
            sb.append(String.valueOf(count));
            sb.append(c);
        }
        return sb.toString();
    }
}
