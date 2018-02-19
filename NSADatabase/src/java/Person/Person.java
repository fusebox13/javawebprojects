
package Person;

public class Person 
{
    String firstName="";
    String middleName="";
    String lastName="";
    String eyeColor="";
    String hairColor="";
    String weight="";
    String height="";
    Address address;
    
    Person(String firstName, String middleName, String lastName, String eyeColor, String hairColor, String weight, String height)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.weight = weight;
        this.height = height;
    }
    
    public String toString()
    {
        return firstName + " " + middleName.charAt(0) + " " + lastName;
    }
    public String validate()
    {
        String errorMessage = "";
        if (firstName.trim().length() == 0)
            errorMessage += "[First Name] ";
        if (middleName.trim().length() == 0)
            errorMessage += "[Middle Name] ";
        if (lastName.trim().length() == 0)
            errorMessage += "[Last Name] ";
        if (weight.trim().length() == 0)
            errorMessage += "[Weight] ";
        if (height.trim().length() == 0)
            errorMessage += "[Height] ";
        return errorMessage;
        
    }
    
    public String getAttribute(String name)
    {
        switch(name)
        {
            case "firstName":
                return firstName;
            case "middleName":
                return middleName;
            case "lastName":
                return lastName;
            case "eyeColor":
                return eyeColor;
            case "hairColor":
                return hairColor;
            case "weight":
                return weight;
            case "height":
                return height;
            default:
                return null;
        }
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }
    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }
    
    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }
    
    public void setWeight(String weight)
    {
        this.weight = weight;
    }
    
    public void setHeight(String height)
    {
        this.height = height;
    }
    
    public void setAddress(Address a)
    {
        this.address = a;
    }
    
    public String getEyeColor()
    {
        return eyeColor;
    }
    
    public String getHairColor()
    {
        return hairColor;
    }
    
    public String getWeight()
    {
        return weight;
    }
    
    public String getHeight()
    {
        return height;
    }
    
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        
        Person otherPerson = (Person)o;
        
        if(eyeColor.equals(otherPerson.eyeColor) && hairColor.equals(otherPerson.hairColor)
                && weight.equals(otherPerson.weight) && height.equals(otherPerson.height)
                && firstName.equals(otherPerson.firstName) && lastName.equals(otherPerson.lastName)
                && middleName.equals(otherPerson.middleName))
            return true;
        else
            return false;
    }
}

class Address
{
    String addressLine;
    String city;
    String state;
    String zipCode;
    
    Address(String addressLine, String city, String state, String zipCode)
    {
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        
        Address otherAddress = (Address)o;
        
        if(addressLine.equals(otherAddress.addressLine) && city.equals(otherAddress.city)
                && state.equals(otherAddress.state) && zipCode.equals(otherAddress.zipCode))
            return true;
        else
            return false;
        
    }
}
