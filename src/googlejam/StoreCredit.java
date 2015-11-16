package googlejam;

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N, I;
		
		Scanner reader = new Scanner(System.in);  
		N = reader.nextInt(); // Number of cases
		
		int C[] = new int[N];;
		StoreItem[][] P = new StoreItem[N][];
		
		for (int cases = 0; cases < N; cases++) { // for each case
			
			C[cases] = reader.nextInt(); // Credit
			I = reader.nextInt(); // Number of Items in the shop.
			P[cases] = new StoreItem[I];
			
			for (int item = 0; item < I; item++ ) {
				P[cases][item] = new StoreItem(reader.nextInt(), item+1);
			}
					
		}
		
		System.out.println("Case #1: ");
		
		for (int cases = 0; cases < N; cases++)	
			System.out.println("Case #"+ (cases+1) +": " + useCredit(C[cases], P[cases]));	
	}

}
