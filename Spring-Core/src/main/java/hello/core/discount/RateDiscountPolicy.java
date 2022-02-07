package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // 현재 RateDiscountPolicy와 FixDiscountPolicy에 모두 @Component가 붙어있다.
        // 이 때 스프링 빈은 어떤 것을 선택해서 가져올지 모르므로(다른 곳에서는 DiscountPolicy에만 의존하므로) 순위권을 주는 것이다.
        // 스프링 빈이 어떤 것을 가져올 지 모를 때  @Primary가 붙은 것을 우선적으로 가져온다
//@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
