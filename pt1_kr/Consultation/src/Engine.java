import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class Engine {
    private ArrayList<Country> countries;
    private String fileName;
    
    
    public Engine (String fileName) {
        this.fileName = fileName;
        parseCountry(fileName);
        
    }
    
    public void parseCountry(String fileName) {
        try (Scanner sc = new Scanner(new File(fileName))) {
            countries = new ArrayList<>();
            while (sc.hasNextLine()) {
                processFileLineByLine(sc.nextLine());
            }
        }

        catch(FileNotFoundException e) {
            System.err.println("CANNOT FIND OR OPEN FILE");
        }        
    }
    
    private void processFileLineByLine(String line) {
        String[] data = line.split("\\s+"); 
        String url = data[data.length - 1];
        String workingDir = Paths.get(".").toAbsolutePath().normalize().toString();
        File imageFile = new File(workingDir + "/" + url);
        if (imageFile.exists() && !imageFile.isDirectory()) {
            StringBuilder nameOfCountry = new StringBuilder();
            for (int i = 0; i < data.length - 2; ++i) {
                nameOfCountry.append(data[i]);
                nameOfCountry.append(" ");
            }     
            nameOfCountry.append(data[data.length - 2]);
            countries.add(new Country(nameOfCountry.toString(), url));          
        }
    }
    
        
    public ArrayList<String> getCountryNames() {
        ArrayList<String> countryNames = new ArrayList<>();
        for (Country country : countries) {
            countryNames.add(country.getName());
        }
        return countryNames;
    }
    
    public Country getRandomCountry() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(countries.size());
        return countries.get(index);    
    }
    
//    public static void main(String[] args) {
//        Engine engine = new Engine("countries.flag");
//        for (Country country : engine.getCountries()) {
//            System.out.println(country.getName() + ", " + country.getFlagUrl());
//        }
//        
//        System.out.println(engine.getRandomCountry().getFlagUrl());
//    }
}
