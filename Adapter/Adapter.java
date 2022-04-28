public class Adapter implements TableData{
    private final ContactManager manager;

    public Adapter(ContactManager manager) {
        this.manager = manager;
    }
    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return manager.getContactCount();
    }

    @Override
    public int getColumnSpacing() {
        return 0;
    }

    @Override
    public int getRowSpacing() {
        return 0;
    }

    @Override
    public char getHeaderUnderline() {
        return '-';
    }

    @Override
    public String getColumnHeader(int col) {
        if (col == 0) { return "Contacts"; }
        else if (col == 1) { return "First"; }
        else if (col == 2) { return "Last"; }
        else if (col == 3) { return "Phone"; }
        else if (col == 4) { return "Email"; }
        else { return "Invalid col"; }
    }

    @Override
    public int getColumnWidth(int col) {
        return 20;
    }

    @Override
    public Justification getColumnJustification(int col) {
        return Justification.Center;
    }

    @Override
    public String getCellValue(int row, int col) {
        if (col == 0) { return String.valueOf(row + 1) ; }
        else if (col == 1) { return manager.getContact(row).getFirstName(); }
        else if (col == 2) { return manager.getContact(row).getLastName(); }
        else if (col == 3) { return manager.getContact(row).getPhone(); }
        else if (col == 4) { return manager.getContact(row).getEmail(); }
        else { return "Invalid row/col combination"; }
    }
}
