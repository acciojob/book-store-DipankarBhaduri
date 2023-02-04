package com.driver;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    List < Book > bookList ;
    public BookRepository(){
        this.bookList = new ArrayList<>() ;
    }

    public Book save(Book book){
        bookList.add(book);
        return book;
    }

    public Book findBookById(int id){
        for ( int i = 0 ; i < bookList.size() ; i++ ){
            Book book = bookList.get(i) ;
            if ( book.getId() == id ){
                return book ;
            }
        }
        return null ;
    }


    public List<Book> findAll(){
        return bookList ;
    }

    public void deleteBookById(int id){
        for ( int i = 0 ; i < bookList.size() ; i++ ){
            Book book = bookList.get(i) ;
            if ( book.getId() == id ){
                bookList.remove(i) ;
                break ;
            }
        }
    }

    public void deleteAll(){
        bookList.clear() ;
    }

    public List<Book> findBooksByAuthor(String author){
        List < Book > aut = new ArrayList<>() ;
        for ( int i = 0 ; i < bookList.size() ; i++ ){
            if ( bookList.get(i).getAuthor().equals(author)){
                aut.add(bookList.get(i));
            }
        }
        return aut ;
    }

    public List<Book> findBooksByGenre(String genre){
        List < Book > aut = new ArrayList<>() ;
        for ( int i = 0 ; i < bookList.size() ; i++ ){
            if ( bookList.get(i).getGenre().equals(genre)){
                aut.add(bookList.get(i));
            }
        }
        return aut ;
    }

}
