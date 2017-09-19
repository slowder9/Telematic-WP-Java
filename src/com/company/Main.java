package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


            Scanner in = new Scanner(System.in);

            // make a new VehicleInfo object
            VehicleInfo vh = new VehicleInfo();
            vh.setVin(12345);

            vh.setOdometer(1.2);

            vh.setConsumption(2.3);

            vh.setLastOilChange(3.4);

            vh.setEngineSize(4.5);
            // for each field in VehicleInfo, use the
            // scanner to read in values. and populate.
            // the object.

            TelematicsService.report(vh);
        }
    }

