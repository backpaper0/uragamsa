create table Entry (
    id bigint auto_increment
    ,url varchar(1000)
    ,title varchar(1000)
    ,primary key (id)
);

create table Bookmark (
    id bigint auto_increment
    ,comment varchar(200)
    ,username varchar(100)
    ,entryId bigint
    ,primary key (id)
    ,foreign key (entryId) references Entry (id)
);
