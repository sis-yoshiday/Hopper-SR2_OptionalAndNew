package com.example;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by yukiyoshida on 2016/08/03.
 */
@Repository
public interface TestDataRepository extends JpaRepository<TestData, Integer> {

    @Query("select d " +
            "from TestData d where d.id = ?1")
    Optional<TestData> findOptionalById(Integer id);

    @Query("select new com.example.TestDataSummary(d.id, d.col1) " +
            "from TestData d where d.id = ?1")
    TestDataSummary findNewById(Integer id);

    @Query("select new com.example.TestDataSummary(d.id, d.col1) " +
            "from TestData d where d.id = ?1")
    Optional<TestDataSummary> findOptionalAndNewById(Integer id);
}
