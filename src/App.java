import java.util.ArrayList;
import java.util.Iterator;
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



        // 3-Creare una lista ed eliminare gli elementi duplicati


        System.out.println("\nTerzo esercizio:\nCreare una lista ed eliminare gli elementi duplicati");

        //  creiamo un arraylist
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Luca", "Barolo", 45));
        persons.add(new Person("Marta", "Rossi", 30));
        persons.add(new Person("Luca", "Barolo", 45));
        persons.add(new Person("Anna", "Verdi", 21));
        persons.add(new Person("Marta", "Rossi", 30));


        System.out.println("\nArray originale con elementi duplicati:");
        for (Person person : persons) {

            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());

        }

        // creiamo un oggetto Iterator per ciclare l'arraylist e una lista di appoggio dove salveremo gli elementi unici incontriamo
         Iterator<Person> iterator = persons.iterator();
        List<Person> uniquePersons = new ArrayList<>();



        // con questo ciclo basato sull'iterator rimuoviamo dalla lista persons gli elementi duplicati 
    while (iterator.hasNext()) {
    Person person = iterator.next();

    if (uniquePersons.contains(person)) {
        iterator.remove();
    } else {
        uniquePersons.add(person);
    }
    }

    System.out.println("\nArray senza elementi duplicati:");
        for (Person person : persons) {

            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());

        }
     System.out.println(" ");





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


    

