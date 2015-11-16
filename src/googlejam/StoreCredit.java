package googlejam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class StoreCredit {

	static class StoreItem implements Comparable<StoreItem> {
		int price;
		int index;	// To be able to sort the list without losing the original indexes.
		
		public StoreItem(int p, int i) {
			price = p;
			index = i;
		}
		

		@Override
		public int compareTo(StoreItem o) {
			   if (this.price < o.price) return -1;
			   else if (this.price > o.price) return 1;
			   else return 0; 
		}
	}
	
	public static String useCredit(int credit, StoreItem[] items) {
		
		StoreItem[] auxItems = items;	// So items won't be modified when sorted.
		Arrays.sort(auxItems);
		
		int i = 0;
		int j = auxItems.length-1;
		
		int aux = auxItems[i].price + auxItems[j].price;
		
		while (aux != credit && i < j) {
			if (aux < credit) {
				i++;				
			} else { // aux > credit
				j--;
			}

			aux = auxItems[i].price + auxItems[j].price;
		}
		
		if (auxItems[i].index > auxItems[j].index)
			return((auxItems[j].index) + " " + (auxItems[i].index));

		return((auxItems[i].index) + " " + (auxItems[j].index));
	}
	
	public static void execute(String inputPath, String outputPath) {

		String[] aux;
		int N, C, I;
		StoreItem[] P;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputPath));
			PrintWriter writer = new PrintWriter(outputPath, "UTF-8");
			N = Integer.parseInt(reader.readLine()); // Number of cases
			
			for (int cases = 1; cases <= N; cases++) { // for each case
				
				C = Integer.parseInt(reader.readLine()); // Credit
				I = Integer.parseInt(reader.readLine()); // Number of Items in the shop.
				P = new StoreItem[I];
				
				aux = reader.readLine().split(" ");
				
				for (int j = 0; j < I; j++ ) {
					P[j] = new StoreItem(Integer.parseInt(aux[j]), j+1);
				}
				
				writer.println("Case #"+ cases +": " + useCredit(C, P));			
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

		execute("input/A-small-practice.in", "output/A-small-practice.out");
		execute("input/A-large-practice.in", "output/A-large-practice.out");
		
	}

}
