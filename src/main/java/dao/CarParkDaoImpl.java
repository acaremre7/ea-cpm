package dao;

import model.ParkedCar;

import java.io.*;

public class CarParkDaoImpl implements CarParkDao {
    private final String TICKET_PATH = "src/main/resources/Ticket";
    private final String CARPARK_PATH = "src/main/resources/CarPark";

    public int createTicket() {
        int result = 0;
        try {
            File file = new File(TICKET_PATH);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String ticketString;
            if ((ticketString = br.readLine()) != null) {
                result = Integer.valueOf(ticketString)+1;
                writeFile(TICKET_PATH,new String[]{String.valueOf(result)});
            } else {
                result = 5000;
                writeFile(TICKET_PATH,new String[]{"5000"});
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ticket file is not found at expected location, creating a new one...");
            try {
                Boolean fileCreated = new File(TICKET_PATH).createNewFile();
                if(fileCreated){
                    //Giving one more chance
                    result = createTicket();
                }else{
                    System.err.println("Unknown error while creating a new Ticket file.");
                }
            } catch (IOException e1) {
                System.err.println("Error while creating a new Ticket file: " + e1.getMessage());
            }
        }catch (IOException e){
            System.err.println("Error while writing the Ticket file: " + e.getMessage());
        }
        return result;
    }

    public ParkedCar[] getCarPark() {
        ParkedCar[] parkedCars = new ParkedCar[10];
        try{
            File file = new File(CARPARK_PATH);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String rawLine;
            String[] parsedLine;
            int index = 0;
            while ((rawLine = br.readLine()) != null){
                if(!rawLine.isEmpty()) {
                    parsedLine = rawLine.split(",");
                    parkedCars[index] = new ParkedCar(Integer.valueOf(parsedLine[0]), parsedLine[1]);
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("CarPark file is not found at expected location, creating a new one...");
            try {
                Boolean fileCreated = new File(CARPARK_PATH).createNewFile();
                if(!fileCreated){
                    System.err.println("Unknown error while creating a new CarPark file.");
                }
                //Not giving another chance because it would return an empty array anyways.
            } catch (IOException e1) {
                System.err.println("Error while creating a new CarPark file: " + e1.getMessage());
            }
        }catch (IOException e){
            System.err.println("Error while writing the CarPark file: " + e.getMessage());
        }
        return parkedCars;
    }

    public void storeCarPark(ParkedCar[] parkedCars) {
        try {
            String[] content = new String[10];
            for(int i = 0; i<10; i++){
                content[i] = parkedCars[i]==null?null:(parkedCars[i].getTicketNumber() + "," + parkedCars[i].getLicencePlate());
            }
            writeFile(CARPARK_PATH,content);
        }catch (FileNotFoundException e) {
            System.err.println("CarPark file is not found at expected location, creating a new one...");
            try {
                Boolean fileCreated = new File(CARPARK_PATH).createNewFile();
                if(fileCreated) {
                    //Giving one more chance
                    storeCarPark(parkedCars);
                }else{
                    System.err.println("Unknown error while creating a new CarPark file.");
                }
            } catch (IOException e1) {
                System.err.println("Error while creating a new CarPark file: " + e1.getMessage());
            }
        }catch (IOException e){
            System.err.println("Error while writing the CarPark file: " + e.getMessage());
        }
    }

    private void writeFile(String fileName, String[] content) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        for(String line : content){
            writer.println(line==null?"":line);
        }
        writer.close();
    }
}
