package googlejam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseWords {
	
	public static String reverseInput(String input) {
		String[] aux = input.split(" ");
		StringBuffer result = new StringBuffer();
		result.append(aux[aux.length-1]);
		for (int i = aux.length-2; i >= 0; i--) {
			result.append(" ");
			result.append(aux[i]);
		}
		
		return result.toString();		
	}
	
	public static void execute(String inputPath, String outputPath) {

		int N;
		String L;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputPath));
			PrintWriter writer = new PrintWriter(outputPath, "UTF-8");
			N = Integer.parseInt(reader.readLine()); // Number of cases
			
			for (int i = 1; i <= N; i++) { // for each case
				L = reader.readLine();	
				writer.println("Case #"+ i +": " + reverseInput(L));			
			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		execute("input/ReverseWords-B-small-practice.in", "output/ReverseWords-B-small-practice.out");
		execute("input/ReverseWords-B-large-practice.in", "output/ReverseWords-B-large-practice.out");
		
	}

}
