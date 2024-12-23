package com.weblog.service.interfaces;

import java.util.List;

public interface ReaderManager {
    public List<String> addReaders(String userEmail, List<String> readerEmailList);
}
