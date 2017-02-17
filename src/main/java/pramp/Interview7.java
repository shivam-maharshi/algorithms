package pramp;

class Interview7 {

  public static int get(int[] n) {
    if (n == null || n.length == 0)
      return 1;

    for (int i = 0; i < n.length; i++) {
      while (n[i] != i + 1 && n[i] <= n.length && n[i] > 0) {
        int temp = n[i]; // 1
        n[i] = n[temp - 1]; // 10
        n[temp - 1] = temp; // n[0] = 1
      }
    }

    for (int i = 0; i < n.length; i++)
      if (n[i] != i + 1)
        return i + 1;

    return n.length + 1;
  }

}
