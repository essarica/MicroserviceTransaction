package com.universal_yazilim.bid.ysm.transaction_app.model.service;

import java.util.List;


public interface EntityService<E,I> {

    E findByID(I id);

    List<E> getAll();

    E save(E entity);

    void deleteByID(I id);
}

