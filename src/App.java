import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


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
        System.out.println("\nLista originale:");
        for (Person person : people) {

            if (person.getAge() >= 18) {
                adults.add(person);
            }

            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());

        }

        System.out.println("\nLista con le sole persone maggiorenni:");
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

        // creo un solo oggetto Scanner per l'intero programma, si chiude alla fine dell'extra 2, per evitare conflitti
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
       



        // 3-Creare una lista ed eliminare gli elementi duplicati


        System.out.println("\nTerzo esercizio:\nCreare una lista ed eliminare gli elementi duplicati");

        //  creiamo una linkedlist
        List<Person> persons = new LinkedList<>();

        persons.add(new Person("Luca", "Barolo", 45));
        persons.add(new Person("Marta", "Rossi", 30));
        persons.add(new Person("Luca", "Barolo", 45));
        persons.add(new Person("Anna", "Verdi", 21));
        persons.add(new Person("Marta", "Rossi", 30));


        System.out.println("\nLista originale con elementi duplicati:");
        for (Person person : persons) {

            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());

        }

        // creiamo un oggetto Iterator per ciclare la linkedlist e una lista di appoggio dove salveremo gli elementi unici incontriamo
         Iterator<Person> iterator = persons.iterator();
        List<Person> uniquePersons = new LinkedList<>();



        // con questo ciclo basato sull'iterator rimuoviamo dalla lista persons gli elementi duplicati 
    while (iterator.hasNext()) {
    Person person = iterator.next();

    if (uniquePersons.contains(person)) {
        iterator.remove();
    } else {
        uniquePersons.add(person);
    }
    }

    System.out.println("\nLista senza elementi duplicati:");
        for (Person person : persons) {

            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());

        }
     System.out.println(" ");



    
    //   Extra 1- Creare una Set che contenga degli oggetti di una classe creata da voi 
    // che non ammetta ripetizioni ( sovrascrivendo i metodi equals e hashcode )

         System.out.println("\nExtra, Primo esercizio:\nCreare un catalogo libri con un Set che non ammette duplicati\n");
        Set<Book> catalogo = new HashSet<>();

        // andiamo a creare 3 oggetti book, il primo e secondo uguali
        Book l1 = new Book("1978-8804668237", "Il nome della rosa", "Umberto Eco");
        Book l2 = new Book("1978-8804668237", "Il nome della rosa", "Umberto Eco");
        Book l3 = new Book("2978-8806216023", "1984", "George Orwell");

        System.out.println("l1 equals l2: " + l1.equals(l2) );
        System.out.println("hashcode l1 = hashcode l2: " + (l1.hashCode() == l2.hashCode()) + "\n");
       

        // il secondo libro non viene inserito perché uguale come hascode e attributi al primo 
        System.out.println("Aggiunto l1: " + catalogo.add(l1)); // true
        System.out.println("Aggiunto l2 (uguale a l2): " + catalogo.add(l2)); // false, non ammesso
        System.out.println("Aggiunto l3: " + catalogo.add(l3)); // true
        System.out.println("l1 e l2 sono uguali, solo l1 viene aggiunto");

        System.out.println("\nElementi nel Catalogo (Set) (" + catalogo.size() + "):");
        for (Book libro : catalogo) {
            System.out.println("Libro: " + libro.getCode() + " - " + libro.getTitle() + " - " + libro.getAuthor()  );
        }
        System.out.println(" ");


       
        // Extra 2- Creare una mappa con degli oggetti, chiedere all’utente di inserire 
        // una chiave e provare a cercare l’oggetto corrispondente nella mappa
        System.out.println("\nExtra, Secondo Esercizio:\nCreare una mappa contenente gli oggetti book e cercarli tramite chiave inserita");
        Map<String, Book> biblioteca = new HashMap<>();

        biblioteca.put("11", new Book("11", "Il nome della rosa", "Umberto Eco"));
        biblioteca.put("22", new Book("22", "Il visconte dimezzato", "Italo Calvino"));
        biblioteca.put("33", new Book("33", "Il Fu Mattia Pascal", "Luigi Pirandello"));

        
        System.out.println("\nInserisci il codice da cercare (11-22-33): ");
        String chiaveLibro = scanner.next();

        if (biblioteca.containsKey(chiaveLibro)) {
            Book trovato = biblioteca.get(chiaveLibro);
            System.out.println("\nLibro trovato: " + trovato.getCode() + " - " + trovato.getTitle() + " - " + trovato.getAuthor() + "\n");
        } else {
            System.out.println("\nNessun libro trovato con chiave '" + chiaveLibro + "'.\n");
        }

        scanner.close();










    //  Extra 4: crea una classse generica 
    System.out.println("\nExtra, Quarto esercizio:\nCrea una classe generica");
    GenericClass<String> general = new GenericClass<String>("Questà è una stringa stampata tramite classe generica");
    System.out.println(general.getInput());
    GenericClass<Integer> generic = new GenericClass<Integer>(22);
    System.out.println("Numero stampato tramite classe generica: " + generic.getInput());
    System.out.println(" ");


//  Extra 5: crea un metodo generico
    System.out.println("\nExtra, Quinto esercizio:\nCrea un metodo generico");

    GenMethodClass<String, Integer> pair1 = new GenMethodClass<String, Integer>("Hello", 3);
    System.out.println("I dati della classe con metodo generico sono: " + pair1.getData1() + "  " + pair1.getData2());

    GenMethodClass<Double, String> pair2 = new GenMethodClass<Double, String>(123.0, "MySql");
    System.out.println("I dati della classe con metodo generico sono: " + pair2.getData1() + "  " + pair2.getData2());
    
    System.out.println(" ");

    }
}


    

