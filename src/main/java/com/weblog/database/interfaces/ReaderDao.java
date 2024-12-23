package com.weblog.database.interfaces;

import java.util.List;

public interface ReaderDao {
    public List<String> addReaders(String userEmail, List<String> readerEmailList);
    public Boolean isReaderOfBlogger(String reader, String blogger);
}
