// 입력받는 숫자에 따라 다른 메뉴를 실행시켜주는 프로그램을 만들었습니다.
// 기본적으로 메인 스레드를 종료조건 문자가 들어오기전까지 계속해서 실행시키고
// 1부터 3사이의 숫자를 입력받으면 메인 스레드를 대기시키고 입력받은 숫자에 맞는
// 스레드를 join하여 실행시킵니다. 홈을 입력하면 스레드를 종료하고 다시 메인 스레드로 돌아갑니다.
// 1번 프로그램은 컨텐츠별 한국 문화콘텐츠 소비비중을 컨텐츠 명을 입력하면 상위 3개의 나라를 출력해주는 프로그램이고
// 2번 프로그램은 컨텐츠를 입력하면 컨텐츠별 가장 인기있는 3개를 출력해주는 프로그램입니다.
// 3번 프로그램은 컨텐츠에 대한 데이터를 파일입력을 통해 파일에 써주고 그 파일을 다시 읽어와 파일에 등장하는 나라의 빈도수를 출력해주는 프로그램입니다.
// 4번을 입력시에 프로그램이 종료됩니다.

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class DataSet { //추상클래스 선언
    private int[][] HallyuData;
    private String[] countryName;

    public void setName() {
    };

    public void setData() {
    };

    public abstract String getContentName(int x);
}

interface DataIndex { //데이터 인덱스 접근을 위한 인터페이스 정의 (평가항목 3번 인터페이스)
    public int Fisrt = 0;
    public int Second = 1;
    public int Third = 2;
    public int forth = 3;
    public int fifth = 4;
    public int sixth = 5;


    default void printLogo() { // 처음 프로그램이 시작되면 출력.
        System.out.println("##  Choose Contents!  ##");
    }

}
interface Menu{
    void endMenu();
}
class Menu1 implements Menu{    //메뉴가 종료됨을 알리기 위한 class(평가항목 5번 다형성)
    public void endMenu(){
        System.out.println("1번 메뉴가 종료되었습니다.");
        System.out.println();
    }
}
class Menu2 implements Menu{    //메뉴가 종료됨을 알리기 위한 class(평가항목 5번 다형성)
    public void endMenu(){
        System.out.println("2번 메뉴가 종료되었습니다.");
        System.out.println();
    }
}
class Menu3 implements Menu{   //메뉴가 종료됨을 알리기 위한 class(평가항목 5번 다형성)
    public void endMenu(){
        System.out.println("3번 메뉴가 종료되었습니다.");
        System.out.println();
    }
}

class HallyuContent extends DataSet implements DataIndex{ // 클래스 상속, 인터페이스 상속 (평가항목 2번, 5번)
    private String[][] HallyuData = new String[7][6]; // 각 컨텐츠별로 데이터를 저장해주기 위한 배열(평가항목 6번 참조타입)
    ArrayList<String> NameList = new ArrayList<String>(); // 컬렉션 프레임워크 ArrayList사용 (평가항목 7번)

    public void setName() {
        NameList.add("드라마"); // ArrayList add메소드 사용, 컨텐츠 이름 저장 (평가항목 7번)
        NameList.add("예능");
        NameList.add("영화");
        NameList.add("음악");
        NameList.add("애니메이션");
        NameList.add("웹툰");
        NameList.add("게임");
    }

    public void setData() { // 콘텐츠별 데이터를 만들어준다.
        HallyuData[0][Fisrt] = "말레이시아 : 39.5%";
        HallyuData[0][Second] ="인도네시아 : 39.2%";
        HallyuData[0][Third] = "태국 : 39.0%";
        HallyuData[0][forth] = "오징어 게임 : 21.2%";
        HallyuData[0][fifth] ="사랑의 불시착 : 2.2%";
        HallyuData[0][sixth] = "빈센조 : 1.9%";


        HallyuData[1][Fisrt] = "인도. : 37.6%";
        HallyuData[1][Second] = "UAE : 35.5%";
        HallyuData[1][Third] = "인도네시아 : 35.5%";
        HallyuData[1][forth] = "런닝맨";
        HallyuData[1][fifth] ="꽃보다 할배";
        HallyuData[1][sixth] = "프로듀스 101";

        HallyuData[2][Fisrt] = "UAE : 40.5%";
        HallyuData[2][Second] = "태국 : 37.4%";
        HallyuData[2][Third] = "인도네시아 : 39.5%";
        HallyuData[2][forth] = "기생충 : 10.3%";
        HallyuData[2][fifth] ="부산행 : 6.8%";
        HallyuData[2][sixth] = "서복 : 1.5%";

        HallyuData[3][Fisrt] = "베트남 : 38.5%";
        HallyuData[3][Second] = "UAE : 35.6%";
        HallyuData[3][Third] = "인도네시아 : 35.1%";
        HallyuData[3][forth] = "방탄소년단 : 26.7%";
        HallyuData[3][fifth] ="블랙핑크 : 10.4%";
        HallyuData[3][sixth] = "아이유 : 2.8%";

        HallyuData[4][Fisrt] = "인도. : 34.3%";
        HallyuData[4][Second] = "UAE : 32.7%";
        HallyuData[4][Third] = "베트남 : 31.9%";
        HallyuData[4][forth] = "라바 : 9.6%";
        HallyuData[4][fifth] ="뽀로로 : 9.3%";
        HallyuData[4][sixth] = "뿌까 : 8.8%";

        HallyuData[5][Fisrt] = "인도. : 35.7%";
        HallyuData[5][Second] = "인도네시아 : 33.6%";
        HallyuData[5][Third] = "UAE : 32.9%";
        HallyuData[5][forth] = "말레이시아 : 39.5%";
        HallyuData[5][fifth] ="인도네시아 : 39.2%";
        HallyuData[5][sixth] = "태국 : 39.0%";

        HallyuData[6][forth] = "배틀그라운드 : 14.5%";
        HallyuData[6][fifth] ="라그나로크 : 12.1%";
        HallyuData[6][sixth] = "크로스파이어 : 9.7%";
    }

    public String getContentName(int x) {
        return NameList.get(x); // 컬렉션 프레임워크 ArrayList의 get메소드 사용 (평가항목 7번)
    }

    public String[] getData(int x) {   //데이터 한줄을 배열로 반환
        String[] tmp = new String[6];
        tmp[0] = HallyuData[x][Fisrt];
        tmp[1] = HallyuData[x][Second];
        tmp[2] = HallyuData[x][Third];
        tmp[3] = HallyuData[x][forth];
        tmp[4] = HallyuData[x][fifth];
        tmp[5] = HallyuData[x][sixth];
        return tmp;
    }
}

class Thread1 extends Thread implements DataIndex { //스레드 생성
    HallyuContent c = new HallyuContent();
    Scanner sc = new Scanner(System.in);
    String country;
    boolean exit = true;

    public void run() {
        String[] result;
        c.printLogo();
        c.setName();
        c.setData();
        while (exit) {
            System.out.println("드라마 / 예능 / 영화 / 음악 / 애니메이션 / 웹툰");
            System.out.print("콘텐츠를 입력하세요(뒤로가려면 '홈'입력) : ");
            country = sc.next();
            System.out.println();
            switch (country) {
                case "홈":
                    exit = false;   //홈 입력될경우 루프 탈출후 스레드 종료시킴
                    break;
                case "드라마": // 입력되는 컨텐츠의 종류에 따라 저장해놨던 데이터를 불러운다.
                    System.out.println();
                    System.out.println("한국 " + c.getContentName(0) + " 소비 비중(상위 3개 국가)");
                    result = c.getData(0);
                    System.out.print("1위 : " + result[Fisrt] + " / ");
                    System.out.print("2위 : " + result[Second] + " / ");
                    System.out.println("3위 : " + result[Third] + " / ");
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "예능":
                    System.out.println();
                    System.out.println("한국 " + c.getContentName(1) + " 소비 비중(상위 3개 국가)");
                    result = c.getData(1);
                    System.out.print("1위 : " + result[Fisrt] + " / ");
                    System.out.print("2위 : " + result[Second] + " / ");
                    System.out.println("3위 : " + result[Third]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "영화":
                    System.out.println();
                    System.out.println("한국 " + c.getContentName(2) + " 소비 비중(상위 3개 국가)");
                    result = c.getData(2);
                    System.out.print("1위 : " + result[Fisrt] + " / ");
                    System.out.print("2위 : " + result[Second] + " / ");
                    System.out.println("3위 : " + result[Third]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "음악":
                    System.out.println();
                    System.out.println("한국 " + c.getContentName(3) + " 소비 비중(상위 3개 국가)");
                    result = c.getData(3);
                    System.out.print("1위 : " + result[Fisrt] + " / ");
                    System.out.print("2위 : " + result[Second] + " / ");
                    System.out.println("3위 : " + result[Third]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "애니메이션":
                    System.out.println();
                    System.out.println("한국 " + c.getContentName(4) + " 소비 비중(상위 3개 국가)");
                    result = c.getData(4);
                    System.out.print("1위 : " + result[Fisrt] + " / ");
                    System.out.print("2위 : " + result[Second] + " / ");
                    System.out.println("3위 : " + result[Third]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "웹툰":
                    System.out.println();
                    System.out.println("한국 " + c.getContentName(5) + " 소비 비중(상위 3개 국가)");
                    result = c.getData(5);
                    System.out.print("1위 : " + result[Fisrt] + " / ");
                    System.out.print("2위 : " + result[Second] + " / ");
                    System.out.println("3위 : " + result[Third]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                default:
                    System.out.println("컨텐츠를 입력해주세요.");   //콘텐츠가 아닌 다른 입력이 들어올 경우 다시 루프 진입
                    System.out.println();
            }
        }
    }

}


class Thread2 implements Runnable, DataIndex {  // 인터페이스 다중상속
    public void run() {
        HallyuContent c = new HallyuContent();
        Scanner sc = new Scanner(System.in);
        String content;
        boolean exit = true;

        String[] result;
        c.printLogo();
        c.setName();
        c.setData();
        while (exit) {
            System.out.println("드라마 / 예능 / 영화 / 음악 / 애니메이션 / 게임");
            System.out.print("컨텐츠를 입력하세요(뒤로가려면 '홈'입력) : ");
            content = sc.next();
            System.out.println();
            switch (content) {
                case "홈":
                    exit = false;
                    break;
                case "드라마":
                    System.out.println("인기 한국 " + c.getContentName(0) + "(상위 3개)");
                    result = c.getData(0);
                    System.out.print("1위 : "+ result[forth] + " / ");
                    System.out.print("2위 : " + result[fifth] + " / ");
                    System.out.println("3위 : " + result[sixth]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "예능":
                    System.out.println("인기 한국 " + c.getContentName(1) + "(상위 3개)");
                    result = c.getData(1);
                    System.out.print("1위 : "+ result[forth] + " / ");
                    System.out.print("2위 : " + result[fifth] + " / ");
                    System.out.println("3위 : " + result[sixth]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "영화":
                    System.out.println("인기 한국 " + c.getContentName(2) + "(상위 3개)");
                    result = c.getData(2);
                    System.out.print("1위 : "+ result[forth] + " / ");
                    System.out.print("2위 : " + result[fifth] + " / ");
                    System.out.println("3위 : " + result[sixth]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "음악":
                    System.out.println("인기 한국 " + c.getContentName(3) + "(상위 아티스트 3팀)");
                    result = c.getData(3);
                    System.out.print("1위 : "+ result[forth] + " / ");
                    System.out.print("2위 : " + result[fifth] + " / ");
                    System.out.println("3위 : " + result[sixth]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "애니메이션":
                    System.out.println("인기 한국 " + c.getContentName(4) + "(상위 3개)");
                    result = c.getData(4);
                    System.out.print("1위 : "+ result[forth] + " / ");
                    System.out.print("2위 : " + result[fifth] + " / ");
                    System.out.println("3위 : " + result[sixth]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                case "게임":
                    System.out.println("인기 한국 " + c.getContentName(6) + "(상위 3개)");
                    result = c.getData(6);
                    System.out.print("1위 : "+ result[forth] + " / ");
                    System.out.print("2위 : " + result[fifth] + " / ");
                    System.out.println("3위 : " + result[sixth]);
                    System.out.println("2021.12.06 00:00 집계 기준");
                    System.out.println();
                    break;
                default:
                    System.out.println("컨텐츠를 입력해주세요.");
                    System.out.println();
            }
        }

    }
}
class Thread3 implements Runnable, DataIndex{ // 인터페이스 다중 상속
    public void run() {
        HallyuContent c = new HallyuContent();
        Scanner sc = new Scanner(System.in);
        String country;
        boolean exit = true;
        String[] result;
        c.printLogo();
        c.setName();
        c.setData();
        while (exit) {
            System.out.println("말레이시아 / 인도네시아 / 태국 / 인도. / UAE / 베트남");
            System.out.print("컨텐츠를 입력하세요(뒤로가려면 '홈'입력) : ");
            country = sc.next();
            System.out.println();
            switch (country) {
                case "홈":
                    exit = false;
                    break;
                case "말레이시아":
                    try{ // 파일 입출력 사용 (평가항목 8번)
                        FileOutputStream output = new FileOutputStream("c:/out.txt"); // 파일을 새로 생성하여 파일에 데이터를 써준다.
                        for (int i=0; i<6; i ++){
                            result = c.getData(i);
                            String data = result[Fisrt] + " " + result[Second] + " " + result[Third] + "\r\n";
                            output.write(data.getBytes());
                        }
                        output.close();
                        FileReader fileReader = new FileReader("c:/out.txt"); //  생성된 txt파일에서 찾고자하는 나라의 이름이
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = "";
                        String find = country;
                        int cnt = 0;
                        while((line = bufferedReader.readLine()) != null){ // 몇번 등장하는지 세어준다.
                            if (line.contains(find)){
                                cnt ++;
                            }
                        }
                        bufferedReader.close();
                        System.out.println(cnt + "번");
                        System.out.println();
                        cnt = 0;
                        break;    
                    } catch (IOException e){    // 파일이 생성되지 않았을 경우 예외처리 (평가항목 4번)
                        System.out.println();   // 파일이 c드라이브에 생성되도록 프로그래밍을 해서 vs코드를 관리자 권한으로 실행하지 않으면
                    }                           // 파일이 생성되지않는다.
                    break;
                case "인도네시아":
                    try{
                        FileOutputStream output = new FileOutputStream("c:/out.txt");
                        for (int i=0; i<6; i ++){
                            result = c.getData(i);
                            String data = result[Fisrt] + " " + result[Second] + " " + result[Third] + "\r\n";
                            output.write(data.getBytes());
                        }
                        output.close();
                        FileReader fileReader = new FileReader("c:/out.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = "";
                        String find = country;
                        int cnt = 0;
                        while((line = bufferedReader.readLine()) != null){
                            if (line.contains(find)){
                                cnt ++;
                            }
                        }
                        bufferedReader.close();
                        System.out.println(cnt + "번");
                        System.out.println();

                        cnt = 0;
                        break;    
                    } catch (IOException e){
                        System.out.println();
                    }
                    break;
                case "태국":
                    try{
                        FileOutputStream output = new FileOutputStream("c:/out.txt");
                        for (int i=0; i<6; i ++){
                            result = c.getData(i);
                            String data = result[Fisrt] + " " + result[Second] + " " + result[Third] + "\r\n";
                            output.write(data.getBytes());
                        }
                        output.close();
                        FileReader fileReader = new FileReader("c:/out.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = "";
                        String find = country;
                        int cnt = 0;
                        while((line = bufferedReader.readLine()) != null){
                            if (line.contains(find)){
                                cnt ++;
                            }
                        }
                        bufferedReader.close();
                        System.out.println(cnt + "번");
                        System.out.println();

                        cnt = 0;
                        break;    
                    } catch (IOException e){
                        System.out.println();
                    }
                    break;
                case "인도.":
                    try{
                        FileOutputStream output = new FileOutputStream("c:/out.txt");
                        for (int i=0; i<6; i ++){
                            result = c.getData(i);
                            String data = result[Fisrt] + " " + result[Second] + " " + result[Third] + "\r\n";
                            output.write(data.getBytes());
                        }
                        output.close();
                        FileReader fileReader = new FileReader("c:/out.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = "";
                        String find = country;
                        int cnt = 0;
                        while((line = bufferedReader.readLine()) != null){
                            if (line.contains(find)){
                                cnt ++;
                            }
                        }
                        bufferedReader.close();
                        System.out.println(cnt + "번");
                        System.out.println();

                        cnt = 0;
                        break;    
                    } catch (IOException e){
                        System.out.println();
                    }
                    break;
                case "UAE":
                    try{
                        FileOutputStream output = new FileOutputStream("c:/out.txt");
                        for (int i=0; i<6; i ++){
                            result = c.getData(i);
                            String data = result[Fisrt] + " " + result[Second] + " " + result[Third] + "\r\n";
                            output.write(data.getBytes());
                        }
                        output.close();
                        FileReader fileReader = new FileReader("c:/out.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = "";
                        String find = country;
                        int cnt = 0;
                        while((line = bufferedReader.readLine()) != null){
                            if (line.contains(find)){
                                cnt ++;
                            }
                        }
                        bufferedReader.close();
                        System.out.println(cnt + "번");
                        System.out.println();

                        cnt = 0;
                        break;    
                    } catch (IOException e){
                        System.out.println();
                    }
                    break;
                case "베트남":
                    try{
                        FileOutputStream output = new FileOutputStream("c:/out.txt");
                        for (int i=0; i<6; i ++){
                            result = c.getData(i);
                            String data = result[Fisrt] + " " + result[Second] + " " + result[Third] + "\r\n";
                            output.write(data.getBytes());
                        }
                        output.close();
                        FileReader fileReader = new FileReader("c:/out.txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = "";
                        String find = country;
                        int cnt = 0;
                        while((line = bufferedReader.readLine()) != null){
                            if (line.contains(find)){
                                cnt ++;
                            }
                        }
                        bufferedReader.close();
                        System.out.println(cnt + "번");
                        System.out.println();

                        cnt = 0;
                        break;    
                    } catch (IOException e){
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("나라이름을 입력해주세요."); // 나라이름이 입력되지 않는다면 나라이름을 입력하라는 메시지 출력후 다시 루프 진입
                    System.out.println();
            }
        }

    }
}
public class main1 {
    public static void main(String[] args) throws IOException { // 입출력 예외처리
        boolean loof = true;
        while (loof) {
            Integer n = 0;
            System.out.println("1. 한국 문화콘텐츠 소비 비중 2. 한국 문화콘텐츠 소비 특성 3. 콘텐츠 소비 비중이 높은 나라의 빈도수 4. 프로그램 종료");
            System.out.println("숫자를 입력하세요(1~4) ");
            Scanner sc = new Scanner(System.in);
            try {
                n = sc.nextInt();   //정수가 아닌수가 입력될경우를 위한 예외처리 (평가항목 4번)
            } catch (InputMismatchException e) {
                System.out.println("1부터 4 사이의 숫자를 입력해주세요");
            }
            Thread th = new Thread1();
            Thread th2 = new Thread(new Thread2());
            Thread th3 = new Thread(new Thread3());
            String sw = n.toString();
            Menu menu;
            switch (sw) {
                case "1":
                    th.start();
                    try {
                        th.join(); // join을 이용하여 1번스레드가 종료될때까지 main스레드 대기 1번 스레드가 종료되면 이어서 main스레드 다시실행
                    } catch (InterruptedException e) {
                    }
                    menu=new Menu1();
                    menu.endMenu();
                    break;
                case "2":
                    th2.start();
                    try {
                        th2.join(); //2번 스레드 실행 main스레드 대기(이어지는 main스레드는 루프입니다.)
                    } catch (InterruptedException e) {
                    }
                    menu=new Menu2();
                    menu.endMenu();
                    break;
                case "3":
                    th3.start();
                    try {
                        th3.join(); //3번 스레드 실행 main스레드 대기(이어지는 main스레드는 루프입니다.)
                    } catch (InterruptedException e) {
                    }
                    menu=new Menu3();
                    menu.endMenu();
                    break;
                case "4":
                    System.out.println("프로그램이 종료됩니다.");
                    loof = false;   // 루프 탈출후 main스레드 종료
                    break;
            }
        }
    }
}