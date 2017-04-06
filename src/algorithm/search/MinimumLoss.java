package algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumLoss {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<House> arr = new ArrayList<>();        
        for (int i = 0; i < n; i++) {
        	arr.add(new House(in.nextLong(), (long) i));
        }
        
        Collections.sort(arr);  
        long mindiff = Long.MAX_VALUE; 

        for (int i = 0; i < n - 1; i++) {   
            if (arr.get(i).getIndex() < arr.get(i + 1).getIndex()) {
                if (arr.get(i).getPrice() > arr.get(i + 1).getPrice() && 
                		arr.get(i).getPrice() - arr.get(i + 1).getPrice() < mindiff) {
                	
                    mindiff = arr.get(i).getPrice() - arr.get(i + 1).getPrice();    
                }    

            } else if (arr.get(i).getIndex() > arr.get(i + 1).getIndex()) {
                if (arr.get(i + 1).getPrice() > arr.get(i).getPrice() && 
                		arr.get(i + 1).getPrice() - arr.get(i).getPrice() < mindiff) {
                    
                	mindiff = arr.get(i + 1).getPrice() - arr.get(i).getPrice();    
                }
            }
        }
        
        System.out.println(mindiff);
        
        in.close();
    }
	
	static class House implements Comparable<House> {
		private Long price;
		private Long index;
		
		House(Long price, Long index) {
			this.price = price;
			this.index = index;
		}

		public Long getPrice() {
			return price;
		}

		public void setPrice(long price) {
			this.price = price;
		}

		public Long getIndex() {
			return index;
		}

		public void setIndex(long index) {
			this.index = index;
		}

		@Override
		public int compareTo(House o) {
			
			return this.getPrice().compareTo(o.getPrice());
		}
	}
}
