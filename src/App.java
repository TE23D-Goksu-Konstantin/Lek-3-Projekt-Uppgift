import java.io.Console;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String[] seats = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] seatsReference = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] seatsPersNr = new String[20];
        String[] seatsName = new String[20];
        String[] idList = {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
        double cost = 0;
    
        for(int i = 0; i < seatsName.length; i++)
        {
            seatsPersNr[i] = "0";
            seatsName[i] = "0";
        }

        Scanner keyB = new Scanner(System.in);
    while(true)
    {
        System.out.println("Hello person, do you wish to, \n1. Book a seat\n2. Avalible seats\n3. Beräkna slutsumman \n4. Avsluta programmet \n5. Find your seat \n6. Unbook a seat \n7. Bookings list");
        
        
        String choice1 = keyB.nextLine();
        int choice2 = Integer.parseInt(choice1);


        
        
if(choice2 == 1)
{
    
    String perNum = ID(keyB, cost);
    int perNrInt = Integer.parseInt(perNum);

        if(perNrInt <= 20070101)
        {
            cost += 299.90;
        }
        else
        {
            cost += 149.9; 
        }
    
    String name = Name(keyB);
    String seatNr = Booking(keyB, perNrInt, seats);

    boolean seatBooked = false;
    for(int i = 0; i < seats.length; i++)
    {
        if(seatNr.equals(seats[i]))
        {
            seatsPersNr[i] = perNum;
            seatsName[i] = name;
            idList[i] = perNum;
            seats[i] = "xx";
            SeatList(seats);
            System.out.println("Seat " + seatNr + " has been booked");
            seatBooked = true;
            break;
        }
    }

    if (!seatBooked) {
        System.out.println("Seat " + seatNr + " is already booked or not avalible");
    }
}
        else if(choice2 == 2)
        {
            SeatList(seats);
        }
        else if(choice2 == 3)
        {
            System.out.println(cost + "kr");
        }
        else if(choice2 == 4)
        {
            keyB.close();
            System.exit(0);
        }
        else if(choice2 == 5)
        {
            System.out.println("Please type your personnummer to find your seat");
            String bookCheck = keyB.nextLine();

            for(int i = 0; i < seats.length; i++)
            {
                if(bookCheck.equals(idList[i+1]))
                {
                    System.out.println("Your seat is, " + seatsReference[i+1]);
                }
            }
        }
        else if(choice2 == 6)
        {
            System.out.println("Please type your personnummer to unbook your seat");
            String bookCheck = keyB.nextLine();

            for(int i = 0; i < seats.length; i++)
            {
                if(bookCheck.equals(idList[i]))
                {
                    if(seatsReference[i].length() == 1)
                    {
                        seats[i] = ("0"+(i+1));
                    }
                    else
                    {
                        seats[i] = "" + (i+1);
                    }
                    System.out.println("Your seat has been unbooked");
                    int unbookInt = Integer.parseInt(idList[i]);
                    if(unbookInt <= 20070101)
                    {
                        cost -= 299.9;
                    }
                    else
                    {
                        cost -= 149.9;
                    }
                }
            }
        }
        else if(choice2 == 7)
        {
            for(int i = 0; i < seats.length; i++)
            {
                if(idList[i].compareTo(idList[i+1]) > 0)
                {
                    System.out.println("Name: "+ seatsName[i+1] + " Personnummer: " + seatsPersNr[i+1] + " Seat: " + seatsReference[i+1]);
                }
                else
                {
                    System.out.println("Name: "+ seatsName[i] + " Personnummer: " + seatsPersNr[i] + " Seat: " + seatsReference[i]);
                }
            }
        }
        else
        {
            System.out.println("Faulty input");
            continue;
        }
    }
}
    
    
    public static void SeatList(String[] seats)
    {
        System.out.println(
            
            "├"+seats[0]+"─"+seats[1]+"─ ─"+seats[2]+"─"+seats[3]+"┤\r\n" + 
        "├"+seats[4]+"─"+seats[5]+"─ ─"+seats[6]+"─"+seats[7]+"┤\r\n" + 
        "├"+seats[8]+"─"+seats[9]+"─ ─"+seats[10]+"─"+seats[11]+"┤\r\n" + //Chart for visuals
        "├"+seats[12]+"─"+seats[13]+"─ ─"+seats[14]+"─"+seats[15]+"┤\r\n" + 
        "├"+seats[16]+"─"+seats[17]+"─ ─"+seats[18]+"─"+seats[19]+"┤\r\n");
    }
    



    public static String ID(Scanner keyB, double cost)
    {
        while(true)
        {
            System.out.println("Please give me your Personnummer by this given formula (YYYYMMDD)");
            String bookPR = keyB.nextLine();
            try
            {
                if(bookPR.length() == 8)
                {
                        return bookPR;
                }
                else
                {
                    System.out.println("Personnummer not found, please try again");
                }
            }
            catch(Exception e)
            {
                System.out.println("Personnummer not found, please try again");
            }  
        }
    }


        public static String Name(Scanner keyB)
    {
        while(true)
        {
            System.out.println("Please give me your first and last name");
            String bookName = keyB.nextLine();
            try
            {
                if(bookName.length() <= 25)
                {
                    return bookName;
                }
                else
                {
                    System.out.println("Name too long, please try again");
                }
            }
            catch(Exception e)
            {
                System.out.println("Name too long, please try again");
            }  
        }
    }




        public static String Booking(Scanner keyB, int pR, String[] seats)
    {
        while(true)
        {
            System.out.println("Please choose a seat");
            SeatList(seats);
            String bookPR = keyB.nextLine();
            try
            {
                if(bookPR.length() == 2)
                {
                    pR = Integer.parseInt(bookPR);
                    return bookPR;
                }
            }
            catch(Exception e)
            {
                System.out.println("Seat not found, please try again");
            }  
        }
    }
}
