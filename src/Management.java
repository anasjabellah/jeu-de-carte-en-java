import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Management {

    List<Carte> cards;
    List<Carte> listCartPlayer ;

    public Management() {
        cards=new ArrayList<>();
        listCartPlayer = new ArrayList<>();
    }


    public List<Carte> CreateCart(){
        IntStream.range(1,14).forEach(v->{
            Stream.of(Couleur.values()).forEach(c->{
                cards.add(new Carte(c,v)) ;
            });
        });
        return cards;
    }

    public  Carte getRandomCard(){
        int rIndex = new Random().nextInt(0, cards.size());
        return  cards.remove(rIndex);
    }

    public  void  creer_cartes(int LiCart , int lsCart){

        for (int i = LiCart ; i <= 13 ; i++){
            for (int j = lsCart ; j <= 4 ; j++){
                System.out.print("("+ i+","+j +")");
            }
        }
    }

    public void  RandomCard(){
        ArrayList<Carte> CartRandom = new ArrayList<>();
        for (int i = 0 ; i < cards.size() ; i++){
            int rIndex = new Random().nextInt(0, cards.size());
            CartRandom.add(cards.get(rIndex));
        }

        System.out.println(CartRandom);
    }






}
