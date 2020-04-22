package televisao;


import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static ArrayList<Canal> canais;

    public static void main(String[] args) {

        ControleRemoto controleRemoto = new ControleRemoto();

        Televisao smart = new SmartTV("LG24", canais, 22);
        Televisao tvHD = new TVHD("PHILIPS17", canais, TVHD.model.PLASMA);

        /**smart.cadastrarCanais(canais);
        tvHD.cadastrarCanais(canais);


        try {

            controleRemoto.cadastrarTV(smart);
            controleRemoto.cadastrarTV(tvHD);

        } catch (TVCadastradaException e) {

            System.err.println(e.getMessage());

        }*/


        canaisInicio();

        Scanner sc = new Scanner(System.in);

        String aux;

        while (true){

            System.out.println("#####################");
            System.out.println("Qual o modelo da sua TV, 'SmartTV' ou 'TVHD' ? (Responda da forma que está escrito)");
            System.out.println("");

            aux = sc.nextLine();

            if (aux.equalsIgnoreCase("SmartTV")) {

                smart.cadastrarCanais(canais);

                try {

                    controleRemoto.cadastrarTV(smart);

                } catch (TVCadastradaException e) {

                    System.err.println(e.getMessage());

                }

                geral(smart, controleRemoto);

            } else if (aux.equalsIgnoreCase("TVHD")) {

                tvHD.cadastrarCanais(canais);

                try {

                    controleRemoto.cadastrarTV(tvHD);

                } catch (TVCadastradaException e) {

                    System.err.println(e.getMessage());

                }

                geral(tvHD,controleRemoto);

            }else {

                System.out.println("Essa opção foi inválida, tente novamente!");

            }

        }

    }

    public static void geral (Televisao televisao, ControleRemoto controleRemoto){

        int op = 0;

        Scanner sc = new Scanner(System.in);

        do {

            Menu.Menu();

            op = sc.nextInt();

            String i;
            String a;
            int c;

            switch (op) {

                case 1:
                    System.out.println("Deseja 'aumentar' ou 'diminuir' o volume ? (Responda da forma que está escrito)");

                    i = sc.nextLine();

                    if (i.equalsIgnoreCase("aumentar")){

                        controleRemoto.aumentarVol();
                        System.out.println("Volume = " + televisao.getVolume() + "\n");

                    } else if (i.equalsIgnoreCase("diminuir")){

                        controleRemoto.diminuirVol();
                        System.out.println("Volume = " + televisao.getVolume() + "\n");

                    }
                    break;

                case 2:
                    System.out.println("");
                    System.out.println("Escolha uma das opções abaixo para alterar o canal (Responda da forma que está escrito)");
                    System.out.println("'proximo' ou 'anterior'");

                    a = sc.nextLine();

                    if (a.equalsIgnoreCase("proximo")){

                        controleRemoto.proximoCanal();
                        System.out.println("Canal = " + televisao.getCanalAtual() + "\n");

                    } else if (a.equalsIgnoreCase("anterior")){

                        controleRemoto.canalAnterior();
                        System.out.println("Canal = " + televisao.getCanalAtual() + "\n");

                    }
                    break;

                case 3:
                    System.out.println("Qual o número do canal que você deseja sintonizar ?");

                    c = sc.nextInt();

                    controleRemoto.sintonizar(c);

                    System.out.println("Canal = " + televisao.getCanalAtual() + "\n");
                    break;

                case 4:
                    controleRemoto.informarDados(televisao);
                    break;

                case 5:
                    controleRemoto.mostrarGrade();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;

            }

        } while (op != 0);
    }

    public static void canaisInicio() {

        canais = new ArrayList<>();

        canais.add(new Canal(8, "RECORD", false));
        canais.add(new Canal(80, "RECORDHD", true));
        canais.add(new Canal(10, "GLOBO", false));
        canais.add(new Canal(100, "GLOBOHD", true));
        canais.add(new Canal(12, "SBT", false));
        canais.add(new Canal(120, "SBTHD", true));
        canais.add(new Canal(14, "BAND", false));
        canais.add(new Canal(140, "BANDHD", true));
    }



}
