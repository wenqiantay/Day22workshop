create table rsvp (
    reservation_id int not null auto_increment,
    full_name varchar(80) not null,
    email  varchar(80) not null,
    phone varchar(80) not null, 
    confirmation_date date,
    comments varchar(250),

    primary key (reservation_id)
);