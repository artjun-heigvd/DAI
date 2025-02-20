package app;

import io.javalin.http.Context;
import java.util.concurrent.ConcurrentHashMap;

class PetsController {
    private ConcurrentHashMap<String, Pet> pets = new ConcurrentHashMap<String, Pet>();

    public PetsController() {
    }

    public void getOne(Context ctx) {
        String name = ctx.pathParam("name");
        ctx.json(pets.get(name));
    }

    public void getAll(Context ctx) {
        ctx.json(pets);
    }

    public void create(Context ctx) {
        Pet pet = ctx.bodyAsClass(Pet.class);
        pets.put(pet.firstName, pet);
        ctx.status(201);
    }

    public void delete(Context ctx) {
        String name = ctx.pathParam("name");
        pets.remove(name);
        ctx.status(204);
    }

    public void update(Context ctx) {
        String name = ctx.pathParam("name");
        UpdatePet update = ctx.bodyAsClass(UpdatePet.class);
        Pet pet = pets.get(name);
        pet.feed(update.food);
        ctx.status(200);
    }

}
