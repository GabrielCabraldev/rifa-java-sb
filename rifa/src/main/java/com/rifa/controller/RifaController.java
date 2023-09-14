package com.rifa.controller;

import com.rifa.dto.RifaDTO;
import com.rifa.repositories.RifaRepository;
import com.rifa.repositories.UserRepository;
import com.rifa.service.RifaService;
import com.rifa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rifas")
public class RifaController {

    private final RifaService rifaService;
    private final UserService userService;

    @Autowired
    public RifaController(RifaService rifaService, UserService userService) {
        this.rifaService = rifaService;
        this.userService = userService;
    }


    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<RifaDTO>> listarRifasDoUsuario(@PathVariable Long userId) {
        List<RifaDTO> rifasDoUsuario = rifaService.listarRifasDoUsuario(userId);
        return ResponseEntity.ok(rifasDoUsuario);
    }

    @PostMapping("/comprar-bilhetes")
    public ResponseEntity<String> comprarBilhetes(@RequestParam Long userId, @RequestParam Long rifaId, @RequestParam int quantidade) {
        boolean compraBemSucedida = rifaService.comprarBilhetes(userId, rifaId, quantidade);
        if (compraBemSucedida) {
            return ResponseEntity.ok("Compra de bilhetes bem-sucedida.");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível comprar os bilhetes.");
        }
    }
}
