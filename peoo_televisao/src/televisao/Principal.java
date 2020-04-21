package televisao;


import java.util.ArrayList;

public class Principal {

    public static ArrayList<Canal> canais;

    public static void main(String[] args) {

        canaisInicio();

        int op = 0;

        do{

            Menu.Menu();

            switch (op){

                case 1:


            }

        }









    }

    public static void canaisInicio(){

        canais = new ArrayList<>();

        canais.add(new Canal(8,"RECORD", false));
        canais.add(new Canal(80,"RECORDHD", true));
        canais.add(new Canal(10,"GLOBO", false));
        canais.add(new Canal(100,"GLOBOHD", true));
        canais.add(new Canal(12,"SBT", false));
        canais.add(new Canal(120,"SBTHD", true));
        canais.add(new Canal(14,"BAND", false));
        canais.add(new Canal(140,"BANDHD", true));

        ControleRemoto controleRemoto = new ControleRemoto();

        Televisao smartTV = new SmartTV("LG24", canais, 22);
        Televisao tvHD = new TVHD("PHILIPS17", canais, TVHD.model.PLASMA);

        smartTV.cadastrarCanais(canais);
        tvHD.cadastrarCanais(canais);


        try{

            controleRemoto.cadastrarTV(smartTV);
            controleRemoto.cadastrarTV(tvHD);

        } catch (TVCadastradaException e){

            System.err.println(e.getMessage());

        }



    }



}
