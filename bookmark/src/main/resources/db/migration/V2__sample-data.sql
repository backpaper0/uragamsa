insert into Entry (url, title) values ('http://backpaper0.github.io/', '裏紙');
insert into Entry (url, title) values ('https://twitter.com/', 'Twitter');
insert into Entry (url, title) values ('https://github.com/', 'GitHub');

insert into Bookmark (comment, username, entryId) values ('blog', 'user', 1);

insert into Bookmark (comment, username, entryId) values (null, 'user', 2);
insert into Bookmark (comment, username, entryId) values (null, 'foo', 2);
insert into Bookmark (comment, username, entryId) values (null, 'bar', 2);

insert into Bookmark (comment, username, entryId) values (null, 'user', 3);
insert into Bookmark (comment, username, entryId) values (null, 'baz', 3);

