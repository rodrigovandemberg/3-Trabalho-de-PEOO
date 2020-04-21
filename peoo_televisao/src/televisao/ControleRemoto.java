package televisao;

import java.util.ArrayList;

public class ControleRemoto {


    public ArrayList<Televisao> listaTVS = new ArrayList<>();

    public ArrayList<Televisao> getListaTVS(){

        return listaTVS;

    }

    public void setListaTVS(ArrayList<Televisao> listaTVS){

        this.listaTVS = listaTVS;

    }

    public ControleRemoto(){

        this.listaTVS = new ArrayList<>();

    }

    public void cadastrarTV(Televisao televisao) throws TVCadastradaException{

        if (this.listaTVS.contains(televisao)){

            this.listaTVS.add(televisao);

        } else {

            throw new TVCadastradaException("Essa TV já foi cadastrada", televisao);

        }

    }

    public void proximoCanal(){

        for (Televisao televisao : listaTVS){

            televisao.altCanal("proximo");

        }

    }

    public void canalAnterior(){

        for (Televisao televisao : listaTVS){

            televisao.altCanal("anterior");

        }

    }

    public void sintonizar(int canal) throws CanalInexistenteException {

        for (Televisao televisao : listaTVS){

            televisao.sintonia(canal);

        }

    }

    public void sintonizar2(Canal canal){

        this.listaTVS.forEach(televisao -> {

            try{

                televisao.sintonia(canal.getCanal());

            } catch (CanalInexistenteException e){

                System.err.println(e.getMessage());

            }

        });

    }

    public void mostrarGrade(){

        for (Televisao televisao : listaTVS){

            televisao.mostarGrade();

        }

    }

    public void informarDados(Televisao televisao){

        televisao.informarDados();

    }

    public void aumentarVol(){

        this.listaTVS.forEach(televisao -> televisao.altVolume("aumentar"));

    }

    public void diminuirVol(){

        this.listaTVS.forEach(televisao -> televisao.altVolume("diminuir"));

    }

    /**public void aumentarVol(){

        for (Televisao televisao : listaTVS){

            televisao.altVolume("aumentar");

        }

    }

    public void diminuirVol(){

        for (Televisao televisao : listaTVS){

            televisao.altVolume("diminuir");

        }

    }*/







}
