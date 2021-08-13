package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl(null);
    OrderService orderService = new OrderServiceImpl(null,null);

    @Test
    void createOrder() {
        // given
        long memberId = 1L;
        Member member = new Member(memberId, "모두한", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "모니터", 10000);

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}