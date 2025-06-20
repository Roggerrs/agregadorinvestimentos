package tech.buildrun.agregadorinvestimentos.repository;

import tech.buildrun.agregadorinvestimentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    // Não é necessário declarar findById, pois já vem da interface JpaRepository
}