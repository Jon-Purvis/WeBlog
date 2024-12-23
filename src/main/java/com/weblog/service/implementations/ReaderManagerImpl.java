package com.weblog.service.implementations;

import java.util.List;

import com.weblog.database.Repository;
import com.weblog.service.interfaces.ReaderManager;

public class ReaderManagerImpl implements ReaderManager {
    private Repository repository;

    public ReaderManagerImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> addReaders(String userEmail, List<String> readerEmailList) {
        return repository.addReaders(userEmail, readerEmailList);
    }
}
