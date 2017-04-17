class Pramp {
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
   }
   
   
   public static void print(int[][] a) {
      if (a == null || a.length == 0 || a[0].length == 0)
         return;
      int x = 0,  y = 0, r = a.length, c = a[0].length;  // r = 4, c = 5
      
      while (r > 0 && c > 0) {                         
        
         for (int j = x; j < x + c - 1; j++) { // 0 + 5 - 1 < 4
            System.out.print(a[y][x] + " ");  // 1, 2, 3, 4 -> x = 3
            x++; // 4
         }
         
         for (int i = y; i < y + r - 1; i++) { // i < 0 + 4 - 1 < 3
            System.out.print(a[y][x] + " "); // 5, 10, 15
            y++;
         } // y = 3
         
         for (int j = x; j > x - c + 1; j--) { // j > 4 - 5 + 1 > 0, j = 4
            System.out.print(a[y][x] + " "); // 20, 19, 18, 17
            x--;
         } // x = 0
         
         r--;
         // 3
         for (int i = y; i > y - r + 1; i--) { // i = 3, i > 3 - 3 + 1 > 1
            System.out.print(a[y][x] + " "); // 16, 11
            y--;
         } //
         
         r--; // 2
         c--; // 4
      }
      
   }
      
}
