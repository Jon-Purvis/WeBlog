package com.weblog.ui.blogger;

import java.util.List;

import com.weblog.entity.Blogger;
import com.weblog.service.Service;
import com.weblog.ui.blogger.views.ListAllBloggersView;

public class ListAllBloggersPresenter {
    private Service service;
    private ListAllBloggersView view;

    public ListAllBloggersPresenter(Service service) {
        this.service = service;
        this.view = new ListAllBloggersView();
    }

    public void begin() {
        List<Blogger> bloggers = service.getAllBloggers();

        if (bloggers.isEmpty()) {
            view.displayMessage("No Bloggers Available.");
            return;
        }

        view.displayHeader();
        for (Blogger blogger : bloggers) {
            view.displayBloggerDetails(blogger);
        }
        view.displayMessage("");
    }
}
