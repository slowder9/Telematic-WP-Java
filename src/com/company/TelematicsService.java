package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TelematicsService {
    static void report(VehicleInfo vehicleInfo) {
        // Write the VehicleInfo to a file as json
        // using the VIN as the name of the file and
        // a "json" extension (e.g. "234235435.json").
        // The file will overwrite any existing files for the same VIN.

        File f = new File(vehicleInfo.getVin() + ".json"); //file is getting vin info from vehicleInfo object
        try {
            // write to a new file
            FileWriter fw = new FileWriter(f);

            // convert our vehicleInfo to json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);

            fw.write(json);
            fw.close();

            // GOAL: Build an arraylist of VehicleInfo objects
            // we'll get our vehicle info info from all the json files
            // in the current directory
            ArrayList<VehicleInfo> vehicleInfos = new ArrayList<>();

            // read from all json files
            File file = new File(".");
//            for(int i = 0; i < file.listFiles().length; i++)
            for (File currentFile : file.listFiles()) {
                if (currentFile.getName().endsWith(".json")) {
                    // get the json from the file
                    String fileJson = getDataFromFile(currentFile);

                    // convert that json to a VehicleInfo object
                    ObjectMapper om = new ObjectMapper();
                    VehicleInfo vi = om.readValue(fileJson, VehicleInfo.class);
                    vehicleInfos.add(vi);

                }
            }

                    double odometer = 0;
                    double consumption = 0;
                    double oilChange = 0;
                    double engineSize = 0;

                    for (int i = 0; i < vehicleInfos.size(); i++) {
                        odometer += vehicleInfos.get(i).getOdometer();
                        consumption += vehicleInfos.get(i).getConsumption();
                        oilChange += vehicleInfos.get(i).getLastOilChange();
                        engineSize+= vehicleInfos.get(i).getEngineSize();
                    }

            System.out.println("The total Odometer is :" + odometer);
            System.out.println("The average odometer is :" + (odometer/vehicleInfos.size()));

            System.out.println("The total consumption is :" + consumption);
            System.out.println("The average consumption is :" + (consumption/vehicleInfos.size()));

            System.out.println("The total lastOilChange is :" + oilChange);
            System.out.println("The average oil change is :" + (oilChange/vehicleInfos.size()));

            System.out.println("The total engineSizeInL is :" + engineSize);
            System.out.println("The average engine size is :" + (engineSize/vehicleInfos.size()));

            System.out.println("The average miles per gallon is:" + (consumption/odometer));

            // what do we do with vi?
            // put it inside of an arraylist.
            // when we get to this point, we should have a populated arraylist of VehicleInfos
            // we can use this list to write values to our html

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDataFromFile(File f) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(f);

        String results = "";
        String stuff = fileScanner.nextLine();
        results += stuff;


        // results to get a new value
        // results == "vin":12345,"odometer":1.2,"consumption":2.3,"lastOilChange":3.4,"engineSize":4.5

        // while fileScanner hasNext(),

        // add the next line from the file
        // to results

        return results;
    }

    // TODO: maybe write a "writeDataToFile method??????"
}
