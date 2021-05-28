import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountriesAndCitiesDAO {
	public double ParseDouble(String strNumber) {
		   if (strNumber != null && strNumber.length() > 0) {
		       try {
		          return Double.parseDouble(strNumber);
		       } catch(Exception e) {
		          return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
		       }
		   }
		   else return 0;
		}
	
	public List<Country> readCountriesFromCSV(String file) throws IOException {
List<Country> countries= new LinkedList<>();

FileReader f = new FileReader(file);
BufferedReader buff= new BufferedReader(f);
String[] parts;
String line="";
Country co;
while (line!=null) {
	line=buff.readLine();
	if (line!=null) {
		parts=line.split(",");
	co= new Country(parts[0].strip(),parts[1].strip(),parts[2],ParseDouble(parts[3]),ParseDouble(parts[4]),ParseDouble(parts[5]),Integer.parseInt(parts[6]));
	countries.add(co);
	}
	
}
buff.close();
return countries;
}
	public List<City> readCitiesFromCSV(String file2) throws IOException{
		List<City> cities = new LinkedList<>();
		FileReader fi= new FileReader(file2);
		BufferedReader br= new BufferedReader(fi);
		String line2= "";
		String[] parts2;
		City ci;
		while(line2!=null) {
			line2=br.readLine();
			if (line2!=null) {
				parts2=line2.split(",");
				ci= new City(Integer.parseInt(parts2[0]),parts2[1].strip(),Integer.parseInt(parts2[2]),parts2[3].strip());
				cities.add(ci);
			}
			
		}
		br.close();
		return cities;
	}
}