import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class PhoneBook {

    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty");
            return;
        }
        ArrayList<Integer> phoneNums = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNums.add(phoneNum);
        phoneBook.put(name, phoneNums);
    }

    public ArrayList<Integer> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public static void printPhoheBook() {

        ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList(phoneBook.entrySet());
        list.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, ArrayList> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}

public class Printer {
    public static void main(String[] args) {

        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Ivanov", 1111);
        myPhoneBook.add("Petrov", 2222);
        myPhoneBook.add("Sidorov", 3333);
        myPhoneBook.add("Ivanov", 4141);
        myPhoneBook.add("Ivanov", 5151);
        myPhoneBook.add("Sidorov", 7777);
        myPhoneBook.add("Ahmetov", 4654);
        myPhoneBook.add("Ahmetov", 4655);
        myPhoneBook.add("Babanov", 7897);
        myPhoneBook.add("Babanov", 6464);
        myPhoneBook.add("Babanov", 1123);
        myPhoneBook.add("Babanov", 3579);

        myPhoneBook.add("",1);


        PhoneBook.printPhoheBook();

    }
}
