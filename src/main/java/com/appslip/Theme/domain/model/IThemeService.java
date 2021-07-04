package com.appslip.Theme.domain.model;

import com.appslip.util.CrudService;

import java.util.List;

public interface IThemeService extends CrudService<Theme> {
    public List<Theme> findByThemeName(String themeName) throws Exception;
    public List<Theme> findByDescriptionTheme(String descriptionTheme) throws Exception;
}
