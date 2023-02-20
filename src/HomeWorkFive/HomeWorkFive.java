package HomeWorkFive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class HomeWorkFive {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();

        accounts.add(new Account(156434, 1, 100));
        accounts.add(new Account(234788, 1, 150));
        accounts.add(new Account(344558, 2, 200));
        accounts.add(new Account(423432, 3, 250));
        accounts.add(new Account(598545, 3, 300));

        clients.add(new Client(1, "Tom", 30, accounts.subList(0, 2)));
        clients.add(new Client(2, "Max", 16, accounts.subList(2, 3)));
        clients.add(new Client(3, "Steve", 50, accounts.subList(3, 5)));

        System.out.println("Клиентов которым доступны операции с деньгами - " + clients.stream().filter(x -> x.isServed()).count());
        System.out.println("Имена:");
        clients.stream().filter(x -> x.isServed()).forEach(x -> System.out.println(x.getName()));

        List<Client> approvedClients = clients.stream().filter(x -> x.isServed()).collect(Collectors.toList());

        System.out.println("Их счета:");
        for (Client client : approvedClients) {
            System.out.println(client.getName() + " - " + client.getAccounts().toString());
        }
    }
}
