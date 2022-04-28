package GumballMachine;

public class GumballMachine {
    private State state;
    private int gumballs;
    private float totalProfit;

    public GumballMachine() {
        gumballs = 2;
        this.state = new GN(this);
    }

    public void addGumballs(int count) {
        gumballs += count;
    }

    public void insertQuarter() {
        if (state.getClass().equals(NQ.class) || state.getClass().equals(GQ.class)) {
            System.out.println("Quarter already inserted");
        }
        else if (gumballs != 0) {
            state = new GQ(this);
            System.out.println("Quarter inserted!");
        }
        else {
            state = new NQ(this);
            System.out.println("Quarter inserted, but there are no gumballs in the machine...");
        }
    }

    public void removeQuarter() {
        if (state.getClass().equals(GN.class) || state.getClass().equals(NN.class)) {
            System.out.println("No quarter to remove");
        }
        else {
            System.out.println("Quarter removed.");
            if (getGumballs() == 0) { state = new NN(this); }
            else { state = new GN(this); }
        }
    }

    public void turnHandle() {
        state.handleTurn();
    }

    public void removeGumball() {
        if (gumballs == 0) { System.out.println("No gumballs to remove"); }
        else {
            gumballs -= 1;
        }
    }

    public int getGumballs() { return gumballs; }

    public void changeState(State state) { this.state = state; }

    public void increaseProfit() {
        totalProfit += .25;
        System.out.println("Total profit: $" + totalProfit);
    }

}
