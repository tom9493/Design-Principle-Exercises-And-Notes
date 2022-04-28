package GumballMachine;

public class GQ implements State {
    private GumballMachine gm;

    public GQ(GumballMachine gm) {
        this.gm = gm;
    }

    @Override
    public void handleTurn() {
        System.out.println("Handle turned and quarter accepted! Gumball dispensed! :)");
        gm.removeGumball();
        gm.increaseProfit();
        if (gm.getGumballs() == 0) { gm.changeState(new NN(gm)); }
        else { gm.changeState(new GN(gm)); }
    }

    @Override
    public Class getState() {
        return this.getClass();
    }
}
