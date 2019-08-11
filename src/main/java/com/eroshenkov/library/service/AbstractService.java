package com.eroshenkov.library.service;

import com.eroshenkov.library.model.AbstractEntity;
import com.eroshenkov.library.model.Book;

public abstract class AbstractService {

    abstract String add(AbstractEntity entity);

    abstract Book findById(long id);

    abstract String deleteById(long id);
}
