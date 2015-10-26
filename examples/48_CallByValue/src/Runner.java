import acm.program.ConsoleProgram;

public class Runner extends ConsoleProgram {
    @Override
    public void run() {
        Person person = new Person("Alexander");
        println(person.name);
        changeName(person, "Bazo");
        println(person.name);
        changePerson(person, "Alexander");
        println(person.name);
    }

    public void changeName(Person person, String name) {
        person.name = name;
    }

    public void changePerson(Person person, String name) {
        person = new Person(name);
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

}
