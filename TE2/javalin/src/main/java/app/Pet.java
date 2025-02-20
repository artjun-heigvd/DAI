package app;

public class Pet {
    public String firstName = "";
    private int energy = 0;

    public Pet(String firstName, int energy) {
        this.firstName = firstName;
        if(energy <= 0){
            this.energy = 0;
        }else {
            this.energy = Math.min(energy, 100);
        }
    }

    public void feed(int food){
        if(food >= 0){
           this.energy = Math.min(energy + food, 100);
        }
    }
}
