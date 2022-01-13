package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("kim");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("kim1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kim2");
        repository.save(member2);

        Member result = repository.findByName("kim1").get();

        assertThat(result).isEqualTo(member1);
        assertThat(result.getName()).isEqualTo("kim1");
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("kim1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("kim2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}