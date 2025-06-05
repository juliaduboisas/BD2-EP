package com.danceSchool.api.controller;

import com.danceSchool.api.modalidade.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modality")
public class ModalidadeController {
    @Autowired
    private ModalidadeRepository modalidadeRepository;

    // ADD CRUD

}
