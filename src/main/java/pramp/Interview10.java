class Pramp {

   public static String get(String s, char[] a) {
      if (a == null || a.length == 0 || s == null || s.length() == 0 || a.length > s.legnth())
         return null;
      String r = null;
      int[] c = new int[256];
      for (int i=0; i< a.length; i++)
         c[s.charAt(i)]++;
      int i = 0, j = a.length - 1;
      while (i <= s.length() - a.length && j <= s.length()) {
         if (allPresent(a, c)) {
            r = (r == null || r.length() > j - i) ? s.substring(i, j) : r; // 5, 8
            if (r.length() == a.length)
               return r;
            c[s.charAt(i)]--;
            i++;
         } else {
            j++;
            c[s.charAt(j)]++;
         }
      }
      return r;
   }
   
   public static boolean allPresent(char[] a, int[] c) {
      for (char aa : a) {
         if (c[aa] == 0)
            return false;
         c[aa]--;
      }
      return true;
   }
}
