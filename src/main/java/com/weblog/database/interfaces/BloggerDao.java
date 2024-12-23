package com.weblog.database.interfaces;

import java.util.List;
import com.weblog.entity.Blogger;

public interface BloggerDao {
    Blogger registerBlogger(Blogger blogger);
    List<Blogger> getAllBloggers();
    Blogger getBloggerByEmail(String email);
}
