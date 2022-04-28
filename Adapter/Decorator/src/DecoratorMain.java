import Decorator.AppendDecorator;
import Decorator.PunctuationDecorator;
import Decorator.ReverseDecorator;
import StringSource.StringSource1;
import StringSource.StringSource2;

public class DecoratorMain {
    public static void main(String[] args) {
        StringSource1 ss1 = new StringSource1();
        StringSource2 ss2 = new StringSource2();
        System.out.println(ss1.next());
        System.out.println(ss2.next());

        PunctuationDecorator pd1 = new PunctuationDecorator(ss1);
        PunctuationDecorator pd2 = new PunctuationDecorator(ss2);

        System.out.println("Punctuation decorator:\n");
        System.out.println(pd1.next());
        System.out.println(pd2.next());

        AppendDecorator ad1 = new AppendDecorator(ss1, " in the dead of night");
        AppendDecorator ad2 = new AppendDecorator(ss2, " whenever he chooses");

        System.out.println("Append decorator:\n");
        System.out.println(ad1.next());
        System.out.println(ad2.next());

        ReverseDecorator rd1 = new ReverseDecorator(ss1);
        ReverseDecorator rd2 = new ReverseDecorator(ss2);

        System.out.println("Reverse decorator:\n");
        System.out.println(rd1.next());
        System.out.println(rd2.next());

        System.out.println("Append decorator inside a punctuation decorator:\n");
        PunctuationDecorator pdad1 = new PunctuationDecorator(new AppendDecorator(ss2, " when nobody was watching"));

        System.out.println(pdad1.next());

    }
}
