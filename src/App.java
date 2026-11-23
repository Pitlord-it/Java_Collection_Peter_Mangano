import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
   /*
    * 1 - Creare una List con N oggetti della classe Person.
    *     Creare un'altra List vuota, ciclare la prima lista filtrando
    *     gli elementi in base alla maggiore età e inserire
    *     gli elementi nella seconda lista.
    */

        System.out.println("\nPrimo esercizio: \nCreare una List con N oggetti della classe Person. Creare un'altra List vuota, ciclare la prima lista filtrando gli elementi in base alla maggiore età e inserire gli elementi nella seconda lista.");
        // lista originale 
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("Giovanni", "Severin", 35));
        people.add(new Person("Marco", "Amodei", 16));
        people.add(new Person("Annamaria", "Verdi", 21));
        people.add(new Person("Giulia", "Neri", 14));
        people.add(new Person("Paolo", "Gialli", 70));

        // lista che si riempirà solo con i maggiorenni
        List<Person> adults = new ArrayList<Person>();

        // assegnazione delle persone maggiorenni all'array aduts 
        System.out.println("\nArray originale:");
        for (Person person : people) {

            if (person.getAge() >= 18) {
                adults.add(person);
            }

            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());

        }

        System.out.println("\nArray con le sole persone maggiorenni:");
        for (Person person : adults) {
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());
        }
        System.out.println(" ");



    //    2- Scrivere un programma Java per aggiornare un elemento della lista specifico in base al suo indice. Esempio, 
    //    create una lista di persone, chiedete all’utente quale persona vuole modificare, chiedete i dati e 
    //    aggiornate quell’elemento della lista

         System.out.println("\nSecondo esercizio:\nModificare un elemnento di una lista con i dati inseriti dall'utente");

        List<Person> ppl = new ArrayList<Person>(List.of(
            new Person("Amedeo", "Bianchi", 25),
            new Person("Marco", "Rossi", 56),
            new Person("Anna", "Verdi", 21)
        ));

        ppl.add(new Person("Andrea", "Verdone", 75));
         

        System.out.println("\nLista delle persone:");

        Scanner scanner = new Scanner(System.in);
        // scorriamo l'Arraylist in base all'indice. Size restituisce il numero di oggetti presenti, get restituisce il singolo elemento
        for (int i = 0; i < ppl.size(); i++) {
            Person person = ppl.get(i);
            System.out.println(i + " - " + person.getName() + " " + person.getSurname() + " "+ person.getAge());
        }

        System.out.println("\nQuale persona vuoi modificare? Inserisci l'indice:");
        int index = scanner.nextInt();
        

        if (index >= 0 && index < ppl.size()) {

            System.out.println("Inserisci il nuovo nome:");
            String name = scanner.next();

            System.out.println("Inserisci il nuovo cognome:");
            String surname = scanner.next();

            System.out.println("Inserisci la nuova età:");
            int age = scanner.nextInt();

            // modifichiamo la persona indicata 
            ppl.set(index, new Person(name, surname, age));

            System.out.println("Persona aggiornata");

        } else {
            System.out.println("Indice non valido.");
        }

        System.out.println("\nLista aggiornata:");

        for (Person person : ppl) {
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());
        }
        System.out.println(" ");
        scanner.close();
    }
}


    

