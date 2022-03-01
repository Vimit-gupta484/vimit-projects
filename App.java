package com.niit;

import com.niit.routes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Apps
{
    public static int  count(String file) throws IOException
    {
        FileReader fr=new FileReader("C:\\Users\\vimit\\project\\sum\\java code\\c4s7_project1-route-planner\\src\\main\\resources\\routes.csv");
        BufferedReader br=new BufferedReader(fr);
        String line="";
        int count=0;
        while((line=br.readLine())!=null)
        {
            count++;
        }
        return count;
    }

     public static routes[] readFile(String file, int count) {
        routes[] ro = new routes[count];
        String line;
        int i = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                routes r1 = new routes(temp[0].trim(),temp[1].trim(),Integer.parseInt(temp[2].trim()),temp[3].trim(),temp[4].trim());
                ro[i] = r1;
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ro;

    }

    public static routes[] showDirectFlights(routes[] ro, String sourceCity) {
        System.out.println("Source     Destination  Distance      Flight Time       ticketCost");
        int c=0;
        for (int i = 0; i <ro.length; i++) {
            if (ro[i].getSource().equals(sourceCity)) {
                c++;
                System.out.format("%-12s%-12s%-12s%-12s%-12s\n", ro[i].getSource(), ro[i].getDestination(), ro[i].getDistancekm(), ro[i].getTime(), ro[i].getTicketcost());
            } else {
                System.out.println("============================No records found ========================================");
            }
        }
           routes[] direct = new routes[c];
            int k=0;
            for(int j=0;j<ro.length;j++){
                if(ro[j].getSource().equals(sourceCity)) {
                    routes rew = new routes(ro[j].getSource(), ro[j].getDestination(), ro[j].getDistancekm(), ro[j].getTime(), ro[j].getTicketcost());
                    direct[k] = rew;
                    k++;
                }
            }

        return direct;
    }
    public static void sortDirectRoutes(routes [] direct )
    {
        int m= direct.length;
        for(int i=0;i<m;i++)
        {
            for(int j=i+1;j<m;j++)
            {
                if(direct[i].getDestination().compareToIgnoreCase(direct[j].getDestination())>0)
                {
                   routes temp=direct[i];
                    direct[i]=direct[j];
                    direct[j]=temp;
                }
            }
        }

        System.out.format("\n%-15s%-15s%-15s%-15s%-15s\n","Source","Destination","Distance","Flight Time","ticketCost");
        for(int k=0;k< m;k++){
            System.out.format("%-15s%-15s%-15s%-15s%-15s\n",direct[k].getSource(), direct[k].getDestination(), direct[k].getDistancekm(),direct[k].getTime(),direct[k].getTicketcost());
        }
    }
    public static void showAllConnections(routes[] ro, String SourceCity, String destination) {
        for (int i = 0; i < ro.length; i++) {
            if (SourceCity.equals(ro[i].getSource())) {
                if (destination.equals(ro[i].getDestination())) {
                    System.out.format("%-15s%-15s%-15s%-15s%-15s\n", ro[i].getSource(), ro[i].getDestination(), ro[i].getDistancekm(), ro[i].getTime(), ro[i].getTicketcost());
                }
            }
            if(destination.equals(ro[i].getDestination())){
                for(int j=0;j<ro.length;j++){
                    if(ro[i].getSource().equals(ro[j].getDestination())){
                        if(ro[j].getSource().equals(SourceCity)){
                            System.out.format("%-15s%-15s%-15s%-15s%-15s\n", ro[j].getSource(), ro[j].getDestination(),ro[j].getDistancekm(),ro[j].getTime(),ro[j].getTicketcost());
                            System.out.format("%-15s%-15s%-15s%-15s%-15s\n", ro[i].getSource(), ro[i].getDestination(), ro[i].getDistancekm(),ro[i].getTime(),ro[i].getTicketcost());
                        }
                    }
                }
            }
        }
    }


    public static void main( String[] args ) throws IOException
    {

        String file= ("C:\\Users\\vimit\\project\\sum\\java code\\c4s7_project1-route-planner\\src\\main\\resources\\routes.csv");
        int count = count(file);//count the no of records in file
        System.out.println("Total no of records :" + count);
        routes[] ro = readFile(file,count);
        System.out.format("%-15s%-15s%-15s%-15s%-15s\n", "source", "destination", "distancekm","time","ticketcost");
        for (routes r1 : ro) {
            System.out.format("%-15s%-15s%-15s%-15s%-15s\n", r1.getSource(),r1.getDestination(),r1.getDistancekm(),r1.getTime(),r1.getTicketcost());

        }
       System.out.println("enter Source city");
        Scanner scanner=new Scanner(System.in);
        String sourceCity=scanner.nextLine();
        routes[] direct=showDirectFlights(ro,sourceCity);
        System.out.println(direct.length);
        sortDirectRoutes(direct);
        System.out.println("Enter the DestinationCity");
        String destination=scanner.nextLine();
        showAllConnections(ro,sourceCity,destination);








    }
}