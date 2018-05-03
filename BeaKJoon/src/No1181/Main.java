package No1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> dictionary = new ArrayList<>();
		while (N-- > 0) {
			String word = br.readLine();
			if (!dictionary.contains(word))
				dictionary.add(word);
		}
		Collections.sort(dictionary, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() >= o2.length())
					return 1;
				return -1;
			}
		});

		for (int i = 0; i < dictionary.size(); i++) {
			for (int j = i + 1; j < dictionary.size(); j++) {
				if (dictionary.get(i).length() == dictionary.get(j).length()) {
					char[] arr1 = dictionary.get(i).toCharArray();
					char[] arr2 = dictionary.get(j).toCharArray();
					for (int k = 0; k < arr1.length; k++) {
						if (arr1[k] > arr2[k]) {
							String temp = dictionary.get(i);
							dictionary.set(i, dictionary.get(j));
							dictionary.set(j, temp);
							break;
						} else if (arr1[k] < arr2[k]) {
							break;
						}
					}
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < dictionary.size(); i++) {
			System.out.println(dictionary.get(i));
		}
	}
}
