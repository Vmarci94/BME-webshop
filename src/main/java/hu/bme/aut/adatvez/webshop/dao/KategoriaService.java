package hu.bme.aut.adatvez.webshop.dao;

import hu.bme.aut.adatvez.webshop.model.Kategoria;
import hu.bme.aut.adatvez.webshop.model.Termek;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class KategoriaService {

    @PersistenceContext
    EntityManager em;

    private final TermekRepository termekRepository;

    KategoriaService(TermekRepository termekRepository) {
        this.termekRepository = termekRepository;
    }

    @Transactional
    public void createDragaJatekKategoria(double limit) {
        String kategoriaNev = "Drága játékok";
        Kategoria dragaKategoria;

        List<Kategoria> dragaJatekok = em
                        .createQuery("select k from Kategoria k where k.nev = :nev", Kategoria.class)
                        .setParameter("nev", kategoriaNev).getResultList();

        if(dragaJatekok.isEmpty()){
            dragaKategoria = new Kategoria(0, "Drága Játékok");
            em.persist(dragaJatekok); //ezzel mentünk el a db-be.
        }else {
            dragaKategoria = dragaJatekok.get(0);
        }

        List<Termek> termekek = termekRepository.findByNettoarGreaterThan(8000);
        Kategoria finalDragaKategoria = dragaKategoria;
        termekek.forEach(finalDragaKategoria::addTermek);

    }

}
