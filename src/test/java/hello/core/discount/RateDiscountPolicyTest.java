package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    @DisplayName("VIP는 10퍼센트가 할인되어야 한다")
    void rateDiscount() {
        // given
        Member member = new Member(1L, "모두한", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L, "맥북", 3000000);

        // when
        int discountPrice = order.getDiscountPrice();

        // then
        Assertions.assertThat(discountPrice).isEqualTo(300000);
    }
}