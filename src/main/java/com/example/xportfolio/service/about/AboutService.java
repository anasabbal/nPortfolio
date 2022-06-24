package com.example.xportfolio.service.about;

import com.example.xportfolio.command.AboutCommand;
import com.example.xportfolio.model.About;

public interface AboutService {
    About createAbout(AboutCommand aboutCommand);
}
