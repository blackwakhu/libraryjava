package Miscallenous;

public class Miscallenous {
    public static void getEmptyArray(String[][] myArray, int max ){
        for(int i=0; i < myArray.length; i++){
            for (int x=0; x<=max; x++){
                myArray[i][x] = "";
            }
        }
    }
}
