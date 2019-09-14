package rhyme_Bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class rhyme_Bot {

	public static void main(String[] args) throws IOException {

		BufferedReader br = null;
		Scanner input = new Scanner(System.in);

		System.out.println(
				"RhymeBot300: Hello handsome user. I'm RhymeBot300. I will help you find rhymes for a word you give me");
		System.out.println("RhymeBot300: Enter another word or type 'stop' to quit");
		String word = "";
		while (!word.equals("stop")) {
			System.out.print("User: ");
			word = input.next();
			URL url = new URL("https://rhymebrain.com/talk?function=getRhymes&word=" + word + "&maxResults=20");
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;

			int n = 1;
			StringBuilder sb = new StringBuilder();

			while ((line = br.readLine()) != null) {
				String[] splitted = line.split(":");
				String aux = splitted[1];
				String[] finalSplit = aux.split(",");
				sb.append(finalSplit[0]);
				if (n % 3 == 0)
					sb.append(",\n");
				else if(n!=20)
					sb.append(", ");
				else if(n==20)
					sb.append(".");

				n++;
			}
			if (word.equals("stop")) {
				System.out.println("RhymeBot300: Goodbye!");
				return;
			}

			System.out.println(sb);
			System.out.println("RhymeBot300: These are the words I can think of, now go spit some fire");
			System.out.println("RhymeBot300: Enter another word or type 'stop' to quit");
		}

	}
}

