package com.calife.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calife.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
