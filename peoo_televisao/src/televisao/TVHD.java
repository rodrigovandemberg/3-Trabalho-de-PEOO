package televisao;

import java.util.ArrayList;
import java.util.List;

public class TVHD extends Televisao {

    private model modelo;

    public enum model {

        LED, PLASMA, HD;

    }

    public model getModelo(){

        return modelo;

    }

    public void setModelo(model modelo){

        this.modelo = modelo;

    }

    public TVHD(String id, ArrayList<Canal> canaisDisponiveis, model modelo){

        super(id, canaisDisponiveis);
        this.modelo = modelo;

    }

    @Override
    public void cadastrarCanais (List<Canal> canais){

        for(Canal canal : canais) if (canal.isHd()) this.canaisCadastrados.add(canal);
        this.canalAtual = this.canaisCadastrados.get(canaisCadastrados.size() - 1);

    }

    @Override
    public String toString(){

        return "TVHD " + modelo + "," + id + "," + canalAtual + "," + volume;

    }







}
