package com.rifa.service;


import com.rifa.dto.RifaDTO;
import com.rifa.mapper.RifaMapper;
import com.rifa.model.Rifa;
import com.rifa.model.User;
import com.rifa.repositories.RifaRepository;
import com.rifa.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RifaService {

    private final RifaRepository rifaRepository;
    private final UserRepository userRepository;
    private final RifaMapper rifaMapper;

    @Autowired
    public RifaService(RifaRepository rifaRepository, UserRepository userRepository, RifaMapper rifaMapper) {
        this.rifaRepository = rifaRepository;
        this.userRepository = userRepository;
        this.rifaMapper = rifaMapper;
    }

    public List<RifaDTO> listarRifasDoUsuario(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return Collections.emptyList();
        }

        List<Rifa> rifasDoUsuario = rifaRepository.findByUsuario(user);
        return rifasDoUsuario.stream()
                .map(rifaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean comprarBilhetes(Long userId, Long rifaId, int quantidade) {
        User user = userRepository.findById(userId).orElse(null);
        Rifa rifa = rifaRepository.findById(rifaId)
                .orElseThrow(() -> new RuntimeException("Rifa não encontrada: " + rifaId));

        if (user == null || rifa == null) {
            return false;
        }

        if (quantidade <= 0 || quantidade > rifa.getQuantidadeDisponivel()) {
            return false;
        }

        rifa.setQuantidadeVendida(rifa.getQuantidadeVendida() + quantidade);
        rifaRepository.save(rifa);

        return true;
    }





}
