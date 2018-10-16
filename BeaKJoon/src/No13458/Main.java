package No13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] peopleOfRoom = br.readLine().split(" ");
		String[] supervisor_info = br.readLine().split(" ");

		int B = Integer.parseInt(supervisor_info[0]);
		int C = Integer.parseInt(supervisor_info[1]);

		long result = N;

		int[] room_info = new int[peopleOfRoom.length];
		for (int i = 0; i < peopleOfRoom.length; i++) {
			room_info[i] = Integer.parseInt(peopleOfRoom[i]);

			int temp = room_info[i];
			temp -= B;
			if (temp > 0) {
				result += temp / C;
				if (temp % C != 0)
					result++;
			}
		}
		System.out.println(result);

	}

}
