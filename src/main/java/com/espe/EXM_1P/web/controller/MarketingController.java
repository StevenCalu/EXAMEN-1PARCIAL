package com.espe.EXM_1P.web.controller;

import com.espe.EXM_1P.domain.service.EduSmartAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketingController {

    private final EduSmartAIService aiService;
    private final String tema;
    private final String audiencia;

    public MarketingController(EduSmartAIService aiService , @Value("tema") String tema, @Value("audiencia") String audiencia) {
        this.aiService = aiService;
        this.tema = tema;
        this.audiencia = audiencia;
    }

    @GetMapping("/api/edusmart/publicidad")
    public String Publicidad(@RequestParam String tema, @RequestParam String audiencia) {

        return aiService.generateGreeting(tema, audiencia);
    }
}