package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
class Address {
    String country;
    String city;

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
class Person {
    String name;
    String surname;
    int age;
    String[] phones;
    Address address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phones=" + Arrays.toString(phones) +
                ", address=" + address +
                '}';
    }
}
public class App 
{
    static final String JSON = """
    {
       "name": "Vsevolod",
       "surname": "Ievgiienko",
       "phones": ["3834543534", "1233543435"],
       "age": 38,
       "address": {
           "country": "UA",
           "city": "Kyiv"
       }
    }
    """;
    public static void main( String[] args )
    {
        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(JSON, Person.class);
        System.out.println(person);

        person.age = 15;
        String json = gson.toJson(person);
        System.out.println(json);
    }
}
