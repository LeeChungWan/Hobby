package No11718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * 문제 11718번:  그대로 출력하기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		List<String> arr = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while (br.ready()) {
			str = br.readLine();
			arr.add(str);
		}
		for (int i = 0; i < arr.size(); i++)
			System.out.println(arr.get(i));
	}

}
