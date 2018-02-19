package java_beans;

public class Person
{
    String name;
    Dog dog;
    public Person(String name, Dog dog)
    {
        this.name=name;
        this.dog = dog;
    }
    public String getName()
    {
        return name;
    }
    
    public Dog getDog()
    {
        return dog;
    }
    
}