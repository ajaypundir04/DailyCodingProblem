package demo.code.leetcode;

public class Winner {

    public static void main(String[] args) {
        Winner w = new Winner();
        System.out.println(w.canWinNim(6));
    }

    public boolean canWinNim(int n) {
        return (
                winner(n-1, true) || winner(n-2, true) || winner(n-3, true)
        );
    }

    private boolean winner(int total, boolean myTurn) {
        if(total <= 0) {
            return !myTurn;
        }

        if(myTurn) {
            return winner(total - 1, false) || winner(total - 2, false) || winner(total - 3, false);
        } else {
            return winner(total - 3, true);
        }
    }
}
