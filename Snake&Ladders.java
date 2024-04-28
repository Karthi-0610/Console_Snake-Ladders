import java.util.*;
public class SnakesAndLadders {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        Random rand=new Random();
        String board[][]=new String[10][10];
        fill(board);
        int player=0;
        char play='T';
        String prev="0";
        while(play=='T' && player<100){
            int value=rand.nextInt(7);
            System.out.println("Dice rolled to:"+value);
            player+=value;
            if(player>100){
                player=player-value;
            }else if(player==100){
                System.out.println("You Won");
            }else{
                player=check(player);
            }
            print(board,""+player);
            System.out.println("Press 'T' to roll a dice");
            play=scan.nextLine().charAt(0);
        }
    }

    public static int check(int player){
        if(player==4 || player==13 || player==33 || player==42  || player==50 || player==62 || player==74){
            int ladder=player;
            if(player==4){
                ladder=25;
            }else if(player==13){
                ladder=46;
            }else if(player==33){
                ladder=49;
            }else if(player==42){
                ladder=63;
            }else if(player==50){
                ladder=69;
            }else if(player==62){
                ladder=81;
            }else if(player==74){
                ladder=92;
            }
            System.out.println("You climbed through ladder from "+player+" to "+ladder);
            player=ladder;
        }else if(player==27 || player==40 || player==43 || player==54 || player==66 || player==76 || player==89 || player==99){
            int snake=player;
            if(player==27){
                snake=5;
            }else if(player==40){
                snake=3;
            }else if(player==43){
                snake=18;
            }else if(player==54){
                snake=31;
            }else if(player==66){
                snake=45;
            }else if(player==76){
                snake=58;
            }else if(player==89){
                snake=53;
            }else if(player==99){
                snake=41;
            }
            System.out.println("You got bitten by snake from "+player+" to "+snake);
            player=snake;
        }else{
            System.out.println("You moved to "+player);
        }
        return player;
    }

    public static void fill(String board[][]){
        int val=0;
        for(int i=9;i>=0;i=i-2){
            for(int j=0;j<10;j++){
                if(((j+1)+val)==27 || ((j+1)+val)==40 || ((j+1)+val)==43 || ((j+1)+val)==54 || ((j+1)+val)==66 || ((j+1)+val)==76 || ((j+1)+val)==89 || ((j+1)+val)==99 ){
                    board[i][j]="$";
                }else if(((j+1)+val)==4 || ((j+1)+val)==13 || ((j+1)+val)==33 || ((j+1)+val)==42 || ((j+1)+val)==50 || ((j+1)+val)==62 || ((j+1)+val)==74){
                    board[i][j]="#";
                }else{
                    board[i][j]=""+((j+1)+val);
                }
            }
            val+=20;
        }

        val=0;
        for(int i=8;i>=0;i=i-2){
            for(int j=0;j<10;j++){
                if(((j+11)+val)==27 || ((j+11)+val)==40 || ((j+11)+val)==43 || ((j+11)+val)==54 || ((j+11)+val)==66 || ((j+11)+val)==76 || ((j+11)+val)==89 || ((j+11)+val)==99 ){
                    board[i][9-j]="$";
                }else if(((j+11)+val)==4 || ((j+11)+val)==13 || ((j+11)+val)==33 || ((j+11)+val)==42 || ((j+11)+val)==50 || ((j+11)+val)==62 || ((j+11)+val)==74){
                    board[i][9-j]="#";
                }else{
                    board[i][9-j]=""+((j+11)+val);
                }
            }
            val+=20;
        }
    }
    public static void print(String[][] board,String player){
        int k=0;
        int l=0;
        Boolean bool=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j].equals(player)){
                    board[i][j]="P";
                    k=i;
                    l=j;
                    bool=true;
                }
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        if(bool){
            board[k][l]=player;
        }
    }
}
