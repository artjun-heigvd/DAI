public class Cat extends Animal{

    Cat(String name){
        super(name);
    }

    @Override
    protected String sound(){
        return "'Mreow!'";
    }
}
