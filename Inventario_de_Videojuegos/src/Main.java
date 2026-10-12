public static void main (String[] args){

    Videojuego[] videojuegos = new Videojuego[4];

    videojuegos[0] = new Videojuego();
    videojuegos[0].titulo = "Roblox";
    videojuegos[0].plataforma = "Roblox Studio";
    videojuegos[0].precio = 0.00;

    videojuegos[1] = new Videojuego();
    videojuegos[1].titulo = "Fortnite";
    videojuegos[1].plataforma = "Steam";
    videojuegos[1].precio = 0.00;

    videojuegos[2] = new Videojuego();
    videojuegos[2].titulo = "Balatro";
    videojuegos[2].plataforma = "Epic Games";
    videojuegos[2].precio = 499.00;

    videojuegos[3] = new Videojuego();
    videojuegos[3].titulo = "Slime Rancher";
    videojuegos[3].plataforma = "Steam";
    videojuegos[3].precio = 60.50;

    for (int i=0; i<4; i++){
        videojuegos[i].MostrarVideojuegos();
    }
}