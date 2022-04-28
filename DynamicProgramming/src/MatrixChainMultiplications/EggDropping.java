package MatrixChainMultiplications;

public class EggDropping {

    public static int eggDropRec(int E, int F) {

        if(E ==0 || F == 1){
            return F;
        }
        if(E == 1){
            return F;
        }
        int min = Integer.MAX_VALUE;
        int x, res;

        // Consider all droppings from
        // 1st floor to kth floor and
        // return the minimum of these
        // values plus 1.
        for (x = 1; x <= F; x++) {
            res = Math.max(eggDropRec(E - 1, x - 1),
                    eggDropRec(E, F - x));
            min = Math.min(res, min);
        }

        return min + 1;
    }

    public static void main(String[] args) {
        int E = 2, F = 10;
        System.out.print("Minimum number of "
                + "trials in worst case with "
                + E + " eggs and " + F
                + " floors is " + eggDropRec(E, F));
    }
}

