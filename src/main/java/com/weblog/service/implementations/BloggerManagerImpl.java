package com.weblog.service.implementations;

import java.util.List;

import com.weblog.database.Repository;
import com.weblog.entity.Blogger;
import com.weblog.entity.BloggerProfile;
import com.weblog.service.interfaces.BloggerManager;
import com.weblog.utility.PasswordEncryptor;

public class BloggerManagerImpl implements BloggerManager {
    private Repository repository;

    public BloggerManagerImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public BloggerProfile registerBlogger(Blogger blogger) {
        String encryptedPassword = PasswordEncryptor.encrypt(blogger.getPassword());
        blogger.setPassword(encryptedPassword);
        Blogger registeredBlogger = repository.registerBlogger(blogger);

        if (registeredBlogger != null) {
            return new BloggerProfile(
                registeredBlogger.getEmail(),
                registeredBlogger.getName(),
                registeredBlogger.getInterests()
            );
        }
        return null; 
    }

    @Override
    public BloggerProfile validateLogin(String email, String plainPassword) {
        Blogger blogger = repository.getBloggerByEmail(email);

        // If blogger exists and password matches, return BloggerProfile
        if (blogger != null && PasswordEncryptor.verify(plainPassword, blogger.getPassword())) {
            return new BloggerProfile(
                blogger.getEmail(),
                blogger.getName(), 
                blogger.getInterests()
            );
        }
        return null; 
    }

    @Override
    public List<Blogger> getAllBloggers() {
        return repository.getAllBloggers();
    }

    @Override
    public Blogger getBloggerByEmail(String email) {
        return repository.getBloggerByEmail(email);
    }
}