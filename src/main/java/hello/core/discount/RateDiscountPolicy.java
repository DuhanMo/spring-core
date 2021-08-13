<<<<<<< HEAD
package hello.core.discount;public class RateDiscountPolicy {
=======
package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }

>>>>>>> a22ef5c1593b771621aac5f3913bc74e1c32d452
}
