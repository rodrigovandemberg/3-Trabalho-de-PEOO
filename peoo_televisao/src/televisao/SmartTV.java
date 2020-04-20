package televisao;

import java.util.ArrayList;
import java.util.List;

public class SmartTV extends Televisao{

    public int pol;

    /**
     * Método get/set do pol
     * @return
     */

    public int getPol(){

        return pol;

    }

    public void setPol(int pol){

        this.pol = pol;

    }

    public SmartTV(String id, ArrayList<Canal> canaisDisponiveis, int pol){

        super(id, canaisDisponiveis);
        this.pol = pol;

    }

    public void cadastrarCanais(){

        cadastrarCanais(this.canaisDisponiveis);

    }

    @Override
    public void cadastrarCanais(List<Canal>canais) {
        for (Canal canal : canaisDisponiveis) {
            this.canaisCadastrados.add(canal);
        }
        this.canalAtual = this.canaisCadastrados.get(0);
    }









}
