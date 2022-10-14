import java.util.ArrayList;
import java.util.*;

public class Main {


    public static  void main(String[] args) {



        ArrayList<Carte> CartPlayer = new ArrayList<>();
        ArrayList<Carte> CartPlayerIA = new ArrayList<>();


        Player Player = new Player();
        Management coll = new Management();
        coll.CreateCart();


        int Sint = 0 ;
        int Eint = 1 ;
        do {

            Sint++;
            Eint++;

            Scanner Smain = new Scanner(System.in);
            int SmainInt ;

            System.out.println(" 1.  Creer list following  Cartes ");
            System.out.println(" 2.  the list of following cards of a card given in parameter ");
            System.out.println(" 3.  Random Cart ");
            System.out.println(" 4.  Close ");


            SmainInt = Smain.nextInt();

            switch (SmainInt){
                case 1:
                    System.out.println(coll.CreateCart());
                    break;
                case 2:
                    Scanner SCmain = new Scanner(System.in);
                    int SCmainInt , liCart ;

                    System.out.println("list cart :");
                    SCmainInt = SCmain.nextInt();

                    System.out.println("nomber cart :");
                    liCart = SCmain.nextInt();
                    coll.creer_cartes(SCmainInt , liCart);
                    break;
                case 3 :
                    coll.RandomCard();
                    break;
                case 4:
                    Sint = Eint ;
                    break;
                case 5:
                    break;
            }


        } while(Sint != Eint);


        System.out.println("-------- Welcome To Blackjack -------");

        int  Splay = 0 ;
        int EndPlay = 1 ;
        int MonyePlayer =  Player.getMoney();

        do {

            Scanner SCmain = new Scanner(System.in);
            int SCmainInt ;
            System.out.println("how match monye do you Play : ( your monye is "+ MonyePlayer + ")" );
            SCmainInt = SCmain.nextInt();

            if (SCmainInt > Player.getMoney()){
                System.out.println("don't have monye");
            }else {

                MonyePlayer = Player.getMoney() - SCmainInt;
                Player.setMoney(MonyePlayer);
                System.out.println(Player.getMoney());

                System.out.println("-------------------------------------------------------------");
                System.out.println("***********************   star Game   ***********************");
                System.out.println("-------------------------------------------------------------");

                CartPlayer.add(coll.getRandomCard());
                CartPlayer.add(coll.getRandomCard());
                CartPlayerIA.add(coll.getRandomCard());
                CartPlayerIA.add(coll.getRandomCard());

                int sum = 0;
                int SumPlayer = 0 ;
                System.out.println("****************************************");
                for (int i = 0 ; i <= CartPlayer.size() - 1 ; i++){
                    System.out.println(CartPlayer.get(i));

                    if(CartPlayer.get(i).ValueCart > 10){
                        sum += 10 ;
                    }else { sum += CartPlayer.get(i).ValueCart;}
                }

                System.out.println("Totale value = " + sum);
                System.out.println("****************************************");

                System.out.println("Cart Bank :" + CartPlayerIA.get(0));

                Scanner MainPlay1 = new Scanner(System.in);
                int MainPlay ;

                System.out.println(" Entre 1 To Hit    .");
                System.out.println(" Entre 2 To Stand  .");
                MainPlay = MainPlay1.nextInt();


                switch (MainPlay){

                    case 1:

                        SumPlayer = 0 ;
                        sum = 0 ;
                        CartPlayer.add(coll.getRandomCard());
                        CartPlayerIA.add(coll.getRandomCard());

                        //======================================Cart Player IA ==============================================//
                        for (int i = 0 ; i < CartPlayerIA.size() - 1 ; i++){
                            if(CartPlayerIA.get(i).ValueCart > 10){
                                SumPlayer += 10 ;
                            }else {
                                SumPlayer += CartPlayerIA.get(i).ValueCart;
                            }
                        }

                        System.out.println("****************************************");
                        for (int i = 0 ; i < CartPlayer.size()  ; i++){
                            System.out.println(CartPlayer.get(i));

                            if(CartPlayer.get(i).ValueCart > 10){
                                sum += 10 ;
                            }else { sum += CartPlayer.get(i).ValueCart;}
                        }

                        System.out.println("Totale value = " + sum);
                        System.out.println("****************************************");

                        // ================================ Totale Value  Cart  AI ====================================== //
                        System.out.println("Totale value Bank = " + SumPlayer);
                        System.out.println("****************************************");


                        if (sum > 21){
                            System.out.println("Ooooopppssss your loser ");
                            break;
                        }


                        int MainPlayInt2 ;
                        System.out.println(" Entre 1 To Hit    .");
                        System.out.println(" Entre 2 To Stand  .");
                        MainPlayInt2 = MainPlay1.nextInt();


                        switch (MainPlayInt2){
                            case 1:

                                 SumPlayer = 0 ;
                                sum = 0 ;
                                CartPlayer.add(coll.getRandomCard());
                                CartPlayerIA.add(coll.getRandomCard());

                                //======================================Cart Player IA ==============================================//
                                for (int i = 0 ; i < CartPlayerIA.size() - 1 ; i++){
                                    if(CartPlayerIA.get(i).ValueCart > 10){
                                        SumPlayer += 10 ;
                                    }else {
                                        SumPlayer += CartPlayerIA.get(i).ValueCart;
                                    }
                                }
                                System.out.println("****************************************");
                                // ===========================  Player cart  =============================== //
                                for (int i = 0 ; i <= CartPlayer.size() - 1 ; i++){
                                    System.out.println(CartPlayer.get(i));

                                    if(CartPlayer.get(i).ValueCart > 10){
                                        sum += 10 ;
                                    }else { sum += CartPlayer.get(i).ValueCart;}
                                }

                                // ================================ Totale Value  Cart ====================================== //
                                System.out.println("Totale value = " + sum);
                                System.out.println("****************************************");

                                // ================================ Totale Value  Cart  AI ====================================== //
                                System.out.println("Totale value Bank = " + SumPlayer);
                                System.out.println("****************************************");

                                TestValue(sum , SumPlayer , Player.getMoney());

                                if (sum > 21){
                                    System.out.println("Ooooopppssss your loser ");
                                }
                                System.out.println("****************************************");
                                CartPlayer.removeAll(CartPlayer);
                                CartPlayerIA.removeAll(CartPlayerIA);

                                break;


                            case 2 :
                                SumPlayer = 0 ;
                                sum = 0 ;

                                //======================================Cart Player IA ==============================================//
                                for (int i = 0 ; i < CartPlayerIA.size() ; i++){
                                    if(CartPlayerIA.get(i).ValueCart > 10){
                                        SumPlayer += 10 ;
                                    }else {
                                        SumPlayer += CartPlayerIA.get(i).ValueCart;
                                    }
                                }

                                // ===========================  Player cart  =============================== //
                                for (int i = 0 ; i <= CartPlayer.size() - 1 ; i++){
                                    System.out.println(CartPlayer.get(i));

                                    if(CartPlayer.get(i).ValueCart > 10){
                                        sum += 10 ;
                                    }else { sum += CartPlayer.get(i).ValueCart;}
                                }

                                // ================================ Totale Value  Cart ====================================== //
                                System.out.println("****************************************");
                                System.out.println("Totale value = " + sum);
                                System.out.println("****************************************");
                                // ================================ Totale Value  Cart  AI ====================================== //
                                System.out.println("Totale value Bank = " + SumPlayer);
                                System.out.println("****************************************");
                                TestValue(sum , SumPlayer , Player.getMoney());

                                CartPlayer.removeAll(CartPlayer);
                                CartPlayerIA.removeAll(CartPlayerIA);

                                break;
                        }
                        break;
                    case 2:

                        SumPlayer = 0 ;

                        // ===========================  Player cart  AI =============================== //
                        for (int i = 0 ; i < CartPlayerIA.size() ; i++){

                            if(CartPlayerIA.get(i).ValueCart > 10){
                                SumPlayer += 10 ;
                            }else {
                                SumPlayer += CartPlayerIA.get(i).ValueCart;
                            }

                        }

                        // ===========================  Player cart  =============================== //
                        for (int i = 0 ; i <= CartPlayer.size() - 1 ; i++){
                            System.out.println(CartPlayer.get(i));
                        }
                        // ================================ Totale Value  Cart ====================================== //
                        System.out.println("****************************************");
                        System.out.println("Totale value = " + sum);
                        System.out.println("****************************************");
                        // ================================ Totale Value  Cart AI ====================================== //
                        System.out.println("Totale value Bank = " + SumPlayer);
                        System.out.println("****************************************");

                        TestValue(sum , SumPlayer , Player.getMoney());

                        CartPlayer.removeAll(CartPlayer);
                        CartPlayerIA.removeAll(CartPlayerIA);
                        break;
                }

            }

            Splay++;
            EndPlay++;

        } while (Splay <= EndPlay);


    }

    public static void  TestValue(int sumPlayer, int sumBank, int MonyeUser){

        Player Players = new Player();

        if( (sumPlayer > sumBank && sumPlayer < 21 ) || (sumBank > 21 )  ){
            System.out.println("****************************************");
            System.out.println("Your WIN ");
            MonyeUser = MonyeUser * 2 ;
            Players.setMoney(Players.getMoney() + MonyeUser);
            System.out.println("totla Money : "+ Players.getMoney());
            System.out.println("****************************************");
        }else if( sumPlayer > 21 || sumBank > sumPlayer){
            System.out.println("****************************************");
            System.out.println("Ooooopppssss your loser ");
            System.out.println("****************************************");
        }else if(sumPlayer == sumBank){
            System.out.println("****************************************");
            System.out.println("ta3adol ");
            Players.setMoney(Players.getMoney() + MonyeUser );
            System.out.println("****************************************");
        }

    }




}