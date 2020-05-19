import java.util.Arrays;
public class Course {
    private String type;
    private String [] signedUpMembers;
    private String instructor;
    private int currentNumberOfMembers;
    private String time;
    public Course(String type, String instructor, String time) {
        this.type = type;
        this.signedUpMembers = new String[15];
        this.instructor = instructor;
        this.currentNumberOfMembers = 0;
        this.time = time;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String[] getSignedUpMembers() {
        return signedUpMembers;
    }
    public void setSignedUpMembers(String signedUpMember) {
        if(currentNumberOfMembers < 15) {
            boolean alreadySignedUp = false;
            for(String member : this.signedUpMembers){
                if(signedUpMember.equals(member)){
                    alreadySignedUp = true;
                }
            }
            if(!alreadySignedUp) {
                this.signedUpMembers[getCurrentNumberOfMembers()] = signedUpMember;
                this.currentNumberOfMembers += 1;
                System.out.println("You have been registered to " + this.getType() + " at " + this.getTime());
            }
            else{
                System.out.println("You are already signed up to this");
            }
        }
        else{
            System.out.println("The course is full");
        }
    }
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public int getCurrentNumberOfMembers() {
        return currentNumberOfMembers;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void removeMember(int index){
        this.currentNumberOfMembers -= 1;
        this.signedUpMembers[index] = this.signedUpMembers[getCurrentNumberOfMembers()];
        this.signedUpMembers[getCurrentNumberOfMembers()] = null;
    }
    @Override
    public String toString() {
        String info = "Course: " + type + ", taught at " + getTime() + "\n" + "Instructor: " + getInstructor() + "\nSigned up members (" + getCurrentNumberOfMembers() + "/" + signedUpMembers.length + ")\n";
        for(int i = 0; i < 15; i++){
            if(signedUpMembers[i] != null){
                info += signedUpMembers[i] + "\n";
            }
        }
        return info;
    }
}