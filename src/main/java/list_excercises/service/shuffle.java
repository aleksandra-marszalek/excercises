package list_excercises.service;
import java.util.ArrayList;
import java.util.Random;

public class shuffle {

    public ArrayList<String> shuffleArray(ArrayList<String> arr) {
        int n = arr.size();

        if (n <= 1){
            return arr;
        }

        int shuffles = n * 10;
        int posFrom;
        String val;
        int posTo;
        Random rand = new Random();

        for (int i = 0; i < shuffles; i++) {
            posFrom = rand.nextInt(n);
            val = arr.get(posFrom);
            posTo = rand.nextInt(n);
            arr.remove(val);
            arr.add(posTo, val);
        }
        return arr;
    }
}