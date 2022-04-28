package GumballMachine;

public class Main {

    public static void main(String[] args) {
        GumballMachine gm = new GumballMachine();

        gm.turnHandle();
        gm.removeQuarter();
        gm.insertQuarter();
        gm.insertQuarter();
        gm.removeQuarter();
        gm.removeQuarter();

        gm.insertQuarter();
        gm.turnHandle();
        gm.insertQuarter();
        gm.turnHandle();
        gm.insertQuarter();
        gm.turnHandle();

        gm.addGumballs(2);
        gm.insertQuarter();
        gm.turnHandle();
        gm.insertQuarter();
        gm.turnHandle();
        gm.insertQuarter();
        gm.turnHandle();
        gm.turnHandle();
    }
}
