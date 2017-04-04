package ua.kpi.model;

/**
 * Created by Bohdan on 28.03.2017.
 */
public class AddressValue {
    private String cityName;
    private String streetName;
    private String homeNumber;
    private int appartmentNumber;

    public AddressValue(String cityName, String streetName,
                        String homeNumber, int appartmentNumber){
        this.cityName = cityName;
        this.streetName = streetName;
        this.homeNumber = homeNumber;
        this.appartmentNumber = appartmentNumber;
    }

    public String getCityName(){
        return cityName;
    }

    public String getStreetName(){
        return streetName;
    }

    public String getHomeNumber(){
        return homeNumber;
    }

    public int getAppartmentNumber(){
        return appartmentNumber;
    }
}
