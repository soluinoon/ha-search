package com.soluinoon.hasearch.repository;

import com.soluinoon.hasearch.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
