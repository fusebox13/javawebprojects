package java_beans;

public class State {
    private String name;
    private int population;
    private City capital=null;
    private City largestCity=null;
    
    public void setName(String n)
    {
        name=n;
    }
    public void setPopulation(int p)
    {
        population =p;
    }
    public void setCapital(City c)
    {
        capital =c ;
    }
    public void setLargestCity(City c)
    {
        largestCity =c;
    }
    public String getName()
    {
        return name;
    }
    public String getPopulation()
    {
        String s= String.format("%,d", population);
        return s;
    }
    public City getCapital()
    {
        return capital;
    }
    public City getLargestCity()
    {
        return largestCity;
    }
    

}