package exam04.models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoService {

    @NonNull // 생성자 매개변수로 추가가 된다.
    private MemberDao memberDao;

    /*public InfoService(MemberDao memberDAO) {
        this.memberDao = memberDAO;
    }*/

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
    //@Autowired(required = false)
    @Autowired  //required = false로 되어 있으면 setFormatter가 호출이 되지 않는다.
    public void setFormatter(@Nullable DateTimeFormatter formatter) { // Nullable : 의존성이 없으면 null값으로 주입한다.
        this.formatter = formatter;
    }

    public void print() {
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
