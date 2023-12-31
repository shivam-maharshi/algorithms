package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/word-ladder-ii
 * 
 * @author shivam.maharshi
 */
public class H126_WordLadderII extends TestCase {

  @Test
  public static void test() {
    // Test 1
    Set<String> s = new HashSet<>();
    s.addAll(Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log" }));
    List<List<String>> r = new ArrayList<>();
    r.add(Arrays.asList(new String[] { "hit", "hot", "lot", "log", "cog" }));
    r.add(Arrays.asList(new String[] { "hit", "hot", "dot", "dog", "cog" }));
    assertEquals(r, findLadders("hit", "cog", s));
    // Test 2
    s = new HashSet<>();
    s.addAll(Arrays.asList(new String[] {}));
    r = new ArrayList<>();
    r.add(Arrays.asList(new String[] { "hit", "hot" }));
    assertEquals(r, findLadders("hit", "hot", s));
    // Test 3
    s = new HashSet<>();
    s.addAll(Arrays.asList(new String[] { "hot", "dot", "lot", "log" }));
    r = new ArrayList<>();
    r.add(Arrays.asList(new String[] { "hit", "hot", "lot", "log", "cog" }));
    assertEquals(r, findLadders("hit", "cog", s));
    // Test 4
    s = new HashSet<>();
    s.addAll(Arrays.asList(new String[] { "kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip",
        "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob",
        "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum",
        "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out",
        "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew",
        "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map",
        "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl",
        "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob",
        "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire",
        "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy",
        "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub",
        "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie",
        "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam",
        "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye",
        "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev",
        "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop",
        "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla",
        "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let",
        "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod",
        "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew",
        "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf",
        "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax",
        "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon",
        "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat",
        "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod",
        "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur",
        "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop",
        "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low",
        "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir",
        "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot",
        "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err",
        "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab",
        "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip",
        "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig",
        "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her",
        "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai",
        "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow",
        "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob" }));
    r = findLadders("cet", "ism", s);
  }

  public static Map<String, Node> g = new HashMap<>();

  /*
   * This solution works but exceeds time limit since it is exponential. Better
   * would be to add change characters manually. That will give O(26*len*n)
   * complexity.
   */
  public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    wordList.add(beginWord);
    wordList.add(endWord);
    populateGraph(wordList);
    int md = getMinDist(g.get(beginWord), g.get(endWord));
    List<List<String>> res = new ArrayList<List<String>>();
    List<String> t = new ArrayList<>();
    t.add(beginWord);
    getPaths(beginWord, endWord, 0, md, t, res);
    return res;
  }

  public static void getPaths(String s, String d, int l, int md, List<String> t, List<List<String>> res) {
    if (l > md)
      return;
    else if (s.equals(d)) {
      res.add(new ArrayList<>(t));
      return;
    }

    Node sn = g.get(s);
    sn.isVisited = true;

    for (Node ad : sn.l) {
      if (!ad.isVisited) {
        t.add(ad.s);
        getPaths(ad.s, d, l + 1, md, t, res);
        t.remove(t.size() - 1);
      }
    }

    sn.isVisited = false;
  }

  public static int getMinDist(Node s, Node d) {
    if (s == d)
      return 0;

    int level = 1;
    Queue<Node> q = new LinkedList<>();
    Queue<Node> t = new LinkedList<>();
    q.add(s);
    s.isVisited = true;

    outer: while (!q.isEmpty()) {
      t = new LinkedList<>();
      while (!q.isEmpty()) {
        Node n = q.poll();
        for (Node ad : n.l) {
          if (!ad.isVisited) {
            t.add(ad);
            ad.isVisited = true;
            if (ad == d)
              break outer;
          }
        }
      }
      level++;
      q = t;
    }
    resetVisitedFlag();
    return level;
  }

  public static void resetVisitedFlag() {
    for (String s : g.keySet())
      g.get(s).isVisited = false;
  }

  public static void populateGraph(Set<String> wordList) {
    for (String s : wordList) {
      Node n = new Node(s);
      g.put(s, n);
    }

    for (String s : wordList)
      for (String t : wordList)
        if (isDiffByOne(s, t))
          g.get(s).l.add(g.get(t));
  }

  public static boolean isDiffByOne(String s, String t) {
    int c = 0;
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) != t.charAt(i))
        c++;
    return c == 1 ? true : false;
  }

  private static class Node {
    String s;
    List<Node> l;
    boolean isVisited;

    public Node(String s) {
      this.s = s;
      this.l = new ArrayList<>();
    }

  }

}
