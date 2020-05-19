import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



class ClassBooking {

   // Sökväg till SQLite-databas. OBS! Ändra sökväg så att den pekar ut din databas
    public static final String DB_URL = "jdbc:sqlite://Users/ellenstray/desktop/java/fitnessdb.sqlite"; 
     // Namnet på den driver som används av java för att prata med SQLite
    public static final String Driver = "org.sqlite.JDBC"; 
 static Scanner sc = new Scanner(System.in);
 
 
     public static void main(String[] args) throws IOException {
        //Connection conn = null;
 
        // Kod för att skapa uppkoppling mot SQLite-dabatasen
        try {
           Class.forName(Driver);
           SQLiteConfig config = new SQLiteConfig(); 
           config.enforceForeignKeys(true); // Denna kodrad ser till att sätta databasen i ett läge där den ger felmeddelande ifall man bryter mot någon främmande-nyckel-regel
           conn = DriverManager.getConnection(DB_URL,config.toProperties()); 
        } catch (Exception e) {
           // Om java-progammet inte lyckas koppla upp sig mot databasen (t ex om fel sökväg eller om driver inte hittas) så kommer ett felmeddelande skrivas ut
           System.out.println(e.toString());
           System.exit(0);
        }
       
    private static boolean MainMenu = true;
    private static boolean SubMenu = true;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Course> allCourses = new ArrayList<Course>();
        allCourses.add(new Course("Yoga", "Daniel", "14:00"));
        allCourses.add(new Course("Crossfit", "Ellen", "15:00"));
        allCourses.add(new Course("Bodypump", "Någon", "16:00"));
       // TestReg(allCourses);
        while (MainMenu) {
            while (SubMenu) {
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("Hello and Welcome!");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Please select one of the options.");
                System.out.println("A: Book A Course.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("E: Display Empty Spots.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("V: View all Courses.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("D: Cancel Participation.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("F: Find courses i'm registered on");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("R: Register new course");
                System.out.println("---------------------------------------------------------------------------------------");
                String Selection = input.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookACourse(allCourses);
                        break;
                    case "E":
                        CheckIfEmpty(allCourses);
                        break;
                    case "V":
                        ViewAllCourses(allCourses);
                        break;
                    case "D":
                        DeleteMemberFromCourse(allCourses);
                        break;
                    case "F":
                        FindCourses(allCourses);
                        break;
                    case "R":
                        RegisterNewCourse(allCourses);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
                System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
            System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);
            }
        }
    }
    private static void BookACourse (ArrayList<Course> allCourses){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course number:" + GetCourses(allCourses));
        int spotNr = input.nextInt() - 1;
        System.out.println("Enter your memberId:");
        String memberID = input.next();
        allCourses.get(spotNr).setSignedUpMembers(memberID);
    }
    private static void ViewAllCourses(ArrayList<Course> allCourses){
        for(Course course : allCourses){
            System.out.println(course.toString());
        }
    }
    private static void DeleteMemberFromCourse(ArrayList<Course> allCourses){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Course number:" + GetCourses(allCourses));
        int spotNr = input.nextInt() - 1;
        System.out.println("Enter your memberId:");
        String memberID = input.next();
        String [] members = allCourses.get(spotNr).getSignedUpMembers();
        boolean found = false;
        int index = 0;
        for(int i = 0; i < members.length; i++){
            if(memberID.equals(members[i])){
                found = true;
                index = i;
            }
        }
        if(found){
            allCourses.get(spotNr).removeMember(index);
            System.out.println("Patricipation cancelled:)");
        }
        else{
            System.out.println("This member is not registered to the course to begin with");
        }
    }
    private static void CheckIfEmpty(ArrayList<Course> allCourses){
        for(Course course : allCourses){
            System.out.println("For " + course.getType() + " there is currently " + (15 - course.getCurrentNumberOfMembers()) + " empty slots");
        }
    }
    private static void RegisterNewCourse(ArrayList<Course> allCourses){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter type of course:");
        String type = input.next();
        System.out.println("Enter instructor:");
        String instructor = input.next();
        System.out.println("Enter time (e.g. 14:00):");
        String time = input.next();
        allCourses.add(new Course(type, instructor, time));
    }
    private static String GetCourses(ArrayList<Course> allCourses){
        String info = "\n";
        for(int i = 0; i < allCourses.size(); i++){
            info += (i + 1)+ ": " + allCourses.get(i).getType() + "\n";
        }
        return info;
    }
    private static String FindCourses(ArrayList<Course> allCourses){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your memberId:");
        String memberId = input.next();
        String info = "";
        System.out.println("You are registered to the following courses:");
        for(Course course : allCourses){
            String [] members = course.getSignedUpMembers();
            for(int i = 0; i < course.getCurrentNumberOfMembers(); i++)
                if(memberId.equals(members[i])){
                    System.out.println(course.getType() + " with " + course.getInstructor() + " at " + course.getTime());
                }
        }
        return info;
    }
   }
   // private static void TestReg(ArrayList<Course> allCourses){
      //*  String[] asd = new String[5];
    //    asd[0] = "asd";
     //   asd[1] = "asdasd";
     //   asd[2] = "asdasdasd";
     //   asd[3] = "asdasdasdasd";
      //  asd[4] = "asdasdasdasdasd";
      //  for(Course course : allCourses){
        //    for(int i = 0; i < 5; i++){
        //        course.setSignedUpMembers(asd[i]);
         //   }
        //    for(int i = 0; i < 5; i++){
          //      course.setSignedUpMembers(asd[i] + "i");
        //    }
          //  for(int i = 0; i < 5; i++){
          //      course.setSignedUpMembers(asd[i] + "j");
        //    }
     //   }
  //  }
//}
