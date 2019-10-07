package list_excercises.service;

import java.util.ArrayList;

public class Compare {

    public double comparisson(ArrayList<String> arr1, ArrayList<String> arr2) {
        int len1 = 0;
        int len2 = 0;

        ArrayList<String> blank = new ArrayList<String>();
        blank.add("");
        if (arr1 == blank) {
            len1 = 0;
        } else if (arr2 == blank) {
            len2 = 0;
        } else {
            len1 = arr1.size();
            len2 = arr2.size();
        }
        if (len1 == 0 || len2 == 0) {
            return 0.0;
        }

        double perc;
        double trues = 0.0;
        double falses = 0.0;

        if (len1 >= len2) {
            for (int i=0; i < len2; i++) {
                if (arr1.get(i) == arr2.get(i)) {
                    trues = trues + 1.0;
                } else {
                    falses = falses + 1.0;
                }
            }
            perc = (trues * 100) / len1;
        } else {
            for (int j=0; j < len1; j++) {
                if (arr1.get(j) == arr2.get(j)) {
                    trues = trues + 1.0;
                } else {
                    falses = falses + 1.0;
                }
            }
            perc = (trues * 100) / len2;
        }
        return perc;
    }

}
