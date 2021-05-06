import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Test {
    Random random = new Random();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int  com, draw, win, lose, round;
    String temp, user;
    void com(){
        com = random.nextInt(3)+1;
    }
    void comString() {
        if(com == 1){
            temp = "가위";
            pln("Conputer: "+temp);
        }else if(com == 2 ){
            temp = "바위";
            pln("Conputer: "+temp);
        }else if(com == 3){
            temp = "보";
            pln("Conputer: "+temp);
        }
    }
    void user() {
        pln("입력해주세요: ");
        try {
            user = br.readLine();
            pln("user: "+ user);
        } catch (IOException e) {}
    }
    void round() {
        while (true) {
            p("몇판을 진행할까요 ? ");
            try {
                round = Integer.parseInt(br.readLine());
                break;
            } catch (NumberFormatException ne) {
                pln("숫자만 입력해주세요.!");
                continue;
            } catch (IOException e) {
            } // 게임진행 round
        }
    }
    void figth(){
        System.out.println("round: "+round);
        for(int i=0; i<round; i++) {
            user();
            com();
            comString();
            if(temp.equals("가위")) {
                if(user.equals("가위")) {
                    pln("draw");
                    draw++;
                }else if(user.equals("바위")) {
                    pln("win");
                    win++;
                }else if(user.equals("보")) {
                    pln("lose");
                    lose++;
                }else {
                    pln("가위,바위,보만 내주세요");
                    i--;
                }
            }
            if(temp.equals("바위")) {
                if(user.equals("가위")) {
                    pln("lose");
                    lose++;
                }else if(user.equals("바위")) {
                    pln("draw");
                    draw++;
                }else if(user.equals("보")) {
                    pln("win");
                    win++;
                }else {
                    pln("가위,바위,보만 내주세요");
                    i--;
                }
            }
            if(temp.equals("보")) {
                if(user.equals("가위")) {
                    pln("win");
                    win++;
                }else if(user.equals("바위")) {
                    pln("lose");
                    lose++;
                }else if(user.equals("보")) {
                    pln("draw");
                    draw++;
                }else {
                    pln("가위,바위,보만 내주세요");
                    i--;
                }
            }
        }
        if((draw >= lose) || (draw >= win) || (lose == win)) {
            pln("결과는 ? draw: "+ draw);
        }else if((win >lose) || (win>draw)) {
            pln("결과는 ? win: "+ win);
        }else if((lose > win) || (lose > draw)){
            pln("결과는 ? lose: "+ lose);
        }
    }
    void pln(String str){
        System.out.println(str);
    }
    void p(String str) {
        System.out.print(str);
    }
    public static void main(String[] args) {
        Test t = new Test();
        t.pln("컴퓨터 vs 나 가위바위보 게임!!!!");

        t.round();
        t.pln("===========GAME START!!==========");
        t.figth();
    }
}

