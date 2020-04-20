package televisao;

import java.util.ArrayList;

public class SmartTV extends Televisao{

    public int pol;

    public int getPol(){

        return pol;

    }

    public void setPol(int pol){

        this.pol = pol;

    }

    public SmartTV(ArrayList<Canal> canaisDisponiveis, int pol){

        super(canaisDisponiveis);
        this.pol = pol;

    }









}
