package server.model;

import java.util.ArrayList;

public class DataServer {
    private ArrayList<Infringement> infringements;

    public DataServer(){
        infringements = new ArrayList<>();
        addDatas();
    }


    public void addDatas(){
        infringements.add(new Infringement(new Person(1007388645,"Jeisson"),"Mal estacionado"));
        infringements.add(new Infringement(new Person(1007388645,"Jeisson"),"Mal estacionado"));
        infringements.add(new Infringement(new Person(1007388646,"Manuel"),"Accidente de conducir"));
        infringements.add(new Infringement(new Person(1007388647,"Jose"),"No porte de documentos"));
        infringements.add(new Infringement(new Person(1007388648,"Antonio"),"Mal estacionado"));
        infringements.add(new Infringement(new Person(1007388649,"Josefina"),"Mal estacionado"));
        infringements.add(new Infringement(new Person(1007388650,"Juanes"),"Mal estacionado"));
        infringements.add(new Infringement(new Person(1007388651,"Maria"),"Mal estacionado"));
        infringements.add(new Infringement(new Person(1007388651,"Ana"),"Mal estacionado"));
    }

    public ArrayList<Infringement> getInfringements() {
        return infringements;
    }

    public void setInfringements(ArrayList<Infringement> infringements) {
        this.infringements = infringements;
    }
}
