    select b.comment
         , e.url
         , e.title
      from Bookmark b
inner join Entry e
        on e.id = b.entryId
     where b.username = /* username */'hoge'

