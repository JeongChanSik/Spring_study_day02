package exam05;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
    public void send(String message) {
        System.out.printf("전송 메세지 : %s%n", message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() 호출 성공~! 유후 룰루 랄라~!~!~!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy() 호출 성공!!!"); // ctx.close();를 호출해야 destroy()가 호출된다.
    }
}
