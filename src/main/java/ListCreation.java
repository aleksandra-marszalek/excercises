import java.util.*;

public class ListCreation {

    public int getN(Scanner scan) {
        //Get N
        System.out.println("Enter number of elements in list, N:");
        int N = scan.nextInt();
        scan.nextLine();
        return N;
    }


    public LinkedList<Integer> getL(Scanner scan, int n) {
        //Get L
        LinkedList<Integer> listL = new LinkedList<>();
        System.out.println("Enter list, L:");
        for (int z = 0; z < n; z++) {
            int value = scan.nextInt();
            listL.add(value);
        }
        scan.nextLine();
        return listL;
    }


    public int getQ(Scanner scan) {
        //Get Q
        System.out.println("Enter number of queries, Q:");
        return scan.nextInt();
    }


    public void insertDelete(Scanner scan, LinkedList<Integer> listL, int q) {
        //Insert/Delete and Get Position (and Integer)
        int pos;
        int intIns;
        for (int i = 0; i < q; i++) {
            scan.nextLine();
            System.out.println("Enter Insert or Delete:");
            String insDel = scan.next();
            scan.nextLine();

            if (insDel.equals("Insert")) {
                //Insert Stuff
                System.out.println("Enter position:");
                pos = scan.nextInt();
                System.out.println("Enter integer:");
                intIns = scan.nextInt();
                listL.add(pos, intIns);
            } else if (insDel.equals("Delete")){
                //Delete Stuff
                System.out.println("Enter position:");
                pos = scan.nextInt();
                listL.remove(pos);
            } else {
                System.out.println("Incorrect Input, enter any value to continue");
                i -= 1;
            }
        }
    }


    public void outputFinalList(LinkedList<Integer> listL) {
        //Output Final List
        System.out.println("The final list is:");
        for (int j = 0; j < listL.size(); j++) {
            System.out.print(listL.get(j) + " ");
        }
        System.out.println();
    }


    public void listAmmend() {

        Scanner scan = new Scanner(System.in);
        int N = getN(scan);

        LinkedList<Integer> listL = getL(scan, N);
        int Q = getQ(scan);

        insertDelete(scan, listL, Q);

        scan.close();

        outputFinalList(listL);

    }

}
