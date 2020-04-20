package televisao;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Televisao {

    /**
     * Constantes globais
     */

    public final static int VOLUME_MAXIMO = 10;
    public final static int VOLUME_MINIMO = 0;


    String id;
    int volume;
    Canal canalAtual;

    ArrayList<Canal> canaisDisponiveis = new ArrayList<>();
    ArrayList<Canal> canaisCadastrados = new ArrayList<>();


    /**
     * Método get/set do Id
     * @return
     */

    public String getId(){

        return id;

    }

    public void setId(String id){

        this.id = id;

    }

    /**
     * Método get/set do volume
     * @return
     */

    public int getVolume(){

        return volume;

    }

    public void setVolume(int volume){

        this.volume = volume;

    }

    /**
     * Método get/set do Canal
     * @return
     */

    public Canal getCanalAtual(){

        return canalAtual;

    }

    public void setCanalAtual(Canal canalAtual){

        this.canalAtual = canalAtual;

    }

    /**
     * Método get do canaisCadastrados
     * @return
     */

    public ArrayList<Canal> getCanaisCadastrados(){

        return canaisCadastrados;

    }

    public Televisao(String id, ArrayList<Canal> canaisCadastrados){

        this.volume = 5;
        this.id = id;
        this.canaisDisponiveis = canaisCadastrados;


    }

    /**
     * Método de cadastrar canais
     */

    public abstract void cadastrarCanais();

    /**
     * Mostra quais os canais que tem
     */

    public void mostrarGradeDeCanais(){

        this.canaisCadastrados.stream().sorted(Comparator.comparing(Canal::getCanal)).forEach(System.out::println);

    }

    /**
     * Mostra as informações do canal atual
     */

    public void informacoes(){

        System.out.println(canalAtual);

    }

    /**
     * Muda o volume
     * @param altVolume
     * @return
     */


    public boolean altVolume(String altVolume){

        int vol;
        vol = 0;

        if(altVolume.equalsIgnoreCase("decrementar")){

            vol = this.volume - 1;

            if (vol < VOLUME_MINIMO){

                System.out.println("O volume não pode ser igual ou menor que ZERO!");

                return false;

            }

        } else if (altVolume.equalsIgnoreCase("incrementar")){

            vol = this.volume + 1;

            if (vol > VOLUME_MAXIMO){

                System.out.println("O volume não pode ser maior que 10!");

                return false;

            }

        } else {

            System.out.println("Não foi possível realizar essa ação!");

            return false;

        }

        this.setVolume(vol);

        return true;

    }

    /**
     * Muda de canal
     * @param altCanal
     */


    public void altCanal(String altCanal){

        int i;
        i = canaisCadastrados.indexOf(canalAtual);

        if (altCanal.equalsIgnoreCase("seguinte")){

            i = i++;
            i %= canaisCadastrados.size();

        } else if (altCanal.equalsIgnoreCase("voltar")){

            i = i--;

            if (i >= 0){

                i %= canaisCadastrados.size();

            } else {

                i = canaisCadastrados.size() + i;

            }

        }

        setCanalAtual(this.canaisCadastrados.get(i));

    }

    /**
     * Verifica se o canal existe
     * @param canal
     * @return
     */


    public boolean verificarCanal(Canal canal){

        if (this.canaisCadastrados.contains(canal)){

            return false;

        }

        return true;

    }

    /**
     * Sintoniza os canais
     * @param canal1
     * @throws CanalInexistenteException
     */


    public void sintonia(int canal1) throws CanalInexistenteException{

        for(Canal canal : canaisCadastrados){

            if (canal.getCanal() == canal1) {

                if (verificarCanal(canal)){

                    canalAtual.setCanal(canal1);

                } else {

                    throw new CanalInexistenteException("O canal" + canal + "não existe!", canal1);

                }

            }

        }



    }







}
