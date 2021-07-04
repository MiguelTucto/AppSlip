package com.appslip.Theme.infrastructure;

import com.appslip.Theme.domain.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IThemeRepository extends JpaRepository<Theme, Long> {
    public List<Theme> findByThemeName(String themeName);
    public List<Theme> findByDescriptionTheme(String descriptionTheme);
}
