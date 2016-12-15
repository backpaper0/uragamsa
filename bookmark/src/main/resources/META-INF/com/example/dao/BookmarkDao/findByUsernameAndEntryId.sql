select /*%expand*/*
  from Bookmark
 where username = /* username */'hoge'
   and entryId = /* entryId */123
