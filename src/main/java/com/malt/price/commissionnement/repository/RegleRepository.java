package com.malt.price.commissionnement.repository;

import com.malt.price.commissionnement.pojo.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface RegleRepository extends JpaRepository<Rule, Integer> {
}
