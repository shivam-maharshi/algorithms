package array;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shivam.maharshi
 */
public class UriTesting {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    String file = "C:/Users/Sam/Downloads/elwiki-20151201-all-titles-in-ns0.txt";
    List<String> urls = FileUtil.read(file);
    List<String> out = new ArrayList<>(), fail = new ArrayList<>();
    for (String url : urls)
      try {
        out.add(URLEncoder.encode(url, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
        fail.add(url);
      }
    FileUtil.write(out, file + "encoded");
    FileUtil.write(fail, file + "failed");
    System.out.println("Encoded all URLs in: " + ((System.currentTimeMillis() - start) / 1000) + " seconds.");
  }

}
