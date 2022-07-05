package com.example.xportfolio.service.lang;

import com.example.xportfolio.command.LangCommand;
import com.example.xportfolio.dto.LangDto;
import com.example.xportfolio.model.Lang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LangService {

    Page<LangDto> getAllLang(Pageable pageable);
    Lang getById(String langId);

    Lang updateLang(String langId, LangCommand langCommand);

    Lang createOne(String writerId, LangCommand langCommand);
    void deleteLang(String langId);
}
