import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class AdapterMain {

    public static void main(String[] args) throws IOException {
        ContactManager manager = new ContactManager();
        Writer writer = new PrintWriter(System.out);

        manager.addContact(new Contact("Thomas", "Hart", "801 999 9999", "Tom@email.com"));
        manager.addContact(new Contact("Maddie", "Fart", "801 999 9998", "Maddie@email.com"));
        manager.addContact(new Contact("Jack", "Tart", "801 999 9997", "Jack@email.com"));
        manager.addContact(new Contact("Sara", "Mart", "801 999 9996", "Sara@email.com"));
        manager.addContact(new Contact("Matt", "Cart", "801 999 9995", "Matt@email.com"));

        Table table = new Table(writer, new Adapter(manager));
        table.display();
        writer.flush();
    }
}
