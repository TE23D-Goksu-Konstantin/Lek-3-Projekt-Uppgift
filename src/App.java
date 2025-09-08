import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String[] seats = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] seatsPersNr = new String[seats.length];
        String[] seatsName = {};
        int kostnad = 0;
    
        Scanner keyB = new Scanner(System.in);
        
    while(true)
    {
        System.out.println("Hello person, do you wish to, \n1. Book a seat\n2. Avalible seats\n3. Beräkna slutsumman \n4. Avsluta programmet");
        
        
        String choice1 = keyB.nextLine();
        int choice2 = Integer.parseInt(choice1);
        
        if(choice2 == 1)
        {
            
            int perNr = ID(keyB);
                String seatNr = Booking(keyB, perNr, seats);
                for(int i = 0; i < seats.length; i++)
                {
                    if(seatNr.equals(seats[i]))
                    {
                    seatsPersNr[i] = seatNr;
                    seats[i] = "xx";
                    SeatList(seats);
                    kostnad += 299;
                }
            }
        }
        else if(choice2 == 2)
        {
            SeatList(seats);
        }
        else if(choice2 == 3)
        {
            System.out.println(kostnad + "kr");
        }
        else if(choice2 == 4)
        {
            keyB.close();
            System.exit(0);
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
    





    public static int ID(Scanner keyB)
    {
        while(true)
        {
            System.out.println("Please give me your Personnummer by this given formula (YYMMDD)");
            String bookPR = keyB.nextLine();
            try
            {
                if(bookPR.length() == 6)
                {
                    int pR = Integer.parseInt(bookPR);
                    return pR;
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
