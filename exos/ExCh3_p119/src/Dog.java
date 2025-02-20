public class Dog extends Animal{

    String bark;

    Dog(String name, String bark){
        super(name);
        this.bark = bark;
    }

    @Override
    protected String sound(){
        return "'" + bark + "'";
    }

}
