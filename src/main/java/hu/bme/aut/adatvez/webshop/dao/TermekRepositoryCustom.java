package hu.bme.aut.adatvez.webshop.dao;

import hu.bme.aut.adatvez.webshop.model.Termek;

import java.util.List;

public interface TermekRepositoryCustom {

    List<Termek> findAllThatOrderedAtLeastTwice();

}
