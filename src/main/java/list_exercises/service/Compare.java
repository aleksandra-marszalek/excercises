package list_exercises.service;
import java.util.ArrayList;

public class Compare {

    public double comparisson(ArrayList<String> arr1, ArrayList<String> arr2) {

        int len1 = arr1.size();
        int len2 = arr2.size();

        if (len1 ==0 || len2 == 0) {
            return 0.0;
        }

        double perc;
        double trues = 0.0;
        double falses = 0.0;

        if (len1 >= len2) {
            for (int i=0; i < len2; i++) {
                if (arr1.get(i).equals(arr2.get(i))) {
                    trues += 1.0;
                } else {
                    falses += 1.0;
                }
            }
            perc = (trues * 100) / len1;
        } else {
            for (int j=0; j < len1; j++) {
                if (arr1.get(j).equals(arr2.get(j))) {
                    trues += 1.0;
                } else {
                    falses += 1.0;
                }
            }
            perc = (trues * 100) / len2;
        }
        return perc;
    }

}
