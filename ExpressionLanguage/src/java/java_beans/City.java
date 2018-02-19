package java_beans;


public class City {
    private Mayor mayor;
    private int population;
    private String name;
    
    public void setMayor(Mayor m)
    {
        mayor = m;
    }
    public void setPopulation(int p)
    {
        population =p;
    }
    public void setName(String n)
    {
        name =n;
    }
    public Mayor getMayor()
    {
        return mayor;
    }
    public String getPopulation()
    {
        String s= String.format("%,d", population);
        return s;
    }
    public String getName()
    {
        return name;
    }

}