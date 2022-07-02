package com.example.xportfolio.service.lang;

import com.example.xportfolio.command.LangCommand;
import com.example.xportfolio.model.Lang;

public interface LangService {
    Lang getById(String langId);

    Lang updateLang(String langId, LangCommand langCommand);

    Lang createOne(String writerId, LangCommand langCommand);
}
