package exam05;

public class Message2 {
    public void send(String message) {
        System.out.printf("전송 메세지 : %s%n", message);
    }

    public void init() {
        System.out.println("init 호출해따리!!");
    }

    public void close() {
        System.out.println("close 종료 ㅠㅠ");
    }
}
