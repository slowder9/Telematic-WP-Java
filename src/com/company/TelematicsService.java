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
            for (File currentFile : file.listFiles()) {
                if (currentFile.getName().endsWith(".json")) {
                    // get the json from the file
                    String fileJson = getDataFromFile(currentFile);

                    // convert that json to a VehicleInfo object
                    ObjectMapper om = new ObjectMapper();
                    VehicleInfo vi = om.readValue(fileJson, VehicleInfo.class);


                    // what do we do with vi?
                    // put it inside of an arraylist.
                }
            }
            // when we get to this point, we should have a populated arraylist of VehicleInfos

            // we can use this list to write values to our html

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDataFromFile(File f) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(f);

        String results = "";
        // while fileScanner hasNext(),
        // add the next line from the file
        // to results

        return results;
    }

    // TODO: maybe write a "writeDataToFile method??????"

        }
