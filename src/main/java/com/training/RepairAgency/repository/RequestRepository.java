package com.training.RepairAgency.repository;

import com.training.RepairAgency.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAll();

    Optional<List<Request>> findByCreatorAndStatusNot(String creator, String status);

    Page<Request> findByStatus(String status, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Request r SET r.status = :status WHERE r.id = :id", nativeQuery = true)
    void updateStatusById(@Param("status") String status,
                                   @Param("id") Long id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Request r SET r.status = :status, r.reason=:reason WHERE r.id = :id", nativeQuery = true)
    void updateStatusAndReasonById(@Param("status") String status,
                          @Param("id") Long id, @Param("reason") String reason);

    @Query(value = "SELECT r.* FROM service_db.request r INNER JOIN service_db.user u ON r.master_id=u.id " +
            "WHERE u.email=:email AND r.status=:status",
            nativeQuery = true)
    Page<Request> findByStatusAndEmail(@Param("email")String email,
                                                 @Param("status") String status, Pageable pageable);

    Optional<List<Request>> findByCreatorAndStatus(String creator, String status);
}
