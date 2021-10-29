package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary  Qualifier의 우선순위가 높지만 간결한 @Primary를 자주 사용한다.
@Component
@MainDiscountPolicy // Qualifier를 애노테이션으로만듦
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountRate = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountRate / 100;
        } else {
            return 0;
        }
    }
}
