public abstract class Animal {
    private final String name;

    Animal(String name){
        this.name = name;
    }

    public String toString(){
     return this.getClass().getSimpleName() + " " +  name + " says " + sound();
    }

    abstract String sound();

    public void speak(){
        System.out.println(this);
    }

}
