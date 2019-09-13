package nl.lunatech.emile.utilities.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nl.lunatech.emile.utilities.domain.CodeValue;

@Repository
public interface CodeValueRepository extends JpaRepository<CodeValue, String>{

	@Query("select c from CodeValue c where c.code = ?1")
	CodeValue findByCode(@Param("code") String code);
	
	@Query("select c from CodeValue c")
	List<CodeValue> findAll();

	@Query("select c from CodeValue c where c.code like CONCAT('%', ?1, '%')")
	List<CodeValue> findByCodeContaining(String code);

}
