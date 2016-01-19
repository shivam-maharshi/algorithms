package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortFile {

	public static void sort(String path) {
		Map<String, Void> map = new HashMap<String, Void>();
		List<String> list = new ArrayList<>();
		try {
			String line = null;
			FileReader file = new FileReader(path);
			BufferedReader br = new BufferedReader(file);
			while ((line = br.readLine()) != null) {
				String company = line.split("-")[0];
				company = company.trim();
				if (!map.containsValue(company)) {
					map.put(company, null);
				}
				list.add(line);
			}
			Collections.sort(list);
			
			File f = new File("Output.txt");
			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(String c : list) {
				bw.write(c + "\n");
			}
			bw.close();
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) {
		sort("C:/Users/Sam/Downloads/Company.txt");
	}

}
