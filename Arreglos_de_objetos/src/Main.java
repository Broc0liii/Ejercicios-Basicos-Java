 public static void main(String[] args) {

    /*Persona[] grupo = new Persona[3];*/
    Animal[] grupoanimales = new Animal[3];

    grupoanimales[0] = new Animal();
    grupoanimales[0].edad = 10;
    grupoanimales[0].nombre = "Morita";
    grupoanimales[0].tanimal = "oviparo";

    grupoanimales[1] = new Animal();
    grupoanimales[1].nombre = "Lolita";
    grupoanimales[1].edad = 5;
    grupoanimales[1].tanimal = "omnivoro";

    grupoanimales[2] = new Animal();
    grupoanimales[2].edad = 1;
    grupoanimales[2].nombre = "Animalito";
    grupoanimales[2].tanimal = "vertebrado";

     /*grupo[0] = new Persona();
     grupo[0].nombre = "Ana";
     grupo[0].edad = 19;

     grupo[1] = new Persona();
     grupo[1].nombre = "Carlos";
     grupo[1].edad = 22;

     grupo[2] = new Persona();
     grupo[2].nombre = "Sofía";
     grupo[2].edad = 20;*/

    for (int i=0; i<3; i++){

        grupoanimales[i].MostrarAnimales();
    }


    }
