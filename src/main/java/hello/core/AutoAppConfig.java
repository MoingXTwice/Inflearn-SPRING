package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages = "hello.core", // 탐색(@Component 를 찾는)을 시작할 위치를 지정
        // 지정하지 않으면 @ComponentScan 을 붙힌 package 부터 탐색을 시작한다. ex) AutoAppConfig 에 @ComponentScan 을 붙혔으니  package "hello.core" 부터 스캔
        // 그러므로 설정정보는 프로젝트의 최상단에 두는 것을 권장
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 스캔 대상에서 제외할 것을 선택
)
public class AutoAppConfig {
}
