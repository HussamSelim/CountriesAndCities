import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class Testing {

	public static void main(String[] args) throws IOException {
		CountriesAndCitiesDAO obj=new CountriesAndCitiesDAO();
		
		String countryDir="E:\\iti\\Java & UML Programming\\DAY 4\\CSV_files\\Countries.csv";
		
		String cityDir="E:\\iti\\Java & UML Programming\\DAY 4\\CSV_files\\Cities.csv";
		
		List<Country> displayCountry= new ArrayList<Country>();
		
		List<City> displayCity= new ArrayList<City>();
	
		displayCountry= obj.readCountriesFromCSV(countryDir);
		displayCity = obj.readCitiesFromCSV(cityDir);	
		List<String> ListOfCountryCodes= displayCountry.stream().map(Country::getCode).collect(Collectors.toList());
		//System.out.println(ListOfCountryCodes);
		
		List<String> ListOfCities= displayCity.stream().map(City::getName).collect(Collectors.toList());
		//System.out.println(ListOfCities);
		mapping(displayCountry, displayCity);
		
		//displayCity=obj.readCitiesFromCSV(cityDir);
		
		//Get a List of countries population
//		displayCountry.stream().map(Country::getPopulation).forEach(y->System.out.println(y));
		
		//Get the average countries population
		//double average =displayCountry.stream().mapToDouble(Country::getPopulation).average().getAsDouble();
		//System.out.println(average);
		
		//Get the Maximum countries population
		//OptionalDouble max= displayCountry.stream().mapToDouble(Country::getPopulation).max();
		//Optional<Country> max= displayCountry.stream().max(Comparator.comparing(Country::getPopulation));
		//System.out.println(max);
		
		//Highest population city of each country
		//List<Optional> citiesCollected= countriesCitiesMap.
		
		//Highest population capital
	//	OptionalDouble capitalHigh= displayCity.stream().mapToDouble(City::getPopulation).max();
	//	System.out.println(capitalHigh);
	}

	public static void mapping(List<Country> country, List<City> city) {
		Map<String, List<City>> countriesCitiesMap= new HashMap<>();
		//List<String>citiesFinal= new ArrayList<>();
		
		for (Country co: country) 
		{
			List<City>citiesFinal= new ArrayList<>();
			for (City ci: city) 
			{
			
				if (ci.getCountryCode().equals(co.getCode())) 
				{
					citiesFinal.add(ci);
					
				}
				
			}
			countriesCitiesMap.put(co.getCode(),citiesFinal);
		}
		System.out.println(countriesCitiesMap.get("NZL"));
	
		
	}
	
}
