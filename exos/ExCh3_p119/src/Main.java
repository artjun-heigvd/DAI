import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animal> animals = List.of(new Dog("Fido", "Waf!"), new Cat("Ascii"));

        for(Animal a : animals){
            a.speak();
        }

    }
}