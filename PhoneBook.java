

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, 
// что в во входной структуре будут повторяющиеся имена с 
// разными телефонами, их необходимо считать,
// как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();
        
        // Добавляем контакты в телефонную книгу
        addContact(phoneBook, "Ivan",  "126446789");
        addContact(phoneBook, "Maria", "987654321");
        addContact(phoneBook, "Ivan",  "337391833");
        addContact(phoneBook, "Maria", "347621898");
        addContact(phoneBook, "Ivan",  "567483920");
        addContact(phoneBook, "Oleg",  "123459876");
        addContact(phoneBook, "Ivan",  "976324567");
        addContact(phoneBook, "Maria", "165378335");
        addContact(phoneBook, "Stepan","432678910");
        addContact(phoneBook, "Oleg",  "678905132");
        
        
        // Вывод телефонной книги
        printPhoneBook(phoneBook);
    }
    
    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phone) {
        if (phoneBook.containsKey(name)) {
            Set<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            Set<String> phones = new TreeSet<>(Collections.reverseOrder());
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }
    
    public static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        
        // Сортируем телефонную книгу по убыванию числа телефонов 
        
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        
        // Выводим телефонную книгу
        
        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.print(entry.getKey() + ": ");
            for (String phone : entry.getValue()) {
                System.out.print(phone + " ");
            }
            System.out.println();
        }
    }
}