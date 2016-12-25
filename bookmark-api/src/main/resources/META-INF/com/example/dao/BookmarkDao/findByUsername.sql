    select b.comment
         , e.url
         , e.title
         , b2.count
      from Bookmark b
inner join Entry e
        on e.id = b.entryId
inner join (select entryId, count(*) as count
              from Bookmark
          group by entryId) b2
        on b2.entryId = b.entryId
     where b.username = /* username */'hoge'

