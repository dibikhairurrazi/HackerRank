package tutorial.linkedInPlacement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionariesAndMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> phoneBook = new HashMap<String, Integer>();
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            phoneBook.put(name.toLowerCase(), phone);
            // Write code here
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            System.out.println(phoneBook.get(s.toLowerCase()) != null ? s + "=" + phoneBook.get(s.toLowerCase()) : "Not found");
        }
        in.close();
	}

}
