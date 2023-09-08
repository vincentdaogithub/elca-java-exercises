/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure.datasource;

import com.vincentdao.pimtoolback.infrastructure.custom.annotation.component.DataSource;
import com.vincentdao.pimtoolback.infrastructure.datasource.mapper.ProjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;

@DataSource
public interface ProjectDs extends JpaRepository<ProjectMapper, Long> {
}