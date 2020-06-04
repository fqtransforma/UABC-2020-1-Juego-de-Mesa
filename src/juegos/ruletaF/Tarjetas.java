package juegos.ruletaF;

public class Tarjetas {

    public void seleccion(int random){

        switch (random) {
            case 0:
                SeresVivos seres1 = new SeresVivos();
                seres1.Seres();

                break;
            case 1:
                Animales animal1 = new Animales();
                animal1.Animal();
                break;
            case 2:
                Minerales mineral = new Minerales();
                mineral.Mineral();
                break;
            case 3:
                RecursosNat recurso = new RecursosNat();
                recurso.Recursos();
                break;
            case 4:
                RecursosNoRenov Nrecurso = new RecursosNoRenov();
                Nrecurso.NoRenovable();
                break;
            case 5:
                RecursosOrg Orecurso=new RecursosOrg();
                Orecurso.Organico();
                break;
            case 6:
                RecursosRenov Rrecurso=new RecursosRenov();
                Rrecurso.Renovable();
                break;
            case 7:
                SeresNoVivos seres =new SeresNoVivos();
                seres.NoVivo();
                break;
            case 8:
                Plantas planta = new Plantas();
                planta.Planta();
                break;
        }


    }
}
