CREATE TABLE blogger (
    email TEXT,
    password TEXT NOT NULL,
    name TEXT NOT NULL,
    address TEXT,
    PRIMARY KEY(email)
);

CREATE TABLE reader (
    blogger_email TEXT,
    reader_email TEXT,  
    PRIMARY KEY(blogger_email, reader_email),
    FOREIGN KEY(blogger_email) REFERENCES blogger(email),
    FOREIGN KEY(reader_email) REFERENCES blogger(email)
);

CREATE TABLE blogger_interest (
    email TEXT,
    interest TEXT,
    PRIMARY KEY(email, interest),
    FOREIGN KEY(email) REFERENCES blogger(email)
);

CREATE TABLE blog (
    id SERIAL,
    title TEXT NOT NULL,
    body TEXT,
    is_private BOOLEAN,
    date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    email TEXT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(email) REFERENCES blogger(email)
);

CREATE TABLE comment (
    blog_id INTEGER,
    seq_num SERIAL,
    body TEXT NOT NULL,
    date_time TIMESTAMP,
    email TEXT NOT NULL,
    PRIMARY KEY(blog_id, seq_num),
    FOREIGN KEY(blog_id) REFERENCES blog(id),
    FOREIGN KEY(email) REFERENCES blogger(email)
);