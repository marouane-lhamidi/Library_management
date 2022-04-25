package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;

@Service
public class LivreService {
	
    @Autowired
    LivreRepo livreRepository;


    public List<Livre> getAll()
    {
        return livreRepository.findAllByOrderByTitre();
    }
    
    public Livre getLivre(long id)
    {
        return livreRepository.findById(id).get();
    }
    
    public void deleteLivre(long id)
    {
        livreRepository.deleteById(id);
    }
    
    public void modifieLivre(long id, Livre l)
    {
        Livre livre = livreRepository.findById(id).get();
        livre.setTitre(l.getTitre());
        livre.setAuteur(l.getAuteur());
        livre.setDateDerConsult(l.getDateDerConsult());
        livre.setDateSortie(l.getDateSortie());
        livre.setDisponible(l.isDisponible());
        livre.setNombrePages(l.getNombrePages());
        livreRepository.save(livre);
    }
    
    public Livre createLivre( Livre l)
    { 
        return livreRepository.save(l);
    }

}
