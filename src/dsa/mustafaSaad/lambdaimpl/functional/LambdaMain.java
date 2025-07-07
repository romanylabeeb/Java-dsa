package dsa.mustafaSaad.lambdaimpl.functional;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaMain {
    interface Checkable<T>{
        boolean check(T t,Predicate<T> predicate);
    }
   static class Person {
        String name;
        int age;
        double height;

        public Person(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }
    }

    void consumer() {
        Printable<String> printable = System.out::println;
        printable.print("Printable lambda");
    }

    public int supplier(){
        Retrievable<Integer> retrievable=()->77;
        return retrievable.retrieve();
    }
    public void predicate(){
        Evaluate<Integer> evaluate=v-> v<0;
        System.out.println(evaluate.isNegative(-1));
        System.out.println(evaluate.isNegative(1));
        Predicate<Integer> isEven=n->n%2==0;
        Checkable<Integer> checkable1=(v,p)-> p.test(v);
        System.out.println(String.format("Is 7 even?" ,checkable1.check(7,isEven)));
        System.out.println(String.format("Is 4 even?" ,checkable1.check(4,isEven)));

        Predicate<String> stringPredicate=s->s.startsWith("Mr.");
        Checkable<String> checkable2=(v,p)-> p.test(v);
        System.out.println(String.format("Is begins with Mr.?" ,checkable2.check("Mr. Joe Bloggs",stringPredicate)));
        System.out.println(String.format("Is begins with Mr.?" ,checkable2.check("Mrs. Joe Bloggs",stringPredicate)));


        Predicate<Person> isAdult=person->person.age>=18;
        Checkable<Person> checkable3=(person,adultPredicate)-> adultPredicate.test(person);

        System.out.println(String.format("Is Mike adult?" ,checkable3.check(new Person("Mike",19,156.5),isAdult)));
        System.out.println(String.format("Is Hany adult?" ,checkable3.check(new Person("Mike",17,156.5),isAdult)));

    }
    // Method to create the list of people
    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }
    // 6. sortAge() method
    public static void sortByName(List<Person> people) {
        Comparator<Person>byName=Comparator.comparing(Person::getName);
        people.sort(byName);
        System.out.println("Sorted by name:");
        people.forEach(person -> System.out.println(person));
    }    public static void main(String[] args) {
        List<Person> people = getPeople();

    }
}
