package com.example.xportfolio.service.about;

import com.example.xportfolio.command.AboutCommand;
import com.example.xportfolio.model.About;

import javax.print.DocFlavor;

public interface AboutService {
    About createAbout(String writerId, AboutCommand aboutCommand);

    About updateAbout(String aboutId, AboutCommand aboutCommand);

    About findById(String aboutId);
}
