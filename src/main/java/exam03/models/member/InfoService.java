package exam03.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class InfoService {
    /*@Autowired
    private MemberDao memberDao;*/

    @Autowired
    private Optional<MemberDao> opt;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
    //@Autowired(required = false)
    @Autowired  //required = false로 되어 있으면 setFormatter가 호출이 되지 않는다.
    public void setFormatter(@Nullable DateTimeFormatter formatter) { // Nullable : 의존성이 없으면 null값으로 주입한다.
        System.out.println("유입?");
        System.out.println(formatter);

        this.formatter = formatter;
    }

    public void print() {
        MemberDao memberDao = opt.get();
        List<Member> members = memberDao.gets();
        members.stream().map(this::toConvert).forEach(System.out::println);
    }

    private Member toConvert(Member member) {
        if(formatter == null){
            return member;
        }

        String regDtStr = formatter.format(member.getRegDt());
        member.setRegDtStr(regDtStr);
        return member;
    }
}
