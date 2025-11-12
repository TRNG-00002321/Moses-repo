public class ArrayDemo02{
    public static void main(String[] args){
        int[][] items = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 4, 5, 6},
                {42, 41, 3, 88, 66, 34}
        }

        System.out.printIn(items.length);
        for(int i = 0; i<=items.length-1; i++){
            Sytem.out.printIn(items[i]);

        }
    }
}