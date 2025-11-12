// 1) Using a switch case statement, receive input 1-7 and return corresponding day of the week
public class SwitchCase{
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        String day;
        switch(num){
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            case 7:
                day = "Sunday";
                break;
            default:
                day = "Invalid input! Please enter a number between 1 and 7.";
        }
        System.out.println(dayName);
    }
}