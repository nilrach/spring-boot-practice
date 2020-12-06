package com.nilrach.trade.store.repository;

import com.nilrach.trade.store.entity.TradeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface TradeRepository extends CrudRepository<TradeEntity, CriteriaBuilder.In> {

}
