package app;

import io.javalin.*;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        PetsController petsController = new PetsController();

        app.get("/api/pets", petsController::getAll);
        app.get("/api/pets/{name}", petsController::getOne);
        app.post("/api/pets/", petsController::create);
        app.put("/api/pets/{name}", petsController::update);
        app.delete("/api/pets/{name}", petsController::delete);
    }
}