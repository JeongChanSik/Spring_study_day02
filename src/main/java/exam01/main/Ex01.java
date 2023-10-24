package exam01.main;

import exam01.Great;
import exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Great g1 = ctx.getBean("great", Great.class);
        g1.hello("정찬식");

        Great g2 = ctx.getBean("great", Great.class);
        System.out.println(g1 == g2); // 싱글톤 패턴으로 관리하기 때문에 주소 값이 같다.
        g2.hello("털썩이");
        Great g3 = ctx.getBean("great", Great.class);
        g3.hello("햄버거드실?");
        ctx.close();
    }
}
