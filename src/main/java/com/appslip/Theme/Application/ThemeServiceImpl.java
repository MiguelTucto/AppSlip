package com.appslip.Theme.Application;

import com.appslip.Theme.domain.model.IThemeService;
import com.appslip.Theme.domain.model.Theme;
import com.appslip.Theme.infrastructure.IThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly=true)
public class ThemeServiceImpl implements IThemeService {

    @Autowired
    private IThemeRepository themeRepository;

    @Override
    @Transactional
    public Theme save(Theme theme) throws Exception {
        return themeRepository.save(theme);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        themeRepository.deleteById(id);
    }

    @Override
    public List<Theme> getAll() throws Exception {
        return themeRepository.findAll();
    }

    @Override
    public Optional<Theme> getById(Long Id) throws Exception {
        return themeRepository.findById(Id);
    }

    @Override
    public List<Theme> findByThemeName(String themeName) throws Exception {
        return themeRepository.findByThemeName(themeName);
    }

    @Override
    public List<Theme> findByDescriptionTheme(String descriptionTheme) throws Exception {
        return themeRepository.findByDescriptionTheme(descriptionTheme);
    }
}
