public class Person {
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // metodo  equals che verifica se due oggetti sono duplicati, utilizzato dal contains dell'esercizio 3 che confronta
    //  il singolo elemento del ciclo for con gli elementi presenti nella lista di appoggio

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Person person = (Person) obj;

    // ritorniamo il risultato di tutte queste verifiche di uguaglianza sugli attributi, svolte usando equals per le stringhe == per gli interi
    return this.name.equals(person.name) && this.surname.equals(person.surname) && this.age == person.age;
}

}
