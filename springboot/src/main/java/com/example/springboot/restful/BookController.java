package com.example.springboot.restful;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


volatile    List<Book> list = new ArrayList<Book>();
Long createTime =System.currentTimeMillis();

    {
        Book book = new Book(1L, "Spring boot", "author_wzh");
        list.add(book);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> getBooks() {

        return list;
    }

    @RequestMapping(value = "/{bookid}",method=RequestMethod.GET)
    public ResponseEntity<Book> getBook(@PathVariable long bookid){
        for(Book k: list){
            if(k.getBookId()==bookid){
                return ResponseEntity.status(HttpStatus.OK).body(k);
            }
        }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @RequestMapping(value="/{bookid}" ,method = RequestMethod.PUT)
    public boolean addBook(@PathVariable long bookid,@RequestBody Book b){
      //  Book book=list.get((int) bookid);
        return  list.add(b);

    }

    @RequestMapping(value="/book" ,method = RequestMethod.PUT)
    public boolean addBook(@RequestParam long bookid,@RequestParam  String title,@RequestParam String author){
        Book b1=new Book(bookid,title,author);
        list.add(b1);
        return true;
    }

    @RequestMapping(value="/{bookid}" ,method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<Boolean> updateBook(@PathVariable long bookid, @RequestBody Book b){
        for (Book k : list) {
            if(k.getBookId()==bookid){
                k.setAuthor(b.getAuthor());
                k.setTitle(b.getTitle());
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }
    @RequestMapping(value="/book" ,method = RequestMethod.DELETE,produces = "application/json")
    public boolean deleteBook(@RequestBody Book b){
        return  list.remove(b);

    }
    @RequestMapping(value="/{bookid}" ,method = RequestMethod.DELETE)
    public boolean deleteBook(@RequestParam long bookid,@RequestParam String title,@RequestParam String author){
        return list.remove(new Book(bookid,title,author));

    }
}
